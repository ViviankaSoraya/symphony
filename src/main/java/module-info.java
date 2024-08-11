module com.vi.symphony {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.vi.symphony to javafx.fxml;
    exports com.vi.symphony;
}