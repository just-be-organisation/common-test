package picky.test;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

public interface NatsContainerSupport {

    String NATS_IMAGE = "nats-streaming:latest";

    @Container
    GenericContainer<?> nats = SingleNatsContainer.getInstance();

}
