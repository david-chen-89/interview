package sony.mode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * a thread safe class used for console output
 * 
 * @author Qiongqiong Chen
 *
 */
public class Output {
	public static final String newline = System.getProperty("line.separator");

	private AtomicInteger filesNumber = new AtomicInteger(0);
	private volatile String replacement;
	private Map<String, Integer> matches = Collections.synchronizedMap(new HashMap<String, Integer>());

	public Output(String replacement) {
		this.replacement = replacement;
	}

	public void addFilesNumber(int i) {
		filesNumber.addAndGet(i);
	}

	public void addToMatches(String s) {
		if (matches.containsKey(s)) {
			matches.put(s, matches.get(s) + 1);
		} else {
			matches.put(s, 1);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Processed ").append(filesNumber.get()).append(" files").append(newline);
		sb.append("Replaced to ").append(replacement).append(" :").append(newline);
		for (Entry<String, Integer> entry : matches.entrySet()) {
			sb.append(" * ").append(entry.getKey()).append(" : ").append(entry.getValue()).append(" occurence").append(newline);
		}
		return sb.toString();
	}

	// --------------------------- get set method ---------------------------

	public AtomicInteger getFilesNumber() {
		return filesNumber;
	}

	public void setFilesNumber(AtomicInteger filesNumber) {
		this.filesNumber = filesNumber;
	}

	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

	public Map<String, Integer> getMatches() {
		return matches;
	}

	public void setMatches(Map<String, Integer> matches) {
		this.matches = matches;
	}

}
