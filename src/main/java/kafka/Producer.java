package kafka;

import Interface.IKafkaConstants;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {

    public void run(String URLImage) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", IKafkaConstants.KAFKA_BROKERS);
        properties.put("key.serializer", IKafkaConstants.KEY_SERIALIZER);
        properties.put("value.serializer", IKafkaConstants.VALUE_SERIALIZER);

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        try{
//            for(int i = 0; i < 100; i++){
                System.out.println(URLImage);
                kafkaProducer.send(new ProducerRecord("devglan-test", Integer.toString(1), URLImage ));
//            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaProducer.close();
        }
    }
}
