import javax.swing.JOptionPane;
public class Moderator
{
	private int aliveWerewolvesCount =0;
	private int aliveVillagersCount =0;
	private int playersCount;
	private Player players[];
	String victim; 
	int victimSerial;
	public Moderator(int playersCount)
	{
		this.playersCount = playersCount;
	}
	public int getPlayersCount()
	{
		return this.playersCount;
	}
	
	public void prepareToStart()
	{
		players = new Player[getPlayersCount()];
		String []roles = Role.prepareRoles(playersCount);
		for (int n = 0 ; n < playersCount ; n++)
		{
			players[n] = new Player(JOptionPane.showInputDialog(null, " input player # " + (n+1) +  "'s name") ,n, roles[n]);
		}
		Vote vote = new Vote(playersCount);
	}
	
	public void start()
	{
		for (int n = 0 ; n < players.length; n++)
		{
			JOptionPane.showMessageDialog(null, "If you are " + players[n].getPlayerName() + ", press OK.");
			JOptionPane.showMessageDialog(null, players[n].getPlayerName() + "\n You are a " + players[n].getPlayerRole());
		}
		while (isContinueGame())
		{
			playARound();
		}
		if(werewolvesWin())
		{
			JOptionPane.showMessageDialog(null,"werewolves team wins");
		}
		else if(villagersWin())
		{
			JOptionPane.showMessageDialog(null,"villagers team wins");
		}
	}
	
	public void playARound()
	{
		for (int n = 0 ; n < players.length ; n++)
		{
			JOptionPane.showMessageDialog(null, "If you are " + players[n].getPlayerName() + ", press OK.");

			if (players[n].isAlive())
			{
				if(players[n].getPlayerRole().equals("Werewolf"))
				{
					victimSerial = players[n].takeAction(players);
					victim = players[victimSerial].getPlayerName();
				}
				else
				{
					players[n].takeAction(players);
				}
			}
		}
		if (victimSerial != -1)
		{
			JOptionPane.showMessageDialog(null, victim + " was killed" );
			players[victimSerial].setAlive(false);
			victimSerial = -1;
		}
		if(!isContinueGame())
		{
			return;
		}
		for (int n = 0 ; n < players.length ; n++)
		{
			if (players[n].isAlive())
			players[n].vote(players);	
		}
		
		int votesResult = Vote.getMaximumVotes();
		if (votesResult == -1)
		{
			JOptionPane.showMessageDialog(null, "The villagers are confused on who to lynch so they did not lycnh anyone");
			Vote.resetVotes();
		}
		else
		{	
			JOptionPane.showMessageDialog(null, "The villagers decided to lynch "+players[Vote.getMaximumVotes()].getPlayerName());
			JOptionPane.showMessageDialog(null, players[Vote.getMaximumVotes()].getPlayerName() + " was lynched.");
			players[Vote.getMaximumVotes()].setAlive(false);
			Vote.resetVotes();
		}
		
	}
	
	public boolean isContinueGame()
	{
		if(werewolvesWin() || villagersWin())
		{
			if (werewolvesWin())
			{
				return false;
			}
			else if (villagersWin())
			{
				return false;
			}
			else
				return true;
		}
		else
		{
			return true;
		}
	}
	public boolean werewolvesWin()
	{
		countPlayers();
		
		if (aliveWerewolvesCount >= aliveVillagersCount) 
		{
			return true;
		}
		else
			{
				return false;
			}
	}
	public boolean villagersWin()
	{
		countPlayers();
		if(aliveWerewolvesCount == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void countPlayers()
	{
		aliveWerewolvesCount=0;
		aliveVillagersCount =0;
				
				for (int n = 0 ; n < players.length ; n++)
				{
					if(players[n].getPlayerRole().equals("Werewolf"))
					{
						if (players[n].isAlive())
						{
							aliveWerewolvesCount++;
						}
					}
					else
					{
						if (players[n].isAlive())
						{
							aliveVillagersCount++;
						}
					}
				}
	}
}