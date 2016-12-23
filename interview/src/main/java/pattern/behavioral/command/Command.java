package pattern.behavioral.command;

public class Command implements ICommand {
	@Override
	public void execute(Receiver receiver) {
		// ...
		receiver.action();
	}
}