package pattern.creational.factory;

/**
 * Factory class
 * 
 * variation 1: instead of using parameter, create multiple methods
 * variation 2: using static method
 * 
 * @author Jingjing
 *
 */
public class ShapeFactory {
	//use getShape method to get object of type shape 
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();

		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();

		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}

		return null;
	}
}
