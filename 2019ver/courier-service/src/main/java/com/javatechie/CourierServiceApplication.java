package com.javatechie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CourierServiceApplication {

    Logger logger = LoggerFactory.getLogger(CourierServiceApplication.class);
    @StreamListener(Sink.INPUT)
    public void orderDispatched(List<Product> products)
    {
        for(Product product:products)
        {
            logger.info("product delivered"+product);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CourierServiceApplication.class, args);
    }

}
