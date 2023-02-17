package com.example.stringsink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.List;

@SpringBootApplication
@EnableBinding(Sink.class)
public class StringSinkApplication {

    Logger logger = LoggerFactory.getLogger(StringSinkApplication.class);
    @StreamListener(Sink.INPUT)
    public void orderDispatched(List<String> words)
    {
        for(String word:words)
        {
            logger.info("there you go : "+word);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(StringSinkApplication.class, args);
    }

}
