java -cp ./libs/salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./logs/nameserver.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id1 examples.chat.ServerKtKt > ./logs/serverSimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id2 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id2 > ./logs/speaker1SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id3 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id3 > ./logs/speaker2SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id4 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id4 > ./logs/speaker3SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id5 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id5 > ./logs/speaker4SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id6 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id6 > ./logs/speaker5SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id7 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id7 > ./logs/speaker6SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id8 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id8 > ./logs/speaker7SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id9 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id9 > ./logs/speaker8SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id10 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id10 > ./logs/speaker9SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan:\\localhost:3030\id11 examples.chat.SpeakerKtKt uan:\\localhost:3030\id1 uan:\\localhost:3030\id11 > ./logs/speaker10SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Dnodie examples.chat.SimpleGlitchAdvancedChat uan:\\localhost:3030\id2 uan:\\localhost:3030\id3 uan:\\localhost:3030\id4 uan:\\localhost:3030\id5 uan:\\localhost:3030\id6 uan:\\localhost:3030\id7 uan:\\localhost:3030\id8 uan:\\localhost:3030\id9 uan:\\localhost:3030\id10 uan:\\localhost:3030\id11 > ./logs/simpleGlitchSimple.txt 2>&1 &

sleep 15s

python ParseSimpleGlitch.py 10 >> logs/SimpleGlitchChatResults.txt

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep SpeakerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep ServerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9