package com.javatechie;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

@SpringBootApplication
@EnableBinding(Processor.class)
public class DiscountServiceApplication {

    Logger logger = LoggerFactory.getLogger(DiscountServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DiscountServiceApplication.class, args);
    }

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public List<Product> addDiscountToProduct(List<Product> products)
    {
        List<Product> processed=new ArrayList<>();
        for (Product product:products)
        {
            double price=product.getPrice();
            if (price>8000)
            {
                product.setPrice(product.getPrice()*90/100);
                 processed.add(product);
                 logger.info("product actual price {},after discount{}"+Double.toString((product.getPrice() )*100/90)+Double.toString((product.getPrice() )));
            }
            else if (price>5000)
            {
                product.setPrice(product.getPrice()*95/100);
                processed.add(product);
                logger.info("product actual price {},after discount{}"+Double.toString((product.getPrice() )*100/90)+Double.toString((product.getPrice() )));
            }
        }
        return processed;
    }
}
