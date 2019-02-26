package utils;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utils {

    protected static final Logger LOGGER = LoggerUtil.getInstance();


    private Utils() {
    }

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

    public static void storePageTitlesInFile(String pageTitles) {
        LOGGER.info("Create file.txt and write data into it");
        String fileName = "PageTitles.txt";
        try {
            File file = new File("src/test/resources/" + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(pageTitles);
            file.getAbsolutePath();
            bw.close();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}