package pattern.structural.adapter;

/**
 * useful to reuse legacy library
 * @author Jingjing
 *
 */
public class AapterPlayer implements NewPlayer {

	private OldPlayerImpl player = new OldPlayerImpl();

	@Override
	public void play(String fileName) {
		player.playSong(fileName);
	}
}