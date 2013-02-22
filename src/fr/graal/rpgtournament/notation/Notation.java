package fr.graal.rpgtournament.notation;

import java.io.Serializable;

import fr.graal.rpgtournament.game.Game;

/**
 * @author VAN DE BOR Eric
 * @author Sébastien VICARD
 * @version 1.1
 */

public class Notation implements Serializable {
	
	private static final long serialVersionUID = 225001396050012288L;

	public static final String PLAYER = "PJ";
	public static final String GAME_MASTER = "MJ";

	public static final Notation DEFAULT_PLAYER_NOTATION = new Notation(PLAYER, null, null);
	public static final Notation DEFAULT_GM_NOTATION = new Notation(GAME_MASTER, null, null);
	
	public static final Integer DEFAULT_NOTE = -1;

	private String type;
	private Integer note;
	private Game game;

	public Notation() {
		setType(PLAYER);
		setNote(DEFAULT_NOTE);
	}

	public Notation(String type, Integer note, Game game) {
		setType(type);
		setNote(note);
		setGame(game);
	}
	
	public static Notation newGameMasterNotation(Integer note, Game game) {
		return new Notation(GAME_MASTER, note, game);
	}
	
	public static Notation newPlayerNotation(Integer note, Game game) {
		return new Notation(PLAYER, note, game);
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Integer getNote() {
		return note;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

}