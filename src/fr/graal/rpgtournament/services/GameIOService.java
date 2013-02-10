package fr.graal.rpgtournament.services;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fr.graal.rpgtournament.game.Game;

public class GameIOService {


	public Game readObject(ObjectInputStream ois) {
		String name;
		boolean dayOne, dayTwo, dayThree;
		Integer index;
		Game game = null;
		try {
			name = (String) ois.readObject();
			dayOne = ois.readBoolean();
			dayTwo = ois.readBoolean();
			dayThree = ois.readBoolean();
			index = ois.readInt();
			game = new Game(name, dayOne, dayTwo, dayThree, index);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return game;
	}

	public void writeObject(ObjectOutputStream oos, Game game) {
		try {
			oos.writeObject(game.getName());
			oos.writeBoolean(game.isDayOne());
			oos.writeBoolean(game.isDayTwo());
			oos.writeBoolean(game.isDayThree());
			oos.writeInt(game.getIndex());
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}
}
