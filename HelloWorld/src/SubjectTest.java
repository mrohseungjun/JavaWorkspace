
public class SubjectTest {
public static void main(String[] args) {
		
		Student student = new Student(1, "Yoon");
		student.setKoreaSubject("국어", 100);
		student.setMathSubject("수학", 90);
		student.korea.score = 100;
		System.out.println(student.korea.score);
		student.korea.test();
		
		Student studentKim = new Student(2, "Kim");
		studentKim.setKoreaSubject("국어", 50);
		studentKim.setMathSubject("수학", 40);
		
		student.showScore();
		studentKim.showScore();
		

	}
}
