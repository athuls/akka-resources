java -cp salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./taskLogs/nameserver.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id1 todo.Server > ./taskLogs/serverCausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id2 todo.User uan:\\localhost:3030\id1 username1 > ./taskLogs/user1CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id3 todo.User uan:\\localhost:3030\id1 username2 > ./taskLogs/user2CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id4 todo.User uan:\\localhost:3030\id1 username3  > ./taskLogs/user3CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id5 todo.User uan:\\localhost:3030\id1 username4 > ./taskLogs/user4CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id6 todo.User uan:\\localhost:3030\id1 username5 > ./taskLogs/user5CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id7 todo.User uan:\\localhost:3030\id1 username6 > ./taskLogs/user6CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id8 todo.User uan:\\localhost:3030\id1 username7 > ./taskLogs/user7CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id9 todo.User uan:\\localhost:3030\id1 username8  > ./taskLogs/user8CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id10 todo.User uan:\\localhost:3030\id1 username9 > ./taskLogs/user9CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id11 todo.User uan:\\localhost:3030\id1 username10 > ./taskLogs/user10CausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id12 todo.TaskList > ./taskLogs/tasklistCausalSimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. todo.CausalAdvancedEndTodo uan:\\localhost:3030\id2 uan:\\localhost:3030\id3 uan:\\localhost:3030\id4 uan:\\localhost:3030\id5 uan:\\localhost:3030\id6 uan:\\localhost:3030\id7 uan:\\localhost:3030\id8 uan:\\localhost:3030\id9 uan:\\localhost:3030\id10 uan:\\localhost:3030\id11 uan:\\localhost:3030\id12 > ./taskLogs/simpleCausalTodo.txt 2>&1 &

sleep 30s

python parseCausalTodo.py >> taskLogs/CausalTaskResults.txt

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep User | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep todo | grep -v grep | awk '{print $2}' | xargs kill -9