package mohammadsharif.com.intersect;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.identity.*;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateMediaActivity extends AppCompatActivity implements View.OnClickListener {

    private TwitterLoginButton loginButton;
    private User user;

    TwitterAuthClient mTwitterAuthClient= new TwitterAuthClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_media);

        Intent intent = getIntent();
        user = (User)intent.getSerializableExtra("user");

        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // The TwitterSession is also available through:
                // Twitter.getInstance().core.getSessionManager().getActiveSession()
                TwitterSession session = result.data;

                Long app = session.getUserId();
                String app_str = app.toString();
                String url_twitter = "http://twitter.com/" + app_str;

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/" + uid);

                myRef.child("twitter").setValue(url_twitter);

                
                // TODO: Remove toast and use the TwitterSession's userID
                // with your app's user model
                String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.push_button){
            // Handle authentications
            Intent intent = new Intent(UpdateMediaActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if(v.getId() == R.id.facebook_button){
            Intent intent = new Intent(UpdateMediaActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if(v.getId() == R.id.twitter_button){
                    Intent intent = new Intent(UpdateMediaActivity.this, MainActivity.class);
                    startActivity(intent);
                    user.setTwitterConnected(true);
                    finish();
                } else if(v.getId() == R.id.linkedin_button){
                    Intent intent = new Intent(UpdateMediaActivity.this, MainActivity.class);
                    startActivity(intent);
                    user.setLinkedInConnected(true);
                    finish();
                } else if(v.getId() == R.id.instagram_button){
                    Intent intent = new Intent(UpdateMediaActivity.this, MainActivity.class);
                    startActivity(intent);
                    user.setInstagramConnected(true);
        finish();
    }
}


    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        mTwitterAuthClient.onActivityResult(requestCode, responseCode, intent);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // Make sure that the loginButton hears the result from any
//        // Activity that it triggered.
//        loginButton.onActivityResult(requestCode, resultCode, data);
//    }


}
