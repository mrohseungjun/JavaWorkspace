package studentInfoEx.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import studentInfoEx.school.School;
import studentInfoEx.school.Score;
import studentInfoEx.school.Student;
import studentInfoEx.school.Subject;
import studentInfoEx.school.report.GenerateGradeReport;
import studentInfoEx.utils.Define;

public class GradeTest {
	
	School goodSchool = School.getInstance();
	Subject korean;
	Subject math;
	Subject dance;
	Define define;

	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) throws FileNotFoundException {

		GradeTest test = new GradeTest();
		test.creatSubject2();
		test.createStudent();
		
		String report = test.gradeReport.getReport(); //성적 결과 생성
		System.out.println(report); // 출력	
		
		try(FileWriter fw = new FileWriter("resultInfo.txt ")) {
			fw.write(report);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void creatSubject2()throws FileNotFoundException{
		
		Scanner scanner = new Scanner(new FileInputStream("subjectInfo.txt"));
		String subjectFirstSpell;
		String subjectName;
		int subjectId;
		
		Subject subject = null;
		
		while(scanner.hasNext()) {
			subjectFirstSpell = scanner.next();
			subjectName = scanner.next();
			subjectId = scanner.nextInt();
			
			if(subjectFirstSpell.equals("K")) {
				korean = new Subject(subjectName,subjectId);
				goodSchool.addSubject(korean);
			} else if(subjectFirstSpell.equals("M")) {
				math = new Subject(subjectName,subjectId);
				goodSchool.addSubject(math);
			} else if(subjectFirstSpell.equals("D")) {
				dance = new Subject(subjectName,subjectId);
				dance.setGradeType(Define.PF_TYPE);
				goodSchool.addSubject(dance);
			} else {
				System.out.println("아직 미개설 과목입니다.");
				return;
			}
			
		}
		scanner.close();
	}
	
	public void createStudent() throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new FileInputStream("studentinfo.txt"));
		
		String name;
		int id;
		int koreanScore;
		int mathScore;
		int danceScore;
		int majorCode;
		
		
		Student student = null;
		
		while(scanner.hasNextLine()) {
			
			name = scanner.next();
			id = scanner.nextInt();
			koreanScore = scanner.nextInt();
			mathScore = scanner.nextInt();
			danceScore = scanner.nextInt();
			majorCode = scanner.nextInt();
			
			
			if(majorCode == Define.KOREAN) {
				student = new Student(id, name, korean );
			}
			else if(majorCode == Define.MATH) {
				student = new Student(id, name, math );
			}
			else if (majorCode == Define.DANCE) {
				student = new Student(id, name, dance);
			} 
			else {
				System.out.println("전공 과목 오류 입니다");
				return;
			}
			
			goodSchool.addStudent(student);
			korean.register(student);
			math.register(student);
			dance.register(student);
			addScoreForStudent(student, korean, koreanScore);
			addScoreForStudent(student, math, mathScore);
			addScoreForStudent(student, dance, danceScore);
		}
		scanner.close();
	}
	
	//과목별 성적 입력
	public void addScoreForStudent(Student student, Subject subject, int point){
			
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
			
	}
}
