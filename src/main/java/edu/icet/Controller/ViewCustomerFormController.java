package edu.icet.Controller;

import edu.icet.db.DBConnection;
import edu.icet.modal.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ViewCustomerFormController {

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colDob;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colNumber;

    @FXML
    private TableView<Customer> tblView;

    @FXML
    void btnReloadOnAction(ActionEvent event) {
      colId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));

        ObservableList<Customer> observableList= FXCollections.observableArrayList();
        List<Customer> customerList= DBConnection.getInstance().getConnection();
        customerList.forEach(obj->{
            observableList.add(obj);
        });
        tblView.setItems(observableList);
    }

}
