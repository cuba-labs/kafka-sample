# Example for Kafka Interaction

The example of interaction with Kafka from CUBA application. Key classes:
* `com.company.kafkasample.config.KafkaConfig` - configures all Kafka-related facilities. Based on the example from [the official Spring documentation](https://docs.spring.io/spring-kafka/docs/2.5.3.RELEASE/reference/html/#with-java-configuration).
* `com.company.kafkasample.service.KafkaSenderServiceBean` - sends messages to Kafka using `KafkaTemplate`
* `com.company.kafkasample.listeners.MessageListener` - receives messages from Kafka and stores them to the database.

## Application set up
* Install Kafka on your local computer using [the official guide](https://docs.confluent.io/current/quickstart/cos-docker-quickstart.html). Please note that 
for this sample configuration parameters are hardcoded in the `KafkaConfig` class. In the next version we might fix it.
 
* Checkout the application and start it in CUBA Studio or using Gradle. 
