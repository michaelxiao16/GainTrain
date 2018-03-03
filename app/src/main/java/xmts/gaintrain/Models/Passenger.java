package xmts.gaintrain.Models;

/**
 * Created by xu on 3/2/18
 * The general user of the app, aka a passenger of gain train
 */

public class Passenger {
    public int daysOnTrain;
    public int workoutsThisWeek;
    public int avgWorkoutLength;
    public int totalVolumne;

    public Passenger(){
        //Default constructor required;
        this(0,0,0,0);
    }

    public Passenger(int days, int workouts, int length, int volume) {
        this.daysOnTrain =  days;
        this.workoutsThisWeek = workouts;
        this.avgWorkoutLength = length;
        this.totalVolumne = volume;
    }

    public int getDaysOnTrain() {
        return daysOnTrain;
    }
    public int getWorkoutsThisWeek() {
        return workoutsThisWeek;
    }
    public int getAvgWorkoutLength() {
        return avgWorkoutLength;
    }
    public int getTotalVolumne() {
        return totalVolumne;
    }
}
