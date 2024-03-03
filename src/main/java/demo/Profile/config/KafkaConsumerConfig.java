package demo.Profile.config;

import demo.Profile.constant.TopicConstants;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    private final String bootstrapServerConfig;

    public KafkaConsumerConfig(@Value("${spring.kafka.bootstrap-server}") final String bootstrapServerConfig) {
        this.bootstrapServerConfig = bootstrapServerConfig;
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        final Map<String, Object> configProps = Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServerConfig,
                ConsumerConfig.GROUP_ID_CONFIG, TopicConstants.GROUPS_PROFILE,
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class,
                JsonDeserializer.TYPE_MAPPINGS, KafkaUtils.extractTypeMappings()
        );

        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory(
            ConsumerFactory<String, Object> consumerFactory) {
        return new ConcurrentKafkaListenerContainerFactory<>() {{
            this.setConsumerFactory(consumerFactory);
        }};
    }
}