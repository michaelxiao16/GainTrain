package xmts.gaintrain.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseError;

import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.R;

/**
 * Created by xu on 3/2/18
 */

public class WorkoutListRecyclerViewAdapter extends FirebaseRecyclerAdapter<Workout, WorkoutListRecyclerViewAdapter.WorkoutListViewHolder> {
    //listener for clicks to workout list
    private WorkoutListAdapterListener mListener;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public WorkoutListRecyclerViewAdapter(@NonNull FirebaseRecyclerOptions<Workout> options) {
        super(options);
    }

    /**
     * newInstance method for propagation of listener up to fragment then main activity
     * @param listener
     * @return an instance of this class
     */
    public static WorkoutListRecyclerViewAdapter newInstance(WorkoutListAdapterListener listener, FirebaseRecyclerOptions<Workout> option) {
        WorkoutListRecyclerViewAdapter adapter = new WorkoutListRecyclerViewAdapter(option);
        adapter.mListener = listener;
        return adapter;
    }

    /**
     * interface to be implemented by fragment,
     */
    public interface WorkoutListAdapterListener {
        void onWorkoutClick(Workout w);
    }

    @Override
    public void onDataChanged() {
        super.onDataChanged();
    }

    @Override
    public void onError(@NonNull DatabaseError error) {
        Log.d("tag", error.getDetails());
        super.onError(error);
    }

    //ViewHolder methods overriden
    @Override
    public WorkoutListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new WorkoutListViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.workout_list_item_view;
    }

    @Override
    protected void onBindViewHolder(@NonNull WorkoutListViewHolder holder, int position, @NonNull Workout model) {
        ((WorkoutListViewHolder) holder).bindData(model);
    }

    public class WorkoutListViewHolder extends RecyclerView.ViewHolder {

        private TextView workoutNameTextView;
        private Object data;

        public WorkoutListViewHolder(View itemView) {
            super(itemView);
            workoutNameTextView = (TextView) itemView.findViewById(R.id.workout_name_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    mListener.onWorkoutClick((Workout) data);
                }
            });
        }

        public void bindData(Workout workout) {
            if (workout.getName() != null) {
                workoutNameTextView.setText(workout.getName());
                data = workout;
            } else {
                workoutNameTextView.setText(R.string.not_applicable);
            }
        }

    }
}
