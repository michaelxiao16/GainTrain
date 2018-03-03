package xmts.gaintrain.Utils;

import java.util.ArrayList;
import java.util.List;

import xmts.gaintrain.Models.Exercise;
import xmts.gaintrain.Models.ExerciseSet;
import xmts.gaintrain.Models.Workout;
import xmts.gaintrain.Models.WorkoutExercise;
import xmts.gaintrain.Models.WorkoutHistory;

/**
 * Created by xu on 3/2/18
 */

public class TestUtils {

    public static List<Workout> getTestWorkoutList() {

        List<Exercise> exerciseList = getTestExerciseList();

        // Template for Doing 3 sets of 8 reps of exercise[0] at 185lbs
        ArrayList<ExerciseSet> threeSets = new ArrayList<>(2);
        threeSets.add(new ExerciseSet(exerciseList.get(0), 8, 185));
        threeSets.add(new ExerciseSet(exerciseList.get(0), 8, 185));
        threeSets.add(new ExerciseSet(exerciseList.get(0), 8, 185));

        WorkoutExercise threeSetsWorkoutExercise = new WorkoutExercise(threeSets);


        // Template for Doing 2 sets of 12 reps of exercise[1] at 135lbs
        ArrayList<ExerciseSet> twoSets = new ArrayList<>(2);
        twoSets.add(new ExerciseSet(exerciseList.get(1), 12, 135));
        twoSets.add(new ExerciseSet(exerciseList.get(1), 12, 135));

        WorkoutExercise twoSetsWorkoutExercise = new WorkoutExercise(twoSets);


        ArrayList<WorkoutExercise> oneWorkoutExercise = new ArrayList<>(1);
        oneWorkoutExercise.add(threeSetsWorkoutExercise);

        ArrayList<WorkoutExercise> twoWorkoutExercises = new ArrayList<>(2);
        twoWorkoutExercises.add(threeSetsWorkoutExercise);
        twoWorkoutExercises.add(twoSetsWorkoutExercise);


        ArrayList<Workout> workouts = new ArrayList<>(2);

        workouts.add(new Workout("Workout 1", null, oneWorkoutExercise));
        workouts.add(new Workout("Workout 2", null, twoWorkoutExercises));

        return workouts;
    }

    public static List<Exercise> getTestExerciseList() {

        List<Exercise.BodyParts> benchParts = new ArrayList<>(0);
        benchParts.add(Exercise.BodyParts.chest);
        benchParts.add(Exercise.BodyParts.tricep);

        List<Exercise.BodyParts> squatParts = new ArrayList<>(0);
        squatParts.add(Exercise.BodyParts.legs);

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

    public static WorkoutHistory getTestWorkoutHistory() {
        String dateCompleted = "01/01/2018";
        List<WorkoutExercise> workoutExercises = getTestCompletedWorkoutExerciseList();

        return new WorkoutHistory(dateCompleted, workoutExercises);
    }

    // Gets a List of WorkoutExercises that have been completed
    public static List<WorkoutExercise> getTestCompletedWorkoutExerciseList() {
        List<Workout> workouts = getTestWorkoutList();
        List<WorkoutExercise> workoutExercises = workouts.get(1).getWorkoutExercises();

        for (WorkoutExercise we : workoutExercises) {
            for (ExerciseSet es : we.getExerciseSets()) {
                es.setWeightPerformed(es.getWeightExpected() - 20);
                es.setRepsPerformed(es.getRepsExpected() - 2);
            }
        }

        return workoutExercises;
    }

}
