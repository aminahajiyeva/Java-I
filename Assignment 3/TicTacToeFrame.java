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
 * @version April 2025
 */

public class TicTacToeFrame extends TicTacToe 
{
    private JTextArea status; // text area to print game status
    /**
     * Constructs a new Tic-Tac-Toe board and sets up the JFrame.
     */
    public TicTacToeFrame() 
    {
        super();

        //make new frame
        JFrame frame = new JFrame("TicTacToe Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //add menu bar
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar); // add to frame

        JMenu fileMenu = new JMenu("Options"); // create menu
        menubar.add(fileMenu);

        JMenuItem newItem = new JMenuItem("New Game"); // create "New Game"
        fileMenu.add(newItem);
        JMenuItem quitItem = new JMenuItem("Quit"); // create "Quit"
        fileMenu.add(quitItem);

        // menu shortcuts added
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, SHORTCUT_MASK));
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));

        // menu items listeners
        newItem.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    emptyBoard();
                }
            }
        );

        quitItem.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    System.exit(0);
                }
            }
        );

        // make 3x3 grid layout for the buttons
        JPanel panel = new JPanel(new GridLayout(3, 3));

        // make buttons array and add it to the grid
        for (int row = 0; row < 3; row++) 
        {
            for (int col = 0; col < 3; col++) 
            {
                JButton button = new JButton(); // create a button
                board[row][col] = button;
                button.setPreferredSize(new Dimension(100, 100)); // size
                button.setBorderPainted(true);

                final int r = row, c = col;
                button.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent e) 
                        {
                            click(r, c, button);
                        }
                    }
                );
                
                // add button
                panel.add(button);
            }
        }
        
        // add in grid of buttons to frame
        frame.add(panel, BorderLayout.SOUTH);

        // create and add in label field
        status = new JTextArea("X's turn.");
        // change text size and font
        Font font = new Font( "Monospaced", Font.PLAIN, 30 );

        status.setFont(font);
        status.setEditable(false);
        frame.add(status, BorderLayout.NORTH);

        // make frame visible and organize it
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Updates the game once a button has been clicked
     *
     * @param row The row of the button (0 to 2)
     * @param col The column of the button (0 to 2)
     * @param button The button being clicked
     */
    private void click(int row, int col, JButton button) 
    {
        numFreeSquares--; // decrement

        // set the text that is on the button to the current player 
        button.setText(print_text());
        // change the font
        button.setFont(new Font("Monospaced", Font.PLAIN, 40));
        // no longer clickable
        button.setEnabled(false);

        // update the board
        super.board[row][col].setText(print_text());
        playGame(row, col);

        if (haveWinner(row, col)) 
        { 
            // game over if winner or tie
            status.setText(print_text() + " wins!");

            for (int i = 0; i < 3; i++) 
            {
                for (int j = 0; j < 3; j++) 
                {
                    board[i][j].setEnabled(false); //disable the buttons at end
                }
            }
        }
        else 
        { 
            //update the game if it isnt over
            if (numFreeSquares == 0 && winner.equals(TIE)) 
            {
                status.setText("It is a tie!");
                return;
            }
            updateGame();
            status.setText(print_text() + "'s turn.");
        }
    }

    /**
     * Clears the text on all the buttons. Resets the text to the first player's turn (X)
     */
    public void emptyBoard() 
    {
        clearBoard(); // clear the board
        
        for (int row = 0; row < 3; row++) 
        {
            for (int col = 0; col < 3; col++) 
            {
                board[row][col].setText(""); // clear 
                board[row][col].setEnabled(true);
            }
        }
        status.setText("X's turn.");
    }
}