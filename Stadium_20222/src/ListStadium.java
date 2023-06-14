import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ListStadium extends JFrame implements ActionListener {
    JTable t1;
    JLabel list,stadium,availble,type,money,status;
    ListStadium(){
        super("LTNC 20222 nhom 10");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        list = new JLabel("Danh sách các sân hiện có");
        list.setBounds(150,1,500,50);
        add(list);

        stadium = new JLabel("Sân");
        stadium.setBounds(10,40,500,50);
        add(stadium);

        availble = new JLabel("Tình trạng sân");
        availble.setBounds(105,40,500,50);
        add(availble);

        type = new JLabel("Loại sân");
        type.setBounds(215,40,500,50);
        add(type);

        money = new JLabel("Giá");
        money.setBounds(310,40,500,50);
        add(money);

        status = new JLabel("Cho thuê");
        status.setBounds(420,40,500,50);
        add(status);




        t1 = new JTable();
        t1.setBounds(10,80,500,400);
        add(t1);

        try{
            Connection_DB c = new Connection_DB();
            String query = "select * from san" ;
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
        new ListStadium();
    }
}
