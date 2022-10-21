package gamelevel;

public abstract class PlayerLevel {
	// 추상 메서드는 반드시 구현을 해주세요, 강제성을 부여.
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	
	// 템플릿 메서드, go 메서드, 매개변수 count 가 들어고,
	// run(), 반복문으로 해당 jump, turn.
	final public void go(int count)
	{
		run();
		for(int i=0; i<count; i++){
			jump();
		}
		turn();
	}
}
