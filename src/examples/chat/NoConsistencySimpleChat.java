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

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.sql.Timestamp;
import examples.chat.ChatMessage.MessageType;

public class NoConsistencySimpleChat extends UniversalActor  {
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
		RunTime.receivedMessage();
		NoConsistencySimpleChat instance = (NoConsistencySimpleChat)new NoConsistencySimpleChat(uan, ual,null).construct();
		gc.WeakReference instanceRef=new gc.WeakReference(uan,ual);
		{
			Object[] _arguments = { args };

			//preAct() for local actor creation
			//act() for remote actor creation
			if (ual != null && !ual.getLocation().equals(ServiceFactory.getTheater().getLocation())) {instance.send( new Message(instanceRef, instanceRef, "act", _arguments, false) );}
			else {instance.send( new Message(instanceRef, instanceRef, "preAct", _arguments, false) );}
		}
		RunTime.finishedProcessingMessage();
	}

	public static ActorReference getReferenceByName(UAN uan)	{ return new NoConsistencySimpleChat(false, uan); }
	public static ActorReference getReferenceByName(String uan)	{ return NoConsistencySimpleChat.getReferenceByName(new UAN(uan)); }
	public static ActorReference getReferenceByLocation(UAL ual)	{ return new NoConsistencySimpleChat(false, ual); }

	public static ActorReference getReferenceByLocation(String ual)	{ return NoConsistencySimpleChat.getReferenceByLocation(new UAL(ual)); }
	public NoConsistencySimpleChat(boolean o, UAN __uan)	{ super(false,__uan); }
	public NoConsistencySimpleChat(boolean o, UAL __ual)	{ super(false,__ual); }
	public NoConsistencySimpleChat(UAN __uan,UniversalActor.State sourceActor)	{ this(__uan, null, sourceActor); }
	public NoConsistencySimpleChat(UAL __ual,UniversalActor.State sourceActor)	{ this(null, __ual, sourceActor); }
	public NoConsistencySimpleChat(UniversalActor.State sourceActor)		{ this(null, null, sourceActor);  }
	public NoConsistencySimpleChat()		{  }
	public NoConsistencySimpleChat(UAN __uan, UAL __ual, Object obj) {
		//decide the type of sourceActor
		//if obj is null, the actor must be the startup actor.
		//if obj is an actorReference, this actor is created by a remote actor

		if (obj instanceof UniversalActor.State || obj==null) {
			  UniversalActor.State sourceActor;
			  if (obj!=null) { sourceActor=(UniversalActor.State) obj;}
			  else {sourceActor=null;}

			  //remote creation message sent to a remote system service.
			  if (__ual != null && !__ual.getLocation().equals(ServiceFactory.getTheater().getLocation())) {
			    WeakReference sourceRef;
			    if (sourceActor!=null && sourceActor.getUAL() != null) {sourceRef = new WeakReference(sourceActor.getUAN(),sourceActor.getUAL());}
			    else {sourceRef = null;}
			    if (sourceActor != null) {
			      if (__uan != null) {sourceActor.getActorMemory().getForwardList().putReference(__uan);}
			      else if (__ual!=null) {sourceActor.getActorMemory().getForwardList().putReference(__ual);}

			      //update the source of this actor reference
			      setSource(sourceActor.getUAN(), sourceActor.getUAL());
			      activateGC();
			    }
			    createRemotely(__uan, __ual, "examples.chat.NoConsistencySimpleChat", sourceRef);
			  }

			  // local creation
			  else {
			    State state = new State(__uan, __ual);

			    //assume the reference is weak
			    muteGC();

			    //the source actor is  the startup actor
			    if (sourceActor == null) {
			      state.getActorMemory().getInverseList().putInverseReference("rmsp://me");
			    }

			    //the souce actor is a normal actor
			    else if (sourceActor instanceof UniversalActor.State) {

			      // this reference is part of garbage collection
			      activateGC();

			      //update the source of this actor reference
			      setSource(sourceActor.getUAN(), sourceActor.getUAL());

			      /* Garbage collection registration:
			       * register 'this reference' in sourceActor's forward list @
			       * register 'this reference' in the forward acquaintance's inverse list
			       */
			      String inverseRefString=null;
			      if (sourceActor.getUAN()!=null) {inverseRefString=sourceActor.getUAN().toString();}
			      else if (sourceActor.getUAL()!=null) {inverseRefString=sourceActor.getUAL().toString();}
			      if (__uan != null) {sourceActor.getActorMemory().getForwardList().putReference(__uan);}
			      else if (__ual != null) {sourceActor.getActorMemory().getForwardList().putReference(__ual);}
			      else {sourceActor.getActorMemory().getForwardList().putReference(state.getUAL());}

			      //put the inverse reference information in the actormemory
			      if (inverseRefString!=null) state.getActorMemory().getInverseList().putInverseReference(inverseRefString);
			    }
			    state.updateSelf(this);
			    ServiceFactory.getNaming().setEntry(state.getUAN(), state.getUAL(), state);
			    if (getUAN() != null) ServiceFactory.getNaming().update(state.getUAN(), state.getUAL());
			  }
		}

		//creation invoked by a remote message
		else if (obj instanceof ActorReference) {
			  ActorReference sourceRef= (ActorReference) obj;
			  State state = new State(__uan, __ual);
			  muteGC();
			  state.getActorMemory().getInverseList().putInverseReference("rmsp://me");
			  if (sourceRef.getUAN() != null) {state.getActorMemory().getInverseList().putInverseReference(sourceRef.getUAN());}
			  else if (sourceRef.getUAL() != null) {state.getActorMemory().getInverseList().putInverseReference(sourceRef.getUAL());}
			  state.updateSelf(this);
			  ServiceFactory.getNaming().setEntry(state.getUAN(), state.getUAL(),state);
			  if (getUAN() != null) ServiceFactory.getNaming().update(state.getUAN(), state.getUAL());
		}
	}

	public UniversalActor construct() {
		Object[] __arguments = { };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public class State extends UniversalActor .State {
		public NoConsistencySimpleChat self;
		public void updateSelf(ActorReference actorReference) {
			((NoConsistencySimpleChat)actorReference).setUAL(getUAL());
			((NoConsistencySimpleChat)actorReference).setUAN(getUAN());
			self = new NoConsistencySimpleChat(false,getUAL());
			self.setUAN(getUAN());
			self.setUAL(getUAL());
			self.activateGC();
		}

		public void preAct(String[] arguments) {
			getActorMemory().getInverseList().removeInverseReference("rmsp://me",1);
			{
				Object[] __args={arguments};
				self.send( new Message(self,self, "act", __args, null,null,false) );
			}
		}

		public State() {
			this(null, null);
		}

		public State(UAN __uan, UAL __ual) {
			super(__uan, __ual);
			addClassName( "examples.chat.NoConsistencySimpleChat$State" );
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

		public void chatSession(Speaker s1, Speaker s2, Speaker s3, Speaker s4, Speaker s5) {
			{
				// s1<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 1: Random statement 1."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 1: Random statement 1."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s1, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s1<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 1: Random statement 2."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 1: Random statement 2."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s1, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s1<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 1: Random statement 3."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 1: Random statement 3."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s1, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s2<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 2: Random statement 1."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 2: Random statement 1."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s2, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s2<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 2: Random statement 2."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 2: Random statement 2."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s2, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s2<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 2: Random statement 3."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 2: Random statement 3."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s2, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s3<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 3: Random statement 1."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 3: Random statement 1."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s3, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s3<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 3: Random statement 2."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 3: Random statement 2."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s3, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s3<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 3: Random statement 3."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 3: Random statement 3."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s3, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s4<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 4: Random statement 1."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 4: Random statement 1."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s4, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s4<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 4: Random statement 2."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 4: Random statement 2."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s4, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s4<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 4: Random statement 3."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 4: Random statement 3."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s4, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s5<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 5: Random statement 1."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 5: Random statement 1."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s5, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s5<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 5: Random statement 2."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 5: Random statement 2."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s5, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// s5<-broadcastSend(new ChatMessage(MessageType.STATEMENT, "User 5: Random statement 3."), 0, 12)
				{
					Object _arguments[] = { new ChatMessage(MessageType.STATEMENT, "User 5: Random statement 3."), new Integer(0), new Integer(12) };
					Message message = new Message( self, s5, "broadcastSend", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
		public void reply(String replyMsg) {
			{
				// standardOutput<-println(replyMsg)
				{
					Object _arguments[] = { replyMsg };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
		public void act(String args[]) {
			if (args.length!=5) {{
				{
					// standardOutput<-println("Usage: java -Duan=myuan examples.chat.Chat <friendUAN1> <friendUAN2>")
					{
						Object _arguments[] = { "Usage: java -Duan=myuan examples.chat.Chat <friendUAN1> <friendUAN2>" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				return;
			}
}			try {
				Speaker speaker1 = (Speaker)Speaker.getReferenceByName(args[0]);
				Speaker speaker2 = (Speaker)Speaker.getReferenceByName(args[1]);
				Speaker speaker3 = (Speaker)Speaker.getReferenceByName(args[2]);
				Speaker speaker4 = (Speaker)Speaker.getReferenceByName(args[3]);
				Speaker speaker5 = (Speaker)Speaker.getReferenceByName(args[4]);
				Date first = new Date();
				Timestamp start = new Timestamp(first.getTime());
				{
					// standardOutput<-println("Starting time: "+start)
					{
						Object _arguments[] = { "Starting time: "+start };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				Instant begin = Instant.now();
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					// chatSession(speaker1, speaker2, speaker3, speaker4, speaker5)
					{
						Object _arguments[] = { speaker1, speaker2, speaker3, speaker4, speaker5 };
						Message message = new Message( self, self, "chatSession", _arguments, null, token_3_0 );
						__messages.add( message );
					}
					// trackEndingTime(begin)
					{
						Object _arguments[] = { begin };
						Message message = new Message( self, self, "trackEndingTime", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// standardOutput<-println("Done with chat conversation")
					{
						Object _arguments[] = { "Done with chat conversation" };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_1, null );
						__messages.add( message );
					}
				}
			}
			catch (Exception e) {
				{
					// standardOutput<-println("Usage: java examples.chat.Chat <friendUAN1> <friendUAN2> <friendUAN3>")
					{
						Object _arguments[] = { "Usage: java examples.chat.Chat <friendUAN1> <friendUAN2> <friendUAN3>" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				return;
			}

		}
		public void trackEndingTime(Instant begin) {
			Date second = new Date();
			Timestamp end = new Timestamp(second.getTime());
			Instant endTime = Instant.now();
			Duration timeDifference = Duration.between(begin, endTime);
			long timeTaken = timeDifference.toMillis();
			{
				// standardOutput<-println("Time taken to run this in milliseconds: "+timeTaken)
				{
					Object _arguments[] = { "Time taken to run this in milliseconds: "+timeTaken };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// standardOutput<-println("Ending time: "+end)
				{
					Object _arguments[] = { "Ending time: "+end };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
	}
}