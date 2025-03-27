/**
 * An up/down counter with a simple GUI.
 * 
 * @author Lynn Marshall
 * @version November 17, 2012
 * 
 * @Amina Hajiyeva 101303729
 * 
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Counter implements ActionListener
{
   /* The current value of the counter. */
   private int count;
   
   // The constants
   public static final int MINIMUM = 0;
   public static final int RESET_TO = 5;
   public static final int MAXIMUM = 10;
   
   /* A JTextField displays the current value of the counter. */
   private JTextField counterDisplay;
   
   /* The button that is clicked to increment the counter. */
   private JButton upButton;

   /* The button that is clicked to decrement the counter. */
   private JButton downButton;

   /* The button that is clicked to reset the counter. */
   private JButton resetButton;
   
   /* ADDED: The button that is clicked to  change the count to a random number in the range of MINIMUM to MAXIMUM. */
   private JButton randomButton; 
   
   /* The reset menu item */
   private JMenuItem resetItem;
   
   /* The quit menu item */
   private JMenuItem quitItem;
   
   /* ADDED: The clear history item */
   private JMenuItem clearItem; 
   
   /* The history area */
   private JTextArea history;
   
   /** 
    * Constructor for Counter
    */
   public Counter() 
   {
      // model
      count = 0;
      
      // JFrame
      JFrame frame = new JFrame("Counter");
      Container contentPane = frame.getContentPane(); 
      
      //Changed to a vertical box layout.
      contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); 
      
      JMenuBar menubar = new JMenuBar();
      frame.setJMenuBar(menubar); // add menu bar to our frame

      JMenu fileMenu = new JMenu("Options"); // create a menu
      menubar.add(fileMenu); // and add to our menu bar

      resetItem = new JMenuItem("Reset"); // create a menu item called "Reset"
      fileMenu.add(resetItem); // and add to our menu

      quitItem = new JMenuItem("Quit"); // create a menu item called "Quit"
      fileMenu.add(quitItem); // and add to our menu
      
      //ADDED
      clearItem = new JMenuItem("Clear"); // create a "Clear" item
      fileMenu.add(clearItem); // added to menu
      
      // this allows us to use shortcuts (e.g. Ctrl-R and Ctrl-Q)
      final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(); // to save typing
      resetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, SHORTCUT_MASK));
      quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
      clearItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, SHORTCUT_MASK)); // ADDED for Ctrl-C
      
      // listen for menu selections
      resetItem.addActionListener(this); 
      clearItem.addActionListener(this); // ADDED: register "Clear"
      
      quitItem.addActionListener(new ActionListener() // create an anonymous inner class
        { // start of anonymous subclass of ActionListener
          // this allows us to put the code for this action here  
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0); // quit
            }
        } // end of anonymous subclass
      ); // end of addActionListener parameter list and statement
      
      // Top Area (buttonPanel): buttons
      
      // The Up, Down and Reset buttons are arranged horizontally in a JPanel
      
      // ADDED: Top sub-component: buttons
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS)); // horizontal layout

      upButton = new JButton("Up");
      buttonPanel.add(upButton);

      downButton = new JButton("Down");
      buttonPanel.add(downButton);
      
      /* Initially the Down button is disabled. */
      downButton.setEnabled(false);      

      resetButton = new JButton("Reset");
      buttonPanel.add(resetButton);
      
      randomButton = new JButton("Random"); // ADDED: creates a random button
      buttonPanel.add(randomButton); // ADDED: To add random button to top sub-component

      /* Place the buttons at the top. */
      contentPane.add(buttonPanel); // CHANGED top sub-component
      
      //Middle sub-component. ADDED
      JPanel middlePanel = new JPanel(); 
      middlePanel.setLayout(new BorderLayout());
      
      // add a label
      JLabel label = new JLabel("Counter Value: ");
      label.setHorizontalAlignment(JLabel.RIGHT); // right justified
      middlePanel.add(label, BorderLayout.WEST); // CHANGHED add label to middle panel
      
      // Middle area (counterDisplay): current counter value
      counterDisplay = new JTextField(5); // text field is 5 characters wide
      counterDisplay.setEditable(false); // we cannot edit this field
      counterDisplay.setFont(new Font(null, Font.BOLD, 18)); // bold 18pt font
      counterDisplay.setHorizontalAlignment(JTextField.RIGHT); // right justified
      middlePanel.add(counterDisplay, BorderLayout.EAST); // CHANGED display to middle panel
      
      //ADDED middle sub-component
      contentPane.add(middlePanel);
      
      /* Update the view to reflect the initial state of the model. */
      counterDisplay.setText("" + count); 
      
      // register buttons as listeners
      upButton.addActionListener(this); 
      downButton.addActionListener(this);
      resetButton.addActionListener(this);  
      
      randomButton.addActionListener(this); // ADDED: listener for Random button
      
      // Add a scrollable JTextArea (i.e. put it in a JScrollPane)
      // and use it to display the history
      
      history = new JTextArea(20,10);
      JScrollPane pane = new JScrollPane(history); // put text area in a scroll pane
      contentPane.add(pane); // CHANGED bottom sub-component
      history.append("\nThe counter value is: " + count);
      history.setCaretPosition(history.getDocument().getLength()); // move cursor to end

      // finish setting up the frame
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // exit when we hit the "X"
      frame.pack(); // pack everthing into our frame
      frame.setResizable(false); // CHANGED to make window non resizable
      frame.setVisible(true); // it's visible
   }
   
   /** 
    * This action listener is called when the user clicks on 
    * any of the GUI's buttons. 
    * 
    * @param e The action event
    */
    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource(); // get the action 
        boolean updated = false; 
        
        // see if it's a JButton
        if (o instanceof JButton) 
        {
            JButton button = (JButton)o;
            if (button == downButton) 
            { // decrement
                count--;
            } 
            else if (button == upButton) 
            { // increment
                count++;
            } 
            else if (button == resetButton) 
            { // reset
                count = RESET_TO;
            } 
            else if (button == randomButton) 
            { //ADDED: Random 
                count = MINIMUM + (int)(Math.random() * (MAXIMUM - MINIMUM + 1));
            }
        } 
        else 
        { 
            // it's a JMenuItem
            JMenuItem item = (JMenuItem)o;
            
            if (item == resetItem) 
            { // reset
                count = RESET_TO;
            }
            else if (item == clearItem) 
            {
                history.setText("");
                return;
            }
        }
        // Ensure that the right buttons are enabled.
        // the down button is enabled as long as count isn't minimum, etc.
        downButton.setEnabled(count != MINIMUM);
        upButton.setEnabled(count != MAXIMUM);
        resetButton.setEnabled(count != RESET_TO);
        
        // update the display
        counterDisplay.setText("" + count); 
        
        history.append("\nThe counter value is: " + count);
        history.setCaretPosition(history.getDocument().getLength());
   }    
}