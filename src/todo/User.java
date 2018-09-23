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

import java.util.Set;
import java.util.HashSet;

public class User extends UniversalActor  implements ActorService {
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
		User instance = (User)new User(uan, ual,null).construct();
		{
			Object[] _arguments = { args };
			instance.send( new Message(instance, instance, "act", _arguments, null, null) );
		}
	}

	public static ActorReference getReferenceByName(UAN uan)	{ return new User(false, uan); }
	public static ActorReference getReferenceByName(String uan)	{ return User.getReferenceByName(new UAN(uan)); }
	public static ActorReference getReferenceByLocation(UAL ual)	{ return new User(false, ual); }

	public static ActorReference getReferenceByLocation(String ual)	{ return User.getReferenceByLocation(new UAL(ual)); }
	public User(boolean o, UAN __uan)	{ super(false,__uan); }
	public User(boolean o, UAL __ual)	{ super(false,__ual); }

	public User(UAN __uan,UniversalActor.State sourceActor)	{ this(__uan, null,null); }
	public User(UAL __ual,UniversalActor.State sourceActor)	{ this(null, __ual,null); }
	public User(UniversalActor.State sourceActor)		{ this(null, null,null);  }
	public User()		{  }
	public User(UAN __uan, UAL __ual,Object sourceActor) {
		if (__ual != null && !__ual.getLocation().equals(ServiceFactory.getTheater().getLocation())) {
			createRemotely(__uan, __ual, "todo.User");
		} else {
			State state = new State(__uan, __ual);
			state.updateSelf(this);
			ServiceFactory.getNaming().setEntry(state.getUAN(), state.getUAL(), state);
			if (getUAN() != null) ServiceFactory.getNaming().update(state.getUAN(), state.getUAL());
		}
	}

	public UniversalActor construct (String id, String email, String status) {
		Object[] __arguments = { id, email, status };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public UniversalActor construct() {
		Object[] __arguments = { };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public class State extends UniversalActor .State implements salsa.resources.ActorServiceState {
		public User self;
		public void updateSelf(ActorReference actorReference) {
			((User)actorReference).setUAL(getUAL());
			((User)actorReference).setUAN(getUAN());
			self = new User(false,getUAL());
			self.setUAN(getUAN());
			self.setUAL(getUAL());
			self.muteGC();
		}

		public State() {
			this(null, null);
		}

		public State(UAN __uan, UAL __ual) {
			super(__uan, __ual);
			addClassName( "todo.User$State" );
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
		String emailId = "";
		String status = "";
		Server server_ref;
		Set taskIds = new HashSet();
		Set tasksViewed = new HashSet();
		void construct(String id, String email, String status){
			myName = id;
			emailId = email;
			status = status;
		}
		public void broadcastReceive(String taskId, String msg) {
			{
				// standardOutput<-println("[Task Id] "+taskId+": "+msg)
				{
					Object _arguments[] = { "[Task Id] "+taskId+": "+msg };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			tasksViewed.add(taskId);
			if (!taskIds.contains(taskId)) {{
				taskIds.add(taskId);
			}
}			else {{
				taskIds.remove(taskId);
				taskIds.add(taskId);
			}
}		}
		public void viewTaskList() {
		}
		public String getUserName() {
			return myName;
		}
		public void whereAmI() {
			{
				// standardOutput<-println("User started with uan: "+getUAN().toString())
				{
					Object _arguments[] = { "User started with uan: "+getUAN().toString() };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
		public boolean addTaskToList(TaskList taskList, String taskId, String text) {
			{
				// server_ref<-addTaskToList(taskList, taskId, text, ((User)self))
				{
					Object _arguments[] = { taskList, taskId, text, ((User)self) };
					Message message = new Message( self, server_ref, "addTaskToList", _arguments, null, null );
					__messages.add( message );
				}
			}
			return true;
		}
		public boolean updateTask(String taskId, String text) {
			{
				// server_ref<-updateTask(taskId, text, ((User)self))
				{
					Object _arguments[] = { taskId, text, ((User)self) };
					Message message = new Message( self, server_ref, "updateTask", _arguments, null, null );
					__messages.add( message );
				}
			}
			return true;
		}
		public void act(String args[]) {
			if (args.length!=2) {{
				{
					// standardOutput<-println("Usage: java -Duan=uan://hostname/place todo.User <serverName> <myName>")
					{
						Object _arguments[] = { "Usage: java -Duan=uan://hostname/place todo.User <serverName> <myName>" };
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
				// server_ref<-registerUser(myName, emailId, status, ((User)self))
				{
					Object _arguments[] = { myName, emailId, status, ((User)self) };
					Message message = new Message( self, server_ref, "registerUser", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
	}
}