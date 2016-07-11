package pattern.structural.decorator;

public class RedShapeDecorator implements Shape {
	protected Shape shape;

	public RedShapeDecorator(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void draw() {
		shape.draw();
		this.fill();
	}

	private void fill() {
		System.out.println("fill red color");
	}
}