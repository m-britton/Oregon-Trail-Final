package com.example.mp2oregontrailmvp;

import java.util.Random;

public class Women extends Wagon
{
    // A variable to represent one item being removed when it is used.
    int remove1 = -1;

    // A string that will be displayed to the user.
    String message = "";

    /**
     * playWithKids -> This method allows the women to play with their children when they are sick to
     * speed up their recovery process. Each time the method is called a toy is removed from the total.
     */
    public void playWithKids()
    {
        setKidsToys(getKidsToys() + remove1);
        message ="The kids are having fun, they look better!";
    }

    /**
     * cookFood -> This method simulated women cooking food for their party. When they cook more
     * food is added to the total amount, and the items used to cook are removed from the total.
     */
    public void cookFood()
    {
        setCookingItems(getCookingItems() + remove1);
        setFood(getFood() + 20);
    }

    /**
     * forageFood -> This method allows women to go out foraging for food and cooking supplies when
     * the group starts running low. A random amounts of cooking supplies and food are found.
     */
    public void forageFood()
    {
        Random rand = new Random();
        int intRandom = rand.nextInt(4) + 1;
        setCookingItems(getCookingItems() + intRandom);
        setFood(getFood() + (intRandom * 5));
        message = "You found " + intRandom + " cooking supplies!";
    }

    /**
     * restoreClothing -> Simulates the women taking time to mend the clothing. When this method is
     * called the amount of clothes increases and the number of sewing kits decreases
     */
    public void restoreClothing(){
        setClothing(getClothing() + 2);
        setSewingKit(getSewingKit() + remove1);
        message = "You have restored two items of clothing!!";
    }
}
