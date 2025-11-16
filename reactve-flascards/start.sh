gradle clean
gradle bootJar
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar build/libs/reactve-flascards-1.0.0.jar