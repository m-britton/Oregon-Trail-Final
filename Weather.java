/**
 * Name: Weather
 * Date: 4/17/23
 * Author: McKinley Britton
 * Description: The weather class is helpful in determining any kind of weather the group may
 *              experience during the game. The temperature and rainfall are broken down across
 *              six zones as well as by month. These values are based on data at specific town across
 *              the trail and are the monthly averages. We can also determine if the precipitation
 *              experienced is rain or snow, and how heavily it will precipitate for the day.
 */

package com.example.mp2oregontrailmvp;

import java.util.Random;

public class Weather {

    // The temperatures and rainfall to set for each zone of the trail
    private int zone1Temp = 0;
    private int zone2Temp = 0;
    private int zone3Temp = 0;
    private int zone4Temp = 0;
    private int zone5Temp = 0;
    private int zone6Temp = 0;
    private double zone1Rain = 0.0;
    private double zone2Rain = 0.0;
    private double zone3Rain = 0.0;
    private double zone4Rain = 0.0;
    private double zone5Rain = 0.0;
    private double zone6Rain = 0.0;

    // The temperature and rainfall of the day for any day
    private int realTemp = 0;
    private double realRain = 0.0;

    // A value for the amount of temperature to add for a different temperature each day
    private int randomAdd = 0;

    // the total amount of rain or snow accumulated during play
    private double totalRain = 0.0;
    private double totalSnow = 0.0;

    // The probability for heavy rain or light rain
    private double rainHeaviness;


    /**
     * Default constructor for the weather class
     */
    public Weather(){}

    /**
     * setRandomAdd -> Sets a randomly generated amount between -20 and 20that is added to the
     *              temperature to create a new different each day.
     */
    public void setRandomAdd(){
        // Create a variable to determine how much the temperature will vary from the average temperature.
        Random num = new Random();
        randomAdd = num.nextInt(20 + 1);

        // There is a 50/50 chance that the random add is positive or negative, create a variable to determine positive or negative.
        double plusMinus = Math.random();
        if(plusMinus < 0.5){
            randomAdd *= -1;
        }
    }

    /**
     * setZone1Temp -> Determines the initial temperature for the region and time of year based on
     *              data of average temperatures in Kansas City, MO. Once the initial temperature is found
     *              a random value between -20 and 20 is added to the temperature to create different
     * @param month -> An integer used to specify what month it is, so the temperature relates accordingly.
     */
    public void setZone1Temp(int month){
        // Switch statement by month for the average temperature in zone 1
        switch(month){
            case 1: zone1Temp = 29; break;
            case 2: zone1Temp = 35; break;
            case 3: zone1Temp = 46; break;
            case 4: zone1Temp = 56; break;
            case 5: zone1Temp = 66; break;
            case 6: zone1Temp = 76; break;
            case 7: zone1Temp = 80; break;
            case 8: zone1Temp = 78; break;
            case 9: zone1Temp = 70; break;
            case 10:zone1Temp = 58; break;
            case 11:zone1Temp = 45; break;
            case 12:zone1Temp = 34; break;
        }
        // determine the random value to be added to the average temperature
        setRandomAdd();
        // Add the random value to the average temperature to create the real temperature for the day
        realTemp = zone1Temp + randomAdd;
    }

    /**
     * setZone1Rain -> Determines the average monthly rainfall for a specific zone of the trail.
     *                  The data is based on Kansas City, MO.
     * @param month -> An integer used to specify what month it is, so the data correlates with the journey
     */
    public void setZone1Rain(int month){
        // Switch statement by month for the average rainfall in zone 1
        switch(month){
            case 1: zone1Rain = 1.1; break;
            case 2: zone1Rain = 1.4; break;
            case 3: zone1Rain = 2.3; break;
            case 4: zone1Rain = 3.7; break;
            case 5: zone1Rain = 5.1; break;
            case 6: zone1Rain = 5.2; break;
            case 7: zone1Rain = 4.4; break;
            case 8: zone1Rain = 3.9; break;
            case 9: zone1Rain = 4.6; break;
            case 10:zone1Rain = 3.2; break;
            case 11:zone1Rain = 2.1; break;
            case 12:zone1Rain = 1.5; break;
        }
        //set the real amount of rain to the average in specified month of zone 1
        realRain = zone1Rain;
    }

    /**
     * setZone2Temp -> Determines the initial temperature for the region and time of year based on
     *              data of average temperatures in North Platte, NE. Once the initial temperature is found
     *              a random value between -20 and 20 is added to the temperature to create different
     * @param month -> An integer used to specify what month it is, so the temperature relates accordingly.
     */
    public void setZone2Temp(int month){
        // Switch statement by month for the average temperature in zone 2
        switch(month){
            case 1: zone2Temp = 26; break;
            case 2: zone2Temp = 29; break;
            case 3: zone2Temp = 39; break;
            case 4: zone2Temp = 48; break;
            case 5: zone2Temp = 58; break;
            case 6: zone2Temp = 69; break;
            case 7: zone2Temp = 75; break;
            case 8: zone2Temp = 73; break;
            case 9: zone2Temp = 63; break;
            case 10:zone2Temp = 50; break;
            case 11:zone2Temp = 37; break;
            case 12:zone2Temp = 30; break;
        }
        // determine the random value to be added to the average temperature
        setRandomAdd();
        // Add the random value to the average temperature to create the real temperature for the day
        realTemp = zone2Temp + randomAdd;
    }

    /**
     * setZone2Rain -> Determines the average monthly rainfall for a specific zone of the trail.
     *                  The data is based on North Platte, NE.
     * @param month -> An integer used to specify what month it is, so the data correlates with the journey
     */
    public void setZone2Rain(int month){
        // Switch statement by month for the average rainfall in zone 2
        switch(month){
            case 1: zone2Rain = 0.42; break;
            case 2: zone2Rain = 0.56; break;
            case 3: zone2Rain = 1.2; break;
            case 4: zone2Rain = 2.2; break;
            case 5: zone2Rain = 3.5; break;
            case 6: zone2Rain = 3.2; break;
            case 7: zone2Rain = 3.1; break;
            case 8: zone2Rain = 2.3; break;
            case 9: zone2Rain = 1.4; break;
            case 10:zone2Rain = 1.5; break;
            case 11:zone2Rain = 0.62; break;
            case 12:zone2Rain = 0.48; break;
        }
        //set the real amount of rain to the average in specified month of zone 2
        realRain = zone2Rain;
    }

    /**
     * setZone3Temp -> Determines the initial temperature for the region and time of year based on
     *             data of average temperatures in Casper, WY. Once the initial temperature is found
     *              a random value between -20 and 20 is added to the temperature to create different
     * @param month -> An integer used to specify what month it is, so the temperature relates accordingly.
     */
    public void setZone3Temp(int month){
        // Switch statement by month for the average temperature in zone 3
        switch(month){
            case 1: zone3Temp = 26; break;
            case 2: zone3Temp = 28; break;
            case 3: zone3Temp = 36; break;
            case 4: zone3Temp = 43; break;
            case 5: zone3Temp = 53; break;
            case 6: zone3Temp = 63; break;
            case 7: zone3Temp = 71; break;
            case 8: zone3Temp = 70; break;
            case 9: zone3Temp = 60; break;
            case 10:zone3Temp = 46; break;
            case 11:zone3Temp = 35; break;
            case 12:zone3Temp = 27; break;
        }
        // determine the random value to be added to the average temperature
        setRandomAdd();
        // Add the random value to the average temperature to create the real temperature for the day
        realTemp = zone3Temp + randomAdd;
    }

    /**
     * setZone3Rain -> Determines the average monthly rainfall for a specific zone of the trail.
     *                  The data is based on Casper, WY.
     * @param month -> An integer used to specify what month it is, so the data correlates with the journey
     */
    public void setZone3Rain(int month){
        // Switch statement by month for the average rainfall in zone 3
        switch(month){
            case 1: zone3Rain = 0.55; break;
            case 2: zone3Rain = 0.60; break;
            case 3: zone3Rain = 0.92; break;
            case 4: zone3Rain = 1.5; break;
            case 5: zone3Rain = 2.1; break;
            case 6: zone3Rain = 1.4; break;
            case 7: zone3Rain = 1.2; break;
            case 8: zone3Rain = 0.75; break;
            case 9: zone3Rain = 0.93; break;
            case 10:zone3Rain = 1.1; break;
            case 11:zone3Rain = 0.71; break;
            case 12:zone3Rain = 0.65; break;
        }
        //set the real amount of rain to the average in specified month of zone 3
        realRain = zone3Rain;
    }

    /**
     * setZone4Temp -> Determines the initial temperature for the region and time of year based on
     *             data of average temperatures in Lander, WY. Once the initial temperature is found
     *             a random value between -20 and 20 is added to the temperature to create different
     * @param month -> An integer used to specify what month it is, so the temperature relates accordingly.
     */
    public void setZone4Temp(int month){
        // Switch statement by month for the average temperature in zone 4
        switch(month){
            case 1: zone4Temp = 20; break;
            case 2: zone4Temp = 25; break;
            case 3: zone4Temp = 36; break;
            case 4: zone4Temp = 45; break;
            case 5: zone4Temp = 54; break;
            case 6: zone4Temp = 64; break;
            case 7: zone4Temp = 72; break;
            case 8: zone4Temp = 70; break;
            case 9: zone4Temp = 60; break;
            case 10:zone4Temp = 46; break;
            case 11:zone4Temp = 31; break;
            case 12:zone4Temp = 21; break;
        }
        // determine the random value to be added to the average temperature
        setRandomAdd();
        // Add the random value to the average temperature to create the real temperature for the day
        realTemp = zone4Temp + randomAdd;
    }

    /**
     * setZone4Rain -> Determines the average monthly rainfall for a specific zone of the trail.
     *                  The data is based on Lander, WY.
     * @param month -> An integer used to specify what month it is, so the data correlates with the journey
     */
    public void setZone4Rain(int month){
        // Switch statement by month for the average rainfall in zone 4
        switch(month){
            case 1: zone4Rain = 0.5; break;
            case 2: zone4Rain = 0.65; break;
            case 3: zone4Rain = 1.2; break;
            case 4: zone4Rain = 2.1; break;
            case 5: zone4Rain = 2.6; break;
            case 6: zone4Rain = 1.25; break;
            case 7: zone4Rain = 0.7; break;
            case 8: zone4Rain = 0.52; break;
            case 9: zone4Rain = 1.03; break;
            case 10:zone4Rain = 1.24; break;
            case 11:zone4Rain = 0.81; break;
            case 12:zone4Rain = 0.6; break;
        }
        //set the real amount of rain to the average in specified month of zone 4
        realRain = zone4Rain;
    }

    /**
     * setZone5Temp -> Determines the initial temperature for the region and time of year based on
     *             data of average temperatures in Boise, ID. Once the initial temperature is found
     *              a random value between -20 and 20 is added to the temperature to create different
     * @param month -> An integer used to specify what month it is, so the temperature relates accordingly.
     */
    public void setZone5Temp(int month){
        // Switch statement by month for the average temperature in zone 5
        switch(month){
            case 1: zone5Temp = 32; break;
            case 2: zone5Temp = 46; break;
            case 3: zone5Temp = 45; break;
            case 4: zone5Temp = 50; break;
            case 5: zone5Temp = 59; break;
            case 6: zone5Temp = 68; break;
            case 7: zone5Temp = 77; break;
            case 8: zone5Temp = 75; break;
            case 9: zone5Temp = 66; break;
            case 10:zone5Temp = 53; break;
            case 11:zone5Temp = 40; break;
            case 12:zone5Temp = 33; break;
        }
        // determine the random value to be added to the average temperature
        setRandomAdd();
        // Add the random value to the average temperature to create the real temperature for the day
        realTemp = zone5Temp + randomAdd;
    }

    /**
     * setZone5Rain -> Determines the average monthly rainfall for a specific zone of the trail.
     *                  The data is based on Boise, ID.
     * @param month -> An integer used to specify what month it is, so the data correlates with the journey
     */
    public void setZone5Rain(int month){
        // Switch statement by month for the average rainfall in zone 5
        switch(month){
            case 1: zone5Rain = 1.4; break;
            case 2: zone5Rain = 1.1; break;
            case 3: zone5Rain = 1.3; break;
            case 4: zone5Rain = 1.2; break;
            case 5: zone5Rain = 1.32; break;
            case 6: zone5Rain = 0.84; break;
            case 7: zone5Rain = 0.25; break;
            case 8: zone5Rain = 0.27; break;
            case 9: zone5Rain = 0.55; break;
            case 10:zone5Rain = 0.82; break;
            case 11:zone5Rain = 1.31; break;
            case 12:zone5Rain = 1.43; break;
        }
        //set the real amount of rain to the average in specified month of zone 5
        realRain = zone5Rain;
    }

    /**
     * setZone6Temp -> Determines the initial temperature for the region and time of year based on
     *              data of average temperatures in Portland, OR. Once the initial temperature is found
     *              a random value between -20 and 20 is added to the temperature to create different
     * @param month -> An integer used to specify what month it is, so the temperature relates accordingly.
     */
    public void setZone6Temp(int month){
        // Switch statement by month for the average temperature in zone 6
        switch(month){
            case 1: zone6Temp = 41; break;
            case 2: zone6Temp = 44; break;
            case 3: zone6Temp = 48; break;
            case 4: zone6Temp = 52; break;
            case 5: zone6Temp = 58; break;
            case 6: zone6Temp = 64; break;
            case 7: zone6Temp = 69; break;
            case 8: zone6Temp = 70; break;
            case 9: zone6Temp = 65; break;
            case 10:zone6Temp = 55; break;
            case 11:zone6Temp = 47; break;
            case 12:zone6Temp = 40; break;
        }
        // determine the random value to be added to the average temperature
        setRandomAdd();
        // Add the random value to the average temperature to create the real temperature for the day
        realTemp = zone6Temp + randomAdd;
    }

    /**
     * setZone6Rain -> Determines the average monthly rainfall for a specific zone of the trail.
     *                  The data is based on Portland, OR.
     * @param month -> An integer used to specify what month it is, so the data correlates with the journey
     */
    public void setZone6Rain(int month){
        // Switch statement by month for the average rainfall in zone 6
        switch(month){
            case 1: zone6Rain = 5.4; break;
            case 2: zone6Rain = 3.8; break;
            case 3: zone6Rain = 3.7; break;
            case 4: zone6Rain = 2.6; break;
            case 5: zone6Rain = 2.2; break;
            case 6: zone6Rain = 1.6; break;
            case 7: zone6Rain = 0.5; break;
            case 8: zone6Rain = 0.8; break;
            case 9:zone6Rain = 1.62; break;
            case 10:zone6Rain = 3.2; break;
            case 11:zone6Rain = 5.3; break;
            case 12:zone6Rain = 5.5; break;
        }
        //set the real amount of rain to the average in specified month of zone 6
        realRain = zone6Rain;
    }

    /**
     * getTemperature -> Using the temperatures from the different zones the daily temperature is found.
     * @param zone -> An integer used to determine which zone the group is in and the temperature of the zone
     * @param month -> An integer used to determine what of data to use.
     * @return -> The temperature that the group will experience for the day
     */
    public double getTemperature(int zone, int month){
        // Depending on the zone the group is currently traveling through, find the average temperature in a specific month
        if(zone <= 1){
            setZone1Temp(month);
        }
        else if(zone <= 2){
            setZone2Temp(month);
        }
        else if(zone <= 3){
            setZone3Temp(month);
        }
        else if(zone <= 4){
            setZone4Temp(month);
        }
        else if(zone <= 5){
             setZone5Temp(month);
        }
        else{
            setZone6Temp(month);
        }

        // Then actual real temperature for the day is stored as realTemp
        return realTemp;
    }

    /**
     * getRealTemp -> Accesses the actual temperature for the day.
     * @return -> The daily temperature
     */
    public int getRealTemp(){return realTemp;}

    /**
     * getRainfall -> Using the rainfall from the different zones the average daily rainfall is found.
     * @param zone -> An integer used to determine which zone the group is in and the temperature of the zone
     * @param month -> An integer used to determine what of data to use.
     */
    public void getRainfall(int zone, int month){
        /*
         Depending on which zone the group is currently traveling through find the average rainfall
         during a specified month.
         */
        if(zone <= 1){
            setZone1Rain(month);
        }
        else if(zone <= 2){
            setZone2Rain(month);
        }
        else if(zone <= 3){
            setZone3Rain(month);
        }
        else if(zone <= 4){
            setZone4Rain(month);
        }
        else if(zone <= 5){
            setZone5Rain(month);
        }
        else {
            setZone6Rain(month);
        }
    }

    /**
     * getTotalRain -> Gets the total rainfall and surface water for the day.
     * @return -> The total amount of rain or surface water.
     */
    public double getTotalRain(){return totalRain;}

    /**
     * getTotalSnow -> Gets the total accumulated snow on the ground.
     * @return -> The amount of snow on the ground.
     */
    public double getTotalSnow(){return totalSnow;}

    /**
     * chanceOfRain -> Determines if there is going to be rainy weather for the day. The probability
     *                  of it raining is based on the total average rainfall for the month. The higher
     *                  the average the more likely it i sto rain.
     * @param zone -> Integer used to show the zone that the group is traveling through at the time.
     * @param month -> Integer used to show what month of the year it is to determine the correlating rainfall.
     * @return -> True if the randomly generated probability is lass than the probability of it raining.
     *              False otherwise.
     */
    public boolean chanceOfRain(int zone, int month){
        //Use the method to find the average rainfall in a specific zone and month
        getRainfall(zone, month);

        //create doubles for the chance of it raining and it actually rain for the day.
        double chanceOfRain;
        double itsRaining = Math.random() * 100;

        //The chance of it raining varies depending on the average amount of rain that is found
        if(realRain <= 1){
            chanceOfRain = 7.0;
        }
        else if(realRain <= 2){
            chanceOfRain = 14.0;
        }
        else if(realRain <= 3){
            chanceOfRain = 21.0;
        }
        else if(realRain <= 4){
            chanceOfRain = 28.0;
        }
        else if(realRain <= 5){
            chanceOfRain = 35.0;
        }
        else{
            chanceOfRain = 45.0;
        }

        // Return a boolean for if it is actually raining for the day
        return itsRaining <= chanceOfRain;
    }

    /**
     * displayTemperature -> A string describing the temperature for the day is created based on the
     *                      numerical temperature generated for the day.
     * @param temp -> A double that represents the temperature of the day.
     * @return -> A string to be displayed to the user saying how hot the day is.
     */
    public String displayTemperature(double temp){
        // A string to describe the temperature for the day
        String tempDescription;

        /*
         The string changes value depending on the numerical temperature found previously.
         Ranges from very cold to very hot.
         */
        if(temp >= 90){
            tempDescription = "Very Hot";
        }
        else if(temp >=70){
            tempDescription = "Hot";
        }
        else if(temp >= 50){
            tempDescription = "Warm";
        }
        else if(temp >= 30){
            tempDescription = "Cool";
        }
        else if(temp >= 10){
            tempDescription = "Cold";
        }
        else{
            tempDescription = "Very Cold";
        }
        return tempDescription;
    }

    /**
     * heavyPrecipitation -> sets the probability for how heavy it will rain for the day
     * @param raining -> A boolean that tells if it is predicted to rain.
     */
    public void heavyPrecipitation(boolean raining){
        //When it is going to rain, find the probability for it being heavy rain or normal rain.
        if(raining) {
            rainHeaviness = Math.random();
        }
        //When it is NOT going to rain the probability if set to negative 1
        else{
            rainHeaviness = -1.0;
        }
    }

    /**
     * totalRainfall -> Tracks the total amount of rainfall. The heaviness of the rain determines how
     *              much rain to add to the total. The temperature is used to determine whether the
     *              precipitation is rain or snow.
     * @param zone -> Integer used to show the zone that the group is traveling through at the time.
     * @param month -> Integer used to show what month of the year it is to determine the correlating rainfall.
     */
    public String totalRainfall(int zone, int month){
        // create a string that tells the user how the precipitation is for the day
        String displayRain;
        heavyPrecipitation(chanceOfRain(zone, month));
        //When there is a chance for it to rain enter the if statement
        if(rainHeaviness != -1.0) {
            // 30% chance of heavy rain(temperature greater than 30) or snow(temperature less than 30) each time it precipitates
            if (rainHeaviness <= .30) {
                if (realTemp <= 30) {
                    // add 8 inches of snow
                    totalSnow += 8;
                    displayRain = "Very Snowy.";
                } else {
                    // add 0.8 inches of rain
                    totalRain += 0.8;
                    displayRain = "Very Rainy.";
                }
            }
            // 70% chance of normal precipitation, rain when temperature greater than 30, snow when temperature less than 30
            else {
                if (realTemp <= 30) {
                    // add two inches of snow
                    totalSnow += 2;
                    displayRain = "Snowy";
                } else {
                    // add 0.2 inches of rain
                    totalRain += 0.2;
                    displayRain = "Rainy";
                }
            }
        }
        // When there is no chance of it raining nothing is added to accumulated precipitation totals
        else {
            if (realTemp <= 30) {
                totalSnow += 0;
            } else {
                totalRain += 0.0;
            }
            displayRain = "";
        }
        return displayRain;
    }

    /**
     * resetRain -> Each day 10% of the accumulated rain evaporates and is subtracted form the total
     */
    public void resetRain(){
        //When there is accumulated rain 10% is removed form the total
        if(totalRain > 0.0) {
            totalRain *= 0.9;
        }
        else{
            totalRain = 0.0;
        }
    }

    /**
     * resetSnow -> If there is snow on the ground 3% of the total accumulated snow melts if the
     *              temperature is very cold, cold, or cool. If the temperature is warm, hot, or very hot
     *              5 inches of snow melts and 0.5 inches of water is added to the rainfall total.
     */
    public void resetSnow() {
        /*
         When there is snow on the ground 3% is removed from the total when it is cool, cold, or very cold.
         When it is warm, hot, or very hot, 5 inches of snow melt and 0.5 inches of rain are added
         */
        if (totalSnow > 0) {
            if (realTemp <= 45) {
                totalSnow *= .97;
            }
            else {
                totalSnow -= 5;
                totalRain += 0.5;
            }
        }
        // When there are zero inches of snow, the total snow is zero
        else{
            totalSnow = 0;
        }
    }
}

