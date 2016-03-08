package toastGame;

/**
 * ScoreTracker keeps track of the level and score of the user in the game
 * @author YH
 *
 */
class ScoreTracker {
	private int currentScore;
	private Level currentLevel;
	
	private enum Level {
		EASY,NORMAL,HARD} 
	ScoreTracker() {
		currentScore = 0;
		currentLevel = Level.EASY;
	}
}
