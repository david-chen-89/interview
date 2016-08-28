package pattern.structural.decorator;

public class BlueBorderDecorator implements ShapeI {
	protected ShapeI shape;

	public BlueBorderDecorator(ShapeI shape) {
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