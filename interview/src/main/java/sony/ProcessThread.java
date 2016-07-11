package sony;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sony.mode.Output;

public class ProcessThread extends Thread {
	private Output output;

	private File file;
	private Pattern pattern;
	private String replacement;
	private PathMatcher pathMatcher;

	public ProcessThread(File file, Pattern pattern, String replacement, PathMatcher pathMatcher) {
		super();
		this.file = file;
		this.pattern = pattern;
		this.replacement = replacement;
		this.pathMatcher = pathMatcher;

		output = new Output(replacement);
	}

	@Override
	public void run() {
		if (!file.isFile() || !file.canRead()) {
			return;
		}

		//	check file name pattern
		if (pathMatcher != null) {
			if (!pathMatcher.matches(Paths.get(file.getName()))) {
				return;
			}
		}

		try {
			String content = new String(Files.readAllBytes(file.toPath()));

			Matcher matcher = pattern.matcher(content);
			boolean flag = false;
			while (matcher.find()) {
				flag = true;
				String s = matcher.group();
				output.addToMatches(s);
			}
			if (flag) {
				output.addFilesNumber(1);
				Files.write(Paths.get(file.getPath() + ".processed"), content.replaceAll(pattern.toString(), replacement).getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Output getOutput() {
		return output;
	}
}
