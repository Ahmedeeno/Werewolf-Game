import javax.swing.JOptionPane;

public class Werewolf extends Role
{
	public Werewolf()
	{
		setRoleTitle("Werewolf");
	}
	
	public void takeAction(Player[] players, int serial)
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
		choice = Integer.parseInt(JOptionPane.showInputDialog(null,"who do you want to eat"+ list));
		String victim = null;
		for (int n = 0 , m = 1 ; n< players.length; n++)
		{
			if ((players[n].isAlive)&&(players[n].getSerial()!= serial))
			{
				if (choice == m)
				{
					//players[n].isAlive = false;
					//victim = players[n].getRoleTitle();
					JOptionPane.showMessageDialog(null, "You killed" + players[n].getName());
					break;
				}
				m++;
			}
		}
		//return victim;
	}
}