package producer.prac;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.InvalidRecordException;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

public class CustomPartitioner_prac implements Partitioner{


	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		
		if(keyBytes == null) {
			throw new InvalidRecordException("need message key");
		}
		if(((String)key).equals("pang")) {
			return 0;
		}
		List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
		int numPartions = partitions.size();
		
		return Utils.toPositive(Utils.murmur2(keyBytes) % numPartions);
	}

	
	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
