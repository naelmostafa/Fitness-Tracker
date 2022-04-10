package com.naelmostafa.fitnesstracker;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    public Button addButton;
    public TextField activityText;
    public TextField durationText;
    public TextArea calcArea;
    public TextArea resultArea;
    public Button calcButton;
    public Label errorLabel;
    public Button reset;
    public Tracker tracker = new Tracker();

    public void HandelOnActionAdd() {
        String text = activityText.getText().toLowerCase();
        if (isNumeric(durationText.getText())) {
            int time = Integer.parseInt(durationText.getText());

            boolean flag = true;
            switch (text) {
                case "running":
                    tracker.addRunning(time);
                    break;
                case "swimming":
                    tracker.addSwimming(time);
                    break;
                case "kick boxing":
                    tracker.addKickBoxing(time);
                    break;
                case "strength training":
                    tracker.addStrengthTraining(time);
                    break;
                default:
                    errorLabel.setText("Error Invalid Activity!!!");
                    flag = false;
                    break;
            }
            if (flag) {
                errorLabel.setText("");
                calcArea.appendText("\nType: " + text + ", Time:" + time + "minutes.\n");
                calcArea.appendText(String.format("(total calories burnt = %s, total heart rate = %s)\n", tracker.getTotalCaloriesBurnt(), tracker.getTotalHeartRate()));
            }
        }else {errorLabel.setText("Invalid Duration!!!");

        }
    }

    public void HandelOnActionCalc() {
        resultArea.clear();
        resultArea.appendText("Result:");
        resultArea.appendText(String.format("\nTotal calories burnt = %s\nTotal heart rate %s", tracker.getTotalCaloriesBurnt(), tracker.getTotalHeartRate()));
        tracker.sortActivity();
        resultArea.appendText("\n\nActivities Rank:\n\n");
        for (int i = 0; i < tracker.getActivityIndex(); i++) {
            resultArea.appendText(i + 1 + ". " + tracker.getActivityName(i) + ":\n" +
                    "calories burnt:" + tracker.getCaloriesBurnt(i) + "\n Heart Rate increase:" + tracker.getHeartRate(i) + " beat/minute.\n\n");
        }
    }

    public void HandelOnActionReset() {
        tracker.resetMethod();
        calcArea.clear();
        resultArea.clear();
        calcArea.appendText("Add activity:");
    }

    public boolean isNumeric(final String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.chars().allMatch(Character::isDigit);
    }
}

