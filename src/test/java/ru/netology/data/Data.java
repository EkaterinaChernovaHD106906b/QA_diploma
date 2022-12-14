package ru.netology.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Date;
import java.util.Locale;

public class Data {
    private Data() {

    }

    private static final Faker faker = new Faker(new Locale("en"));

    @Value
    public static class cardNumberFirst {
        private String numberFirstCard;
    }

    @Value
    public static class cardNumberSecond {
        private String numberSecondCard;
    }

    public static String getCardNumberFirst() {
        return new String("4444 4444 4444 4441");
    }

    public static String getCardNumberSecond() {
        return new String("4444 4444 4444 4442");
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale("en"));
        String name = faker.name().fullName();
        return name;
    }

    public static String generateCVV() {
        Faker faker = new Faker();
        String cvv = faker.finance().creditCard().substring(1, 4);
        return cvv;
    }

    public static String generateInvalidCVV() {
        Faker faker = new Faker();
        String cvv = faker.finance().creditCard().substring(1, 3);
        return cvv;
    }

    public static String generateMonth(int months) {
        return LocalDate.now().plusMonths(months).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear(int years) {
        return LocalDate.now().plusYears(years).format(DateTimeFormatter.ofPattern("yy"));
    }
}






