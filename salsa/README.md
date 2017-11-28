# Prereqs
## Java 8
## Kotlin installation

1) curl -s https://get.sdkman.io | bash
2) In new window:
sdk install kotlin

# Execute
Run runChat.sh

The cleanup phase needs some fixing so for now, after each run of above script, run the following cleanup commands: 
ps -ef | grep Chat | grep -v grep | awk '{print $2}' | xargs kill -9  
ps -ef | grep Speaker | grep -v grep | awk '{print $2}' | xargs kill -9  
ps -ef | grep wwc | grep -v grep | awk '{print $2}' | xargs kill -9  
