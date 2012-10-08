package net.jeeeyul.eclipse.themes.css;

import java.util.HashMap;
import java.util.Map;

public class ChromeResourceURI {
	private static final String PREFIX = "chrome://";

	private String command;
	private Map<String, String> arguments;

	public ChromeResourceURI() {
		arguments = new HashMap<String, String>();
	}

	public ChromeResourceURI(String uri) {
		this();

		String substring = uri.substring(PREFIX.length());
		String[] split = substring.split("\\?");

		setCommand(split[0].trim());
		if (split[1] != null) {
			String[] pairs = split[1].split("&");
			for (String each : pairs) {
				String[] keyValue = each.split("=");
				addArgument(keyValue[0].trim(), keyValue[1].trim());
			}
		}
	}

	public void addArgument(String argName, String value) {
		arguments.put(argName, value);
	}

	public String getArgument(String argName) {
		return getArgument(argName, null);
	}

	public String getArgument(String argName, String defaultValue) {
		String result = arguments.get(argName);
		return result != null ? result : defaultValue;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
}
