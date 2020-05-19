/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package hello;

import java.util.concurrent.CompletableFuture;

import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements ApplicationEventPublisherAware {
    private final MessageProperties properties;
    
    private ApplicationEventPublisher publisher;

    public HelloController(MessageProperties properties) {
        this.properties = properties;
    }

    @GetMapping
    public String getMessage() {
        return "Message: " + properties.getMessage();
    }
    
    @GetMapping("/refresh")
    public void refresh() {
        CompletableFuture.supplyAsync(() -> asyncRefresh());
    }
    
    private boolean asyncRefresh() {
        publisher.publishEvent(new RefreshEvent(this, "Endpoint Refresh", "Refreshing Configurations"));
        return true;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
