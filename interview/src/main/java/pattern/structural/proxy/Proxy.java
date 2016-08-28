package pattern.structural.proxy;

/**
 * Proxy pattern key point is Both proxy class and source class implement the same interface. Client 
 * contact proxy to trigger source method.
 * EJB using proxy pattern
 *
 */
public class Proxy implements SourceableI {

	private Source source;

	public Proxy() {
		super();
		this.source = new Source();
	}

	@Override
	public void method() {
		before();
		source.method();
		atfer();
	}

	private void atfer() {
		System.out.println("after proxy!");
	}

	private void before() {
		System.out.println("before proxy!");
	}
}
