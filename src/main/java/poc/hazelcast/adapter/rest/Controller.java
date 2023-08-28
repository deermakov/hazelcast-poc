package poc.hazelcast.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import poc.hazelcast.app.impl.GetAllPartiesUseCase;
import poc.hazelcast.app.impl.GetPartyUseCase;
import poc.hazelcast.app.impl.SavePartyUseCase;
import poc.hazelcast.domain.Party;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final GetAllPartiesUseCase getAllPartiesUseCase;
    private final SavePartyUseCase savePartyUseCase;
    private final GetPartyUseCase getPartyUseCase;

    @GetMapping("/party/list")
    public List<Party> getAllParties(){
        return getAllPartiesUseCase.execute();
    }
    @PutMapping("/party")
    public void saveParty(@RequestBody Party party){
        savePartyUseCase.execute(party);
    }
    @GetMapping("/party")
    public Party getParty(@RequestParam String partyId){
        return getPartyUseCase.execute(partyId).orElseThrow(()-> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
    }
}
