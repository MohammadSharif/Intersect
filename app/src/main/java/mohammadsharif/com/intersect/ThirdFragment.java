package mohammadsharif.com.intersect;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



public class ThirdFragment extends Fragment {

    private RecyclerView rv;
    private EditText search;
    private Button searchButton;
    private User thisGuy;
    public ArrayList<Friend> friends;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        search = new EditText(this.getActivity());
        searchButton = new Button(this.getActivity());

        //Please crosscheck attributes on this one
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = search.getText().toString();
                search(name); //Calling search method

            }
        });


        View v = inflater.inflate(R.layout.third_frag, container, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        getActivity().setTitle("Ads");

        rv = (RecyclerView) v.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        return v;
    }

    public static ThirdFragment newInstance() {
        ThirdFragment f = new ThirdFragment();
        return f;

    }

    public void addFriend(User toBeFriend) {
        System.out.println(toBeFriend.getName());
        //thisGuy.something .? Need a little help here
        //Display in recycler view
    }

    public void search(String name) {

        friends = thisGuy.getFriends();

        for (Friend Fname : friends) {

            if (Fname.getName().equals(name)) {

                //Display only this entry in recycler view

            }

        }

    }

}