package com.example.stringsource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableBinding(Source.class)
public class StringSourceApplication {

    Logger logger = LoggerFactory.getLogger(StringSourceApplication.class);

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,poller= @Poller(fixedDelay = "10000",maxMessagesPerPoll = "1"))
    public MessageSource<List<String>> addProducts()
    {
        List<String> products = Stream.of("Saad","college","dropout","123","hurdman").collect(Collectors.toList());
        logger.info("strings: {}",products);
        return()-> MessageBuilder.withPayload(products).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(StringSourceApplication.class, args);
    }

}
