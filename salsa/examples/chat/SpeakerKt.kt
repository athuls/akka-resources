package examples.chat;

import java.io.File
import java.io.InputStream

import examples.chat.SpeakerInterface


class SpeakerKt {
	companion object SpeakerFactory {
		fun a(name: String) : String {
			SpeakerInterface.create(name)
			return "John Jack";
		}		
	}
	
}

fun main(args: Array<String>) {
    //SpeakerInterface.create()
    println("Received name for speaker: ${args[0]}")
    SpeakerKt.a(args[0])
}
