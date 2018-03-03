package xmts.gaintrain.Models;

/**
 * Created by xu on 3/2/18
 * The general user of the app, aka a passenger of gain train
 */

public class Passenger {
    private String username;

    private int daysOnTrain;
    private int workoutsThisWeek;
    private int avgWorkoutLength;
    private int totalVolumne;

    public Passenger(){
        //Default constructor required;
        this("Passenger 1",0,0,0,0);
    }

    public Passenger(String username, int days, int workouts, int length, int volume) {
        this.username = username;
        this.daysOnTrain =  days;
        this.workoutsThisWeek = workouts;
        this.avgWorkoutLength = length;
        this.totalVolumne = volume;
    }
    public String getUsername() {
        return username;
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
