package fr.graal.rpgtournament;

import java.io.Serializable;

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
public static final String NO_GAME = "none";
  
  private String type;
  private int note;
  private String game;

  public Notation() {
    setType(PLAYER);
    setNote(0);
    setGame(NO_GAME);
  }

  public Notation(String t, int n, String g) {
    setType(t);
    setNote(n);
    setGame(g);
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

	public void setGame(String game) {
		this.game = game;
	}

	public String getGame() {
		return game;
	}

}