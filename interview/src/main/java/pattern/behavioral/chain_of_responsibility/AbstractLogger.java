package pattern.behavioral.chain_of_responsibility;

/**
 * 
 * a little bit like linked list. A method calls next element's method.
 *
 */
public abstract class AbstractLogger {

	//next element in chain or responsibility
	protected AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message) {
		write(message);

		if (nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
	}

	abstract protected void write(String message);
}
