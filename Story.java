/**
 * Name: Story
 * Date:/ 5/11/23
 * Author: Julia Kamatali
 * Description: This class displays the stories associated with each town the user visits
 */
public class Story {
    
    private String townStory  =  "No story for town";
    private String landmarkStory = "No story for landmark";

    // Introduction for the user at the begining of the game
    public final String welcomeStory = "Hi I’m Hattie, my family is about to embark on a very " +
            "dangerous and challenging adventure to oregon. My parents Charles and Augusta are " +
            "taking me and my siblings Ben and Jake across the country to start a new and better " +
            "life. It’s time for us to buy our supplies for our trip along the Oregon trail. " +
            "We have $1000 to spend. Click enter shop and help my family fill our wagon. \n";

    // Displayed after the user exist the the first shop in the town Independence
    public final String getStartedStory = " Thanks for your help shopping. Now it’s time for us to " +
            "start our journey. I’ve heard many stories about people traveling the trail and how " +
            "difficult the journey can be and they make me nervous. However, I believe my family " +
            "can do it and I will do anything I can to help us get to Oregon. My mother and I will " +
            "do most of the cooking and foraging while my dad and brothers rest for the next day. " +
            "We will also repair any clothing we can along our journey because the winters can be " +
            "harsh and we will need all the layers we can get. Remember anything can happen at any " +
            "point  along the Oregon trail. Click next day to begin. ";

    /**
     * Default constructor to create values for the different stories that are displayed to the user.
     */
    public Story(){}

    /**
     * storyTowns -> Depending on the town visited in the game the story according to it is returned as a string.
     * @param town -> A string representing the town that is being visited.
     * @return -> A string of the story for the specified town.
     */
    public String storyTowns(String town){

        if(town.equalsIgnoreCase("Fort Kearney")){

            this.townStory = "You made it to your first town, Fort Kearney. Fort Kearny was a " +
                    "historic outpost of the United States Army founded in 1848 in the western " +
                    "U.S. during the middle and late 19th century. The fort was named after Col. " +
                    "and later General Stephen Watts Kearny. The fort was built in response to the " +
                    "growth of overland emigration to Oregon after 1845. Despite its lack of " +
                    "fortifications, Fort Kearny served as way station, sentinel post, supply depot, " +
                    "and message center for 49'ers bound for California and homeseekers traveling " +
                    "to California, Oregon and the Pacific Northwest.\n";

        }
        else if (town.equalsIgnoreCase("Laramie")){

            this.townStory = "Welcome to Fort Laramie, originally known as Fort William in 1834," +
                    " it was " + "located where the North Platte River meets the Laramie River." +
                    " It was " + "started by fur traders and in 1849 the US Military purchased" +
                    " Fort William" + " and renamed it after a well known French fur trader" +
                    " Jacques La Ramie." + " During the time of the Oregon Trail this form" +
                    " was used to supply and " + "protect emigrant wagons. As time went on " +
                    "Fort Laramie became an important" + " part of the colonization of western" +
                    " America. The fort also served as a " + "link in the transcontinental " +
                    "telegraph network, a stop for the Pony " + "Express, and a base during " +
                    "the High Plains Indian Wars. As of 1937 Fort " + "Laramie is protected as" +
                    " a National Monument under the National Park " + "Service.\n";

        }
        else if (town.equalsIgnoreCase("Fort Bridger")){

            this.townStory = "Welcome to Fort Bridger. In 1842, mountain man John Bridger " +
                    "created this" + " trading post along the trail. Fort Bridger soon became" +
                    " one of the most " + "important stops for emigrants as an outfitting point." +
                    " As the fort grew so " + "did the population around it specifically " +
                    "for Mormons. As more Mormons " + "settled around Fort Bridger tensions" +
                    " with the federal government grew. " + "In 1857 President Buchanan sent" +
                    " troops out to the area to deal with the " + "rising tensions and" +
                    " the “Mormon War” broke out. The Mormon militia used " + "guerilla warfare" +
                    " tactics, setting fire to prairies and wagons. Fort " + "Bridger had to " +
                    "be rebuilt and later served as a post along the Pony " + "Express, before" +
                    " its final abandonment in 1890\n";

        }
        else if (town.equalsIgnoreCase("Fort Hall")){

            this.townStory = "You made it to Fort Hall! This fur trading post along the " +
                    "Snake River was " + "established in 1834. Before this fort was considered" +
                    " to be in US territory " + "along with the rest of Oregon Country a British " +
                    "flag flew over it for a " + "short period of time. In the early years of " +
                    "traveling along the trail " + "emigrants would leave their wagons at this" +
                    " post because traveling with " + "them became too dangerous. Around 1843" +
                    " travel increased along the trail " + "because pioneer Dr. Marcus Whitman" +
                    " led a train of wagons to the fort he " + "established in Walla Walla, " +
                    "Washington.\n";

        }
        else if (town.equalsIgnoreCase("Fort Boise")){

            this.townStory = "Welcome to Fort Boise. Established in 1834 this fort was in direct " +
                    "competition with Fort Hall, another nearby stop along the trail. While our " +
                    "current day location is near Boise, Idaho we were originally set along " +
                    "Snake River near the town of Parma. The original fort was abandoned due to " +
                    "several Indian attacks and severe flooding from the river back in 1854. " +
                    "However, for the twenty years we resided on Snake River we supplied many " +
                    "of the travelers making their way to Oregon.\n";

        }
        else if (town.equalsIgnoreCase("Fort Walla Walla")){

            this.townStory = " Welcome to Fort Walla Walla. The first iteration of Fort " +
                    "Walla Walla " + "was established in July 1856, by Lieutenant Colonel " +
                    "Edward Steptoe, 9th " + "Infantry Regiment. A second Fort Walla Walla" +
                    " was occupied September 23, " + "1856. The third and permanent military" +
                    " Fort Walla Walla was built in 1858" + " and adjoined Steptoeville, now " +
                    "Walla Walla, Washington, a community that" + " had grown up around the" +
                    " second fort. We are currently a military " + "reservation with over 600" +
                    " acres devoted to military purposes.\n";

        }
        else if (town.equalsIgnoreCase("Oregon City")){

            this.townStory = "Congratulations!! You made it to Oregon City, the first " +
                    "territorial " + "Capital " + "of Oregon. Established in 1842, we are located " +
                    "at the junction of" + " the " + "Willamette River and the Columbia River," +
                    " which we use as a source" + " of power " + "for our mills. Our economy" +
                    " grew at a rapid rate due to all " + "the travelers " + "ending their" +
                    " journeys and starting up their own farms." + " We have always been" +
                    " a great palace of friendship and community, " + "helping out others" +
                    " who have " + "arrived from their grueling adventure " + "across the " +
                    "country. Today we are a " + "small suburb of the much larger" + " city of " +
                    "Portland, Oregon, but our origin " + "story is truly one for " + "the books.\n";

        }
        else {this.townStory = "Error occurred for town story";}

        return this.townStory;
    }

    /**
     * storyLandmarks -> Depending on the landmark being visited the coordinating story is displayed.
     * @param landmark -> A string representing the landmark being visited.
     * @return -> A string that tell the story of the landmark.
     */
    public String storyLandmarks(String landmark){

        if(landmark.equalsIgnoreCase("Chimney Rock")){

            this.landmarkStory = "Here is one of the most picturesque landmarks along the Oregon " +
                    "Trail, Chimney Rock. This landmark which was visible from about 40 miles" +
                    " away was drawn by many surveyors and artists. Once travelers made it to " +
                    "Chimney Rock they knew their journey was about to get a lot tougher. The " +
                    "structure marks the end of the prairie terrain and the start of a more " +
                    "steep mountainous one. Many travelers wrote about their stop at Chimney" +
                    " Rock in their diaries, one describing it to look like a haystack with a " +
                    "pole stretching out of the top.\n";

        }
        else if(landmark.equalsIgnoreCase("Independence Rock")){

            this.landmarkStory = "You are about to embark on the journey to Oregon from the most " +
                    "popular starting destination, Independence, Missouri. This town located" +
                    " where the Missouri river flows into the Mississippi was established in " +
                    "1827. Independence was a great place for travelers to stock up on " +
                    "supplies and load their wagons before adventuring across the country. " +
                    "In its early days missionaries from the Church of Jesus Christ of Latter" +
                    " Day Saints wanted Independence to be the holy capital. However, conflict" +
                    " arose with these local Mormons because it was a political and economic" +
                    " establishment. By 1833 the missionaries were driven out of Independence" +
                    " and the Mormons used Nauvoo, Missouri as their starting point.\n";

        }
        else if(landmark.equalsIgnoreCase("South Pass")){

            this.landmarkStory = "You Have reached South Pass. This highly important landmark " +
                    "along the trail signified the west could be open to settlement. This " +
                    "gentle slope in the Rocky Mountains allowed travelers to pass through " +
                    "the area easily. Emigrants used this grass land because they could easily " +
                    "navigate their wagons through. This wide flat path was created by erosion " +
                    "from the amount of people and oxen walking over the path.\n";

        }
        else if(landmark.equalsIgnoreCase("Soda Springs")){

            this.landmarkStory = "Welcome to the Soda Springs. Formed from ancient volcanic " +
                    "activity, these bubbling, carbonated pools of water are naturally " +
                    "occurring. The springs were located along a shortcut off the main trail " +
                    "and served as an attraction for the travelers. For several years before " +
                    "travel along the trail had begun Indians, fur traders, and trappers would" +
                    " visit the springs too.Emigrants visiting Soda Springs rested, recovered," +
                    " bathed, and rehydrated. However, the water from the springs often made " +
                    "people and animals sick because it has too much alkali.\n";

        }
        else if(landmark.equalsIgnoreCase("Blue Mountaints")){

            this.landmarkStory = "You have reached the Blue Mountains. The final mountain range along" +
                    " the Oregon Trail. Considered the final hurdle for those traveling the" +
                    " Oregon trail. This is mainly due to the blue mountains containing many " +
                    "steep cliff faces and rocky slopes. This mountain range is one of the most " +
                    "geologically diverse parts of Oregon. This mountain range extends through " +
                    "Oregon and southeast Washington. Many predators live in these mountains " +
                    "including black bears, coyotes, raccoons, and cougars.\n";

        }
        else if(landmark.equalsIgnoreCase("The Dalles")){

            this.landmarkStory = " Welcome to The Dalles. This name is French meaning “gutter” and" +
                    " was given to the location by fur trappers in the area. Emigrants that " +
                    "chose this path had to float down the Columbia River on rafts crowded with" +
                    " their wagons and party members. This journey was often perilous due to the" +
                    " rocky nature of the river gorge. Another path to Oregon City was created " +
                    "in 1845, the Barlow Toll Road. This route was much safer than that of " +
                    "rafting through The Dalles, but it was a long route around Mount Hood.\n";

        }
        else {this.landmarkStory = "Error occurred for landmark story";}

        return this.landmarkStory;

    }
}
