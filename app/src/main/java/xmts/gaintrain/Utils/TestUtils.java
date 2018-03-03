package xmts.gaintrain.Utils;

import java.util.ArrayList;
import java.util.List;

import xmts.gaintrain.Models.Exercise;
import xmts.gaintrain.Models.ExerciseSet;
import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.Models.WorkoutExercise;

/**
 * Created by xu on 3/2/18.
 */

public class TestUtils {

    public static List<Workout> getTestWorkoutList() {

        List<Exercise> exerciseList = getTestExerciseList();

        ArrayList<ExerciseSet> exerciseSetWithOneExercise = new ArrayList<>(2);
        exerciseSetWithOneExercise.add(new ExerciseSet(exerciseList.get(0), 8, 185));

        ArrayList<ExerciseSet> exerciseSetWithTwoExercises = new ArrayList<>(2);
        exerciseSetWithTwoExercises.add(new ExerciseSet(exerciseList.get(0), 12, 135));
        exerciseSetWithTwoExercises.add(new ExerciseSet(exerciseList.get(1), 12, 225));


        ArrayList<Workout> workouts = new ArrayList<>(2);

        workouts.add(new Workout("Workout 1", exerciseSetWithOneExercise));
        workouts.add(new Workout("Workout 2", exerciseSetWithTwoExercises));

        return workouts;
    }

    public static List<Exercise> getTestExerciseList() {

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

        ArrayList<Exercise> exerciseList = new ArrayList<>(2);
        exerciseList.add(bench);
        exerciseList.add(squat);

        return exerciseList;
    }

}
