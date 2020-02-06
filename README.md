
[localhost:9001](http://localhost:9001/)

[localhost:9001/actuator](http://localhost:9001/actuator)

[localhost:9001/swagger-ui.html](http://localhost:9001/swagger-ui.html)

[localhost:9001/api/swagger.json](http://localhost:9001/api/swagger.json)

[localhost:9001/v2/api-docs](http://localhost:9001/v2/api-docs)

[localhost:9001/api/ping](http://localhost:9001/api/ping)

[localhost:9001/api/users/6](http://localhost:9001/api/users/6)

[localhost:9001/api/users/6/roles/2](http://localhost:9001/api/users/6/roles/2)

# first compile gwt app/project (ui)

./gradlew clean compileGwt

# to run from sources:

./gradlew clean bootRun

# to build and run:

./gradlew clean bootJar

cd server/build/libs

java -jar server-0.0.1-SNAPSHOT.jar

