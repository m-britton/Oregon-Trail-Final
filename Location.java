package com.example.mvpfororegontrail;

public class Location {

    private int location;
    private int month;
    private int day;
    private boolean atTown;
    private boolean atRiver;
    private boolean atLandmark;

    private boolean gameWon;

    private int townsVisited;
    private int riversVisited;
    private int landmarksVisited;

    //These distance variables is to determine if either landmark or atRiver is true. This should be changed in the main activity every time a landmark or river is reached
    private double distanceToTown;
    private double distanceToRiver;
    private double distanceToLandmark;

    private int zone = 0;
    private int pace = 1;

    //Constructor
    public Location (int location, int month, int day, int distanceToTown, int distanceToRiver, int distanceToLandmark)
    {
        this.location = location;
        this.month = month;
        this.day = day;

        this.atTown = false;
        this.atRiver = false;
        this.atLandmark = false;

        this.distanceToTown = distanceToTown;
        this.distanceToRiver = distanceToRiver;
        this.distanceToLandmark = distanceToLandmark;

        this.townsVisited = 0;
        this.riversVisited = 0;
        this.landmarksVisited = 0;
        this.gameWon = false;
    }

    public void setLocation (int location) {
        if (location >= 0) {
            this.location = location;
        } else {
            this.location = 0;
        }
    }

    public void setMonth (int month)
    {
        if (month > 0 && month <=12)
        {
            this.month = month;
        }
        else
        {
            this.month = 1;
        }
    }

    public void setDay (int day)
    {
        if (day > 0 && day <= 31)
        {
            this.day = day;
        }
        else
        {
            this.day = 1;
        }
    }

    public void setAtTown(boolean atTown)
    {
        this.atTown = atTown;
    }

    public void setAtRiver (boolean atRiver)
    {
        this.atRiver = atRiver;
    }

    public void setAtLandmark(boolean atLandmark){
        this.atLandmark = atLandmark;
    }

    //Setters for the distance variables. Should be reset every time one is reached.
    public void setDistanceToTown(double distance)
    {
        this.distanceToTown = distance;
    }
    public void setDistanceToRiver(double distance)
    {
        this.distanceToRiver = distance;
    }
    public void setDistanceToLandmark(double distance)
    {
        this.distanceToLandmark = distance;
    }

    //Getters
    public int getLocation()
    {
        return this.location;
    }
    public int getMonth()
    {
        return this.month;
    }
    public int getDay()
    {
        return this.day;
    }
    public boolean getAtTown()
    {
        return this.atTown;
    }
    public boolean getAtRiver()
    {
        return this.atRiver;
    }
    public boolean getAtLandmark()
    {
        return this.atLandmark;
    }
    public int getLandmarksVisited()
    {
        return this.landmarksVisited;
    }
    public double getDistanceToTown()
    {
        return this.distanceToTown;
    }
    public double getDistanceToRiver()
    {
        return this.distanceToRiver;
    }
    public double getDistanceToLandmark()
    {
        return this.distanceToLandmark;
    }

    public int getZone(){return zone;}
    public int getPace(){return pace;}


    //Returns what month it is as a string based upon the integer number for month
    public String whatMonth()
    {
        String monthOfYear = "";

        switch (this.month)
        {
            case 1:
                monthOfYear = "January";
                break;
            case 2:
                monthOfYear = "February";
                break;
            case 3:
                monthOfYear = "March";
                break;
            case 4:
                monthOfYear = "April";
                break;
            case 5:
                monthOfYear = "May";
                break;
            case 6:
                monthOfYear = "June";
                break;
            case 7:
                monthOfYear = "July";
                break;
            case 8:
                monthOfYear = "August";
                break;
            case 9:
                monthOfYear = "September";
                break;
            case 10:
                monthOfYear = "October";
                break;
            case 11:
                monthOfYear = "November";
                break;
            case 12:
                monthOfYear = "December";
                break;
            default :
                monthOfYear = "Error invalid data";
        }
        return monthOfYear;
    }

    //Increments the day count by 1 (sets to zero if the month changes) and switches the month if the criteria is met
    public void incrementDay()
    {
        //Checks if the current month has 31 days and, if so, makes sure the month changes if it is day 31
        if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12)
        {
            if (this.day == 31)
            {
                this.day = 1;
                this.month++;
            }
            else
            {
                this.day++;
            }
        }

        //checks if the current month has 30 days
        if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
        {
            if(this.day == 30)
            {
                this.day = 1;
                this.month++;
            }
            else
            {
                this.day++;
            }
        }

        //Checks if it is february
        if (this.month == 2)
        {
            if (this.day == 28)
            {
                this.day = 1;
                this.month++;
            }
            else
            {
                this.day++;
            }
        }

        //Makes sure months goes back to 1 after twelve
        if (this.month >12)
        {
            this.month = 1;
        }

    }

    //Determines if the player is at any special stop. This should be called in the main method for every day that passes.
    public void atLandmark()
    {
        if (this.distanceToRiver <= 0)
        {
            atRiver = true;
            riversVisited++;
        }

        if(this.distanceToTown <= 0)
        {
            atTown = true;
            townsVisited++;
        }

        if(this.distanceToLandmark <= 0)
        {
            this.atLandmark = true;
            this.landmarksVisited++;
        }
    }

    //Determines what town the player is in based on how many towns they have visited
    public String whatTown()
    {
        String town = "";

        switch(this.townsVisited)
        {
            case 1:
                town = "Fort Kearney";
                zone += 1;
                break;
            case 2:
                town = "Laramie";
                zone += 1;
                break;
            case 3:
                town = "Fort Bridger";
                zone += 1;
                break;
            case 4:
                town = "Fort Hall";
                zone += 1;
                break;
            case 5:
                town = "Fort Boise";
                zone += 1;
                break;
            case 6:
                town = "Fort Walla Walla";
                zone += 1;
                break;
            case 7:
                town = "Oregon City";
                this.gameWon = true;
                break;
            default:
                town = "Error";
                break;
        }
        return town;
    }

    //Determines what landmark the player is at depending on how many landmarks they have visited
    public String whatLandmark()
    {
        String landmark = "";

        switch(this.landmarksVisited)
        {
            case 1:
                landmark ="Chimney Rock";
                break;
            case 2:
                landmark = "Independence Rock";
                break;
            case 3:
                landmark = "South Pass";
                break;
            case 4:
                landmark = "Soda Springs";
                break;
            case 5:
                landmark = "Blue Mountaints";
                break;
            case 6:
                landmark = "The Dalles";
                break;
            default:
                landmark = "error";
                break;
        }

        return landmark;
    }

    public double locationFromPace(int pace, double oxen, int sickPeople, double snow, String location){

        double setPace = 20; //travel 20 miles a day

        if(pace == 1){ //Steady pace
            setPace *= 1;

        }
        else if (pace == 2){ //Strenouse pace
            setPace *= 1.5;

        }
        else if (pace == 3){ //Grueling pace
            setPace *= 2;

        }
        if (location.equalsIgnoreCase("chimney rock") || location.equalsIgnoreCase("independence rock") || location.equalsIgnoreCase("blue mountains")){
            setPace *= 0.5;

        }
        if (oxen < 4){
            setPace *= oxen / 4;

        }
        if(sickPeople >= 1){
            setPace *= sickPeople * .10;

        }
        if(snow >= 30){
            setPace = 0;

        }

        return setPace;
    }
}