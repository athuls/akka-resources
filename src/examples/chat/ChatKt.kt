package examples.chat;
import examples.chat.ChatInterface

class ChatKt {
	companion object {
		fun initiate_chat(speaker1: String, speaker2: String, speaker3: String) : String {
			ChatInterface.pass_through(speaker1, speaker2, speaker3)
			return "${speaker1} and ${speaker2} and ${speaker3}";
		}
	}
}

fun main(args: Array<String>) {
    println("Received ids for speakers: ${args[0]} and ${args[1]} and ${args[2]}")
    ChatKt.initiate_chat(args[0], args[1], args[2])
}
