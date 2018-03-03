package xmts.gaintrain.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.R;

/**
 * Created by xu on 3/2/18
 */

public class WorkoutListRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<Workout> workoutList;
    //listener for clicks to workout list
    private onClickListener mListener;

    public WorkoutListRecyclerViewAdapter(List<Workout> workoutList) {
        if (workoutList != null) {
            this.workoutList = workoutList;
        }
    }

    //interface to pass data to fragment
    public interface onClickListener {
        void onClick();
    }


    @Override
    public WorkoutListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new WorkoutListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WorkoutListViewHolder) holder).bindData(workoutList.get(position));
        WorkoutListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    WorkoutListRecyclerViewAdapter.
                }
            }
        })
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
