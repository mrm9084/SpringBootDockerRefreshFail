/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package hello;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ConfigLocator.class)
@ConditionalOnProperty(name = "config.enabled", matchIfMissing = true)
public class TestBootstrapConfiguration {

    @Bean
    public ConfigLocator sourceLocator() {
        return new ConfigLocator();
    }
}
