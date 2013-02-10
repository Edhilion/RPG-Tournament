package fr.graal.rpgtournament;

import java.util.ArrayList;
import java.io.*;


/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003-2012</p>
 * <p>Société : GRAAL</p>
 * @author VAN DE BOR Eric
 * @author VICARD Sébastien
 * @version 1.1
 */

public class MainDataManager {

	protected File pathFile;
	protected File pathGameFile;

	// The list of all players
	protected ArrayList<Person> playerList;
	protected ArrayList<Person> pcList; // classement des PJ
	protected ArrayList<Person> gmList; // classement des MJ
	// The list of all games
	protected ArrayList<Game> gameList;

	public MainDataManager() {
		playerList = new ArrayList<Person>();
		pcList = new ArrayList<Person>();
		gmList = new ArrayList<Person>();
		gameList = new ArrayList<Game>();
		pathFile = new File(RPGTournamentMngrConstants.saveDirectoryPlayers);
		pathFile.mkdir();
		getAllPlayers();
		pathGameFile = new File(RPGTournamentMngrConstants.saveDirectoryGames);
		pathGameFile.mkdir();
		getAllGames();
	}


	public void saveAllPlayers() {
		for (Person player : playerList) {
		  savePerson(player);
		}
	}
  
	public void saveAllGames() {
		for (Game game : gameList) {
			saveGame(game);
		}
	}

 
	protected void getAllPlayers() {
		String[] listFile = pathFile.list();
		for (int i=0; i<listFile.length; i++) {
			playerList.add(createPerson(RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator + listFile[i]));
		}
	}
  
  	protected void getAllGames() {
	    String[] listFile = pathGameFile.list();
	    for (int i=0; i<listFile.length; i++) {
	    	gameList.add(createGame(RPGTournamentMngrConstants.saveDirectoryGames + File.separator + listFile[i]));
	    }
  	}


  	protected Person createPerson(String fileName) {
  		FileInputStream in = null;
  		try {
  			in = new FileInputStream(fileName);
  		}
  		catch (FileNotFoundException ex) {
  			ex.printStackTrace();
  		}
  		ObjectInputStream s = null;
  		try {
  			s = new ObjectInputStream(in);
  		}
  		catch (IOException ex1) {
  			ex1.printStackTrace();
  		}
  		Person p = new Person(s);
  		try {
  			s.close();
  			in.close();
  		} catch (IOException ex2) {
  			ex2.printStackTrace();
  		}
  		return p;
  	}
  	
  	protected Game createGame(String fileName) {
  		FileInputStream in = null;
  		try {
  			in = new FileInputStream(fileName);
  		}
  		catch (FileNotFoundException ex) {
  			ex.printStackTrace();
  		}
  		ObjectInputStream s = null;
  		try {
  			s = new ObjectInputStream(in);
  		}
  		catch (IOException ex1) {
  			ex1.printStackTrace();
  		}
  		Game g = new Game(s);
  		try {
  			s.close();
  			in.close();
  		} catch (IOException ex2) {
  			ex2.printStackTrace();
  		}
  		return g;
  	}


  	public void addPerson(Person p) {
  		playerList.add(p);
  		savePerson(p);
  	}

  	public void addGame(Game g) {
  		gameList.add(g);
  		saveGame(g);
  	}

  	public void savePerson(Person p) {
  		FileOutputStream out = null;
  		try {
  			out = new FileOutputStream(RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator +
                                 p.getName() + p.getFirstName());
  		} catch (FileNotFoundException ex) {
  			ex.printStackTrace();
  		}

  		try {
  			ObjectOutputStream s = new ObjectOutputStream(out);
  			p.writeObject(s);
  			s.flush();
  			s.close();
  			out.close();
  		} catch (IOException ex1) {
  			ex1.printStackTrace();
  		}
  	}
  	
  	public void saveGame(Game g) {
  		FileOutputStream out = null;
  		try {
  			out = new FileOutputStream(RPGTournamentMngrConstants.saveDirectoryGames + File.separator +
                                 g.getName());
  		} catch (FileNotFoundException ex) {
  			ex.printStackTrace();
  		}

  		try {
  			ObjectOutputStream s = new ObjectOutputStream(out);
  			g.writeObject(s);
  			s.flush();
  			s.close();
  			out.close();
  		} catch (IOException ex1) {
  			ex1.printStackTrace();
  		}
  	}


  	public void removePerson(Person p) {
  		playerList.remove(p);
  		try {
  			if (!(new File(RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator + p.getName() + p.getFirstName())).delete()) {
  				System.out.println("Error while deleting file: " + RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator + p.getName() + p.getFirstName());
  			}
  		} catch (Exception exp) {
  			exp.printStackTrace();
  		}
  	}

  	public void removeGame(Game g) {
  		gameList.remove(g);
  		try {
  			if (!(new File(RPGTournamentMngrConstants.saveDirectoryGames + File.separator + g.getName())).delete()) {
  				System.out.println("Error while deleting file: " + RPGTournamentMngrConstants.saveDirectoryGames + File.separator + g.getName());
  			}
  		} catch (Exception exp) {
  			exp.printStackTrace();
  		}
  	}

  	public ArrayList<Person> getPlayerList() {
  		return this.playerList;
  	}
  	
  	public ArrayList<Game> getGameList() {
  		return this.gameList;
  	}


  	public Person findPerson(String name, String firstName) {
  		for (Person player : playerList) {
  			if (player.equals(name, firstName)) {
  				return player;
  			}
  		}
  		return null;
  	}
  	
  	public Game findGame(String name) {
  		for (Game game : gameList) {
  			if (game.equals(name)) {
  				return game;
  			}
  		}
  		return null;
  	}


  	public void updatePerson(Person previousPerson, Person newPerson) {
  		removePerson(previousPerson);
  		addPerson(newPerson);
  	}
  	
  	public void updateGame(Game previousGame, Game newGame) {
  		removeGame(previousGame);
  		addGame(newGame);
  	}


}