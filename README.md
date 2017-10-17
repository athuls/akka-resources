# akka-resources

1) Scalable Spreadsheets for Interactive Data Analysis: In interactive data-centric applications, the scalability could come from the amount of data that needs to be manipulated and the complex queries that need to be done on the data (not necessarily scale on the number of clients/users accessing the data. Also we can look at integrating different data sources on the backend, while the spreadsheet provides the visual interface for manipulating it (the message interface in actors could be used here). 
Relevant references:
   - [Object Spreadsheets](https://sdg.csail.mit.edu/sites/default/files/documents/objsheets-onward2016.pdf)
   - [DataSpread](http://data-people.cs.illinois.edu/papers/data-spread-demo.pdf)
   - [Scalable Spreadsheets for Interactive Data Analysis](http://www.almaden.ibm.com/cs/dmkd/papers/raman.ps)

2) Kotlin and Java are interoperable and Kotlin is being adopted widely for mobile app development. So integrating with SALSA in the backend? 
   - [Notes](KotlinNotes.md)

3) Akka persistence: Provides stateful actors that persist internal state so that it can be recovered upon migration or when an actor is restarted after a crash. 
   - https://groups.google.com/forum/#!topic/akka-user/iGf9XJ1k204
   - https://doc.akka.io/docs/akka/current/scala/persistence.html
   - https://martinfowler.com/eaaDev/EventSourcing.html

4) ReactiveMongo: Reactive Scala driver for MongoDB, a fully asynchronous and non-blocking IO for scalability using Futures
   - http://reactivemongo.org/
  
5) MongoDB Casbah: Scala toolkit for MongoDB (on top of java driver for MongoDB). Provides scala-friendly syntax on top of MongoDB. E.g. scala lists will be serialized to something java driver can serialize.
   - https://mongodb.github.io/casbah/
   
6) Akka-persistence-Casbah: Akka persistence backed by MongoDB Casbah
   - https://github.com/scullxbones/akka-persistence-mongo
   - https://github.com/ironfish/akka-persistence-mongo (deprecated)
   
7) Building a REST service in Scala with Akka HTTP, Akka Streams and reactive mongo
   - http://www.smartjava.org/content/building-rest-service-scala-akka-http-akka-streams-and-reactive-mongo
   
8) Akka HTTP
   - https://doc.akka.io/docs/akka-http/current/scala/http/
   
9) Spray.IO: Building REST/HTTP-based integration layers on top of Scala and Akka. Scala libraries providing client/server side REST/HTTP support on top of Akka
   - http://spray.io/
  
10) Play framework
   - https://www.playframework.com/documentation/2.6.x/JavaAkka
   - https://www.playframework.com/documentation/2.6.x/ScalaAkka

11) Sunny.js
   - https://github.com/aleksandarmilicevic/sunny.js/tree/master/examples

# Meeting minutes
1) [10-17-2017](Meeting_10_17_17.md)

