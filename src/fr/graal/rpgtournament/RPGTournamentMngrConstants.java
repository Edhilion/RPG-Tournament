package fr.graal.rpgtournament;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.Hashtable;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.1
 */

public class RPGTournamentMngrConstants {

  public static ResourceBundle Texts = ResourceBundle.getBundle("fr.evdb.rpgtournament.i18n.RPGTournamentManagerText", Locale.getDefault());

  public static Map listOfGameByRound;

  public static final int nbrOfRound = 3;
  public static Map nbrOfGames;

  public static final String saveDirectoryPlayers = "Player";
  public static final String saveDirectoryRounds = "Round";

  public static void init() {

    nbrOfGames = new Hashtable();
    nbrOfGames.put(new Integer(1), new Integer(6));
    nbrOfGames.put(new Integer(2), new Integer(6));
    nbrOfGames.put(new Integer(3), new Integer(6));
    
    listOfGameByRound = new Hashtable();
    Vector roundGame;
    //round 1
    roundGame = new Vector();
    roundGame.add("PRAETORIA PRIMA");
    roundGame.add("DONJONS ET DRAGONS 4");
    roundGame.add("CTHULHU");
    roundGame.add("DARK HERESY");
    roundGame.add("JEU SURPRISE");
    listOfGameByRound.put(new Integer(1), roundGame);

    //round 2
    roundGame = new Vector();
    roundGame.add("KHAOS 1795");
    roundGame.add("WARHAMMER JDR 2e");
    roundGame.add("HOLLOW EARTH EXPEDITION");
    roundGame.add("POLARIS");
    roundGame.add("JEU SURPRISE");
    
    listOfGameByRound.put(new Integer(2), roundGame);

    //round 3
    roundGame = new Vector();
    roundGame.add("QIN/YGGDRASILL");
    roundGame.add("LEGENDE DES 5 ANNEAUX");
    roundGame.add("BRAIN SODA");
    roundGame.add("STAR WARS");
    roundGame.add("JEU SURPRISE");
    
    listOfGameByRound.put(new Integer(3), roundGame);
  }

}