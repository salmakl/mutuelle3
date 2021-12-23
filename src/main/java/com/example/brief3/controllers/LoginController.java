package com.example.brief3.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.brief3.DAO.ConnectionClass;
import com.example.brief3.DAO.Users;
import com.example.brief3.Mutuelle;
import com.example.brief3.interfaces.LoginInterface;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import org.apache.log4j.*;


public class LoginController implements LoginInterface {
    Users users = new Users();
    static final Logger log = Logger.getLogger(LoginController.class.getName());


    public LoginController() {
    }
    @FXML
    private Button button;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrong;


    public boolean decryption(String password,String email) {
            //String password = "5B2yubZU";
        try {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), users.getPassword(email));
            // result.verified == true
            System.out.println(result);
            return result.verified;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    public void checkLogin() throws IOException {

        Mutuelle main = new Mutuelle();
        String email = this.email.getText();
        String password = this.password.getText();




        try {

            ConnectionClass connectionClass = new ConnectionClass();
            connectionClass.getConnection();




            if (email.isEmpty() || password.isEmpty()) {
                wrong.setText("Please fill in all fields");
            }
            else if (decryption(password,email)) {
                System.out.println(decryption(password,email));
                main.chaneScene("dashboard.fxml");

            }
            else {
                wrong.setText("Wrong email or password");
                log.info("Wrong email or password");


            }

        }catch (Exception e) {

            e.printStackTrace();
        }





    }


}