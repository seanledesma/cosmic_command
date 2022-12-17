package application;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdRandom;


/**
 * An Player with some included AI capabilities to make attacking decisions.
 * 
 * Subclass of Player. Enemy includes one new field to control their difficulty when 
 * making attacking decisions. This is initialized during construction. The 
 * chooseAttackingBase method chooses which base the enemy should attack with based 
 * on which of their bases contains the most troops. The chooseDefendingBase method 
 * chooses which base the enemy should attack, randomly based on the difficulty 
 * setting. The setDifficulty method sets the difficulty which can be changed mid-game.
 * 
 * @author Braden T
 *
 */
public class Enemy extends Player {
	private double difficulty;
	
	public Enemy(Base[] allBases, BaseStatus playerID, String playerName, double difficulty) {
		super(allBases, playerID, playerName);
		this.difficulty = difficulty;
	}
	
	public Base chooseAttackingBase () {
		Base attackingBase = new Base(100);
		attackingBase.setTroops(Integer.MIN_VALUE);
		for (Base base : basesOwned)
			if (base.getTroops() > attackingBase.getTroops())
				attackingBase = base;
		return attackingBase;
	}
	
	public Base chooseDefendingBase (Graph warMap, Base[] allBases, Base attackingBase) {
		double efficientAttack = StdRandom.uniform();
		Base defendingBase;
		if (efficientAttack > difficulty) {
			defendingBase = new Base(Integer.MAX_VALUE);
			defendingBase.setTroops(Integer.MAX_VALUE);
		}
		else {
			defendingBase = new Base(Integer.MAX_VALUE);
			defendingBase.setTroops(Integer.MIN_VALUE);
		}
		for (Integer index : warMap.adj(attackingBase.getIndex()))
			if (efficientAttack > difficulty)
				if (allBases[index].getTroops() <= defendingBase.getTroops())
					defendingBase = allBases[index];
			else
				if (allBases[index].getTroops() >= defendingBase.getTroops())
					defendingBase = allBases[index];
		return defendingBase;
	}
	
	public void setDifficulty (double difficulty) {
		this.difficulty = difficulty;
	}
}
