package in1007.w10.ex1;

public class ChristmasGift {
    private String name;
    private String recipient;
    private int price;

    public ChristmasGift(String name, String recipient, int price) {
        this.name = name;
        this.recipient = recipient;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getPrice() {
        return price;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    private void setPrice(int price) {
        this.price = price;
    }
}
