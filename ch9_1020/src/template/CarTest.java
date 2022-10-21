package template;

public class CarTest {

	public static void main(String[] args) {
		
		//추가 해보기. 나만의 자동차를 만들기.
		// 추가 기능을 넣어 보기. (공통 기능과, 각차량의 기능 넣기)
		
		System.out.println("=== 자율주행 하는 자동차 ===");
		Car myCar = new AICar();
		myCar.run();
		
		System.out.println("=== 사람이 운전하는 자동차 ===");
		Car hisCar = new ManualCar();
		hisCar.run();
	}

}
