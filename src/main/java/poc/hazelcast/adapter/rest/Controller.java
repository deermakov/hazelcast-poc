package poc.hazelcast.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import poc.hazelcast.app.impl.GetAllPartiesUseCase;
import poc.hazelcast.app.impl.SavePartyUseCase;
import poc.hazelcast.domain.Party;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final GetAllPartiesUseCase getAllPartiesUseCase;
    private final SavePartyUseCase savePartyUseCase;

    @GetMapping("/party/list")
    public List<Party> getAllParties(){
        return getAllPartiesUseCase.execute();
    }
    @PutMapping("/party")
    public void saveParty(@RequestBody Party party){
        savePartyUseCase.execute(party);
    }

}
