/**
 * Name: RandomEvents
 * Date: 4/1/23
 * Author: McKinley Britton
 * Description: The RandomEvents class determines whether something random will happen to a group
 *              traveling along the Oregon Trail. These events can be good or bad, and can effect a
 *              range of things from health, weather, food, clothing, and more. Each event has it's
 *              own likelihood, and it is the same for each day traveling along the trail.
 */

package com.example.mp2oregontrailmvp;
import androidx.annotation.Nullable;

import java.util.Random;

public class RandomEvents {

    // Constant variables that show the likelihood of an event occurring
    private final double snakeBite = 0.7;
    private final double indiansFindFood = 5.0;
    private final double wrongWay = 1.0;
    private final double lostTrail = 2.0;

    private final double foundWildFruit = 4.0;
    private final double fire = 2.0;
    private final double lostMember = 1.0;
    private final double missingOx = 1.0;
    private final double abandonedWagon = 2.0;
    private final double prairieInjury = 2.0;
    private final double mountainInjury = 3.5;
    private final double thief = 2.0;
    private final double badWater = 10.0;
    private final double veryLittleWater = 20.0;
    private final double inadequateGrass = 20.0;
    private final double doTask = 50.0;

    // The probability of an event happening
    public double eventProbability = 0.0;

    // constructors
    /**
     * Constructor that finds the probability of something happening
     */
    public RandomEvents(){ setEventProbability();}

    // getters and setters

    /**
     * setEventProbability -> Sets the value of the eventProbability variable
     */
    public void setEventProbability(){
        Random num = new Random();
        eventProbability = Math.random() * 100;
    }

    /**
     * getEventProbability -> Accesses the probability/likelihood of an event happening
     * @return -> The probability of an event
     */
    public double getEventProbability(){ return eventProbability;}

    //other methods

    /**
     * snakeBite -> Determines whether or not someone in the group gets bit by a snake each day
     * @return -> True if likelihood of getting a snake bite is greater than randomly generated
     *            probability for the event; False otherwise
     */
    public boolean snakeBite(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= snakeBite;
    }

    /**
     * indiansHelpFindFood -> Determines whether or not the group gets help finding food from Indians
     * @return -> True if likelihood of Indians helping find food is greater than randomly generated
     *             probability for the event; False otherwise
     */
    public boolean indiansHelpFindFood(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= indiansFindFood;
    }

    /**
     * wrongTrail -> Determines whether or not the group went down the wrong trail
     * @return -> True if likelihood of traveling the wrong trail is greater than randomly generated
     *           probability for the event; False otherwise
     */
    public boolean wrongTrail(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= wrongWay;
    }

    /**
     * injuredOxen -> Used when traveling on the prairie. Determines if an oxen is injured
     * @param zone -> An integer representing the zone the group is traveling in, and if the zone is mountainous.
     * @return -> True if the randomly generated probability is less than that of getting injured
     *              on the prairie or in the mountains; False otherwise.
     */
    public boolean injuredOxen(int zone){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        if(zone > 3 && zone < 6 ){
            return eventProbability <= mountainInjury;
        }
        else {
            return eventProbability <= prairieInjury;
        }
    }

    /**
     * injuredPerson -> Used when traveling on the prairie. Determines if an oxen is injured
     * @param zone -> An integer representing the zone the group is traveling in, and if the zone is mountainous.
     * @return -> True if the randomly generated probability is less than that of getting injured
     *              on the prairie or in the mountains; False otherwise.
     */
    public boolean injuredPerson(int zone){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        if(zone > 3 && zone < 6 ){
            return eventProbability <= mountainInjury;
        }
        else {
            return eventProbability <= prairieInjury;
        }
    }

    /**
     * lostTrail -> Determines whether or not the group loses the trail on their journey.
     * @return -> True if the randomly generated probability is less than the likeliness of losing
     *              the trail; False otherwise;
     */
    public boolean lostTrail(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= lostTrail;
    }


    /**
     * foundFruit -> Used during months May-September. Determines whether or not the group finds wild
     *              fruit along the trail during their travels.
     * @return -> True if the randomly generated probability if less than the probability of finding
     *              wild fruit; False otherwise.
     */
    public boolean foundFruit(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= foundWildFruit;
    }

    /**
     * wagonFire -> Determines whether or not the groups wagon catches fire during the day.
     * @return -> True if the randomly generated probability if less than that of the catching fire.
     *              False otherwise.
     */
    public boolean wagonFire(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= fire;
    }

    /**
     * lostPerson -> Determines whether or not a party member goes missing on the journey.
     * @return -> True if the randomly generated probability if less than the probability of a
     *              party member going missing; False otherwise.
     */
    public boolean lostPerson(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= lostMember;
    }

    /**
     * lostOxen -> Determines whether or not one of the oxen wanders off.
     * @return -> True if the randomly generated probability if less than the probability of an oxen
     *              wandering off; False otherwise;
     */
    public boolean lostOxen(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return  eventProbability <= missingOx;
    }

    /**
     * foundWagon -> Determines whether or not the group finds an abandon wagon along the trail.
     * @return -> True if the randomly generated probability if less than the probability of finding
     *              an abandoned wagon; False otherwise.
     */
    public boolean foundWagon(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= abandonedWagon;
    }

    /**
     * robbedAtNight -> Determines whether or not a thief comes in the middle of the night an robs
     *                  the wagon.
     * @return -> True if the randomly generated probability if less than the probability of a thief
     *             robbing the wagon; False otherwise.
     */
    public boolean robbedAtNight(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= thief;
    }

    /**
     * badWater -> Used when accumulated rainfall is less than 0.1 inch. Determines whether or not
     *              the water is bad to consume.
     * @return -> True if the randomly generated probability if less than the probability of consuming
     *              bad water; False otherwise.
     */
    public boolean badWater(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= badWater;
    }

    /**
     * littleWater -> Used when accumulated rainfall is below 0.1 inch. Determines whether or not the
     *                  group has very little water access.
     * @return -> True if the randomly generated probability if less than the probability of experiencing
     *              very little water; False otherwise.
     */
    public boolean littleWater(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= veryLittleWater;
    }

    /**
     * badGrass -> Used when accumulated rainfall is less than 0.1 inch. Determines whether or not the
     *              grass is suitable for the oxen.
     * @return -> True if the randomly generated probability if less than the probability of inadequate
     *              grass; False otherwise.
     */
    public boolean badGrass(){
        // generate a random probability of an event occurring and compare it to the probability of a specific event
        setEventProbability();
        return eventProbability <= inadequateGrass;
    }

    /**
     * illness -> Determines the likelihood of a party member contracting a disease. The probability
     *              of contracting a disease fluctuates based on the overall health of the group.
     *              The higher the health the more likely it is to contract a disease.
     * @param health -> An integer that represents the overall health of the group.
     * @return -> True if the randomly generated probability is less than the probability of contracting an illness..
     */
    public boolean illness(double health){
        // create a variable to represent the probability of a group member getting ill
        double illnessProbability = 0.0;

        /*
         Use the total health of the group to determine the probability of a group member contracting an illness.
         The higher the total health of the group the more likely it is to become sick.
         */
        if(health <= 34){
            illnessProbability = 5.0;
        }
        else if(health <= 65){
            illnessProbability = 10.0;
        }
        else if(health <= 104){
            illnessProbability = 20.0;
        }
        else if(health <= 139){
            illnessProbability = 32.0;
        }
        else{
            illnessProbability = 45.0;
        }

        // Generate a random probability of an illness occurring and compare it to the actual probability of an illness occurring.
        setEventProbability();
        return eventProbability <= illnessProbability;
    }

    /**
     * safeCrossing -> Used when the group has to cross a river. The probability of complications differs
     *                  based on the method of crossing that the player chooses.
     * @param methodOfCrossing -> An integer that represents the method that the player has chosen to cross by.
     * @return -> True if the randomly generated probability is less than the likelihood of a problem
     *              occurring while crossing; False otherwise
     */
    public boolean safeCrossing(int methodOfCrossing){
        //Create a variable to represent the likelihood of a problem occurring when crossing the river.
        double problemCrossing = 0.0;

        /*
        Depending on the method the player uses to cross the river the chance of a problem changes.
        Safer choices lessen the probability of something going wrong.
         */
        if(methodOfCrossing == 1){
            problemCrossing = 10;
        }
        else if(methodOfCrossing == 2){
            problemCrossing = 5;
        }
        else{
            problemCrossing = 0.5;
        }

        //Generate a random probability of a problem happening, and compare it to the chance of problems actually occurring
        setEventProbability();
        return eventProbability <= problemCrossing;
    }

    public boolean womenTask(){
        setEventProbability();
        return eventProbability <= doTask;
    }
}
