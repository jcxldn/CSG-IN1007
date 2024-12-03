package in1007.w10.ex1;

import java.util.ArrayList;

public class MyChristmasList {
    private ArrayList<ChristmasGift> myList;

    public MyChristmasList() {
        myList = new ArrayList<ChristmasGift>(); // empty arraylist
    }

    public ArrayList<ChristmasGift> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<ChristmasGift> myList) {
        this.myList = myList;
    }

    public void addGift(ChristmasGift gift) {
        myList.add(gift);
    }
}
