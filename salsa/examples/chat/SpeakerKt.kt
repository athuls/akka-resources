package examples.chat;

import java.io.File
import java.io.InputStream

import examples.chat.SpeakerInterface


class SpeakerKt {
	companion object SpeakerFactory {
		fun register(server: String, name: String) : String {
			SpeakerInterface.pass_through(server, name)
			return name;
		}		
	}
	
}

fun main(args: Array<String>) {
    println("Received speaker: ${args[1]} to register with server ${args[0]}")
    SpeakerKt.register(args[0], args[1])
}
