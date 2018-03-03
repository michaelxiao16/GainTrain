package xmts.gaintrain.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import xmts.gaintrain.Adapters.WorkoutListRecyclerViewAdapter;
import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends android.support.v4.app.Fragment implements WorkoutListRecyclerViewAdapter.WorkoutListAdapterListener{

    private RecyclerView mRecyclerView;
    private FirebaseRecyclerAdapter mAdapter;
    private WorkoutListFragmentListener mListener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }

    // new instance method for propagation of fragment listener up to activity
    public static WorkoutListFragment newInstance(WorkoutListFragmentListener listener) {
        Bundle args = new Bundle();
        WorkoutListFragment fragment = new WorkoutListFragment();
        fragment.setArguments(args);
        if (listener != null) {
            fragment.mListener = listener;
        }
        return fragment;
    }

    //interface for activity to implement, passes a workout to the activity
    public interface WorkoutListFragmentListener {
        public void onWorkoutSelected(Workout w);
    }

    //Override methods for fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = context instanceof Activity ? (Activity) context : null;
    }
    //Implement the interface method onWorkoutClick()
    @Override
    public void onWorkoutClick(Workout w) {
        mListener.onWorkoutSelected(w);
        //TODO: actually get data from listener, send to fragment, not this hack

    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }

    //Create and inflate recycler view, set the adapter to it
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_list, container, false);

        // Create the recycler view and adapter for it
        mRecyclerView = (RecyclerView) view.findViewById(R.id.workout_list_recycler_view);

        Query query = FirebaseDatabase.getInstance()
                .getReference().child("workouts");

        FirebaseRecyclerOptions<Workout> options = new FirebaseRecyclerOptions.Builder<Workout>()
                .setQuery(query, new SnapshotParser<Workout>() {
                    @NonNull
                    @Override
                    public Workout parseSnapshot(@NonNull DataSnapshot snapshot) {
                        Workout workout = new Workout(snapshot);
                        return workout;
                    }
                })
                .build();

        mAdapter = WorkoutListRecyclerViewAdapter.newInstance(this, options);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));

        mRecyclerView.getAdapter().notifyDataSetChanged();

        return view;
    }


}
