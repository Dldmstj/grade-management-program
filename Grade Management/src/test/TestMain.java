package test;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.report.GenerateGradeReport;
import utils.Define;

public class TestMain {

	School goodSchool = School.getInstance();	// singletone
	Subject korean;
	Subject math;
	
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
		
		TestMain test = new TestMain();

		test.creatSubject();
		test.creatStudnet();

		String report = test.gradeReport.getReport();		// 성적 결과 생성
		System.out.println(report);		// 출력
		
	}

	// 과목 생성
	public void creatSubject() {
		
		korean = new Subject("국어", Define.KOREAN);
		math = new Subject("수학", Define.MATH);
	
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
		
	}
	
	// 학생 생성
	public void creatStudnet() {
		
		Student std1 = new Student(201833017, "짱구", korean);
		Student std2 = new Student(201833018, "맹구", math);
		Student std3 = new Student(201833019, "철수", korean);
		Student std4 = new Student(201833020, "훈이", math);
		Student std5 = new Student(201833021, "유리", korean);
		
		goodSchool.addStudent(std1);
		goodSchool.addStudent(std2);
		goodSchool.addStudent(std3);
		goodSchool.addStudent(std4);
		goodSchool.addStudent(std5);		// shcool 에 학생 add, 학교에서 관리하는 학생 명단
		
		korean.register(std1);
		korean.register(std2);
		korean.register(std3);
		korean.register(std4);
		korean.register(std5);		// korean 에 학생 add , korean 수강신청
		
		math.register(std1);
		math.register(std2);
		math.register(std3);
		math.register(std4);
		math.register(std5);		// math 에 학생 add , math 수강신청
		
		addScoreForStudent(std1, korean, 95);
		addScoreForStudent(std1, math, 56);
		
		addScoreForStudent(std2, korean, 95);
		addScoreForStudent(std2, math, 95);
		
		addScoreForStudent(std3, korean, 100);
		addScoreForStudent(std3, math, 88);
		
		addScoreForStudent(std4, korean, 89);
		addScoreForStudent(std4, math, 95);
		
		addScoreForStudent(std5, korean, 85);
		addScoreForStudent(std5, math, 56);
		
	}
	
	// 과목별 성적 입력하는 메서드
	public void addScoreForStudent(Student student, Subject subject, int point) {
		
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
	}
}
