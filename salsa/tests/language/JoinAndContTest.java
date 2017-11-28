package tests.language;

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


public class JoinAndContTest extends UniversalActor  {
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
		JoinAndContTest instance = (JoinAndContTest)new JoinAndContTest(uan, ual,null).construct();
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

	public static ActorReference getReferenceByName(UAN uan)	{ return new JoinAndContTest(false, uan); }
	public static ActorReference getReferenceByName(String uan)	{ return JoinAndContTest.getReferenceByName(new UAN(uan)); }
	public static ActorReference getReferenceByLocation(UAL ual)	{ return new JoinAndContTest(false, ual); }

	public static ActorReference getReferenceByLocation(String ual)	{ return JoinAndContTest.getReferenceByLocation(new UAL(ual)); }
	public JoinAndContTest(boolean o, UAN __uan)	{ super(false,__uan); }
	public JoinAndContTest(boolean o, UAL __ual)	{ super(false,__ual); }
	public JoinAndContTest(UAN __uan,UniversalActor.State sourceActor)	{ this(__uan, null, sourceActor); }
	public JoinAndContTest(UAL __ual,UniversalActor.State sourceActor)	{ this(null, __ual, sourceActor); }
	public JoinAndContTest(UniversalActor.State sourceActor)		{ this(null, null, sourceActor);  }
	public JoinAndContTest()		{  }
	public JoinAndContTest(UAN __uan, UAL __ual, Object obj) {
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
			    createRemotely(__uan, __ual, "tests.language.JoinAndContTest", sourceRef);
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
		public JoinAndContTest self;
		public void updateSelf(ActorReference actorReference) {
			((JoinAndContTest)actorReference).setUAL(getUAL());
			((JoinAndContTest)actorReference).setUAN(getUAN());
			self = new JoinAndContTest(false,getUAL());
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
			addClassName( "tests.language.JoinAndContTest$State" );
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

		public void act(String[] args) {
			int testcode = Integer.parseInt(args[0]);
			if (testcode==0) {{
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					Token token_3_2 = new Token();
					// returnStr("Test ")
					{
						Object _arguments[] = { "Test " };
						Message message = new Message( self, self, "returnStr", _arguments, null, token_3_0 );
						__messages.add( message );
					}
					// standardOutput<-println(token)
					{
						Object _arguments[] = { token_3_0 };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// returnStr("Continuations")
					{
						Object _arguments[] = { "Continuations" };
						Message message = new Message( self, self, "returnStr", _arguments, token_3_1, token_3_2 );
						__messages.add( message );
					}
					// standardOutput<-println(token)
					{
						Object _arguments[] = { token_3_2 };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_2, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==1) {{
				{
					Token token_3_0 = new Token();
					// join block
					token_3_0.setJoinDirector();
					if (false) {{
						{
							// standardOutput<-println("Wrong ")
							{
								Object _arguments[] = { "Wrong " };
								Message message = new Message( self, standardOutput, "println", _arguments, null, token_3_0 );
								__messages.add( message );
							}
						}
					}
}					addJoinToken(token_3_0);
					// standardOutput<-println("passed empty join")
					{
						Object _arguments[] = { "passed empty join" };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_0, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==2) {{
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					// join block
					token_3_0.setJoinDirector();
					for (int i = 0; i<10; i++){
						{
							// dummy()
							{
								Object _arguments[] = {  };
								Message message = new Message( self, self, "dummy", _arguments, null, token_3_0 );
								__messages.add( message );
							}
						}
					}
					addJoinToken(token_3_0);
					// mergeDummy(token)
					{
						Object _arguments[] = { token_3_0 };
						Message message = new Message( self, self, "mergeDummy", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// standardOutput<-println("passed non-empty join block with return values")
					{
						Object _arguments[] = { "passed non-empty join block with return values" };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_1, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==3) {{
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					// join block
					token_3_0.setJoinDirector();
					for (int i = 0; i<0; i++){
						{
							// dummy()
							{
								Object _arguments[] = {  };
								Message message = new Message( self, self, "dummy", _arguments, null, token_3_0 );
								__messages.add( message );
							}
						}
					}
					addJoinToken(token_3_0);
					// mergeDummy(token)
					{
						Object _arguments[] = { token_3_0 };
						Message message = new Message( self, self, "mergeDummy", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// standardOutput<-println("passed empty join block with return values")
					{
						Object _arguments[] = { "passed empty join block with return values" };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_1, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==4) {{
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					// join block
					token_3_0.setJoinDirector();
					for (int i = 0; i<100; i++){
						{
							// dummy()
							{
								Object _arguments[] = {  };
								Message message = new Message( self, self, "dummy", _arguments, null, token_3_0 );
								__messages.add( message );
							}
						}
					}
					addJoinToken(token_3_0);
					// testCont(new Integer(1000))
					{
						Object _arguments[] = { new Integer(1000) };
						Message message = new Message( self, self, "testCont", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// standardOutput<-println("passed join block following currentContinuation")
					{
						Object _arguments[] = { "passed join block following currentContinuation" };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_1, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==5) {{
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					// join block
					token_3_0.setJoinDirector();
					for (int i = 0; i<100; i++){
						{
							// testCont(new Integer(i))
							{
								Object _arguments[] = { new Integer(i) };
								Message message = new Message( self, self, "testCont", _arguments, null, token_3_0 );
								__messages.add( message );
							}
						}
					}
					addJoinToken(token_3_0);
					// mergeDummy(token)
					{
						Object _arguments[] = { token_3_0 };
						Message message = new Message( self, self, "mergeDummy", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// standardOutput<-println("passed join block within currentContinuation")
					{
						Object _arguments[] = { "passed join block within currentContinuation" };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_1, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==6) {{
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					Token token_3_2 = new Token();
					// join block
					token_3_0.setJoinDirector();
					{
						Token token_4_0 = new Token();
						// add(new Integer(1), new Integer(2))
						{
							Object _arguments[] = { new Integer(1), new Integer(2) };
							Message message = new Message( self, self, "add", _arguments, null, token_4_0 );
							__messages.add( message );
						}
						// add(token, new Integer(3))
						{
							Object _arguments[] = { token_4_0, new Integer(3) };
							Message message = new Message( self, self, "add", _arguments, token_4_0, token_3_0 );
							__messages.add( message );
						}
					}
					{
						Token token_4_0 = new Token();
						// add(new Integer(4), new Integer(5))
						{
							Object _arguments[] = { new Integer(4), new Integer(5) };
							Message message = new Message( self, self, "add", _arguments, null, token_4_0 );
							__messages.add( message );
						}
						// add(token, new Integer(6))
						{
							Object _arguments[] = { token_4_0, new Integer(6) };
							Message message = new Message( self, self, "add", _arguments, token_4_0, token_3_0 );
							__messages.add( message );
						}
					}
					{
						Token token_4_0 = new Token();
						// add(new Integer(7), new Integer(8))
						{
							Object _arguments[] = { new Integer(7), new Integer(8) };
							Message message = new Message( self, self, "add", _arguments, null, token_4_0 );
							__messages.add( message );
						}
						// add(token, new Integer(9))
						{
							Object _arguments[] = { token_4_0, new Integer(9) };
							Message message = new Message( self, self, "add", _arguments, token_4_0, token_3_0 );
							__messages.add( message );
						}
					}
					{
						Token token_4_0 = new Token();
						// add(new Integer(10), new Integer(11))
						{
							Object _arguments[] = { new Integer(10), new Integer(11) };
							Message message = new Message( self, self, "add", _arguments, null, token_4_0 );
							__messages.add( message );
						}
						// add(token, new Integer(12))
						{
							Object _arguments[] = { token_4_0, new Integer(12) };
							Message message = new Message( self, self, "add", _arguments, token_4_0, token_3_0 );
							__messages.add( message );
						}
					}
					addJoinToken(token_3_0);
					// add(token)
					{
						Object _arguments[] = { token_3_0 };
						Message message = new Message( self, self, "add", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// standardOutput<-print(token)
					{
						Object _arguments[] = { token_3_1 };
						Message message = new Message( self, standardOutput, "print", _arguments, token_3_1, token_3_2 );
						__messages.add( message );
					}
					// standardOutput<-println(" = 78")
					{
						Object _arguments[] = { " = 78" };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_2, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==7) {{
				Token x = new Token("x");
				{
					// token x = ((JoinAndContTest)self)<-returnStr("J0 ")
					{
						Object _arguments[] = { "J0 " };
						Message message = new Message( self, ((JoinAndContTest)self), "returnStr", _arguments, null, x );
						Object[] _propertyInfo = { new Integer(10000) };
						message.setProperty( "delay", _propertyInfo );
						__messages.add( message );
					}
				}
				Token y = new Token("y");
				{
					// token y = ""returnStr:((new Integer(4000)))
					{
						Object _arguments[] = { "" };
						Message message = new Message( self, self, "returnStr", _arguments, null, y );
						Object[] _propertyInfo = { new Integer(4000) };
						message.setProperty( "delay", _propertyInfo );
						__messages.add( message );
					}
				}
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					Token token_3_2 = new Token();
					// join block
					token_3_0.setJoinDirector();
					{
						// "J1 "returnStr:((x, y))
						{
							Object _arguments[] = { "J1 " };
							Message message = new Message( self, self, "returnStr", _arguments, null, token_3_0 );
							Object[] _propertyInfo = { x, y };
							message.setProperty( "waitfor", _propertyInfo );
							__messages.add( message );
						}
					}
					{
						// returnStr("J2 ")
						{
							Object _arguments[] = { "J2 " };
							Message message = new Message( self, self, "returnStr", _arguments, null, token_3_0 );
							__messages.add( message );
						}
					}
					{
						// "J3 "returnStr:((new Integer(7000)))
						{
							Object _arguments[] = { "J3 " };
							Message message = new Message( self, self, "returnStr", _arguments, null, token_3_0 );
							Object[] _propertyInfo = { new Integer(7000) };
							message.setProperty( "delay", _propertyInfo );
							__messages.add( message );
						}
					}
					{
						// returnStr("J4 ")
						{
							Object _arguments[] = { "J4 " };
							Message message = new Message( self, self, "returnStr", _arguments, null, token_3_0 );
							__messages.add( message );
						}
					}
					{
						// returnStr("J5 ")
						{
							Object _arguments[] = { "J5 " };
							Message message = new Message( self, self, "returnStr", _arguments, null, token_3_0 );
							__messages.add( message );
						}
					}
					{
						// returnStr("J6 ")
						{
							Object _arguments[] = { "J6 " };
							Message message = new Message( self, self, "returnStr", _arguments, null, token_3_0 );
							__messages.add( message );
						}
					}
					{
						// returnStr("J7 ")
						{
							Object _arguments[] = { "J7 " };
							Message message = new Message( self, self, "returnStr", _arguments, null, token_3_0 );
							__messages.add( message );
						}
					}
					addJoinToken(token_3_0);
					// showStr(x, token)
					{
						Object _arguments[] = { x, token_3_0 };
						Message message = new Message( self, self, "showStr", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// standardOutput<-print(token)
					{
						Object _arguments[] = { token_3_1 };
						Message message = new Message( self, standardOutput, "print", _arguments, token_3_1, token_3_2 );
						__messages.add( message );
					}
					// standardOutput<-println("The result should be printed out in order!")
					{
						Object _arguments[] = { "The result should be printed out in order!" };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_2, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==8) {{
				int size = 0;
				try {
					size = Integer.parseInt(args[1]);
				}
				catch (Exception e) {
				}

				JoinAndContTest[] actors = new JoinAndContTest[size];
				for (int i = 0; i<actors.length; i++){
					actors[i] = ((JoinAndContTest)new JoinAndContTest(this).construct());
				}
				{
					Token token_3_0 = new Token();
					Token token_3_1 = new Token();
					// join block
					token_3_0.setJoinDirector();
					for (int i = 0; i<actors.length; i++){
						{
							Token token_5_0 = new Token();
							Token token_5_1 = new Token();
							// actors[i]<-dummy()
							{
								Object _arguments[] = {  };
								Message message = new Message( self, actors[i], "dummy", _arguments, null, token_5_0 );
								__messages.add( message );
							}
							// returnStr("??")
							{
								Object _arguments[] = { "??" };
								Message message = new Message( self, self, "returnStr", _arguments, token_5_0, token_5_1 );
								__messages.add( message );
							}
							// actors[i]<-dummy()
							{
								Object _arguments[] = {  };
								Message message = new Message( self, actors[i], "dummy", _arguments, token_5_1, token_3_0 );
								__messages.add( message );
							}
						}
					}
					addJoinToken(token_3_0);
					// combine(token)
					{
						Object _arguments[] = { token_3_0 };
						Message message = new Message( self, self, "combine", _arguments, token_3_0, token_3_1 );
						__messages.add( message );
					}
					// standardOutput<-println(token)
					{
						Object _arguments[] = { token_3_1 };
						Message message = new Message( self, standardOutput, "println", _arguments, token_3_1, null );
						__messages.add( message );
					}
				}
			}
}			if (testcode==9) {{
				try {
					turns = Integer.parseInt(args[1]);
				}
				catch (Exception e) {
				}

				{
					// startRecursion()
					{
						Object _arguments[] = {  };
						Message message = new Message( self, self, "startRecursion", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}		}
		int turns = 0;
		ActorReference c1, c2;
		public void startRecursion() {
			c1 = ((JoinAndContTest)new JoinAndContTest(this).construct());
			c2 = ((JoinAndContTest)new JoinAndContTest(this).construct());
			{
				Token token_2_0 = new Token();
				// zero()
				{
					Object _arguments[] = {  };
					Message message = new Message( self, self, "zero", _arguments, null, token_2_0 );
					__messages.add( message );
				}
				// standardOutput<-println("\npassed continuation recursion tests")
				{
					Object _arguments[] = { "\npassed continuation recursion tests" };
					Message message = new Message( self, standardOutput, "println", _arguments, token_2_0, null );
					__messages.add( message );
				}
			}
		}
		public void zero() {
			turns--;
			System.out.print("0");
			if (turns>0) {{
				{
					Token token_3_0 = new Token();
					// join block
					token_3_0.setJoinDirector();
					{
						// c1<-callBack0()
						{
							Object _arguments[] = {  };
							Message message = new Message( self, c1, "callBack0", _arguments, null, token_3_0 );
							__messages.add( message );
						}
					}
					{
						// c2<-callBack0()
						{
							Object _arguments[] = {  };
							Message message = new Message( self, c2, "callBack0", _arguments, null, token_3_0 );
							__messages.add( message );
						}
					}
					addJoinToken(token_3_0);
					// first()
					{
						Object _arguments[] = {  };
						Message message = new Message( self, self, "first", _arguments, token_3_0, currentMessage.getContinuationToken() );
						__messages.add( message );
					}
					throw new CurrentContinuationException();
				}
			}
}		}
		public void callBack0() {
			System.out.print("a");
		}
		public void first() {
			System.out.print("1");
			{
				Token token_2_0 = new Token();
				// join block
				token_2_0.setJoinDirector();
				{
					// c1<-callBack1()
					{
						Object _arguments[] = {  };
						Message message = new Message( self, c1, "callBack1", _arguments, null, token_2_0 );
						__messages.add( message );
					}
				}
				{
					// c2<-callBack1()
					{
						Object _arguments[] = {  };
						Message message = new Message( self, c2, "callBack1", _arguments, null, token_2_0 );
						__messages.add( message );
					}
				}
				addJoinToken(token_2_0);
				// second()
				{
					Object _arguments[] = {  };
					Message message = new Message( self, self, "second", _arguments, token_2_0, currentMessage.getContinuationToken() );
					__messages.add( message );
				}
				throw new CurrentContinuationException();
			}
		}
		public void callBack1() {
			System.out.print("b");
		}
		public void second() {
			System.out.print("2");
			{
				Token token_2_0 = new Token();
				// join block
				token_2_0.setJoinDirector();
				{
					// c1<-callBack1()
					{
						Object _arguments[] = {  };
						Message message = new Message( self, c1, "callBack1", _arguments, null, token_2_0 );
						__messages.add( message );
					}
				}
				{
					// c2<-callBack1()
					{
						Object _arguments[] = {  };
						Message message = new Message( self, c2, "callBack1", _arguments, null, token_2_0 );
						__messages.add( message );
					}
				}
				addJoinToken(token_2_0);
				// zero()
				{
					Object _arguments[] = {  };
					Message message = new Message( self, self, "zero", _arguments, token_2_0, currentMessage.getContinuationToken() );
					__messages.add( message );
				}
				throw new CurrentContinuationException();
			}
		}
		public void callBack2() {
			System.out.print("c");
		}
		public String returnStr(String val) {
			return val;
		}
		public String showStr(String x1, Object[] data) {
			System.out.println(x1);
			for (int i = 0; i<data.length; i++){
				String str = (String)data[i];
				System.out.println(str);
			}
			return ": ";
		}
		public Integer dummy() {
			return new Integer(1);
		}
		public Integer add(Integer a, Integer b) {
			return new Integer(a.intValue()+b.intValue());
		}
		public Integer add(Object[] data) {
			int sum = 0;
			for (int i = 0; i<data.length; i++){
				sum += ((Integer)data[i]).intValue();
			}
			return new Integer(sum);
		}
		public void mergeDummy(Object[] args) {
			if (args.length==0) {{
				{
					// dummy()
					{
						Object _arguments[] = {  };
						Message message = new Message( self, self, "dummy", _arguments, null, null );
						__messages.add( message );
					}
				}
			}
}		}
		public Integer testCont(Integer i) {
			int j = i.intValue();
			if (i.intValue()>0) {{
				{
					// testCont(new Integer(j-1))
					{
						Object _arguments[] = { new Integer(j-1) };
						Message message = new Message( self, self, "testCont", _arguments, null, currentMessage.getContinuationToken() );
						__messages.add( message );
					}
					throw new CurrentContinuationException();
				}
			}
}			else {{
				return new Integer(0);
			}
}		}
		public Integer combine(Object[] data) {
			int sum = 0;
			for (int i = 0; i<data.length; i++){
				sum += ((Integer)data[i]).intValue();
			}
			return new Integer(sum);
		}
	}
}