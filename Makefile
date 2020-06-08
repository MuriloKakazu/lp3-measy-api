run:
	docker-compose up --detach
	./gradlew bootRun

stop:
	docker-compose down
	./gradlew -stop