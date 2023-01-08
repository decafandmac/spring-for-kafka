package com.decafandmac.sfk.configuration;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfiguration {

    /**
     * kafka 의 정보를 가져옴
     */
//    @Bean
//    public AdminClient adminClient(KafkaAdmin kafkaAdmin) {
//        return AdminClient.create(kafkaAdmin.getConfigurationProperties());
//    }

//    @Bean
//    public NewTopic createTopic() {
//        return TopicBuilder.name("clip2")
//                .build();
//    }

    /**
     * KafkaAdmin 이 생성되는 시점에 afterSingletonsInstantiated 가 호출되면서 초기화됨
     */
//    @Bean
//    public KafkaAdmin.NewTopics createTopics() {
//        return new KafkaAdmin.NewTopics(
//                TopicBuilder.name("clip2-part1").build(),
//                TopicBuilder.name("clip2-part2")
//                        .partitions(3)
//                        .replicas(1)
//                        .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60 * 60))
//                        .build()
//        );
//    }

    @Bean
    public KafkaAdmin.NewTopics createTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("clip3").build(),
                TopicBuilder.name("clip3-bytes").build(),
                TopicBuilder.name("clip3-request").build(),
                TopicBuilder.name("clip3-replies").build()
        );
    }
}
