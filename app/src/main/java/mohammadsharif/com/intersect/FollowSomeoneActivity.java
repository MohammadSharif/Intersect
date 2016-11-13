package mohammadsharif.com.intersect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;



    public class FollowSomeoneActivity extends AppCompatActivity implements View.OnClickListener {

        private TwitterLoginButton loginButton;
        private User user;

        TwitterAuthClient mTwitterAuthClient= new TwitterAuthClient();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.follow_someone);

            Intent intent = getIntent();
            user = (User)intent.getSerializableExtra("user");

            loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
            loginButton.setCallback(new Callback<TwitterSession>() {
                @Override
                public void success(Result<TwitterSession> result) {
                    // The TwitterSession is also available through:
                    // Twitter.getInstance().core.getSessionManager().getActiveSession()
                    TwitterSession session = result.data;
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
                Intent intent = new Intent(FollowSomeoneActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else if(v.getId() == R.id.facebook_button){
                Intent intent = new Intent(FollowSomeoneActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else if(v.getId() == R.id.twitter_button){
                Intent intent = new Intent(FollowSomeoneActivity.this, MainActivity.class);
                startActivity(intent);
                user.setTwitterConnected(true);
                finish();
            } else if(v.getId() == R.id.linkedin_button){
                Intent intent = new Intent(FollowSomeoneActivity.this, MainActivity.class);
                startActivity(intent);
                user.setLinkedInConnected(true);
                finish();
            } else if(v.getId() == R.id.instagram_button){
                Intent intent = new Intent(FollowSomeoneActivity.this, MainActivity.class);
                startActivity(intent);
                user.setInstagramConnected(true);
                finish();
            }
        }


        @Override
        protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
            mTwitterAuthClient.onActivityResult(requestCode, responseCode, intent);
        }
}
