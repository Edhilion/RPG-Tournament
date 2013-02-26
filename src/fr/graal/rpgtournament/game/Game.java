package fr.graal.rpgtournament.game;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * <p>
 * Titre : Game
 * </p>
 * <p>
 * Description : la classe contenant les informations d'un jeu (son nom et les
 * jours où il est joué)
 * </p>
 * <p>
 * Copyright : Copyright (c) 2012
 * </p>
 * <p>
 * Société :
 * </p>
 * 
 * @author VICARD Sébastien
 * @version 1.0
 */

public class Game implements Serializable, Comparable<Game> {

	private static final long serialVersionUID = 7594902657450811058L;
	private String name;
	private Integer index; // position du jeu dans la liste des jeux de la fiche
							// d'inscription
	private boolean dayOne;

	private boolean dayTwo;
	private boolean dayThree;


	public Game(String name, boolean dayOne, boolean dayTwo, boolean dayThree,
			Integer index) {
		this.name = name;
		this.index = index;
		this.dayOne = dayOne;
		this.dayTwo = dayTwo;
		this.dayThree = dayThree;
	}

	public Game(String name) {
		this.name = name;
	}
	


	public String getName() {
		return name;
	}
	
	public Integer getIndex() {
		return index;
	}
	
	public boolean isDayOne() {
		return dayOne;
	}

	public boolean isDayTwo() {
		return dayTwo;
	}

	public boolean isDayThree() {
		return dayThree;
	}
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;

		return new EqualsBuilder().append(this.name, other.name).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(this.name).toHashCode();
	}

	public int compareTo(Game game) {
		if (game == null || index == null) {
			return -1;
		} else {
			return this.index.compareTo(game.getIndex());
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}