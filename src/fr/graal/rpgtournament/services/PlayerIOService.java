package fr.graal.rpgtournament.services;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import fr.graal.rpgtournament.notation.PlayerNotation;
import fr.graal.rpgtournament.player.Player;
import fr.graal.rpgtournament.tournament.Round;

public class PlayerIOService {

	@SuppressWarnings("unchecked")
	public Player readObject(ObjectInputStream ois) {
		String lastname, firstname, address, postCode, city, phoneNumber, email, clubName, inscriptionDate;
		int age, yearsOfRPG;
		boolean sex, keepInTouch, isClubMember, alreadyPaid;
		Map<Integer, Round> roundList;
		PlayerNotation notation;
		
		Player player = null;
		try {
			lastname = (String) ois.readObject();
			firstname = (String) ois.readObject();
			age = ois.readInt();
			sex = ois.readBoolean();
			address = (String) ois.readObject();
			postCode = (String) ois.readObject();
			city = (String) ois.readObject();
			phoneNumber = (String) ois.readObject();
			email = (String) ois.readObject();
			keepInTouch = ois.readBoolean();
			yearsOfRPG = ois.readInt();
			isClubMember = ois.readBoolean();
			clubName = (String) ois.readObject();
			inscriptionDate = (String) ois.readObject();
			alreadyPaid = ois.readBoolean();
			roundList = (Map<Integer, Round>) ois.readObject();
			notation = (PlayerNotation) ois.readObject();
			player = new Player(lastname, firstname, age, sex, address, postCode, city, phoneNumber, email, keepInTouch, 
					yearsOfRPG, isClubMember, clubName, inscriptionDate, alreadyPaid, roundList, notation);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return player;
	}

	public void writeObject(ObjectOutputStream oos, Player player) {
		try {
			oos.writeObject(player.getLastname());
			oos.writeObject(player.getFirstName());
			oos.writeInt(player.getAge());
			oos.writeBoolean(player.getSex());
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
			oos.writeObject(player.getRoundList());
			oos.writeObject(player.getNotation());
		} catch (IOException exp) {
			exp.printStackTrace();
		}

	}
}
