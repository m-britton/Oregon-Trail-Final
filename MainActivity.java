package com.example.mp2oregontrailmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Creation of classes used.
    RandomEvents re = new RandomEvents();
    Health health = new Health();
    Location location = new Location(0, 1, 1, 200, 100, 300);
    Shop shop = new Shop();
    Weather weather = new Weather();
    Wagon wagon = new Wagon(shop.food_Price / .1, shop.clothing_Price / .2, shop.weapons_Price / 20, shop.oxen_Price / 50, shop.spareWagonWheel_Price / 8, shop.spareWagonAxel_Price / 3, shop.spareWagonTongues_Price / 3, shop.medicalSupplyBox_Price / 1.5, shop.sewingKit_Price / .50, shop.fireStartingKit_Price / .25, shop.kidsToys_Price / .05, 1, shop.seedPackeges_Price / .01, shop.shovels_Price / 2.5, shop.cookingItems_Price / 1.5);
    MediaPlayer mp;
    MediaPlayer st;

    public boolean wagonMade = true;
    public boolean mtIsPlaying = false;

    String rations = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView display = findViewById(R.id.Display);
        final Button nextDay = findViewById(R.id.button);
        final TextView date = findViewById(R.id.Date);
        final TextView foodBox = findViewById(R.id.foodRemaining);
        final TextView healthBox = findViewById(R.id.healthBox);
        final TextView reBox = findViewById((R.id.REbox));
        final Button enter = findViewById(R.id.enter);
        final EditText User_InputBox = findViewById(R.id.UserInput);
        final TextView shopDisplay = findViewById(R.id.shopDisplay);
        final ImageView picture = findViewById(R.id.imageView);
        final Button enterShop = findViewById(R.id.enterShop);
        final Button leaveShop = findViewById(R.id.leaveShop);
        final TextView weatherBox = findViewById(R.id.weatherBox);
        //This is to change background color in order to do so use .setBackgroundColor()
        final LinearLayout background = findViewById(R.id.linear);

        //Array of images, images made be added as needed
        final int a[] = {R.drawable.shoppingpic, R.drawable.traveling, R.drawable.hattiecampbell, R.drawable.oregonstart, R.drawable.chimneyrock, R.drawable.forthall, R.drawable.fortboise, R.drawable.fortkearney, R.drawable.fortwallawalla, R.drawable.laramie, R.drawable.sodaspring, R.drawable.southpass, R.drawable.thedalles, R.drawable.oregoncity};

        //Creates a media player for main theme
        mp = MediaPlayer.create(this, R.raw.maintune);
        st = MediaPlayer.create(this, R.raw.shoptune);


        //When clicked takes player to shop
        enterShop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Sets store layout along with making everything invisible until leaving the shop
                shopDisplay.setText(shop.storeLayout());
                enterShop.setVisibility(View.INVISIBLE);
                reBox.setVisibility(View.INVISIBLE);
                date.setVisibility(View.INVISIBLE);
                healthBox.setVisibility(View.INVISIBLE);
            }
        });

        leaveShop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                shopDisplay.setVisibility(View.INVISIBLE);
                reBox.setVisibility(View.VISIBLE);
                date.setVisibility(View.VISIBLE);
                healthBox.setVisibility(View.VISIBLE);
                leaveShop.setVisibility(View.INVISIBLE);
                enter.setVisibility(View.INVISIBLE);
                User_InputBox.setVisibility(View.INVISIBLE);
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //Changes text of button to just enter
                enter.setText("Confirm");
                //Changes image to that of the shopping area
                picture.setImageResource(R.drawable.shoppingpic);
                //Changes music
                st.start();

                // Get the users input from the text box and convert to a string.
                String input = User_InputBox.getText().toString();

                // If the user decides to buy items then the item bought and the price owed for the item are updated.
                if (shop.buying) {
                    String boughtItem = shop.buyItem(input);
                    shopDisplay.setText(boughtItem);
                } else {
                    shop.calcBoughtItem(shop.otherinput, Integer.parseInt(input));
 //                   shopDisplay.setText(shop.storeShelf);
                }
            }

        });

        // Actions occur when the Next Day button is clicked.
        nextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Switches and removes all necessary aesthetics
                enter.setVisibility(View.INVISIBLE);
                User_InputBox.setVisibility(View.INVISIBLE);
                leaveShop.setVisibility(View.INVISIBLE);
                st.stop();
                //Changes images to oregon start
                picture.setImageResource(R.drawable.oregonstart);
                //Starts the mt if it is not playing
                if (mtIsPlaying = false) {
                    mp.start();
                    mtIsPlaying = true;
                }
                mp.start();


                //Changes the variables in the wagon class based upon purchased items.
                if (wagonMade) {
                    wagon = new Wagon(shop.food_Price / .1, shop.clothing_Price / .2, shop.weapons_Price / 20, shop.oxen_Price / 50, shop.spareWagonWheel_Price / 8, shop.spareWagonAxel_Price / 3, shop.spareWagonTongues_Price / 3, shop.medicalSupplyBox_Price / 1.5, shop.sewingKit_Price / .50, shop.fireStartingKit_Price / .25, shop.kidsToys_Price / .05, 1, shop.seedPackeges_Price / .01, shop.shovels_Price / 2.5, shop.cookingItems_Price / 1.5);
                    wagonMade = false;
                }

                //Resets display in case no location is reached.
                display.setText("");
                shopDisplay.setText("");

                /* Location based classes that happen everytime a button is clicked.
                    Every button click adds 1 day and changes months if appropriate.
                    checks if the player has reached a river, town, or landmark.
                    Decreases distance of player form river, town, and landmarks.
                */
                location.locationFromPace(location.getPace(), health.getTotalOxen(), health.getSickPeople(), weather.getTotalSnow(), location.whatLandmark());
                location.incrementDay();
                location.setDistanceToLandmark(location.getDistanceToLandmark() - 20);
                location.setDistanceToRiver(location.getDistanceToRiver() - 20);
                location.setDistanceToTown(location.getDistanceToTown() - 20);

                location.atLandmark();

                // display the weather for the day to the user, using the getTemperature method
                weatherBox.setText(weather.displayTemperature(weather.getTemperature(location.getZone(), location.getMonth()))
                        + " " + weather.totalRainfall(location.getZone(), location.getMonth()));

                if(weather.getTotalSnow() >= 1){
                    background.setBackgroundColor(1243);
                }
                else if(weather.getTotalRain() <= 0.2){
                    background.setBackgroundColor(Color.rgb(255, 165, 0));
                }
                else{
                    background.setBackgroundColor(Color.rgb(0, 100, 100));
                }

                //Displays a message if the person is at a town. If true resets distance to next landmark.
                if (location.getAtTown()) {
                    display.setText("You are at town " + location.whatTown());
                    location.setDistanceToTown(200);
                    location.setAtTown(false);
                }
                if (location.getAtRiver()) {
                    display.setText("You are at a river");
                    location.setDistanceToRiver(100);
                    location.setAtRiver(false);
                }
                if (location.getAtLandmark()) {
                    display.setText("You are at " + location.whatLandmark());
                    location.setDistanceToLandmark(300);
                    location.setAtLandmark(false);
                }


                // restore 10 percent of the total health for resting over night
                health.startOfDayHealth();

                /*
                Use the random event method for someone getting sick.
                If it is true, randomly generate the person and the disease contracted.
                Update the variable that tracks the health of that person.
                Display to the user that someone has become ill.
                 */
                if(re.illness(health.getHealth())){
                    String disease = health.randomDisease();
                    String person = health.randomPerson();
                    health.sickPerson(person);
                    String sickMessage = person + " has contracted " + disease;
                    health.addHealth(20);
                }

                // add one for each party member that is sick
                health.addHealth(health.getSickPeople());

                // Reset the amount of accumulated precipitation.
                weather.resetRain();
                weather.resetSnow();

                /* Find whether or not a random event occurs each day.
                    If a random event takes place a prompt appears for the user to see what happened
                    If someone gets bit by a snake the overall health goes up by 10
                    If Indians help you find food the amount of food goes up 8 pounds
                    If you take the wrong trail you have to back track using vital supplies
                    Otherwise they message "It was a normal day" appears
                 */
                if (re.snakeBite()) {
                    health.addHealth(10);
                    reBox.setText("You got bit by a snake");
                    health.sickPerson(health.randomPerson());
                }
                else if (re.indiansHelpFindFood()) {
                    wagon.setFood(wagon.getFood() + 30);
                    reBox.setText("Indians helped you find food");
                }
                else if (re.wrongTrail()) {
                    reBox.setText("OH-NO you took the wrong trail");
                }
                else if (re.lostTrail()) {
                    reBox.setText("You lost the trail");
                }
                else if (re.wagonFire()) {
                    reBox.setText("THe wagon caught on fire!!");
                }
                else if (re.lostPerson()) {
                    reBox.setText("A member of your group is missing");
                }
                else if (re.lostOxen()) {
                    reBox.setText("An oxen has wandered off.");
                }
                else if (re.foundWagon()) {
                    reBox.setText("You found an abandoned wagon");
                }
                else if (re.robbedAtNight()) {
                    reBox.setText("You got robbed in the niddle of the night");
                }
                else {
                    reBox.setText("It was a normal day!");
                }

                // When the total accumulated rain is less than 0.1 inch drought occurs and its consequences are invoked.
                if (weather.getTotalRain() <= 0.1) {
                    // Check if there is bad water, very little water, or bad grass.
                    if (re.badWater()) {
                        // When there is bad water tell the user and add 20 to the groups overall health.
                        reBox.setText("The water is bad.");
                        health.addHealth(20);
                    } else if (re.littleWater()) {
                        // When there is very little water tell the user and add 10 to the overall health.
                        reBox.setText("There is very little water");
                        health.addHealth(10);
                    } else if (re.badGrass()) {
                        // When there is bad grass tell the user and ass 15 to the overall oxen health.
                        reBox.setText("The grass is inadequate.");
                        health.addOxenHealth(15);
                    }
                }

                // When the group is traveling between the months of May and September they can find wild fruit.
                if (location.getMonth() >= 5 && location.getMonth() <= 9) {
                    // When the group finds wild fruit tell the user and and add 20 pounds to the total food.
                    if (re.foundFruit()) {
                        reBox.setText("You found wild fruit");
                        wagon.setFood(wagon.getFood() + 20);
                    }
                }

                //Depending on how many pounds of food is remaining the ration qualification changes
                if (wagon.getFood() >= 1500) {
                    rations = "Filling";
                } else if (wagon.getFood() >= 1000) {
                    rations = "Meager";
                } else if (wagon.getFood() >= 500) {
                    rations = "Bare Bones";
                } else {
                    rations = "Out of food";
                }

                // Using the rations found above determine how the health is effected
                health.healthFromFood(rations);
                health.healthFromPace(location.getPace());
                health.healthFromWeather(weather.displayTemperature(weather.getRealTemp()), wagon.getClothing());

                wagon.setFood(wagon.getFood() - 20);

                // display to the user the overall health of the entire group
                healthBox.setText(health.generalHealth());
                foodBox.setText(Double.toString(wagon.getFood()));
                date.setText(location.whatMonth() + " " + location.getDay());
            }
        });

    }
}