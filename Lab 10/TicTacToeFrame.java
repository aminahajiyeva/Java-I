import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A class modelling a tic-tac-toe (noughts and crosses, Xs and Os) game in a very
 * simple GUI window.
 * 
 * @author Lynn Marshall
 * @version November 8, 2012
 * 
 * @author Amina Hajiyeva 101303729
 */

public class TicTacToeFrame extends TicTacToe 
{ 
   private JTextArea status; // text area to print game status
   
   /** 
    * Constructs a new Tic-Tac-Toe board and sets up the basic
    * JFrame containing a JTextArea in a JScrollPane GUI.
    */
   public TicTacToeFrame()
   { 
       JFrame frame = new JFrame("TicTacToe"); // create new window (JFrame)
       frame.setSize(250, 250);  //initial size of window
       
       
       status = new JTextArea(20, 50);  // create  text area 20 rows 50 columns FOR GUI
       status.setEditable(false);  // make it read only (not editable)
       
       JScrollPane scroll = new JScrollPane(status); // add a scroll
       
       frame.add(scroll);       
       frame.setVisible(true);  // make window visible
       frame.pack();        // adjust window size to fit contents
   }
   
   /**
    * Prints the board to the GUI using toString().
    */
    public void print() 
    {  
        status.append("\n" + toString() + "\n");  //updates GUI
    }

}