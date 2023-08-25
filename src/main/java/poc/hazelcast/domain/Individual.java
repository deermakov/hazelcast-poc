package poc.hazelcast.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Individual extends Party {
    private String fio;
}
