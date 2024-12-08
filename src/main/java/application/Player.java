package application;

import edu.princeton.cs.algs4.Queue;

/**
 * An entity participating in the game, the user represents the main player.
 * 
 * Player is a Superclass which keeps track of various player information vital to playing 
 * Cosmic Command including a list of the bases owned, the player ID, and the name of the 
 * player, all initialized during construction. The attackBase method is how Player can attack 
 * bases from bases they own by sending troops from the attacking base to the defending 
 * base. The updateBases method clears the list of bases owned and re-adds by iterating 
 * through all the bases in the game to check if it is owned by the player's player ID. The 
 * transferTroops method is similar to attackBase, but instead of depleting troops it 
 * instead adds the troops from the attacking base to the defending base implying that the 
 * defending base is owned by the player.
 * 
 * @author Braden T
 */
public class Player {
	protected Queue<Base> basesOwned;
	private BaseStatus playerID;
	private String playerName;
	
	public Player (Base[] allBases, BaseStatus playerID, String playerName) {
		this.playerID = playerID;
		this.playerName = playerName;
		basesOwned = new Queue<>();
		updateBases(allBases);
	}
	
	public int getSize() {
		return basesOwned.size();
	}
	
	public BaseStatus getID() {
		return playerID;
	}
	
	public String getName() {
		return playerName;
	}
	
	/**
	 * Attacks a base and adds it to the list of owned bases if successful.
	 * 
	 * @param attackingBase
	 * @param defendingBase
	 * @return
	 */
	public boolean attackBase(Base attackingBase, Base defendingBase) {
		boolean successful = defendingBase.attack(attackingBase.getTroops(), playerID);
		attackingBase.setTroops(0);
		if (successful)
			basesOwned.enqueue(defendingBase);
		return successful;
	}
	
	/**
	 * Updates the list of bases owned by the player.
	 * 
	 * @param allBases
	 */
	public void updateBases(Base[] allBases) {
		while(basesOwned.size() != 0)
			basesOwned.dequeue();
		
		for (Base base : allBases)
			if (base.getStatus() == playerID)
				basesOwned.enqueue(base);
	}

	/**
	 * Transfers troops from one base to another that are owned by the player.
	 * 
	 * @param attackingBase
	 * @param defendingBase
	 */
	public void transferTroops(Base attackingBase, Base defendingBase) {
		defendingBase.setTroops(defendingBase.getTroops() + attackingBase.getTroops());
		attackingBase.setTroops(0);
	}
}
