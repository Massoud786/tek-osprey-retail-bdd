package tek.bdd.utility;

import java.util.Random;

public class DataGeneratorUtility {

    public static String randomEmail(String email) {

        // take this value: Hejaz@gmail.com

        // return this value: Hejaz123@gmail.com

        Random random = new Random();
        int number = random.nextInt(1000);
        int indexOfAtSign = email.indexOf("@");
        String firstPart = email.substring(0, indexOfAtSign);
        String secondPart = email.substring(indexOfAtSign);

        return firstPart + number + secondPart;

    }

}
