package examples.chat;

import java.io.File
import java.io.InputStream

import examples.chat.SpeakerInterface


class SpeakerKt {
	companion object SpeakerFactory {
		fun a(server: String, name: String) : String {
			SpeakerInterface.create(server, name)
			return name;
		}		
	}
	
}

fun main(args: Array<String>) {
    println("Received name for speaker: ${args[1]} with server ${args[0]}")
    SpeakerKt.a(args[0], args[1])
}
