package examples.chat;
import examples.chat.ServerInterface

class ServerKt {
	companion object {
		//fun a(id1: String, id2: String, id3: String) : String {
		fun a() : String {
			ServerInterface.create()
			//return "${id1} and ${id2} and ${id3}";
			return "Server is ready";
		}
	}
}

fun main(args: Array<String>) {
    //println("Received ids for chat: ${args[0]} and ${args[1]} and ${args[2]}")
    //ServerKt.a(args[0], args[1], args[2])
    ServerKt.a()
}
