package poc.hazelcast.adapter.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.hazelcast.domain.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HazelcastAdapter {
    private static final String DATA_OBJECT_KEY = "parties";
    private final HazelcastInstance hazelcastInstance;

    public Optional<Party> getParty(String partyId){
        return Optional.ofNullable(hazelcastInstance.<String, Party>getMap(DATA_OBJECT_KEY).get(partyId));
    }

    public List<Party> getAllParties(){
        return new ArrayList<>( hazelcastInstance.<String, Party>getMap(DATA_OBJECT_KEY).values() );
    }

    public void saveParty(Party party){
        hazelcastInstance.<String, Party>getMap(DATA_OBJECT_KEY).put(party.getId(), party);
    }
}
