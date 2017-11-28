package examples.chat;
import examples.chat.ChatInterface

class ChatKt {
	companion object {
		fun a(id1: String, id2: String) : String {
			ChatInterface.create(id1, id2)
			return "uan:\\\\localhost:3030\\id1 uan:\\\\localhost:3030\\id2";
		}
	}
}

fun main(args: Array<String>) {
    println("Received ids for chat: ${args[0]} and ${args[1]}")
    ChatKt.a(args[0], args[1])
}
