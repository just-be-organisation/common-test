package picky.test;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public interface SingletonMySQLContainerSupport {
    String MYSQL_IMAGE = "mysql:5.7.30";
    @Container
    GenericContainer<?> MYSQL = SingleMySQLContainerSupport.getInstance();

    class SingleMySQLContainerSupport extends MySQLContainer<SingleMySQLContainerSupport> {
        private static SingleMySQLContainerSupport container;

        private SingleMySQLContainerSupport() {
            super(SingletonMySQLContainerSupport.MYSQL_IMAGE);
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
}
