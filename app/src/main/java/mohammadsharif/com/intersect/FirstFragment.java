package mohammadsharif.com.intersect;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.Space;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);
        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
        tv.setText("PLACE HOLDER");

        ImageButton facebook = new ImageButton(this.getActivity());
        ImageButton twitter = new ImageButton(this.getActivity());
        ImageButton linkedin = new ImageButton(this.getActivity());
        ImageButton instagram = new ImageButton(this.getActivity());

        LinearLayout ll = (LinearLayout)v.findViewById(R.id.buttonLayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(30, 0, 30, 0);

        facebook.setBackgroundResource(R.drawable.faceb);

        instagram.setBackgroundResource(R.drawable.ig);
        twitter.setBackgroundResource(R.drawable.twitt);
        linkedin.setBackgroundResource(R.drawable.linkedin);




        ImageButton[] buttons = new ImageButton[]{
                facebook,
                instagram,
                twitter,
                linkedin
        };

        for(ImageButton button: buttons){
            button.setLayoutParams(lp);
            ll.addView(button);
        }


        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getActivity().setTitle("Profile");

        return v;
    }

    public static FirstFragment newInstance() {
        FirstFragment f = new FirstFragment();

        Bundle b = new Bundle();
        f.setArguments(b);

        return f;
    }
}