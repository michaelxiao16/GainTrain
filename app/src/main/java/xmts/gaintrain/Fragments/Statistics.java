package xmts.gaintrain.Fragments;

/**
 * Created by xu on 3/2/18.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;

import xmts.gaintrain.R;

public class Statistics extends Fragment {
    public Statistics() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.statistics_fragment, container, false);

        BarChart chart = (BarChart) view.findViewById(R.id.weeklybargraph);
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        //TODO: implement statistic fragment onPause
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //handlers to view objects
    }

}
