package com.example.mp2oregontrailmvp;

/**
 * Name: RiverMenu
 * Date: 5/08/2023
 * Author: Julia Kamatali
 * Description: The River class is responsible for allowing the player to cross the river,
 * check the wagon, change rations, change pace if necessary by the user
 */
public class River {

    //Fields
    public boolean riverMenu = true;
    public String otherinput; //input from the user
    public String output = ""; //River menu/display

    public void setRiverMenu(){ riverMenu = true;}

    /**
     * riverLayout -> This is what will be outputed on the display screen first when the user gets to a river
     * @return -> the different things the user can do before crossing the river
     */
    public String riverLayout() {


        output = "1. Continue on trail\n" + "2. Check supplies\n" + "3. Look at map\n" +
                "4. Change pace\n" + "5. Change food rations\n" + "6. Stop to rest\n" +
                "7. Talk to people\n" + "\n What is your choice?";

        return output;
    }

    /**
     * riverCatagory -> Based on if the user decieds to change their pace/rest, ration intake,
     * or wants to look at the map they can do so before corssing the river
     * @param userInput -> takes in the quantity of the good the user wants to buy
     * @return -> the pace or ration intake they want to change before crossing the river
     */
    public String riverCatagory(String userInput){

        String input = "";
        riverMenu = true; // reverts back to the river menu after this method is executed

        if (userInput.equalsIgnoreCase("A steady pace") || userInput.equals("A")){

            input = "Pace has been changed to steady";

        }
        else if (userInput.equalsIgnoreCase("A strenuous pace") || userInput.equals("B")){

            input = "Pace has been changed to strenuous";

        }
        else if (userInput.equalsIgnoreCase("A grueling pace") || userInput.equals("C")){

            input = "Pace has been changed to grueling";

        }
        else if (userInput.equalsIgnoreCase("Find out what these difference paces mean") || userInput.equals("D")) {

            input = "Steady - You travel about 8 hours a day, taking frequent rests. You take " +
                    "care not to get too tirded. \n" + "Strenuous - You travel about 12 hours a " +
                    "day, starting just after sunrise and stopping shortly before sunset. You" +
                    "stop to rest only when necessary. You finish each day feeling very tired \n" +
                    "Grueling - You travel about 16 hours a day, starting before sunrise and " +
                    "almost never stop to rest. You do not get enough sleep at night. You " +
                    "finish each day feeling absolutely exhausted, and your health suffers \n";

        }
        else if (userInput.equalsIgnoreCase("Filling") || userInput.equals("E")){

            input = "Pace has been changed to steady";

        }
        else if (userInput.equalsIgnoreCase("Meager") || userInput.equals("F")){

            input = "Pace has been changed to strenuous";

        }
        else if (userInput.equalsIgnoreCase("Bare bones") || userInput.equals("G")){

            input = "Pace has been changed to grueling";

        }

        return input;

    }

    /**
     * dayRest -> counts how many days the user wants to rest before crossin the river
     * @param days -> inputed days the user wants to rest
     * @return -> return the users input
     */
    public int dayRest(int days){

        return days;
    }

    /**
     * secondRiverCategory -> This is what the user first picks to do before crossing the river
     * They have the option to cross, check their wagon, look at the map, change pace/rest, change food ration intake
     * @param userInput -> takes in the type of good the user wants to buy
     * @return -> the next display for the user, which asks how much of that good they want to buy
     */
    public String secondRiverCategory(String userInput) {

        riverMenu = false;
        otherinput = userInput;

        String input = "Nothing";

        if (userInput.equalsIgnoreCase("Continue on trail") || userInput.equals("1")) {

            input =  "Returning to trail";


        } else if (userInput.equalsIgnoreCase("Check supplies") || userInput.equals("2")) {

            input = "1. Food: " + "getFood" + "\n" + "2. Clothing " + "getClothing" + "\n" +
                    "3. Weapons " + "getWeapons" + "\n" + "4. Oxen " + "getOxen" + "\n" +
                    "5. Spare Wagon Wheel " + "getSpareWagonWheel"+ "\n" + "6. Spare Wagon Axel: " +
                    "getSpareWagonAxel" + "\n" + "7. Spare Wagon Tongues: " + "getSpareWagonTongues"
                    + "\n" + "8. Medical Supply Box: " + "getMedicalSupplyBox" + "\n" +
                    "9. Sewing Kit: " + "getSewingKit" + "\n" + "10. Fire Starting Kit: "
                    + "getFireStartingKit" + "\n" + "11. Kids Toys: " + "getKidsToys" + "\n" +
                    "12. Family Keeping Sake:" + "getFamilyKeepingSake" + "\n" +
                    "13. Seed Packages: " + "getSeedPackages" + "\n" + "14. Shovel: " + "getShovel"
                    + "\n" + "15. Cooking Items: " + "getCookingItems" + "\n";

        } else if (userInput.equalsIgnoreCase("Look at map") || userInput.equals("3")) {

            input = "Map"; // + title.setImage(R.Map);

        }else if (userInput.equalsIgnoreCase("Change pace") || userInput.equals("4")) {

            input = "Change pace (currently '" + "currentPace" + "') \n" +
                    "A. A steady pace\n" + "B. A strenuous pace\n" + "C. A grueling pace\n" +
                    "D. Find out what these difference paces mean\n" +
                    "What is your choice? ";

        } else if (userInput.equalsIgnoreCase("Change food rations") || userInput.equals("5")) {

            input = "Change food rations (currently '" + "currentRation_Rate" + "') \n" +
                    "The amount of food the people in your party eat each day can change. These amounts are:\n" +
                    "E. Filling - meals are large and generous.\n" + "F. Meager - meals are small, but adequate.\n"
                    + "G. Bare bones - meals are very small; everyone stays hungry.\n" +
                    "What is your choice? ";

        } else if (userInput.equalsIgnoreCase("Stop to rest") || userInput.equals("6")) {

            input = "You rest for seven days";

        } else if (userInput.equalsIgnoreCase("Talk to people") || userInput.equals("7")) {

            input = "With the crowds of people waiting to get on the ferry, we could be " +
                    "stranded here for days! Hope there's enough graze for all those animals" +
                    " -- not many people carry feed! I'd rather wait, though, than cross in " +
                    "a rickety wagon boat!";

        }
        else {

            input = "This doesn't exist";
        }

        return input;

    }

}