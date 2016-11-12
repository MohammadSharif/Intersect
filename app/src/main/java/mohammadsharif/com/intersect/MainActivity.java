package mohammadsharif.com.intersect;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnTabSelectedListener;

public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final int RC_SIGN_IN = 0;
    private BottomBar bottomBar;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            if(resultCode == RESULT_OK){
                // User Logged In
                System.out.println("User Logged In");
            } else {
                // User not authenticated
                System.out.println("User must be authenticated first");

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "mohammadsharif.com.intersect",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        addFragments(savedInstanceState);


        if(mAuth.getCurrentUser() != null){
            // User Already Signed In
            System.out.println("User Logged In");

        } else {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setProviders(
                    AuthUI.FACEBOOK_PROVIDER
            ).build(), RC_SIGN_IN);

            System.out.println("User must be authenticated");

        }


    }

    public void addFragments(Bundle savedInstanceState) {
        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setFragmentItems(getSupportFragmentManager(), R.id.fragmentContainer,
                new BottomBarFragment(FirstFragment.newInstance(), R.drawable.ic_login_white_24dp, "User"),
                new BottomBarFragment(SecondFragment.newInstance(), R.drawable.ic_qrreader_on_white_24dp, "Profile Scanner"),
                new BottomBarFragment(ThirdFragment.newInstance(), R.drawable.ic_contact_list, "Contact List"));
        bottomBar.mapColorForTab(0, "#3B494C");
        bottomBar.mapColorForTab(1, "#00796B");
        bottomBar.mapColorForTab(2, "#7B1FA2");

        bottomBar.setOnItemSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                switch (position) {
                    case 0:
                        // Item 1 Selected
                }
            }
        });

        bottomBar.setActiveTabColor("#C2185B");

    }

}
