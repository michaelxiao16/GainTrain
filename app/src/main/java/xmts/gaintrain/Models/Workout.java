package xmts.gaintrain.Models;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.PropertyName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu on 3/2/18
 */

public class Workout{

    public static final String WORKOUT_NAME_KEY = "name";

    @PropertyName("name")
    private String name;
    @PropertyName("workout_exercises")
    private List<String> workoutExercisesKeys;

    // List of ExerciseSets performed
    private List<WorkoutExercise> workoutExercises;

    public Workout() {

    }

    public Workout(DataSnapshot snapshot) {
        this.workoutExercises = new ArrayList<>(10);
        this.workoutExercisesKeys = new ArrayList<>(10);

        if (snapshot.hasChild(WORKOUT_NAME_KEY)) {
            name = ((String) snapshot.child(WORKOUT_NAME_KEY).getValue());
        }

        if (snapshot.hasChild(WorkoutExercise.WORKOUT_EXERCISES_KEY)) {
            for (DataSnapshot ds : snapshot.child(WorkoutExercise.WORKOUT_EXERCISES_KEY).getChildren()) {
                this.workoutExercisesKeys.add(ds.getKey());
                workoutExercises.add(new WorkoutExercise(ds.getKey()));
            }
        }
    }

    public Workout(String name, List<String> workoutExercisesKeys) {
        this(name, workoutExercisesKeys, null);
    }

    public Workout(String name, List<String> workoutExercisesKeys, List<WorkoutExercise> workoutExercises) {
        this.name = name;
        this.workoutExercisesKeys = workoutExercisesKeys;
        this.workoutExercises = workoutExercises;
    }

    public List<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(List<WorkoutExercise> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWorkoutExercisesKeys() {
        return workoutExercisesKeys;
    }

    public void setWorkoutExercisesKeys(List<String> workoutExercisesKeys) {
        this.workoutExercisesKeys = workoutExercisesKeys;
    }

    @Override
    public String toString() {
        return name;
    }
}
