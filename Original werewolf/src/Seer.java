/* A seer class. A subclass of Role
 * 
 */
public class Seer extends Role
{
	public Seer()
	{
		setRoleTitle("Seer");
	}
	public int takeAction(Player[] players, int serial)
	{
		return 0;
	}
}
