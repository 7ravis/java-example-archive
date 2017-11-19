package com.design_patterns.observer;

public class App {

    public static void main(String... strings) {
	Podcast podcast = new Podcast("Hidden Brain");
	Subscriber subscriber1 = new Subscriber("Subscriber1");
	Subscriber subscriber2 = new Subscriber("Subscriber2");

	subscriber1.subscribe(podcast);
	subscriber2.subscribe(podcast);

	podcast.addEpisode("The \"Swiss Army Knife\" Of Health: A Good Night's Sleep");
    }

}
