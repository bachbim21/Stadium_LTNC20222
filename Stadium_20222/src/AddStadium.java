import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStadium extends JFrame implements ActionListener {
    JComboBox Jstadium, Javailable,Jtype,Jstatus;
    JLabel stadium,available,price,add,heading,status;
    JTextField Jprice;
    JButton tinhtien;
    AddStadium(){
        super("LTNC 20222 nhom 10");
        setLayout(null);

        heading = new JLabel("Thêm sân mới");
        heading.setFont(new Font("serif", Font.PLAIN,20));
        heading.setBounds(150,1,200,30);
        add(heading);

        stadium = new JLabel("Chọn sân");
        stadium.setBounds(60,30,120,30);
        stadium.setFont(new Font("serif", Font.PLAIN,17));
        add(stadium);

        String[] str = {"Sân 1","Sân 2","Sân 3","Sân 4","Sân 5","Sân 6","Sân 7" };
        Jstadium = new JComboBox(str);
        Jstadium.setBounds(200,30,150,40);
        add(Jstadium);

        available = new JLabel("Tình trạng sân");
        available.setBounds(60,80,120,30);
        available.setFont(new Font("serif", Font.PLAIN,17));
        add(available);

        String[] str1 = {"Tốt","Trung bình","Xấu" };
        Javailable = new JComboBox(str1);
        Javailable.setBounds(200,80,150,40);
        add(Javailable);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);

        add = new JLabel("Loại sân");
        add.setBounds(60,130,120,30);
        add.setFont(new Font("serif", Font.PLAIN,17));
        add(add);

        String[] str2 = {"Sân nhỏ ","Sân vừa","Sân to" };
        Jtype = new JComboBox(str2);
        Jtype.setBounds(200,130,150,40);
        add(Jtype);

        price = new JLabel("Giá");
        price.setBounds(60,180,120,30);
        price.setFont(new Font("serif", Font.PLAIN,17));
        add(price);

        Jprice = new JTextField();
        Jprice.setBounds(200,180,150,30);
        add(Jprice);

        tinhtien = new JButton("Xác nhận");
        tinhtien.setBackground(Color.BLACK);
        tinhtien.setForeground(Color.WHITE);
        tinhtien.setBounds(380,280,123,40);
        tinhtien.addActionListener(this);
        add(tinhtien);

        status = new JLabel("Cho thuê");
        status.setBounds(60,220,120,30);
        status.setFont(new Font("serif", Font.PLAIN,17));
        add(status);

        String[] str3 = {"Có thể thuê","Không thể thuê"};
        Jstatus = new JComboBox(str3);
        Jstatus.setBounds(200,220,150,40);
        add(Jstatus);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/s4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(550,100,250,250);
        add(l3);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == tinhtien) {
            try {
                String stadiumnumber =(String) Jstadium.getSelectedItem();
                String availability =(String) Javailable.getSelectedItem();
                String type =(String) Jtype.getSelectedItem();
                String price = Jprice.getText();
                String status =(String) Jstatus.getSelectedItem();

                Connection_DB c = new Connection_DB();
                String query = "insert into san values('" + stadiumnumber + "','" + availability + "','" + type + "','" + price + "','" + status + "')";
                c.s.executeUpdate(query);

             /*   if (stadiumnumber.equals(stadiumnumber)) {
                    JOptionPane.showMessageDialog(null, "Đã tồn tại sân này");
                    return;
                }*/

                JOptionPane.showMessageDialog(null, "Thêm thành công");
                setVisible(false);

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddStadium();
    }
}

