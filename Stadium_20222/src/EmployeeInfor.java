import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfor extends JFrame implements ActionListener {
    JTable t1;
    JLabel list,name,age,gender,job,salary,phone,ID;
    EmployeeInfor(){
        super("LTNC 20222 nhom 10");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        list = new JLabel("Danh sách các nhân viên hiện có");
        list.setBounds(150,1,500,50);
        add(list);

        name = new JLabel("Tên");
        name.setBounds(10,40,500,50);
        add(name);

        age = new JLabel("Tuổi");
        age.setBounds(85,40,500,50);
        add(age);

        gender = new JLabel("Giới tính");
        gender.setBounds(155,40,500,50);
        add(gender);

        job = new JLabel("Công việc");
        job.setBounds(230,40,500,50);
        add(job);

        salary = new JLabel("Lương");
        salary.setBounds(305,40,500,50);
        add(salary);

        phone = new JLabel("SĐT");
        phone.setBounds(380,40,500,50);
        add(phone);

        ID = new JLabel("CCCD");
        ID.setBounds(450,40,500,50);
        add(ID);




        t1 = new JTable();
        t1.setBounds(10,80,500,400);
        add(t1);

        try{
            Connection_DB c = new Connection_DB();
            String query = "select * from employee" ;
            ResultSet resultSet = c.s.executeQuery(query);
            t1.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }





        setBounds(350,200,1000,570);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public static void main(String[] args) {
        new EmployeeInfor();
    }
}

