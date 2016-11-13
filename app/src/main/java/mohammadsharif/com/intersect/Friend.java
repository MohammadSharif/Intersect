package mohammadsharif.com.intersect;

import android.location.Location;

import java.sql.Time;

public class Friend extends User {

    ThirdFragment ref_3;
    private Location meetLocation;
        private String time;


    public Friend(User toBefriend, Location meetLocation, String time){
        super(toBefriend.getUserID(), toBefriend.getName(), toBefriend.getFriends());
        this.meetLocation = meetLocation;
        this.time = time;
        //Adding to visible friend list
        ref_3.addFriend(toBefriend);
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


