package producer.prac;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProducer_prac {
	
	private static final Logger loger = LoggerFactory.getLogger(SimpleProducer_prac.class);
	private static final String TOPIC_NAME = "test";
	private static final String BOOTSTRAP_SERVERS = "10.10.10.10:9092";
	
	public static void main(String[] args) {
		Properties configs = new Properties();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(configs);
		
		String testMessage = "test";
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC_NAME, testMessage);
		
		producer.send(record);
		loger.info("{}", record);
		producer.flush();
		producer.close();
		
		
	}
}
