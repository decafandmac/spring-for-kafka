package com.decafandmac.sfk;

import com.decafandmac.sfk.producer.ClipProducer;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class SpringForKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringForKafkaApplication.class, args);
    }

//    @Bean
//    public ApplicationRunner runner(AdminClient adminClient) {
//        return args -> {
//            Map<String, TopicListing> topics = adminClient.listTopics().namesToListings().get();
//            for(String topicName : topics.keySet()) {
//                TopicListing topicListing = topics.get(topicName);
//                System.out.println(topicListing);
//
//                // topic 의 상세정보 조회
//                Map<String, TopicDescription> description = adminClient.describeTopics(Collections.singleton(topicName)).all().get();
//                System.out.println(description);
//
//                // topic 삭제
//                if(!topicListing.isInternal()) {
//                    adminClient.deleteTopics(Collections.singleton(topicName));
//                }
//            }
//        };
//    }

    @Bean
    public ApplicationRunner runner(ClipProducer clipProducer) {
        return args -> {
            clipProducer.async("clip3", "Hello, Clip3 async");
            clipProducer.sync("clip3", "Hello, Clip3 sync");
            clipProducer.routingSend("clip3", "Hello, Clip3 routing");
            clipProducer.routingSendBytes("clip3-bytes", "Hello, Clip3 bytes".getBytes(StandardCharsets.UTF_8));
            clipProducer.replyingSend("clip3-request", "Ping Clip3");
        };
    }

}
