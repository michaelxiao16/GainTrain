package xmts.gaintrain.Models;

import java.util.List;

/**
 * Created by xu on 3/3/18
 *
 * A completed workout, stores a list of WorkoutExercises
 * Ex. Chest Day:
 * Bench 3 x 12 at 135
 * Incline Bench 3 x 12 at 95
 *
 */

public class WorkoutHistory {
    // Stored as a string until better method figured out
    private String dateCompleted;
    private List<WorkoutExercise> workoutExercises;

    public WorkoutHistory(String dateCompleted, List<WorkoutExercise> workoutExercises) {
        this.dateCompleted = dateCompleted;
        this.workoutExercises = workoutExercises;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public List<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(List<WorkoutExercise> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }
}

