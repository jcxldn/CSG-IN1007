package in1007.w8.ex2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shop defShop = new Shop();

        int[] articles = { 1 };
        Shop namedShop = new Shop("My Shop", 1, articles);

        System.out.println(Arrays.toString(namedShop.getArticles()));
        namedShop.iterator(5);
        System.out.println(Arrays.toString(namedShop.getArticles()));

    }

    public static boolean articlesArrayMatchesGivenLength(Shop s) {
        return s.getArticles().length == s.getNumberOfArticles();
    }
}
