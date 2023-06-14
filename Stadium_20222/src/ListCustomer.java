//public class ListCustomer {
//}
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ListCustomer extends JFrame implements ActionListener {
    JTable t1;
    JLabel list,name,age,gender,job,salary,phone,ID;
    ListCustomer(){
        super("LTNC 20222 nhom 10");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        list = new JLabel("Danh sách khách hàng hiện có");
        list.setBounds(150,1,500,50);
        add(list);

        name = new JLabel("ID");
        name.setBounds(100,40,500,50);
        add(name);

        age = new JLabel("Tên");
        age.setBounds(230,40,500,50);
        add(age);

        gender = new JLabel("SĐT");
        gender.setBounds(400,40,500,50);
        add(gender);

        job = new JLabel("Giới tính");
        job.setBounds(550,40,250,50);
        add(job);

        salary = new JLabel("Sân đặt");
        salary.setBounds(700,40,250,50);
        add(salary);

        phone = new JLabel("Thời gian đặt");
        phone.setBounds(890,40,800,50);
        add(phone);

        ID = new JLabel("Thanh toán");
        ID.setBounds(1100,40,250,50);
        add(ID);

        t1 = new JTable();
        t1.setBounds(10,80,1200,400);
        add(t1);

        try{
            Connection_DB c = new Connection_DB();
            String query = "select * from customer" ;
            ResultSet resultSet = c.s.executeQuery(query);
            t1.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        setBounds(350,200,1500,570);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public static void main(String[] args) {
        new ListCustomer();
    }
}


