package hello;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

public class ConfigLocator implements PropertySourceLocator  {

    @Override
    public PropertySource<?> locate(Environment environment) {
        return new TestPropertySource("TestPropertySource");
    }

}
