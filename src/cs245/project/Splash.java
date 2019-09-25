/***************************************************************
* file: Splash.java
* author: Gary Machorro, Brandon Helt, Sonya Eller
* class: CS 2450 – Programming Graphical User Interfaces
*
* assignment: Project 1
* date last modified: 9/13/19
*
* purpose: This file is for the splash screen before the game loads.
*
****************************************************************/ 

package cs245.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author garym
 */
public class Splash {    
    static SplashScreen splash;
    static Graphics2D splashTitle,splashName;               
    static Rectangle2D.Double splashTitleSpace, splashNameSpace;
    static Font titleFont, nameFont;

    // method: splashInit
    // purpose: This method creates the text on the splash screen
    public static void splashInit() {
        int height, width;
        splash = SplashScreen.getSplashScreen();
        Dimension dim = splash.getSize();
        height = dim.height;
        width = dim.width;
        splashTitleSpace = new Rectangle2D.Double(15., height*.1, width * .45, 32.);
        splashTitle = splash.createGraphics();
        titleFont = new Font("Arial", Font.PLAIN, 40);
        splashTitle.setFont(titleFont);

        splashNameSpace = new Rectangle2D.Double(190., height*0.88, width * .45, 32.);
        splashName = splash.createGraphics();
        nameFont = new Font("Arial", Font.PLAIN, 30);
        splashName.setFont(nameFont); 
            
        splashTitleText("");
        splashNameText("");
            
    }
    // method: splashTitleText
    // purpose: This method displays the game name on the splash screen
    public static void splashTitleText(String str){
        if (splash != null && splash.isVisible()) {
            splashTitle.setPaint(Color.YELLOW);
            splashTitle.drawString(str, (int)(splashTitleSpace.getX() + 20),(int)(splashTitleSpace.getY() + 15));
            splash.update();
        }
    }
    
    // method: splashNameText
    // purpose: This method displays the team name on the splash screen
    public static void splashNameText(String str){
        if (splash != null && splash.isVisible()) {
            splashName.setPaint(Color.YELLOW);
            splashName.drawString(str, (int)(splashNameSpace.getX() + 10),(int)(splashNameSpace.getY() + 15));
            splash.update();
        }
    }
}
