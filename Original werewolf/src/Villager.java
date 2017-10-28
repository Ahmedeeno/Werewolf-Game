import javax.swing.JOptionPane;

/* A villager class. A subclass or Role
 * 
 */
public class Villager extends Role
{
	public Villager()
	{
		setRoleTitle("Villager");
	}
	public int takeAction(Player[] players, int serial)
	{
		JOptionPane.showMessageDialog(null,  players[serial].getPlayerName()+"\nNothing to do for now. Just go to sleep.");
		return 0;
	}
}
