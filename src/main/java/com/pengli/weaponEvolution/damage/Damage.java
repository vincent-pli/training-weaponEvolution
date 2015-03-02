package com.pengli.weaponEvolution.damage;

import com.pengli.weaponEvolution.player.Player;

public abstract class Damage implements Cloneable{
	protected int ATK;
	protected String currentEffect = "";
	
	public Damage(int ATK){
		this.ATK = ATK;
	}
	
	public void Damage(Player target){
		int hurtPoint = target.physicHurt(this.ATK);
		this.currentEffect = " hurt " + hurtPoint + " points.";
		target.underAttackInformation(this);
	}
	
	public Object clone(){
		Damage damage = null;
		try {
			damage = (Damage) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return damage;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}
	
	public String toString(){
		return this.currentEffect;
	}
}
