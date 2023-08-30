package poc.hazelcast.app.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCachedUseCase {
    @Cacheable("uuid")
    public UUID execute() {
        return UUID.randomUUID();
    }
}
