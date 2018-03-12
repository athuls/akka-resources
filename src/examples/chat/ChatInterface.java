package examples.chat;
public class ChatInterface {
	public static void pass_through(String speaker1, String speaker2, String speaker3) {
		Chat.main(new String[] {speaker1, speaker2, speaker3});
	}
}
