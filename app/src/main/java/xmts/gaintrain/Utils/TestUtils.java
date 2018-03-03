package xmts.gaintrain.Utils;

import java.util.ArrayList;
import java.util.List;

import xmts.gaintrain.Models.Exercise;
import xmts.gaintrain.Models.Workout;

/**
 * Created by xu on 3/2/18.
 */

public class TestUtils {

    public static List<Workout> getTestWorkoutList() {

        List<Exercise.BodyParts> benchParts = new ArrayList<>(0);
        benchParts.add(Exercise.BodyParts.chest);
        benchParts.add(Exercise.BodyParts.tricep);

        List<Exercise.BodyParts> squatParts = new ArrayList<>(0);
        benchParts.add(Exercise.BodyParts.legs);

        Exercise bench = new Exercise("bench",
                benchParts,
                Exercise.ExerciseType.bar,
                Exercise.Difficulty.hard);

        Exercise squat = new Exercise("squat",
                squatParts,
                Exercise.ExerciseType.bar,
                Exercise.Difficulty.hard);

        ArrayList<Exercise> oneExercise = new ArrayList<>(2);
        oneExercise.add(bench);

        ArrayList<Exercise> twoExercise = new ArrayList<>(2);
        oneExercise.add(bench);
        oneExercise.add(squat);

        ArrayList<Workout> workouts = new ArrayList<>(2);

        workouts.add(new Workout("Workout 1", oneExercise));
        workouts.add(new Workout("Workout 2", twoExercise));

        return workouts;
    }

}
