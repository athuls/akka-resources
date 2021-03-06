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
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

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

	public UniversalActor construct (String name, String serverRef) {
		Object[] __arguments = { name, serverRef };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public UniversalActor construct (String name, String speakerName, String serverRef, String logDirectory, boolean logToFile, String userPaddedString) {
		Object[] __arguments = { name, speakerName, serverRef, logDirectory, new Boolean(logToFile), userPaddedString };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
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
		Map fifoValues = new HashMap();
		Map fifoMessageValues = new HashMap();
		Map valuesAdded = new HashMap();
		File logFile;
		boolean logToFileOption = false;
		PrintWriter printWriter = null;
		void construct(String name, String serverRef){
			myName = name;
			server_ref = (Server)Server.getReferenceByName(serverRef);
						{
				// server_ref<-registerUser(myName)
				{
					Object _arguments[] = { myName };
					Message message = new Message( self, server_ref, "registerUser", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
		public void setQuestionIdentity() {
			isQuestion = true;
		}
		public void broadcastSend(String msg, boolean is_statement, boolean is_question, boolean is_answer, int number_of_questions, int total_messages, boolean fifo) {
			Date date = new Date();
			Timestamp current = new Timestamp(date.getTime());
			String type = "";
			if (is_statement) {type = "STATEMENT";
}			else {if (is_question) {type = "QUESTION";
}			else {if (is_answer) {type = "ANSWER";
}}}			printWriter.println("[Speaker Local] "+myName+": "+type+": "+msg+"; Timestamp: "+current);
			printWriter.flush();
			{
				Token token_2_0 = new Token();
				// standardOutput<-println("[Speaker Local] "+myName+": "+type+": "+msg+"; Timestamp: "+current)
				{
					Object _arguments[] = { "[Speaker Local] "+myName+": "+type+": "+msg+"; Timestamp: "+current };
					Message message = new Message( self, standardOutput, "println", _arguments, null, token_2_0 );
					__messages.add( message );
				}
				// server_ref<-broadcast(myName, msg, type, number_of_questions, total_messages, fifo)
				{
					Object _arguments[] = { myName, msg, type, number_of_questions, total_messages, fifo };
					Message message = new Message( self, server_ref, "broadcast", _arguments, token_2_0, null );
					__messages.add( message );
				}
			}
		}
		public void broadcastReceive(String speakerName, String msg, String type, int number_of_questions, int total_messages, boolean fifo) throws InterruptedException{
			switch (type) {
			case "QUESTION": 			{
				Token token_2_0 = new Token();
				// handleFifoCode(speakerName, msg, type, true)
				{
					Object _arguments[] = { speakerName, msg, type, true };
					Message message = new Message( self, self, "handleFifoCode", _arguments, null, token_2_0 );
					__messages.add( message );
				}
				// handleNormalStall(speakerName, number_of_questions, total_messages)
				{
					Object _arguments[] = { speakerName, number_of_questions, total_messages };
					Message message = new Message( self, self, "handleNormalStall", _arguments, token_2_0, null );
					__messages.add( message );
				}
			}
break;			case "ANSWER": double number_users = (total_messages+number_of_questions)/number_of_questions;
double total_questions = number_users*0.2*number_of_questions;
if (questionTimeStamp.values().size()==total_questions||(isQuestion&&questionTimeStamp.values().size()==(int)(total_questions-number_of_questions))) {{
				if (answerQueue.size()>0) {{
					while (answerQueue.size()>0) {
						String chatMessage = (String)answerQueue.remove();
						{
							// handleFifoCode(speakerName, chatMessage, "ANSWER", false)
							{
								Object _arguments[] = { speakerName, chatMessage, "ANSWER", false };
								Message message = new Message( self, self, "handleFifoCode", _arguments, null, null );
								__messages.add( message );
							}
						}
					}
				}
}				{
					// handleFifoCode(speakerName, msg, "ANSWER", false)
					{
						Object _arguments[] = { speakerName, msg, "ANSWER", false };
						Message message = new Message( self, self, "handleFifoCode", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}			else {{
				answerQueue.add(msg);
			}
}break;			default: if (fifo) {{
				{
					// handleFifoCode(speakerName, msg, type, false)
					{
						Object _arguments[] = { speakerName, msg, type, false };
						Message message = new Message( self, self, "handleFifoCode", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}			else {{
				messages.add(msg);
				Thread.sleep(20);
				Date date_four = new Date();
				Timestamp current_four = new Timestamp(date_four.getTime());
				printWriter.println("[Speaker Remote] "+speakerName+": "+type+": "+msg+"; Timestamp: "+current_four);
				printWriter.flush();
				{
					// standardOutput<-println("[Speaker Remote] "+speakerName+": "+type+": "+msg+"; Timestamp: "+current_four)
					{
						Object _arguments[] = { "[Speaker Remote] "+speakerName+": "+type+": "+msg+"; Timestamp: "+current_four };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}break;			}
		}
		public void handleNormalStall(String speakerName, int number_of_questions, int total_messages) {
			double number_users = (total_messages+number_of_questions)/number_of_questions;
			double total_questions = number_users*0.2*number_of_questions;
			if (questionTimeStamp.values().size()==total_questions||(isQuestion&&questionTimeStamp.values().size()==(int)(total_questions-number_of_questions))) {{
				if (answerQueue.size()>0) {{
					while (answerQueue.size()>0) {
						String chatMessage = (String)answerQueue.remove();
						{
							// handleFifoCode(speakerName, chatMessage, "ANSWER", false)
							{
								Object _arguments[] = { speakerName, chatMessage, "ANSWER", false };
								Message message = new Message( self, self, "handleFifoCode", _arguments, null, null );
								__messages.add( message );
							}
						}
					}
				}
}			}
}		}
		public boolean handleFifoCode(String speakerName, String msg, String type, boolean isQuestion) throws InterruptedException{
			Integer current_value = Integer.parseInt(msg.substring(10).replaceAll("[\\D]", ""));
			Integer current_user = Integer.parseInt(msg.substring(0, 10).replaceAll("[\\D]", ""));
			if (!valuesAdded.containsKey(current_user)) {{
				ArrayList vals = new ArrayList();
				valuesAdded.put(current_user, vals);
			}
}			if (!fifoValues.containsKey(current_user)) {{
				ArrayList vals = new ArrayList();
				ArrayList msgVals = new ArrayList();
				fifoValues.put(current_user, vals);
				fifoMessageValues.put(current_user, msgVals);
			}
}			ArrayList currentAdded = (ArrayList)valuesAdded.get(current_user);
			ArrayList currentFifo = (ArrayList)fifoValues.get(current_user);
			ArrayList currentFifoMessages = (ArrayList)fifoMessageValues.get(current_user);
			boolean isAdded = false;
			if ((currentAdded.size()==0&&current_value==1)||(currentAdded.size()>0&&((Integer)currentAdded.get(currentAdded.size()-1)==current_value-1))) {{
				currentAdded.add(current_value);
				messages.add(msg);
				Thread.sleep(20);
				Date date_four = new Date();
				Timestamp current_four = new Timestamp(date_four.getTime());
				if (isQuestion) {questionTimeStamp.put(msg, current_four);
}				printWriter.println("[Speaker Remote] "+speakerName+": "+type+": "+msg+"; Timestamp: "+current_four);
				printWriter.flush();
				{
					// standardOutput<-println("[Speaker Remote] "+speakerName+": "+type+": "+msg+"; Timestamp: "+current_four)
					{
						Object _arguments[] = { "[Speaker Remote] "+speakerName+": "+type+": "+msg+"; Timestamp: "+current_four };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				int i = -1;
				for (i = 0; i<currentFifo.size(); i++){
					if ((Integer)currentFifo.get(i)==current_value+1) {{
						current_value = (Integer)currentFifo.get(i);
						String current_message = (String)currentFifoMessages.get(i);
						currentAdded.add(current_value);
						messages.add(current_message);
						Thread.sleep(20);
						Date date_five = new Date();
						Timestamp current_five = new Timestamp(date_five.getTime());
						if (isQuestion) {questionTimeStamp.put(current_message, current_five);
}						printWriter.println("[Speaker Remote] "+speakerName+": "+type+": "+current_message+"; Timestamp: "+current_five);
						printWriter.flush();
						{
							// standardOutput<-println("[Speaker Remote] "+speakerName+": "+type+": "+current_message+"; Timestamp: "+current_five)
							{
								Object _arguments[] = { "[Speaker Remote] "+speakerName+": "+type+": "+current_message+"; Timestamp: "+current_five };
								Message message = new Message( self, standardOutput, "println", _arguments, null, null );
								__messages.add( message );
							}
						}
					}
}					else {break;}				}
				while (i>0) {
					currentFifoMessages.remove(0);
					currentFifo.remove(0);
					i--;
				}
				isAdded = true;
			}
}			else {{
				if (currentFifo.size()==0) {{
					currentFifo.add(current_value);
					currentFifoMessages.add(msg);
				}
}				else {{
					if (current_value<(Integer)currentFifo.get(0)) {{
						currentFifo.add(0, current_value);
						currentFifoMessages.add(0, msg);
					}
}					else {{
						int i = -1;
						boolean added = false;
						for (i = 0; i<currentFifo.size(); i++){
							if (current_value<(Integer)currentFifo.get(i)) {{
								added = true;
								currentFifo.add(i, current_value);
								currentFifoMessages.add(i, msg);
break;							}
}						}
						if (!added) {{
							currentFifo.add(i, current_value);
							currentFifoMessages.add(i, msg);
						}
}					}
}				}
}			}
}			valuesAdded.put(current_user, currentAdded);
			fifoValues.put(current_user, currentFifo);
			fifoMessageValues.put(current_user, currentFifoMessages);
			return isAdded;
		}
		public boolean handleFifoCodeAdvanced(String speakerName, String msg, String type, boolean isQuestion) throws InterruptedException{
			Integer current_value = Integer.parseInt(msg.substring(10).replaceAll("[\\D]", ""));
			Integer current_user = Integer.parseInt(msg.substring(0, 10).replaceAll("[\\D]", ""));
			if (!valuesAdded.containsKey(current_user)) {{
				ArrayList vals = new ArrayList();
				valuesAdded.put(current_user, vals);
			}
}			if (!fifoValues.containsKey(current_user)) {{
				ArrayList vals = new ArrayList();
				ArrayList msgVals = new ArrayList();
				fifoValues.put(current_user, vals);
				fifoMessageValues.put(current_user, msgVals);
			}
}			ArrayList currentAdded = (ArrayList)valuesAdded.get(current_user);
			ArrayList currentFifo = (ArrayList)fifoValues.get(current_user);
			ArrayList currentFifoMessages = (ArrayList)fifoMessageValues.get(current_user);
			boolean isAdded = false;
			if ((currentAdded.size()==0&&current_value==1)||(currentAdded.size()>0&&((Integer)currentAdded.get(currentAdded.size()-1)==current_value-1))) {{
				currentAdded.add(current_value);
				messageQueue.add(msg);
				if (isQuestion) {questionTimeStamp.put(msg, null);
}				int i = -1;
				for (i = 0; i<currentFifo.size(); i++){
					if ((Integer)currentFifo.get(i)==current_value+1) {{
						current_value = (Integer)currentFifo.get(i);
						String current_message = (String)currentFifoMessages.get(i);
						currentAdded.add(current_value);
						if (isQuestion) {questionTimeStamp.put(current_message, null);
}						messageQueue.add(current_message);
					}
}					else {break;}				}
				while (i>0) {
					currentFifoMessages.remove(0);
					currentFifo.remove(0);
					i--;
				}
				isAdded = true;
			}
}			else {{
				if (currentFifo.size()==0) {{
					currentFifo.add(current_value);
					currentFifoMessages.add(msg);
				}
}				else {{
					if (current_value<(Integer)currentFifo.get(0)) {{
						currentFifo.add(0, current_value);
						currentFifoMessages.add(0, msg);
					}
}					else {{
						int i = -1;
						boolean added = false;
						for (i = 0; i<currentFifo.size(); i++){
							if (current_value<(Integer)currentFifo.get(i)) {{
								added = true;
								currentFifo.add(i, current_value);
								currentFifoMessages.add(i, msg);
break;							}
}						}
						if (!added) {{
							currentFifo.add(i, current_value);
							currentFifoMessages.add(i, msg);
						}
}					}
}				}
}			}
}			valuesAdded.put(current_user, currentAdded);
			fifoValues.put(current_user, currentFifo);
			fifoMessageValues.put(current_user, currentFifoMessages);
			return isAdded;
		}
		public void handleAdvancedStall(String speakerName, int number_of_questions, int total_messages) {
			double number_users = (total_messages+number_of_questions)/number_of_questions;
			double total_questions = number_users*0.2*number_of_questions;
			if (questionTimeStamp.values().size()==total_questions||(isQuestion&&questionTimeStamp.values().size()==(int)(total_questions-number_of_questions))) {{
				if (answerQueue.size()>0) {{
					while (answerQueue.size()>0) {
						String chatMessage = (String)answerQueue.remove();
						{
							// handleFifoCodeAdvanced(speakerName, chatMessage, "ANSWER", false)
							{
								Object _arguments[] = { speakerName, chatMessage, "ANSWER", false };
								Message message = new Message( self, self, "handleFifoCodeAdvanced", _arguments, null, null );
								__messages.add( message );
							}
						}
					}
				}
}			}
}		}
		public void broadcastReceiveAdvanced(String speakerName, String msg, String type, int number_of_questions, int total_messages, boolean fifo) throws InterruptedException{
			switch (type) {
			case "QUESTION": 			{
				Token token_2_0 = new Token();
				Token token_2_1 = new Token();
				// handleFifoCodeAdvanced(speakerName, msg, type, true)
				{
					Object _arguments[] = { speakerName, msg, type, true };
					Message message = new Message( self, self, "handleFifoCodeAdvanced", _arguments, null, token_2_0 );
					__messages.add( message );
				}
				// handleAdvancedStall(speakerName, number_of_questions, total_messages)
				{
					Object _arguments[] = { speakerName, number_of_questions, total_messages };
					Message message = new Message( self, self, "handleAdvancedStall", _arguments, token_2_0, token_2_1 );
					__messages.add( message );
				}
				// printQueueInfo(total_messages)
				{
					Object _arguments[] = { total_messages };
					Message message = new Message( self, self, "printQueueInfo", _arguments, token_2_1, null );
					__messages.add( message );
				}
			}
break;			case "ANSWER": 			{
				Token token_2_0 = new Token();
				// handleAnswerCase(speakerName, msg, number_of_questions, total_messages)
				{
					Object _arguments[] = { speakerName, msg, number_of_questions, total_messages };
					Message message = new Message( self, self, "handleAnswerCase", _arguments, null, token_2_0 );
					__messages.add( message );
				}
				// printQueueInfo(total_messages)
				{
					Object _arguments[] = { total_messages };
					Message message = new Message( self, self, "printQueueInfo", _arguments, token_2_0, null );
					__messages.add( message );
				}
			}
break;			default: 			{
				Token token_2_0 = new Token();
				// handleFifoCodeAdvanced(speakerName, msg, type, false)
				{
					Object _arguments[] = { speakerName, msg, type, false };
					Message message = new Message( self, self, "handleFifoCodeAdvanced", _arguments, null, token_2_0 );
					__messages.add( message );
				}
				// printQueueInfo(total_messages)
				{
					Object _arguments[] = { total_messages };
					Message message = new Message( self, self, "printQueueInfo", _arguments, token_2_0, null );
					__messages.add( message );
				}
			}
break;			}
		}
		public void handleAnswerCase(String speakerName, String msg, int number_of_questions, int total_messages) throws InterruptedException{
			double number_users = (total_messages+number_of_questions)/number_of_questions;
			double total_questions = number_users*0.2*number_of_questions;
			if (questionTimeStamp.values().size()==total_questions||(isQuestion&&questionTimeStamp.values().size()==(int)(total_questions-number_of_questions))) {{
				if (answerQueue.size()>0) {{
					while (answerQueue.size()>0) {
						String chatMessage = (String)answerQueue.remove();
						{
							// handleFifoCodeAdvanced(speakerName, chatMessage, "ANSWER", false)
							{
								Object _arguments[] = { speakerName, chatMessage, "ANSWER", false };
								Message message = new Message( self, self, "handleFifoCodeAdvanced", _arguments, null, null );
								__messages.add( message );
							}
						}
					}
				}
}				{
					// handleFifoCodeAdvanced(speakerName, msg, "ANSWER", false)
					{
						Object _arguments[] = { speakerName, msg, "ANSWER", false };
						Message message = new Message( self, self, "handleFifoCodeAdvanced", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}			else {{
				answerQueue.add(msg);
			}
}		}
		public void printQueueInfo(int total_messages) throws InterruptedException{
			if (messageQueue.size()==total_messages) {{
				while (messageQueue.size()>0) {
					messages.add(messageQueue.remove());
					Thread.sleep(20);
				}
				Date date = new Date();
				Timestamp current = new Timestamp(date.getTime());
				printWriter.println("Overall Timestamp: "+current);
				printWriter.flush();
				{
					// standardOutput<-println("Overall Timestamp: "+current)
					{
						Object _arguments[] = { "Overall Timestamp: "+current };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				for (int i = 0; i<messages.size(); i++){
					printWriter.println(messages.get(i));
					printWriter.flush();
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
		void construct(String name, String speakerName, String serverRef, String logDirectory, boolean logToFile, String userPaddedString){
			myName = name;
			server_ref = (Server)Server.getReferenceByName(serverRef);
						{
				// server_ref<-registerUser(myName)
				{
					Object _arguments[] = { myName };
					Message message = new Message( self, server_ref, "registerUser", _arguments, null, null );
					__messages.add( message );
				}
			}
			String fileSeparator = System.getProperty("file.separator");
						{
				// standardOutput<-println(" file name : "+logDirectory+fileSeparator+speakerName+userPaddedString+".txt")
				{
					Object _arguments[] = { " file name : "+logDirectory+fileSeparator+speakerName+userPaddedString+".txt" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			if (logToFile) {{
				try {
					logFile = new File(logDirectory+fileSeparator+speakerName+userPaddedString+".txt");
					logFile.createNewFile();
				}
				catch (Exception e) {
					{
						// standardOutput<-println("exception creation file with name : "+"logs"+fileSeparator+speakerName+".txt")
						{
							Object _arguments[] = { "exception creation file with name : "+"logs"+fileSeparator+speakerName+".txt" };
							Message message = new Message( self, standardOutput, "println", _arguments, null, null );
							__messages.add( message );
						}
					}
				}

			}
}			logToFileOption = logToFile;
						try {
				printWriter = new PrintWriter(new FileWriter(logFile, true), true);
			}
			catch (Exception e) {
				{
					// standardOutput<-println("exception creating print writer file with name : "+"logs"+fileSeparator+myName+".txt")
					{
						Object _arguments[] = { "exception creating print writer file with name : "+"logs"+fileSeparator+myName+".txt" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
			}

		}
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