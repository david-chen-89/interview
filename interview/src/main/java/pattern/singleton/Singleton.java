package pattern.singleton;

public class Singleton {
	//1 static instance
	private static Singleton instance = null;

	//2 private construction
	private Singleton() {
	}

	//3 get method
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
