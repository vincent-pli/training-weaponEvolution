package com.pengli.weaponEvolution.player;

import com.pengli.weaponEvolution.damage.Damage;
import com.pengli.weaponEvolution.damage.PhysicDamage;

public class OrdinaryBeing extends Player {

	public OrdinaryBeing(String name, int health, int ATK) {
		super(name, health, ATK);
	}

	@Override
	protected Damage generateDamage() {
		return new PhysicDamage(this.ATK);
	}

	@Override
	public int physicHurt(int ATKHurt) {
		this.health -= ATKHurt;
		return ATKHurt;
	}

	@Override
	protected void attackInformation(Player target) {
		System.out.println(this + " attack on " + target + ".");
		
	}
	
	public String toString(){
		return "Ordinary being " + this.name;
	}

}
