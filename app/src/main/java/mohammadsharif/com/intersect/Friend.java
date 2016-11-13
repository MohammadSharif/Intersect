package mohammadsharif.com.intersect;

import android.location.Location;

import java.sql.Time;

public class Friend extends User {

    ThirdFragment ref_3;
    private Location meetLocation;
    private String time;


    public Friend(String userID, String name){
        super(userID, name, null);

        //Adding to visible friend list
//        ref_3.addFriend(toBefriend);
    }



    public void setTime(String t){this.time = t;}

}
