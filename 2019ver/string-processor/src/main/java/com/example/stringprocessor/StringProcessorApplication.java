package com.example.stringprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.Transformer;
import org.springframework.cloud.stream.messaging.Processor;
//import javax.annotation.processing.Processor;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableBinding(Processor.class)
public class StringProcessorApplication {

    Logger logger = LoggerFactory.getLogger(StringProcessorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StringProcessorApplication.class, args);
    }

    @Transformer(inputChannel=Processor.INPUT, outputChannel = org.springframework.cloud.stream.messaging.Processor.OUTPUT)
    public List<String> addDiscountToProduct(List<String> words)
    {
        List<String> processed=new ArrayList<>();
        for (String word:words)
        {

                processed.add(word+"1000");
                logger.info("string before adding {},after adding {}",word,word+"1000");
        }
        return processed;
    }
}
