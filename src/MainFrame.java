import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame{
        private Container cp;
        private Random rnd =new Random();
        private JTextField jtf= new JTextField();
        private JButton btn[]=new JButton[12];
        private JPanel jpn= new JPanel(new GridLayout(4,3,5,5));
        private LoginFrame loginFrame;
        private Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
        private int w=300,h=300,Sw=dim.width,Sh=dim.height;


        public MainFrame(LoginFrame login){
            loginFrame=login;
            init();
        }
        private void init(){
            this.setBounds(Sw/2-w,Sh/2-h,w,h);
            cp=this.getContentPane();
            cp.setLayout(new BorderLayout(5,5));
            cp.add(jpn,BorderLayout.CENTER);
            cp.add(jtf,BorderLayout.NORTH);
            jtf.setEditable(false);
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    MainFrame.this.setVisible(false);
                    loginFrame.setVisible(true);
                }
            });
            for(int i=0;i<10;i++){
                btn[i]= new JButton();
                jpn.add(btn[i]);
                btn[i].addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmpButton =(JButton) e.getSource();
                        jtf.setText(jtf.getText()+tmpButton.getText());
                    }
                });
            }
            for(int i=0;i<10;i++){
                btn[i].setText(String .valueOf(rnd.nextInt(10)));
                boolean repeat=false;
                for(int j=0;j<i;j++){
                    if(btn[j].getText().equals(btn[i].getText())){
                        repeat=true;
                        break;
                    }
                }
                if(repeat ==true){
                    i--;
                    
                }
            }
            btn[10]=new JButton(".");
            btn[11]=new JButton("CLEAR");
            jpn.add(btn[10]);
            jpn.add(btn[11]);
            btn[10].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jtf.setText(jtf.getText()+".");
                }
            });

            btn[11].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jtf.setText(" ");
                }
            });
        }
    }

