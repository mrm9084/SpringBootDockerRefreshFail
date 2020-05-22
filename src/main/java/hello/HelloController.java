/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final Logger LOGGER= LoggerFactory.getLogger(HelloController.class);
    
    private final MessageProperties properties;
    
    @Autowired
    private EventProducerAsync producer;


    public HelloController(MessageProperties properties) {
        this.properties = properties;
    }

    @GetMapping
    public String getMessage() {
        return "Message: " + properties.getMessage();
    }
    
    @GetMapping("/refresh")
    public void refresh() {
    LOGGER.info("refresh-begin");
    producer.asyncRefresh();
    LOGGER.info("refresh-end");
    }

}
