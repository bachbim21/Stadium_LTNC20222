import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel heading,ID,name,phone,stadium,deposit;
    JTextField Jname,Jphone,Jstadium,Jdeposit;
    Choice JID;
    JButton check,sub;
    UpdateCustomer(){
        super("LTNC 20222 nhom 10");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("Sửa thông tin khách hàng");
        heading.setBounds(100,20,300,30);
        heading.setFont(new Font("serif",Font.BOLD,17));
        add(heading);

        ID = new JLabel("ID");
        ID.setBounds(30,80,100,20);
        add(ID);

        JID = new Choice();
        JID.setBounds(200,80,200,30);
        add(JID);

        try {
            Connection_DB c = new Connection_DB();
            String query = "select * from customer ";
            ResultSet resultSet = c.s.executeQuery(query);
            while (resultSet.next()){
                JID.add(resultSet.getString("ID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        name = new JLabel("Tên");
        name.setBounds(30,120,100,20);
        add(name);

        Jname = new JTextField();
        Jname.setBounds(200,120,200,30);
        add(Jname);

        phone = new JLabel("SDT");
        phone.setBounds(30,160,100,20);
        add(phone);

        Jphone = new JTextField();
        Jphone.setBounds(200,160,200,30);
        add(Jphone);

        stadium = new JLabel("Sân");
        stadium.setBounds(30,200,100,20);
        add(stadium);

        Jstadium = new JTextField();
        Jstadium.setBounds(200,200,200,30);
        add(Jstadium);

        deposit = new JLabel("Đặt cọc");
        deposit.setBounds(30,240,100,20);
        add(deposit);

        Jdeposit = new JTextField();
        Jdeposit.setBounds(200,240,200,30);
        add(Jdeposit);

        sub = new JButton("Xác nhận");
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setBounds(290,280,123,40);
        sub.addActionListener(this);
        add(sub);

        check = new JButton("Kiểm tra thông tin");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,280,160,40);
        check.addActionListener(this);
        add(check);

        setBounds(350,200,900,570);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == check) {
            String id = JID.getSelectedItem();
            try {
                Connection_DB c = new Connection_DB();
                String query = "select * from customer where ID = '"+id+"'";
                ResultSet resultSet = c.s.executeQuery(query);
                while (resultSet.next()){
                    Jname.setText(resultSet.getString("name"));
                    Jphone.setText(resultSet.getString("phone"));
                    Jstadium.setText(resultSet.getString("stadiumnumber"));
                    Jdeposit.setText(resultSet.getString("deposit"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (actionEvent.getSource() == sub) {
            String id = JID.getSelectedItem();
            String name = Jname.getText();
            String phone = Jphone.getText();
            String stadiumnumber = Jstadium.getText();
            String deposit = Jdeposit.getText();
            try{
                Connection_DB c = new Connection_DB();
                String query = "update customer set name = '"+name+"',phone = '"+phone+"',stadiumnumber= '"+stadiumnumber+"',deposit = '"+deposit+"'  where ID= '"+id+"' "     ;
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer();
    }
}
