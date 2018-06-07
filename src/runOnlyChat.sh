cd target/classes
mkdir libs
mkdir logs
cp ../../libs/* libs/
java -cp ./libs/salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./logs/nameserver.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id1 examples.chat.ServerKtKt > ./logs/server.txt 2>&1 &


java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id2 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id2 > ./logs/speaker1.txt 2>&1 &


java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id3 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id3 > ./logs/speaker2.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id4 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id4 > ./logs/speaker3.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Dnodie examples.chat.ChatKtKt uan:\\localhost:3030\id2 uan:\\localhost:3030\id3 uan:\\localhost:3030\id4 > ./logs/chat.txt 2>&1 &