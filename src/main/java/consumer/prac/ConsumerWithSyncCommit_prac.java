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

public class ConsumerWithSyncCommit_prac {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerWithSyncCommit_prac.class); 
	private static final String BOOTSTRAB_SERVERS = "10";
	private static final String GROUP_ID = "test";
	private static final String TOPIC_NAME = "test";
	
	public static void main(String[] args) {
		
		Properties conf = new Properties();
		
		conf.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAB_SERVERS);
		conf.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		conf.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		conf.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		conf.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(conf);
		
		consumer.subscribe(Arrays.asList(TOPIC_NAME));
	
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
			for(ConsumerRecord<String, String> record : records) {
				logger.info("{}", record);
			}
			consumer.commitAsync();
			
		}
		
		
		
		
		
		
		
		
	}

}
