package xmts.gaintrain.Adapters;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.R;

/**
 * Created by xu on 3/2/18
 */

public class WorkoutListRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<Workout> workoutList;
    //listener for clicks to workout list
    private WorkoutListAdapterListener mListener;

    /**
     * No args empty constructor
     */
    public WorkoutListRecyclerViewAdapter() {
    }

    /**
     * newInstance method for propagation of listener up to fragment then main activity
     * @param workouts
     * @param listener
     * @return an instance of this class
     */
    public static WorkoutListRecyclerViewAdapter newInstance(List<Workout> workouts, WorkoutListAdapterListener listener) {
        WorkoutListRecyclerViewAdapter adapter = new WorkoutListRecyclerViewAdapter();
        adapter.workoutList= workouts;
        adapter.mListener = listener;
        return adapter;
    }

    /**
     * interface to be impleneted by fragment,
     */
    public interface WorkoutListAdapterListener {
        void onWorkoutClick();
    }

    //ViewHolder methods overriden
    @Override
    public WorkoutListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new WorkoutListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WorkoutListViewHolder) holder).bindData(workoutList.get(position));
//        WorkoutListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    WorkoutListRecyclerViewAdapter.
//                }
//            }
//        })
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.workout_list_item_view;
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public class WorkoutListViewHolder extends RecyclerView.ViewHolder {

        private TextView workoutNameTextView;

        public WorkoutListViewHolder(View itemView) {
            super(itemView);
            workoutNameTextView = (TextView) itemView.findViewById(R.id.workout_name_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onWorkoutClick();
//                    Toast toast=Toast.makeText( "Hello Javatpoint",Toast.LENGTH_SHORT);
//                    toast.show();
                }
            });
        }

        public void bindData(Workout workout) {
            if (workout.getName() != null) {
                workoutNameTextView.setText(workout.getName());
            } else {
                workoutNameTextView.setText(R.string.not_applicable);
            }
        }

    }
}
