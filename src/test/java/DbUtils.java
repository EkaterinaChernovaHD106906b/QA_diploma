import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.DriverManager;

public class DbUtils {
    @BeforeEach
    @SneakyThrows
    @Test
    void stubTest() {
        var cardsSQL = "SELECT id, amount, status FROM payment_entity;";
        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app",
                        "pass");
                var cardsStmt = conn.prepareStatement(cardsSQL);) {
            try (var rs = cardsStmt.executeQuery()) {
                while (rs.next()) {
                    var id = rs.getString("id");
                    var amount = rs.getInt("amount");
                    var status = rs.getString("status");
                    String expected = "DECLINED";
                    String actual = status;
                    Assertions.assertEquals(expected, actual);

                }


            }
        }


    }
}





