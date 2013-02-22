package fr.graal.rpgtournament.tournament;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import fr.graal.rpgtournament.game.Game;

/**
 * @author Eric VAN DE BOR
 * @author Sébastien VICARD
 * @version 1.1
 */

public class RoundWishes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3986451105313405355L;
	// List of games indexed by priority
	protected Map<Integer, Game> gmGamesList;
	protected Map<Integer, Game> pGamesList;

	protected boolean isMaster;

	public RoundWishes() {
		gmGamesList = new Hashtable<Integer, Game>();
		pGamesList = new Hashtable<Integer, Game>();
	}

	public Map<Integer, Game> getGmGamesList() {
		return gmGamesList;
	}

	public Map<Integer, Game> getPGamesList() {
		return pGamesList;
	}

	public boolean isMaster() {
		return isMaster;
	}

	public void setIsMaster() {
		isMaster = true;
	}

	public void setIsPlayer() {
		isMaster = false;
	}

	public Game getGame(Integer gameNbr, boolean isMaster) {
		if (isMaster)
			return gmGamesList.get(gameNbr);
		else
			return pGamesList.get(gameNbr);
	}

	public Game getFirstGame(boolean isMaster) {
		Game result = null;
		if (isMaster) {
			List<Integer> indexes = new ArrayList<Integer>(gmGamesList.keySet());
			Collections.sort(indexes);
			result = gmGamesList.get(indexes.get(0));
		} else {
			List<Integer> indexes = new ArrayList<Integer>(pGamesList.keySet());
			Collections.sort(indexes);
			result = pGamesList.get(indexes.get(0));
		}
		return result;
	}

	public void setGame(Integer gameNbr, Game game, boolean isMaster) {
		if (isMaster)
			gmGamesList.put(gameNbr, game);
		else
			pGamesList.put(gameNbr, game);
	}

	public void setGmGameList(Map<Integer, Game> listOfGames) {
		this.gmGamesList = listOfGames;
	}

	public void setPGameList(Map<Integer, Game> listOfGames) {
		this.pGamesList = listOfGames;
	}

}