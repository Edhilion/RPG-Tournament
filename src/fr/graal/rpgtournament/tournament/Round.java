package fr.graal.rpgtournament.tournament;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class Round implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 3986451105313405355L;
// List of games indexed by priority
  protected Map<Integer,String> gmGamesList;
  protected Map<Integer,String> pGamesList;

  protected boolean isMaster;

  public Round() {
	  gmGamesList = new Hashtable<Integer,String>();
	  pGamesList = new Hashtable<Integer,String>();
  }

  public Map<Integer,String> getGmGamesList() {
    return gmGamesList;
  }
  
  public Map<Integer,String> getPGamesList() {
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

  public String getGame(Integer gameNbr, boolean isMaster) {
	  if (isMaster)
		  return (String)gmGamesList.get(gameNbr);
	  else
		  return (String)pGamesList.get(gameNbr);
  }
  
  public String getFirstGame(boolean isMaster) {
	  String result = null;
	  if (isMaster) {
		  List<Integer> indexes = new ArrayList<Integer>(gmGamesList.keySet());
		  Collections.sort(indexes);
		  for(Integer i : indexes) {
			  if (gmGamesList.containsKey(i)) {
				  result = (String)gmGamesList.get(i);
			  }
		  }
	  } else {
		  List<Integer> indexes = new ArrayList<Integer>(pGamesList.keySet());
		  Collections.sort(indexes);
		  for(Integer i : indexes) {
			  if (pGamesList.containsKey(i)) {
				  result = (String)pGamesList.get(i);
			  }
		  }
	  }
	  return result;		  
  }

  public void setGame(Integer gameNbr, String gameName, boolean isMaster) {
	  if (isMaster)
		  gmGamesList.put(gameNbr, gameName);
	  else
		  pGamesList.put(gameNbr, gameName);
  }

  public void setGmGameList(Map<Integer,String> listOfGame) {
    this.gmGamesList = listOfGame;
  }
  
  public void setPGameList(Map<Integer,String> listOfGame) {
    this.pGamesList = listOfGame;
  }

}