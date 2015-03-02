package com.pengli.weaponEvolution;

import com.pengli.weaponEvolution.player.Player;

public class Game {
	
	private Player playerA, playerB;

	public Game(Player playerA, Player playerB){
		this.playerA = playerA;
		this.playerB = playerB;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Armor shield = new Armor("NBShield", 10);
//		MagicDamage fireDamage = new FireDamage("juniorFire", 30, 5, 2);
//		MagicDamage frozenDamage = new FrozenDamage("juniorFrozen", 30, 5, 2);
//		List<MagicDamage> attributesSword = new ArrayList<MagicDamage>();
//		List<MagicDamage> attributesAxe = new ArrayList<MagicDamage>();
//		attributesSword.add(fireDamage);
//		attributesAxe.add(frozenDamage);
//		
//		Weapon fireSword = new Weapon("fireSword", attributesSword); 
//		Weapon frozenAxe = new Weapon("frozenAxe", attributesAxe); 
//		Player playerZhang = new Soldier("Zhang", 100, 20, shield, fireSword);
//		Player playerLee = new Soldier("Lee", 100, 20, shield, frozenAxe);
//		Game game = new Game(playerZhang, playerLee);
//		game.start();
		
	}


	public void start() {
		while(this.playerA.isAlive() && this.playerB.isAlive()){
			this.playerA.attack(this.playerB);
			if(this.playerB.isAlive()){
				this.playerB.attack(this.playerA);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
