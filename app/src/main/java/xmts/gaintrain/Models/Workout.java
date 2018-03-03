package xmts.gaintrain.Models;

import java.util.List;

/**
 * Created by xu on 3/2/18
 */

public class Workout{

    private String name;
    // List of ExerciseSets performed
    private List<WorkoutExercise> workoutExercises;

    public Workout(String name, List<WorkoutExercise> workoutExercises) {
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }
}
