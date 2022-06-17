package school.report;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {

	School school = School.getInstance();
	public static final String TITLE = " ������ ���� \t\t\n";
	public static final String HEADER = " �̸�  |  �й�  |  ����  | ����   \n";
	public static final String LINE = " ------------------------------------\n";
	private StringBuffer buffer = new StringBuffer();	// StringBuffer�� ����
	
	public String getReport() {		// Report ����ϴ� �޼���
		ArrayList<Subject> subjectList = school.getSubjectList();	// ��� ���� ���� ���� ����
		for( Subject subject : subjectList ) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
	}
		return buffer.toString();		// String���� ��ȯ
	}
	
	public void makeHeader(Subject subject) {
		buffer.append(LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(TITLE);
		buffer.append(HEADER);
		buffer.append(LINE);
			
	}
	
	public void  makeBody(Subject subject) {
		
		ArrayList<Student> studentList = subject.getStudentList();		// �� ������ �л� ����Ʈ
		
		for(int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append("  |  ");
			buffer.append(student.getStudentId());
			buffer.append("  |  ");
			buffer.append(student.getMajorSubject().getSubjectName());
			buffer.append("  |  ");
			
			getScoreGrade(student, subject.getSubjectId());		// �л��� �ش���� ���� ���
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	
	public void getScoreGrade(Student student, int subjectId) {
		
		ArrayList<Score> scoreList = student.getScoreList();
		int majorId = student.getMajorSubject().getSubjectId();
		
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()};		// ���� �� Ŭ����
		
		for( int i = 0; i < scoreList.size(); i++ ) {
			Score score = scoreList.get(i);
			if(score.getSubject().getSubjectId() == subjectId) {
				String grade;
				
				if(score.getSubject().getSubjectId() == majorId)	// ���� ������ ���
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());	// SAB �򰡹��
				else
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");
				
			}
		}
	}
	
	public void makeFooter() {
		buffer.append("\n");
	}
}
