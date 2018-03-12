package examples.chat;
import examples.chat.ServerInterface

class ServerKt {
	companion object {
		fun run() : String {
			ServerInterface.pass_through()
			return "Server is ready";
		}
	}
}

fun main(args: Array<String>) {
    println("Started server")
    ServerKt.run()
}
