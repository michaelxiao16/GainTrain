package xmts.gaintrain.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.Models.WorkoutExercise;
import xmts.gaintrain.R;

/**
 * Created by Michael Xiao Local on 3/3/2018.
 */

public class WorkoutRecyclerViewAdapter extends RecyclerView.Adapter {
    //instance variables????
    private RecyclerView mRecyclerView;
    private Workout workout;

    //might make more sense to refactor as ExerciseListRecyclerViewAdapter, but whatevs
    public WorkoutRecyclerViewAdapter() {
    }

    public static WorkoutRecyclerViewAdapter newInstance() {
        WorkoutRecyclerViewAdapter adapter = new WorkoutRecyclerViewAdapter();
        return adapter;
    }


    @Override
    public WorkoutRecyclerViewAdapter.WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new WorkoutRecyclerViewAdapter.WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WorkoutRecyclerViewAdapter.WorkoutViewHolder) holder).bindData(workout.getWorkoutExercises().get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.workout_list_item_view;
    }

    @Override
    public int getItemCount() {
        //TODO: not really implemented, we don't exactly have a list
        return workout.getWorkoutExercises().size();
    }

    public class WorkoutViewHolder extends RecyclerView.ViewHolder {

        private TextView workoutExerciseTextView;

        public WorkoutViewHolder(View itemView) {
            super(itemView);
            workoutExerciseTextView = (TextView) itemView.findViewById(R.id.workout_name_text_view);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int position = getAdapterPosition();
//                    mListener.onWorkoutClick(workoutList.get(position));
//                }
//            });
        }

        public void bindData(WorkoutExercise workoutExercise) {
            if (workoutExercise.getExerciseSets() != null) {
                workoutExerciseTextView.setText(workoutExercise.toString());
            } else {
                workoutExerciseTextView.setText(R.string.not_applicable);
            }
        }

    }
}
