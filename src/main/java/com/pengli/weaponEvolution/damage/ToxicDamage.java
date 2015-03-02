package com.pengli.weaponEvolution.damage;

import com.pengli.weaponEvolution.player.Player;

public class ToxicDamage extends DelayDamage {

	public ToxicDamage(String name, int attackPercent, int point, int count) {
		super(name, attackPercent, point, count);
		super.currentEffect = " toxic";
	}

	@Override
	protected void effectDamage(Player target) {
		target.magicHurt(this.point);
		super.currentEffect = " toxic hurt " + this.point + " points";
		target.underAttackInformation(this);
		
	}

	@Override
	public void overlap(DelayDamage delayDamage) {
		this.point += delayDamage.getPoint();
		this.count += delayDamage.getCount();
	}


}
