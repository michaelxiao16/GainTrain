package xmts.gaintrain.Models;

import java.util.List;

/**
 * Created by xu on 3/2/18
 */

public class Exercise {
    // List of BodyParts a exercise can utilize
    public enum BodyParts {chest, back, bicep, tricep, legs};

    // List of types a workout can be
    public enum ExerciseType {bodyweight, bar, dumbbell, machine};

    private String exerciseName;
    private List<BodyParts> bodyPartsUsed;
    private ExerciseType exerciseType;
}
