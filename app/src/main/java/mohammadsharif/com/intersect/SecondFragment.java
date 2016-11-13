package mohammadsharif.com.intersect;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class SecondFragment extends Fragment implements CameraFragmentCallbacks {

    public static final String TAG = "SecondFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_frag, container, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getActivity().setTitle("QR Reader");

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.cam_placeholder, CameraFragment.newInstance(this));
        ft.commit();

        return v;
    }

    public static SecondFragment newInstance() {
        SecondFragment f = new SecondFragment();
        return f;
    }

    @Override
    public void postRecognition(String firebaseID, String formalName) {
        Log.d(TAG, firebaseID + " | " + formalName);
    }
}