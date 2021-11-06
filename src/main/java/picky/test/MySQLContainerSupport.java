package picky.test;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

public interface MySQLContainerSupport {
    String MYSQL_IMAGE = "mysql:5.7.30";
    @Container
    GenericContainer<?> MYSQL = SingleMySQLContainerSupport.getInstance();
}
