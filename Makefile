typescript-test:
	cd typescript && npx tsc

maven-test:
	cd java && mvn test

.PHONY: typescript-test maven-test
