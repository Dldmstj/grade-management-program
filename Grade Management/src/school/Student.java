package school;

import java.util.ArrayList;

public class Student {

	private int studentId;		// 학번
	private String studentName;		// 이름
	private Subject magorSubject;		// 전공 과목

	//학생의 성적 리스트
	//addSubjectScore() 메서드가 호출되면 리스트에 추가됨
	private ArrayList<Score> scoreList = new ArrayList<Score>();
	
	public Student(int studentId, String studentName, Subject majorSubject) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.magorSubject = majorSubject;
	}
	
	public void addSubjectScore(Score score) {		// scoreList에 score 추가하는 메서드
		scoreList.add(score);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getMagorSubject() {
		return magorSubject;
	}

	public void setMagorSubject(Subject magorSubject) {
		this.magorSubject = magorSubject;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	
}
