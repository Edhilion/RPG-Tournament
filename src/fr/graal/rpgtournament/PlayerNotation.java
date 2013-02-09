package fr.graal.rpgtournament;

import java.util.Hashtable;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class PlayerNotation extends Hashtable {

  protected static final int MAX_NOTATION = 175;
  protected static final int MIN_NOTATION = 0;

  public PlayerNotation() {
    super();
    for (int i=1; i<=RPGTournamentMngrConstants.nbrOfRound; i++) { 
    	this.put(new Integer(i), new Notation());
    }
  }

  public void addNotation(Integer roundNb, Notation notation) {
    this.put(roundNb, notation);
  }

  public Notation getNotation(Integer roundNb) {
    return (Notation)this.get(roundNb);
  }

}