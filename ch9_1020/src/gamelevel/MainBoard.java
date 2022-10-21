package gamelevel;

public class MainBoard {

	public static void main(String[] args) {
		
		
		// 추상클래스 및 다형성 흐름을 간단히 요약.
		// Plater 는 이 클래스 안에 , 추상 클래스(부모) PlayerLevel를 참조형 변수 Level 선언.
		// has A 관계로 사용합니다.
		// Player 디폴트 생성자에 , 기본 BeginnerLevel 인스턴스가 생성이 됩니다.
		// 그리고 각 자식 클래스 3개 있음. BeginnerLevel, AdvancedLevel, SuperLevel
		// 3개 클래스를 공통점 자식 클래스, 그래서 부모가 추상클래스이므로, 자식은 상속을 했기 때문에,
		// 반드시 부모에서 정의한 추상메서드를 강제로 구현 합니다.
		// 반드시 구현하는 기능은 4가지
//		public abstract void run();
//		public abstract void jump();
//		public abstract void turn();
//		public abstract void showLevelMessage();
		// 템플릿 메서드는 final 표기 해서 , 변경 못하게 했고
		// go( 템플릿 메서드는) 안에 정의한 순서대로 진행이 됩니다.
		// 진행 할때 , 호출하는 메서드는 자식 메서드 입니다.(가상메서드),
		// 부모에도 있고, 자식에도 있고, (같은 메서드) 있다면, 자식을 선택한다.
		
		// 다형성 예제) // 부모클래스(타입) Level;
		// Level = new BeginnerLevel(); 사용 했습니다.
		

		Player player = new Player(); // 인스턴스 생성
		player.play(1); // Player 클래스 play 함수 실행
		AdvancedLevel aLevel = new AdvancedLevel(); // 인스턴스 생성
		player.upgradeLevel(aLevel);
		player.play(2);
		SuperLevel sLevel = new SuperLevel();
		player.upgradeLevel(sLevel);
		player.play(3);
		
	}
}
