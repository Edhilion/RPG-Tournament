package fr.graal.rpgtournament.services;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Map;

import fr.graal.rpgtournament.notation.Notation;
import fr.graal.rpgtournament.player.Player;
import fr.graal.rpgtournament.player.Player.Gender;
import fr.graal.rpgtournament.tournament.RoundWishes;

public class PlayerIOService {

	@SuppressWarnings("unchecked")
	public Player readObject(ObjectInputStream ois) {
		String lastname, firstname, nickname, address, postCode, city, phoneNumber, email, clubName;
		Date inscriptionDate;
		int age, yearsOfRPG;
		boolean keepInTouch, isClubMember, alreadyPaid;
		Map<Integer, RoundWishes> gameWishes;
		Map<Integer, Notation> notations;
		Gender gender;
		
		Player player = null;
		try {
			lastname = (String) ois.readObject();
			firstname = (String) ois.readObject();
			nickname = (String) ois.readObject();
			age = ois.readInt();
			gender = (Gender) ois.readObject();
			address = (String) ois.readObject();
			postCode = (String) ois.readObject();
			city = (String) ois.readObject();
			phoneNumber = (String) ois.readObject();
			email = (String) ois.readObject();
			keepInTouch = ois.readBoolean();
			yearsOfRPG = ois.readInt();
			isClubMember = ois.readBoolean();
			clubName = (String) ois.readObject();
			inscriptionDate = (Date) ois.readObject();
			alreadyPaid = ois.readBoolean();
			gameWishes = (Map<Integer, RoundWishes>) ois.readObject();
			notations = (Map<Integer, Notation>) ois.readObject();
			player = new Player(lastname, firstname, nickname, age, gender, address, postCode, city, phoneNumber, email, keepInTouch, 
					yearsOfRPG, isClubMember, clubName, inscriptionDate, alreadyPaid, gameWishes, notations);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return player;
	}

	public void writeObject(ObjectOutputStream oos, Player player) {
		try {
			oos.writeObject(player.getLastname());
			oos.writeObject(player.getFirstname());
			oos.writeObject(player.getNickname());
			oos.writeInt(player.getAge());
			oos.writeObject(player.getGender());
			oos.writeObject(player.getAddress());
			oos.writeObject(player.getPostCode());
			oos.writeObject(player.getCity());
			oos.writeObject(player.getPhoneNumber());
			oos.writeObject(player.getEmail());
			oos.writeBoolean(player.isKeptInTouch());
			oos.writeInt(player.getYearsOfRPG());
			oos.writeBoolean(player.isClubMember());
			oos.writeObject(player.getClubName());
			oos.writeObject(player.getInscriptionDate());
			oos.writeBoolean(player.hasAlreadyPaid());
			oos.writeObject(player.getGameWishes());
			oos.writeObject(player.getNotations());
		} catch (IOException exp) {
			exp.printStackTrace();
		}

	}
}
