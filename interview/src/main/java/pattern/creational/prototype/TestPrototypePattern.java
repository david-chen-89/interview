package pattern.creational.prototype;

import pattern.creational.prototype.PrototypeFactory.ModelType;

public class TestPrototypePattern {
	public static void main(String[] args) {
		try {
			String moviePrototype = PrototypeFactory.getInstance(ModelType.movie.name()).toString();
			System.out.println(moviePrototype);

			String albumPrototype = PrototypeFactory.getInstance(ModelType.album.name()).toString();
			System.out.println(albumPrototype);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
