package fr.graal.rpgtournament.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.graal.rpgtournament.player.Player;

public class TableTest {
	
	private static Game game;
	private static Table table;
	private static Player pc1;
	private static Player pc2;
	private static Player gm;
	
	private final static String GAME_1 = "Game1";
	
	private final static String GM_LASTNAME = "GYGAX";
	private final static String GM_FIRSTNAME = "Gary";
	private final static String PC1_LASTNAME = "DOE";
	private final static String PC1_FIRSTNAME = "John";
	private final static String PC2_LASTNAME = "SMITH";
	private final static String PC2_FIRSTNAME = "John";
	
	@BeforeClass
	public static void initialize() {
		game = new Game(GAME_1);
		gm = new Player(GM_LASTNAME, GM_FIRSTNAME);
		pc1 = new Player(PC1_LASTNAME, PC1_FIRSTNAME);
		pc2 = new Player(PC2_LASTNAME, PC2_FIRSTNAME);
		
		table = new Table(gm, game);
		table.addPlayer(pc1);
	}

	@Test
	public void checkTableDoesntContainPlayer() {
		assertFalse(table.containsPlayer(pc2));
	}

	@Test
	public void checkTableContainsPlayer() {
		assertTrue(table.containsPlayer(pc1));
	}
	
	@Test
	public void cannotAddSamePlayerMultipleTimes() {
		table.addPlayer(pc1);
		assertEquals(1, table.getPlayerList().size());
		assertEquals(pc1, table.getPlayerList().get(0));
	}
	
	@Test
	public void cannotAddGMAsPlayer() {
		table.addPlayer(gm); // TODO : devrait lancer une exception ou un message d'avertissement
		assertEquals(1, table.getPlayerList().size());
		assertEquals(pc1, table.getPlayerList().get(0));
	}

}
