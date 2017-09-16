import javax.swing.JOptionPane;

public class Villager extends Role
{
	public Villager ()
	{
		setRoleTitle("Villager");		
	}
	
	public void takeAction(Player[]players,int serial)
	{
		choice = 0;
		String list = "\n";
		for (int n = 0, m=1 ; n < players.length; n++)
		{
			if ((players[n].isAlive)&&(players[n].getSerial()!= serial))
			{
				list += m + "- " + players[n].getName()+"\n";
				m++;
			}
		}
		choice = Integer.parseInt(JOptionPane.showInputDialog(null,"who do you suspect?"+ list));
		for (int n = 0 , m = 1 ; n< players.length; n++)
		{
			if ((players[n].isAlive)&&(players[n].getSerial()!= serial))
			{
				if (choice == m)
				{
					JOptionPane.showMessageDialog(null, "You chose to suspect " + players[n].getName());
					break;
				}
				m++;
			}
		}
		//return "";
	}
}
