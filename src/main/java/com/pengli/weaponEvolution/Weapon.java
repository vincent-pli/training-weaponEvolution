package com.pengli.weaponEvolution;

import java.util.List;
import java.util.Random;

import com.pengli.weaponEvolution.damage.Damage;
import com.pengli.weaponEvolution.damage.MagicDamage;

public class Weapon {
	private String name;
	private List<MagicDamage> attributes;
	
	public Weapon(String name, List<MagicDamage> attributes){
		this.name = name;
		this.attributes = attributes;
	}
	
	public Damage weaponAttack(){
		Random random = new Random();
		
		if(this.attributes.size() == 0 || this.attributes == null){
			return new MagicDamage("", 0);
		}
		
		int attackPercent = random.nextInt(100);
		for(MagicDamage magicDamage : attributes){
			if(magicDamage.couldEffected(attackPercent)){
				return (Damage) magicDamage.clone();
			}
		}
		
		return new MagicDamage("", 0);
	}
	
	public String toString(){
		return this.name;
	}
}
