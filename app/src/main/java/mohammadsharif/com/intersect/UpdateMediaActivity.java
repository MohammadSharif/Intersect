package mohammadsharif.com.intersect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        }
    }
}
