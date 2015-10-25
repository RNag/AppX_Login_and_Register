package appx_homescreen.appx;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 10/24/2015.
 */
public class Splash_NextFragmentSecond extends Fragment {
    public static Splash_NextFragmentSecond newInstance() {
        Splash_NextFragmentSecond fragment = new Splash_NextFragmentSecond();
        return fragment;
    }

    public Splash_NextFragmentSecond() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View eventView = inflater.inflate(R.layout.fragment_opportunities, container, false);
        return eventView;
    }
}
