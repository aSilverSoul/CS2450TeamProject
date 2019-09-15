/***************************************************************
* file: PlayScreen.java
* author: Gary Machorro, Brandon Helt, Sonya Eller
* class: CS 2450 – Programming Graphical User Interfaces
*
* assignment: Project 1
* date last modified: 9/13/19
* purpose: This file is the play screen, which is what the user will
* see while playing the game.
*
****************************************************************/ 

package cs245.project;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author garym
 */
public class PlayScreen extends javax.swing.JFrame {

    /**
     * Creates new form PlayScreen
     */
    //Word player must guess
    String selectedWord;
    String hiddenWord;
    //used to check if in word
    String[] wordArray;
    HangMan hangman;
    HashMap<Character, javax.swing.JButton> letterButtonMap  = new HashMap<>(); 
    
    // method: PlayScreen constructor
	// purpose: the default constructor
    public PlayScreen() {
        initComponents();
        addBindings();
    }
    
    //method: addBindings
    //purpose: adds keyBindings to the Clock label
    public void addBindings(){
        Action exit = new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                dispose();
                System.exit(0);
            }
        };
        Action credits = new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                System.out.print("test1\n");
                MainMenu menu = new MainMenu();
                CreditsScreen credits = new CreditsScreen();
                menu.setVisible(false);
                credits.setVisible(true);
                dispose();
            }
        };
        String actName = "exit";
        Clock.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),
                actName);
        Clock.getActionMap().put(actName, exit);
        actName = "credits";
        Clock.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),
                actName);
        Clock.getActionMap().put(actName, credits);
    }
    
    // method: mapButtonToLetters
	// purpose: Maps a charcter to a jButton to be used by other methods; such as hideKey
    public void mapButtonToLetters(){
        letterButtonMap.put('U',U);
        letterButtonMap.put('V',V);
        letterButtonMap.put('W',W);
        letterButtonMap.put('X',X);
        letterButtonMap.put('Y',Y);
        letterButtonMap.put('Z',Z);
        letterButtonMap.put('I',I);
        letterButtonMap.put('J',J);
        letterButtonMap.put('K',K);
        letterButtonMap.put('L',L);
        letterButtonMap.put('M',M);
        letterButtonMap.put('N',N);
        letterButtonMap.put('O',O);
        letterButtonMap.put('P',P);
        letterButtonMap.put('Q',Q);
        letterButtonMap.put('R',R);
        letterButtonMap.put('A',A);
        letterButtonMap.put('B',B);
        letterButtonMap.put('C',C);
        letterButtonMap.put('D',D);
        letterButtonMap.put('E',E);
        letterButtonMap.put('F',F);
        letterButtonMap.put('G',G);
        letterButtonMap.put('H',H);
        letterButtonMap.put('S',S);
        letterButtonMap.put('T',T);    
    }
    // method: hidKey
	// parameter: character that should be hidden
	// purpose: allows outside classes to be able to hide the jButton key
	// on the gui
    public void hideKey(Character letter){
        System.out.println(letter);
        System.out.println(letterButtonMap.containsKey(letter));
        letterButtonMap.get(letter).setVisible(false);
    }
	// method: PlayScreen Constructor
	// parameter: the HangMan class that has been created
    // purpose: the main constructor that will be used in game. It retrieves
	// the randomly selected word from the hangman class and sets up the hidden
	// word lines
    public PlayScreen(HangMan hangman) {
        this.hangman = hangman;
        initComponents();
        addBindings();
        mapButtonToLetters();
        this.selectedWord = hangman.getSelectedWord();
        wordArray = selectedWord.split("");
        hiddenWord = hangman.getHiddenWord();
        updateHiddenWord(hiddenWord);
        System.out.print(selectedWord);
        currentTime();
    }
	// method: currentTime
	// purpose: This method will generate and display the current time
	// on the game screen
    public void currentTime() {
        Thread clock = new Thread()
        {
                public void run()
                {
                    for(;;)
                    {
                        GregorianCalendar cal = new GregorianCalendar();
                        
                        int second = cal.get(GregorianCalendar.SECOND);
                        int minute = cal.get(GregorianCalendar.MINUTE);
                        int hour = cal.get(GregorianCalendar.HOUR);
                        Date now = new Date();
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
                        Clock.setText(dateFormatter.format(now) + "    " + hour + ": " + minute + ":  " + second);
                        try{
                            sleep(1000);
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                }
        };
        clock.start();
    }
    // method: updateHiddenWord
	// parameter: string that we will use to update the hidden word field
	// purpose: changes the hidden word to show the user's correct guess,
	// otherwise it starts out with all underscores
    public void updateHiddenWord(String word){
        hiddenWord = word;
        word = word.replace("", " ").trim();
        hiddenWordLabel.setText(word);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        U = new javax.swing.JButton();
        V = new javax.swing.JButton();
        W = new javax.swing.JButton();
        X = new javax.swing.JButton();
        Y = new javax.swing.JButton();
        Z = new javax.swing.JButton();
        Skip = new javax.swing.JButton();
        I = new javax.swing.JButton();
        J = new javax.swing.JButton();
        K = new javax.swing.JButton();
        L = new javax.swing.JButton();
        M = new javax.swing.JButton();
        N = new javax.swing.JButton();
        O = new javax.swing.JButton();
        P = new javax.swing.JButton();
        Q = new javax.swing.JButton();
        R = new javax.swing.JButton();
        A = new javax.swing.JButton();
        B = new javax.swing.JButton();
        C = new javax.swing.JButton();
        D = new javax.swing.JButton();
        E = new javax.swing.JButton();
        F = new javax.swing.JButton();
        G = new javax.swing.JButton();
        H = new javax.swing.JButton();
        S = new javax.swing.JButton();
        T = new javax.swing.JButton();
        hiddenWordLabel = new javax.swing.JLabel();
        Clock = new javax.swing.JLabel();
        gameScore = new javax.swing.JLabel();
        Image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        U.setText("U");
        U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UActionPerformed(evt);
            }
        });
        getContentPane().add(U);
        U.setBounds(180, 380, 50, 23);

        V.setText("V");
        V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VActionPerformed(evt);
            }
        });
        getContentPane().add(V);
        V.setBounds(230, 380, 50, 23);

        W.setText("W");
        W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WActionPerformed(evt);
            }
        });
        getContentPane().add(W);
        W.setBounds(280, 380, 50, 23);

        X.setText("X");
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });
        getContentPane().add(X);
        X.setBounds(330, 380, 50, 23);

        Y.setText("Y");
        Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YActionPerformed(evt);
            }
        });
        getContentPane().add(Y);
        Y.setBounds(380, 380, 50, 23);

        Z.setText("Z");
        Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZActionPerformed(evt);
            }
        });
        getContentPane().add(Z);
        Z.setBounds(430, 380, 50, 23);

        Skip.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        Skip.setText("Skip");
        Skip.setToolTipText("Press to skip to the color game.");
        Skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkipActionPerformed(evt);
            }
        });
        getContentPane().add(Skip);
        Skip.setBounds(480, 380, 50, 20);

        I.setText("I");
        I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IActionPerformed(evt);
            }
        });
        getContentPane().add(I);
        I.setBounds(480, 320, 50, 23);

        J.setText("J");
        J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JActionPerformed(evt);
            }
        });
        getContentPane().add(J);
        J.setBounds(80, 350, 50, 23);

        K.setText("K");
        K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KActionPerformed(evt);
            }
        });
        getContentPane().add(K);
        K.setBounds(130, 350, 50, 23);

        L.setText("L");
        L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LActionPerformed(evt);
            }
        });
        getContentPane().add(L);
        L.setBounds(180, 350, 50, 23);

        M.setText("M");
        M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MActionPerformed(evt);
            }
        });
        getContentPane().add(M);
        M.setBounds(230, 350, 50, 23);

        N.setText("N");
        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }
        });
        getContentPane().add(N);
        N.setBounds(280, 350, 50, 23);

        O.setText("O");
        O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OActionPerformed(evt);
            }
        });
        getContentPane().add(O);
        O.setBounds(330, 350, 50, 23);

        P.setText("P");
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }
        });
        getContentPane().add(P);
        P.setBounds(380, 350, 50, 23);

        Q.setText("Q");
        Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QActionPerformed(evt);
            }
        });
        getContentPane().add(Q);
        Q.setBounds(430, 350, 50, 23);

        R.setText("R");
        R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RActionPerformed(evt);
            }
        });
        getContentPane().add(R);
        R.setBounds(480, 350, 50, 23);

        A.setText("A");
        A.setToolTipText("");
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });
        getContentPane().add(A);
        A.setBounds(80, 320, 50, 23);

        B.setText("B");
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });
        getContentPane().add(B);
        B.setBounds(130, 320, 50, 23);

        C.setText("C");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        getContentPane().add(C);
        C.setBounds(180, 320, 50, 23);

        D.setText("D");
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });
        getContentPane().add(D);
        D.setBounds(230, 320, 50, 23);

        E.setText("E");
        E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EActionPerformed(evt);
            }
        });
        getContentPane().add(E);
        E.setBounds(280, 320, 50, 23);

        F.setText("F");
        F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FActionPerformed(evt);
            }
        });
        getContentPane().add(F);
        F.setBounds(330, 320, 50, 23);

        G.setText("G");
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });
        getContentPane().add(G);
        G.setBounds(380, 320, 50, 23);

        H.setText("H");
        H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HActionPerformed(evt);
            }
        });
        getContentPane().add(H);
        H.setBounds(430, 320, 50, 23);

        S.setText("S");
        S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SActionPerformed(evt);
            }
        });
        getContentPane().add(S);
        S.setBounds(80, 380, 50, 23);

        T.setText("T");
        T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TActionPerformed(evt);
            }
        });
        getContentPane().add(T);
        T.setBounds(130, 380, 50, 23);

        hiddenWordLabel.setBackground(new java.awt.Color(255, 255, 255));
        hiddenWordLabel.setForeground(new java.awt.Color(204, 0, 0));
        hiddenWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hiddenWordLabel.setOpaque(true);
        getContentPane().add(hiddenWordLabel);
        hiddenWordLabel.setBounds(100, 0, 260, 30);

        Clock.setBackground(new java.awt.Color(204, 204, 255));
        Clock.setForeground(new java.awt.Color(204, 0, 0));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Clock.setText("TEXT");
        Clock.setOpaque(true);
        getContentPane().add(Clock);
        Clock.setBounds(430, 10, 160, 14);

        gameScore.setBackground(new java.awt.Color(255, 255, 255));
        gameScore.setOpaque(true);
        gameScore.setForeground(new java.awt.Color(204, 0, 0));
        gameScore.setText("Score: 100");
        getContentPane().add(gameScore);
        gameScore.setBounds(10, 0, 140, 30);

        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/project/hangman_images/gallows_1.png"))); // NOI18N
        getContentPane().add(Image);
        Image.setBounds(80, 40, 440, 240);

        setSize(new java.awt.Dimension(616, 454));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('U');
    }//GEN-LAST:event_UActionPerformed

    private void VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('V');

    }//GEN-LAST:event_VActionPerformed

    private void WActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('W');

    }//GEN-LAST:event_WActionPerformed

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('X');

    }//GEN-LAST:event_XActionPerformed

    private void YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('Y');

    }//GEN-LAST:event_YActionPerformed

    private void ZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('Z');

    }//GEN-LAST:event_ZActionPerformed

    private void IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('I');

    }//GEN-LAST:event_IActionPerformed

    private void JActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('J');

    }//GEN-LAST:event_JActionPerformed

    private void KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('K');

    }//GEN-LAST:event_KActionPerformed

    private void LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('L');

    }//GEN-LAST:event_LActionPerformed

    private void MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('M');

    }//GEN-LAST:event_MActionPerformed

    private void NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('N');

    }//GEN-LAST:event_NActionPerformed

    private void OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('O');

    }//GEN-LAST:event_OActionPerformed

    private void PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('P');

    }//GEN-LAST:event_PActionPerformed

    private void QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('Q');

    }//GEN-LAST:event_QActionPerformed

    private void RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('R');

    }//GEN-LAST:event_RActionPerformed

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('A');

    }//GEN-LAST:event_AActionPerformed

    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('B');

    }//GEN-LAST:event_BActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('C');

    }//GEN-LAST:event_CActionPerformed

    private void DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('D');

    }//GEN-LAST:event_DActionPerformed

    private void EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('E');

    }//GEN-LAST:event_EActionPerformed

    private void FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('F');

    }//GEN-LAST:event_FActionPerformed

    private void GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('G');

    }//GEN-LAST:event_GActionPerformed

    private void HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('H');

    }//GEN-LAST:event_HActionPerformed

    private void SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('S');

    }//GEN-LAST:event_SActionPerformed

    private void TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TActionPerformed
        // TODO add your handling code here:
        hangman.selectCharacter('T');

    }//GEN-LAST:event_TActionPerformed

    private void SkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkipActionPerformed
        
        
        hangman.setScore(0);
        
        this.dispose();
    }//GEN-LAST:event_SkipActionPerformed

    public boolean CheckWord(String letter) {
        for (int i = 0; i < (wordArray.length + 1); i++) {
            if (letter.equalsIgnoreCase(wordArray[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A;
    private javax.swing.JButton B;
    private javax.swing.JButton C;
    private javax.swing.JLabel Clock;
    private javax.swing.JButton D;
    private javax.swing.JButton E;
    private javax.swing.JButton F;
    private javax.swing.JButton G;
    private javax.swing.JButton H;
    private javax.swing.JButton I;
    public javax.swing.JLabel Image;
    private javax.swing.JButton J;
    private javax.swing.JButton K;
    private javax.swing.JButton L;
    private javax.swing.JButton M;
    private javax.swing.JButton N;
    private javax.swing.JButton O;
    private javax.swing.JButton P;
    private javax.swing.JButton Q;
    private javax.swing.JButton R;
    private javax.swing.JButton S;
    private javax.swing.JButton Skip;
    private javax.swing.JButton T;
    private javax.swing.JButton U;
    private javax.swing.JButton V;
    private javax.swing.JButton W;
    private javax.swing.JButton X;
    private javax.swing.JButton Y;
    private javax.swing.JButton Z;
    public javax.swing.JLabel gameScore;
    private javax.swing.JLabel hiddenWordLabel;
    // End of variables declaration//GEN-END:variables
}
