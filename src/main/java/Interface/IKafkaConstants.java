package Interface;

public interface IKafkaConstants {

    public static String KAFKA_BROKERS = "localhost:9092";
    public static String KEY_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    public static String VALUE_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    public static String KEY_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    public static String VALUE_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    public static String GROUP_ID = "test-group";
//    public static Integer MESSAGE_COUNT=1000;
//    public static String CLIENT_ID="client1";
//    public static String TOPIC_NAME="demo";
//    public static String GROUP_ID_CONFIG="consumerGroup1";
//    public static Integer MAX_NO_MESSAGE_FOUND_COUNT=100;
//    public static String OFFSET_RESET_LATEST="latest";
//    public static String OFFSET_RESET_EARLIER="earliest";
//    public static Integer MAX_POLL_RECORDS=1;

}
