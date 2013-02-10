package fr.graal.rpgtournament.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.graal.rpgtournament.RPGTournamentMngrConstants;
import fr.graal.rpgtournament.game.Game;
import fr.graal.rpgtournament.player.Player;
import fr.graal.rpgtournament.services.GameIOService;
import fr.graal.rpgtournament.services.PlayerIOService;


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
	
	private GameIOService gameIOService;
	private PlayerIOService playerIOService;

	protected File pathFile;
	protected File pathGameFile;

	// The list of all players
	protected ArrayList<Player> playerList;
	protected ArrayList<Player> pcList; // classement des PJ
	protected ArrayList<Player> gmList; // classement des MJ
	// The list of all games
	protected ArrayList<Game> gameList;

	public MainDataManager() {
		gameIOService = new GameIOService();
		playerIOService = new PlayerIOService();
		
		playerList = new ArrayList<Player>();
		pcList = new ArrayList<Player>();
		gmList = new ArrayList<Player>();
		gameList = new ArrayList<Game>();
		pathFile = new File(RPGTournamentMngrConstants.saveDirectoryPlayers);
		pathFile.mkdir();
		getAllPlayers();
		pathGameFile = new File(RPGTournamentMngrConstants.saveDirectoryGames);
		pathGameFile.mkdir();
		getAllGames();
	}


	public void saveAllPlayers() {
		for (Player player : playerList) {
		  savePlayer(player);
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


  	protected Player createPerson(String fileName) {
  		FileInputStream in = null;
  		try {
  			in = new FileInputStream(fileName);
  		}
  		catch (FileNotFoundException ex) {
  			ex.printStackTrace();
  		}
  		ObjectInputStream inputStream = null;
  		try {
  			inputStream = new ObjectInputStream(in);
  		}
  		catch (IOException ex1) {
  			ex1.printStackTrace();
  		}
  		Player player = playerIOService.readObject(inputStream);
  		try {
  			inputStream.close();
  			in.close();
  		} catch (IOException ex2) {
  			ex2.printStackTrace();
  		}
  		return player;
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
  		Game g = gameIOService.readObject(s);
  		try {
  			s.close();
  			in.close();
  		} catch (IOException ex2) {
  			ex2.printStackTrace();
  		}
  		return g;
  	}


  	public void addPerson(Player p) {
  		playerList.add(p);
  		savePlayer(p);
  	}

  	public void addGame(Game g) {
  		gameList.add(g);
  		saveGame(g);
  	}

  	public void savePlayer(Player player) {
  		FileOutputStream out = null;
  		try {
  			out = new FileOutputStream(RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator +
                                 player.getLastname() + player.getFirstName());
  		} catch (FileNotFoundException ex) {
  			ex.printStackTrace();
  		}

  		try {
  			ObjectOutputStream outputStream = new ObjectOutputStream(out);
  			playerIOService.writeObject(outputStream, player);
  			outputStream.flush();
  			outputStream.close();
  			out.close();
  		} catch (IOException ex1) {
  			ex1.printStackTrace();
  		}
  	}
  	
  	public void saveGame(Game game) {
  		FileOutputStream out = null;
  		try {
  			out = new FileOutputStream(RPGTournamentMngrConstants.saveDirectoryGames + File.separator +
                                 game.getName());
  		} catch (FileNotFoundException ex) {
  			ex.printStackTrace();
  		}

  		try {
  			ObjectOutputStream outputStream = new ObjectOutputStream(out);
  			gameIOService.writeObject(outputStream, game);
  			outputStream.flush();
  			outputStream.close();
  			out.close();
  		} catch (IOException ex1) {
  			ex1.printStackTrace();
  		}
  	}


  	public void removePerson(Player p) {
  		playerList.remove(p);
  		try {
  			if (!(new File(RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator + p.getLastname() + p.getFirstName())).delete()) {
  				System.out.println("Error while deleting file: " + RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator + p.getLastname() + p.getFirstName());
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

  	public ArrayList<Player> getPlayerList() {
  		return this.playerList;
  	}
  	
  	public ArrayList<Game> getGameList() {
  		return this.gameList;
  	}


  	public Player findPerson(String name, String firstName) {
  		for (Player player : playerList) {
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


  	public void updatePerson(Player previousPerson, Player newPerson) {
  		removePerson(previousPerson);
  		addPerson(newPerson);
  	}
  	
  	public void updateGame(Game previousGame, Game newGame) {
  		removeGame(previousGame);
  		addGame(newGame);
  	}


}