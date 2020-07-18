import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class extends Jframe and this class a various method to create and add 
 * Jpanel, JButton, Jlabel.
 * This class has an inner Class for Action Event
 * @author (Karankumar Patel)
 * @version (6-11-2020)
 */
public class DieFrame extends JFrame
{
    // Variables for JPanel
    private JPanel MainPanel;
    private JPanel ScorePanel;
    private JPanel DicePanel;
    private JPanel ButtonPanel;
    // Variables for jLabel
    private JLabel ScoreLabel;
    private JLabel Die1Label;
    private JLabel Die2Label;
    private JLabel Die3Label;
    private JLabel PlayerTurnLabel;
    // Variables for Claculation
    private int P1Score;         // variable for player 1 score
    private int P2Score;         // variable for player 2 score
    private int P1turn = 1;      // variable for player 1 turn
    private int P2turn = 1;      // variable for player 1 turn
    private int ButtonCount = 1; // variable for counting how many times a button is clicked.

    int [][] Trials =  new int[2][3];

    private JButton TurnButton;
    
    //Die class object varaible
    private Die die1;
    private Die die2;
    private Die die3;
    private Die die;

    /**
     * Constructor of DieFrame Class
     */
    public DieFrame()
    {
        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
        createMainPanel();
        add(MainPanel);
    }

    /**
     * This is a method to create main panel
     * @param This method does not have any parameters.
     * @return this method does not return anything.
     */
    private void createMainPanel()
    {
        MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout());
        createScorePanel(); // method call to create score panel
        createDicePanel();  // method call to create dice panel
        createButtonPanel(); // method call to create button panel
        MainPanel.add(ScorePanel,BorderLayout.NORTH);
        MainPanel.add(DicePanel, BorderLayout.CENTER);
        MainPanel.add(ButtonPanel,BorderLayout.SOUTH);
    }

    /**
     * This is a method to create score panel.
     * @param This method does not have any parameters.
     * @return this method does not return anything.
     */
    private void createScorePanel()
    {
        ScorePanel = new JPanel();
        ScorePanel.setBackground(new Color(255,255,0));
        ScoreLabel = new JLabel("Player 1 Score: " + P1Score + "       Player 2 Score: " + P2Score);
        ScorePanel.add(ScoreLabel);
    }

    /**
     * This is a method to create dice panel.
     * @param This method does not have any parameters.
     * @return this method does not return anything.
     */
    private void createDicePanel()
    {
        DicePanel = new JPanel();
        DicePanel.add (Box.createRigidArea (new Dimension (0,300))); // adjusting space between Components
        DicePanel.setBackground(new Color(0,0,0));

        Die1Label = new JLabel();
        Die1Label.setIcon(die1.getPic(1)); 
        DicePanel.add(Die1Label);

        DicePanel.add (Box.createRigidArea (new Dimension (30,0))); //adjusting space between two dices;
        Die2Label = new JLabel();
        Die2Label.setIcon(die2.getPic(2));
        DicePanel.add(Die2Label);

        DicePanel.add (Box.createRigidArea (new Dimension (30,0)));
        Die3Label = new JLabel();
        Die3Label.setIcon(die3.getPic(3));
        DicePanel.add(Die3Label);
    }

    /**
     * This is a method to create button panel.
     * @param This method does not have any parameters.
     * @return this method does not return anything.
     */
    private void createButtonPanel()
    {
        ButtonPanel = new JPanel();
        PlayerTurnLabel = new JLabel(" Player 1 turn: "+ P1turn);
        ButtonPanel.add(PlayerTurnLabel);
        TurnButton = new JButton("Turn");
        ButtonPanel.add(TurnButton);
        ActionListener listener = new ButtonListener(); // creating object of ButtonListener Class
        TurnButton.addActionListener(listener);         // adding action to the button.
    } 

    /**
     * This is a inner Class the implements Action listener and has a method to add
     * action on any event when thr button is clicked.
     */
    class ButtonListener implements ActionListener
    {
        /**
         * This is a method to add action to the button when it is clicked.
         * @param This method Event paramter of ActionEvent class.
         * @return this method does not return anything.
         */
        public void actionPerformed(ActionEvent event)
        { 
            //variables for checking triplet of the player
            boolean P1Triplet = false;
            boolean P2Triplet = false;
            //if button count is odd the button is clicked for player 1.
            if(ButtonCount%2!=0)
            {
                //die is rolled and textual description is displayed in a terminal
                System.out.println(" Player 1 : \n");
                Trials[0][0] = die1.Roll();
                System.out.println(" Die 1" + "\n" + die1.toString());
                Trials[0][1] = die2.Roll();
                System.out.println(" Die 2" + "\n" + die2.toString());
                Trials[0][2] = die3.Roll();
                System.out.println(" Die 3" + "\n" +die3.toString());
                System.out.println();
                
                //Display image to label for each die with reference of roll method
                Die1Label.setIcon(die1.getPic(Trials[0][0]));
                Die2Label.setIcon(die2.getPic(Trials[0][1]));
                Die3Label.setIcon(die3.getPic(Trials[0][2]));
                PlayerTurnLabel.setText(" Player 2 turn: "+ P2turn);
                
                //checking for triplet
                if(die1.getFaceValue() == die2.getFaceValue() && die1.getFaceValue() == die3.getFaceValue() )
                {
                    P1Score = P1Score + 10;
                    P1Triplet = true;
                    ScoreLabel.setText("Player 1 Score: " + P1Score + "       Player 2 Score: " + P2Score + "   ");
                }
                P1turn++; //updating player turn
            }
            else   
            {
                // button is clicked for player 2.
                //die is rolled and textual description is displayed in a terminal
                System.out.println(" Player 2 : \n");
                Trials[1][0] = die1.Roll();
                System.out.println(" Die 1" + "\n" + die1.toString());
                Trials[1][1] = die2.Roll();
                System.out.println(" Die 2" + "\n" + die2.toString());
                Trials[1][2] = die3.Roll();
                System.out.println(" Die 3" + "\n" + die3.toString());
                //Display image to label for each die with reference of roll method
                Die1Label.setIcon(die1.getPic(Trials[1][0]));
                Die2Label.setIcon(die2.getPic(Trials[1][1]));
                Die3Label.setIcon(die3.getPic(Trials[1][2]));
                PlayerTurnLabel.setText(" Player 1 turn: "+ P1turn);
                //checking for triplet
                if(die1.getFaceValue() == die2.getFaceValue() && die1.getFaceValue() == die3.getFaceValue()  )
                {
                    P2Score = P2Score + 10;
                    P2Triplet = true;
                }
                
                P2turn++; //updating player turn
                //Calculation for Player 1 Score
                for(int i = 0 ; i< 3; i++)
                {
                    for(int j = 0; j<3; j++)
                    {
                        if(Trials[0][i] > Trials[1][j])
                        {
                            P1Score++;
                        }
                    }
                }
                //Calculation for Player 2 Score
                for(int i = 0 ; i< 3; i++)
                {
                    for(int j = 0; j<3; j++)
                    {
                        if(Trials[1][i] > Trials[0][j])
                        {
                            P2Score++;
                        }
                    }
                }
            }
            //checking if both have triplet or not
            if(P1Triplet == true && P2Triplet == true)
            {
                if(Trials[0][0] >Trials[1][0])
                {
                    P1Score+=10;
                }
                else
                {
                    P2Score+=10;
                }
            }
            ScoreLabel.setText("Player 1 Score: " + P1Score + "       Player 2 Score: " + P2Score + "   ");
            //checking if any player has score of 50 or not
            if(P1Score >= 50 || P2Score >= 50 )
            {
                TurnButton.setEnabled(false);
                JOptionPane.showMessageDialog(null,"Game Over");
                //staring new Game
                System.out.println("-----------Starting a new game--------\n");
                P1Score = 0;
                P2Score = 0;
                P1turn = 1;
                P2turn = 1;
                ButtonCount = 1;
                die1 = new Die();
                die2 = new Die();
                die3 = new Die();
                ScoreLabel.setText("Player 1 Score: " + P1Score + "       Player 2 Score: " + P2Score + "   ");
                PlayerTurnLabel.setText(" Player 1 turn: "+ P1turn);
                TurnButton.setEnabled(true);
            }
            ButtonCount++; // upadting buttoncount
        }
    }
}

