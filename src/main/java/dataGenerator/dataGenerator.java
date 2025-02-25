package dataGenerator;

import com.github.javafaker.Faker;

import java.util.Locale;

public class dataGenerator {
    public static String generateFirstName(){
        Faker faker = new Faker(new Locale("en-IND"));
        String firstName = faker.name().firstName();
        return firstName;
    }
    public static String generateLastName(){
        return new Faker().name().lastName();
    }
    public static String generatePostalCode(){
        return new Faker().address().zipCode();
    }
}
