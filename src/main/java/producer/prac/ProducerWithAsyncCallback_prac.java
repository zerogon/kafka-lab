package producer.prac;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerWithAsyncCallback_prac {
	
	private static final String BOOTSTRAP_SERVER = "10";
	private static final String TOPIC_NAME ="TEst";
	
	
	public static void main(String[] args) {
		Properties configs = new Properties();
		
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(configs);
		ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, "key", "value");
		
		producer.send(record, new ProducerCallback_prac());
		producer.flush();
		producer.close();
		
		
	}
}
