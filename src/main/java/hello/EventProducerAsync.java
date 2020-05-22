package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventProducerAsync {
    private final Logger LOGGER = LoggerFactory.getLogger(EventProducerAsync.class);
    
    private final ApplicationEventPublisher publisher;

    public EventProducerAsync(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Async
    public void asyncRefresh() {
        LOGGER.info("asyncRefresh-begin");
        publisher.publishEvent(new RefreshEvent(this, "Endpoint Refresh", "Refreshing Configurations"));
        LOGGER.info("asyncRefresh-end");

    }
}
