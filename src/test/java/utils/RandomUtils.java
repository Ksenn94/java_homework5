package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getRandomEmail(int length) {
        return RandomStringUtils.randomAlphabetic(length) + "@mail.com";
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);

    }

    public static String getRandomPhone() {

        return getRandomLong(1111111111L, 9999999999L).toString();
    }


}
