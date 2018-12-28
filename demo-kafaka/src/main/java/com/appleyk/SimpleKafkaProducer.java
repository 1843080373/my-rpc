package com.appleyk;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class SimpleKafkaProducer {

    public static void main(String[] args) {

        Properties props = new Properties();

        //broker��ַ
        props.put("bootstrap.servers", "localhost:9092");

        //����ʱ����Ҫ��֤
        props.put("acks", "all");

        //����ʧ��ʱ����Ҫ����
        props.put("retries", 0);

        //�ڴ滺������С
        props.put("buffer.memory", 33554432);

        //ָ����Ϣkey���л���ʽ
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
	
        //ָ����Ϣ��������л���ʽ
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(props);

        for (int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i+10)));
        System.out.println("Message sent successfully");
        producer.close();
    }
}