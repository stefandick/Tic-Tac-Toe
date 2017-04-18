import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UiBoard  {

	private  JFrame frame;
	private  JButton buttons[] = new JButton[9];
	private  JButton btnReset;
	private  JButton btnNewGame;

	private  JTextField textField;
	private  JTextField textField_1;
	private  TictactoeGame model;
	private JPanel gridPanel;

	public  void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		makeGridPanel();

		makeInfoPanel();

	}

	 void makeGridPanel() {
		gridPanel = placeGridPanelOnLeft();

		frame.getContentPane().add(gridPanel, BorderLayout.WEST);
		gridPanel.setLayout(new GridLayout(3, 3));
		addButtonsForBoard(gridPanel);
	}

	 
	private void makeInfoPanel() {
		JPanel infoPanel = placeGridPanelOnLeft();
		frame.getContentPane().add(infoPanel, BorderLayout.EAST);
		infoPanel.setLayout(new GridLayout(3, 2));

		makeLabelsForScores(infoPanel);

		

		textField = new JTextField();
		infoPanel.add(textField);
		textField.setColumns(5);
		textField.enable(false);

		textField_1 = new JTextField();
		infoPanel.add(textField_1);
		textField_1.setColumns(5);
		textField_1.enable(false);

		btnNewGame = new JButton("NEW GAME");
		infoPanel.add(btnNewGame);
		btnNewGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				resetButtons();
				model.resetCount_Win();
				
			}
		});

		btnReset = new JButton("RESET");
		infoPanel.add(btnReset);
		btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clickReset(e);
				
			}
			
		});
	}

	private  void addButtonsForBoard(JPanel gridPanel) {
		// ADD THE BUTTONS
		for (int i = 0; i <= 8; i++) {
			buttons[i] = new JButton();
			gridPanel.add(buttons[i]);
			buttons[i].addActionListener(new Playmaker());
		}
	}

	private  void makeLabelsForScores(JPanel infoPanel) {
		// LABELS FOR SCORES
		JLabel lblPlayerx = new JLabel("Player 'X'\n ");
		lblPlayerx.setVerticalAlignment(SwingConstants.TOP);
		infoPanel.add(lblPlayerx);

		JLabel lblPlayero = new JLabel("Player 'O'\n ");
		lblPlayero.setVerticalAlignment(SwingConstants.TOP);
		infoPanel.add(lblPlayero);
	}

	private  JPanel placeGridPanelOnLeft() {
		// Place grid panel on left
		JPanel gridPanel = new JPanel();
		return gridPanel;
	}

	public JButton[] getButtons() {
		return this.buttons;

	}

	 void clickReset(ActionEvent a) {
		// RESET BUTTON ACTION
		 
		if ((JButton) a.getSource() == btnReset) {
			//set Buttons back their un-played format and reset scores
			resetButtons();
			model.reset_Count_Win_Scores();
		}
	}

	private void resetButtons() {
		for(int i=0;i<=8;i++){
			buttons[i].setText("");
			buttons[i].setEnabled(true);
		}
	}
	 


	 void makePlay(ActionEvent a) {
		// Write the character to the button and deactivate it
		JButton pressedButton = (JButton) a.getSource();
		pressedButton.setText(model.getNextPlayer().character);
		pressedButton.setEnabled(false);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TictactoeGame model = new TictactoeGame();
					UiBoard window = new UiBoard();
					model.setGameBoard(window);
					window.setModel(model);
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	///////ACTION LISTENERS
	class Playmaker implements ActionListener{ 
	@Override
	
	public void actionPerformed(ActionEvent e) {

		model.incrementCount();

		makePlay(e);

		model.getResult();

		model.endGameMessage();

	}
	}
	
	
	public TictactoeGame getModel() {
		return model;
	}

	public void setModel(TictactoeGame model) {
		this.model = model;
	}
	
	void disableButtons(){
		for(int i=0; i <= 8;i++){
			buttons[i].setEnabled(false);
		}
	}

	void writePlayerXScore(Player p){
		textField.setText(p.getScore());
		
	}
	
	void writePlayerOScore(Player p){
		textField_1.setText(p.getScore());
		
	}

	void playerWinMessage(TictactoeGame tictactoeGame) {
		JOptionPane.showMessageDialog(null, tictactoeGame.getNextPlayer().character + " won the game!");
	}

	void playerTieMessage() {
		JOptionPane.showMessageDialog(null, "The game was tie!");
	}
}
