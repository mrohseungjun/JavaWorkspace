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

public class TestMain {

	//스쿨 클래스 형은 하나의 객체만 사용합니다. 싱글톤 패턴으로 하나의 인스턴스만 사용합니다.
	// 당연히 직접 접근을 해서 생성하는 것이 아니라. 해당 메서드를 호출 해서 인스턴스를 생성 및 사용.
	School goodSchool = School.getInstance(); // 정적으로 선언이 되어 있어서, 해당 클래스명으로 바로 호출 가능. 
	Subject korean; // 기본 과목은 국어, 수학만 선언. 
	Subject math;
	Subject dance;

	// gradeReport 해당 객체를 통해서 , 성적의 결과를 출력.
	// has a 관계로 다른 클래스를 가져와서 사용. 
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		TestMain test = new TestMain();
		
		// 과목 생성
		test.createSubject2();
		// 학생 추가. 2개의 메서드들은 같은 클래스 내부에 있으니, 천천히 보세요.
		test.createStudent();
		
		String report = test.gradeReport.getReport(); //성적 결과 생성
		System.out.println(report); // 출력
		
		//파일에 출력 하기. 
		try (FileWriter fw = new FileWriter("testInfo.txt")) {
			fw.write(report);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//스캐너 클래스를 이용해서, 과목 등록, 학생 등록을 파일에서 읽어서 등록하기.
		
		
		
	}
	
	public void createStudent2() throws FileNotFoundException{
		Scanner scanner = new Scanner(new FileInputStream("studentInfo.txt"));
		
		String name;
		int id;
		int koreanScore;
		int mathScore;
		int danceScore;
		int majorCode;
		
		Student student = null;
		
		while(scanner.hasNext()) {
			name = scanner.next();
			id = scanner.nextInt();
			koreanScore = scanner.nextInt();
			mathScore = scanner.nextInt();
			danceScore = scanner.nextInt();
			majorCode = scanner.nextInt();
			
			if(majorCode == Define.KOREAN) {
				student = new Student(id, name, korean);
			} else if (majorCode == Define.MATH) {
				student = new Student(id, name, math);
			} else if (majorCode == Define.DANCE) {
				student = new Student(id, name, dance);
			} else {
				System.out.println("전공 과목 오류입니다.");
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
	
	public void createSubject2() throws FileNotFoundException{
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
	
	
	//테스트 과목 생성
	public void creatSubject(){
		
		korean = new Subject("국어", Define.KOREAN);
		math = new Subject("수학", Define.MATH);
		//방송과목 추가 및 성적 평가는 70이상 이면  Pass 평가 방식 채택.
		dance = new Subject("방송댄스", Define.DANCE);
		dance.setGradeType(Define.PF_TYPE);
		
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
		// 방송댄스 과목을 과목에 등록.
		goodSchool.addSubject(dance);
	}
	
	//테스트 학생 생성
	public void createStudent(){
		// 학생 추가 요구시 아래에 추가하기. 본인이름으로 , 학번은 221102, 자기이름, 컴퓨터(과목 추가 예정), 지금은 방송댄스로 임시추가.
		Student student1 = new Student(181213, "안성원", korean  );
		Student student2 = new Student(181518, "오태훈", math  );
//		Student student3 = new Student(171230, "이동호", korean  );
//		Student student4 = new Student(171255, "조성욱", korean  );
//		Student student5 = new Student(171590, "최태평", math );
		Student student6 = new Student(221102, "오승준", dance );
		
		// 추가된 학생 등록.
		goodSchool.addStudent(student1);
		goodSchool.addStudent(student2);
//		goodSchool.addStudent(student3);
//		goodSchool.addStudent(student4);
//		goodSchool.addStudent(student5);
		goodSchool.addStudent(student6);

		// 추가한 학생이 수강한 과목은 지정 해줄 예정. 임시로, 수학, 방송댄스만 추가.

		korean.register(student1);
		korean.register(student2);
//		korean.register(student3);
//		korean.register(student4);
//		korean.register(student5);
		
		math.register(student1);
		math.register(student2);
//		math.register(student3);
//		math.register(student4);
//		math.register(student5);
		math.register(student6);
		
		// 방송 댄스를 수강한 학생은 일단은 본인만 등록. 
		dance.register(student6);
		
		// 추가한 학생의 추가한 과목에 대해서 과목 점수 입력. 
		addScoreForStudent(student6, dance, 70); 
		addScoreForStudent(student6, math, 80);
		
		addScoreForStudent(student1, korean, 95); 
		addScoreForStudent(student1, math, 56);	
		
		addScoreForStudent(student2, korean, 95); 
		addScoreForStudent(student2, math, 95);	
		
//		addScoreForStudent(student3, korean, 100); 
//		addScoreForStudent(student3, math, 88);	
//		
//		addScoreForStudent(student4, korean, 89); 
//		addScoreForStudent(student4, math, 95);	
//		
//		addScoreForStudent(student5, korean, 85); 
//		addScoreForStudent(student5, math, 56);	
	}

	//과목별 성적 입력
	public void addScoreForStudent(Student student, Subject subject, int point){
		
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
		
	}
}
