package xmts.gaintrain.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu on 3/2/18
 */

public class Workout {

    private String name;
    // List of ExerciseSets performed
    private List<ExerciseSet> exerciseSets;

    public Workout(String name, List<ExerciseSet> exerciseSets) {
        this.name = name;
        this.exerciseSets = exerciseSets;
    }

    public List<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
