package com.design_patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {
    private String subscriberName;

    public Subscriber(String subscriberName) {
	this.subscriberName = subscriberName;
    }

    @Override
    public void update(Observable o, Object arg) {
	if (o instanceof Podcast) {
	    System.out.println(
		    subscriberName + ": new episode available from " + ((Podcast) o).getPodcastName() + ": " + arg);
	}
    }

    public void subscribe(Observable o) {
	o.addObserver(this);
    }

}
