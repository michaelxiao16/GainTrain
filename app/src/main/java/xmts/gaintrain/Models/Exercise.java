package xmts.gaintrain.Models;

import android.os.Parcelable;

import java.util.List;

/**
 * Created by xu on 3/2/18
 */

public class Exercise {
    // List of BodyParts a exercise can utilize
    public enum BodyParts {
        chest("chest"), back("back"), bicep("bicep"), tricep("tricep"), legs("legs");

        private final String name;

        BodyParts(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // List of types a workout can be
    public enum ExerciseType {
        bodyweight("bodyweight"), bar("bar"), dumbbell("dumbbell"), machine("machine");
        private final String name;

        ExerciseType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum Difficulty {
        easy(0), medium(1), hard(2);

        private final int difficulty;

        Difficulty(int difficulty) {
            this.difficulty = difficulty;
        }

        public int getDifficulty() {
            return difficulty;
        }
    }

    private String exerciseName;
    private List<BodyParts> bodyPartsUsed;
    private ExerciseType exerciseType;
    private Difficulty difficulty;

    public Exercise(String exerciseName,
                    List<BodyParts> bodyPartsUsed,
                    ExerciseType exerciseType,
                    Difficulty difficulty) {
        this.exerciseName = exerciseName;
        this.bodyPartsUsed = bodyPartsUsed;
        this.exerciseType = exerciseType;
        this.difficulty = difficulty;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public List<BodyParts> getBodyPartsUsed() {
        return bodyPartsUsed;
    }

    public void setBodyPartsUsed(List<BodyParts> bodyPartsUsed) {
        this.bodyPartsUsed = bodyPartsUsed;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        if (exerciseName != null) {
            return exerciseName;
        }

        return super.toString();
    }
}
