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
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import xmts.gaintrain.Models.Passenger;
import xmts.gaintrain.R;

public class StatisticsFragment extends Fragment {
    private Passenger mPassenger;

    public StatisticsFragment() {
        // Required empty public constructor
    }

    public static StatisticsFragment newInstance() {
        StatisticsFragment fragment = new StatisticsFragment();
        return fragment;
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
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //handlers to view objects
    }
    private void populateBarChart(View view) {
        BarChart chart = (BarChart) view.findViewById(R.id.weeklybargraph);
        List<BarEntry> fakedata = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            fakedata.add(new BarEntry(i, i));
        }
        BarDataSet dataSet = new BarDataSet(fakedata, "Day");
        BarData data = new BarData(dataSet);
        dataSet.setDrawValues(false);

        // chart x Axis formatting
        final ArrayList<String> xAxisLabels = new ArrayList<>();
        addBarEntryLabels(xAxisLabels);
        //inner class instantiation of formatter for "Day" labels
        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xAxisLabels.get((int) value);
            }
        };
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(formatter);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);

        YAxis yAxisL = chart.getAxisLeft();
        YAxis yAxisR = chart.getAxisRight();
        yAxisL.setAxisMinimum(0f);
        yAxisL.setDrawAxisLine(false);
        yAxisL.setDrawLabels(true);
        yAxisL.setDrawZeroLine(true);
        yAxisL.setDrawGridLines(false);
        yAxisR.setDrawGridLines(false);
        yAxisR.setDrawAxisLine(false);
        yAxisR.setDrawLabels(false);


        data.setBarWidth(0.9f);
        chart.setData(data);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setExtraOffsets(0,0,0,0);

    }
    private void addBarEntryLabels(ArrayList<String> xAxisLabel) {
        xAxisLabel.add("Sun");
        xAxisLabel.add("Mon");
        xAxisLabel.add("Tue");
        xAxisLabel.add("Wed");
        xAxisLabel.add("Thu");
        xAxisLabel.add("Fri");
        xAxisLabel.add("Sat");
    }
    private void formatXAxis() {

    }




}
