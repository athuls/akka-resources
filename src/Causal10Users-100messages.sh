java -cp ./libs/salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./logs/nameserver.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id1 examples.chat.ServerKtKt > ./logs/serverFIFOSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id11 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id11 > ./logs/speaker1CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id12 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id12 > ./logs/speaker2CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id13 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id13 > ./logs/speaker3CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id14 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id14 > ./logs/speaker4CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id15 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id15 > ./logs/speaker5CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id16 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id16 > ./logs/speaker6CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id17 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id17 > ./logs/speaker7CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id18 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id18 > ./logs/speaker8CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id19 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id19 > ./logs/speaker9CausalSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id20 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id20 > ./logs/speaker10CausalSimple.txt 2>&1 &


java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar  -Dnodie examples.chat.Causal10Users uan://localhost:3030/id11 uan://localhost:3030/id12 uan://localhost:3030/id13 uan://localhost:3030/id14 uan://localhost:3030/id15 uan://localhost:3030/id16 uan://localhost:3030/id17 uan://localhost:3030/id18 uan://localhost:3030/id19 uan://localhost:3030/id20 100 > ./logs/simpleCausal.txt 2>&1 &

sleep 3600s

python ParseCausal.py 10 >> logs/CausalChatResults.txt

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep SpeakerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep ServerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep Causal100Users | grep -v grep | awk '{print $2}' | xargs kill -9


