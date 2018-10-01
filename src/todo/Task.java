package todo;

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


public class Task extends UniversalActor  implements ActorService {
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
		Task instance = (Task)new Task(uan, ual,null).construct();
		{
			Object[] _arguments = { args };
			instance.send( new Message(instance, instance, "act", _arguments, null, null) );
		}
	}

	public static ActorReference getReferenceByName(UAN uan)	{ return new Task(false, uan); }
	public static ActorReference getReferenceByName(String uan)	{ return Task.getReferenceByName(new UAN(uan)); }
	public static ActorReference getReferenceByLocation(UAL ual)	{ return new Task(false, ual); }

	public static ActorReference getReferenceByLocation(String ual)	{ return Task.getReferenceByLocation(new UAL(ual)); }
	public Task(boolean o, UAN __uan)	{ super(false,__uan); }
	public Task(boolean o, UAL __ual)	{ super(false,__ual); }

	public Task(UAN __uan,UniversalActor.State sourceActor)	{ this(__uan, null,null); }
	public Task(UAL __ual,UniversalActor.State sourceActor)	{ this(null, __ual,null); }
	public Task(UniversalActor.State sourceActor)		{ this(null, null,null);  }
	public Task()		{  }
	public Task(UAN __uan, UAL __ual,Object sourceActor) {
		if (__ual != null && !__ual.getLocation().equals(ServiceFactory.getTheater().getLocation())) {
			createRemotely(__uan, __ual, "todo.Task");
		} else {
			State state = new State(__uan, __ual);
			state.updateSelf(this);
			ServiceFactory.getNaming().setEntry(state.getUAN(), state.getUAL(), state);
			if (getUAN() != null) ServiceFactory.getNaming().update(state.getUAN(), state.getUAL());
		}
	}

	public UniversalActor construct (String text, String id, String creator) {
		Object[] __arguments = { text, id, creator };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public UniversalActor construct() {
		Object[] __arguments = { };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public class State extends UniversalActor .State implements salsa.resources.ActorServiceState {
		public Task self;
		public void updateSelf(ActorReference actorReference) {
			((Task)actorReference).setUAL(getUAL());
			((Task)actorReference).setUAN(getUAN());
			self = new Task(false,getUAL());
			self.setUAN(getUAN());
			self.setUAL(getUAL());
			self.muteGC();
		}

		public State() {
			this(null, null);
		}

		public State(UAN __uan, UAL __ual) {
			super(__uan, __ual);
			addClassName( "todo.Task$State" );
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

		String taskId = "";
		String taskText = "";
		Server server_ref;
		String creator;
		String id = "";
		void construct(String text, String id, String creator){
			taskId = id;
			text = text;
			creator = creator;
		}
		public String getCreator() {
			return creator;
		}
		public String getTaskId() {
			return taskId;
		}
		public String getText() {
			return text;
		}
		public boolean update(String theTaskId, String text) {
			if (theTaskId.equals(taskId)) {{
				taskText = text;
				return true;
			}
}			return false;
		}
		public void whereAmI() {
			{
				// standardOutput<-println("Task started with uan: "+getUAN().toString())
				{
					Object _arguments[] = { "Task started with uan: "+getUAN().toString() };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
		public void act(String args[]) {
			if (args.length!=0) {{
				{
					// standardOutput<-println(args.length)
					{
						Object _arguments[] = { args.length };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				{
					// standardOutput<-println("Usage: java -Duan=myuan todo.Task")
					{
						Object _arguments[] = { "Usage: java -Duan=myuan todo.Task" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				return;
			}
}			{
				// whereAmI()
				{
					Object _arguments[] = {  };
					Message message = new Message( self, self, "whereAmI", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
	}
}