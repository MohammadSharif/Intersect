package mohammadsharif.com.intersect;

import android.location.Location;

public class Friend extends User {

    private Location meetLocation;

    public Friend(User toBefriend, Location meetLocation){
        super(toBefriend.getName(), toBefriend.getFacebookURL(), toBefriend.getTwitterURL(), toBefriend.getLinkedInURL(), toBefriend.getInstagramURL());
        this.meetLocation = meetLocation;
    }

    public Location getMeetLocation() {
        return meetLocation;
    }

    public void setMeetLocation(Location meetLocation) {
        this.meetLocation = meetLocation;
    }
}
