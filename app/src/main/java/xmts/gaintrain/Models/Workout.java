package xmts.gaintrain.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu on 3/2/18
 */

public class Workout {

    private String name;
    private List<Exercise> exercises;

    public Workout(String name, List<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
