package fr.graal.rpgtournament.player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.ImmutableMap;

import fr.graal.rpgtournament.tournament.RoundWishes;

public class PlayerTest {
	
	private Player player;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		player = new Player("DOE", "John");		
	}

	@Test
	public void cannotCreatePlayerWithoutLastname() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Lastname (as firstname) is mandatory");
		new Player(null, "John");
	}

	@Test
	public void cannotCreatePlayerWithoutFirstname() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Firstname (as lastname) is mandatory");
		new Player("DOE", null);
	}
	
	@Test
	public void checkSamePlayers() {
		Player p1 = new Player("DOE", "John");
		Player p2 = new Player("Doe", "JOHN");
		assertTrue(p1.equals(p2));
	}
	
	@Test
	public void checkDifferentPlayers() {
		Player differentPlayer = new Player("SMITH", "John");
		assertFalse(player.equals(differentPlayer));
	}
	
	@Test
	public void checkSamePlayersByNickname() {
		player.setNickname("jd");
		Player samePlayer = new Player("DOE", "John", "JD");
		assertTrue(player.equals(samePlayer));
	}
	
	@Test
	public void checkSamePlayersWithoutNickname() {
		Player samePlayer = new Player("DOE", "John", "");
		assertTrue(player.equals(samePlayer));
	}
	
	@Test
	public void checkDifferentPlayersByNickname() {
		player.setNickname("Joe");
		Player differentPlayer = new Player("DOE", "John", "JD");
		assertFalse(player.equals(differentPlayer));
	}
	
	@Test
	public void playsInRound() {
		RoundWishes round = new RoundWishes();
		Map<Integer, RoundWishes> rounds = ImmutableMap.of(1, round);
		player.setGameWishes(rounds);
		
		assertFalse(player.isPlayingInRound(0));
		assertTrue(player.isPlayingInRound(1));
	}


}
