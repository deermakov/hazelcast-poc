package poc.hazelcast.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class IndividualEntrepreneur extends LegalEntity {
    private Individual individual;
    private Boolean selfEmployed;
}
