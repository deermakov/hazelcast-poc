package poc.hazelcast.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(Individual.class),
    @JsonSubTypes.Type(IndividualEntrepreneur.class),
    @JsonSubTypes.Type(LegalEntity.class)
})
@Data
@ToString
public abstract class Party implements Serializable {
    private String id;
    private String inn;
    private Address address;
    private List<Deal> deals;
}
