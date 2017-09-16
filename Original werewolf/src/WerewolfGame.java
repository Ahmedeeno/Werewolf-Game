import javax.swing.JOptionPane;


public class WerewolfGame
{
	private static int numberOfPlayers;
	static String answer;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//Scanner input = new Scanner(System.in);
		
		boolean isInput = false;
		while(!isInput)
		{
			try
			{
				
				answer = (JOptionPane.showInputDialog(null,
						"How many palyers are participating? \nMinimum number of players is 5\n\nTo end the game you can click on the \"Cancel\" button."));
				numberOfPlayers = Integer.parseInt(answer);
				if (numberOfPlayers >20 || numberOfPlayers < 5	)
					throw new Exception();
				else
				{
					isInput = true;
				}	
			}
			catch(Exception e)
			{
				if ((answer ==null)|| (answer.equals("exit"))) 
				{
					isInput = true;
				}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter a valid number from 5 - 20");
					}
					
			}
		}
		if ((answer ==null)|| (answer.equals("exit")))
		{
			JOptionPane.showMessageDialog(null, "See you next time.");
		}
		else
		{
			Moderator mod=new Moderator(numberOfPlayers);
			mod.prepareToStart();
			mod.startGame();
		}
	}

}
