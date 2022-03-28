package com.minyul.kafka.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class KafkaConsumerTest {

	@Autowired
	private KafkaConsumer consumer;

	@Autowired
	private KafkaProducer producer;

	@Value("${test.topic}")
	private String topic;

	@DisplayName("KafKa Test")
	@Test
	public void givenEmbeddedKafkaBroker_whenSendingtoSimpleProducer_thenMessageReceived()
					throws Exception {

		// when
		producer.send(topic, "Sending with own simple KafkaProducer");
		consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);

		// then
		assertThat(consumer.getLatch().getCount()).isEqualTo(0L);
	}
}
