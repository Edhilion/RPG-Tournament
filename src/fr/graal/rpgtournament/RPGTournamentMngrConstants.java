package fr.graal.rpgtournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Map;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003-2012</p>
 * <p>Société : GRAAL</p>
 * @author VAN DE BOR Eric
 * @author VICARD Sébastien
 * @version 1.2
 */

public class RPGTournamentMngrConstants {

  public static ResourceBundle Texts = ResourceBundle.getBundle("fr.evdb.rpgtournament.i18n.RPGTournamentManagerText", Locale.getDefault());

  public static Map<Integer, ArrayList<String>> listOfGameByRound;

  public static final int nbrOfRound = 3;
  public static Map<Integer, Integer> nbrOfGames;

  public static final String saveDirectoryPlayers = "Player";
  public static final String saveDirectoryRounds = "Round";
  public static final String saveDirectoryGames = "Game";

  public static void init() {

    nbrOfGames = new HashMap<Integer, Integer>();
    nbrOfGames.put(new Integer(1), new Integer(6));
    nbrOfGames.put(new Integer(2), new Integer(6));
    nbrOfGames.put(new Integer(3), new Integer(6));
    
    listOfGameByRound = new HashMap<Integer, ArrayList<String>>();
    ArrayList<String> roundGame;
    //round 1
    roundGame = new ArrayList<String>();
    roundGame.add("PRAETORIA PRIMA");
    roundGame.add("DONJONS ET DRAGONS 4");
    roundGame.add("CTHULHU");
    roundGame.add("DARK HERESY");
    roundGame.add("JEU SURPRISE");
    listOfGameByRound.put(new Integer(1), roundGame);

    //round 2
    roundGame = new ArrayList<String>();
    roundGame.add("KHAOS 1795");
    roundGame.add("WARHAMMER JDR 2e");
    roundGame.add("HOLLOW EARTH EXPEDITION");
    roundGame.add("POLARIS");
    roundGame.add("JEU SURPRISE");
    
    listOfGameByRound.put(new Integer(2), roundGame);

    //round 3
    roundGame = new ArrayList<String>();
    roundGame.add("QIN/YGGDRASILL");
    roundGame.add("LEGENDE DES 5 ANNEAUX");
    roundGame.add("BRAIN SODA");
    roundGame.add("STAR WARS");
    roundGame.add("JEU SURPRISE");
    
    listOfGameByRound.put(new Integer(3), roundGame);
  }

}