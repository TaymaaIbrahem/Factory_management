package model;

import java.util.Comparator;

public class CcomperitemScore implements Comparator<Deal> {
	
	private ScoreCalculator score;
	public CcomperitemScore(ScoreCalculator score) {
		this.setScore(score);
	}
	public void setScore(ScoreCalculator score) {
		this.score = score;
	}
	public ScoreCalculator getScore() {
		return score;
	}
	@Override
	public int compare(Deal o1, Deal o2) {
		// TODO Auto-generated method stub
		if(o1.GetScore(score)> o2.GetScore(score))
			return 1;
		if(o1.GetScore(score) == o2.GetScore(score))
			return 0;
		return -1;}
}


