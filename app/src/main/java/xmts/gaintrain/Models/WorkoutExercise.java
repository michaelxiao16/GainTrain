package xmts.gaintrain.Models;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu on 3/3/18
 *
 * Exercise performed during a workout
 * Ex. Three sets of bench on "chest day" workout
 */

public class WorkoutExercise {


    private List<ExerciseSet> exerciseSets;
    public static final String WORKOUT_EXERCISES_KEY = "workout_exercises";

    public WorkoutExercise() {
    }

    public WorkoutExercise(String workoutExerciseKey) {

        exerciseSets = new ArrayList<>(10);

        DatabaseReference weRef = FirebaseDatabase.getInstance().getReference(WORKOUT_EXERCISES_KEY);
        weRef.child(workoutExerciseKey).orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        exerciseSets.add(ds.getValue(ExerciseSet.class));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public WorkoutExercise(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    public List<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    @Override
    public String toString() {
        if (exerciseSets != null) {
            if (exerciseSets.get(0).getExercise() != null) {
                return exerciseSets.size() + " x " + exerciseSets.get(0).getExercise().getExerciseName();
            }
        }
        return super.toString();
    }
}
