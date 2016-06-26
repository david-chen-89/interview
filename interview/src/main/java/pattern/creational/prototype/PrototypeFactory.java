package pattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {
	public enum ModelType {
		movie, album;
	}

	private static Map<String, PrototypeCapable> prototypes = new HashMap<String, PrototypeCapable>();

	static {
		prototypes.put(ModelType.movie.name(), new Movie());
		prototypes.put(ModelType.album.name(), new Album());
	}

	public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
		return prototypes.get(s).clone();
	}
}
