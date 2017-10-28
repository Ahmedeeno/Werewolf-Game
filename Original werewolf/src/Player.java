/* a player class that will hold the player 
 *information and execute the actions for their roles
 */
public class Player
{
	private String playerName;
	private Role playerRole;
	private boolean alive = true;
	private Vote vote = new Vote();
	private int serial;
	public Player(String playerName, int serial, String playerRole)
	{
		this.playerName = playerName;
		this.serial = serial;
		switch (playerRole)
		{
			case "Villager":
				this.playerRole = new Villager();
				break;
			case "Werewolf":
				this.playerRole = new Werewolf();
				break;
			case "Seer":
				this.playerRole = new Seer();
				break;
		}
	}
	public int takeAction(Player [] players)
	{
		return playerRole.takeAction(players, getSerial());
	}
	public void vote(Player[] players)
	{
		vote.vote(players, serial);
	}
	public int getSerial()
	{
		return this.serial;
	}
	public boolean isAlive()
	{
		return alive;
	}
	public String getPlayerName()
	{
		return playerName;
	}
	public void setAlive(boolean x)
	{
		this.alive = x;
	}
	public String getPlayerRole()
	{
		return playerRole.getRoleTitle();
	}
}
	