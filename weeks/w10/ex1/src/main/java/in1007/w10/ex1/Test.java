package in1007.w10.ex1;

public class Test {
    public static void main(String[] args) {
        ChristmasGift g1 = new ChristmasGift("Gift 1", "Recipient 1", 1);
        ChristmasGift g2 = new ChristmasGift("Gift 2", "Person 2", 0);
        ChristmasGift g3 = new ChristmasGift("Gift 3", "Nobody", 9999);

        MyChristmasList list = new MyChristmasList();
        list.addGift(g1);
        list.addGift(g2);
        list.addGift(g3);

        printRecipients(list);

        ChristmasGift expensive = getMostExpensive(list);

        System.out.printf("MOST EXPENSIVE: ");
        System.out.println(expensive.getName());
    }

    public static void printRecipients(MyChristmasList list) {
        for (ChristmasGift gift : list.getMyList()) {
            System.out.printf("Gift '%s' for '%s' (price %d)\r\n", gift.getName(), gift.getRecipient(),
                    gift.getPrice());
        }
    }

    public static ChristmasGift getMostExpensive(MyChristmasList list) {
        ChristmasGift mostExpensive = null;
        int maxPrice = 0;

        for (ChristmasGift gift : list.getMyList()) {
            if (gift.getPrice() >= maxPrice) {
                mostExpensive = gift;
            }
        }

        return mostExpensive;
    }
}
