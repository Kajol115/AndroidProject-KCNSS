package com.example.dell.navigationdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class aboutus extends AppCompatActivity {

    TextView abt;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        img=(ImageView)findViewById(R.id.image1);
        abt=(TextView)findViewById(R.id.t1);

         String array[]={"The main aim of joining NSS is Personality Development through community services. So , definitely after going for it will result in building you a great personality. And you may need not to opt for personality development classes :p.\n" +
                "\n" +
                "The main aim of joining NSS is Personality Development through community services.\n" +
                "        So , definitely after going for it will result in building you a great personality. /n\n" +
                "        And you may need not to opt for personality development classes :p./n\n" +
                "        By joining NSS you will opt for a journey to discover yourself.\n" +
                "        You will learn about your strengths and weaknesses./n\n" +
                "        You will definitely learn amazing skills and qualities like leadership and team work among people with different streams./n\n" +
                "        You will get exposure for your works and talents. Even for small contributions and achievements./n\n" +
                "        You will explore different cultures, mentality and actual situations/problems in different parts of the state, in villages,\n" +
                "        in different parts of country and even different nations through NSS special camps, state camps, National camps and\n" +
                "        International Exchange programs./n\n" +
                "        The work you do will provide you with self satisfaction which is worth of spending time in it.\n" +
                "        Believe me or not it is the one of the best extra - curricular activity to be a part of./n\n" +
                "        By doing work in it you will be definitely contributing in building nation.\n" +
                "        You will learn a lot about participating, performing and organizing an event./n\n" +
                "        It helps in developing public speaking quality.\n" +
                "        It makes you a socially active and responsible person. You will learn to stand up different among the crowd./n\n" +
                "        It develops your problem solving skills, you will be able to solve real life and practical problems.\n" +
                "        It provides you with a lot of opportunities to learn new things./n\n" +
                "        Some other benefits of NSS are certificates, prizes, popularity, names and photos in news papers,\n" +
                "        allowances, refreshments, etc./n\n" +
                "        You will gain more of above listed things only if you are sincere and dedicated to do work genuinely.\n" +
                "        It will surely boosts up your knowledge overall./n\n" +
                "        List of activities NSS students do are:-/n\n" +
                "        Volunteering /n\n" +
                "        Tree plantations /n\n" +
                "        Blood donation /n\n" +
                "        Cleanliness drives /n\n" +
                "        Human Chain formations\n" +
                "        Adopting one of the villages nearby and contribute in its development. /n\n" +
                "        Spreading awareness in society for different issues like sanity, sewage, population, cleanliness, digitalization,\n" +
                "        diseases, environment, etc. /n\n" +
                "        Attending special village camps (for creating awareness in villages), state level camps (sports, yoga, art and craft camps),\n" +
                "        National level camps (youth festivals for sports and cultures, Integration camps, Adventure camps, etc.) and International\n" +
                "        Exchange Programmes (cultural exchange programmes). /n\n" +
                "        Teaching unprivileged students and motivating them in adopted village. /n\n" +
                "        Celebrating different days like World Environment Day, Woman 's Day, Aids day, etc. /n\n" +
                "        Traffic and Voter awareness programmes. /n\n" +
                "        Slogans making, poster making, essay writing, art and crafts creation competitions for different issues to create awareness. /n\n" +
                "        Teaching about digitalization, Cashless payments and other banking services in adopted village. /n\n" +
                "There are many other different activities done by NSS students as per their policies and dedication for social work. /n\n" +
                "Overall we could say that NSS works on different social issues of the community to reform a better society. /n\n" +
                "In my view if you are a civil services aspirant then NSS is a must thing for you. /n"};
        //Random random=new Random();
        //int num= random.nextInt(array.length);
        abt.setText(array[0]);

    }
}
