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

public class TaskList extends UniversalActor  implements ActorService {
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
		TaskList instance = (TaskList)new TaskList(uan, ual,null).construct();
		{
			Object[] _arguments = { args };
			instance.send( new Message(instance, instance, "act", _arguments, null, null) );
		}
	}

	public static ActorReference getReferenceByName(UAN uan)	{ return new TaskList(false, uan); }
	public static ActorReference getReferenceByName(String uan)	{ return TaskList.getReferenceByName(new UAN(uan)); }
	public static ActorReference getReferenceByLocation(UAL ual)	{ return new TaskList(false, ual); }

	public static ActorReference getReferenceByLocation(String ual)	{ return TaskList.getReferenceByLocation(new UAL(ual)); }
	public TaskList(boolean o, UAN __uan)	{ super(false,__uan); }
	public TaskList(boolean o, UAL __ual)	{ super(false,__ual); }

	public TaskList(UAN __uan,UniversalActor.State sourceActor)	{ this(__uan, null,null); }
	public TaskList(UAL __ual,UniversalActor.State sourceActor)	{ this(null, __ual,null); }
	public TaskList(UniversalActor.State sourceActor)		{ this(null, null,null);  }
	public TaskList()		{  }
	public TaskList(UAN __uan, UAL __ual,Object sourceActor) {
		if (__ual != null && !__ual.getLocation().equals(ServiceFactory.getTheater().getLocation())) {
			createRemotely(__uan, __ual, "todo.TaskList");
		} else {
			State state = new State(__uan, __ual);
			state.updateSelf(this);
			ServiceFactory.getNaming().setEntry(state.getUAN(), state.getUAL(), state);
			if (getUAN() != null) ServiceFactory.getNaming().update(state.getUAN(), state.getUAL());
		}
	}

	public UniversalActor construct (String name) {
		Object[] __arguments = { name };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public UniversalActor construct() {
		Object[] __arguments = { };
		this.send( new Message(this, this, "construct", __arguments, null, null) );
		return this;
	}

	public class State extends UniversalActor .State implements salsa.resources.ActorServiceState {
		public TaskList self;
		public void updateSelf(ActorReference actorReference) {
			((TaskList)actorReference).setUAL(getUAL());
			((TaskList)actorReference).setUAN(getUAN());
			self = new TaskList(false,getUAL());
			self.setUAN(getUAN());
			self.setUAL(getUAL());
			self.muteGC();
		}

		public State() {
			this(null, null);
		}

		public State(UAN __uan, UAL __ual) {
			super(__uan, __ual);
			addClassName( "todo.TaskList$State" );
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

		String name;
		Set users = new HashSet();
		List tasks = new ArrayList();
		Server server_ref;
		void construct(String name){
			name = name;
		}
		public boolean addTask(User user, Task task) {
			{
				// standardOutput<-println(" calling inside taskToList.addTask")
				{
					Object _arguments[] = { " calling inside taskToList.addTask" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			if (task==null) {{
				{
					// standardOutput<-println("Task is null")
					{
						Object _arguments[] = { "Task is null" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}			if (user==null) {{
				{
					// standardOutput<-println("user is null")
					{
						Object _arguments[] = { "user is null" };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}			{
				// standardOutput<-println(user)
				{
					Object _arguments[] = { user };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			{
				// standardOutput<-println(task)
				{
					Object _arguments[] = { task };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			User userRef = (User)User.getReferenceByName(user.getUAN());
			Task taskRef = (Task)Task.getReferenceByName(task.getUAN());
			users.add(userRef);
			tasks.add(taskRef);
			{
				// standardOutput<-println("after addTask")
				{
					Object _arguments[] = { "after addTask" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			return true;
		}
		public List getTasks() {
			return tasks;
		}
		public Set getUsers() {
			return users;
		}
		public void whereAmI() {
			{
				// standardOutput<-println("TaskList started with uan: "+getUAN().toString())
				{
					Object _arguments[] = { "TaskList started with uan: "+getUAN().toString() };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
		}
		public boolean updateTask(String taskId, String text) {
			{
				// standardOutput<-println(" calling inside taskToList.updateTask")
				{
					Object _arguments[] = { " calling inside taskToList.updateTask" };
					Message message = new Message( self, standardOutput, "println", _arguments, null, null );
					__messages.add( message );
				}
			}
			for (int i = 0; i<tasks.size(); i++){
				{
					// standardOutput<-println(" taskId inside taskToList.updateTask"+taskId)
					{
						Object _arguments[] = { " taskId inside taskToList.updateTask"+taskId };
						Message message = new Message( self, standardOutput, "println", _arguments, null, null );
						__messages.add( message );
					}
				}
				Task taskRef = (Task)Task.getReferenceByName(((Task)tasks.get(i)).getUAN());
				{
					// taskRef<-update(taskId, text)
					{
						Object _arguments[] = { taskId, text };
						Message message = new Message( self, taskRef, "update", _arguments, null, null );
						__messages.add( message );
					}
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
					// standardOutput<-println("Usage: java -Duan=myuan todo.TaskList")
					{
						Object _arguments[] = { "Usage: java -Duan=myuan todo.TaskList" };
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