import javax.swing.JOptionPane;

/* A vote class. A subclass of Action
 * 
 */
public class Vote extends Action
{
	Player[] players;
	public static int [] votesOnPlayer;
	public Vote()
	{
		
	}
	public Vote(int x)
	{		
		votesOnPlayer = new int [x];
	}
	public void vote(Player[]players, int serial)
	{
		//pickTarget(players,serial);
		//JOptionPane.showMessageDialog(null,pickTarget(players,serial)+"I am here");
		//JOptionPane.showMessageDialog(null,players[pickTarget(players,serial)].getPlayerName());
		//votesOnPlayer[serial]++;
		votesOnPlayer[pickTarget(players,serial, "lynch")]++;
	}
	
	public static int getMaximumVotes()
	{
		int max = 0;
		int maxIndex = 0;
		for (int n = 0 ; n < votesOnPlayer.length ; n ++)
		{
			//JOptionPane.showMessageDialog(null, votesOnPlayer.length);
			//JOptionPane.showMessageDialog(null, votesOnPlayer[n]);
			if (max < votesOnPlayer[n])
			{
				max = votesOnPlayer[n];
				maxIndex = n;
			}
			else if (max == votesOnPlayer[n] && max > 1)
			{
				max = -1;
				maxIndex = -1;
				//System.out.println("I was herer");
				return -1;
			}
		}
		//JOptionPane.showMessageDialog(null, maxIndex);
		return maxIndex;
	}
	public static void resetVotes()
	{
		for (int n = 0 ; n < votesOnPlayer.length ; n++ )
		{
			votesOnPlayer[n] = 0;
		}
	}
}