package hk.jp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class Login extends JFrame {

    private Map<String, String> listOfUsers = new HashMap<>();
    private JPanel panel = new JPanel();
    private JLabel loginL = new JLabel("Login");
    private JLabel passwordL = new JLabel("Password");
    private JTextField loginT = new JTextField(50);
    private JPasswordField passwordT = new JPasswordField(50);
    private JButton loginB = new JButton("Login");
    private JButton clearB = new JButton("Clear");

    public Login() throws HeadlessException{
        this("Login");
    }

    public Login(String title) throws HeadlessException{
        super(title);
        buildLoginWindow();
    }

    protected void buildLoginWindow(){
        this.setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.add(panel);

        panel.setLayout(null);

        loginL.setBounds(10,30,150,20);
        panel.add(loginL);

        passwordL.setBounds(10,70,150,20);
        panel.add(passwordL);

        loginT.setBounds(100,30,100,20);
        panel.add(loginT);

        passwordT.setBounds(100,70,100,20);
        panel.add(passwordT);

        loginB.setBounds(200,120,70,30);
        loginB.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfCorrect();
            }
        });
        panel.add(loginB);

        clearB.setBounds(110,120,70,30);
        clearB.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        panel.add(clearB);

        createList();
    }

    private void createList(){
        listOfUsers.put("admin", "admin");
        listOfUsers.put("Hubert", "hasło");
        listOfUsers.put("Jan", "janeczek123");
        listOfUsers.put("kotek", "miau");
    }

    protected void checkIfCorrect(){
        String login = loginT.getText();
        String password = String.valueOf(passwordT.getPassword());

        if(listOfUsers.containsKey(login) && listOfUsers.get(login).equals(password)) {
            panel.setBackground(Color.green);
        }
        else panel.setBackground(Color.red);
    }

    protected void clear(){
        loginT.setText("");
        passwordT.setText("");
        panel.setBackground(Color.white);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Login login = new Login();
                    login.setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace(System.err);
                }
            }
        });
    }


}
