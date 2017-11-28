package examples.chat;

import java.util.*;

public class SpeakerInterface {
	public static void main(String[] args) {
			String namesString = SpeakerKt.a();
			String[] names = namesString.split("\\s");
			for(String name : names) {
				Speaker.main(new String[] {name});
			}
	}

	public static void create() {
		System.out.println("Called from interface");
	}
}
