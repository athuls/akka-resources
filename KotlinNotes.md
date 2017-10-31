# Summary 
1) Kotlin can be compiled to Java, JS and native.
2) Javascript can be called from Java when run within Rhino (https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino)
3) Chat applications in Kotlin: 
   - https://objectpartners.com/2017/09/06/real-time-chat-application-with-kotlin-and-firebase/
   - https://github.com/FrangSierra/KotlinFirechat
3) For server-side, look at co-routines in Kotlin. Used for long-running operations such as network IO/file IO/CPU-GPU intensive work. 
4) Jack and Jill toolchain like approach where Jill compiler has the SALSA based translation (?). Need to think more. 

# Build system in Android
1) Java converted by javac and then by dx (transcoded from bytecode to bytecode) to dex bytecode, gets executed on Android-> creates the APK
2) Java Android Compiler Kit or JACK -> compiles JAVA source to dex bytecode directly. JILL converts the libraries in java bytecode separately for JACK to process.
3) Kotlin/Scala are JVM compatible and need to be processed as JAVA bytecode so handled by JILL
4) Android runtime (ART) converts the dex bytecode into machine code that can run on Android. 
5) ART has implementations for standard JAVA functions (as class files that are converted by dex by JILL) so they can be supported in higher level languages.
6) Dalvik VM is similar to JVM (but not identical): more suitable for resource constrained devices. JIT that converts dex to machine code as it is run
7) ART is newer one: takes dex and compiles to machine code. Comes with JIT for optimizing using runtime characteristics. Dex is stored as machine code instead of bytecode for performance.
8) Android NDK: include headers associated with libraries to use. Tell build system that the native module needs to link against libraries at load time. Uses JNI. Accesses sensors, etc.

# Javascript on Android
1) React native app: build mobile app using only javascript.
   - Can run native code if needed for performance. Partly in ReactNative and partly in Java.
   - JS communicates with native using "bridge". Lacks performance. 
   - Gives compatibility/cross platform development.
   - Otherwise need to wrap web app in web view
   - Can write native code if pre-built native (like Objetive C or C++ for iOS) is not enough and you need something custom. Its in objective-C and an interface for native runtime to run the classes.
     JS code can access this using a module name specifically for accessing native from JS. 
     Native code in ObjectiveC is made aware to JS. 
     At load time, the native code and JS code are linked. 
     During runtime, initialize and configure modules. In parallel load JS executor and JS code. 
     Load everything in JavaScriptCore VM, which is JS engine for android. It can run JS or JS bridged with native. Runtime written in C/C++ or Objective-C. There are JS engines like V8 and Rhino that have been ported to Android as well. JS calls translate to native calls using native modules.
     Cordova runs JS in a web browser, ReactNative has performance improvements over Cordova apps.
     ReactNAtive compiles to native code for performance. 
     Web apps on mobile aren not powerful enough, can act as icon and loader for web page. It does not feel the same as native app and does not work without network connection. Also needed functionality that what web page can do like access camera.
      
# Kotlin
1) Server-side web applications: Has coroutines for server side scalability with number of clients. 
   Like write HelloWorld and run in tomcat server.
2) Different bytecode on android than Java, but similar. As fast as Java (has inline functions so may run faster). Can use existing libraries in Java with Kotlin app.
3) Can call Java from Kotlin and vice-versa. Same for JS.
4) For JS transpiling: includes libraries but excludes JDK and JVM framework library used.
5) Integration with Jack and Jill toolchain. Currently planning to have it go through Jill compiler. Since Kotlin compiles to .class. 
   - So it is right now treated as second class in toolchain as it would not benefit from compile optimization speeds for Jack code. 
   - Still has runtime benefits though  
6) Kotlins compiler produces Java 6 bytecode. 
   When targeting JVM -> goes to java compatible bytecode. (Java 6 or Java 8)
   When targeting JS -> transpiles to ES5.1 to generate code which is compatible with module systems including AMD and commonjs. 
   When targeting native, produces platform specific code (via LLVM). Interoperable with C functions	
7) Coroutines: allow long-running operations to be blocked until they complete. Blocking replaced by suspension of co-routine. 
   Every suspending function is transformed to a state machine where states corresponding to suspending calls. Right before suspension, next state is stored in compiler generated class. Upon resumption of coroutine, local variables are restored and state machine proceeds from state right after suspension.
   Suspended object can be passed around as continuation.
