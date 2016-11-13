package mohammadsharif.com.intersect;

import android.location.Location;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;


public class User implements Serializable{

    private String name;
    private ArrayList<Friend> friends;
    private String userID;
    private boolean facebookConnected;
    private boolean twitterConnected;
    private boolean linkedInConnected;
    private boolean instagramConnected;

    public User(String userID, String name, ArrayList<Friend> friends) {
        this.name = name;
        this.friends = friends;
        this.userID = userID;

        this.facebookConnected = false;
        this.instagramConnected = false;
        this.twitterConnected = false;
        this.linkedInConnected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }


    public boolean isFacebookConnected() {
        return facebookConnected;
    }

    public void setFacebookConnected(boolean facebookConnected) {
        this.facebookConnected = facebookConnected;
    }

    public boolean isTwitterConnected() {
        return twitterConnected;
    }

    public void setTwitterConnected(boolean twitterConnected) {
        this.twitterConnected = twitterConnected;
    }

    public boolean isLinkedInConnected() {
        return linkedInConnected;
    }

    public void setLinkedInConnected(boolean linkedInConnected) {
        this.linkedInConnected = linkedInConnected;
    }

    public boolean isInstagramConnected() {
        return instagramConnected;
    }

    public void setInstagramConnected(boolean instagramConnected) {
        this.instagramConnected = instagramConnected;
    }

    public void addFriend(User friend) {
        Friend toAdd = new Friend(friend.userID, friend.getName());
        friends.add(toAdd);
    }


}