package xmts.gaintrain.Fragments;

/**
 * Created by xu on 3/2/18.
 *
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import xmts.gaintrain.R;

public class StatisticsFragment extends Fragment {


    public StatisticsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.statistics_fragment, container, false);

        populateBarChart(view);

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
    private void populateBarChart(View view) {
        BarChart chart = (BarChart) view.findViewById(R.id.weeklybargraph);
        List<BarEntry> fakedata = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            fakedata.add(new BarEntry(i, i));
        }
        BarDataSet dataSet = new BarDataSet(fakedata, "Day");
        BarData data = new BarData(dataSet);
        chart.setData(data);
        Description bullshitDescription = new Description();
        bullshitDescription.setText("BULLSHIT LEVEL OVER TIME CHART");
        chart.setDescription(bullshitDescription);
    }
}
