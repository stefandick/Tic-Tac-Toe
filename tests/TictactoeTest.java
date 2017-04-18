import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author StefanDick
 * 
 */
public class TictactoeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link TictactoeGame#getNextPlayer()}.
	 */
	@Test
	public void testGetNextPlayer() {
		Player playerX = new Player("Player X", "X");
		Player playerO = new Player("Player O", "O");
		TictactoeGame tictactoe = new TictactoeGame(null, playerX, playerO);
		for (int i = 0; i < 100; i++) {
			assertEquals(playerO, tictactoe.getNextPlayer());
			tictactoe.incrementCount();
			assertEquals(playerX, tictactoe.getNextPlayer());
			tictactoe.incrementCount();
		}
	}



	/**
	 * Test method for {@link Tictactoe#getResult()}.
	 */
	@Test
	public void testGetResult() {
		;
	}

	/**
	 * Test method for {@link Tictactoe#incrementCount()}.
	 */
	@Test
	public void testIncrementCount() {
		Player playerX = new Player("Player X", "X");
		Player playerO = new Player("Player O", "O");
		TictactoeGame tictactoe = new TictactoeGame(null, playerX, playerO);
		for (int i =0; i <100;i++){
			tictactoe.incrementCount();
			assertEquals(i+1, tictactoe.getCount());
					
		}
		
	}

}
