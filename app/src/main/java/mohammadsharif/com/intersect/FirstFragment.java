package mohammadsharif.com.intersect;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        ImageButton facebook = new ImageButton(this.getContext());
        ImageButton twitter = new ImageButton(this.getContext());
        ImageButton linkedin = new ImageButton(this.getContext());
        ImageButton instagram = new ImageButton(this.getContext());

        LinearLayout ll = (LinearLayout)v.findViewById(R.id.buttonLayout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


//        facebook.setImageDrawable();

        ll.addView(facebook, lp);

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