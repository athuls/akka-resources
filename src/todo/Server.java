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

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Server extends UniversalActor  implements ActorService {
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
		Server instance = (Server)new Server(uan, ual,null).construct();
		{
			Object[] _arguments = { args };
			instance.send( new Message(instance, instance, "act", _arguments, null, null) );
		}
	}

	public static ActorReference getReferenceByName(UAN uan)	{ return new Server(false, uan); }
	public static ActorReference getReferenceByName(String uan)	{ return Server.getReferenceByName(new UAN(uan)); }
	public static ActorReference getReferenceByLocation(UAL ual)	{ return new Server(false, ual); }

	public static ActorReference getReferenceByLocation(String ual)	{ return Server.getReferenceByLocation(new UAL(ual)); }
	public Server(boolean o, UAN __uan)	{ super(false,__uan); }
	public Server(boolean o, UAL __ual)	{ super(false,__ual); }

	public Server(UAN __uan,UniversalActor.State sourceActor)	{ this(__uan, null,null); }
	public Server(UAL __ual,UniversalActor.State sourceActor)	{ this(null, __ual,null); }
	public Server(UniversalActor.State sourceActor)		{ this(null, null,null);  }
	public Server()		{  }
	public Server(UAN __uan, UAL __ual,Object sourceActor) {
		if (__ual != null && !__ual.getLocation().equals(ServiceFactory.getTheater().getLocation())) {
			createRemotely(__uan, __ual, "todo.Server");
		} else {
			State state = new State(__uan, __ual);
			state.updateSelf(this);
			ServiceFactory.getNaming().setEntry(state.getUAN(), state.getUAL(), state);
			if (getUAN() != null) ServiceFactory.getNaming().update(state.getUAN(), state.getUAL());
		}
	}

	public UniversalActor construct () {
		Object[] __arguments = {  };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public class State extends UniversalActor .State implements salsa.resources.ActorServiceState {
		public Server self;
		public void updateSelf(ActorReference actorReference) {
			((Server)actorReference).setUAL(getUAL());
			((Server)actorReference).setUAN(getUAN());
			self = new Server(false,getUAL());
			self.setUAN(getUAN());
			self.setUAL(getUAL());
			self.muteGC();
		}

		public State() {
			this(null, null);
		}

		public State(UAN __uan, UAL __ual) {
			super(__uan, __ual);
			addClassName( "todo.Server$State" );
			addMethodsForClasses();
		}

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

		List registeredUsers;
		List specifiedTasks;
		Task taskRef;
		TaskList mainList;
		Map userIdUANMap;
		void construct(){
			registeredUsers = new ArrayList();
			specifiedTasks = new ArrayList();
			userIdUANMap = new HashMap();
		}
		public void broadcast(String taskId, String msg, String creatorName) {
			for (int i = 0; i<registeredUsers.size(); i++){
				String userRefName = (String)registeredUsers.get(i);
				if (!userRefName.equals(creatorName)) {{
					User user = (User)userIdUANMap.get(userRefName);
					if (user!=null) {{
						User userRef = (User)User.getReferenceByName(user.getUAN());
						{
							// userRef<-broadcastReceive(taskId, msg)
							{
								Object _arguments[] = { taskId, msg };
								Message message = new Message( self, userRef, "broadcastReceive", _arguments, null, null );
								__messages.add( message );
							}
						}
					}
}				}
}			}
		}
		public boolean registerUser(String userId, String email, String status, User user) {
			{
				// standardOutput<-println("Registering User "+userId+"user"+user)
				{
					Object _arguments[] = { "Registering User "+userId+"user"+user };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			registeredUsers.add(userId);
			userIdUANMap.put(userId, user);
			return true;
		}
		public boolean addTaskToList(TaskList taskList, String taskId, String text, String creator) {
			Task taskRef = (Task)Task.getReferenceByName(taskId);
			{
				// standardOutput<-println("taskref "+taskRef)
				{
					Object _arguments[] = { "taskref "+taskRef };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			if (creator==null) {{
				{
					// standardOutput<-println("creator is null")
					{
						Object _arguments[] = { "creator is null" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				return false;
			}
}			{
				// standardOutput<-println(" calling inside server.addTaskToList")
				{
					Object _arguments[] = { " calling inside server.addTaskToList" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// standardOutput<-println(taskId)
				{
					Object _arguments[] = { taskId };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			Task task = ((Task)new Task(this).construct(text, taskId, creator));
			if (task==null) {{
				{
					// standardOutput<-println("Task is null")
					{
						Object _arguments[] = { "Task is null" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				return false;
			}
}			TaskList taskListRef = (TaskList)TaskList.getReferenceByName(taskList.getUAN());
			{
				// taskListRef<-addTask(creator, taskRef, taskId)
				{
					Object _arguments[] = { creator, taskRef, taskId };
					Message message = new Message( self, taskListRef, "addTask", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// standardOutput<-println("after taskListRef")
				{
					Object _arguments[] = { "after taskListRef" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			mainList = taskList;
			{
				// broadcast(taskId, text, creator)
				{
					Object _arguments[] = { taskId, text, creator };
					Message message = new Message( self, self, "broadcast", _arguments, null, null );
					__messages.add( message );
				}
			}
			return true;
		}
		public boolean updateTask(String taskId, String text, String creator) {
			{
				// standardOutput<-println("before taskListRef.update")
				{
					Object _arguments[] = { "before taskListRef.update" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			TaskList taskListRef = (TaskList)TaskList.getReferenceByName((mainList).getUAN());
			{
				// taskListRef<-updateTask(taskId, text, creator)
				{
					Object _arguments[] = { taskId, text, creator };
					Message message = new Message( self, taskListRef, "updateTask", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// standardOutput<-println("after taskListRef.update")
				{
					Object _arguments[] = { "after taskListRef.update" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// broadcast(taskId, text, creator)
				{
					Object _arguments[] = { taskId, text, creator };
					Message message = new Message( self, self, "broadcast", _arguments, null, null );
					__messages.add( message );
				}
			}
			return true;
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
					// standardOutput<-println("Usage: java -Duan=myuan todo.Server")
					{
						Object _arguments[] = { "Usage: java -Duan=myuan todo.Server" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				return;
			}
}			{
				// standardOutput<-println("Server started")
				{
					Object _arguments[] = { "Server started" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
	}
}