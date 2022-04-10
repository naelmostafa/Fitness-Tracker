module com.naelmostafa.fitnesstracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.naelmostafa.fitnesstracker to javafx.fxml;
    exports com.naelmostafa.fitnesstracker;
}