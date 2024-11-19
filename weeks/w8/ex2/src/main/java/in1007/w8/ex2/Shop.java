package in1007.w8.ex2;

import lombok.Getter;
import lombok.Setter;

public class Shop {
    private @Getter @Setter String name;
    private @Getter int numberOfArticles;
    private @Getter int[] articles;

    public Shop(String name, int numberOfArticles, int[] articles) {
        this.name = name;
        this.numberOfArticles = numberOfArticles;
        this.articles = articles;

        System.out.printf("Welcome to the new shop '%s'!\r\n", this.getName());
    }

    public Shop() {
        this.name = "shop open soon";
        this.numberOfArticles = 0;
        this.articles = new int[1];
    }

    public void setNumberOfArticles(int numberOfArticles) {
        if (numberOfArticles > 0)
            this.numberOfArticles = numberOfArticles;
    }

    public void setArticles(int[] articles) {
        boolean hasNegatives = false;

        for (int i = 0; i < articles.length; i++) {
            if (articles[i] < 0)
                hasNegatives = true;
        }

        if (!hasNegatives) {
            this.articles = articles;
        }
    }

    public void iterator(int cycles) {
        // eg cycles=5 -> i [0-4] inclusive (5 loops)
        for (int i = cycles - 1; i >= 0; i--) {
            // i is out of bounds, continue to next iteration
            if (i >= articles.length)
                continue;

            // Check if articles[i] is positive
            if (articles[i] > 0) {
                // Decrement
                articles[i] = articles[i] - 1;
            }
        }
    }
}
