package com.example.mp2oregontrailmvp;

import java.util.Random;

public class Women extends Wagon
{
    int remove1 = -1;
    int remove2 = -2;
    String message = "";

    public void playWithKids()
    {
        setKidsToys(getKidsToys() + remove1);

        message ="The kids are having fun, they look better!";
    }
    public void cookFood()
    {
        setCookingItems(getCookingItems() + remove1);
        setFood(getFood() + 20);
    }
    public void forageFood()
    {
        Random rand = new Random();
        int intRandom = rand.nextInt(4) + 1;
        setCookingItems(getCookingItems() + intRandom);
        setFood(getFood() + (intRandom * 5));
        message = "You found " + intRandom + " cooking supplies!";
    }
}
