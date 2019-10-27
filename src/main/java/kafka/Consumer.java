package kafka;

import Interface.IKafkaConstants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {

    public String run() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", IKafkaConstants.KAFKA_BROKERS);
        properties.put("key.deserializer", IKafkaConstants.KEY_DESERIALIZER);
        properties.put("value.deserializer", IKafkaConstants.VALUE_DESERIALIZER);
        properties.put("group.id", IKafkaConstants.GROUP_ID);

        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
        List topics = new ArrayList();
        topics.add("devglan-test");
        kafkaConsumer.subscribe(topics);
        try{
            while (true){
                ConsumerRecords<String, String> records = kafkaConsumer.poll(10);
                for (ConsumerRecord<String, String> record: records){
                    System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", record.topic(), record.partition(), record.value()));
                    return record.value();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            kafkaConsumer.close();
        }
        System.out.println("AAAAAAAAAAAA");
        return "";
    }
}
