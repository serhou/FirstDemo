package com.bestlove.test;

/**
 * 接口和工厂：游戏的例子
 * 
 * 如果Games类表示一段复杂的代码，那么这种方式就允许你在不同类型的
 * 游戏中复用这段代码。
 * @author think
 *
 */

public class Games {

	public static void playGame(GameFactory factory) {
		Game g = factory.getGame();
		while (g.move()) {
			System.out.println("-------------");
		}
	}
	
	public static void main(String[] args) {
		playGame(new CheckersFactory());
		playGame(new ChessFactory());
	}
	
}

interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

class Checkers implements Game {
	private int moves = 0;
	private static final int MOVES = 3;
	@Override
	public boolean move() {
		System.out.println("Checkers move " + moves);
		return ++moves != MOVES;
	}
}

class CheckersFactory implements GameFactory {
	@Override
	public Game getGame() {
		return new Checkers();
	}
}

class Chess implements Game {
	private int moves = 0;
	private static final int MOVES = 4;
	@Override
	public boolean move() {
		System.out.println("Chess move " + moves);
		return ++moves != MOVES;
	}
}

class ChessFactory implements GameFactory {
	@Override
	public Game getGame() {
		return new Chess();
	}
}