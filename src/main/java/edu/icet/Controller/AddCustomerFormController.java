package edu.icet.Controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.db.DBConnection;
import edu.icet.modal.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private DatePicker DOB;

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    void btnAddOnAction(ActionEvent event) {

     List<Customer> customerList = DBConnection.getInstance().getConnection();
     customerList.add(new Customer(txtId.getText(),cmbTitle.getValue(),txtName.getText(),txtAddress.getText(),txtNumber.getText(),DOB.getValue()));
      //System.out.println(customerList);
        JOptionPane.showMessageDialog(null,"Customer Added Successfully!");
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtNumber.setText("");
        cmbTitle.setValue("");
        DOB.setValue(null);

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/dash_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTitle.getItems().addAll("Mr.","Mrs.");

    }
}
