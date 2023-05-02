
public class River_Interface {

    public boolean riverMenu = true;

    public String RiverLayout() {

        String menu = "No menu";

        menu = "1. Continue on trail\n" + "2. Check supplies\n" + "3. Look at map\n" +
        "4. Change pace\n" + "5. Change food rations\n" + "6. Stop to rest\n" +
                "7. Talk to people\n" + "\n What is your choice?";

        return menu;

    }
    public String RiverCategoryRequest(String categoryRequest) {

        String display = "No display";
        riverMenu = false;


        if (categoryRequest.equalsIgnoreCase("Continue on trail") || categoryRequest.equals("1")){

            display = "Returning to trail";

        }
        else if (categoryRequest.equalsIgnoreCase("Check supplies") || categoryRequest.equals("2")){

            riverMenu = false;

            display = "1. Food: " + getFood + "\n" + "2. Clothing " + getClothing + "\n" +
                    "3. Weapons " + getWeapons + "\n" + "4. Oxen " + getOxen + "\n" +
                    "5. Spare Wagon Wheel " + getSpareWagonWheel+ "\n" + "6. Spare Wagon Axel: " +
                    getSpareWagonAxel + "\n" + "7. Spare Wagon Tongues: " + getSpareWagonTongues
                    + "\n" + "8. Medical Supply Box: " + getMedicalSupplyBox + "\n" +
                    "9. Sewing Kit: " + getSewingKit + "\n" + "10. Fire Starting Kit: "
                    + getFireStartingKit + "\n" + "11. Kids Toys: " + getKidsToys + "\n" +
                    "12. Family Keeping Sake:" + getFamilyKeepingSake + "\n" +
                    "13. Seed Packages: " + getSeedPackages + "\n" + "14. Shovel: " + getShovel
                    + "\n" + "15. Cooking Items: " + getCookingItems + "\n";

            RiverLayout();


        }
        else if (categoryRequest.equalsIgnoreCase("Look at map") || categoryRequest.equals("3")){

            riverMenu = false;
            display = "" + title.setImage(R.Map);

            RiverLayout();

        }
        else if (categoryRequest.equalsIgnoreCase("Change pace") || categoryRequest.equals("4")){

            display = "Change pace (currently '" + currentPace + "') \n" +
                    "1. A steady pace\n" + "2. A strenuous pace\n" + "3. A grueling pace\n" +
                    "Find out what these difference paces mean\n" +
                    "What is your choice? ";

        }
        else if (categoryRequest.equalsIgnoreCase("Change food rations") || categoryRequest.equals("5")){

            display = "Change food rations (currently '" + currentRation_Rate + "') \n" +
                    "The amount of food the people in your party eat each day can change. These amounts are:\n" +
                    "1. Filling - meals are large and generous.\n" + "2. Meager - meals are small, but adequate.\n"
                    + "3. Bare bones - meals are very small; everyone stays hungry.\n" +
                    "What is your choice? ";

        }
        else if (categoryRequest.equalsIgnoreCase("Stop to rest") || categoryRequest.equals("6")){

            display = "How many days would you like to rest?";

        }
        else if (categoryRequest.equalsIgnoreCase("Talk to people") || categoryRequest.equals("7")){

            riverMenu = false;

            display = "With the crowds of people waiting to get on the ferry, we could be " +
                    "stranded here for days! Hope there's enough graze for all those animals" +
                    " -- not many people carry feed! I'd rather wait, though, than cross in " +
                    "a rickety wagon boat!";

            RiverLayout();

        }
        else { display = "Users input didn't work"; }


        return display;

    }
