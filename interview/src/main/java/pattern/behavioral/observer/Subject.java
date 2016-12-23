package pattern.behavioral.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Subject {
	private Set<Observer> observers = new HashSet<Observer>(); // collection to keep observers
	private int state;

	//methods to register and unregister observers
	public abstract void register(Observer obj);

	public abstract void unregister(Observer obj);

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void notifyAllObservers() { // !!!
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
