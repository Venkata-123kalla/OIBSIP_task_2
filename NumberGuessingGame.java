import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NumberGuessingGame extends JFrame implements ActionListener 
{
    private int randomNumber;
    private int guessesLeft;
    private JTextField guessTextField;
    private JButton guessButton;
    private JLabel messageLabel;
    private JLabel guessesLeftLabel;
	
    public NumberGuessingGame() 
	{
        super("Number Guessing Game");
        randomNumber=(int)(Math.random()*100)+1;
        guessesLeft=6;
        messageLabel=new JLabel("Try to Guess a number between 1 and 100");
        guessTextField=new JTextField(15);
        guessButton=new JButton("Guess");
        guessButton.addActionListener(this);
        guessesLeftLabel=new JLabel("Guesses left: " + guessesLeft);
        Container contentPane=getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(messageLabel);
        contentPane.add(guessTextField);
        contentPane.add(guessButton);
        contentPane.add(guessesLeftLabel);
        setSize(500,300);
        setVisible(true);
    }
	public void actionPerformed(ActionEvent e) 
	{
        if(e.getSource()==guessButton) 
		{
            try 
			{
                int guess=Integer.parseInt(guessTextField.getText());
                guessesLeft--;
                guessesLeftLabel.setText("Guesses you have left: " + guessesLeft);
                if(guess==randomNumber) 
				{
                    guessTextField.setEnabled(false);
                    guessButton.setEnabled(false);
                    messageLabel.setText("Congrats! You guessed the correct number!");

                } 
				else 
				{
                    if(guessesLeft==0) 
					{
                        guessTextField.setEnabled(false);
                        guessButton.setEnabled(false);
                        messageLabel.setText("Sorry,you have run out of guesses.The actual number was "+randomNumber+".");
                    } 
					else 
					{
                        if(guess>randomNumber) 
						{
                            messageLabel.setText("Too high.Guess again.");
                        } 
						else 
						{
                            messageLabel.setText("Too low. Guess again.");
                        }
                    }
                }
            } catch(NumberFormatException ex) 
			{
                messageLabel.setText("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) 
	{
        NumberGuessingGame game = new NumberGuessingGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
