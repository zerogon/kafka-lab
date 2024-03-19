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

public class SimpleConsumer_prac {
	private static final Logger logger = LoggerFactory.getLogger(SimpleConsumer_prac.class);
	private static final String TOPIC_NAME = "test";
	private static final String BOOTSTRAP_SERVERS = "tet:90";
	private static final String GROUPT_ID = "test-group";
	
	public static void main(String[] args) {
		Properties configs = new Properties();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUPT_ID);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);
		
		consumer.subscribe(Arrays.asList(TOPIC_NAME));
		
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
			for(ConsumerRecord<String, String> record : records) {
				logger.info("record:{}", record);
			}
			
			
			
		}
	}
	

}
