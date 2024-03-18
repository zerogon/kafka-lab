package producer.prac;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProducer_prac02 {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleProducer_prac02.class);
	private static final String BOTSTRAP_SERVERS = "10.10.10.10:9020";
	private static final String TOPIC_NAME ="Test";
	
	public static void main(String[] args) {
		
		Properties configs = new Properties();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOTSTRAP_SERVERS);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(configs);
		String value = "Test";
		ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, value);
		
		producer.send(record);
		logger.info("{}", record);
		producer.flush();
		producer.close();
		
		
		
		
	}
}
