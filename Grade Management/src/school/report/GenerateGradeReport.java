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
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이름  |  학번  |  전공  | 점수   \n";
	public static final String LINE = " ------------------------------------\n";
	private StringBuffer buffer = new StringBuffer();	// StringBuffer로 연결
	
	public String getReport() {		// Report 출력하는 메서드
		ArrayList<Subject> subjectList = school.getSubjectList();	// 모든 과목에 대한 학점 산출
		for( Subject subject : subjectList ) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
	}
		return buffer.toString();		// String으로 변환
	}
	
	public void makeHeader(Subject subject) {
		buffer.append(LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(TITLE);
		buffer.append(HEADER);
		buffer.append(LINE);
			
	}
	
	public void  makeBody(Subject subject) {
		
		ArrayList<Student> studentList = subject.getStudentList();		// 각 과목의 학생 리스트
		
		for(int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append("  |  ");
			buffer.append(student.getStudentId());
			buffer.append("  |  ");
			buffer.append(student.getMajorSubject().getSubjectName());
			buffer.append("  |  ");
			
			getScoreGrade(student, subject.getSubjectId());		// 학생별 해당과목 학점 계산
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	
	public void getScoreGrade(Student student, int subjectId) {
		
		ArrayList<Score> scoreList = student.getScoreList();
		int majorId = student.getMajorSubject().getSubjectId();
		
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()};		// 학점 평가 클래스
		
		for( int i = 0; i < scoreList.size(); i++ ) {
			Score score = scoreList.get(i);
			if(score.getSubject().getSubjectId() == subjectId) {
				String grade;
				
				if(score.getSubject().getSubjectId() == majorId)	// 전공 과목인 경우
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());	// SAB 평가방법
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
