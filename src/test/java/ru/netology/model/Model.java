package ru.netology.model;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import ru.netology.page.DashboardPage;

import java.util.Locale;


@AllArgsConstructor
@Data
public class Model {
    @Value
    public static class Card {
        private String number;
        private String month;
        private String year;
        private String holder;
        private String CVC;
    }
}










