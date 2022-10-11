import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;

/*public class DbUtils {
    @BeforeEach
    @SneakyThrows
    /*void setUp(){
        var faker = new Faker();
        var runner = new QueryRunner();
        var dataSQL = "INSERT INTO users (number, status) VALUES (?, ?);";
        try(
                var conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/app"
                );
                ){
            runner.update(conn, dataSQL, "4444 4444 4444 4441");
            runner.update((conn, dataSQL, "APPROVED");
        }
    }
    @Test
    @SneakyThrows
    void stubTest(){
        var runner = new QueryRunner();
        var conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/app");
        var dataSQL = "INSERT INTO users (number, status) VALUES (?, ?);";
        var all = runner.query(conn,  )
    }
}*/
