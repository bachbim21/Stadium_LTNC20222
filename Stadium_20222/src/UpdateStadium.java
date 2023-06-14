import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateStadium extends JFrame implements ActionListener {
    JLabel heading,ID,name,phone,stadium,deposit;
    JTextField Jname,Jphone,Jstadium,Jdeposit;

    /**các tên jlabel và jtextfield được bê nguyên từ updateCustomer nhưng vẫn giữ đúng logic */

    Choice JID;
    JButton check,sub;
    UpdateStadium(){
        super("LTNC 20222 nhom 10");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("Sửa thông tin sân");
        heading.setBounds(100,20,300,30);
        heading.setFont(new Font("serif",Font.BOLD,17));
        add(heading);

        ID = new JLabel("stadiumnumber");
        ID.setBounds(30,80,100,20);
        add(ID);

        JID = new Choice();
        JID.setBounds(200,80,200,30);
        add(JID);

        try {
            Connection_DB c = new Connection_DB();
            String query = "select * from san ";
            ResultSet resultSet = c.s.executeQuery(query);
            while (resultSet.next()){
                JID.add(resultSet.getString("stadiumnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        name = new JLabel("Tình trạng sân");
        name.setBounds(30,120,100,20);
        add(name);

        Jname = new JTextField();
        Jname.setBounds(200,120,200,30);
        add(Jname);

        phone = new JLabel("Loại sân");
        phone.setBounds(30,160,100,20);
        add(phone);

        Jphone = new JTextField();
        Jphone.setBounds(200,160,200,30);
        add(Jphone);

        stadium = new JLabel("Giá");
        stadium.setBounds(30,200,100,20);
        add(stadium);

        Jstadium = new JTextField();
        Jstadium.setBounds(200,200,200,30);
        add(Jstadium);

        deposit = new JLabel("Tình trạng");
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
                String query = "select * from san where stadiumnumber = '"+id+"'";
                ResultSet resultSet = c.s.executeQuery(query);
                while (resultSet.next()){
                    Jname.setText(resultSet.getString("availability"));
                    Jphone.setText(resultSet.getString("type"));
                    Jstadium.setText(resultSet.getString("price"));
                    Jdeposit.setText(resultSet.getString("status"));
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
                String query = "update san set availability = '"+name+"',type = '"+phone+"',price= '"+stadiumnumber+"',status = '"+deposit+"'  where stadiumnumber= '"+id+"' "     ;
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new UpdateStadium();
    }
}
