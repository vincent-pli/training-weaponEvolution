package com.pengli.weaponEvolution.damage;

import com.pengli.weaponEvolution.player.Player;

public class CritDamage extends MagicDamage{
	private int mutiple = 3;
	
	public CritDamage(String name, int attackPercent) {
		super(name, attackPercent);
	}

	@Override
	public void Damage(Player target) {
		int hurtPoint = 0;
		for(int i= 0; i < this.mutiple; i++){
			hurtPoint += target.physicHurt(this.ATK);
		}
		super.currentEffect = " CRIT, hurt " + hurtPoint + " Points.";
		target.underAttackInformation(this);
	}

}
