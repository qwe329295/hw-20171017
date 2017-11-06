import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame  extends JFrame{
    private JLabel jlab1ID = new JLabel("ID:");
    private JLabel jlab1PW = new JLabel("PW:");
    private JTextField jtfID = new JTextField();
    private JPasswordField jpfPW = new JPasswordField();
    private JButton jbtnExit = new JButton("EXIT");
    private JButton jbtnLogin = new JButton("LOGIN");
    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=300,frmH=150,screenW,screenH;
    private Container cp;
    public LoginFrame(){
        init();
    }
    private void init(){
        screenW=dim.width;
        screenH=dim.height;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        cp.add(jlab1ID);
        cp.add(jtfID);
        cp.add(jlab1PW);
        cp.add(jpfPW);
        cp.add(jbtnExit);
        cp.add(jbtnLogin);

        jlab1ID.setHorizontalAlignment(JLabel.RIGHT);
        jlab1PW.setHorizontalAlignment(JLabel.RIGHT);

        jbtnLogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtfID.getText().equals("h304") &&(new String(jpfPW.getPassword()).equals("23323456")) ) {
                    MainFrame mainFrame = new MainFrame( LoginFrame.this);
                    mainFrame.setVisible(true);
                    LoginFrame.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,"Error");
                }
            }
        });

        jbtnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}
