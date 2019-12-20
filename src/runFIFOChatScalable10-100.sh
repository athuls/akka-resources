java -cp ./libs/salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./logs/nameserver.txt 2>&1 &

java -Xmx8192m -cp ./libs/salsa1.1.5.jar:. wwc.messaging.Theater  > ./logs/theatre.txt 2>&1 &

java -Xmx8192m -cp .:./libs/salsa1.1.5.jar   -Dual=rmsp://localhost:4040/id1 -Duan=uan://localhost:3030/id1 examples.chat.ServerKtKt

sleep 10s

java -Xmx1024m -cp .:./libs/salsa1.1.5.jar -Dnodie -Dnogc examples.chat.ScalableCreateUsers uan://localhost:3030/id1 /home/rohankasivis/akka-resources-11-02-19/src/logs 100 1000 1 200  localhost FIFOSimple  > ./logs/ScalableCreateUsers.txt 2>&1 &

sleep 10s

java -Xmx4096m -cp .:./libs/salsa1.1.5.jar -Dnodie -Dnogc examples.chat.FIFOScalableChat uan://localhost:3030/id1 /home/rohankasivis/akka-resources-11-02-19/src/logs 100 100 1 200 localhost > ./logs/simpleFIFO.txt 2>&1 &

sleep 80s

python ParseFIFO.py 10 >> logs/FIFOChatResults.txt

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Scalable | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep SpeakerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep ServerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Server | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep ScalableCreateUsers | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep FIFOScalableChat | grep -v grep | awk '{print $2}' | xargs kill -9
