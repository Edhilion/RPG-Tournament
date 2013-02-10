package fr.graal.rpgtournament.notation;

import java.io.Serializable;

import fr.graal.rpgtournament.game.Game;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class Notation implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 225001396050012288L;
	
	
public static final String PLAYER = "PJ";
public static final String GAME_MASTER = "MJ";
  
  private String type;
  private int note;
  private Game game;

  public Notation() {
    setType(PLAYER);
    setNote(0);
  }

  public Notation(String type, int note, Game game) {
    setType(type);
    setNote(note);
    setGame(game);
  }

	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setNote(int note) {
		this.note = note;
	}
	
	public int getNote() {
		return note;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

}