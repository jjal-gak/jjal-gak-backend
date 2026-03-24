plugins {
	java
	id("org.springframework.boot") version "3.2.8"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.jjalgak"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot Starter (JPA, WAB, VALID)
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")                              
	implementation("org.springframework.boot:spring-boot-starter-validation")

	// Lombok
    compileOnly ("org.projectlombok:lombok")                                  
    annotationProcessor ("org.projectlombok:lombok")

	// MySQL, MongoDB, Redis
 	runtimeOnly ("com.mysql:mysql-connector-j")  
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.mongodb:mongodb-driver-sync")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
