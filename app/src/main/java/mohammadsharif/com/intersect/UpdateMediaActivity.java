package mohammadsharif.com.intersect;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class UpdateMediaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_media);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.push_button){
            // Handle authentications
            Intent intent = new Intent(UpdateMediaActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if(v.getId() == R.id.log_out_button){
            AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    finish();
                }
            });
        }
    }
}
