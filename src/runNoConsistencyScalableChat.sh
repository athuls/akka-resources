java -cp ./libs/salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./logs/nameserver.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id1 examples.chat.ServerKtKt > ./logs/serverNoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id2 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id2 > ./logs/speaker1NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id3 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id3 > ./logs/speaker2NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id4 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id4 > ./logs/speaker3NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id5 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id5 > ./logs/speaker4NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id6 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id6 > ./logs/speaker5NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Dnodie examples.chat.NoConsistencySimpleChat uan:\\localhost:3030\id2 uan:\\localhost:3030\id3 uan:\\localhost:3030\id4 uan:\\localhost:3030\id5 uan:\\localhost:3030\id6 > ./logs/simpleNoConsistency.txt 2>&1 &

sleep 20s

#python ParseNoLayers.py >> logs/NoConsistencyChatResults.txt

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep SpeakerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep ServerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9