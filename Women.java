package com.example.mp2oregontrailmvp;

/**
 * Name: Women
 * Date: 4/25/23
 * Author: McKinley Britton
 * Description: The women class allows women to take actions during game play.
 *              Women can play with the children, cook food, forage for more food and supplies, and
 *              repair clothing that is inadequate for winter. Each method has different effects on
 *              the supplies in the wagon and will display a message to the user when the method is called.
 */

import java.util.Random;

public class Women extends Wagon
{
    // A variable to represent one item being removed when it is used.
    int remove1 = -1;

    // A string that will be displayed to the user.
    String message = "";

    public String getMessage(){ return message;}

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
        message = "The women cooked food today!!";
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
        message = "The women found food and cooking supplies!!";
    }

    /**
     * restoreClothing -> Simulates the women taking time to mend the clothing. When this method is
     * called the amount of clothes increases and the number of sewing kits decreases
     */
    public void restoreClothing(){
        setClothing(getClothing() + 2);
        setSewingKit(getSewingKit() + remove1);
        message = "The Women have restored two items of clothing!!";
    }
}
