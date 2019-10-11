/***************************************************************
* file: Pong.java
* author: Gary Machorro, Brandon Helt, Sonya Eller
* class: CS 2450 – Programming Graphical User Interfaces
*
* assignment: Project 1-finalversion
* date last modified: 10/11/19
* purpose: The pong.java which contains pongengine, pong, and status bar 
* classes. Has everthing for pong to run
*
****************************************************************/ 


package cs245.project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author garym
 */
public class Pong extends JFrame {
		
	PongEngine gameEngine = new PongEngine();	
	
	public Pong() {
		setTitle("Pong");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
				
		// Initial status bar displaying scores
		JLabel score = new JLabel("Player A | Player B", JLabel.CENTER);
		score.setOpaque(true);
		score.setBackground(Color.green);
		add(score, BorderLayout.SOUTH);	
		
		add(gameEngine);
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					gameEngine.start();
					break;
				case KeyEvent.VK_UP:
					gameEngine.moveB(-20);
					break;
				case KeyEvent.VK_DOWN:
					gameEngine.moveB(+20);
					break;
				case KeyEvent.VK_E:
					gameEngine.moveA(-20);
					break;
				case KeyEvent.VK_D:
					gameEngine.moveA(20);
					break;
                                case KeyEvent.VK_ESCAPE: 
                                        MainMenu menu = new MainMenu();
                                        menu.setVisible(true);
                                        dispose();
				}
			}
		});
	
	}
	
}

class PongEngine extends JPanel {
	
	String message = "Press space to start";
	
	/** Coordinate of player A */
	int aY;
	
	/** Move player A up/down by d pixels */
	public void moveA(int d) {
		aY += d;
		
		// Player A left paddle cannot leave the screen from top or bottom
		if (aY <= paddleSize/2){
			aY = paddleSize/2;
		} else if (aY + paddleSize >= getHeight() + paddleSize/2){
			aY = getHeight() - paddleSize/2;
		} 
	}
	
	/** Coordinate of player B */
	int bY;

	/** Move player B up/down by d pixels */
	public void moveB(int d) {
		bY += d;

		// Player B right paddle cannot leave the screen from top or bottom
		if (bY <= paddleSize/2){
			bY = paddleSize/2;
		} else if (bY + paddleSize >= getHeight() + paddleSize/2){
			bY = getHeight() - paddleSize/2;
		}
	}
		
	/** Size of the paddles */
	static int paddleSize = 75;
	
	// Player A score count 
	static int aScore;
	// Player B score count
	static int bScore;

	/** Ball x coordinate */
	double ballX;
	/** Ball y coordinate */
	double ballY;

	/** Ball x direction/speed */
	double dX = 5.0;
	/** Ball y direction/speed */
	double dY = 5.0;
	
	/** Ball radius */
	int ballR = 10;
		
	/** Are we running or not */
	boolean running = false;
	
	public PongEngine() {
		super();
		// Compute the new ball coordinates 
		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (running) {
					updateGame();
				}
			}
		});
		timer.start();
	}
	
	/** Update the game */
	private void updateGame() {
		// Update ball coordinates
		ballX += dX;
		ballY += dY;
		
		// Check for out of bounds (y)
		if (ballY + ballR > getHeight()) {
			double out = ballY + ballR - getHeight();
			ballY = getHeight() - ballR - out;  
			dY = -dY;
		}
		if (ballY - ballR < 0) {
			double out = ballR - ballY;
			ballY = ballR + out;
			dY = -dY;
		}
		
		// Check if left paddle hits ball
		if ((ballX - ballR < 15) && (ballY < aY + paddleSize/2) && (ballY > aY - paddleSize/2)) {
			dX = -dX;
		} else if (ballX - ballR < 0) { // If out of bounds, score increases for player B
			bScore++;
			System.out.println("Player A: " + aScore + " | Player B: " + bScore);
			running = false;
		}
		
		// Check if right paddle hits ball
		if ((ballX + ballR > getWidth() - 15) && (ballY < bY + paddleSize/2) && (ballY > bY - paddleSize/2)){
			dX = -dX;
		} else if (ballX + ballR > getWidth()){ // If out of bounds, score increases for player A
			aScore++;
			System.out.println("Player A: " + aScore + " | Player B: " + bScore);
			running = false;
		}
		
		/** Repaint after the move */
		repaint();
		
	}
	
	/** Start the game */
	public void start() {
		if (!running) {
			running = true;
			aY = bY = getHeight() / 2;
			ballX = getWidth() / 2;
			ballY = getHeight() / 2;
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (running) {
			// Draw the ball
			int x = (int)(ballX - ballR);
			int y = (int)(ballY - ballR);
			int size = 2*ballR;
			g.setColor(Color.RED);
			g.fillOval(x, y, size, size);
			
			// Draw the paddles
			g.setColor(Color.BLUE);
			g.fillRect(5, aY - paddleSize/2, 15, paddleSize);
			g.setColor(Color.BLUE);
			g.fillRect(getWidth() - 20, bY - paddleSize/2, 15, paddleSize);

		} else {
			// If not running display a message 
			String message = "Press space to start";
			g.setColor(Color.BLACK);
			int h = g.getFontMetrics().getHeight();
			int w = g.getFontMetrics().stringWidth(message);
			g.drawString(message, getWidth()/2 - w/2, getHeight()/2 - h/2);

		}
	}
}

class StatusBar extends JFrame {
	
	public StatusBar(int aScore, int bScore){
		setTitle("Pong");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		
		JLabel score = new JLabel("Player A:" + aScore + " | Player B: " + bScore, JLabel.CENTER);
		score.setOpaque(true);
		score.setBackground(Color.green);	
		add(score, BorderLayout.SOUTH);		
	}
}
