package fr.graal.rpgtournament.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import fr.graal.rpgtournament.RPGTournamentMngrConstants;
import fr.graal.rpgtournament.player.Player;

/**
 * @author VAN DE BOR Eric
 * @author VICARD Sébastien
 * @version 1.1
 */

public class Table implements Serializable {
	private static final long serialVersionUID = -6280463294080837240L;

	private Game game;
	private Player master;
	private Set<Player> players;

	public Table(Player master, Game game) {
		this.game = game;
		this.master = master;
		this.players = new HashSet<Player>();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getMaster() {
		return master;
	}

	public void setMaster(Player master) {
		this.master = master;
	}

	public void addPlayer(Player player) {
		if (!player.equals(master)) {
			this.players.add(player);
		}
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public boolean isFivePlayer() {
		return players.size() >= 5;
	}

	public boolean isSixPlayer() {
		return players.size() == 6;
	}

	public boolean containsPlayer(Player player) {
		return players.contains(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	private String getTitleForDisplay(int tableNumber) {
		StringBuilder asString = new StringBuilder();
		asString.append(RPGTournamentMngrConstants.Texts.getString("Table"))
				.append(" ")
				.append(tableNumber)
				.append("    -    ")
				.append(game);
		return asString.toString();
	}

	private String getMasterForDisplay() {
		StringBuilder asString = new StringBuilder();
		asString.append(RPGTournamentMngrConstants.Texts.getString("Master"))
				.append(" : ")
				.append(master.getFullName());
		return asString.toString();
	}

	private String getPlayersForDisplay() {
		StringBuilder asString = new StringBuilder();
		asString.append(RPGTournamentMngrConstants.Texts.getString("Players"))
				.append("\n")
				.append(playerListToString());
		return asString.toString();
	}

	public String asString(int number) {
		StringBuilder asString = new StringBuilder();
		asString.append(getTitleForDisplay(number)).append("\n")
				.append(getMasterForDisplay()).append("\n")
				.append(getPlayersForDisplay()).append("\n");
		return asString.toString();
	}

	private String playerListToString() {
		String returnedString = "";
		if (CollectionUtils.isNotEmpty(players)) {
			for (Player player : players) {
				returnedString = returnedString + "     -"
						+ player.getFullName() + "\n";
			}
		} else {
			returnedString = "     "
					+ RPGTournamentMngrConstants.Texts.getString("NoPlayer")
					+ "\n";
		}
		return returnedString;
	}

}
