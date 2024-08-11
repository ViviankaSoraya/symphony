module com.vi.symphony {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vi.symphony to javafx.fxml;
    exports com.vi.symphony;
}