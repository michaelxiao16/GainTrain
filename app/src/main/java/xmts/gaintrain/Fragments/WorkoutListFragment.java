package xmts.gaintrain.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xmts.gaintrain.Adapters.WorkoutListRecyclerViewAdapter;
import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends android.support.v4.app.Fragment implements WorkoutListRecyclerViewAdapter.onClickListener{

    private List<Workout> workouts;
    private RecyclerView mRecyclerView;
    private WorkoutListFragmentListener mlistener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }
    //Create new instance method to pass data from from workoutlistfragment listener to activity
    public static WorkoutListFragment newInstance(WorkoutListFragmentListener listener) {
        Bundle args = new Bundle();
        WorkoutListFragment fragment = new WorkoutListFragment();
        fragment.setArguments(args);
        if (listener != null) {
            fragment.mlistener = listener;
        }
        return fragment;
    }

    //interface for passing data to activity
    public interface WorkoutListFragmentListener {
        public void onWorkoutSelected(Workout w);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = context instanceof Activity ? (Activity) context : null;
    }

    //interface for talking to adapter
    @Override
    public void onClick() {
        //TODO: get data from listener, send to fragment
        switc
    }

    public static WorkoutListFragment newInstance(List<Workout> workouts) {

        Bundle args = new Bundle();
        
        WorkoutListFragment fragment = new WorkoutListFragment();
        fragment.setArguments(args);

        fragment.workouts = workouts;

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.workout_list_recycler_view);

        WorkoutListRecyclerViewAdapter adapter = new WorkoutListRecyclerViewAdapter(workouts);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));

        return view;
    }

}
