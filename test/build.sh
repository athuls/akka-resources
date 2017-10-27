kotlinc Foo.kt -d Foo.jar
#javac -cp Foo.jar JavaClass.java
#java -cp Foo.jar:. JavaClass
java -cp salsa1.1.5.jar:. salsac.SalsaCompiler HelloWorld.salsa
#javac -classpath salsa1.1.5.jar:. HelloWorld.java
javac -cp Foo.jar:salsa1.1.5.jar:. JavaClass.java HelloWorld.java
java -cp salsa1.1.5.jar:Foo.jar:. JavaClass
