package fr.graal.rpgtournament.player;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Map;

import fr.graal.rpgtournament.notation.Notation;
import fr.graal.rpgtournament.notation.PlayerNotation;
import fr.graal.rpgtournament.tournament.Round;

/**
 * @author Eric VAN DE BOR
 * @author Sébastien VICARD
 * @version 1.1
 */

public class Player implements Serializable, Comparable<Player> {

	private static final DateFormat df = DateFormat
			.getDateInstance(DateFormat.SHORT);
	
	private static final long serialVersionUID = -6600900997440902409L;
	private String lastname;
	private String firstname;
	private int age;
	private boolean sex;
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

	private String inscriptionDate;
	private boolean alreadyPaid;

	private Map<Integer, Round> roundList;

	private PlayerNotation notation;

	public Player(String lastname, String firstname) {
		this.lastname = checkNotNull(lastname);
		this.firstname = checkNotNull(firstname);
	}

	public Player(String lastname, String firstname, int age, boolean sex,
			String adress, String postCode, String city, String phoneNumber,
			String emailAdress, boolean keptInTouch, int yearsOfRPG,
			boolean isClubMember, String clubName, String inscriptionDate,
			boolean alreadyPaid, Map<Integer, Round> roundList) {
		this(lastname, firstname);
		this.age = age;
		this.sex = sex;
		this.address = adress;
		this.postCode = postCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.email = emailAdress;
		this.keptInTouch = keptInTouch;
		this.yearsOfRPG = yearsOfRPG;
		this.isClubMember = isClubMember;
		this.clubName = clubName;
		this.inscriptionDate = inscriptionDate;
		this.alreadyPaid = alreadyPaid;
		this.roundList = roundList;

	}

	public Player(String lastname, String firstname, int age, boolean sex,
			String adress, String postCode, String city, String phoneNumber,
			String emailAdress, boolean keptInTouch, int yearsOfRPG,
			boolean isClubMember, String clubName, String inscriptionDate,
			boolean alreadyPaid, Map<Integer, Round> roundList,
			PlayerNotation notation) {
		this(lastname, firstname, age, sex, adress, postCode, city, phoneNumber,
				emailAdress, keptInTouch, yearsOfRPG, isClubMember, clubName,
				inscriptionDate, alreadyPaid, roundList);
		this.notation = notation;
	}

	public Notation getPlayerNote() {
		Notation maxNote = new Notation();
		for (int i = 1; i <= notation.size(); i++) {
			Notation rdNote = notation.getNotation(i);
			if (rdNote.getNote() > maxNote.getNote())
				maxNote = rdNote;
		}
		return maxNote;
	}

	public Notation getPlayerNoteAsPC() {
		Notation maxPCNote = new Notation();
		for (int i = 1; i <= notation.size(); i++) {
			Notation rdNote = notation.getNotation(i);
			if (rdNote.getNote() > maxPCNote.getNote()
					&& rdNote.getType().equals(Notation.PLAYER))
				maxPCNote = rdNote;
		}
		return maxPCNote;
	}

	public Notation getPlayerNoteAsGM() {
		Notation maxGMNote = new Notation();
		for (int i = 1; i <= notation.size(); i++) {
			Notation rdNote = notation.getNotation(i);
			if (rdNote.getNote() > maxGMNote.getNote()
					&& rdNote.getType().equals(Notation.GAME_MASTER))
				maxGMNote = rdNote;
		}
		return maxGMNote;
	}

	public boolean equals(String name, String firstName) {
		if (this.lastname.equalsIgnoreCase(name)
				&& this.firstname.equalsIgnoreCase(firstName)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean equals(Player p) {
		if (this.lastname.equalsIgnoreCase(p.getLastname())
				&& this.firstname.equalsIgnoreCase(p.getFirstName())) {
			return true;
		}
		return false;
	}

	public int compareTo(Player o) {
		try {
			if ((this.inscriptionDate.equals(""))
					&& (((Player) o).getInscriptionDate()).equals("")) {
				return 0;
			} else if (this.inscriptionDate.equals("")) {
				return 1;
			} else if (((Player) o).getInscriptionDate().equals("")) {
				return -1;
			} else {
				return (df.parse(this.inscriptionDate).compareTo(df
						.parse(((Player) o).getInscriptionDate())));
			}
		} catch (ParseException ex) {
			System.out.println("EXCEPTION");
			ex.printStackTrace();
			return 0;
		}
	}

	public boolean isRoundExist(int roundNbr) {
		if (roundList.get(new Integer(roundNbr)) == null) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		return this.getLastname() + " " + this.getFirstName();
	}
	
	// GETTERS - SETTERS
	public String getLastname() {
		return this.lastname;
	}

	public String getFirstName() {
		return this.firstname;
	}

	public int getAge() {
		return this.age;
	}

	public boolean getSex() {
		return this.sex;
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

	public String getInscriptionDate() {
		return this.inscriptionDate;
	}

	public boolean hasAlreadyPaid() {
		return this.alreadyPaid;
	}

	public Map<Integer, Round> getRoundList() {
		return this.roundList;
	}

	public PlayerNotation getNotation() {
		return notation;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
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

	public void setInscriptionDate(String inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public void setAlreadyPaid(boolean alreadyPaid) {
		this.alreadyPaid = alreadyPaid;
	}

	public void setRoundList(Map<Integer, Round> roundList) {
		this.roundList = roundList;
	}

	public void setNotation(PlayerNotation notation) {
		this.notation = notation;
	}

}