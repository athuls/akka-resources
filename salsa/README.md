# Prereqs
## Java 8
## Kotlin installation

1) curl -s https://get.sdkman.io | bash
2) In new window: sdk install kotlin

# Build
1) cd akka-resources/salsa
2) sh preBuild.sh
3) mvn clean package

# Execute 
1) ./runOnlyChat.sh

# View output
Log files with output from server, speakers (chat clients), etc. available at target/classes/logs 
