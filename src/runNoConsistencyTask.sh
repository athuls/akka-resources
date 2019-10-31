java -cp salsa1.1.5.jar:. wwc.naming.WWCNamingServer -p 3030 > ./taskLogs/nameserver.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id1 todo.Server > ./taskLogs/serverNoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id2 todo.User uan:\\localhost:3030\id1 username1 > ./taskLogs/user1NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id3 todo.User uan:\\localhost:3030\id1 username2 > ./taskLogs/user2NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id4 todo.User uan:\\localhost:3030\id1 username3 > ./taskLogs/user3NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id5 todo.User uan:\\localhost:3030\id1 username4 > ./taskLogs/user4NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id6 todo.User uan:\\localhost:3030\id1 username5 > ./taskLogs/user5NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id7 todo.User uan:\\localhost:3030\id1 username6 > ./taskLogs/user6NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id8 todo.User uan:\\localhost:3030\id1 username7 > ./taskLogs/user7NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id9 todo.User uan:\\localhost:3030\id1 username8 > ./taskLogs/user8NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id10 todo.User uan:\\localhost:3030\id1 username9 > ./taskLogs/user9NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id11 todo.User uan:\\localhost:3030\id1 username10 > ./taskLogs/user10NoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. -Duan=uan:\\localhost:3030\id12 todo.TaskList > ./taskLogs/tasklistNoConsistencySimple.txt 2>&1 &
java -cp libs/salsa1.1.5.jar:. todo.NoConsistencyAdvancedTodo uan:\\localhost:3030\id2 uan:\\localhost:3030\id3 uan:\\localhost:3030\id4 uan:\\localhost:3030\id5 uan:\\localhost:3030\id6 uan:\\localhost:3030\id7 uan:\\localhost:3030\id8 uan:\\localhost:3030\id9 uan:\\localhost:3030\id10 uan:\\localhost:3030\id11 uan:\\localhost:3030\id12 > ./taskLogs/simpleTodoNoConsistency.txt 2>&1 &

sleep 30s

#python ParseNoLayersTodo.py >> taskLogs/NoConsistencyTasksResults.txt

ps -ef | grep WWCNamingServer | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep User | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep todo | grep -v grep | awk '{print $2}' | xargs kill -9