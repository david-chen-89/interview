package lambda;

import java.util.ArrayList;
import java.util.List;

public class First {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");
		new Thread(() -> {
			System.out.println("Run!");
		}).start();

		copy(names, names);
	}

	public static <T> void copy(List<T> dest, List<? extends T> src) {
		// ...
	}
}
