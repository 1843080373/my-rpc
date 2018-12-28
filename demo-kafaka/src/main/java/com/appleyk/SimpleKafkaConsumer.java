package com.appleyk;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SimpleKafkaConsumer {

    public static void main(String[] args) {

        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        //ÿ�������߷�����������
        props.put("group.id", "test");

        //���value�Ϸ������Զ��ύƫ����
        props.put("enable.auto.commit", "true");

        //���ö��һ�θ��±�������Ϣ��ƫ����
        props.put("auto.commit.interval.ms", "1000");

        //���ûỰ��Ӧ��ʱ�䣬�������ʱ��kafka����ѡ��������ѻ���������һ����Ϣ
        props.put("session.timeout.ms", "30000");

        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Collections.singletonList("test"));

        System.out.println("Subscribed to topic " + "test");
        int i = 0;

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)

                // print the offset,key and value for the consumer records.
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
        }
    }
}