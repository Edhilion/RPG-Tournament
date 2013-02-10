package fr.graal.rpgtournament.notation;

import java.util.Hashtable;

import fr.graal.rpgtournament.RPGTournamentMngrConstants;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003-2012</p>
 * <p>Société : GRAAL</p>
 * @author VAN DE BOR Eric
 * @author VICARD Sébastien
 * @version 1.1
 */

public class PlayerNotation extends Hashtable<Integer, Notation> {
	private static final long serialVersionUID = 7170634245188168735L;

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