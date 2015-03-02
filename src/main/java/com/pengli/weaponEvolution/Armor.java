package com.pengli.weaponEvolution;

public class Armor {
	protected String name;
	protected int DEF;
	
	public Armor(String name, int DEF){
		this.name = name;
		this.DEF = DEF;
	}

	public int getDEF() {
		return DEF;
	}

}
