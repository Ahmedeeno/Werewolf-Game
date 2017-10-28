/* A new class
 * An action class. to do the actions done by the roles.
 */
import javax.swing.JOptionPane;
public class Action
{
	private int targetSerial;
	private int choice;
	private String caller;
	public int pickTarget(Player[] players, int serial, String caller)
	{
		this.caller = caller;
		String list="\n";
		for (int n = 0, m = 1 ; n < players.length ; n++)
		{
			if(serial != players[n].getSerial() && players[n].isAlive())
			{
				list += m + "- " +  players[n].getPlayerName() +"\n";
				m++;
			}
		}
		
		choice = Integer.parseInt(JOptionPane.showInputDialog(null, players[serial].getPlayerName() + "\nWho do you want to " + caller +"\n\n"+list))	;
		for (int n = 0, m = 1 ; n < players.length ; n++)
		{
			if(serial != players[n].getSerial() && players[n].isAlive())
			{
				if (m == choice)
				{
					return players[n].getSerial();					
				}
				m++;
			}
		}
		return 0 ;
	}
}