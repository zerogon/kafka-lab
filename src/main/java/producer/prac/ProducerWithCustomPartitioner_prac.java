package producer.prac;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerWithCustomPartitioner_prac {
	private static final String BOTSTRAP_SERVERS = "10:920";
	private static final String TOPIC_NAME = "test";
	
	public static void main(String[] args) {
		Properties configs = new Properties();
		
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOTSTRAP_SERVERS);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner_prac02.class);
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(configs);
		String test = "Test";
		ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, "key", test);
		
		producer.send(record);
		producer.flush();
		producer.close();
		
		
		
	}

}
