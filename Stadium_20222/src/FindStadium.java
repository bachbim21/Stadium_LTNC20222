import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FindStadium extends JFrame implements ActionListener {
    JTable t1;
    JButton sub;
    JComboBox Jfilter;
    JCheckBox available1;
    JLabel list,stadium,availble,type,money,status,filter;
    FindStadium(){
        super("LTNC 20222 nhom 10");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        list = new JLabel("Tìm sân theo yêu cầu");
        list.setBounds(150,1,500,50);
        add(list);

        filter = new JLabel("Loại sân");
        filter.setBounds(60,80,120,30);
        filter.setFont(new Font("serif", Font.PLAIN,17));
        add(filter);

        String[] str = {"Sân nhỏ ","Sân vừa","Sân to" };
        Jfilter = new JComboBox(str);
        Jfilter.setBounds(200,80,150,40);
        add(Jfilter);

        available1 = new JCheckBox("Chỉ chọn sân có thể thuê");
        available1.setBounds(400,80,250,40);
        add(available1);

        stadium = new JLabel("Sân");
        stadium.setBounds(10,140,500,50);
        add(stadium);

        availble = new JLabel("Tình trạng sân");
        availble.setBounds(105,140,500,50);
        add(availble);

        type = new JLabel("Loại sân");
        type.setBounds(215,140,500,50);
        add(type);

        money = new JLabel("Giá");
        money.setBounds(310,140,500,50);
        add(money);

        status = new JLabel("Cho thuê");
        status.setBounds(420,140,500,50);
        add(status);

        t1 = new JTable();
        t1.setBounds(10,180,500,400);
        add(t1);

        try{
            Connection_DB c = new Connection_DB();
            String query = "select * from san" ;
            ResultSet resultSet = c.s.executeQuery(query);
            t1.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        sub = new JButton("Xác nhận");
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setBounds(300,20,123,30);
        sub.addActionListener(this);
        add(sub);

        setBounds(350,200,1000,570);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == sub) {
            try {
                String choice = null;
                if (available1.isSelected()){
                    choice = "Có thể thuê" ;
                    Connection_DB c = new Connection_DB();
                    String query = "select * from san where type = '"+Jfilter.getSelectedItem()+"' and status = '"+choice+"' " ;
                    ResultSet resultSet = c.s.executeQuery(query);
                    t1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }else {
                    Connection_DB c = new Connection_DB();
                    String query = "select * from san where type = '"+Jfilter.getSelectedItem()+"'" ;
                    ResultSet resultSet = c.s.executeQuery(query);
                    t1.setModel(DbUtils.resultSetToTableModel(resultSet));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FindStadium();
    }
}

