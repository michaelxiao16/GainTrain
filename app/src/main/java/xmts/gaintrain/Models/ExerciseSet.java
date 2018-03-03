package xmts.gaintrain.Models;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.PropertyName;

/**
 * Created by xu on 3/3/18
 *
 * Represents one set (ex. 5 reps of Bench at 135 lbs) of an exercise performed during a workout
 */

public class ExerciseSet {
    @Exclude
    private Exercise exercise;
    @PropertyName("rep_expected")
    private int repsExpected;
    // lbs by default
    @PropertyName("weight_expected")
    private double weightExpected;

    @PropertyName("reps_performed")
    private int repsPerformed = -1;
    @PropertyName("weight_performed")
    private double weightPerformed = -1;

    public ExerciseSet() {

    }

    public ExerciseSet(Exercise exercise, int repsExpected, double weightExpected) {
        this.exercise = exercise;
        this.repsExpected = repsExpected;
        this.weightExpected = weightExpected;
    }

    @Exclude
    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @PropertyName("rep_expected")
    public int getRepsExpected() {
        return repsExpected;
    }

    public void setRepsExpected(int repsExpected) {
        this.repsExpected = repsExpected;
    }

    @PropertyName("weight_expected")
    public double getWeightExpected() {
        return weightExpected;
    }

    public void setWeightExpected(double weightExpected) {
        this.weightExpected = weightExpected;
    }

    @PropertyName("reps_performed")
    public int getRepsPerformed() {
        return repsPerformed;
    }

    public void setRepsPerformed(int repsPerformed) {
        this.repsPerformed = repsPerformed;
    }

    @PropertyName("weight_performed")
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
