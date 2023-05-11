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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Creation of classes used.
    RandomEvents re = new RandomEvents();
    Health health = new Health();
    Location location = new Location(0, 1, 1, 340, 60, 700);
    Shop shop = new Shop();
    River river = new River();
    Story story = new Story();
    Weather weather = new Weather();
    Women women = new Women();
    Wagon wagon = new Wagon(shop.food_Price / .1, shop.clothing_Price / .2, shop.weapons_Price / 20, shop.oxen_Price / 50, shop.spareWagonWheel_Price / 8, shop.spareWagonAxel_Price / 3, shop.spareWagonTongues_Price / 3, shop.medicalSupplyBox_Price / 1.5, shop.sewingKit_Price / .50, shop.fireStartingKit_Price / .25, shop.kidsToys_Price / .05, 1, shop.seedPackages_Price / .01, shop.shovels_Price / 2.5, shop.cookingItems_Price / 1.5);

    // Media players created to play the different music incorporated
    MediaPlayer mp;
    MediaPlayer st;
    MediaPlayer rs;
    MediaPlayer tt;
    MediaPlayer fs;

    // Fields
    public boolean wagonMade = true;
    public boolean mtIsPlaying = false;
    public int resetDay = 0;
    String rations = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create all text boxes, buttons, and input boxes, to update the GUI accordingly throughout
        final TextView display = findViewById(R.id.Display);
        final Button nextDay = findViewById(R.id.button);
        final TextView date = findViewById(R.id.Date);
        final TextView foodBox = findViewById(R.id.foodRemaining);
        final TextView healthBox = findViewById(R.id.healthBox);
        final TextView reBox = findViewById((R.id.REbox));
        final Button confirm = findViewById(R.id.confirm);
        final EditText User_InputBox = findViewById(R.id.UserInput);
        final TextView shopDisplay = findViewById(R.id.shopDisplay);
        final ImageView picture = findViewById(R.id.imageView);
        final Button enterShop = findViewById(R.id.enterShop);
        final Button leaveShop = findViewById(R.id.leaveShop);
        final TextView weatherBox = findViewById(R.id.weatherBox);
        final TextView sickBox = findViewById(R.id.sickBox);
        final ImageView title = findViewById(R.id.fullImage);
        final Button play = findViewById(R.id.playGame);
        final Button credits = findViewById(R.id.credits);
        final TextView storyDisplay = findViewById(R.id.storyDisplay);
        final Button newGame = findViewById(R.id.newGame);
        final TextView womanBox = findViewById(R.id.womanBox);

        //This is to change background color in order to do so use .setBackgroundColor()
        final LinearLayout background = findViewById(R.id.linear);

        //Array of images, images made be added as needed
        final int a[] = {R.drawable.shoppingpic, R.drawable.traveling, R.drawable.hattiecampbell,
                R.drawable.river, R.drawable.title, R.drawable.credits, R.drawable.oregonstart,
                R.drawable.chimneyrock, R.drawable.forthall, R.drawable.fortboise, R.drawable.fortbridger,
                R.drawable.fortkearney, R.drawable.fortwallawalla, R.drawable.laramie, R.drawable.sodaspring,
                R.drawable.southpass, R.drawable.bluemountains, R.drawable.thedalles, R.drawable.oregoncity,
                R.drawable.map, R.drawable.womenchildren, R.drawable.womencooking, R.drawable.womensewing,
                R.drawable.indianshelping, R.drawable.snakebite, R.drawable.drought, R.drawable.wagonfire,
                R.drawable.oxen, R.drawable.robber};

        //Creates a media player for main theme
        mp = MediaPlayer.create(this, R.raw.maintune);
        st = MediaPlayer.create(this, R.raw.shoptune);
        rs = MediaPlayer.create(this, R.raw.rivertune);
        tt = MediaPlayer.create(this, R.raw.towntune);
        fs = MediaPlayer.create(this, R.raw.finaletune);

        //Put title image and button in front
        title.bringToFront();
        play.bringToFront();
        credits.bringToFront();

        //Make display visible until used.
        display.setVisibility(View.INVISIBLE);
        newGame.setVisibility(View.INVISIBLE);

        // Add all people to an array at the start of each game
        health.addPeople();

        //When clicked restarts the game
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }

        });

        //When clicked removes title screen and prompts user to enter shop
        play.setOnClickListener(new View.OnClickListener()  {

            public void onClick(View v)
            {
                //Sets various gui parts to invisible to reveal a new scene
                title.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                credits.setVisibility(View.INVISIBLE);
                leaveShop.setVisibility(View.INVISIBLE);
                storyDisplay.setVisibility(View.INVISIBLE);
                healthBox.setVisibility(View.INVISIBLE);
                reBox.setVisibility(View.INVISIBLE);
                User_InputBox.setVisibility(View.INVISIBLE);
                foodBox.setVisibility(View.INVISIBLE);
                weatherBox.setVisibility(View.INVISIBLE);
                sickBox.setVisibility(View.INVISIBLE);
                womanBox.setVisibility(View.INVISIBLE);

                //allows player to enter shop if at a town
                if(location.getAtTown())
                {
                    enterShop.setVisibility(View.VISIBLE);
                }
                //Hides next day button if not at a river, but reveals it if at river
                if(!location.getAtRiver() && !location.getAtLandmark())
                {
                    nextDay.setVisibility(View.INVISIBLE);
                }
                else
                {
                    nextDay.setVisibility(View.VISIBLE);
                }

                if(location.getAtLandmark())
                {
                    nextDay.setVisibility(View.VISIBLE);
                    nextDay.bringToFront();
                }

                //pause river and town music if at a river or at a town when button is clicked
                if(location.getAtRiver()){
                    rs.pause();
                }
                if(location.getAtTown()){
                    tt.pause();
                }

                // When at a river the river interaction screen comes up
                if(location.getAtRiver()) {
                    // Make input box visible
                    User_InputBox.setVisibility(View.VISIBLE);

                    // String for what user enters in the box
                    String input = User_InputBox.getText().toString();

                    // Depending on the users choice display different things
                    if (river.riverMenu) {
                        String secondCategory = river.secondRiverCategory(input);
                        display.setVisibility(View.VISIBLE);
                        shopDisplay.setVisibility(View.INVISIBLE);
                        display.setText(secondCategory);
                        display.bringToFront();

                        // The map appears when that is what the user chooses
                        if (river.secondRiverCategory(input).equalsIgnoreCase("Map")) {
                            picture.setImageResource(R.drawable.map);
                        }
                        // The user rests if they choose to do so
                        else if (river.dayRest(Integer.parseInt(input)) > 1) {
                            display.setText("Days rested");
                            location.setDay(location.getDay() + Integer.parseInt(input));
                            display.setVisibility(View.VISIBLE);
                            display.setText(secondCategory);
                            display.bringToFront();
                        }
                        else {
                            display.setText(river.riverCatagory(input) + river.output);
                        }
                    }
                }
                //Set the variable at___ to false until the player reaches another one
                location.setAtLandmark(false);
                location.setAtTown(false);
                location.setAtRiver(false);
            }
        });

        // Brings up the credits page when clicked
        credits.setOnClickListener(new View.OnClickListener()  {

            public void onClick(View v)
            {
                title.setImageResource(R.drawable.credits);
            }
        });

        //When clicked takes player to shop
        enterShop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Sets store layout along with making everything invisible until leaving the shop
                shopDisplay.setText(shop.storeLayout());
                shopDisplay.setVisibility(View.VISIBLE);
                confirm.setVisibility(View.VISIBLE);
                enterShop.setVisibility(View.INVISIBLE);
                reBox.setVisibility(View.INVISIBLE);
                date.setVisibility(View.INVISIBLE);
                healthBox.setVisibility(View.INVISIBLE);
                foodBox.setVisibility(View.INVISIBLE);
                weatherBox.setVisibility(View.INVISIBLE);
                sickBox.setVisibility(View.INVISIBLE);
                womanBox.setVisibility(View.INVISIBLE);
                leaveShop.setVisibility(View.VISIBLE);
                User_InputBox.setVisibility(View.VISIBLE);

                //Changes music
                st.start();

                //Changes image to that of the shopping area
                picture.setImageResource(R.drawable.shoppingpic);
            }
        });

        // When clicked the player leaves the shop and returns to the game
        leaveShop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Change gui accordingly for the users game
                shopDisplay.setVisibility(View.INVISIBLE);
                reBox.setVisibility(View.VISIBLE);
                date.setVisibility(View.VISIBLE);
                healthBox.setVisibility(View.VISIBLE);
                leaveShop.setVisibility(View.INVISIBLE);
                confirm.setVisibility(View.INVISIBLE);
                User_InputBox.setVisibility(View.INVISIBLE);
                nextDay.setVisibility(View.VISIBLE);
                foodBox.setVisibility(View.VISIBLE);
                weatherBox.setVisibility(View.VISIBLE);
                sickBox.setVisibility(View.VISIBLE);
                womanBox.setVisibility(View.VISIBLE);

                //Changes back to Hattie's pic
                picture.setImageResource(R.drawable.hattiecampbell);
            }
        });

        // A button that confirms the user input changing values in the shop
        confirm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Get the users input from the text box and convert to a string.
                String input = User_InputBox.getText().toString();

                // If the user decides to buy items then the item bought and the price owed for the item are updated.
                if(shop.buying)
                {
                    String boughtItem = shop.buyItem(input);
                    shopDisplay.setText(boughtItem);
                }
                else
                {
                    shop.calcBoughtItem(shop.otherinput, Integer.parseInt(input));
                    shopDisplay.setText(shop.storeLayout());
                }

            }

        });

        // Actions occur when the Next Day button is clicked.
        nextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Switches and removes all necessary aesthetics
                confirm.setVisibility(View.INVISIBLE);
                User_InputBox.setVisibility(View.INVISIBLE);
                leaveShop.setVisibility(View.INVISIBLE);
                foodBox.setVisibility(View.VISIBLE);
                foodBox.setVisibility(View.VISIBLE);
                healthBox.setVisibility(View.VISIBLE);
                reBox.setVisibility(View.VISIBLE);
                womanBox.setVisibility(View.VISIBLE);
                sickBox.setVisibility(View.VISIBLE);
                weatherBox.setVisibility(View.VISIBLE);

                //stops the store music
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
                    wagon = new Wagon(shop.food_Price / .1, shop.clothing_Price / .2, shop.weapons_Price / 20, shop.oxen_Price / 50, shop.spareWagonWheel_Price / 8, shop.spareWagonAxel_Price / 3, shop.spareWagonTongues_Price / 3, shop.medicalSupplyBox_Price / 1.5, shop.sewingKit_Price / .50, shop.fireStartingKit_Price / .25, shop.kidsToys_Price / .05, 1, shop.seedPackages_Price / .01, shop.shovels_Price / 2.5, shop.cookingItems_Price / 1.5);
                    wagonMade = false;
                }

                //Resets display in case no location is reached.
                display.setText("");
                shopDisplay.setText("");
                sickBox.setText("");

                // Reset the number of days that the group loses due to random events and keeps pace set to zero
                if(resetDay > 0){
                    location.setPace(0);
                    resetDay--;
                }
                // If no random event has effects the travel time set pace to 1
                else{
                    location.setPace(1);
                }

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

                //Displays town image if the person is at a town based upon which town. If true resets distance to next landmark.
                if (location.getAtTown()) {

                    switch(location.getTownsVisited()) {
                        case 1:
                            title.setImageResource(R.drawable.fortkearney);
                            location.setDistanceToTown(420);
                            break;
                        case 2:
                            title.setImageResource(R.drawable.laramie);
                            location.setDistanceToTown(380);
                            break;
                        case 3:
                            title.setImageResource(R.drawable.fortbridger);
                            location.setDistanceToTown(320);
                            break;
                        case 4:
                            title.setImageResource(R.drawable.forthall);
                            location.setDistanceToTown(340);
                            break;
                        case 5:
                            title.setImageResource(R.drawable.fortboise);
                            location.setDistanceToTown(360);
                            break;
                        case 6:
                            title.setImageResource(R.drawable.fortwallawalla);
                            location.setDistanceToTown(340);
                            break;
                        case 7:
                            //Brings up game won screen and music
                            title.setImageResource(R.drawable.oregoncity);
                            newGame.setVisibility(View.VISIBLE);
                            newGame.bringToFront();
                            location.setGameWon(true);
                            fs.start();
                            mp.pause();
                        default:
                            break;
                    }

                    //changes the gui to display picture of the town and its story
                    title.setVisibility(View.VISIBLE);
                    play.setVisibility(View.VISIBLE);

                    // Change button for the player to enter the town to shop and then return to play
                    play.setText("Enter Town");
                    nextDay.setVisibility(View.INVISIBLE);

                    //switches the music to the town song
                    tt.start();
                    mp.pause();

                    // Brings town picture and story to the front so the user can see/read it
                    title.bringToFront();
                    storyDisplay.setVisibility(View.VISIBLE);
                    storyDisplay.bringToFront();
                    storyDisplay.setText(story.storyTowns(location.whatTown()));

                    //if the game is won brings up special button
                    if(location.getGameWon())
                    {
                        newGame.setVisibility(View.VISIBLE);
                        newGame.bringToFront();
                    }
                }

                //If the player is at a river changes gui accordingly
                if (location.getAtRiver()) {
                    // Display the picture of the river to the user
                    title.setImageResource(R.drawable.river);

                    // make other gui changes
                    title.setVisibility(View.VISIBLE);
                    play.setVisibility(View.VISIBLE);
                    play.setText("Cross River");
                    nextDay.setVisibility(View.INVISIBLE);
                    User_InputBox.setVisibility(View.VISIBLE);
                    shopDisplay.setVisibility(View.VISIBLE);
                    shopDisplay.setText(river.riverLayout());

                    // Displays the choices to the user and the input box for their choice
                    User_InputBox.bringToFront();
                    shopDisplay.bringToFront();

                    // reset river menu to true
                    river.setRiverMenu();

                    //changes the song playing to the river tune
                    rs.start();
                    mp.pause();

                    //Resets the distance to the next river after reaching one depending on which river the player is at
                    switch(location.getRiversVisited())
                    {
                        case 1:
                            location.setDistanceToRiver(300);
                            break;
                        case 2:
                            location.setDistanceToRiver(500);
                            break;
                        case 3:
                            location.setDistanceToRiver(320);
                        case 4:
                            location.setDistanceToRiver(10000);
                    }
                }

                //if player is at a landmark changes gui accordingly
                if (location.getAtLandmark()) {

                    // make gui updates for aesthetic purposes
                    title.setVisibility(View.VISIBLE);
                    play.setVisibility(View.VISIBLE);
                    play.setText("Leave");
                    nextDay.setVisibility(View.INVISIBLE);

                    // determine which landmark the group is at, update the picture and the distance to the next one
                    switch(location.getLandmarksVisited())
                    {
                        case 1:
                            title.setImageResource(R.drawable.chimneyrock);
                            location.setDistanceToLandmark(260);
                            break;
                        case 2:
                            title.setImageResource(R.drawable.independencerock);
                            location.setDistanceToLandmark(100);
                            break;
                        case 3:
                            title.setImageResource(R.drawable.southpass);
                            location.setDistanceToLandmark(100);
                            break;
                        case 4:
                            title.setImageResource(R.drawable.sodaspring);
                            location.setDistanceToLandmark(500);
                            break;
                        case 5:
                            title.setImageResource(R.drawable.bluemountains);
                            location.setDistanceToLandmark(100);
                            break;
                        case 6:
                            title.setImageResource(R.drawable.thedalles);
                            location.setDistanceToLandmark(10000);
                            break;
                        default:
                            break;
                    }

                    // gui changes to display the story of the landmark
                    storyDisplay.setText(story.storyLandmarks(location.whatLandmark()));
                    storyDisplay.setVisibility(View.VISIBLE);
                    storyDisplay.bringToFront();

                    // change music to the town song
                    tt.start();
                    mp.pause();
                }


                // display the weather for the day to the user, using the getTemperature method
                weatherBox.setText(weather.displayTemperature(weather.getTemperature(location.getZone(), location.getMonth()))
                        + " " + weather.totalRainfall(location.getZone(), location.getMonth()));

                /* Change the background color depending on the weather
                   White if there is snow
                   Brown-green for now water in the cold months
                   Orange for drought
                   Blue for good weather
                 */
                if(weather.getTotalSnow() > 0){
                    background.setBackgroundColor(1243);
                }
                else if(weather.getTotalRain() <= 0.2 && weather.getRealTemp() > 45){
                    background.setBackgroundColor(Color.rgb(255, 165, 0));
                }
                else if(weather.getTotalRain() <= 0.2 && weather.getRealTemp() <= 45){
                    background.setBackgroundColor(Color.rgb(85, 90, 50));
                }
                else{
                    background.setBackgroundColor(Color.rgb(0, 100, 100));
                }

                // Restore 10 percent of the total health for resting over night
                health.startOfDayHealth();

                // A party member is only sick for ten days, each day the total numbers of days sick is decreased
                health.resetDaysSick();

                /*
                Use the random event method for someone getting sick.
                If it is true, randomly generate the person and the disease contracted.
                Update the variable that tracks the health of that person.
                Display to the user that someone has become ill.
                If the person dies display that to the user.
                Set the number of days the person is sick for to ten.
                 */
                if(re.illness(health.getHealth())){
                    String disease = health.randomDisease();
                    String person = health.randomPerson();
                    health.sickPerson(person);
                    String sickMessage = person + " has contracted " + disease;
                    health.addHealth(20);
                    sickBox.setText(sickMessage);
                    if(health.personHasDied(person)) {
                        sickBox.setText(health.personDeath(person));
                    }
                    health.setDaysSick(person);
                }

                // Set text in woman box to empty string
                womanBox.setText("");

                // Check if the women are able to help on each day
                if(re.womenTask()) {
                /*
                When there are more than two people that are sick the women play with the children.
                Playing with the children makes recovery quicker, and benefits teh overall health of the group
                 */
                    if (health.getSickPeople() > 2) {
                        if (wagon.getKidsToys() > 0) {
                            women.playWithKids();
                            health.addHealth(-5);
                            health.resetDaysSick();
                            womanBox.setText(women.getMessage());
                            picture.setImageResource(R.drawable.womenchildren);
                        }
                    }

                /*
                Once a week each month the women cook more food for their families to eat.
                When they cook an extra 20 pounds of food is added to the total amount of food.
                 */
                    else if (location.getDay() % 7 == 0) {
                        if (wagon.getCookingItems() > 0) {
                            women.cookFood();
                            womanBox.setText(women.getMessage());
                            picture.setImageResource(R.drawable.womencooking);
                        }
                    }

                /*
                When the amount of food remaining in the wagon gets below 300 pounds or if there are
                less than 3 cooking items the women go foraging for more. A random amount of food
                and cooking supplies gets added to the total amount.
                 */
                    else if (wagon.getFood() < 300 || wagon.getCookingItems() < 3) {
                        women.forageFood();
                        womanBox.setText(women.getMessage());
                    }

                /*
                When the party has run out of adequate clothing the women of the group will restore the clothing.
                The group loses a sewing kit but gains 2 items of clothing.
                 */
                    else if (wagon.getClothing() < 1) {
                        if (wagon.getSewingKit() > 1) {
                            women.restoreClothing();
                            womanBox.setText(women.getMessage());
                            picture.setImageResource(R.drawable.womensewing);
                        }
                    }
                }

                // add one for each party member that is sick
                health.addHealth(health.getSickPeople());

                // Reset the amount of accumulated precipitation.
                weather.resetRain();
                weather.resetSnow();

                /* Find whether or not a random event occurs each day.
                    If a random event takes place a prompt appears for the user to see what happened,
                    and the picture changes in some cases.
                    More variables are changed in some cases (food, health, and other stuff can increase or decrease)
                    Otherwise they message "It was a normal day" appears
                 */
                if (re.snakeBite()) {
                    // Snake bite effects the health overall and of a specific person
                    health.addHealth(10);
                    String person = health.randomPerson();
                    health.sickPerson(person);
                    reBox.setText(person + " got bit by a snake");
                    picture.setImageResource(R.drawable.snakebite);
                }
                else if (re.indiansHelpFindFood()) {
                    // The amount of food increases
                    wagon.setFood(wagon.getFood() + 30);
                    reBox.setText("Indians helped you find food");
                    picture.setImageResource(R.drawable.indianshelping);
                }
                else if (re.wrongTrail()) {
                    //Group is set back 3 days
                    reBox.setText("OH-NO you took the wrong trail");
                    resetDay += 3;
                }
                else if (re.lostTrail()) {
                    // Group is set back 5 days
                    reBox.setText("You lost the trail");
                    resetDay += 5;
                }
                else if (re.wagonFire()) {
                    // Certain items are lost
                    reBox.setText("The wagon caught on fire!!");
                    wagon.setFood(wagon.getFood() - 10);
                    wagon.setSewingKit(wagon.getSewingKit() - 2);
                    wagon.setClothing(wagon.getClothing() - 1);
                    wagon.setKidsToys(wagon.getKidsToys() - 2);
                    picture.setImageResource(R.drawable.wagonfire);
                }
                else if (re.lostPerson()) {
                    // Group is set back 4 days
                    String person = health.randomPerson();
                    reBox.setText(person + " is missing");
                    resetDay += 4;
                }
                else if (re.lostOxen()) {
                    // Group is set back 2 days
                    reBox.setText("An oxen has wandered off.");
                    resetDay += 2;
                    picture.setImageResource(R.drawable.oxen);
                }
                else if(re.injuredOxen(location.getZone())){
                    // Oxen health is effected
                    reBox.setText("An oxen got injured today.");
                    health.sickOx();
                }
                else if(re.injuredPerson(location.getZone())){
                    // Overall health and specific person health is increased
                    String person = health.randomPerson();
                    reBox.setText(person + " is injured");
                    health.setDaysSick(person);
                    health.addHealth(10);
                }
                else if (re.foundWagon()) {
                    // Items are gained
                    reBox.setText("You found an abandoned wagon");
                    wagon.setFood(wagon.getFood() + 10);
                    wagon.setCookingItems(wagon.getCookingItems() + 3);
                    wagon.setKidsToys(wagon.getKidsToys() + 2);
                    wagon.setClothing(wagon.getClothing() + 2);
                }
                else if (re.robbedAtNight()) {
                    // Items are lost
                    reBox.setText("You got robbed in the middle of the night");
                    wagon.setFood(wagon.getFood() - 10);
                    wagon.setSewingKit(wagon.getSewingKit() - 1);
                    wagon.setClothing(wagon.getClothing() - 3);
                    picture.setImageResource(R.drawable.robber);
                }
                // Display when nothing happens
                else {
                    reBox.setText("It was a normal day!");
                }

                // When the total accumulated rain is less than 0.1 inch drought occurs and its consequences are invoked.
                if (weather.getTotalRain() <= 0.1) {
                    // Check if there is bad water, very little water, or bad grass.
                    if (re.badWater() && weather.getRealTemp() > 45) {
                        // When there is bad water tell the user and add 20 to the groups overall health.
                        reBox.setText("The water is bad.");
                        health.addHealth(15);
                        picture.setImageResource(R.drawable.drought);
                    } else if (re.littleWater()) {
                        // When there is very little water tell the user and add 10 to the overall health.
                        reBox.setText("There is very little water");
                        health.addHealth(10);
                        picture.setImageResource(R.drawable.drought);
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

                // The freeze/Starve factor is added to the overall health
                health.starveFreezeFactor(wagon.getFood(), wagon.getClothing(), weather.getRealTemp());

                // Using the rations found above determine how the health is effected by food, pace, and weather
                health.healthFromFood(rations);
                health.healthFromPace(location.getPace());
                health.healthFromWeather(weather.displayTemperature(weather.getRealTemp()), wagon.getClothing());

                // display to the user the overall health of the entire group
                healthBox.setText(health.generalHealth());

                /*
                Takes away food every day or displays no food
                When there is less than twenty pounds of food the group runs out of food
                When there is more than twenty pounds of food then 20 pounds are subtracted form the total each day
                When there is no more food remaining nothing is subtracted.
                 */
                if (wagon.getFood() > 0) {
                    if(wagon.getFood() < 20){
                        wagon.setFood(0);
                        foodBox.setText("No Food");
                    }
                    else {
                        wagon.setFood(wagon.getFood() - 20);
                        foodBox.setText(Double.toString(wagon.getFood()));
                    }
                }
                else {
                    foodBox.setText("No Food");
                }

                // Updated the day for the user in the bottom corner
                date.setText(location.whatMonth() + " " + location.getDay());

                /*
                 The game is lost when all family members die.
                 When this happens display it to the user, stop the music, and make the restart
                 button appear so they can play again.
                 */
                if(health.gameLost()){
                    healthBox.setText("");
                    foodBox.setText("");
                    weatherBox.setText("");
                    sickBox.setText("");
                    reBox.setText("Everyone has died :(");
                    newGame.setVisibility(View.VISIBLE);
                    nextDay.setVisibility(View.INVISIBLE);
                    mp.pause();
                }
            }
        });

    }
}