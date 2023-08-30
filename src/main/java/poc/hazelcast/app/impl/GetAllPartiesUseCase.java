package poc.hazelcast.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.hazelcast.adapter.hazelcast.HazelcastAdapter;
import poc.hazelcast.domain.Party;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllPartiesUseCase {
    private final HazelcastAdapter hazelcastAdapter;

    public List<Party> execute() {
        return hazelcastAdapter.getAllParties();
    }
}
