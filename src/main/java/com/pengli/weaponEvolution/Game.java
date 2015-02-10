package com.pengli.weaponEvolution;

import com.pengli.weaponEvolution.beans.Player;
import com.pengli.weaponEvolution.beans.Solider;

public class Game {

	private Player playerZhangSan;
	private Player playerLiSi;
	public static final Object lock = new Object(); 
	
	public void initGame(){
		this.playerZhangSan = new Player("Zhang San", 100, 10);
		this.playerLiSi = new Solider("Li Si", 100, 12, 3, "sword");
		this.playerZhangSan.setEnemy(this.playerLiSi);
		this.playerLiSi.setEnemy(this.playerZhangSan);
	}
	
	public void beginGame(){
		new Thread(this.playerLiSi).start();
		new Thread(this.playerZhangSan).start();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.initGame();
		game.beginGame();
	}

}
