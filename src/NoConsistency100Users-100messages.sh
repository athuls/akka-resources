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

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id21 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id21 > ./logs/speaker11NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id22 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id22 > ./logs/speaker12NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id23 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id23 > ./logs/speaker13NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id24 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id24 > ./logs/speaker14NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id25 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id25 > ./logs/speaker15NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id26 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id26 > ./logs/speaker16NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id27 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id27 > ./logs/speaker17NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id28 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id28 > ./logs/speaker18NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id29 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id29 > ./logs/speaker19NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id30 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id30 > ./logs/speaker20NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id31 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id31 > ./logs/speaker21NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id32 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id32 > ./logs/speaker22NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id33 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id33 > ./logs/speaker23NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id34 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id34 > ./logs/speaker24NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id35 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id35 > ./logs/speaker25NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id36 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id36 > ./logs/speaker26NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id37 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id37 > ./logs/speaker27NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id38 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id38 > ./logs/speaker28NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id39 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id39 > ./logs/speaker29NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id40 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id40 > ./logs/speaker30NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id41 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id41 > ./logs/speaker31NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id42 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id42 > ./logs/speaker32NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id43 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id43 > ./logs/speaker33NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id44 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id44 > ./logs/speaker34NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id45 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id45 > ./logs/speaker35NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id46 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id46 > ./logs/speaker36NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id47 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id47 > ./logs/speaker37NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id48 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id48 > ./logs/speaker38NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id49 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id49 > ./logs/speaker39NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id50 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id50 > ./logs/speaker40NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id51 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id51 > ./logs/speaker41NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id52 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id52 > ./logs/speaker42NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id53 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id53 > ./logs/speaker43NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id54 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id54 > ./logs/speaker44NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id55 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id55 > ./logs/speaker45NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id56 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id56 > ./logs/speaker46NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id57 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id57 > ./logs/speaker47NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id58 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id58 > ./logs/speaker48NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id59 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id59 > ./logs/speaker49NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id60 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id60 > ./logs/speaker50NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id61 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id61 > ./logs/speaker51NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id62 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id62 > ./logs/speaker52NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id63 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id63 > ./logs/speaker53NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id64 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id64 > ./logs/speaker54NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id65 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id65 > ./logs/speaker55NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id66 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id66 > ./logs/speaker56NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id67 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id67 > ./logs/speaker57NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id68 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id68 > ./logs/speaker58NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id69 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id69 > ./logs/speaker59NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id70 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id70 > ./logs/speaker60NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id71 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id71 > ./logs/speaker61NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id72 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id72 > ./logs/speaker62NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id73 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id73 > ./logs/speaker63NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id74 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id74 > ./logs/speaker64NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id75 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id75 > ./logs/speaker65NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id76 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id76 > ./logs/speaker66NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id77 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id77 > ./logs/speaker67NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id78 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id78 > ./logs/speaker68NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id79 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id79 > ./logs/speaker69NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id80 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id80 > ./logs/speaker70NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id81 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id81 > ./logs/speaker71NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id82 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id82 > ./logs/speaker72NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id83 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id83 > ./logs/speaker73NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id84 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id84 > ./logs/speaker74NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id85 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id85 > ./logs/speaker75NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id86 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id86 > ./logs/speaker76NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id87 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id87 > ./logs/speaker77NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id88 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id88 > ./logs/speaker78NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id89 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id89 > ./logs/speaker79NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id90 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id90 > ./logs/speaker80NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id91 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id91 > ./logs/speaker81NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id92 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id92 > ./logs/speaker82NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id93 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id93 > ./logs/speaker83NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id94 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id94 > ./logs/speaker84NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id95 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id95 > ./logs/speaker85NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id96 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id96 > ./logs/speaker86NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id97 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id97 > ./logs/speaker87NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id98 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id98 > ./logs/speaker88NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id99 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id99 > ./logs/speaker89NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id100 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id100 > ./logs/speaker90NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id101 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id101 > ./logs/speaker91NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id102 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id102 > ./logs/speaker92NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id103 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id103 > ./logs/speaker93NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id104 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id104 > ./logs/speaker94NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id105 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id105 > ./logs/speaker95NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id106 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id106 > ./logs/speaker96NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id107 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id107 > ./logs/speaker97NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id108 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id108 > ./logs/speaker98NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id109 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id109 > ./logs/speaker99NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar -Duan=uan://localhost:3030/id110 examples.chat.SpeakerKtKt  uan://localhost:3030/id1 uan://localhost:3030/id110 > ./logs/speaker100NoConsistencySimple.txt 2>&1 &

java -cp .:./libs/kotlin-runtime-1.2.20-dev-331.jar:./libs/salsa1.1.5.jar  -Dnodie examples.chat.NoConsistency100Users uan://localhost:3030/id11 uan://localhost:3030/id12 uan://localhost:3030/id13 uan://localhost:3030/id14 uan://localhost:3030/id15 uan://localhost:3030/id16 uan://localhost:3030/id17 uan://localhost:3030/id18 uan://localhost:3030/id19 uan://localhost:3030/id20 uan://localhost:3030/id21 uan://localhost:3030/id22 uan://localhost:3030/id23 uan://localhost:3030/id24 uan://localhost:3030/id25 uan://localhost:3030/id26 uan://localhost:3030/id27 uan://localhost:3030/id28 uan://localhost:3030/id29 uan://localhost:3030/id30 uan://localhost:3030/id31 uan://localhost:3030/id32 uan://localhost:3030/id33 uan://localhost:3030/id34 uan://localhost:3030/id35 uan://localhost:3030/id36 uan://localhost:3030/id37 uan://localhost:3030/id38 uan://localhost:3030/id39 uan://localhost:3030/id40 uan://localhost:3030/id41 uan://localhost:3030/id42 uan://localhost:3030/id43 uan://localhost:3030/id44 uan://localhost:3030/id45 uan://localhost:3030/id46 uan://localhost:3030/id47 uan://localhost:3030/id48 uan://localhost:3030/id49 uan://localhost:3030/id50 uan://localhost:3030/id51 uan://localhost:3030/id52 uan://localhost:3030/id53 uan://localhost:3030/id54 uan://localhost:3030/id55 uan://localhost:3030/id56 uan://localhost:3030/id57 uan://localhost:3030/id58 uan://localhost:3030/id59 uan://localhost:3030/id60 uan://localhost:3030/id61 uan://localhost:3030/id62 uan://localhost:3030/id63 uan://localhost:3030/id64 uan://localhost:3030/id65 uan://localhost:3030/id66 uan://localhost:3030/id67 uan://localhost:3030/id68 uan://localhost:3030/id69 uan://localhost:3030/id70 uan://localhost:3030/id71 uan://localhost:3030/id72 uan://localhost:3030/id73 uan://localhost:3030/id74 uan://localhost:3030/id75 uan://localhost:3030/id76 uan://localhost:3030/id77 uan://localhost:3030/id78 uan://localhost:3030/id79 uan://localhost:3030/id80 uan://localhost:3030/id81 uan://localhost:3030/id82 uan://localhost:3030/id83 uan://localhost:3030/id84 uan://localhost:3030/id85 uan://localhost:3030/id86 uan://localhost:3030/id87 uan://localhost:3030/id88 uan://localhost:3030/id89 uan://localhost:3030/id90 uan://localhost:3030/id91 uan://localhost:3030/id92 uan://localhost:3030/id93 uan://localhost:3030/id94 uan://localhost:3030/id95 uan://localhost:3030/id96 uan://localhost:3030/id97 uan://localhost:3030/id98 uan://localhost:3030/id99 uan://localhost:3030/id100 uan://localhost:3030/id101 uan://localhost:3030/id102 uan://localhost:3030/id103 uan://localhost:3030/id104 uan://localhost:3030/id105 uan://localhost:3030/id106 uan://localhost:3030/id107 uan://localhost:3030/id108 uan://localhost:3030/id109 uan://localhost:3030/id110 100 > ./logs/Causal100users.txt 2>&1 &

sleep 1200s

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep SpeakerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep ServerKtKt | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep NoConsistency100Users | grep -v grep | awk '{print $2}' | xargs kill -9


