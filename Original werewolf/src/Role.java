import javax.swing.JOptionPane;

abstract public class Role
{
	int choice; 
	private String roleTitle;
	
	public void setRoleTitle(String roleName)
	{
		this.roleTitle = roleName;
	}
	
	public String getRoleTitle()
	{
		return this.roleTitle;
	}
	
	public int vote(Player[] players, int serial)
	{
		int vote=0; 
		String list = "\n";
		for (int n = 0, m=1 ; n < players.length; n++)
		{
			if ((players[n].isAlive)&&(players[n].getSerial()!= serial))
			{
				list += m + "- " + players[n].getName()+"\n";
				m++;
			}
		}
		choice = Integer.parseInt(JOptionPane.showInputDialog(null,"who do you want to vote on?"+ list));
		for (int n = 0 , m = 1 ; n< players.length; n++)
		{
			if ((players[n].isAlive)&&(players[n].getSerial()!= serial))
			{
				if (choice == m)
				{
					vote = n;
				}
				m++;
			}
		}
		//JOptionPane.showMessageDialog(null, players[vote].getName());
		return vote;
		
	}
	abstract public void takeAction(Player players[], int serial);
	
}
