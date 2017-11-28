LIBS=./libs
VERSION=1.1.5
LOGS=./logs
NAMESERVERLOGS=nameserver.txt
SPEAKERLOGS=speaker.txt

# Colors for output
RED='\033[0;31m'
NC='\033[0m'
BLUE='\033[0;32m'


# Don't touch libs directory
#if [ -d $LIBS ]; then
#	rm -rf $LIBS
#fi
echo "Making libs dir if it doesn't exist: "$LIBS
mkdir -p $LIBS
echo ""

if [ -d $LOGS ]; then
	rm -rf $LOGS
fi
echo "Making logs dir: "$LOGS
mkdir $LOGS
echo ""

echo "${BLUE}##################### Creating salsa jar file #####################${NC}"
/bin/bash ./buildSalsa.sh
echo "${BLUE}##################### Created salsa jar file #####################${NC}"

echo "Copying SALSA jar to libs folder"
cp salsa$VERSION.jar $LIBS/

#kotlinc examples/chat/SpeakerKt.kt -d $LIBS/SpeakerKt.jar
#kotlinc examples/chat/ChatKt.kt -d $LIBS/ChatKt.jar

echo "${BLUE}##################### Converting SALSA to java code #####################${NC}"
java -cp $LIBS/salsa1.1.5.jar:. salsac.SalsaCompiler examples/chat/Speaker.salsa
java -cp $LIBS/salsa1.1.5.jar:. salsac.SalsaCompiler examples/chat/Chat.salsa
echo "${BLUE}##################### Converted SALSA to java code #####################${NC}"

echo "${BLUE}##################### Compiling SALSA code, that was previously converted to java #####################${NC}"
javac -cp $LIBS/SpeakerKt.jar:$LIBS/ChatKt.jar:$LIBS/salsa$VERSION.jar:examples/chat:. examples/chat/SpeakerInterface.java examples/chat/Speaker.java
javac -cp $LIBS/SpeakerKt.jar:$LIBS/ChatKt.jar:$LIBS/salsa$VERSION.jar:examples/chat:. examples/chat/ChatInterface.java examples/chat/Chat.java
echo "${BLUE}##################### Compiled SALSA code, that was previously converted to java #####################${NC}"


echo "Running SALSA nameserver now"
#if [ -e $NAMESERVER ]; then
#	rm $NAMESERVER
#fi

java -cp $LIBS/salsa$VERSION.jar:. wwc.naming.WWCNamingServer -p 3030 > $LOGS/$NAMESERVERLOGS 2>&1 &

if [ $? -eq 0 ]; then
	echo "${BLUE}##################### Successfully run nameserver #####################${NC}"
else
	echo "${RED}Failed to run nameserver${NC}"
	exit 1
fi

#echo "Killing any existing Speaker services"
#ps -ef | grep SpeakerInterface | grep -v grep | awk '{print $2}' | xargs kill -9

#java -cp salsa1.5.jar:. -Duan=uan:\\localhost:3030\id2 examples.chat.Speaker John
#java -cp $LIBS/salsa$VERSION.jar:$LIBS/ChatKt.jar:$LIBS/SpeakerKt.jar:. -Duan=uan:\\localhost:3030\id1 examples.chat.SpeakerInterface "John"  > $LOGS/$SPEAKERLOGS 2>&1 &

#echo $! >> $NAMESERVER
#java -cp salsa1.1.5.jar:Foo.jar:. JavaClass

javac examples/chat/SpeakerInterface.java
kotlinc -cp .:./examples/chat examples/chat/SpeakerKt.kt
echo "${BLUE}Compiled speaker code in kotlin${NC}"

javac examples/chat/ChatInterface.java
kotlinc -cp .:./examples/chat examples/chat/ChatKt.kt
echo "${BLUE}Compiled chat code in kotlin${NC}"

echo "${BLUE}##################### Launching speaker with name John #####################${NC}"
java -cp .:$LIBS/kotlin-runtime-1.2.20-dev-331.jar:$LIBS/salsa1.1.5.jar -Duan=uan:\\nameserver\id1 examples.chat.SpeakerKtKt John &
sleep 1
echo "${BLUE}##################### Launching speaker with name Jack #####################${NC}"
java -cp .:$LIBS/kotlin-runtime-1.2.20-dev-331.jar:$LIBS/salsa1.1.5.jar -Duan=uan:\\nameserver\id2 examples.chat.SpeakerKtKt Jack &
sleep 1
echo "${BLUE}Launched 2 speakers with names John and Jack${NC}"

echo ""
echo ""

echo "${BLUE}##################### Initiating chat conversation ##########################${NC}"
java -cp .:$LIBS/kotlin-runtime-1.2.20-dev-331.jar:$LIBS/salsa1.1.5.jar -Dnodie examples.chat.ChatKtKt uan:\\nameserver\id1 uan:\\nameserver\id2 &
sleep 2

echo "${BLUE}##################### Killing any existing Chat and Speaker services #####################${NC}"
ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Speaker | grep -v grep | awk '{print $2}' | xargs kill -9

echo "${BLUE}##################### Killing any existing SALSA nameservers #####################${NC}"
ps -ef | grep wwc | grep -v grep | awk '{print $2}' | xargs kill -9
