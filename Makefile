run-dist:
	./build/install/app/bin/app
mkInstallDist:
	./gradlew clean
	./gradlew installDist
lint:
	./gradlew checkstyleMain
dependency:
	./gradlew dependencyUpdates
doc:
	./gradlew javadoc
.PHONY: test
test:
	./gradlew test
	./gradlew checkstyleMain
	./gradlew checkstyleMain
	./gradlew jacocoTestReport
