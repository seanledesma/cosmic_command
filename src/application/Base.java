package application;

/**
 * A base on the map that the player and enemies are battling for.
 * 
 * A base contains it's health, status, troop count, and index which are all 
 * initialized during construction. The attack method takes the troop count 
 * that is attacking the base, and first depletes any defending troops at the base, then 
 * depletes the health of the base until either the attacking troops or the 
 * health reaches zero. If the attack is successful, then the base updates it's 
 * status to the status of the player who attacked, the base health is reset, 
 * and any remaining troops are added to the troop count. The nextGrowthCycle 
 * method increases the troops by 30, unless there are more than 300 troops or 
 * the base is unowned.
 * 
 * @author Braden T
 */
public class Base {
	private int health;
	private BaseStatus status;
	private int troopCount;
	private int index;
	
	public Base(int index) {
		this.index = index;
		this.health = 100;
		this.status = BaseStatus.UNOWNED;
	}
	
	public void setStatus (BaseStatus newBaseStatus) {
		status = newBaseStatus;
	}
	
	public void setTroops (int troops) {
		troopCount = troops;
	}
	
	public int getHealth() {
		return health;
	}
	
	public BaseStatus getStatus() {
		return status;
	}
	
	public int getTroops() {
		return troopCount;
	}
	
	public int getIndex() {
		return index;
	}
	
	/**
	 * The base takes damage from an incoming attacker, who takes over if successful.
	 * 
	 * @param dmg
	 * @param attacker
	 * @return
	 */
	public boolean attack (int dmg, BaseStatus attacker) {
		int attackingTroops = dmg;
		
		while (troopCount > 0 && attackingTroops > 0) {
			troopCount -= 1;
			attackingTroops -= 1;
		}
		while (health > 0 && attackingTroops > 0) {
			health -= 1;
			attackingTroops -= 1;
		}
		
		if (health <= 0) {
			status = attacker;
			health = 100;
			troopCount = attackingTroops;
			return true;
		}
		return false;
	}

	/**
	 * Grows the troops at the base by 30 if it is owned and not reached the cap.
	 */
	public void nextGrowthCycle() {
		if (troopCount < 300 && status != BaseStatus.UNOWNED)
			troopCount += 30;
	}
}
