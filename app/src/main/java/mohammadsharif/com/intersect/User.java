package mohammadsharif.com.intersect;

import android.location.Location;

import java.net.URL;

public class User {

    private String name;
    private URL facebookURL;
    private URL twitterURL;
    private URL linkedInURL;
    private URL instagramURL;
    private Location meetLocation;

    public User(String name, URL facebookURL, URL twitterURL, URL linkedInURL, URL instagramURL, Location meetLocation){
        this.name = name;
        this.facebookURL = facebookURL;
        this.instagramURL = instagramURL;
        this.twitterURL = twitterURL;
        this.linkedInURL = linkedInURL;
        this.meetLocation = meetLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(URL facebookURL) {
        this.facebookURL = facebookURL;
    }

    public URL getTwitterURL() {
        return twitterURL;
    }

    public void setTwitterURL(URL twitterURL) {
        this.twitterURL = twitterURL;
    }

    public URL getLinkedInURL() {
        return linkedInURL;
    }

    public void setLinkedInURL(URL linkedInURL) {
        this.linkedInURL = linkedInURL;
    }

    public URL getInstagramURL() {
        return instagramURL;
    }

    public void setInstagramURL(URL instagramURL) {
        this.instagramURL = instagramURL;
    }

    public Location getMeetLocation() {
        return meetLocation;
    }

    public void setMeetLocation(Location meetLocation) {
        this.meetLocation = meetLocation;
    }
}
