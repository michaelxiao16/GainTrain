package xmts.gaintrain.Models;

/**
 * Created by xu on 3/3/18
 *
 * Represents one set (ex. 5 reps of Bench at 135 lbs) of an exercise performed during a workout
 */

public class ExerciseSet {
    private Exercise exercise;
    private int rep;

    // lbs by default
    private double weight;

    public ExerciseSet(Exercise exercise, int rep, double weight) {
        this.exercise = exercise;
        this.rep = rep;
        this.weight = weight;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
