package fr.graal.rpgtournament;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class Table implements Serializable {

  protected String game;
  protected Person master;
  protected ArrayList<Person> playersList;

  public Table() {
  }

  public Table(Person master, String game) {
    this.game = game;
    this.master = master;
    this.playersList = new ArrayList<Person>();
  }

  public String getGame() {
    return game;
  }

  public void setGame(String game) {
    this.game = game;
  }

  public Person getMaster() {
    return master;
  }

  public void setmaster(Person master) {
    this.master = master;
  }

  public void addPlayer(Person player) {
    this.playersList.add(player);
  }

  public ArrayList<Person> getPlayerList() {
    return playersList;
  }

  public boolean isFivePlayer() {
    return playersList.size() >= 5;
  }

  public boolean isSixPlayer() {
    return playersList.size() == 6;
  }

  public boolean containsPlayer(Person p) {
    int size = playersList.size();
    for (int i=0; i<size; i++) {
      if ( ((Person)playersList.get(i)).equals(p) ) {
        return true;
      }
    }
    return false;
  }

  public void removePlayer(Person p) {
  	int size = playersList.size();
    for (int i=0; i<size; i++) {
      if ( ((Person)playersList.get(i)).equals(p) ) {
      	playersList.remove(i);
      }
    }
  }
  
}
  
