import com.sun.org.glassfish.gmbal.Impact;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI {
    //Declare a frame for window
    private JFrame frame;
    //declare a textfield for user
    private JTextField userNameField;
    //declare a textfield for password
    private JPasswordField passwordField;
    //Declare user labels
    private JLabel userNameLbl;
    //Declare password labels
    private JLabel passwordLbl;
    //Declare a jbutton
    private JButton btnConnect;

    //Constructor
    public Login_GUI(){
        initialize();
    }

    // The initialize method that builds the window
    private void initialize(){
        //Creates the window
        frame = new JFrame("My login Window");
        frame.setBounds(100,100,450,300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //create user field
        userNameField = new JTextField();
        userNameField.setBounds(156,56,203,26);
        frame.getContentPane().add(userNameField);
        userNameField.setColumns(10);
        //create password field
        passwordField = new JPasswordField();
        passwordField.setEchoChar('x');
        passwordField.setBounds(156,107,203,26);
        frame.getContentPane().add(passwordField);

        //Create user label
        userNameLbl = new JLabel("USER NAME REEEE:");
        userNameLbl.setBounds(57,51,87,16);
        frame.getContentPane().add(userNameLbl);

        //create password label
        passwordLbl = new JLabel("PASSWORD NORMIE");
        passwordLbl.setBounds(63,112,70,16);
        frame.getContentPane().add(passwordLbl);

        //create connect button
        btnConnect = new JButton("Con ya retard");
        btnConnect.setBounds(148,172,117,290);
        frame.getContentPane().add(btnConnect);

        //create btn action
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DB_Statements stat = new DB_Statements();
                try{
                    String username = userNameField.getText();
                    String password = new String (passwordField.getPassword());
                    if (stat.checkLogin(username,password)){ JOptionPane.showMessageDialog(null,"User founderino\nAcces graterino");
                    }else{JOptionPane.showMessageDialog(null,"Ya done Fcked up\nAccess Denied");}
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        });

        frame.setVisible(true);

    }
}
