.PHONY: test
run-dist:
	./build/install/app/bin/app -f=plain /home/oleg/IdeaProjects/java-project-71/app/src/test/resources/fixtures/file1.json /home/oleg/IdeaProjects/java-project-71/app/src/test/resources/fixtures/file2.json

mkInstallDist:
	./gradlew clean
	./gradlew installDist
lint:
	./gradlew checkstyleMain
dependency:
	./gradlew dependencyUpdates
doc:
	./gradlew javadoc
run-test:
	./gradlew test
	./gradlew checkstyleMain
	./gradlew jacocoTestReport
