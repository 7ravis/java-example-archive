package com.design_patterns.observer;

import java.util.Observable;

public class Podcast extends Observable {
    private String podcastName;

    public Podcast(String podcastName) {
	this.podcastName = podcastName;
    }

    public void addEpisode(String episodeName) {
	setChanged();
	notifyObservers(episodeName);
    }

    public String getPodcastName() {
	return podcastName;
    }

}
