package poc.hazelcast.adapter.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poc.hazelcast.domain.Party;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HazelcastAdapter {
    private static final String DATA_OBJECT_KEY = "data";
    private final HazelcastInstance hazelcastInstance;

//    private void createDataStorage(){
//        hazelcastInstance.
//    }

    public Party getParty(String partyId){
        return hazelcastInstance.<String, Party>getMap(DATA_OBJECT_KEY).get(partyId);
    }

    public List<Party> getAllParties(){
        return new ArrayList<>( hazelcastInstance.<String, Party>getMap(DATA_OBJECT_KEY).values() );
    }

    public void saveParty(Party party){
        hazelcastInstance.<String, Party>getMap(DATA_OBJECT_KEY).put(party.getId(), party);
    }
}
