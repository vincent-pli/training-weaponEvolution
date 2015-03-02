package com.pengli.weaponEvolution.damage;

import com.pengli.weaponEvolution.player.Player;

public class MagicDamage extends Damage {
	protected String name;
	protected int attackPercent;
	
	public MagicDamage(String name, int attackPercent) {
		super(0);
		this.name = name;
		this.attackPercent = attackPercent;
	}
	
	public boolean couldEffected(int effectPercent){
		if(this.attackPercent >= effectPercent){
			return true;
		}
		return false;
	}

	@Override
	public void Damage(Player target) {
		super.Damage(target);
	}

	public String getName() {
		return name;
	}
}
