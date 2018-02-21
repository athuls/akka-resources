package examples.chat;
import examples.chat.ChatInterface

class ChatKt {
	companion object {
		fun a(id1: String, id2: String, id3: String) : String {
			ChatInterface.create(id1, id2, id3)
			return "${id1} and ${id2} and ${id3}";
		}
	}
}

fun main(args: Array<String>) {
    println("Received ids for chat: ${args[0]} and ${args[1]} and ${args[2]}")
    ChatKt.a(args[0], args[1], args[2])
}
