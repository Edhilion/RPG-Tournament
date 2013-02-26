package fr.graal.rpgtournament.tournament;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.graal.rpgtournament.RPGTournamentMngrConstants;
import fr.graal.rpgtournament.game.Game;
import fr.graal.rpgtournament.game.Table;
import fr.graal.rpgtournament.notation.Notation;
import fr.graal.rpgtournament.player.Player;

/**
 * @author VAN DE BOR Eric and VAN DE BOR Thomas
 * @author VICARD Sébastien
 * @version 1.2
 */

public class TournamentSchedule implements Serializable {

	private static final long serialVersionUID = -7447165790760414910L;

	protected Map<Integer, Round> rounds;
	protected Map<Integer, Set<Player>> playersWithoutTable;
	private Map<Player, Integer> playerChoices; 

	public TournamentSchedule() {
		System.out.println("création activée");
		rounds = new HashMap<Integer, Round>();
		playersWithoutTable = new HashMap<Integer, Set<Player>>();
	}

	public TournamentSchedule(ObjectInputStream ois) {
		this.readObject(ois);
	}

	public boolean isEmpty() {
		return rounds.isEmpty();
	}

	public Set<Player> getPlayerListWithoutTable(int roundNbr) {
		return playersWithoutTable.get(roundNbr);
	}

	public void addSchedule(Integer index, Round schedule) {
		rounds.put(index, schedule);
	}

	public Map<Integer, Round> getRounds() {
		return rounds;
	}

	public Round getSchedule(int roundNbr) {
		return rounds.get(roundNbr);
	}

	public void debugTableList(ArrayList<Table> v, int det) {
		Table t;
		Set<Player> players;
		if (!v.isEmpty()) {
			for (int i = 0; i < v.size(); i++) {
				t = v.get(i);
				System.out.println("Table: " + i + " - Master: "
						+ t.getMaster().getLastname());
				if (det == 1) {
					System.out.println("Game: " + t.getGame());
					System.out.println("Player List: ");
					players = t.getPlayers();
					debugPlayerList(players);
				}
			}
		} else {
			System.out.println("Liste table vide");
		}
	}

	public String tableListToString(int roundNbr) {
		Round round = rounds.get(roundNbr);
		String returnedString = "";
		returnedString = round.getTablesAsString();
		returnedString = returnedString
				+ "\n \n"
				+ RPGTournamentMngrConstants.Texts
						.getString("PlayerListWithoutTable") + " :\n";
		returnedString = returnedString + round.playersWithoutTableAsString();
		return returnedString;
	}

	public void debugPlayerList(Set<Player> players) {
		if (!players.isEmpty()) {
			for (Player player : players) {
				System.out.println("--" + player.getFullName());
			}
		} else {
			System.out.println("Liste vide");
		}
	}

	public void computeTournamentSchedule(int nbOfRound, List<Player> arrayList) {
		for (int i = 0; i < nbOfRound; i++) {
			try {
				computeOneRound(i, arrayList);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void computeOneRound(int roundNumber, List<Player> players)
			throws Exception {
		System.out.println("***** Début Création Ronde " + roundNumber
				+ "*******************************");

		rounds.put(roundNumber, new Round());
		
		

		List<Player> masters = new ArrayList<Player>();
		List<Player> femalePlayers = new ArrayList<Player>();
		List<Player> malePlayers = new ArrayList<Player>();
		
		for (Player player : players) {
			if (player.isPlayingInRound(roundNumber)) {
				if (player.getGameWishes().get(roundNumber).isMaster()) {
					masters.add(player);
				} else {
					if (player.isMale()) {
						malePlayers.add(player);
					} else {
						femalePlayers.add(player);
					}
				}
			} else {
				System.out.println("Le joueur " + player.getFullName() + " n'a pas de ronde " + roundNumber
						+ " définie");
			}
		}

		// Création de la liste des tables
		for (Player master : masters) {
			Game firstGameChoice = master.getGameWishes().get(roundNumber)
					.getFirstGame(true);
			if (firstGameChoice != null) {
				rounds.get(roundNumber).addTable(
						new Table(master, firstGameChoice));
				master.setGameAsMasterForRound(roundNumber, firstGameChoice);
			} else {
				System.out.println(master.getFullName()
						+ " défini comme Maitre pour la ronde " + roundNumber
						+ " n'a pas de jeu paramétré");
			}
			master.setPlayedGame(roundNumber, Player.WORST_GAME_CHOICE);
		}
		// Triage des listes par ordre d'inscription
		Collections.sort(femalePlayers);
		Collections.sort(malePlayers);
		// Fusion de la liste des filles avec les garçons
		femalePlayers.addAll(malePlayers);
		List<Table> tableListPossible = new ArrayList<Table>();

		Player player;
		boolean playerPlaced = false;
		int nbPlayer = femalePlayers.size();
		Set<Player> tempPlayerListWithoutTable = new HashSet<Player>();

		for (int i = 0; i < nbPlayer; i++) {
			player = femalePlayers.get(i);
			System.out.println("---------------- Traitement de "
					+ player.getFullName());
			playerPlaced = false;
			int j = 1;
			// pour chaque jeu
			int nbrOfGame = player.getGameWishes()
					.get(new Integer(roundNumber)).getPGamesList().size();
			if (nbrOfGame == 0) {
				System.out
						.println(player.getLastname()
								+ " n'a pas de jeu defini pour la ronde "
								+ roundNumber);
			}
			while (j <= nbrOfGame && (!playerPlaced)) {
				tableListPossible.clear();
				Round round = rounds.get(roundNumber);
				// réinintialisation de la liste des tables (en retirant les
				// tables pleines)
				for (Table table : round.getTables()) {
					if (!table.isFivePlayer()) {
						tableListPossible.add(table);
					}
				}
				// test si le joueur a des tables disponibles par rapport au jeu
				// selectionné.
				List<Table> tempVector = getAvailableTableOnGame(
						tableListPossible,
						player.getGameWishes().get(new Integer(roundNumber))
								.getGame(new Integer(j), false));
				tableListPossible = tempVector;
				// test si le joueur a déjà joué avec le même maître du jeu
				tempVector = getAvailableTableOnPreviousMaster(
						tableListPossible, player, roundNumber);
				if (!tempVector.isEmpty()) {
					tableListPossible = tempVector;
					// test si le joueur est dans la bonne tranche d'age
					tempVector = getAvailableTableAge(tableListPossible,
							player.getAge());
					if (!tempVector.isEmpty()) {
						tableListPossible = tempVector;
						// test si il n y a pas d'autre fille sur la table
						if (!player.isMale()) {
							tableListPossible = getAvailableFemaleTable(tableListPossible);
							// test s'il n'y a pas d'autre joueur du même club
							// que lui
							if (player.isClubMember()) {
								tableListPossible = getAvailableTableClub(
										tableListPossible, player.getClubName());
							}
						}
					}
				}

				// test s'il le joueur peut être placé dans une table
				if (!tableListPossible.isEmpty()) {
					if (tableListPossible.size() > 1) {
						tableListPossible.get(
								tableMoreFilled(tableListPossible)).addPlayer(
								player);
					} else if (tableListPossible.size() == 1) {
						tableListPossible.get(0).addPlayer(player);
					}
					playerPlaced = true;
					player.setPlayedGame(roundNumber, player.getGameWishes().get(roundNumber).findGameWishIndex(tableListPossible.get(0).getGame()));
					player.getNotations().get(roundNumber)
							.setGame(tableListPossible.get(0).getGame());
					player.getNotations().get(roundNumber)
							.setType(Notation.PLAYER);
					System.out.println(player.getFullName() + " placé");
				} else {
					// si le joueur n'est pas placé
					if (j == nbrOfGame) {
						System.out.println(player.getFullName() + " non placé");
						tempPlayerListWithoutTable.add(player);
					}
				}
				j++;
			}
		}
		this.playersWithoutTable.put(roundNumber,
				tempPlayerListWithoutTable);
		Round round = rounds.get(roundNumber);
		round.setPlayersWithoutTable(tempPlayerListWithoutTable);
		System.out.println("***** Fin Creation Ronde " + roundNumber
				+ "*******************************");
	}

	protected List<Table> getAvailableTableOnPreviousMaster(
			List<Table> tableList, Player player, int roundNbr) {
		if (roundNbr > 1) {
			List<Table> resultListOfTable = new ArrayList<Table>();
			Player master;
			for (int j = roundNbr - 1; j > 0; j--) {
				master = findMasterOfPlayerInRound(player, j);
				if (master != null) {
					int nbTable = tableList.size();
					for (int i = 0; i < nbTable; i++) {
						if (!((Table) tableList.get(i)).getMaster().equals(
								master)) {
							resultListOfTable.add(tableList.get(i));
						}
					}
				}
			}
			return resultListOfTable;
		} else {
			return tableList;
		}
	}

	private Player findMasterOfPlayerInRound(Player player, int roundNbr) {
		Round round = rounds.get(roundNbr);
		for (Table table : round.getTables()) {
			if (table.containsPlayer(player)) {
				return table.getMaster();
			}
		}
		return null;
	}

	protected List<Table> getAvailableTableOnGame(List<Table> tableList,
			Game game) {
		List<Table> resultListOfTable = new ArrayList<Table>();
		int nbTable = tableList.size();
		for (int i = 0; i < nbTable; i++) {
			if (((Table) tableList.get(i)).getGame().equals(game)) {
				resultListOfTable.add(tableList.get(i));
			}
		}
		return resultListOfTable;
	}

	protected List<Table> getAvailableTableAge(List<Table> tableList,
			int playerAge) {

		List<Table> resultListOfTable = new ArrayList<Table>();
		int nbTable = tableList.size();
		for (int i = 0; i < nbTable; i++) {
			int masterAge = ((Table) tableList.get(i)).getMaster().getAge();
			// Si le maitre a moins de 30 ans
			if (masterAge < 30) {
				if ((masterAge - 4 <= playerAge)
						&& (playerAge <= masterAge + 4)) {
					resultListOfTable.add(tableList.get(i));
					// System.out.println("Age maitre -30 ans");
				}
			} else {
				// Si le maitre a plus de 30 ans
				if ((masterAge - 4 <= playerAge)
						&& (playerAge <= masterAge + 199)) {
					resultListOfTable.add(tableList.get(i));
					// System.out.println("Age maitre +30 ans");
				}
			}
		}

		return resultListOfTable;

	}

	protected List<Table> getAvailableTableClub(List<Table> tables,
			String clubName) {
		List<Table> resultListOfTable = new ArrayList<Table>();
		for (Table table : tables) {
			Set<Player> players = table.getPlayers();
			boolean clubFound = false;
			for (Player player : players) {
				if (player.getClubName().equals(clubName)) {
					clubFound = true;
					break;
				}
			}
			if (!clubFound) {
				resultListOfTable.add(table);
			}
		}
		return resultListOfTable;
	}

	protected List<Table> getAvailableFemaleTable(List<Table> tables) {
		List<Table> resultListOfTable = new ArrayList<Table>();
		for (Table table : tables) {
			Set<Player> players = table.getPlayers();
			boolean female = false;
			for (Player player : players) {
				if (!player.isMale()) {
					female = true;
					break;
				}
			}
			if (!female) {
				resultListOfTable.add(table);
			}
		}
		return resultListOfTable;
	}

	protected int tableMoreFilled(List<Table> tableList) {
		int index = 0;
		int nbTable = tableList.size();
		int numberOfPlayer = 0;
		for (int i = 0; i < nbTable; i++) {
			if (tableList.get(i).getPlayers().size() > numberOfPlayer) {
				numberOfPlayer = tableList.get(i).getPlayers().size();
				index = i;
			}

		}
		return index;
	}

	// //////////////////////////////////////////////////////////////////////////////////

	public static TournamentSchedule createFromFile(String fileName) {
		FileInputStream in = null;
		ObjectInputStream s = null;
		try {
			in = new FileInputStream(fileName);
			s = new ObjectInputStream(in);			
		} catch (FileNotFoundException ex) {
			return null;
		} catch (IOException ex1) {
			ex1.printStackTrace();
			return null;
		}
		TournamentSchedule tournamentSchedule = new TournamentSchedule(s);
		try {
			s.close();
			in.close();
		} catch (IOException ex2) {
			ex2.printStackTrace();
			return null;
		}
		return tournamentSchedule;
	}

	// ////////////////////////////////////////////////////////////////////////////////

	public void save() {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(
					RPGTournamentMngrConstants.saveDirectoryRounds
							+ File.separator + "tournamentSchedule");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		try {
			ObjectOutputStream s = new ObjectOutputStream(out);
			this.writeObject(s);
			s.flush();
			s.close();
			out.close();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
	}

	// //////////////////////////////////////////////////////////////////////////////

	public void writeObject(ObjectOutputStream oos) {
		try {
			oos.writeObject(this.rounds);
			oos.writeObject(this.playersWithoutTable);
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}

	// //////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public void readObject(ObjectInputStream ois) {
		try {
			this.rounds = (Map<Integer, Round>) ois.readObject();
			this.playersWithoutTable = (Map<Integer, Set<Player>>) ois
					.readObject();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// ////////////////////////////////////////////////////////////////////////////////

}