package mohammadsharif.com.intersect;

import android.location.Location;

import java.sql.Time;

public class Friend extends User {

    private Location meetLocation;
        private String time;
    public Friend(User toBefriend, Location meetLocation, String time){
        super(toBefriend.getName(), toBefriend.getFacebookURL(), toBefriend.getTwitterURL(), toBefriend.getLinkedInURL(), toBefriend.getInstagramURL());
        this.meetLocation = meetLocation;
        this.time = time;
    }

    public Location getMeetLocation() {
        return meetLocation;
    }

    public void setMeetLocation(Location meetLocation) {
        this.meetLocation = meetLocation;
    }

    public String getTimeMet(){return time;}

    public void setTime(String t){this.time = t;}

}


