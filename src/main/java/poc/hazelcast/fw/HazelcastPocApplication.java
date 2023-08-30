package poc.hazelcast.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "poc.hazelcast")
public class HazelcastPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazelcastPocApplication.class, args);
    }
}
