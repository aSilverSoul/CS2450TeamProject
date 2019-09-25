/***************************************************************
* file: HighScoreTracker.java
* author: Gary Machorro, Brandon Helt, Sonya Eller
* class: CS 2450 – Programming Graphical User Interfaces
*
* assignment: Project 1
* date last modified: 9/13/19
*
* purpose: tracks, sorts, and collects the top five scores
* from a file
* 
****************************************************************/ 

package cs245.project;

import java.awt.Frame;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author garym
 */
public class HighScoreTracker {
    public Frame frame;
    private final int HIGH_SCORE_AMOUNT= 5;
    private String playerNames[] = new String[HIGH_SCORE_AMOUNT];
    private int scores[] = new int[HIGH_SCORE_AMOUNT];
    private static final String FILE_NAME = "highscorerecord.txt";
    
    // method: HighScoreTracker
        // purpose: this method opens the file, reads the contents, and stores into two arrays.
        //One for player names and another for scores
    public HighScoreTracker() {
        BufferedReader inputStream = null;
        String inputString = "";
        int numStart, count = 0;
        try {
        inputStream = new BufferedReader(new FileReader(FILE_NAME));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        try {
            inputString = inputStream.readLine();
        }
        catch(Exception e) {
            
        }
        while((inputString != null) && (count < HIGH_SCORE_AMOUNT)){
            numStart = inputString.indexOf(' ');
            playerNames[count] = inputString.substring(0, numStart);
            scores[count] = Integer.valueOf(inputString.substring(numStart+1, inputString.length()));
            try {
                inputString = inputStream.readLine();
            }
            catch(Exception e) {
                
            }
            count++;
        }
            try {
                inputStream.close();
            }
            catch(Exception e) {
                
            }        
    }

       // method: addScore
        //parameter: the total score
	// purpose: if the score is top 5, user is prompted to give intials and the high score is updated
    public void addScore(int score) {
        String name = "";
        if(score > scores[scores.length-1]) {
            name = JOptionPane.showInputDialog(frame, "New High Score! Enter your initials: ");
            scores[scores.length-1] = score;
            playerNames[scores.length-1] = name;
            sort();
            writeScores();
        }
    }
    // method: sort
        // purpose: this method sorts the two arrays into the correct order  
    public void sort() {
        String tmpName;
        int tmpScore;
        for(int i = scores.length-1; i> 0;i--){
            if(scores[i] > scores[i-1]) {
                tmpName = playerNames[i];
                playerNames[i] = playerNames[i-1];
                playerNames[i-1] = tmpName;
                tmpScore = scores[i];
                scores[i] = scores[i-1];
                scores[i-1] = tmpScore;               
            }
        }
    }
    // method: writeScores()
        // purpose: this writes the top 5 scores to the test file
    public void writeScores() {
        BufferedWriter outputStream = null;
        try{
            outputStream = new BufferedWriter(new FileWriter(FILE_NAME));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try{
           for(int i = 0; i < HIGH_SCORE_AMOUNT; i++) {
               outputStream.write(playerNames[i] + " " + scores[i] + "\n");
           } 
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try{
            outputStream.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
                        
    }

}

