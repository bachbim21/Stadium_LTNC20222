import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField Tname, Tage, Tsalary, Tphone, Tid;
    JLabel name, age, salary,phone, id,gender,job,heading;
    JRadioButton Jnu, Jnam;
    JComboBox Jjob;
    JButton sub;
    public AddEmployee() {
        super("LTNC 20222 nhom 10");
        setLayout(null);

        heading = new JLabel("Thêm nhân viên mới");
        heading.setFont(new Font("serif", Font.PLAIN,20));
        heading.setBounds(150,1,200,30);
        add(heading);

        name = new JLabel("Tên");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("serif", Font.PLAIN,17));
        add(name);

        Tname = new JTextField();
        Tname.setBounds(200,30,150,30);
        add(Tname);

        age = new JLabel("Tuổi");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("serif", Font.PLAIN,17));
        add(age);

         Tage = new JTextField();
        Tage.setBounds(200,80,150,30);
        add(Tage);

        gender = new JLabel("Giới tính");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("serif", Font.PLAIN,17));
        add(gender);

        Jnam = new JRadioButton("Nam");
        Jnam.setBounds(200,130,80,30);
        Jnam.setFont(new Font("serif", Font.PLAIN,17));
        add(Jnam);

        Jnu = new JRadioButton("Nữ");
        Jnu.setBounds(290,130,80,30);
        Jnu.setFont(new Font("serif", Font.PLAIN,17));
        add(Jnu);

        ButtonGroup group = new ButtonGroup();
        group.add(Jnam);
        group.add(Jnu);

        job = new JLabel("Công việc");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("serif", Font.PLAIN,17));
        add(job);

        String[] str = {"Lễ tân", "Lao công","Bảo vệ","Bác sĩ","Quản lý kho" };
        Jjob = new JComboBox(str);
        Jjob.setBounds(200,180,150,40);
        add(Jjob);

        salary = new JLabel("Lương");
        salary.setBounds(60,230,120,30);
        salary.setFont(new Font("serif", Font.PLAIN,17));
        add(salary);

        Tsalary = new JTextField();
        Tsalary.setBounds(200,230,150,30);
        add(Tsalary);

        phone = new JLabel("Điện thoại");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("serif", Font.PLAIN,17));
        add(phone);

        Tphone = new JTextField();
        Tphone.setBounds(200,280,150,30);
        add(Tphone);

        id = new JLabel("CCCD");
        id.setBounds(60,330,120,30);
        id.setFont(new Font("serif", Font.PLAIN,17));
        add(id);

        Tid = new JTextField();
        Tid.setBounds(200,330,150,30);
        add(Tid);

        sub = new JButton("Xác nhận");
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setBounds(290,400,123,40);
        sub.addActionListener(this);
        add(sub);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/worker1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(550,100,250,250);
        add(l3);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == sub) {
            try {
                String name = Tname.getText();
                String age = Tage.getText();
                String salary = Tsalary.getText();
                String gender = null;
                String phone = Tphone.getText();
                if (Jnu.isSelected()) {
                    gender = "Nữ";
                } else if (Jnam.isSelected()) {
                    gender = "Nam";
                }
                String job = (String) Jjob.getSelectedItem();
                String id = Tid.getText();
                if (id.equals("")) {
                    JOptionPane.showMessageDialog(null, "ID không được để trống");
                    return;
                }

                Connection_DB c = new Connection_DB();
                String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + id + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }


}
