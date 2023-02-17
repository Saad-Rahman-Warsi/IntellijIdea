package com.javatechie.spring.cloud.stream.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

//import java.awt.print.Book;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamSinkApplication {

    private Logger logger= LoggerFactory.getLogger(SpringCloudStreamSinkApplication.class);

    @StreamListener("input")
    public void consumeMessage(Book book)
    {
        logger.info("consume payload"+book);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamSinkApplication.class, args);
    }


}