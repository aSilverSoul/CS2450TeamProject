/***************************************************************
* file: BaseGame.java
* author: Gary Machorro, Brandon Helt, Sonya Eller
* class: CS 2450 – Programming Graphical User Interfaces
*
* assignment: Project 1
* date last modified: 9/13/19
*
* purpose: This is the BaseGame Class, which is the superclass
* 
* 
*
****************************************************************/ 

package cs245.project;

/**
 *
 * @author garym
 */
public class BaseGame implements Runnable{
    
    private Thread t;
    private String gameName;
    private int score;
    
    
    public BaseGame(){
    }
    
    public BaseGame(String gameName){
        this.gameName = gameName;
    }
    
    protected void initGame(){};
    protected void gameLoop(){};
    
    public void startGame() {
        initGame();
        gameLoop();
    };

    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    public void modifyScore(int score){
        this.score += score;
    }
    @Override
    public void run() {
        startGame();
    }
        // method: start
    // purpose: creates a new thread and starts it
    public void start() {
        if(t == null) {
            t = new Thread(this, gameName);
            t.start();
        }
    }
}
