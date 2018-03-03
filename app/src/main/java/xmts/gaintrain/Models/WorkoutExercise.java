package xmts.gaintrain.Models;

import java.util.List;

/**
 * Created by xu on 3/3/18
 *
 * Exercise performed during a workout
 * Ex. Three sets of bench on "chest day" workout
 */

public class WorkoutExercise {
    private List<ExerciseSet> exerciseSets;

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
            return exerciseSets.size() + " x " + exerciseSets.get(0).getExercise().getExerciseName();
        }
        return super.toString();
    }
}
