package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utils {

    public static String getRandomString(int length) {
        final String neededChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(neededChars.charAt(rnd.nextInt(neededChars.length())));
        return sb.toString();
    }

    public static String getRandomStringWithoutNumbers(int length) {
        final String neededChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(neededChars.charAt(rnd.nextInt(neededChars.length())));
        return sb.toString();
    }

    public static String getRandomLocation() {
        List<String> givenLocationList = Arrays.asList("New Delhi", "New Friends Colony, New Delhi, 110025", "Bangalore",
                "Hyderabad", "Pune", "Chennai", "Ahmedabad", "Mumbai", "Surat", "Gurgaon", "Faridabad", "Gurgaon", "Ghaziabad");
        Random rand = new Random();
        return givenLocationList.get(rand.nextInt(givenLocationList.size()));
    }
}