package poc.hazelcast.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Address implements Serializable {
    private String fullAddress;
}
