import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    public Dashboard() {

        super("LTNC 20222 nhom 10");
        setBounds(0,0,1550,1000);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/s4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("Quản lý sân bóng đá");
        text.setBounds(400,80,1000,60);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN,50));
        image.add(text);

        JMenuBar menu = new JMenuBar();
        menu.setBounds(0,0,1550,30);
        image.add(menu);

        JMenu stadium = new JMenu("Quản lý sân");
        stadium.setForeground(Color.GREEN);
        menu.add(stadium);

        JMenuItem themSanMoi = new JMenuItem("Mở rộng");
        themSanMoi.addActionListener(this);
        stadium.add(themSanMoi);

        JMenu admin = new JMenu("Thêm");
        admin.setForeground(Color.RED);
        menu.add(admin);

        JMenuItem themNguoiDatSan = new JMenuItem("Thêm sân mới");
        themNguoiDatSan.addActionListener(this);
        admin.add(themNguoiDatSan);

        JMenuItem themNguoiPhucVu = new JMenuItem("Thêm nhân viên");
        themNguoiPhucVu.addActionListener(this);
        admin.add(themNguoiPhucVu);



        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Thêm nhân viên")){
            new AddEmployee();
        }
        else if (actionEvent.getActionCommand().equals("Thêm sân mới")){
            new AddStadium();
        }
        else if (actionEvent.getActionCommand().equals("Mở rộng")){
            new SecondDashboard();
        }

    }
    public static void main(String[] args) {
        new Dashboard();
    }


}
