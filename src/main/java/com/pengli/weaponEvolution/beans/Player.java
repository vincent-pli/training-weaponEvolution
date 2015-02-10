package com.pengli.weaponEvolution.beans;

import com.pengli.weaponEvolution.Game;

public class Player implements Runnable{
	protected String name;
	protected int health;
	protected int ATK;
	protected boolean isAlive = true;
	protected Player enemy;
	
	public Player(String name, int health, int ATK){
		this.name = name;
		this.health = health;
		this.ATK = ATK;
	}
	
	public void run() {
		this.begin();
		
	}

	public void underAttack(int enemyATK){
		int ATKPoints = getHurtPoints(enemyATK);
		this.health -= ATKPoints;
		if(this.health <= 0){
			this.isAlive = false;
		}
		underAttackPrint(enemyATK);
	}
	
	private void begin(){
		while(this.isAlive && this.enemy.isAlive){
			synchronized(Game.lock){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				this.attack();
				Game.lock.notify();
				try {
					Game.lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void attack(){
		this.attackPrint();
		this.enemy.underAttack(this.ATK);
	}
	
	protected void attackPrint(){
		System.out.println("Ordinary being " + this.name + " attack");
	}
	
	protected void underAttackPrint(int enemyATK){
		if(!this.isAlive){
			System.out.println(this.name + " is defeated.");
		}
		else{
			System.out.println("Ordinary being " + this.name + " under attack, " + " and lost " + getHurtPoints(enemyATK) + " health points, " + "remained " + this.health + " points");
		}
	}
	
	protected int getHurtPoints(int enemyATK){
		return enemyATK;
	}

	public Player getEnemy() {
		return enemy;
	}

	public void setEnemy(Player enemy) {
		this.enemy = enemy;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getATK() {
		return ATK;
	}
	
}
