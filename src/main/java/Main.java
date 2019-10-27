import Interface.IKafkaConstants;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Criado por Mariana
 * Data: 14/09/2019
 **/
public class Main {

    public static void main(String[] args) throws Exception{
        Buffer buffer = new Buffer();
        Semaphore semaphoreDownload = new Semaphore();
        Semaphore semaphoreReadURL = new Semaphore();

        new Thread(new ReadFile(buffer, semaphoreReadURL, semaphoreDownload)).start();

        while (semaphoreReadURL.getQtd() > 0 || semaphoreDownload.getQtd() > 0 ) {
            if (semaphoreDownload.getQtd() > 0) {
//            if (semaphoreDownload.getQtd() > 0 && !buffer.isEmpty()) {
                new Download(buffer).start();
                semaphoreDownload.removeQtd();
            }
        }
    }
}
