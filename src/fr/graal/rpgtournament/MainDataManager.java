package fr.graal.rpgtournament;

import java.util.ArrayList;
import java.util.Vector;
import java.io.*;


/**
 * <p>Titre : Tournoi JDR</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2003</p>
 * <p>Société : </p>
 * @author VAN DE BOR Eric
 * @version 1.0
 */

public class MainDataManager {

  protected File pathFile;

  // The list of all players
  protected ArrayList playerList;

  public MainDataManager() {
    playerList = new ArrayList();
    pathFile = new File(RPGTournamentMngrConstants.saveDirectoryPlayers);
    pathFile.mkdir();
    getAllPlayer();
  }


  public void saveAllPlayers() {
    int size = playerList.size();
    for (int i=0; i<size; i++) {
      savePerson((Person)playerList.get(i));
    }
  }


  protected void getAllPlayer() {
    String[] listFile = pathFile.list();
    for (int i=0; i<listFile.length; i++) {
      playerList.add(createPerson(RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator + listFile[i]));
    }
  }


  protected Person createPerson(String fileName) {
    FileInputStream in = null;
    try {
      in = new FileInputStream(fileName);
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    ObjectInputStream s = null;
    try {
      s = new ObjectInputStream(in);
    }
    catch (IOException ex1) {
      ex1.printStackTrace();
    }
    Person p = new Person(s);
    try {
      s.close();
      in.close();
    } catch (IOException ex2) {
      ex2.printStackTrace();
    }
    return p;
  }


  public void addPerson(Person p) {
    playerList.add(p);
    savePerson(p);
  }


  public void savePerson(Person p) {
    FileOutputStream out = null;
    try {
      out = new FileOutputStream(RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator +
                                 p.getName() + p.getFirstName());
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

    try {
      ObjectOutputStream s = new ObjectOutputStream(out);
      p.writeObject(s);
      s.flush();
      s.close();
      out.close();
    } catch (IOException ex1) {
      ex1.printStackTrace();
    }
  }


  public void removePerson(Person p) {
    playerList.remove(p);
    try {
      if (!(new File(RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator + p.getName() + p.getFirstName())).delete()) {
        System.out.println("Error while deleting file: " + RPGTournamentMngrConstants.saveDirectoryPlayers + File.separator + p.getName() + p.getFirstName());
      }
    } catch (Exception exp) {
      exp.printStackTrace();
    }
  }


  public ArrayList getPlayerList() {
    return this.playerList;
  }


  public Person findPerson(String name, String firstName) {
    int size = playerList.size();
    for (int i=0; i<size; i++) {
      if (((Person)(playerList.get(i))).equals(name, firstName)) {
        return (Person)(playerList.get(i));
      }
    }
    return null;
  }


  public void updatePerson(Person previousPerson, Person newPerson) {
    removePerson(previousPerson);
    addPerson(newPerson);
  }


}