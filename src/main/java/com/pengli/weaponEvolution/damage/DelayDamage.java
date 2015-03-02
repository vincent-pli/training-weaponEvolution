package com.pengli.weaponEvolution.damage;

import com.pengli.weaponEvolution.player.Player;

public abstract class DelayDamage extends MagicDamage {
	protected boolean delaied = false;
	protected int point;
	protected int count;
	
	public DelayDamage(String name, int attackPercent, int point, int count) {
		super(name, attackPercent);
		this.point = point;
		this.count = count;
	}

	
	@Override
	public void Damage(Player target) {
		if(!this.delaied){
			super.Damage(target);
			if(target.getDelayDamage() != null && target.getDelayDamage().equals(this)){
				target.getDelayDamage().overlap(this);
			}
			else{
				target.setDelayDamage(this);
			}
			this.delaied = true;
		}
		else{
			this.effectDamage(target);
			this.count --;
		}

	}

	protected abstract void effectDamage(Player target);
	
	public boolean invalid(){
		if(this.count == 0){
			return true;
		}
		return false;
	}
	
	public abstract void overlap(DelayDamage delayDamage);
	
	
	public int getPoint() {
		return point;
	}

	public int getCount() {
		return count;
	}

	public boolean equals(Object obj){
		if(obj == null || !(obj instanceof DelayDamage)){
			return false;
		}
		
		DelayDamage other = (DelayDamage)obj;
		if(this.name.equals(other.getName())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int hashCode(){
		return this.name.hashCode();
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
	public void setName(String name){
		super.name = name;
	}
}
