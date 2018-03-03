package xmts.gaintrain.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xmts.gaintrain.Adapters.WorkoutRecyclerViewAdapter;
import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.Models.WorkoutExercise;
import xmts.gaintrain.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WorkoutFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WorkoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkoutFragment extends android.support.v4.app.Fragment {
    private Workout workout;
    private RecyclerView mRecyclerView;
//    private String name;
//    private ArrayList<WorkoutExercise> workoutExercise;
    //AUTO-GENERATED listener
    //private OnFragmentInteractionListener mListener;

    public WorkoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param String name
     * @param ArrayList<WorkoutExercise> workoutExerciseList
     * @return A new instance of fragment WorkoutFragment.
     */
    public static WorkoutFragment newInstance(Workout w) {
        WorkoutFragment fragment = new WorkoutFragment();
        fragment.workout = w;
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, w.getName());
        //args.putString(ARG_PARAM2, workoutExerciseList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.workout_recycler_view);
        WorkoutRecyclerViewAdapter adapter = WorkoutRecyclerViewAdapter.newInstance(workout);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
            DividerItemDecoration.VERTICAL));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                + " must implement OnFragmentInteractionListener");
        }*/
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
