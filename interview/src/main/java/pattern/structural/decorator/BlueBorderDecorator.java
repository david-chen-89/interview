package pattern.structural.decorator;

public class BlueBorderDecorator implements Shape {
	protected Shape shape;

	public BlueBorderDecorator(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void draw() {
		shape.draw();
		this.border();
	}

	private void border() {
		System.out.println("paint blue border");
	}
}