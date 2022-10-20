package ch5_1018;

public class Student {
	static int stuNo; // 1번
	String stuName; // 이상용
	String stuClass; // 402호
	String stuHome; // 부산 강서구
	
	
	
	
	
	
	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getStuHome() {
		return stuHome;
	}

	public void setStuHome(String stuHome) {
		this.stuHome = stuHome;
	}
	
	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	
	public void studySub(String stuName) {
		System.out.println(stuName +" 자바 공부중.");
	}
	
	
	public static void main(String[] args) {
		// 여러분은 직접 본인들의 아이디의 이니셜로 해당 참조형변수 ( 인스턴스) 만들기.
		// 해당 값을 설정은, 번호, 이름 직접 설정하고 , 클래스랑, 집은 set 함수를 통해서 만들기.
		// 해당 값을 출력 할 떼 , 번호 , 이름, 직접 출력학, 클래스랑 ,집은 get 함수를 통해서 출력 해보기.
		
		
		
		Student lsy = new Student();
		Student.stuNo = 1;
		lsy.stuName = "이상용";
		lsy.studySub("이상용은"); 
		System.out.println("해당 학생증 번호를 get 메서드를 통해서 접근해서 출력");
		lsy.setStuNo(3);
		System.out.println("해당 학생증 번호를 직접 접근해서 출력");
		System.out.println(Student.stuNo);
		
		
		Student lsy2 = new Student(); // 이상용2 번 학생의 학생 번호를 번을 set 메서드를 통해서 지정.
		lsy2.setStuNo(2);
		System.out.println("해당 학생증 번호를 get 메서드를 통해서 접근해서 출력");
		System.out.println(lsy2.getStuNo());
		
		Student lsy3 = new Student();
		lsy3.stuNo = 3;
		lsy3.stuName = "오승준";
		lsy3.setStuClass("402 강의장");
		lsy3.setStuHome("부산시 강서구");
		System.out.println("해당 학생증 번호를 직접 접근해서 출력");
		System.out.println(lsy3.stuNo);
		System.out.println("해당 학생증 이름을 직접 접근해서 출력");
		System.out.println(lsy3.stuName);
		
		System.out.println("");
		
		
		
		System.out.println("===해당 인스턴스 (참조형 변수)를 확인 해보자 안에 뭐가 들어있는지?");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}


	
}
