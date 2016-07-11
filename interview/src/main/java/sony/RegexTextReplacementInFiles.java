package sony;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import sony.mode.Output;

public class RegexTextReplacementInFiles {

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
			List<ProcessThread> threadList = new ArrayList<ProcessThread>();
			for (File subFile : subFiles) {
				if (subFile.isDirectory()) {
					process(subFile, pattern, replacement, pathMatcher, output);
				} else {
					//thread to improve performance
					ProcessThread td = new ProcessThread(subFile, pattern, replacement, pathMatcher);
					threadList.add(td);
					td.start();
				}
			}

			for (ProcessThread td : threadList) {
				try {
					td.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Output out = td.getOutput();
				mergeOutput(output, out);
			}
			return;
		} else {
			ProcessThread td = new ProcessThread(file, pattern, replacement, pathMatcher);
			td.start();
			try {
				td.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Output out = td.getOutput();
			mergeOutput(output, out);
		}
	}

	/**
	 * values of chg are added to output 
	 * @param output
	 * @param chg
	 */
	private static void mergeOutput(Output output, Output chg) {
		output.addFilesNumber(chg.getFilesNumber().get());

		for (Entry<String, Integer> entity : chg.getMatches().entrySet()) {
			if (output.getMatches().containsKey(entity.getKey())) {
				output.getMatches().put(entity.getKey(), entity.getValue() + output.getMatches().get(entity.getKey()));
			} else {
				output.getMatches().put(entity.getKey(), entity.getValue());
			}
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
