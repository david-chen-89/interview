package sony;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sony.mode.Output;

public class RegexTextReplacementInFiles_pre {

	public static void process(String startingPath, String regexPattern, String replacement, String fileAcceptPattern) {

		Output output = new Output(replacement);

		Pattern pattern = Pattern.compile(regexPattern);

		File file = getFile(startingPath);

		PathMatcher pathMatcher = getPathMatcher(fileAcceptPattern);

		process(file, pattern, replacement, pathMatcher, output);

		System.out.println(output);
	}

	protected static void process(File file, Pattern pattern, String replacement, PathMatcher pathMatcher, Output output) {
		if (file == null) {
			return;
		} else if (file.isDirectory()) { // check isDirectory
			File[] subFiles = file.listFiles();
			for (File subFile : subFiles) {
				process(subFile, pattern, replacement, pathMatcher, output);
			}
			return;
		} else if (!file.isFile() || !file.canRead()) {
			System.out.println("Not a valid file: " + file.getPath());
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

	protected static File getFile(String startingPath) {
		Path path = null;
		try {
			path = Paths.get(startingPath);
		} catch (Exception e) {
			System.out.println(startingPath + " is invalid path: " + e.getMessage());
			return null;
		}
		return path.toFile();
	}

	protected static PathMatcher getPathMatcher(String fileAcceptPattern) {

		PathMatcher pathMatcher = null;
		if (fileAcceptPattern != null) {
			if (fileAcceptPattern.contains("/") || fileAcceptPattern.contains("\\")) {
				throw new RuntimeException("File name accept pattern support only file name. Can not include path!");
			}
			pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + fileAcceptPattern);
		}
		return pathMatcher;
	}

	public static void main(String[] args) {
		String startingDir = null, regexPattern = null, replacement = null, fileAcceptPattern = null;
		if (args.length >= 3) {
			startingDir = args[0];
			regexPattern = args[1];
			replacement = args[2];
		}
		if (args.length >= 4) {
			fileAcceptPattern = args[3];
		}
		if (startingDir != null) {
			process(startingDir, regexPattern, replacement, fileAcceptPattern);
		} else {
			System.out.println("Expected at least 3 parameters but got " + args.length);
		}
	}

}
