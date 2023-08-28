package poc.hazelcast.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.hazelcast.adapter.hazelcast.HazelcastAdapter;
import poc.hazelcast.domain.Party;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPartyUseCase {
    private final HazelcastAdapter hazelcastAdapter;
    public Optional<Party> execute(String partyId){
        return hazelcastAdapter.getParty(partyId);
    }
}
