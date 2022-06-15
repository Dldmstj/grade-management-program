package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {
	
	private String subjectName;		// �����̸�
	private int subjectId;		// ���� ������ȣ
	private int garadeType;		// ���� �򰡹��
	
	// ���� ��û�� �л� ����Ʈ
	// register() �޼��� ȣ���ϸ� ����Ʈ�� �߰���
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Subject(String subjectName, int subjectId, int gradeType) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.garadeType = Define.AB_TYPE;		// A,B Ÿ�� �򰡹��
	}

	public void register(Student student) {		// ������û
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
