# spring-native-samples

Sample spring-boot applications that use spring-native.

## Create the DB

```
docker run --name mysql -e MYSQL_DATABASE=testdb -e MYSQL_ROOT_PASSWORD=my-secret-pw -d -p 3306:3306 mysql:latest
```

## simple-jpa-maven

Maven based spring-boot application using spring-data JPA, Swagger UI, and spring-web MVC.

### Native compile (using GraalVM)

To compile, make sure `JAVA_HOME` points to GraalVM and then run:

```
./mvnw -Pnative clean package
```

To run the executable:

```
target/simple-jpa-maven
```

### Native compile (using buildpacks)

To compile, make sure `JAVA_HOME` points to regular JVM and Docker is running, then run:

```
./mvnw clean spring-boot:build-imag
```

To run the all-in-one JAR:

```
docker run -it -e 'SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/testdb' -p 8080:8080 simple-jpa-maven:1.0
```

## simple-jpa-gradle

Gradle based spring-boot application using spring-data JPA, Swagger UI, and spring-web MVC.

### Native compile (using GraalVM)

To compile, make sure `JAVA_HOME` points to GraalVM and then run:

```
./gradlew nativeCompile
```

To run the executable:

```
build/native/nativeCompile/simple-jpa-gradle
```

### Native compile (using buildpacks)

To compile, make sure `JAVA_HOME` points to regular JVM and Docker is running, then run:

```
./gradlew clean bootBuildImage
```

To run the all-in-one JAR:

```
docker run -it -e 'SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/testdb' -p 8080:8080 simple-jpa-gradle:1.0
```
