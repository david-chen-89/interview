package pattern.structural.decorator;

public class DecoratorPatternDemo {
	public static void main(String[] args) {

		ShapeI circle = new Circle();

		ShapeI redCircle = new RedShapeDecorator(circle);

		ShapeI buleBorderRedCircle = new BlueBorderDecorator(redCircle);

		System.out.println("normal circle");
		circle.draw();

		System.out.println("\nRed Circle");
		redCircle.draw();

		System.out.println("\nBule Border of Red Circle");
		buleBorderRedCircle.draw();
	}
}
