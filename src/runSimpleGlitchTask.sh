java -cp salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./taskLogs/nameserver.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id1 todo.Server > ./taskLogs/serverSimpleGlitchSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id2 todo.User uan:\\localhost:3030\id1 Jason > ./taskLogs/user1SimpleGlitchSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id3 todo.User uan:\\localhost:3030\id1 Mason > ./taskLogs/user2SimpleGlitchSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id4 todo.User uan:\\localhost:3030\id1 Dan  > ./taskLogs/user3SimpleGlitchSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id5 todo.User uan:\\localhost:3030\id1 Chinki > ./taskLogs/user4SimpleGlitchSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id6 todo.User uan:\\localhost:3030\id1 pinku > ./taskLogs/user5SimpleGlitchSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id7 todo.TaskList > ./taskLogs/tasklistSimpleGlitchSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. todo.SimpleGlitchSimpleTodo uan:\\localhost:3030\id2 uan:\\localhost:3030\id3 uan:\\localhost:3030\id4 uan:\\localhost:3030\id5 uan:\\localhost:3030\id6 Jason Mason Dan Chinki pinku uan:\\localhost:3030\id7 > ./taskLogs/simpleGlitchSimpleTodo.txt 2>&1 &

sleep 20s

#python ParseSimpleGlitchTodo.py >> taskLogs/SimpleGlitchTaskResults.txt

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep User | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep todo | grep -v grep | awk '{print $2}' | xargs kill -9