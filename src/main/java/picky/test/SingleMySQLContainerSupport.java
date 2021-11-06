package picky.test;

import org.testcontainers.containers.MySQLContainer;

public class SingleMySQLContainerSupport extends MySQLContainer<SingleMySQLContainerSupport> {
    private static SingleMySQLContainerSupport container;

    private SingleMySQLContainerSupport() {
        super(MySQLContainerSupport.MYSQL_IMAGE);
    }

    public static SingleMySQLContainerSupport getInstance() {
        if (container == null) {
            container = new SingleMySQLContainerSupport();
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
