module fi.jyu.prg2.starvera.personalprojectexpenseproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens fi.jyu.prg2.starvera.personalprojectexpenseproject to javafx.fxml;
    exports fi.jyu.prg2.starvera.personalprojectexpenseproject;
}