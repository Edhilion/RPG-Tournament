package fr.graal.rpgtournament.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.graal.rpgtournament.player.Player;

/**
 * @author VAN DE BOR Eric
 * @author VICARD Sébastien
 * @version 1.1
 */

public class Table implements Serializable {
	private static final long serialVersionUID = -6280463294080837240L;
	
	protected Game game;
	protected Player master;
	protected ArrayList<Player> playersList;

	public Table() {
	}

	public Table(Player master, Game game) {
		this.game = game;
		this.master = master;
		this.playersList = new ArrayList<Player>();
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
		this.playersList.add(player);
	}

	public List<Player> getPlayerList() {
		return playersList;
	}

	public boolean isFivePlayer() {
		return playersList.size() >= 5;
	}

	public boolean isSixPlayer() {
		return playersList.size() == 6;
	}
	
	public boolean containsPlayer(Player p) {
		int size = playersList.size();
		for (int i=0; i<size; i++) {
			if (playersList.get(i).equals(p)) {
				return true;
			}
		}
		return false;
	}

	public void removePlayer(Player p) {
		int size = playersList.size();
		for (int i=0; i<size; i++) {
			if (playersList.get(i).equals(p) ) {
				playersList.remove(i);
			}
		}
		}
	
}
  
