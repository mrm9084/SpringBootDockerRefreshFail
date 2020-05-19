package hello;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.core.env.EnumerablePropertySource;

public class TestPropertySource extends EnumerablePropertySource<String> {
    
    private Map<String, Object> properties = new LinkedHashMap<>();

    protected TestPropertySource(String name) {
        super(name);
        properties.put("config.message", new Date().toString());
    }

    @Override
    public String[] getPropertyNames() {
        Set<String> keySet = properties.keySet();
        return keySet.toArray(new String[keySet.size()]);
    }

    @Override
    public Object getProperty(String name) {
        return properties.get(name);
    }

}
