import javax.swing.JOptionPane;

/* A werewolf class. A subclass of Role
 * 
 */
public class Werewolf extends Role
{
	Action kill = new Kill();
	public Werewolf()
	{
		setRoleTitle("Werewolf");
	}
	public int takeAction(Player [] players, int serial)
	{
		int victimSerial = kill.pickTarget(players, serial, "kill");
		//players[victimSerial].setAlive(false);
		//JOptionPane.showMessageDialog(null, players[victimSerial].getPlayerName() + " was killed");
		return victimSerial;
	}
}
