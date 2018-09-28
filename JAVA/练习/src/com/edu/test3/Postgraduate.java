package com.edu.test3;

/**
 * Postgraduate类
 * @author sunny
 *
 */
public class Postgraduate extends CollegeStudent {
	private String paperName;
	private Double pleaScore;
	
	public Postgraduate() {
		
	}
	public Postgraduate(Integer studentId) {
		super(studentId);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + 
				"; paperName=" + paperName +
				"; pleaScore=" + pleaScore;
	}
	
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Double getPleaScore() {
		return pleaScore;
	}
	public void setPleaScore(Double pleaScore) {
		this.pleaScore = pleaScore;
	}
}
