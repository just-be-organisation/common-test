package picky.test;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.traits.LinkableContainer;
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy;

import java.util.List;

public class SingleNatsContainer extends GenericContainer<SingleNatsContainer> implements
    LinkableContainer {

    private static SingleNatsContainer container;

    private SingleNatsContainer() {
        super(NatsContainerSupport.NATS_IMAGE);
    }

    public static SingleNatsContainer getInstance() {
        if (container == null) {
            container = new SingleNatsContainer()
                .withExposedPorts(4222)
                .waitingFor(new LogMessageWaitStrategy().withRegEx(".*Server is ready.*"));
            container.setPortBindings(List.of("4000:4222"));
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
