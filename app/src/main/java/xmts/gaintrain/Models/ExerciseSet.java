package xmts.gaintrain.Models;

/**
 * Created by xu on 3/3/18
 *
 * Represents one set (ex. 5 reps of Bench at 135 lbs) of an exercise performed during a workout
 */

public class ExerciseSet {
    private Exercise exercise;
    private int repsExpected;
    // lbs by default
    private double weightExpected;

    private int repsPerformed = -1;
    private double weightPerformed = -1;

    public ExerciseSet(Exercise exercise, int repsExpected, double weightExpected) {
        this.exercise = exercise;
        this.repsExpected = repsExpected;
        this.weightExpected = weightExpected;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getRepsExpected() {
        return repsExpected;
    }

    public void setRepsExpected(int repsExpected) {
        this.repsExpected = repsExpected;
    }

    public double getWeightExpected() {
        return weightExpected;
    }

    public void setWeightExpected(double weightExpected) {
        this.weightExpected = weightExpected;
    }

    public int getRepsPerformed() {
        return repsPerformed;
    }

    public void setRepsPerformed(int repsPerformed) {
        this.repsPerformed = repsPerformed;
    }

    public double getWeightPerformed() {
        return weightPerformed;
    }

    public void setWeightPerformed(double weightPerformed) {
        this.weightPerformed = weightPerformed;
    }

    @Override
    public String toString() {
        if (exercise != null) {
            if (repsPerformed >= 0 && weightPerformed >= 0 ) {
                return repsPerformed + "/" +  repsExpected + " x "
                        + weightPerformed + "/" + weightExpected + " of " + exercise.toString()
                        + " performed";
            }

            return repsExpected + " x " + weightExpected + " of " + exercise.toString();
        }
        return super.toString();
    }
}
