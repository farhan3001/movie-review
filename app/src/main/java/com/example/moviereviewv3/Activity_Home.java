package com.example.moviereviewv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class
Activity_Home extends AppCompatActivity {

    SQLiteHelper helper = new SQLiteHelper(this);
    Fragment fragment;
    BottomNavigationView bottomNavigationView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(MySharedPreferences.getWriteToDatabaseStatus(Activity_Home.this))
        {
            MySharedPreferences.setWriteToDatabaseStatus(Activity_Home.this, false);
            addActorsToDatabase();
            addMoviesToDatabase();
            addReviewsToDatabase();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new Fragment_Home()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home: {
                        if (item.isChecked()) {
                            //do nothing
                        } else {
                            fragment = new Fragment_Home();
                            item.setChecked(true);
                            FragmentManager fragmentManager= getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.home_fragment_container, fragment);
                            fragmentTransaction.addToBackStack(null).commit();
                        }
                        break;
                    }
                    case R.id.navigation_search: {
                        if (item.isChecked()) {
                            //do nothing
                        } else {
                            fragment = new Fragment_Search();
                            item.setChecked(true);
                            FragmentManager fragmentManager= getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.home_fragment_container, fragment);
                            fragmentTransaction.addToBackStack(null).commit();
                        }
                        break;
                    }

                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        return false;
    }

    public void addActorsToDatabase() {

        List<Model_Actor> actors = new ArrayList<>();

        actors.add(new Model_Actor(getDrawableId("actor_idris_elba"),
                42, "November 29,2021", "Idris Elba", "Actor", "Suicide Squad", "Idrissa Akuna Elba OBE is an English actor, producer and musician. He is known for roles including Stringer Bell in the HBO series The Wire, DCI John Luther in the BBC One series Luther, and Nelson Mandela in the biographical film Mandela: Long Walk to Freedom."));

        actors.add(new Model_Actor(getDrawableId("actor_anil_kapoor"),
                64, "December 24, 1956", "Anil Kapoor", "Actor", "Slumdog Millionaire", "Anil Kapoor is an Indian actor and film producer who has appeared in over a hundred Hindi-language films, as well as international films and television series. His career has spanned 40 years as an actor, and as a producer since 2005"));

        actors.add(new Model_Actor(getDrawableId("actor_ben_affleck"),
                49,"August 15, 1972","Ben Affleck","Actor","Goodwill Hunting","Benjamin Géza Affleck-Boldt is an American actor, film director, producer, and screenwriter. His accolades include two Academy Awards and three Golden Globe Awards. He began his career as a child when he starred in the PBS educational series The Voyage of the Mimi."));

        actors.add(new Model_Actor(getDrawableId("actor_bob_gunton"),
                75,"November 15, 1945","Bob Gunton","Actor","Shawshank Redemption","Robert Patrick Gunton Jr. is an American character actor of stage and screen. He is known for playing strict, authoritarian characters, including Warden Samuel Norton in the 1994 prison drama"));

        actors.add(new Model_Actor(getDrawableId("actor_bradley_cooper"),46,"January 5, 1975","Bradley Cooper","Actor","The Hangover 3","Bradley Charles Cooper is an American actor and filmmaker. He has been nominated for various awards, including eight Academy Awards and a Tony Award, and has won two Grammy Awards and a BAFTA Award."));

        actors.add(new Model_Actor(getDrawableId("actor_casey_affleck"),46,"August 12, 1975","Casey Affleck","Actor","Goodwill Hunting","Caleb Casey McGuire Affleck-Boldt is an American actor and director. He began his career as a child actor, appearing in the PBS television film Lemon Sky and the miniseries The Kennedys of Massachusetts."));

        actors.add(new Model_Actor(getDrawableId("actor_chris_evans"),40,"June 13, 1981","Chris Evans","Actor","Avengers: Endgame","Christopher Robert Evans is an American actor, best known for his role as Captain America in the Marvel Cinematic Universe series of films. Evans began his career with roles in television series, such as in Opposite Sex in 2000"));

        actors.add(new Model_Actor(getDrawableId("actor_chris_hemsworth"),38,"August 11, 1983","Chris Hemsworth","Actor","Avengers: Endgame","Christopher Hemsworth AM is an Australian actor. He first rose to prominence in Australia playing Kim Hyde in the Australian television series Home and Away before beginning a film career in Hollywood."));

        actors.add(new Model_Actor(getDrawableId("actor_cilian_murphy"),45,"May 25, 1976","Cilian Murphy","Actor","Inception","Cillian Murphy is an Irish actor. He started his performing career as the lead singer, pianist, and songwriter of a rock band named The Sons of Mr. Green Genes. Murphy turned down a record deal in the late 1990s and began acting on stage and in short and independent films. "));

        actors.add(new Model_Actor(getDrawableId("actor_dev_patel"),31,"April 23, 1990","Dev Patel","Actor","Slumdog Millionaire","Dev Patel is a British actor. He is the recipient of various accolades including a BAFTA Award, a Screen Actors Guild Award, a Critics' Choice Award, in addition to receiving nominations for an Academy Award, another BAFTA Award, two Golden Globe Awards and three SAG awards. "));

        actors.add(new Model_Actor(getDrawableId("actor_ed_helms"),47,"January 24, 1974","Ed Helms","Actor","The Hangover 3","Edward Parker Helms is an American actor, comedian, singer, and musician. He has played paper salesman Andy Bernard in the NBC sitcom The Office, a correspondent on Comedy Central's The Daily Show, and starred as Stuart Price in The Hangover trilogy."));

        actors.add(new Model_Actor(getDrawableId("actor_emma_stone"),32,"November 6, 1988","Emma Stone","Actor","La La Land","Emily Jean 'Emma' Stone is an American actress. She is the recipient of various accolades, including an Academy Award, a British Academy Film Award, a Screen Actors Guild Award, and a Golden Globe Award."));

        actors.add(new Model_Actor(getDrawableId("actor_frieda_pinto"),36,"October 18, 1984","Frieda Pinto","Actor","Slumdog Millionaire","Freida Selena Pinto is an Indian actress who has appeared mainly in American and British films. Born and raised in Mumbai, she resolved at a young age to become an actress. As a student at St. Xavier's College, Mumbai, she took part in amateur plays."));

        actors.add(new Model_Actor(getDrawableId("actor_irrfan_khan"),53,"January 7, 1967","Irrfan khan","Actor","Slumdog Millionaire","Irrfan Khan, also known simply as Irrfan, was an Indian actor who worked in Hindi cinema as well as British and American films."));

        actors.add(new Model_Actor(getDrawableId("actor_jennifer_lawrence"),31,"August 15, 1990","Jennifer Lawrence","Actor","Red Sparrow","Jennifer Shrader Lawrence is an American actress. Lawrence was the world's highest-paid actress in 2015 and 2016, with her films grossing over $6 billion worldwide to date. She appeared in Time's 100 most influential people in the world list in 2013 and in the Forbes Celebrity 100 list from 2013 to 2016."));

        actors.add(new Model_Actor(getDrawableId("actor_jeremy_irons"),72,"September 19, 1948","Jeremy Irons","Actor","","Jeremy John Irons is an English actor and activist. After receiving classical training at the Bristol Old Vic Theatre School, Irons began his acting career on stage in 1969 and has appeared in many West"));

        actors.add(new Model_Actor(getDrawableId("actor_jessica_rothe"),34,"May 28, 1987","Jessica Rothe","Actor","","Jessica Ann Rothenberg, better known as Jessica Rothe, is an American actress. She is known for her role in the MTV comedy series Mary + Jane and her lead role as Tree Gelbman in the comedy slasher film Happy Death Day and its 2019 sequel. She has also appeared in La La Land, Forever My Girl, and Valley Girl."));

        actors.add(new Model_Actor(getDrawableId("actor_jk_simmons"),66,"January 9, 1955","J. K. Simmons","Actor","","Jonathan Kimble Simmons is an American actor. In television, he is known for playing Dr. Emil Skoda on the NBC series Law & Order, Vernon Schillinger on the HBO series Oz, Assistant Police Chief Will Pope on TNT's The Closer, and the Amazon Prime series Invincible as Nolan “Omni-Man” Grayson."));

        actors.add(new Model_Actor(getDrawableId("actor_joel_edgerton"),47,"June 23, 1974","Joel Edgerton","Actor","","Joel Edgerton is an Australian actor and filmmaker. He has appeared in the films Star Wars: Episode II – Attack of the Clones, Star Wars: Episode III – Revenge of the Sith as a young Owen Lars, King "));

        actors.add(new Model_Actor(getDrawableId("actor_john_cena"),44,"April 23, 1977","John Cena","Actor","Suicide Squad 2","John Felix Anthony Cena is an American professional wrestler, actor, television presenter, and former rapper currently signed to WWE, where he performs on the SmackDown brand."));

        actors.add(new Model_Actor(getDrawableId("actor_josepth_gordon"),40,"February 17, 1981","Joseph Gordon","Actor","Inception","Joseph Leonard Gordon-Levitt is an American actor, filmmaker, singer, and entrepreneur. He has received various accolades, including nominations for the Golden Globe Award for Best Actor – Motion Picture Musical or Comedy for his leading performances in 500 Days of Summer and 50/50."));

        actors.add(new Model_Actor(getDrawableId("actor_ken_jeong"),52,"July 13, 1969","Ken Jeong","Actor","The Hangover 3","Kendrick Kang-Joh Jeong is an American stand-up comedian, actor, producer, writer, television personality and licensed physician. He has appeared in the films Knocked Up, Role Models, The Hangover film series, Furry Vengeance, Ride Along 2, Crazy Rich Asians, and Tom and Jerry."));

        actors.add(new Model_Actor(getDrawableId("actor_leonardo_decaprio"),46,"November 11, 1974","Leonardo DeCaprio","Actor","Inception","Leonardo Wilhelm DiCaprio is an American actor, film producer, and environmentalist. Known for playing unconventional roles in biopics and period films, DiCaprio has received numerous accolades throughout"));

        actors.add(new Model_Actor(getDrawableId("actor_margot_robbie"),31,"July 2,1990","Margot Robbie","Actor","Suicide Squad","Margot Elise Robbie is an Australian actress. She has received several accolades throughout her career, including nominations for two Academy Awards, three Golden Globe Awards, five British Academy Film Awards, and five Screen Actors Guild Awards."));

        actors.add(new Model_Actor(getDrawableId("actor_matt_damon"),50,"October 8, 1970","Matt Damon","Actor","Goodwill Hunting","Matthew Paige Damon is an American actor, producer, and screenwriter. Ranked among Forbes' most bankable stars, the films in which he has appeared have collectively earned over $3.88 billion at the North American box office, making him one of the highest-grossing actors of all time."));

        actors.add(new Model_Actor(getDrawableId("actor_matthaias"),43,"December 8, 1977","Matthias Schoenaerts","Actor","","Matthias Schoenaerts is a Belgian actor, film producer, and graffiti artist. He made his film debut at the age of 13 in Daens, which was nominated for the Academy Award for Best Foreign Language Film."));

        actors.add(new Model_Actor(getDrawableId("actor_mila_kunis"),38,"August 14, 1983","Mila Kunis","Actor","Black Swan","Milena Markovna Kunis is an American actress and producer. In 1991, at the age of 7, she and her Jewish family fled from Soviet Ukraine to the United States. At age 14, Kunis began playing Jackie Burkhart on the Fox television series That '70s Show."));

        actors.add(new Model_Actor(getDrawableId("actor_morgan_freeman"),84,"June 1, 1937","Morgan Freeman","Actor","Shawshank Redemption","Morgan Freeman is an American actor, director, and narrator. He has appeared in a range of film genres portraying character roles and is particularly known for his distinctive deep voice. Freeman is the recipient of various accolades, including an Academy Award, a Golden Globe Award, and a Screen Actors Guild Award."));

        actors.add(new Model_Actor(getDrawableId("actor_natalie_portman"),40,"June 9, 1981","Natalie Portman","Actor","Black Swan","Natalie Portman is an Israeli-born American actress. With an extensive career in film since her teenage years, she has starred in various blockbusters and independent films, for which she has received multiple accolades, including an Academy Award and two Golden Globe Awards"));

        actors.add(new Model_Actor(getDrawableId("actor_robert_downey_jr"),56,"April 4, 1965","Robert Downy Jr.","Actor","Avengers: Endgame","Robert John Downey Jr. is an American actor. His career has been characterized by critical and popular success in his youth, followed by a period of substance abuse and legal troubles, before a resurgence of commercial success in middle age."));

        actors.add(new Model_Actor(getDrawableId("actor_ron_williams"),75,"July 21, 1951","Ron Williams","Actor","","Robin McLaurin Williams was an American actor and comedian. Known for his improvisational skills and the wide variety of characters he created on the spur of the moment and portrayed on film, in dramas and comedies alike, he is regarded as one of the best comedians of all time."));

        actors.add(new Model_Actor(getDrawableId("actor_ryan_gosling"),40,"November 12, 1980","Ryan Gosling","Actor","La La Land","Ryan Thomas Gosling is a Canadian actor. He began his career as a child star on the Disney Channel's The Mickey Mouse Club, and went on to appear in other family entertainment programs, including Are You Afraid of the Dark? and Goosebumps."));

        actors.add(new Model_Actor(getDrawableId("actor_sebastian_stan"),39,"August 13, 1982","Sebastian Stan","Actor","Avengers: Endgame","Sebastian Stan is a Romanian-American actor. Stan gained wide recognition for his role as Bucky Barnes / Winter Soldier in the Marvel Cinematic Universe, beginning with 2011's Captain America: The First Avenger."));

        actors.add(new Model_Actor(getDrawableId("actor_sylvester_stallone"),75,"July 6, 1946","Sylvester Stallone","Actor","Suicide Squad","Sylvester Enzio Stallone is an American actor, screenwriter, director, and producer. After his beginnings as a struggling actor for a number of years upon arriving to New York City in 1969"));

        actors.add(new Model_Actor(getDrawableId("actor_tim_robbins"),62,"October 16, 1958","Tim Robbins","Actor","Shawshank Redemption","Timothy Francis Robbins is an American actor, screenwriter, director, producer, and musician. He is known for portraying Andy Dufresne in the film The Shawshank Redemption, and has won an Academy Award and three Golden Globe Awards for his roles in the films The Player, Short Cuts and Mystic River."));

        actors.add(new Model_Actor(getDrawableId("actor_tom_hardy"),43,"September 15, 1977","Tom Hardy","Actor","Inception","Edward Thomas Hardy CBE is an English actor, producer and former model. After studying acting at the Drama Centre London, he made his film debut in Ridley Scott's Black Hawk Down."));

        actors.add(new Model_Actor(getDrawableId("actor_tom_holland"),25,"June 1, 1996","Tom Holland","Actor","Avengers: Endgame","Thomas Stanley Holland is an English actor. A graduate of the BRIT School for Performing Arts and Technology in London, he began his acting career on London stage in the title role of Billy Elliot the Musical in the West End theatre from 2008 to 2010."));

        actors.add(new Model_Actor(getDrawableId("actor_vinona_ryder"),49,"October 29, 1971","Vinona Ryder","Actor","Black Swan","Winona Laura Horowitz, known professionally as Winona Ryder, is an American actress. She is the recipient of several awards, including a Golden Globe Award, and has been nominated for two Academy Awards."));

        actors.add(new Model_Actor(getDrawableId("actor_william_sadler"),71,"April 13, 1950","William Sadler","Actor","","William Thomas Sadler is an American stage, film and television actor. His television and motion picture roles have included Chesty Puller in The Pacific, Luther Sloan in Star Trek: Deep Space Nine"));

        actors.add(new Model_Actor(getDrawableId("actor_zack_gali"),51,"October 1, 1969","Zack Galifanakis","Actor","The Hangover 3","Zachary Knight Galifianakis is an American actor, comedian, musician and writer who came to prominence with his Comedy Central Presents special in 2001 and presented his own show called Late World with Zach on VH1 the following year."));

        actors.add(new Model_Actor(getDrawableId("actor_billy_zane"),55,"February 24, 1966","Billy Zane","Actor","Titanic","William George Zane Jr. is an American actor, producer, and artist. His breakthrough role was in the 1989 Australian film Dead Calm, which earned him a nomination for the Chicago Film Critics Association Award for Most Promising Actor."));

        actors.add(new Model_Actor(getDrawableId("actor_kate_winslet"),45,"October 5, 1975","Kate Winslet","Actor","Titanic","Kate Elizabeth Winslet CBE is a British actress. Often regarded by film critics as one of the \"preeminent actresses of her generation\", she is known for her work in independent films, particularly period dramas, and usually portrays headstrong, complicated women."));

        actors.add(new Model_Actor(getDrawableId("actor_kathy_bates"),73,"June 28, 1948","Kathy Bates","Actor","Titanic","Kathleen Doyle Bates is an American actress and director. She has been the recipient of numerous accolades, including an Academy Award, two Primetime Emmy Awards, and two Golden Globe Awards."));

        actors.add(new Model_Actor(getDrawableId("actor_jude_law"),49,"December 29, 1972","Jude Law","Actor","Sherlock Holmes","David Jude Heyworth Law is an English actor. He has received multiple awards including a BAFTA Film Award as well as nominations for two Academy Awards and two Tony Awards. In 2007, he received an Honorary César and was named a knight of the Order of Arts and Letters by the French government."));

        actors.add(new Model_Actor(getDrawableId("actor_mar_strong"),58,"August 5, 1963","Mark Strong","Actor","Sherlock Holmes","Mark Strong is an English actor. He is best known for his film roles such as Prince Septimus in Stardust, Archibald in RocknRolla, Lord Henry Blackwood in Sherlock Holmes, Frank D'Amico in Kick-Ass, ..."));

        actors.add(new Model_Actor(getDrawableId("actor_rachel_mcadams"),43,"November 17, 1978","Rchel McAdams","Actor","Sherlock Holmes","Rachel Anne McAdams is a Canadian actress. After graduating from a theatre degree program at York University in 2001, she worked in Canadian television and film productions, such as the drama film"));

        actors.add(new Model_Actor(getDrawableId("actor_christian_bale"),47,"June 30, 1974","Christian Bale","Actor","The Dark Knight","Christian Charles Philip Bale is an English actor. Known for his versatility and recurring physical transformations to play his roles, he has been a leading man in films of several genres. Bale is the recipient of various accolades, including an Academy Award and two Golden Globe Awards."));

        actors.add(new Model_Actor(getDrawableId("actor_garry_oldman"),64,"March 21, 1958","Garry Oldman","Actor","The Dark","Gary Leonard Oldman is an English actor and filmmaker. Regarded as one of the greatest actors of his generation, he is known for his versatility and intense acting style. He has received several accolades, including an Academy Award, a Golden Globe Award and three British Academy Film Awards."));

        actors.add(new Model_Actor(getDrawableId("actor_heath_ledger"),43,"April 4, 1979","Heath Ledger","Actor","The Dark Knight","Heath Andrew Ledger was an Australian actor and music video director. After playing roles in several Australian television and film productions during the 1990s, Ledger moved to the United States in 1998 to further develop his film career."));

        actors.add(new Model_Actor(getDrawableId("actor_micheal_caine"),89,"March 14, 1933","Micheal Caine","Actor","The Dark knight","Sir Michael Caine CBE is an English actor. Known for his distinctive South London accent, he has appeared in more than 130 films during a career spanning over 60 years, and is considered a British film icon. As of February 2017, the films in which he has appeared have grossed over $7.8 billion worldwide."));

        actors.add(new Model_Actor(getDrawableId("actor_al_pacino"),82,"April 25, 1940","Al Pacino","Actor","The Godfather","Alfredo James Pacino is an American actor and filmmaker. Considered one of the most influential actors of the 20th century, he has received numerous accolades: including an Academy Award, two Tony Awards, and two Primetime Emmy Awards, making him one of the few performers to have achieved the Triple Crown of Acting."));

        actors.add(new Model_Actor(getDrawableId("actor_marlon_brando"),98,"April 3, 1924","Marlon Brando","Actor","The Godfather","Marlon Brando Jr. was an American actor and film director with a career spanning 60 years, during which he won many accolades, including two Academy Awards for Best Actor, three BAFTA Awards for Best Foreign Actor and two Golden Globe Awards for Best Actor — Motion Picture Drama."));

        actors.add(new Model_Actor(getDrawableId("actor_john_cazele"),46,"August 12, 1935","John Cazele","Actor","The Godfather","John Holland Cazale was an American actor. He appeared in five films over seven years, all of which were nominated for the Academy Award for Best Picture: The Godfather, The Conversation, The Godfather Part II, Dog Day Afternoon, and The Deer Hunter, with the two Godfather films and The Deer Hunter winning."));

        for (Model_Actor actor :
                actors) {
            helper.addActor(actor);
        }

    }

    public void addReviewsToDatabase()
    {
        List<Model_Review> reviews = new ArrayList<>();
        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Black Swan"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Black Swan"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Avengers: Endgame"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Avengers: Endgame"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Titanic"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Titanic"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Inception"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Inception"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","The Hangover 3"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","The Hangover 3"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","La la Land"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","La la Land"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","The Godfather"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","The Godfather"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Goodwill Hunting"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Goodwill Hunting"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Red Sparrow"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Red Sparrow"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Suicide Squad"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Suicide Squad"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Shawshank Redemption"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Shawshank Redemption"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Slumdog Millionaire"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Slumdog Millionaire"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","The Two Popes"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","The Two Popes"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","The Drk Knight"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","The Dark Knight"));

        reviews.add(new Model_Review(7.5f,"Really Good movier","Amazing cast and a beautifully written story. Enjoyed every bit.","John Oswald","Black Swan"));
        reviews.add(new Model_Review(9.0f,"Excellent Time Killer","A pleasure to watch on any given sunday.","Oscar Wild","Black Swan"));


        for (Model_Review review : reviews) {
            helper.addReview(review);
        }
    }


    public void addMoviesToDatabase(){
        Model_Movie movie1 = new Model_Movie(getDrawableId("poster_black_swan"),"Black Swan","2010","1h 48m","Drama,Sci-Fi,Crime",
                "Nina, a ballerina, gets the chance to play the White Swan, Princess Odette. But she finds herself slipping into madness when Thomas, the artistic director, decides that Lily might fit the role better.",
                "Natalie Portman","Darren Aronofsky","Andres Heinz",8.5f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Black Swan"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_black_swan);

        Model_Movie movie2 = new Model_Movie(getDrawableId("poster_end_game"),"Avengers: Endgame","2019","3h 20m","Sci-Fi,Action,Thriller",
                "After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.",
                "Robert Downy jr.","Kevin Fiege","Marvel",8.4f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Avengers: Endgame"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_endgame);

        Model_Movie movie3 = new Model_Movie(getDrawableId("poster_goodwill_hunting"),"Goodwill Hunting","1997","2h 7m","Drama,Romance",
                "Will Hunting, a genius in mathematics, solves all the difficult mathematical problems. When he faces an emotional crisis, he takes help from psychiatrist Dr Sean Maguireto, who helps him recover.",
                "Matt Damon","Gus Van Sant","Ben Affleck",8.3f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Goodwill Hunting"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_goodwill_hunting);

        Model_Movie movie4 = new Model_Movie(getDrawableId("poster_hangover"),"The Hangover 3","2013","1h 40m","Comedy",
                "The Wolfpack decides to help Alan after he faces a major crisis in his life. However, when one of them is kidnapped by a gangster in exchange for Chow, a prisoner on the run, they must find him.",
                "Bradley Cooper","Todd Phillips","Craig Mazin",8.4f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","The Hangover 3"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_hangover);

        Model_Movie movie6 = new Model_Movie(getDrawableId("poster_lala_land"),"La la Land","2016","2h 8m","Musical,Romance",
                "Sebastian (Ryan Gosling) and Mia (Emma Stone) are drawn together by their common desire to do what they love. But as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart."
                ,"Ryan Gosling","Damien Chazelle","Damien Chazelle",8.0f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","La la Land"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_lalaland);

        Model_Movie movie5 = new Model_Movie(getDrawableId("poster_inception"),"Inception","2010","2h 40m","Sci-Fi,Thriller",
                "Cobb steals information from his targets by entering their dreams. Saito offers to wipe clean Cobb's criminal history as payment for performing an inception on his sick competitor's son.",
                "Leonardo DeCaprio","Christopher Nolan","Christopher Nolan",8.8f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Inception"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_inception);

        Model_Movie movie7 = new Model_Movie(getDrawableId("poster_red_sparrow"),"Red Sparrow","2018","2h 21m","Thriller,Action",
                "Dominika Egorova, a former ballerina, enrols in a Russian Intelligence programme and becomes a sparrow, using her body as a weapon to entrap a CIA agent.",
                "Jennifer Lawrence","Francis Lawrence","Francis Lawrence",6.6f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Red Sparrow"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_red_sparrow);

        Model_Movie movie8 = new Model_Movie(getDrawableId("poster_shawshank_redemption"),"Shawshank Redemption","1994","2h 23m","Crime,Thriller,Drama",
                "Andy Dufresne, a successful banker, is arrested for the murders of his wife and her lover, and is sentenced to life imprisonment at the Shawshank prison. He becomes the most unconventional prisoner",
                "Morgan Freeman","Frank Darabont","Riki Marvin",9.3f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Shawshank Redemption"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_shahshank);

        Model_Movie movie9 = new Model_Movie(getDrawableId("poster_slumdog"),"Slumdog Millionaire","2008","2h 3m","Romance,Drama",
                "A teenager from the slums of Mumbai becomes a contestant on the show 'Kaun Banega Crorepati?' When interrogated under suspicion of cheating, he revisits his past, revealing how he had all the answers.",
                "Anil Kapoor","Danny Boyle","Simon Beaufoy",8.0f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Slumdog Millionaire"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_slumdog);

        Model_Movie movie10= new Model_Movie(getDrawableId("poster_suicide_squad"),"Suicide Squad","2021","2h 13m","Action,Sci-Fi,Comedy",
                "The government sends the most dangerous supervillains in the world -- Bloodsport, Peacemaker, King Shark, Harley Quinn and others -- to the remote, enemy-infused island of Corto Maltese. Armed with high-tech weapons, they trek through the dangerous jungle on a search-and-destroy mission, with only Col. Rick Flag on the ground to make them behave.",
                "Idris Elba","James Gunn","James Gunn",7.4f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Suicide Squad"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_suicide_squad);

        Model_Movie movie11= new Model_Movie(getDrawableId("poster_the_dark_knight"),"The Dark Knight","2008","2h 32m","Action,Thriller",
                "After Gordon, Dent and Batman begin an assault on Gotham's organised crime, the mobs hire the Joker, a psychopathic criminal mastermind who offers to kill Batman and bring the city to its knees.",
                "Christian Bale","Christopher Nolan","Christopher Nolan",9.0f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","The Dark Knight"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_the_dark_knight);

        Model_Movie movie12= new Model_Movie(getDrawableId("poster_titanic"),"Titanic","1997","3h 14m","Romance,Drama",
                "Seventeen-year-old Rose hails from an aristocratic family and is set to be married. When she boards the Titanic, she meets Jack Dawson, an artist, and falls in love with him.",
                "Leonardo DeCaprio","James Cameron","Russel Carpenter",7.8f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Titanic"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_titanic);

        Model_Movie movie13= new Model_Movie(getDrawableId("poster_the_godfather"),"The Godfather","1972","2h 55m","Drama,Thriller",
                "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.",
                "Al Pacino","Francis Ford Coppola","Mario Puzo",9.2f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","The Godfather"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_the_godfather);

        Model_Movie movie14= new Model_Movie(getDrawableId("poster_sherlock_holmes"),"Sherlock Holmes","2009","2h 8m","Mystery",
                "Detective Sherlock Holmes and his partner, Dr Watson, send Blackwood, a serial killer, to the gallows. However, they are shocked to learn that he is back from the dead and must pursue him again.",
                "Robert Downy Jr.","Guy ritchie","Arthur Conan Doyle",7.6f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","Sherlock Holmes"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_sherlock_holmes);

        Model_Movie movie15= new Model_Movie(getDrawableId("poster_the_two_popes"),"The Two popes","2019","2h 5m","Drama,Comedy",
                "Behind the Vatican walls, Pope Benedict and the future Pope Francis must find common ground to forge a new path for the Catholic Church.",
                "Jonathen Pryce","Fernando Meriellieze","Anthony McCarten",7.6f,new Model_Review(8,"Good Job","Really Good Movie","Oscar Wild","The Two Popes"),"android.resource://"+getPackageName()+"/"+R.raw.trailer_the_two_popes);


        helper.addMovie(movie1);
        helper.addMovie(movie2);
        helper.addMovie(movie3);
        helper.addMovie(movie4);
        helper.addMovie(movie5);
        helper.addMovie(movie6);
        helper.addMovie(movie7);
        helper.addMovie(movie8);
        helper.addMovie(movie9);
        helper.addMovie(movie10);
        helper.addMovie(movie11);
        helper.addMovie(movie12);
        helper.addMovie(movie13);
        helper.addMovie(movie14);
        helper.addMovie(movie15);
    }

    public int getDrawableId(String name)
    {
        return getApplicationContext().getResources().getIdentifier(name, "drawable", getApplicationContext().getPackageName());
    }
}