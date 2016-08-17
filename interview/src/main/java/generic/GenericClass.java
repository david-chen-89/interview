package generic;

public abstract class GenericClass<E> {

	public E get() {
		return null;
	}

	public abstract <T> T setAndGet(T t);

	public void setE(E t) {

	}
}
