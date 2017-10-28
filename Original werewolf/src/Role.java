import javax.swing.JOptionPane;
import java.util.Random;

/* a Role class to hold the role info and actions to be done by the role
 * 
 */
abstract public class Role
{
	private static String[] roles;
	private String roleTitle;
	public void setRoleTitle(String roleTitle)
	{
		this.roleTitle = roleTitle;
	}
	public String getRoleTitle()
	{
		return roleTitle;
	}
	
	public static String[] prepareRoles(int playersCount)
	{
		roles = new String[playersCount];
		for (int n = 0 ; n < playersCount ; n++)
		{
			if ((n+1) % 5 == 0)
			{
				roles[n]= "Werewolf";
			}
			else
			{
				roles[n] = "Villager";
			}
		}
		
		shuffleRoles(roles);
		return roles;
	}
	
	public static String[] shuffleRoles(String[] roles)
	{
		Random random = new Random();
		String tempRole = null;
		int rand;
		for (int n = 0 ; n < roles.length ; n++)
		{
			rand = random.nextInt(roles.length);
			tempRole = roles[n];
			roles[n] = roles[rand];
			roles[rand] = tempRole;
		}
		return roles;
	}
	
	
	abstract public int takeAction(Player[] players, int serial);
	
}
