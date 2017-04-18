
public class TictactoeGame {
	// FIELDS
	private int[][] winCombinations = new int[][] { { 0, 1, 2 }, { 3, 4, 5 },
			{ 6, 7, 8 }, // horizontal win cases
			{ 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // vertical win cases
			{ 0, 4, 8 }, { 2, 4, 6 } // diagonal win cases
	};

	int count = 0;
	String character = "";
	private boolean win = false;
	int playerxScore = 0;
	int playeroScore = 0;
	UiBoard gameBoard = new UiBoard();
	Player playerX = new Player("PlayerX", "X");
	Player playerO = new Player("PlayerO", "O");

	// Create the application.

	public TictactoeGame() {
		gameBoard.initialize();
	}


	Player getNextPlayer() {
		// PLAYERS TURN
		if (getCount() % 2 == 0) {
			gameBoard.writePlayerOScore(playerO);
			return playerO ;
		} else {
			gameBoard.writePlayerXScore(playerX);
			return playerX;
		}
	/*	if(playerX == null || playerO == null)
			catch (Exception e) {
			system.out.println("Missing a player!");
			//e.printStackTrace();
		
		} */
	}

	void endGameMessage() {
		// MESSAGES WHEN GAME IS OVER
		gameBoard.writePlayerOScore(playerO);
		gameBoard.writePlayerXScore(playerX);
		if (win == true) {
			getNextPlayer().incrementScore();
			gameBoard.playerWinMessage(this);
			
			gameBoard.disableButtons();
		} else if (count == 9 && win == false) {
			gameBoard.playerTieMessage();
			
		}
	}


	void getResult() {
		// WINNER
		for (int i = 0; i <= 7; i++) {
			if (nextTo(i, 0, 1) && nextTo(i, 1, 2) && nextTo(i)) {
				win = true;
			}
		}
	}

	private boolean nextTo(int i) {
		return gameBoard.getButtons()[winCombinations[i][0]].getText() != "";
	}

	private boolean nextTo(int i, int j, int k) {
		return gameBoard.getButtons()[winCombinations[i][j]].getText().equals(
				gameBoard.getButtons()[winCombinations[i][k]].getText());
	}

	public UiBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(UiBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	void incrementCount() {
		count++;
	}
	int getCount(){
		return count;
	}

	public TictactoeGame(UiBoard gameBoard, Player playerX, Player playerO) {
		super();
		this.gameBoard = gameBoard;
		this.playerX = playerX;
		this.playerO = playerO;
	}
	
	void resetCount_Win(){
		count = 0;
		win = false;
	}
	
	void reset_Count_Win_Scores(){
		count = 0;
		win =false;
		playerO.resetScore();
		playerX.resetScore();
	}

}