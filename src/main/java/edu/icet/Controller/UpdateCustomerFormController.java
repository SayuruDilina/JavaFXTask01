package edu.icet.Controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.db.DBConnection;
import edu.icet.modal.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UpdateCustomerFormController {

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
    private JFXTextField txtSearch;

    @FXML
    void btnBackOnAction(ActionEvent event) {
      Stage  stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../../view/dash_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        boolean found = false;
        for (Customer customer : customerList) {
            if (txtSearch.getText().equals(customer.getCustomerId())) {
                found = true;
                txtId.setText(customer.getCustomerId());
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtNumber.setText(customer.getNumber());
                cmbTitle.setValue(String.valueOf(customer.getTitle()));
                DOB.setValue(customer.getDob());
                break;
            }
        }
        if (!found){
            JOptionPane.showMessageDialog(null, "Customer Not Found!");
        }
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String  id = txtId.getText();
        String name = txtName.getText();
       String address= txtAddress.getText();
        String number = txtNumber.getText();
        LocalDate date = DOB.getValue();
        boolean updated = false;
        List<Customer> list=DBConnection.getInstance().getConnection();
        for (Customer customer:list){
            if (txtSearch.getText().equals(customer.getCustomerId())) {
              customer.setName(name);
              customer.setAddress(address);
              customer.setDob(date);
              customer.setNumber(number);
                updated = true;
                JOptionPane.showMessageDialog(null, "Customer updated successfully!");
                break;
            }else {
                JOptionPane.showMessageDialog(null, "Customer Not Found!");
            }
        }
    }

}
