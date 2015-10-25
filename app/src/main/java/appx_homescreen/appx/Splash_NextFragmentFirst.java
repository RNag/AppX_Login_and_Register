package appx_homescreen.appx;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 10/24/2015.
 */
public class Splash_NextFragmentFirst extends Fragment {
    public static Splash_NextFragmentFirst newInstance() {
        Splash_NextFragmentFirst fragment = new Splash_NextFragmentFirst();
        return fragment;
    }

    public Splash_NextFragmentFirst() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View eventView = inflater.inflate(R.layout.fragment_events, container, false);
        return eventView;
    }
}
