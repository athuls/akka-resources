java -cp ./libs/salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./logs/nameserver.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id1 examples.chat.ServerKtKt > ./logs/serverFIFOSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id11 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id11 > ./logs/speaker1NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id12 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id12 > ./logs/speaker2NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id13 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id13 > ./logs/speaker3NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id14 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id14 > ./logs/speaker4NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id15 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id15 > ./logs/speaker5NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id16 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id16 > ./logs/speaker6NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id17 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id17 > ./logs/speaker7NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id18 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id18 > ./logs/speaker8NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id19 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id19 > ./logs/speaker9NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id20 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id20 > ./logs/speaker10NoConsistencySimple.txt 2>&1 &


java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Dnodie examples.chat.NoConsistency10Users uan://localhost:3030/id11 uan://localhost:3030/id12 uan://localhost:3030/id13 uan://localhost:3030/id14 uan://localhost:3030/id15 uan://localhost:3030/id16 uan://localhost:3030/id17 uan://localhost:3030/id18 uan://localhost:3030/id19 uan://localhost:3030/id20 100 > ./logs/simpleNoConsistency.txt 2>&1 &

sleep 60s

python ParseNoLayers.py 10 >> logs/NoConsistencyChatResults.txt

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep SpeakerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep ServerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep NoConsistency10Users | grep -v grep | awk '{print $2}' | xargs kill -9
