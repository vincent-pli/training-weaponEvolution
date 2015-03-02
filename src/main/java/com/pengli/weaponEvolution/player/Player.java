package com.pengli.weaponEvolution.player;

import com.pengli.weaponEvolution.damage.Damage;
import com.pengli.weaponEvolution.damage.DelayDamage;


public abstract class Player {
	protected String name;
	protected int health;
	protected int ATK;
	protected boolean alive = true;
	protected boolean couldAttack = true;
	protected DelayDamage delayDamage; 
	
	public Player(String name, int health, int ATK){
		this.name = name;
		this.health = health;
		this.ATK = ATK;
	}
	
	public void attack(Player target){
		if(this.delayDamage != null){
			if(this.delayDamage.invalid()){
				this.delayDamage = null;
			}
			else{
				delayDamage.Damage(this);
			}			
		}
		
		this.resetStatus();
		
		if(this.alive && this.couldAttack){
			this.attackInformation(target);
			target.underAttack(this.generateDamage());
		}
	}
	
	protected abstract Damage generateDamage();
	
	public void underAttack(Damage damage){
		damage.Damage(this);
		this.resetStatus();
	}
	
	private void resetStatus(){
		if(this.health <= 0){
			this.alive = false;
			this.couldAttack = false;
		}
		else{
			this.couldAttack = true;
		}
	}
	
	public abstract int physicHurt(int ATKHurt);
	
	public void magicHurt(int magicHurtPoint){
		this.health -= magicHurtPoint;
	}
	
	public boolean isAlive() {
		return alive;
	}

	protected abstract void attackInformation(Player target);
	
	public void underAttackInformation(Damage damage) {
		System.out.print(this.name + damage);
		if(this.health <= 0){
			System.out.println(" " + this.name + " is defeated.");
		}
		else{
			System.out.println(" " + this.name + " health point is " + this.health);
		}
		
	}

	public void setCouldAttack(boolean couldAttack) {
		this.couldAttack = couldAttack;
	}

	public DelayDamage getDelayDamage() {
		return delayDamage;
	}

	public void setDelayDamage(DelayDamage delayDamage) {
		this.delayDamage = delayDamage;
	}

	public String getName() {
		return name;
	}
	
}
