package examples.chat;

import java.util.*;

public class SpeakerInterface {
	public static void pass_through(String serverName, String speakerName) {
		Speaker.main(new String[] {serverName, speakerName});
	}
}
