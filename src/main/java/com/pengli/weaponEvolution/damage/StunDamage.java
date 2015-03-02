package com.pengli.weaponEvolution.damage;

import com.pengli.weaponEvolution.player.Player;

public class StunDamage extends DelayDamage {
	
	public StunDamage(String name, int attackPercent, int point) {
		super(name, attackPercent, point, 2);
		super.currentEffect = " stuned";
	}

	@Override
	protected void effectDamage(Player target) {
		target.setCouldAttack(false);
		super.currentEffect = " is stuned, can not attack!";
		target.underAttackInformation(this);

	}

	@Override
	public void overlap(DelayDamage delayDamage) {
		this.count += delayDamage.getCount();

	}

}
