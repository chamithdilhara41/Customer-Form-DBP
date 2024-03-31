package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.*;

public class CustomerFormController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    void OnActionName(ActionEvent event) {

    }

    @FXML
    void btnOnActionClear(ActionEvent event) {

    }

    @FXML
    void btnOnActionDelete(ActionEvent event) throws SQLException {
        String Id = txtId.getText();

        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@123"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1,Id);

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0){
                System.out.println("customer deleted succesfully!");
            }else {
                System.out.println("customer not deleted!");
            }
        }
    }

    @FXML
    void btnOnActionSave(ActionEvent event) throws SQLException {

        String Id = txtId.getText();
        String Name = txtName.getText();
        String Address = txtAddress.getText();
        String Tel = txtTel.getText();

        String sql = "INSERT INTO customers(id, name, address, tel) VALUES(?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@123"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1,Id);
            pstm.setObject(2,Name);
            pstm.setObject(3,Address);
            pstm.setObject(4,Tel);

            int affectedRow = pstm.executeUpdate();
            if (affectedRow > 0) {
                System.out.println("Customer saved");
            }else {
                System.out.println("customer not saved");
            }
        }
    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) throws SQLException {

        String Id = txtId.getText();
        String Name = txtName.getText();
        String Address = txtAddress.getText();
        String Tel = txtTel.getText();

        String sql = "UPDATE customers SET name = ?, address = ?, tel = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@123"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1,Name);
            pstm.setObject(2,Address);
            pstm.setObject(3,Tel);
            pstm.setObject(4,Id);

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0){
                System.out.println("customer updated!");
            }else {
                System.out.println("customer not updated!");
            }
        }
    }

    @FXML
    void onActionAddress(ActionEvent event) {

    }

    @FXML
    void onActionId(ActionEvent event) {

    }

    @FXML
    void onActionTel(ActionEvent event) {

    }

}
