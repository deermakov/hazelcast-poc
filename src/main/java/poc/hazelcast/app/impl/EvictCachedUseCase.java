package poc.hazelcast.app.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class EvictCachedUseCase {
    @CacheEvict("uuid")
    public void execute() {
    }
}
