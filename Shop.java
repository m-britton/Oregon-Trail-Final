package com.example.mp2oregontrailmvp;

public class Shop {
    public boolean buying = true;

    public double food_Price = 0.00;
    public double clothing_Price = 0.00;
    public double weapons_Price = 0.00;
    public double oxen_Price = 0.00;
    public double spareWagonWheel_Price = 0.00;
    public double spareWagonAxel_Price = 0.00;
    public double spareWagonTongues_Price = 0.00;
    public double medicalSupplyBox_Price = 0.00;
    public double sewingKit_Price = 0.00;
    public double fireStartingKit_Price = 0.00;
    public double kidsToys_Price = 0.00;
    public double familyKeepsakes_Price = 0.00;
    public double seedPackeges_Price = 0.00;
    public double shovels_Price = 0.00;
    public double cookingItems_Price = 0.00;

    public String otherinput;
    public String output = "";
    public double amount = 0;

    public String storeLayout() {


        String title = "Matt's General Store" + "\n" + "                           ";

        String food = "1. Food: $" + food_Price;
        String clothing = "2. Clothing: $" + clothing_Price;
        String weapons = "3. Weapons: $"+  weapons_Price;
        String oxen = "4. Oxen: $" + oxen_Price;
        String spareWagonWheel = "5. Spare Wagon Wheel: $" + spareWagonWheel_Price;
        String spareWagonAxel = "6. Spare Wagon Axel: $" + spareWagonAxel_Price;
        String spareWagonTongues = "7. Spare Wagon Tongues: $" + spareWagonTongues_Price;
        String medicalSupplyBox = "8. Medical Supply Box: $" + medicalSupplyBox_Price;
        String sewingKit = "9. Sewing Kit: $" + sewingKit_Price;
        String fireStartingKit = "10. Fire Starting Kit: $" + fireStartingKit_Price;
        String kidsToys = "10. Fire Starting Kit: $" + fireStartingKit_Price;
        String familyKeepsakes = "11. Family Keepsakes: $" + familyKeepsakes_Price;
        String seedPackeges = "12. Seed packeges: $" + seedPackeges_Price;
        String shovels = "13. Shovels: $" + shovels_Price;
        String cookingItems = "14. Cooking items: $" + cookingItems_Price;

        String prompt = "What would you like to buy?";


        output = title + "\n" + food + "\n" + clothing + "\n" + weapons + "\n" + oxen + "\n" +
                spareWagonWheel + "\n" + spareWagonAxel + "\n" + spareWagonTongues + "\n" +
                medicalSupplyBox +"\n" + sewingKit + "\n" + fireStartingKit+ "\n" + kidsToys
                + "\n" + familyKeepsakes + "\n" + seedPackeges + "\n" + shovels + "\n"
                + cookingItems + "\n" + prompt;

        return output;
    }



    public double calcBoughtItem(String categoryRequest, int inputNumber, String town){

        double number = 0;
        buying = true;
        
       
        if (town.equalsIgnoreCase("Independence")){
            
            amount = 1;
        }
        else if (town.equalsIgnoreCase("Laramie")){
            
            amount = 1.25;
        }
        else if (town.equalsIgnoreCase("Fort Bridger")){
            
            amount = 1.50;   
        }
        else if (town.equalsIgnoreCase("Fort Hall")){
            
            amount = 1.75;   
        }
        else if (town.equalsIgnoreCase("Fort Boise")){
            
            amount = 2;   
        }
        else if (town.equalsIgnoreCase("Fort walla Walla")){
            
            amount = 2.25;   
        }
        else if (town.equalsIgnoreCase("Oregon City")){
            
            amount = 2.5;   
        }
       

        
        if (categoryRequest.equalsIgnoreCase("Food") || categoryRequest.equals("1")){

            food_Price = food_Price + ((.10 * amount) * inputNumber);

            //Must add .10 coffee, .02 flour, .05 bacon

            number = food_Price;

        } else if(categoryRequest.equalsIgnoreCase("Clothing") || categoryRequest.equals("2")){

            clothing_Price = clothing_Price + ((.2 * amount) * inputNumber);

            number = clothing_Price;

        } else if(categoryRequest.equalsIgnoreCase("Weapons") || categoryRequest.equals("3")){

            weapons_Price = weapons_Price + ((20 * amount) * inputNumber);

            //Must add $20 rifle, $10 shotgun, $5 shots/bullets.

            number = weapons_Price;

        } else if(categoryRequest.equalsIgnoreCase("Oxen") || categoryRequest.equals("4")){

            oxen_Price = oxen_Price + ((50* amount) * inputNumber);

            number = oxen_Price;

        } else if(categoryRequest.equalsIgnoreCase("Spare Wagon Wheel") || categoryRequest.equals("5")){

            spareWagonWheel_Price = spareWagonWheel_Price + ((8 * amount) * inputNumber);

            number = spareWagonWheel_Price;

        } else if(categoryRequest.equalsIgnoreCase("Spare Wagon Axel") || categoryRequest.equals("6")){

            spareWagonAxel_Price = spareWagonAxel_Price + ((3 * amount) * inputNumber);

            number = spareWagonAxel_Price;

        }else if (categoryRequest.equalsIgnoreCase("Spare Wagon Tongues") || categoryRequest.equals("7")){

            spareWagonTongues_Price = spareWagonTongues_Price + ((3 * amount) * inputNumber);

            number = spareWagonTongues_Price;

        }else if (categoryRequest.equalsIgnoreCase("Medical Supply Box") || categoryRequest.equals("8")){

            medicalSupplyBox_Price = medicalSupplyBox_Price + ((1.50 * amount) * inputNumber);

            number = medicalSupplyBox_Price;

        }else if (categoryRequest.equalsIgnoreCase("Sewing Kit") || categoryRequest.equals("9")){

            sewingKit_Price = sewingKit_Price + ((0.50 * amount) * inputNumber);

            number = sewingKit_Price;

        }else if (categoryRequest.equalsIgnoreCase("Fire Starting Kit") || categoryRequest.equals("10")){

            fireStartingKit_Price = fireStartingKit_Price + ((0.25 * amount) * inputNumber);

            number = fireStartingKit_Price;

        }else if (categoryRequest.equalsIgnoreCase("Kids Toys") || categoryRequest.equals("11")){

            kidsToys_Price = kidsToys_Price + ((0.05 * amount) * inputNumber);

            number = kidsToys_Price;

        }else if (categoryRequest.equalsIgnoreCase("Family Keepsakes") || categoryRequest.equals("12")){

            familyKeepsakes_Price = 0;

            number = familyKeepsakes_Price;

        }else if (categoryRequest.equalsIgnoreCase("Seed packeges") || categoryRequest.equals("13")){

            seedPackeges_Price = seedPackeges_Price + ((0.01 * amount) * inputNumber);

            number = seedPackeges_Price;

        }else if (categoryRequest.equalsIgnoreCase("Shovels") || categoryRequest.equals("14")){

            shovels_Price = shovels_Price + ((2.50 * amount) * inputNumber);

            number = shovels_Price;

        }else if (categoryRequest.equalsIgnoreCase("Cooking items") || categoryRequest.equals("15")){

            cookingItems_Price = cookingItems_Price + ((1.50 * amount) * inputNumber);

            //$1 Coffee Mill, $1.50 frying pan, 0.25 cents pan

            number = cookingItems_Price;

        }

        storeLayout();
        return number;

    }


    public String buyItem(String userInput , String town) {

        buying = false;
        otherinput = userInput;

        String input = "Nothing";

        if (userInput.equals("Food") || userInput.equals("1")) {

            input = "You are buying food. Food is: " + (.10 * amount) + " coffee," + (.02 * amount) + " flour," + (.05* amount) + " bacon per pd. " 
                + \n + " How much do you want to buy: ";

        } else if (userInput.equals("Clothing") || userInput.equals("2")) {

            input = "You are buying clothes. Clothes are" + (20 * amount) + " cents. " + \n +
                    "How much do you want to buy:";

        } else if (userInput.equals("Weapons") || userInput.equals("3")) {

            input = "You are buying Weapons. Rifle: $" + (20 * amount) + ", Shotgun: $" + (10 * amount) + ", Shots: $" + (5 * amount) + ". " + \n +
                    "What weapons do you want to buy and how many: ";
        }else if (userInput.equals("Oxen") || userInput.equals("4")) {

            input = "You are buying Oxen. Oxen: $" (50 * amount) + ". " + \n +
                    "How many do you want to buy: ";

        } else if (userInput.equals("Spare Wagon Wheel") || userInput.equals("5")) {

            input = "You are buying a Spare Wagon Wheel. Spare wagon wheel: $" (8 * amount) " each. " + \n +
                    "How many do you want to buy: ";

        } else if (userInput.equals("Spare Wagon Axel") || userInput.equals("6")) {

            input = "You are buying a Spare Wagon Axel. Spare wagon axel: $" (3 * amount) " each. " + \n +
                    "How any do you want to buy: ";

        } else if (userInput.equals("Spare Wagon Tongues") || userInput.equals("7")) {

            input = "You are buying a Spare Wagon Tongues. Spare wagon tongues: $" + (3 * amount) + " each. " + \n +
                    "How any do you want to buy: ";

        } else if (userInput.equals("Medical Supply Box") || userInput.equals("8")) {

            input = "You are buying a Medical Supply Box. Medical supply box: $" + (1.50* amount) + "each. " + \n +
                    "How any do you want to buy: ";

        } else if (userInput.equals("Sewing Kit") || userInput.equals("9")) {

            input = "You are buying a Sewing Kit. Medical supply box: " + (0.50 * amount) + " cents each. " + \n +
                    "How any do you want to buy: ";

        } else if (userInput.equals("Fire Starting Kit") || userInput.equals("10")) {

            input = "You are buying a Fire Starting Kit. Fire starting kit: " + (0.25 * amount) + " cents each. " + \n +
                    "How any do you want to buy: ";

        } else if (userInput.equals("Kids Toys") || userInput.equals("11")) {

            input = "You are buying Kids Toys. Kids toys: " + (0.05 * amount) + " cents each. " +
                    "How any do you want to buy: ";

        } else if (userInput.equals("Family Keepsakes") || userInput.equals("12")) {

            input = "You are buying Family Keepsakes. JK they are FREEEEE";

        } else if (userInput.equals("Seed packeges") || userInput.equals("13")) {

            input = "You are buying Seed Packeges. Seed packeges: " + (0.01 * amount) + "cents per packet. " + \n +
                    "How any do you want to buy: ";

        } else if (userInput.equals("Shovels") || userInput.equals("14")) {

            input = "You are buying Shovels. Shovels: $" (2.50 * amount) + "each. " + \n
                    "How any do you want to buy: ";

        } else if (userInput.equals("Cooking items") || userInput.equals("15")) {

            input = "You are buying Cooking items. Cooking items: $" + (1 * amount) + " Coffee Mill, $" + (1.50 * amount) + " frying pan, " (0.25 * amount) + " cents pan. " + \n +
                    "How any do you want to buy: ";

        } else {

            input = "This doesn't exist";
        }

        return input;

    }
}
