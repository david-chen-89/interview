package pattern.structural.decorator;

public class DecoratorPatternDemo {
	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(circle);

		Shape buleBorderRedCircle = new BlueBorderDecorator(redCircle);

		System.out.println("normal circle");
		circle.draw();

		System.out.println("\nRed Circle");
		redCircle.draw();

		System.out.println("\nBule Border of Red Circle");
		buleBorderRedCircle.draw();
	}
}
