package fr.graal.rpgtournament;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

/**
 * <p>Titre : Game</p>
 * <p>Description : la classe contenant les informations d'un jeu (son nom et les jours où il est joué)</p>
 * <p>Copyright : Copyright (c) 2012</p>
 * <p>Société : </p>
 * @author VICARD Sébastien
 * @version 1.0
 */

public class Game implements Serializable, Comparable<Game> {

	private static final long serialVersionUID = 7594902657450811058L;
	private String name;
	private Integer index; // position du jeu dans la liste des jeux de la fiche d'inscription
	private boolean dayOne;
	private boolean dayTwo;
	private boolean dayThree;
	
////////////////////////////////////////////////////////////////////////////////

	public Game(String name, boolean dayOne, boolean dayTwo, boolean dayThree, Integer index) {
		setAllDatas(name, dayOne, dayTwo, dayThree, index);
	}

////////////////////////////////////////////////////////////////////////////////

	public Game (ObjectInputStream ois) {
		this.readObject(ois);
	}

////////////////////////////////////////////////////////////////////////////////

	protected void setAllDatas(String name, boolean dayOne, boolean dayTwo, boolean dayThree, Integer index) {
		this.name=name;
		this.dayOne = dayOne;
		this.dayTwo = dayTwo;
		this.dayThree = dayThree;
		this.index = index;
	}

////////////////////////////////////////////////////////////////////////////////

	public String getName() {
		return this.name;
	}
	
	public Integer getIndex() {
		return this.index;
	}
	
	public boolean isDayOne() {
		return this.dayOne;
	}
	
	public boolean isDayTwo() {
		return this.dayTwo;
	}
	public boolean isDayThree() {
		return this.dayThree;
	}
////////////////////////////////////////////////////////////////////////////////

	public void writeObject(ObjectOutputStream oos) {
		try {
			oos.writeObject(this.name);
			oos.writeBoolean(this.dayOne);
			oos.writeBoolean(this.dayTwo);
			oos.writeBoolean(this.dayThree);
			oos.writeInt(this.index);
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}

////////////////////////////////////////////////////////////////////////////////

  public void readObject(ObjectInputStream ois) {
	  try {
		  this.name = (String)ois.readObject();
		  this.dayOne = ois.readBoolean();
		  this.dayTwo = ois.readBoolean();
		  this.dayThree = ois.readBoolean();
		  this.index = ois.readInt();
	  } catch (ClassNotFoundException ex) {
		  ex.printStackTrace();
	  } catch (IOException ex) {
		  ex.printStackTrace();
	  }
  }

////////////////////////////////////////////////////////////////////////////////

  	public boolean equals(String name) {
  		if (this.name.equalsIgnoreCase(name)) {
  			return true;
  		} else {
  			return false;
  		}
  	}

////////////////////////////////////////////////////////////////////////////////

  	public boolean equals(Game g) {
  		if (this.name.equalsIgnoreCase(g.getName())) {
  			return true;
  		}
  		return false;
  	}
  

////////////////////////////////////////////////////////////////////////////////

  	public int compareTo(Game o) {
		return this.index.compareTo(((Game)o).getIndex());
  	}

////////////////////////////////////////////////////////////////////////////////

  	public void setName(String name) {
  		this.name = name;
  	}

  	public void setDayOne(boolean dayOne) {
  		this.dayOne = dayOne;
  	}
  	
  	public void setDayTwo(boolean dayTwo) {
  		this.dayTwo = dayTwo;
  	}
  	
  	public void setDayThree(boolean dayThree) {
  		this.dayThree = dayThree;
  	}
  	
  	public void setIndex(Integer index) {
  		this.index = index;
  	}
}