package examples.chat;

// Import declarations generated by the SALSA compiler, do not modify.
import java.io.IOException;
import java.util.Vector;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;

import salsa.language.Actor;
import salsa.language.ActorReference;
import salsa.language.Message;
import salsa.language.RunTime;
import salsa.language.ServiceFactory;
import gc.WeakReference;
import salsa.language.Token;
import salsa.language.exceptions.*;
import salsa.language.exceptions.CurrentContinuationException;

import salsa.language.UniversalActor;

import salsa.naming.UAN;
import salsa.naming.UAL;
import salsa.naming.MalformedUALException;
import salsa.naming.MalformedUANException;

import salsa.resources.SystemService;

import salsa.resources.ActorService;

// End SALSA compiler generated import delcarations.

import java.util.Date;
import java.sql.Timestamp;
import java.util.Map;
import java.util.HashMap;
import examples.chat.ChatMessage.MessageType;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Speaker extends UniversalActor  implements ActorService {
	public static void main(String args[]) {
		UAN uan = null;
		UAL ual = null;
		if (System.getProperty("uan") != null) {
			uan = new UAN( System.getProperty("uan") );
			ServiceFactory.getTheater();
			RunTime.receivedUniversalActor();
		}
		if (System.getProperty("ual") != null) {
			ual = new UAL( System.getProperty("ual") );

			if (uan == null) {
				System.err.println("Actor Creation Error:");
				System.err.println("	uan: " + uan);
				System.err.println("	ual: " + ual);
				System.err.println("	Identifier: " + System.getProperty("identifier"));
				System.err.println("	Cannot specify an actor to have a ual at runtime without a uan.");
				System.err.println("	To give an actor a specific ual at runtime, use the identifier system property.");
				System.exit(0);
			}
			RunTime.receivedUniversalActor();
		}
		if (System.getProperty("identifier") != null) {
			if (ual != null) {
				System.err.println("Actor Creation Error:");
				System.err.println("	uan: " + uan);
				System.err.println("	ual: " + ual);
				System.err.println("	Identifier: " + System.getProperty("identifier"));
				System.err.println("	Cannot specify an identifier and a ual with system properties when creating an actor.");
				System.exit(0);
			}
			ual = new UAL( ServiceFactory.getTheater().getLocation() + System.getProperty("identifier"));
		}
		Speaker instance = (Speaker)new Speaker(uan, ual,null).construct();
		{
			Object[] _arguments = { args };
			instance.send( new Message(instance, instance, "act", _arguments, null, null) );
		}
	}

	public static ActorReference getReferenceByName(UAN uan)	{ return new Speaker(false, uan); }
	public static ActorReference getReferenceByName(String uan)	{ return Speaker.getReferenceByName(new UAN(uan)); }
	public static ActorReference getReferenceByLocation(UAL ual)	{ return new Speaker(false, ual); }

	public static ActorReference getReferenceByLocation(String ual)	{ return Speaker.getReferenceByLocation(new UAL(ual)); }
	public Speaker(boolean o, UAN __uan)	{ super(false,__uan); }
	public Speaker(boolean o, UAL __ual)	{ super(false,__ual); }

	public Speaker(UAN __uan,UniversalActor.State sourceActor)	{ this(__uan, null,null); }
	public Speaker(UAL __ual,UniversalActor.State sourceActor)	{ this(null, __ual,null); }
	public Speaker(UniversalActor.State sourceActor)		{ this(null, null,null);  }
	public Speaker()		{  }
	public Speaker(UAN __uan, UAL __ual,Object sourceActor) {
		if (__ual != null && !__ual.getLocation().equals(ServiceFactory.getTheater().getLocation())) {
			createRemotely(__uan, __ual, "examples.chat.Speaker");
		} else {
			State state = new State(__uan, __ual);
			state.updateSelf(this);
			ServiceFactory.getNaming().setEntry(state.getUAN(), state.getUAL(), state);
			if (getUAN() != null) ServiceFactory.getNaming().update(state.getUAN(), state.getUAL());
		}
	}

	public UniversalActor construct() {
		Object[] __arguments = { };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public class State extends UniversalActor .State implements salsa.resources.ActorServiceState {
		public Speaker self;
		public void updateSelf(ActorReference actorReference) {
			((Speaker)actorReference).setUAL(getUAL());
			((Speaker)actorReference).setUAN(getUAN());
			self = new Speaker(false,getUAL());
			self.setUAN(getUAN());
			self.setUAL(getUAL());
			self.muteGC();
		}

		public State() {
			this(null, null);
		}

		public State(UAN __uan, UAL __ual) {
			super(__uan, __ual);
			addClassName( "examples.chat.Speaker$State" );
			addMethodsForClasses();
		}

		public void construct() {}

		public void process(Message message) {
			Method[] matches = getMatches(message.getMethodName());
			Object returnValue = null;
			Exception exception = null;

			if (matches != null) {
				if (!message.getMethodName().equals("die")) {activateArgsGC(message);}
				for (int i = 0; i < matches.length; i++) {
					try {
						if (matches[i].getParameterTypes().length != message.getArguments().length) continue;
						returnValue = matches[i].invoke(this, message.getArguments());
					} catch (Exception e) {
						if (e.getCause() instanceof CurrentContinuationException) {
							sendGeneratedMessages();
							return;
						} else if (e instanceof InvocationTargetException) {
							sendGeneratedMessages();
							exception = (Exception)e.getCause();
							break;
						} else {
							continue;
						}
					}
					sendGeneratedMessages();
					currentMessage.resolveContinuations(returnValue);
					return;
				}
			}

			System.err.println("Message processing exception:");
			if (message.getSource() != null) {
				System.err.println("\tSent by: " + message.getSource().toString());
			} else System.err.println("\tSent by: unknown");
			System.err.println("\tReceived by actor: " + toString());
			System.err.println("\tMessage: " + message.toString());
			if (exception == null) {
				if (matches == null) {
					System.err.println("\tNo methods with the same name found.");
					return;
				}
				System.err.println("\tDid not match any of the following: ");
				for (int i = 0; i < matches.length; i++) {
					System.err.print("\t\tMethod: " + matches[i].getName() + "( ");
					Class[] parTypes = matches[i].getParameterTypes();
					for (int j = 0; j < parTypes.length; j++) {
						System.err.print(parTypes[j].getName() + " ");
					}
					System.err.println(")");
				}
			} else {
				System.err.println("\tThrew exception: " + exception);
				exception.printStackTrace();
			}
		}

		String myName = "";
		Server server_ref;
		Map questionTimeStamp = new HashMap();
		Queue answerQueue = new LinkedList();
		ArrayList messages = new ArrayList();
		Queue messageQueue = new LinkedList();
		boolean isQuestion = false;
		public void setQuestionIdentity() {
			isQuestion = true;
		}
		public void broadcastSend(ChatMessage msg, int number_of_questions, int total_messages) {
			Date date = new Date();
			Timestamp current = new Timestamp(date.getTime());
			{
				Token token_2_0 = new Token();
				// standardOutput<-println("[Speaker Local] "+myName+": "+msg.getMsgType()+": "+msg.getMsg()+"; Timestamp: "+current)
				{
					Object _arguments[] = { "[Speaker Local] "+myName+": "+msg.getMsgType()+": "+msg.getMsg()+"; Timestamp: "+current };
					Message message = new Message( self, standardOutput, "println", _arguments, null, token_2_0 );
					__messages.add( message );
				}
				// server_ref<-broadcast(myName, msg, number_of_questions, total_messages)
				{
					Object _arguments[] = { myName, msg, number_of_questions, total_messages };
					Message message = new Message( self, server_ref, "broadcast", _arguments, token_2_0, null );
					__messages.add( message );
				}
			}
		}
		public void broadcastReceive(String speakerName, ChatMessage msg, int number_of_questions, int total_messages) throws InterruptedException{
			switch (msg.getMsgType()) {
			case QUESTION: messages.add(msg.getMsg());
Thread.sleep(200);
Date date_one = new Date();
Timestamp current_one = new Timestamp(date_one.getTime());
			{
				// standardOutput<-println("[Speaker Remote] "+speakerName+": "+msg.getMsgType()+": "+msg.getMsg()+"; Timestamp: "+current_one)
				{
					Object _arguments[] = { "[Speaker Remote] "+speakerName+": "+msg.getMsgType()+": "+msg.getMsg()+"; Timestamp: "+current_one };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
questionTimeStamp.put(msg.getMsg(), current_one);
break;			case ANSWER: if (questionTimeStamp.values().size()==number_of_questions||isQuestion) {{
				if (answerQueue.size()>0) {{
					while (answerQueue.size()>0) {
						ChatMessage chatMessage = (ChatMessage)answerQueue.remove();
						messages.add(chatMessage.getMsg());
						Thread.sleep(200);
						Date date_two = new Date();
						Timestamp current_two = new Timestamp(date_two.getTime());
						{
							// standardOutput<-println("[Speaker Remote] "+speakerName+": "+chatMessage.getMsgType()+": "+chatMessage.getMsg()+"; Timestamp: "+current_two)
							{
								Object _arguments[] = { "[Speaker Remote] "+speakerName+": "+chatMessage.getMsgType()+": "+chatMessage.getMsg()+"; Timestamp: "+current_two };
								Message message = new Message( self, standardOutput, "println", _arguments, null, null );
								__messages.add( message );
							}
						}
					}
				}
}				messages.add(msg.getMsg());
				Thread.sleep(200);
				Date date_three = new Date();
				Timestamp current_three = new Timestamp(date_three.getTime());
				{
					// standardOutput<-println("[Speaker Remote] "+speakerName+": "+msg.getMsgType()+": "+msg.getMsg()+"; Timestamp: "+current_three)
					{
						Object _arguments[] = { "[Speaker Remote] "+speakerName+": "+msg.getMsgType()+": "+msg.getMsg()+"; Timestamp: "+current_three };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}			else {{
				answerQueue.add(msg);
			}
}break;			default: messages.add(msg.getMsg());
Thread.sleep(200);
Date date_four = new Date();
Timestamp current_four = new Timestamp(date_four.getTime());
			{
				// standardOutput<-println("[Speaker Remote] "+speakerName+": "+msg.getMsgType()+": "+msg.getMsg()+"; Timestamp: "+current_four)
				{
					Object _arguments[] = { "[Speaker Remote] "+speakerName+": "+msg.getMsgType()+": "+msg.getMsg()+"; Timestamp: "+current_four };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
break;			}
		}
		public void broadcastReceiveAdvanced(String speakerName, ChatMessage msg, int number_of_questions, int total_messages) throws InterruptedException{
			switch (msg.getMsgType()) {
			case QUESTION: messageQueue.add(msg.getMsg());
Date date = new Date();
Timestamp current = new Timestamp(date.getTime());
questionTimeStamp.put(msg.getMsg(), current);
break;			case ANSWER: if (questionTimeStamp.values().size()==number_of_questions||isQuestion) {{
				if (answerQueue.size()>0) {{
					while (answerQueue.size()>0) {
						ChatMessage chatMessage = (ChatMessage)answerQueue.remove();
						messageQueue.add(chatMessage.getMsg());
					}
				}
}				messageQueue.add(msg.getMsg());
			}
}			else {{
				answerQueue.add(msg);
			}
}break;			case STATEMENT: messageQueue.add(msg.getMsg());
break;			}
			if (messageQueue.size()==total_messages) {{
				while (messageQueue.size()>0) {
					messages.add(messageQueue.remove());
					Thread.sleep(200);
				}
				Date date = new Date();
				Timestamp current = new Timestamp(date.getTime());
				{
					// standardOutput<-println("Overall Timestamp: "+current)
					{
						Object _arguments[] = { "Overall Timestamp: "+current };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				for (int i = 0; i<messages.size(); i++){
					{
						// standardOutput<-println(messages.get(i))
						{
							Object _arguments[] = { messages.get(i) };
							Message message = new Message( self, standardOutput, "println", _arguments, null, null );
							__messages.add( message );
						}
					}
				}
			}
}		}
		public void whereAmI() {
			{
				// standardOutput<-println("Speaker started with uan: "+getUAN().toString())
				{
					Object _arguments[] = { "Speaker started with uan: "+getUAN().toString() };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
		public void act(String args[]) {
			if (args.length!=2) {{
				{
					// standardOutput<-println("Usage: java -Duan=uan://hostname/place examples.chat.Speaker <serverName> <myName>")
					{
						Object _arguments[] = { "Usage: java -Duan=uan://hostname/place examples.chat.Speaker <serverName> <myName>" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				return;
			}
}			myName = args[1];
			{
				// whereAmI()
				{
					Object _arguments[] = {  };
					Message message = new Message( self, self, "whereAmI", _arguments, null, null );
					__messages.add( message );
				}
			}
			server_ref = (Server)Server.getReferenceByName(args[0]);
			{
				// server_ref<-registerUser(myName)
				{
					Object _arguments[] = { myName };
					Message message = new Message( self, server_ref, "registerUser", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
	}
}