package fr.graal.rpgtournament.player;

import org.junit.Test;

public class PlayerTest {
	
	

	@Test
	public void cannotCreatePlayerWithoutName() {
		Player player = new Player(null, null);
	}
	
	

}
