package pattern.structural.decorator;

public class RedShapeDecorator implements ShapeI {
	protected ShapeI shape;

	public RedShapeDecorator(ShapeI shape) {
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