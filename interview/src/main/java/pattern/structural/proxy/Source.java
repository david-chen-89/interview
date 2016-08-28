package pattern.structural.proxy;

public class Source implements SourceableI {

	@Override
	public void method() {
		System.out.println("the original method!");
	}
}
