public class Player
{
	private String name;
	private Role role;
	private int serial;
	boolean isAlive = true;
	
	public Player(String roleTitle, String name, int serial)
	{
		this.serial = serial;
		this.name = name;
		switch (roleTitle)
		{
		case "Werewolf":
			role = new Werewolf();
			break;
			
		case "Villager":
			role = new Villager();
			break;
			
		case "Seer":
			role = new Seer();
			break;
			
		}
	}
	public void setName(String name)
	{
		this.name=name;
	}
	/*
	public void setName(String name)
	{
		this.name = name;
	}
	*/
	public String getName()
	{
		return name;
	}
	
	public String getRoleTitle()
	{
		return role.getRoleTitle();
	}
	
	public void takeAction(Player [] players)
	{
		role.takeAction(players,serial);
	}
	public int getSerial()
	{
		return serial;
	}
	
	public int vote(Player[] players)
	{
		return role.vote(players,serial);
	}
}