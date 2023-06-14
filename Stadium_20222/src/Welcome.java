import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame implements ActionListener {
    Welcome(){
        super("LTNC 20222 nhom 10");
        setBounds(100,100,1366,565);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/s4.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);

        JLabel text = new JLabel("QUẢN LÝ SÂN ĐÁ BÓNG - V1");
        text.setBounds(20,430,1500,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN,50));
        image.add(text);

        JButton next = new JButton("TIẾP");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("serif", Font.PLAIN,30));
        // add action to login
        next.addActionListener(this);
        image.add(next);

        setVisible(true);
        while (true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new Welcome();
    }


}
