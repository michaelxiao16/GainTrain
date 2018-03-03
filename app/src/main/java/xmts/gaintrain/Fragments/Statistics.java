package xmts.gaintrain.Fragments;

/**
 * Created by xu on 3/2/18.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xmts.gaintrain.R;

public class Statistics extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TODO: implement statistic fragment onCreate
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statistics_fragment, container, false);
    }
    @Override
    public void onPause() {
        //TODO: implement statistic fragment onPause
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //handlers to view objects
    }

}
