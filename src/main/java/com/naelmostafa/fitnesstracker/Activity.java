package com.naelmostafa.fitnesstracker;

public class Activity {
    private String activity;
    private int duration;
    private float calories;
    private float heartRate;

    Activity(){
    }
    Activity(String activity, int duration, float calories, float heartRate) {
        this.activity = activity;
        this.calories = calories;
        this.heartRate = heartRate;
        if (duration > 0) this.duration = duration;
    }

    public String getActivity() {
        return activity;
    }

    public float getCalories() {
        return calories;
    }

    public float getHeartRate() {
        return heartRate;
    }
}
