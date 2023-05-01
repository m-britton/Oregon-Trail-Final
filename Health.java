/**
 * Name: Health
 * Date:/ 4/1/23
 * Author: McKinley Britton
 * Description: The Health class takes care of the overall health of a group traveling along the
 *              Oregon Trail. The health is determined by many factors: food, pace, weather, random
 *              events. Health is tracked as a double variable because health is based on a number,
 *              and maxes out at 140. If the group reaches a health of 140, they are days from death.
 *              Thus, the healthier the group is the lower the value of the health variable.
 */

package com.example.mp2oregontrailmvp;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Health {

    // Fields

    public double health = 0.0;
    private double oxenHealth = 0.0;
    private double sickOxen = 0.0;
    private double freezeStarveFactor = 0.0;
    private int sickPeople = 0;

    private int totalPeople = 5;
    private double totalOxen = 0.0;

    private int person1daysSick = 0;
    private int person2daysSick = 0;
    private int person3daysSick = 0;
    private int person4daysSick = 0;
    private int person5daysSick = 0;

    private int person1illnesses = 0;
    private int person2illnesses = 0;
    private int person3illnesses = 0;
    private int person4illnesses = 0;
    private int person5illnesses = 0;

    private boolean person1health = true;
    private boolean person2health = true;
    private boolean person3health = true;
    private boolean person4health = true;
    private boolean person5health = true;

    private ArrayList<String> deadPeople = new ArrayList<String>();

    private String person1 = "Hattie";
    private String person2 = "";
    private String person3 = "";
    private String person4 = "";
    private String person5 = "";



    // Constructors

    /**
     * Default constructor that creates a new Health object containing the overall health of the
     *   group traveling along the Oregon Trail
     */
    public Health(){}

    // Getters and Setters

    /**
     * setHealth: Sets the overall health of the group depending on what happens
     * @param health -> The new value that health will take on
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * setTotalOxen -> Sets the total number of oxen the group has with them on their journey.
     * @param oxen -> The amount of oxen that the group has.
     */
    public void setTotalOxen(int oxen){totalOxen = oxen;}

    /**
     * setOxenHealth -> Sets the overall health of the oxen.
     * @param oxHealth -> The value representing the health of all the oxen.
     */
    public void setOxenHealth(double oxHealth){oxenHealth = oxHealth;}

    /**
     * setSickOxen -> Tracks the number or oxen that are sick at any given time.
     * @param sickOxen -> The value used to denote how many oxen are sick.
     */
    public void setSickOxen(double sickOxen){this.sickOxen = sickOxen;}

    /**
     * getHealth -> Accesses the value of the health variable
     * @return -> the overall health of the group traveling to Oregon
     */
    public double getHealth() {
        return health;
    }

    /**
     * getTotalOxen -> Accesses the total number of oxen the group has with them.
     * @return -> The number of oxen that the group has.
     */
    public double getTotalOxen(){return totalOxen;}

    /**
     * getOxenHealth -> Accesses the overall health of all the oxen with the group.
     * @return -> The overall health of the oxen.
     */
    public double getOxenHealth(){return oxenHealth;}

    /**
     * getSickOxen -> Accesses the number of oxen that are sick.
     * @return -> The number of oxen that are sick.
     */
    public double getSickOxen(){return sickOxen;}

    /**
     * getTotalPeople -> Accesses the total number of people in the group at any given time.
     * @return -> The total number of people left in the group.
     */
    public int getTotalPeople(){return totalPeople;}

    /**
     * getSickPeople -> Accesses the number of people that are sick at any given time.
     * @return -> The number of people who are sick.
     */
    public int getSickPeople(){return sickPeople;}

    /**
     * getNumberIllnesses -> Accesses the number of times a person has contracted an illness.
     * @param person -> Tells which person of the group is being looked at.
     * @return -> The number of illnesses a specific person has had along the trail.
     */
    public int getNumberIllnesses(String person){
        if(person.equalsIgnoreCase(person1)){
            return person1illnesses;
        }
        else if(person.equalsIgnoreCase(person2)){
            return person2illnesses;
        }
        else if(person.equalsIgnoreCase(person3)){
            return person3illnesses;
        }
        else if(person.equalsIgnoreCase(person4)){
            return person4illnesses;
        }
        else{
            return person5illnesses;
        }
    }


    // Other Methods

    /**
     * addHealth -> adds a specific amount of health to the overall health of the group
     * @param health -> the amount that is added to the overall health of the group
     */
    public void addHealth(double health ){
        this.health += health;
    }

    /**
     * addOxenHealth -> Adds an specified amount to the total overall health of the oxen.
     * @param oxHealth -> The amount that is being added to the total oxen health.
     */
    public void addOxenHealth(double oxHealth){oxenHealth += oxHealth;}

    /**
     * startOfDayHealth -> The overall health decreases by ten percent to simulate natural recovery
     * @return -> The health of the group after recovering from rest overnight
     */
    public double startOfDayHealth(){
        health *= 0.9;
        return health;
    }

    /**
     * healthFromFood -> The amount of food in the wagon effects the overall health of the group,
     *                   the less food the group has the worse their health gets. (More health added)
     * @param rations -> A string stating how the amount of food rations for the group along the way
     * @return -> The health variable with the updated value based on the amount of food
     */
    public double healthFromFood(String rations){
        /*
         Check to see how the rations are set for the group, the smaller the ration the more that is added to the overall health
         For filling rations add 0, meager add 2, bare bones add 6, and if there is no food add 6
         */
        if(rations.equalsIgnoreCase("filling")){
            health += 0;
        }
        else if(rations.equalsIgnoreCase("meager")){
            health += 2;
        }
        else if(rations.equalsIgnoreCase("bare bones")){
            health += 4;
        }
        else{
            health += 6;
        }

        return health;
    }

    /**
     * healthFromPace -> Different paces effect the overall health of the group, the faster the pace
     *                  the more the health variable increases.
     * @param pace -> A string that describes the pace at which the group is moving during the day.
     * @return -> The health variable with it's updated value, based on how fast the group moves.
     */
    public double healthFromPace(int pace){
        /*
        Check how the used has set the pace for the group, more health is added to the overall health as the group moves faster
        0 means the group is resting and nothing is added, 1 means normal pace and 2 is added,
        2 means 1.5x speed and 4 is added, anything faster than that and 6 is added
         */
        if(pace == 0){
            health += 0;
        }
        else if(pace == 1){
            health += 2;
        }
        else if(pace == 2){
            health += 4;
        }
        else{
            health += 6;
        }
        return health;
    }

    /**
     * healthFromWeather -> Determines how much the health factor grows based on the weather for the day.
     * @param weather -> A string that describes the weather the group is experiencing for the day.
     * @param clothes -> Integer to tell how many sets of clothes the group has for each person.
     * @return -> The updated health variable, based on how the weather is effecting the groups health.
     */
    public double healthFromWeather(String weather, double clothes){
        /*
        Check the temperature description and add the correlating amount of health.
        For very hot weather add 2, hot weather add 1, warm or cool weather add 0.
        For cold and very cold weather the amount added depends on how many clothes the group has for each person to stay warm.
        The less the amount of clothes the more that is added to the health.
         */

        if(weather.equalsIgnoreCase("very hot")){
            health += 2;
        }
        else if(weather.equalsIgnoreCase("hot")){
            health += 1;
        }
        else if(weather.equalsIgnoreCase("cold")){
            if(clothes == 0){
                health += 2;
            }
            else if( clothes < 2 * getTotalPeople()){
                health += 1;
            }
            else{
                health += 0;
            }
        }
        else if(weather.equalsIgnoreCase("very clod")){
            if(clothes == 0){
                health += 4;
            }
            else if(clothes <= getTotalPeople()){
                health += 3;
            }
            else if(clothes <= 2 * getTotalPeople()){
                health += 2;
            }
            else if(clothes <= 3 * getTotalPeople()){
                health += 1;
            }
            else{
                health += 0;
            }
        }
        else{
            health += 0;
        }
        return health;
    }

    /**
     * generalHealth -> Describes the overall health of the group. The higher the health variable is
     *                  the worse their health is.
     * @return -> A string telling the user how healthy their group is at the end of the day.
     *             Ranges form Good Health to very poor health.
     */
    public String generalHealth(){
        // create a string to display the overall health of the group to the user.
        String displayHealth;

        /*
        The higher the health variable the worse the group is doing.
        For health less than 34 the group has good health, less than 65 the group has fair health,
        less than 104 the group has poor health, less than 140 the group has very poor health, anything high means death is soon
         */
        if(health <= 34.0){
            displayHealth = "Good Health";
        }
        else if(health <= 65.0){
            displayHealth = "Fair Health";
        }
        else if(health <= 104.0){
            displayHealth = "Poor Health";
        }
        else if(health <= 139.0){
            displayHealth = "Very Poor Health";
        }
        else{
            displayHealth = "Death is days away";
        }

        return displayHealth;
    }

    /**
     * starveFreezeFactor -> The negative effects of freezing or starving increase at an exponential
     *                      rate if the conditions persist. The freeze/starve factor is added to the overall health.
     * @param foodRations -> Double used to tell how much food the party has.
     * @param clothing -> Double used to tell the amount of clothing the group has.
     * @param temp  -> Double used to tell what the temperature for the day is.
     */
    public void starveFreezeFactor(double foodRations, double clothing, double temp){
        /*
         When the group has no food, or an inadequate amount of clothing in cold weather the
         freeze/starve factor goes up by 0.8 otherwise it is cut in half. It is then added to the overall health.
         */
        if(foodRations == 0.0 || (clothing <= 4 && temp <= 30)) {
            freezeStarveFactor += 0.8;
        }
        else{
            freezeStarveFactor /= 2.0;
        }
        addHealth(freezeStarveFactor);
    }

    /**
     * trackDisease -> Tracks the number of days an individual has had their disease, up to ten days.
     * @param person -> The person that has contracted the disease.
     */
    public void setDaysSick(String person){
        if(person.equalsIgnoreCase(person1)){
            person1daysSick += 10;
        }
        else if(person.equalsIgnoreCase(person2)){
            person2daysSick += 10;
        }
        else if(person.equalsIgnoreCase(person3)){
            person3daysSick += 10;
        }
        else if(person.equalsIgnoreCase(person4)){
            person4daysSick += 10;
        }
        else{
            person5daysSick += 10;
        }
    }

    public void resetDaysSick(){
        if(person1daysSick > 0){
            person1daysSick -= 1;
            person1health = false;
        }
        else{
            person1health = true;
        }
        if(person2daysSick > 0){
            person2daysSick -= 1;
            person2health = false;
        }
        else{
            person2health = true;
        }
        if(person3daysSick > 0){
            person3daysSick -= 1;
            person3health = false;
        }
        else{
            person3health = true;
        }
        if(person4daysSick > 0){
            person4daysSick -= 1;
            person4health = false;
        }
        else{
            person4health = true;
        }
        if(person5daysSick > 0){
            person5daysSick -= 1;
            person5health = false;
        }
        else{
            person5health = true;
        }
    }
    /**
     * trackInjury -> Tracks the number of days an individual has had an injury, up to thirty days.
     * @param person -> The person that has sustained the injury.
     */
    public void trackInjury(boolean person){
        for(int days = 0; days < 30; days++){
            person = false;
        }
        person = true;
        sickPeople -= 1;
    }

    /**
     * sickOx -> When an oxen gets sick or injured they lose half of their ability to function, so
     *          one oxen becomes half an oxen. When a case of illness or injury comes along and there
     *          is an oxen already sick or injured then that oxen dies and the group loses one of it's oxen.
     */
    public void sickOx(){
        // When an oxen gets sick they are reduced to half an oxen and the total oxen drop by the same amount.
        sickOxen += 0.5;
        totalOxen -= sickOxen;

        // When there is 1 full oxen sick the oxen dies and the amount of sick oxen is rest to zero
        if(sickOxen == 1){
            sickOxen = 0.0;
        }
    }

    /**
     * randomDisease -> A random disease is selected from the six diseases that the members of the
     *                  party could contract at some point.
     * @return -> The disease that has been randomly selected.
     */
    public String randomDisease(){
        // create a string to hold a randomly chosen disease, and create a random value to determine the disease
        String disease = "";
        Random choice = new Random();
        int randomInt = choice.nextInt(6) + 1;

        // The chosen disease is based on the randomly generated number and found in the switch statement
        switch(randomInt){
            case 1: disease = "Exhaustion"; break;
            case 2: disease = "Typhoid"; break;
            case 3: disease = "Cholera"; break;
            case 4: disease = "Measles"; break;
            case 5: disease = "Dysentery"; break;
            case 6: disease = "Fever"; break;
        }
        return disease;
    }

    /**
     * personDeath -> If a person is already ill and they contract another disease they die. This method
     *                determines whether or not a person has contracted multiple diseases and is going to die.
     * @param personHealth -> A boolean variable denoting the current state of health of a person.
     * @param person -> A string representing the person that is currently being checked for underlying illness.
     * @return -> A string stating if the person has died or not.
     */
    public String personDeath(int personHealth, String person){
        // Create a string to hold the message that someone in the group has died
        String message = "";

        // If the person has contracted 3 diseases then that person will die and the group is decreased by 1
        if(personHealth == 3){
            message = person + " Has died.";
            deadPeople.add(person);
            totalPeople -= 1;
            sickPeople -= 1;
        }
        return message;
    }

    /**
     * randomPerson -> When the random event of illness strikes a random member of the group is
     *                  chosen to become ill. A random number is generated and the corresponding person is found.
     * @return -> The person corresponding with the randomly generated number.
     */
    public String randomPerson(){
        String person = "";
        Random num = new Random();
        int randomPerson = num.nextInt(5) + 1;
        switch(randomPerson){
            case 1: person = person1; break;
            case 2: person = person2; break;
            case 3: person = person3; break;
            case 4: person = person4; break;
            case 5: person = person5; break;
        }
        for(int i = 0; i < deadPeople.size(); i++){
            if(Objects.equals(person, deadPeople.get(i))){
                randomPerson();
            }
        }
        return person;
    }

    /**
     * randomPersonHealth -> Finds the person that is passed through as a parameter and outputs the
     *                      corresponding variable showing if that person is healthy or sick.
     * @param person -> A string used to represent the specific person whose health needs to be checked.
     * @return -> The boolean variable denoting whether a person is healthy or sick.
     */
    public boolean randomPersonHealth(String person){
        if(person.equalsIgnoreCase(person1)){
            return person1health;
        }
        else if(person.equalsIgnoreCase(person2)){
            return  person2health;
        }
        else if(person.equalsIgnoreCase(person3)){
            return person3health;
        }
        else if(person.equalsIgnoreCase(person4)){
            return person4health;
        }
        else{
            return person5health;
        }
    }

    /**
     * sickPerson -> The person passed in as a parameter is compared to the names of the people in the
     *              group to determine what person has contracted an illness. When the correct match is
     *              found, the corresponding boolean variable is updated to false to represent the
     *              fact that they are unwell.
     * @param person -> A string used to determine what person has contracted an illness.
     */
    public void sickPerson(String person){
        if(person.equalsIgnoreCase(person1)){
            person1health = false;
            person1illnesses += 1;
            sickPeople += 1;
        }
        else if(person.equalsIgnoreCase(person2)){
            person2health = false;
            person2illnesses += 1;
            sickPeople += 1;
        }
        else if(person.equalsIgnoreCase(person3)){
            person3health = false;
            person3illnesses += 1;
            sickPeople += 1;
        }
        else if(person.equalsIgnoreCase(person4)){
            person4health = false;
            person4illnesses += 1;
            sickPeople += 1;
        }
        else{
            person5health = false;
            person5illnesses += 1;
            sickPeople += 1;
        }
    }
}