java -cp ./libs/salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./logs/nameserver.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id1 examples.chat.ServerKtKt > ./logs/serverSimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id11 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id11 > ./logs/speaker1SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id12 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id12 > ./logs/speaker2SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id13 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id13 > ./logs/speaker3SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id14 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id14 > ./logs/speaker4SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id15 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id15 > ./logs/speaker5SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id16 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id16 > ./logs/speaker6SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id17 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id17 > ./logs/speaker7SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id18 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id18 > ./logs/speaker8SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id19 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id19 > ./logs/speaker9SimpleGlitchSimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id20 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id20 > ./logs/speaker10SimpleGlitchSimple.txt 2>&1 &


java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar  -Dnodie examples.chat.SimpleGlitch10Users uan://localhost:3030/id11 uan://localhost:3030/id12 uan://localhost:3030/id13 uan://localhost:3030/id14 uan://localhost:3030/id15 uan://localhost:3030/id16 uan://localhost:3030/id17 uan://localhost:3030/id18 uan://localhost:3030/id19 uan://localhost:3030/id20 100 > ./logs/SimpleGlitch10Users.txt 2>&1 &

sleep 40s

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep SpeakerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep ServerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep SimpleGlitch10Users | grep -v grep | awk '{print $2}' | xargs kill -9


