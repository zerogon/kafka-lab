package consumer.prac;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleConsumer_prac02 {
	private static final Logger logger = LoggerFactory.getLogger(SimpleConsumer_prac02.class);
	private static final String TOPIC_NAME = "tt";
	private static final String BOOTSTRAB_SERVERS = ":9";
	private static final String GROUP_ID = "tt";
	
	public static void main(String[] args) {
		Properties configs = new Properties();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAB_SERVERS);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);
		
		consumer.subscribe(Arrays.asList(TOPIC_NAME));
		
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(0));
			for(ConsumerRecord<String, String> record : records) {
				logger.info("Record:{}",record);
			}
		}
		
		
	}
	
	
}
