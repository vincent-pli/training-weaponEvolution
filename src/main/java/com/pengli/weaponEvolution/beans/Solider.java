package com.pengli.weaponEvolution.beans;

public class Solider extends Player {
	private String weapon;
	private int DEF;
	
	public Solider(String name, int health, int ATK, int DEF, String weapon) {
		super(name, health, ATK);
		this.DEF = DEF;
		this.weapon = weapon;
	}
	
	@Override
	protected int getHurtPoints(int enemyATK){
		return (enemyATK - this.DEF < 0 ? 0 : enemyATK - this.DEF);
	}
	
	@Override
	protected void attackPrint(){
		System.out.println("Ordinary being " + this.name + " attack" + " with " + this.weapon);
	}
	
	@Override
	protected void underAttackPrint(int enemyATK){
		if(!this.isAlive){
			System.out.println(this.name + " is defeated.");
		}
		else{
			System.out.println("Ordinary being " + this.name + " under attack, " + " and lost " + getHurtPoints(enemyATK) + " health points, " + "remained " + this.health + " points");
		}
	}
	
	
}
