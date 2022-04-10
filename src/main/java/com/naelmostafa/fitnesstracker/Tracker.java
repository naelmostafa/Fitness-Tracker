package com.naelmostafa.fitnesstracker;

public class Tracker {

    private Activity[] activitiesList;
    private int activityIndex;
    private float totalHeartRate;
    private float heartRateInc = 0;
    private float totalCaloriesBurnt;
    private float caloriesBurnt = 0;

    Tracker() {
        this.totalHeartRate = 80;
        this.totalCaloriesBurnt = 0;
        activitiesList = new Activity[128];
        this.activityIndex = 0;
    }

    float getTotalHeartRate() {
        return totalHeartRate;
    }

    float getTotalCaloriesBurnt() {
        return totalCaloriesBurnt;
    }

    float getHeartRate(int index) {
        return activitiesList[index].getHeartRate();
    }

    float getCaloriesBurnt(int index) {
        return activitiesList[index].getCalories();
    }

    String getActivityName(int index) {
        return activitiesList[index].getActivity();
    }

    int getActivityIndex() {
        return activityIndex;
    }

    //ADD METHODS
    void addRunning(int duration) {
        final float runningHrInc = 0.003f;
        heartRateInc = totalHeartRate * duration * runningHrInc;
        caloriesBurnt = duration * 5;
        totalHeartRate += heartRateInc;
        totalCaloriesBurnt += caloriesBurnt;
        activitiesList[activityIndex++] = new Activity("Running", duration, caloriesBurnt, heartRateInc);
    }

    void addSwimming(int duration) {
        final float swimmingHrInc = 0.002f;
        heartRateInc = totalHeartRate * duration * swimmingHrInc;
        caloriesBurnt = duration * 4;
        totalHeartRate += heartRateInc;
        totalCaloriesBurnt += caloriesBurnt;
        activitiesList[activityIndex++] = new Activity("Swimming", duration, caloriesBurnt, heartRateInc);
    }

    void addKickBoxing(int duration) {
        final float kickBHrInc = 0.005f;
        heartRateInc = totalHeartRate * duration * kickBHrInc;
        caloriesBurnt = duration * 3;
        totalHeartRate += heartRateInc;
        totalCaloriesBurnt += caloriesBurnt;
        activitiesList[activityIndex++] = new Activity("Kick Boxing", duration, caloriesBurnt, heartRateInc);

    }

    void addStrengthTraining(int duration) {
        final float strTrainingHrInc = 0.006f;
        heartRateInc = totalHeartRate * duration * strTrainingHrInc;
        caloriesBurnt = duration * 5;
        totalHeartRate += heartRateInc;
        totalCaloriesBurnt += caloriesBurnt;
        activitiesList[activityIndex++] = new Activity("Strength Workout", duration, caloriesBurnt, heartRateInc);
    }

    //SORTING METHODS
    void sortActivity() {
        Activity temp;
        for (int i = 0; i < activityIndex - 1; i++) {
            for (int j = 0; j < activityIndex - 1 - i; j++) {
                if (activitiesList[j].getCalories() < activitiesList[j + 1].getCalories()) {
                    temp = activitiesList[j];
                    activitiesList[j] = activitiesList[j + 1];
                    activitiesList[j + 1] = temp;

                } else if (activitiesList[i].getCalories() == activitiesList[i + 1].getCalories()) {
                    if (activitiesList[j].getHeartRate() > activitiesList[j + 1].getHeartRate()) {
                        temp = activitiesList[j];
                        activitiesList[j] = activitiesList[j + 1];
                        activitiesList[j + 1] = temp;
                    }
                }
            }

        }
    }

    void resetMethod() {
        totalHeartRate = 80;
        totalCaloriesBurnt = 0;
        activityIndex = 0;
    }

}
