package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(randomString(10));
        System.out.println(randomEmail());
        System.out.println(randomInt(10, 100));
        String[] names = {"a", "b", "c", "d"};
        System.out.println(randomItemFromList(names));
    }

    private static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private static String randomItemFromList(String[] list) {
        int index = randomInt(0, list.length - 1);
        return list[index];
    }

    public static String randomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomEmail() {
        return randomString(10) + "@test.com";
    }

}
