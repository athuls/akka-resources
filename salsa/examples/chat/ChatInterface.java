package examples.chat;
public class ChatInterface {
			/*
	public static void main(String[] args) {
			String ids = ChatKt.a();
			String[] idsInput = ids.split(" ");
			Chat.main(idsInput);
	}
			*/


	public static void create(String id1, String id2) {
		Chat.main(new String[] {id1, id2});
	}
}
