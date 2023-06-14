import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondDashboard extends JFrame  implements ActionListener {
    JButton Jnewcus,Jliststadium,Jlistemployee,Jlistcustomer,Jcheckout,Jupdatecustomer,Jupdatestadium,Jfind ;
    SecondDashboard(){
        super("LTNC 20222 nhom 10");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Jnewcus = new JButton("Thêm khách hàng");
        Jnewcus.setBounds(10,30,200,30);
        Jnewcus.setBackground(Color.BLACK);
        Jnewcus.setForeground(Color.WHITE);
        Jnewcus.addActionListener(this);
        add(Jnewcus);

        Jliststadium = new JButton("Xem danh sách sân");
        Jliststadium.setBounds(10,70,200,30);
        Jliststadium.setBackground(Color.BLACK);
        Jliststadium.setForeground(Color.WHITE);
        Jliststadium.addActionListener(this);
        add(Jliststadium);

        Jlistemployee = new JButton("Xem danh sách nhân viên");
        Jlistemployee.setBounds(10,110,200,30);
        Jlistemployee.setBackground(Color.BLACK);
        Jlistemployee.setForeground(Color.WHITE);
        Jlistemployee.addActionListener(this);
        add(Jlistemployee);

        Jlistcustomer = new JButton("Xem danh sách khách hàng");
        Jlistcustomer.setBounds(10,150,200,30);
        Jlistcustomer.setBackground(Color.BLACK);
        Jlistcustomer.setForeground(Color.WHITE);
        Jlistcustomer.addActionListener(this);
        add(Jlistcustomer);

        Jcheckout = new JButton("Khách trả sân");
        Jcheckout.setBounds(10,190,200,30);
        Jcheckout.setBackground(Color.BLACK);
        Jcheckout.setForeground(Color.WHITE);
        Jcheckout.addActionListener(this);
        add(Jcheckout);

        Jupdatecustomer = new JButton("Sửa thông tin khách");
        Jupdatecustomer.setBounds(10,230,200,30);
        Jupdatecustomer.setBackground(Color.BLACK);
        Jupdatecustomer.setForeground(Color.WHITE);
        Jupdatecustomer.addActionListener(this);
        add(Jupdatecustomer);

        Jupdatestadium = new JButton("Sửa thông tin sân");
        Jupdatestadium.setBounds(10,270,200,30);
        Jupdatestadium.setBackground(Color.BLACK);
        Jupdatestadium.setForeground(Color.WHITE);
        Jupdatestadium.addActionListener(this);
        add(Jupdatestadium);

        Jfind = new JButton("Tìm sân");
        Jfind.setBounds(10,310,200,30);
        Jfind.setBackground(Color.BLACK);
        Jfind.setForeground(Color.WHITE);
        Jfind.addActionListener(this);
        add(Jfind);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/r.jpg"));
        JLabel l3 = new JLabel(i1);
        l3.setBounds(250,30,500,470);
        add(l3);

        setBounds(350,200,800,570);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Thêm khách hàng")){
            new AddCustomer();
        } else if (actionEvent.getActionCommand().equals("Xem danh sách sân")) {
            new ListStadium();
        }else if (actionEvent.getActionCommand().equals("Xem danh sách nhân viên")) {
            new EmployeeInfor();
        }else if (actionEvent.getActionCommand().equals("Xem danh sách khách hàng")) {
            new ListCustomer();
        }else if (actionEvent.getActionCommand().equals("Tìm sân")) {
            new FindStadium();
        }else if (actionEvent.getActionCommand().equals("Sửa thông tin khách")) {
            new UpdateCustomer();
        }else if (actionEvent.getActionCommand().equals("Sửa thông tin sân")) {
            new UpdateStadium();
        }else if (actionEvent.getActionCommand().equals("Khách trả sân")) {
            new CheckOut();
        }
    }

    public static void main(String[] args) {
        new SecondDashboard();
    }
}
