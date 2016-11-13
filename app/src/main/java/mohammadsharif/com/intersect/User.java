package mohammadsharif.com.intersect;

import java.net.URL;
import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<Friend> friends;
    private String userID;
//    private URL facebookURL;
//    private URL twitterURL;
//    private URL linkedInURL;
//    private URL instagramURL;

    public User(String userID, String name, ArrayList<Friend> friends){
        this.name = name;
        this.friends = friends;
        this.userID = userID;
//        this.facebookURL = facebookURL;
//        this.instagramURL = instagramURL;
//        this.twitterURL = twitterURL;
//        this.linkedInURL = linkedInURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID(){
        return userID;
    }

    public ArrayList<Friend> getFriends(){
        return friends;
    }


//    public URL getFacebookURL() {
//        return facebookURL;
//    }
//
//    public void setFacebookURL(URL facebookURL) {
//        this.facebookURL = facebookURL;
//    }
//
//    public URL getTwitterURL() {
//        return twitterURL;
//    }
//
//    public void setTwitterURL(URL twitterURL) {
//        this.twitterURL = twitterURL;
//    }
//
//    public URL getLinkedInURL() {
//        return linkedInURL;
//    }
//
//    public void setLinkedInURL(URL linkedInURL) {
//        this.linkedInURL = linkedInURL;
//    }
//
//    public URL getInstagramURL() {
//        return instagramURL;
//    }
//
//    public void setInstagramURL(URL instagramURL) {
//        this.instagramURL = instagramURL;
//    }


}
