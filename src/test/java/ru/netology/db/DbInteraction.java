package ru.netology.db;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;

import java.sql.DriverManager;

public class DbInteraction {
    @SneakyThrows
    public void statusDeclined() {
        var cardsSQL = "SELECT status FROM credit_request_entity;";
        try (
                var conn = DriverManager.getConnection(
                        System.getProperty("db.url"), "app",
                        "pass");
                var cardsStmt = conn.prepareStatement(cardsSQL);) {
            try (var rs = cardsStmt.executeQuery()) {
                while (rs.next()) {
                    var status = rs.getString("status");
                    String expected = "DECLINED";
                    String actual = status;
                    Assertions.assertEquals(expected, actual);


                }
            }
        }
    }

    @SneakyThrows
    public void statusApproved() {
        var cardsSQL = "SELECT status FROM credit_request_entity;";
        try (
                var conn = DriverManager.getConnection(System.getProperty("db.url"),
                        "app",
                        "pass");
                var cardsStmt = conn.prepareStatement(cardsSQL);) {
            try (var rs = cardsStmt.executeQuery()) {
                while (rs.next()) {
                    var status = rs.getString("status");
                    String expected = "APPROVED";
                    String actual = status;
                    Assertions.assertEquals(expected, actual);
                }
            }
        }
    }
}
