package com.example.spring.cloud.stream.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamConsumerApplication {

    private Logger logger= LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);

    @StreamListener("input")
    public void consumeMessage(Book book)
    {
        logger.info("consume payload"+book);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
    }


}
