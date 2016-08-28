package pattern.structural.decorator;

public class Circle implements ShapeI {

	@Override
	public void draw() {
		System.out.println("Shape: Circle");
	}
}