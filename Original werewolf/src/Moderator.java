import java.util.Random;
import javax.swing.JOptionPane;
public class Moderator
{
	private static String roles[];
	private static Random random = new Random();
	private static int numberOfPlayers;
	private static Player [] players;
	private static int numberOfWerewolves;
	private static int numberOfSeers;
	private static int numberOfVillagers;
	private static String victim;
	
	public Moderator(int numberOfPlayers)
	{
		Moderator.numberOfPlayers = numberOfPlayers;
	}
	
	public void prepareToStart()
	{
		players = new Player[numberOfPlayers];
		
		figureOutNumberOfRoles();
		createRoles();
		shuffleRoles();
		createPlayers();
	}
	
	public void createRoles()
	{
		roles = new String[players.length];
		int n = 0;
		for (int m = 1; m <= Moderator.numberOfWerewolves ; m++,n++ )
		{			
			roles[n] = "Werewolf"; 
		}
		for (int m = 1; m <= Moderator.numberOfSeers ; m++, n++ )
		{			
			roles[n] = "Seer"; 
		}
		for (int m = 1; m <= Moderator.numberOfVillagers ; m++,n++ )
		{			
			roles[n] = "Villager"; 
		}
		/*
		for (int x = 0 ; x < players.length ; x++)
		{
			JOptionPane.showMessageDialog(null,players[x].getRoleTitle());
		}
		*/
	}
	
	public void shuffleRoles()
	{
		int tempNumber;
		String tempRole = null; 
		for (int n =0; n < roles.length ; n++)
		{
			tempNumber = random.nextInt(roles.length);
			tempRole = roles[n];
			roles[n] = roles[tempNumber];
			roles[tempNumber] = tempRole;
		}	
	}
	
	public void createPlayers()
	{
		for (int n = 0 ; n < players.length; n++)
		{
			players[n] = new Player (roles[n], JOptionPane.showInputDialog("What is the player #" +(n+1) + "'s name ?"),n);
			//JOptionPane.showMessageDialog(null, roles[n]);
		}
	}
	public void figureOutNumberOfRoles()
	{
		Moderator.numberOfWerewolves = figureOutNumberOfWerewolves();
		Moderator.numberOfSeers = figureOutNumberOfSeers();
		Moderator.numberOfVillagers = figureOutNumberOfVillagers();
	}
	public int figureOutNumberOfWerewolves()
	{
		final int VILLAGERS_WEREWOLVES_RATIO = 5;
		int numberOfWerewolves = players.length/VILLAGERS_WEREWOLVES_RATIO;
		return numberOfWerewolves;
	}
	
	public int figureOutNumberOfSeers()
	{
		final int PLAYERS_SEERS_RATIO = 15;
		int numberOfSeers = random.nextInt(players.length / PLAYERS_SEERS_RATIO +2);
		return numberOfSeers;
	}
	public int figureOutNumberOfVillagers()
	{
		return (players.length - (Moderator.numberOfWerewolves + Moderator.numberOfSeers ));
	}
	
	
	public void startGame()
	{
		showRoles();
		while(!(WerewolvesWin()||(VillagersWin())))
		{
			playARound();
		}
	}
	public void showRoles()
	{
		for(int n = 0 ; n < players.length ; n++)
		{
			JOptionPane.showMessageDialog(null, "It is " + players[n].getName()+"'s turn\nif you are "+players[n].getName()+", press Enter");
			JOptionPane.showMessageDialog(null, players[n].getName()+ ", you are a/an " + players[n].getRoleTitle());
			
		}
	}
	
	public void playARound()
	{
		while(!(WerewolvesWin()||VillagersWin()))
		{
			for (int n = 0 ; n < players.length ; n++)
			{
				if(players[n].isAlive)
				{
					JOptionPane.showMessageDialog(null, "It is "+players[n].getName()+"'s turn");
					players[n].takeAction(players);
					if(WerewolvesWin()||VillagersWin())
						break;
				}
			}
			if(WerewolvesWin()||VillagersWin())
				break;
			for (int n = 0 ; n < players.length ; n++)
			{
				if(players[n].isAlive)
				{
					JOptionPane.showMessageDialog(null, "It is "+players[n].getName()+"'s turn");
					JOptionPane.showMessageDialog(null, players[players[n].vote(players)].getName());
				}
			}
		}
		if(WerewolvesWin())
			JOptionPane.showMessageDialog(null, "Werewolves team win");
		else if (VillagersWin())
			JOptionPane.showMessageDialog(null,  "Villagers team win");
				
	}
	
	public boolean WerewolvesWin()
	{
		int WerewolvesAlive=0;
		int VillagersAlive=0;
		for (int n =0; n < players.length ; n++)
		{
			if (players[n].getRoleTitle()== "Werewolf")
				WerewolvesAlive++;
			else if (players[n].isAlive)
				VillagersAlive++;
		}
		if (WerewolvesAlive >= VillagersAlive)
			return true;
		else
			return false;
	}
	
	public boolean VillagersWin()
	{
		int WerewolvesAlive = 0 ;
		for (int n =0; n < players.length ; n++)
		{
		if (players[n].getRoleTitle()== "Werewolf")
			WerewolvesAlive++;
		}
		if (WerewolvesAlive == 0)
			return true;
		else
			return false;
	}
	/*
	public void assignNames()
	{
		int n = 1;
		//JOptionPane.showMessageDialog(null,players.length);
		for (Player p : players)
		{
			p.setName(JOptionPane.showInputDialog(null,"what is the player# "+n+"'s name "));
			n++;
		}
		for (Player p : players)
			{
				JOptionPane.showMessageDialog(null,p.getName());
			}
	}
	*/
}
