package fr.graal.rpgtournament.player;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Objects;

import fr.graal.rpgtournament.game.Game;
import fr.graal.rpgtournament.notation.Notation;
import fr.graal.rpgtournament.tournament.RoundWishes;

/**
 * @author Eric VAN DE BOR
 * @author Sébastien VICARD
 * @version 1.1
 */

public class Player implements Serializable, Comparable<Player> {

	public static final DateFormat df = DateFormat
			.getDateInstance(DateFormat.SHORT);

	public enum Gender {
		FEMALE, MALE
	};
	
	public static final int WORST_GAME_CHOICE = 100;

	private static final long serialVersionUID = -6600900997440902409L;
	private String lastname;
	private String firstname;
	private String nickname;
	private Gender gender;
	private int age;
	private String address;
	private String postCode;
	private String city;
	private String phoneNumber;
	private String email;
	private boolean keptInTouch;

	// Informations sur le parcours rôliste du joueur
	private int yearsOfRPG;
	private boolean isClubMember;
	private String clubName;

	private Date inscriptionDate;
	private boolean alreadyPaid;

	private Map<Integer, RoundWishes> gameWishes;	

	private Map<Integer, Notation> notations;
	
	private Map<Integer, Integer> playedGamesPriorities;
	
	public Player(String lastname, String firstname) {
		checkArgument(StringUtils.isNotBlank(lastname),
				"Lastname (as firstname) is mandatory");
		checkArgument(StringUtils.isNotBlank(firstname),
				"Firstname (as lastname) is mandatory");
		this.lastname = lastname;
		this.firstname = firstname;
		this.gameWishes = new HashMap<Integer, RoundWishes>();
		this.notations = new HashMap<Integer, Notation>();
		this.playedGamesPriorities = new HashMap<Integer, Integer>();
	}
	
	public Player (String lastname, String firstname, String nickname) {
		this(lastname, firstname);
		this.nickname = nickname;
	}

	public Player(String lastname, String firstname, String nickname, int age, Gender gender,
			String adress, String postCode, String city, String phoneNumber,
			String emailAdress, boolean keptInTouch, int yearsOfRPG,
			boolean isClubMember, String clubName, Date inscriptionDate,
			boolean alreadyPaid, Map<Integer, RoundWishes> roundList) {
		this(lastname, firstname, nickname);
		this.age = age;
		this.address = adress;
		this.postCode = postCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.email = emailAdress;
		this.keptInTouch = keptInTouch;
		this.yearsOfRPG = yearsOfRPG;
		this.isClubMember = isClubMember;
		this.clubName = clubName;
		this.inscriptionDate = new Date();
		this.alreadyPaid = alreadyPaid;
		this.gameWishes = roundList;

	}

	public Player(String lastname, String firstname, String nickname, int age, Gender gender,
			String adress, String postCode, String city, String phoneNumber,
			String emailAdress, boolean keptInTouch, int yearsOfRPG,
			boolean isClubMember, String clubName, Date inscriptionDate,
			boolean alreadyPaid, Map<Integer, RoundWishes> roundList,
			Map<Integer, Notation> notations) {
		this(lastname, firstname, nickname, age, gender, adress, postCode, city,
				phoneNumber, emailAdress, keptInTouch, yearsOfRPG,
				isClubMember, clubName, inscriptionDate, alreadyPaid, roundList);
		this.notations = notations;
	}

	public Notation getPlayerFinalNoteAsPC() {
		Notation maxNotation = Notation.DEFAULT_PLAYER_NOTATION;
		for(Notation notation : notations.values()) {
			if (notation.getNote() > maxNotation.getNote()
					&& notation.getType().equals(Notation.PLAYER)) {
				maxNotation = notation;
			}
		}		
		return maxNotation;
	}

	public Notation getPlayerFinalNoteAsGM() {
		Notation maxNotation = Notation.DEFAULT_GM_NOTATION;
		for(Notation notation : notations.values()) {
			if (notation.getNote() > maxNotation.getNote()
					&& notation.getType().equals(Notation.GAME_MASTER)) {
				maxNotation = notation;
			}
		}		
		return maxNotation;
	}
	
	public int getRoundNote(int roundNumber) {
		Notation roundNotation = notations.get(roundNumber);
		int note = 0;
		if (roundNotation != null) {
			note = roundNotation.getNote();
		}
		return note;
	}
	
	public String getRoundNoteAsString(int roundNumber) {
		Notation roundNotation = notations.get(roundNumber);
		String note = "-";
		if (roundNotation != null) {
			note = Integer.toString(roundNotation.getNote());
		}
		return note;
	}
	
	public String getRoundGameName(int roundNumber) {
		Notation roundNotation = notations.get(roundNumber);
		String game = "-";
		if (roundNotation != null) {
			game = roundNotation.getGame().getName();
		}
		return game;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Player other = (Player) obj;
		return this.lastname.equalsIgnoreCase(other.lastname.toLowerCase())
				&& this.firstname.equalsIgnoreCase(other.firstname.toLowerCase());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.lastname.toLowerCase(), this.firstname.toLowerCase());
	}

	public int compareTo(Player player) {
		if (this.getSumOfPriorities() == player.getSumOfPriorities()) {
			return inscriptionDate.compareTo(player.getInscriptionDate());
		} else if (this.getSumOfPriorities() > player.getSumOfPriorities()) {
			return -1;
		} else {
			return 1;
		}
	}
	
	private int getSumOfPriorities() {
		int sum = 0;
		for (Integer priority : playedGamesPriorities.values()) {
			sum += priority != null ? priority.intValue() : WORST_GAME_CHOICE;
		}
		return sum;
	}

	public boolean isPlayingInRound(int roundNumber) {
		return gameWishes.containsKey(roundNumber);
	}

	public String getFullName() {
		return this.getLastname() + " " + this.getFirstname();
	}
	
	public void setGameAsMasterForRound(int roundNumber, Game game) {
		notations.put(roundNumber, Notation.newGameMasterNotation(Notation.DEFAULT_NOTE, game));
	}
	
	public void playNoGame(int roundNumber) {
		playedGamesPriorities.put(roundNumber, WORST_GAME_CHOICE);
	}
	
	public void setPlayedGame(int roundNumber, Game game) {
		int gamePriority = gameWishes.get(roundNumber).findGameWishIndex(game);
		playedGamesPriorities.put(roundNumber, gamePriority);

		if (notations.containsKey(roundNumber)) {
			notations.get(roundNumber).setGame(game);
		} else {
			notations.put(roundNumber, Notation.newPlayerNotation(Notation.DEFAULT_NOTE, game));
		}
	}
	
	public void setMasteredGame(int roundNumber, Game game) {
		playedGamesPriorities.put(roundNumber, WORST_GAME_CHOICE);

		if (notations.containsKey(roundNumber)) {
			notations.get(roundNumber).setGame(game);
		} else {
			notations.put(roundNumber, Notation.newGameMasterNotation(Notation.DEFAULT_NOTE, game));
		}
	}
	
	

	// GETTERS - SETTERS
	public String getLastname() {
		return this.lastname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public String getNickname() {
		return this.nickname;
	}

	public Gender getGender() {
		return this.gender;
	}

	public int getAge() {
		return this.age;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public String getCity() {
		return this.city;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public boolean isKeptInTouch() {
		return this.keptInTouch;
	}

	public int getYearsOfRPG() {
		return this.yearsOfRPG;
	}

	public boolean isClubMember() {
		return this.isClubMember;
	}

	public String getClubName() {
		return this.clubName;
	}

	public Date getInscriptionDate() {
		return this.inscriptionDate;
	}

	public boolean hasAlreadyPaid() {
		return this.alreadyPaid;
	}

	public Map<Integer, RoundWishes> getGameWishes() {
		return this.gameWishes;
	}

	public Map<Integer, Notation> getNotations() {
		return notations;
	}
	
	public boolean isMale() {
		return gender != null ? gender.equals(Gender.MALE) : true;
	}
	

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setKeptInTouch(boolean keptInTouch) {
		this.keptInTouch = keptInTouch;
	}

	public void setYearsOfRPG(int yearsOfRPG) {
		this.yearsOfRPG = yearsOfRPG;
	}

	public void setClubMember(boolean isClubMember) {
		this.isClubMember = isClubMember;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public void setAlreadyPaid(boolean alreadyPaid) {
		this.alreadyPaid = alreadyPaid;
	}

	public void setGameWishes(Map<Integer, RoundWishes> gameWishes) {
		this.gameWishes = gameWishes;
	}

	public void setNotations(Map<Integer, Notation> notations) {
		this.notations = notations;
	}

	public Map<Integer, Integer> getPlayedGamesPriorities() {
		return playedGamesPriorities;
	}

	public void setPlayedGamesPriorities(Map<Integer, Integer> playedGamesPriorities) {
		this.playedGamesPriorities = playedGamesPriorities;
	}

}