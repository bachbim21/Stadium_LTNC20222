import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
   JLabel heading,id,name,phone,gender,stadiumnumber,checkintime,timer,deposit;
   JTextField Jid,Jname,Jphone,Jdeposit;
   JRadioButton Jnu,Jnam;
   JButton sub;
   Choice choice;
    AddCustomer(){
       super("LTNC 20222 nhom 10");
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);

       heading = new JLabel("Thêm khách hàng mới");
       heading.setBounds(100,20,300,30);
       heading.setFont(new Font("serif",Font.BOLD,17));
       add(heading);

        id= new JLabel("CCCD");
        id.setBounds(35,80,100,30);
        add(id);

        Jid = new JTextField();
        Jid.setBounds(200,80,150,30);
        add(Jid);

        name= new JLabel("Tên");
        name.setBounds(35,120,100,30);
        add(name);

        Jname = new JTextField();
        Jname.setBounds(200,120,150,30);
        add(Jname);

        phone= new JLabel("SDT");
        phone.setBounds(35,160,100,30);
        add(phone);

        Jphone = new JTextField();
        Jphone.setBounds(200,160,150,30);
        add(Jphone);

        gender = new JLabel("Giới tính");
        gender.setBounds(35,200,120,30);
        add(gender);

        Jnam = new JRadioButton("Nam");
        Jnam.setBounds(200,200,80,30);
        Jnam.setFont(new Font("serif", Font.PLAIN,17));
        add(Jnam);

        Jnu = new JRadioButton("Nữ");
        Jnu.setBounds(290,200,80,30);
        Jnu.setFont(new Font("serif", Font.PLAIN,17));
        add(Jnu);

        ButtonGroup group = new ButtonGroup();
        group.add(Jnam);
        group.add(Jnu);

        stadiumnumber = new JLabel("Sân đặt");
        stadiumnumber.setBounds(35,240,120,30);
        add(stadiumnumber);

        choice = new Choice();
        try{
            Connection_DB c = new Connection_DB();
            String query = "select * from san where status ='Có thể thuê'";
            ResultSet resultSet = c.s.executeQuery(query);
            while (resultSet.next()){
                choice.add(resultSet.getString("stadiumnumber"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        choice.setBounds(200,240,150,30);
        add(choice);

        Date date = new Date();
        checkintime = new JLabel("Thời điểm tạo form");
        checkintime.setBounds(35,280,120,30);
        add(checkintime);

        timer = new JLabel(" " + date);
        timer.setBounds(200,280,350,30);
        add(timer);

        deposit = new JLabel("Thanh toán");
        deposit.setBounds(35,320,120,30);
        add(deposit);

        Jdeposit = new JTextField();
        Jdeposit.setBounds(200,320,150,30);
        add(Jdeposit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/f.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(550,100,250,250);
        add(l3);

        sub = new JButton("Xác nhận");
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setBounds(290,400,123,40);
        sub.addActionListener(this);
        add(sub);

        setBounds(350,200,800,570);
       setVisible(true);
   }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == sub) {
            try {
                String ID = Jid.getText();
                String name = Jname.getText();
                String phone = Jphone.getText();
                String gender = null;
                if (Jnu.isSelected()) {
                    gender = "Nữ";
                }
                else if (Jnam.isSelected()) {
                    gender = "Nam";
                }
                String time = timer.getText();
                String stadiumnumber = choice.getSelectedItem();
                String deposit  = Jdeposit.getText();
                if (ID.equals("")) {
                    JOptionPane.showMessageDialog(null, "ID không được để trống");
                    return;
                }

                Connection_DB c = new Connection_DB();
                String query = "insert into customer values('" + ID + "','" + name + "','" + phone + "','" + gender + "','" + stadiumnumber + "','" + time + "','" + deposit + "')";
                String query2 = "update san set status = 'Không thể thuê' where stadiumnumber = '" +stadiumnumber+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
