package snakegame;


public class GameState {
	boolean playing;
	boolean scoreboard;
	boolean menu;
	boolean inGame;

	public GameState() {
		removeAllStates();
	}

	public void removeAllStates() {
		playing = false;
		scoreboard = false;
		menu = false;
		inGame = false;
	}

	public void addState(String s) {

	}

	public void setState(String s) {

	}

}