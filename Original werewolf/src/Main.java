import javax.swing.JOptionPane;

public class Main
{
	private static int playersCount =0;
	private static String answer;
	//private static WWFrame wwFrame = new WWFrame();
	public static void main(String[] args)
	{
		launchGame();
	}
	
	public static void launchGame()
	{
		boolean isInput = false;
		while (!isInput)
		{
			try
			{		
					answer = JOptionPane.showInputDialog(null, "How many players are going to play?");
					playersCount = Integer.parseInt(answer);
					if (playersCount < 5 || playersCount > 20)
						throw new Exception();
					else
					isInput = true;
			}
			catch (Exception e)
			{
				if (answer == null)
				{
					JOptionPane.showMessageDialog(null, "See you again");
					break;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid value in the range of 5 - 20");
				}
			}		
		}
		if(answer!=null)
		{
			Moderator mod = new Moderator(playersCount);
			mod.prepareToStart();
			mod.start();			
		}
	}
}