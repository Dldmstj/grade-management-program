package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {
	
	private String subjectName;		// 과목이름
	private int subjectId;		// 과목 고유번호
	private int garadeType;		// 과목 평가방법
	
	// 수강 신청한 학생 리스트
	// register() 메서드 호출하면 리스트에 추가됨
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Subject(String subjectName, int subjectId, int gradeType) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.garadeType = Define.AB_TYPE;		// A,B 타입 평가방식
	}

	public void register(Student student) {		// 수강신청
		studentList.add(student);
	}
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGaradeType() {
		return garadeType;
	}

	public void setGaradeType(int garadeType) {
		this.garadeType = garadeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	

}
