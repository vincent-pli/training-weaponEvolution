package com.pengli.weaponEvolution.player;

import com.pengli.weaponEvolution.Armor;
import com.pengli.weaponEvolution.Weapon;
import com.pengli.weaponEvolution.damage.Damage;

public class Soldier extends Player {
	private Armor armor;
	private Weapon weapon;
	
	public Soldier(String name, int health, int ATK, Armor armor, Weapon weapon) {
		super(name, health, ATK);
		this.armor = armor;
		this.weapon = weapon;
	}

	@Override
	protected Damage generateDamage() {
		Damage magicDamage = this.weapon.weaponAttack();
		magicDamage.setATK(this.ATK);
		return magicDamage;
	}

	@Override
	public int physicHurt(int ATKHurt) {
		int realHurt = ATKHurt - this.armor.getDEF() > 0 ? ATKHurt - this.armor.getDEF() : 0;
		this.health -= realHurt;
		return realHurt;
	}

	@Override
	protected void attackInformation(Player target) {
		System.out.println(this + " use " + this.weapon + " attack on " + target);
		
	}
	
	public String toString(){
		return "Soldier " + this.name;
	}
}
