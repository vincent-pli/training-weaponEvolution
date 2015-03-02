package com.pengli.weaponEvolution.damage;

import com.pengli.weaponEvolution.player.Player;

public class FrozenDamage extends DelayDamage{
	
	public FrozenDamage(String name, int attackPercent, int point,int count) {
		super(name, attackPercent, point, count);
		super.currentEffect = " frozed.";
	}

	@Override
	protected void effectDamage(Player target) {
		if(this.count % 2 == 0){
			target.setCouldAttack(false);
			super.currentEffect = " frozed, can not attack!";
			target.underAttackInformation(this);
		}
	}

	@Override
	public void overlap(DelayDamage delayDamage) {
		this.count += delayDamage.getCount();
	}

}
