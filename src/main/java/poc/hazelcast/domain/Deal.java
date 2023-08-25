package poc.hazelcast.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class Deal implements Serializable {
    private String id;
    private String number;
    private BigDecimal amount;
    private List<Party> participants;
}
