package MyFrame;


import Func.Enter;
import Func.Instructor;
import Func.Student;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogFrame extends JFrame implements StartFrame{

    private JPanel contentPane;
    // 用户名框
    private JTextField textField;
    // 密码框
    private JTextField textField_1;

    // 学生登录button
    private JButton btnNewButton;
    // 教师登录button
    private JButton button1;
    // 教务员登录button
    private JButton btnNewButton_1;

    //清除号码
    private JButton button;

    // 登录按钮
    private JButton btnNewButton_2;


    //通过state判断是谁在登陆
    private static int state = 1;

    // ID、password
    private String ID;
    private String password;

    /**
     * Launch the application.
     */

    public LogFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 460);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 学生登录button
        btnNewButton = new JButton("\u5B66\u751F\u767B\u9646");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                state=1;
            }
        });
        btnNewButton.setBounds(0, 196, 113, 27);
        contentPane.add(btnNewButton);

        // 教师登录button
        button1=new JButton("\u6559\u5E08\u767B\u9646");
        button1.addActionListener(event->{
            state=2;
        });
        button1.setBounds(222,196,113,27);
        contentPane.add(button1);

        // 教务员登录button
        btnNewButton_1 = new JButton("\u6559\u52A1\u5458\u767B\u9646");
        btnNewButton_1.addActionListener(event->{
            state=3;
        });
        btnNewButton_1.setBounds(111, 196, 113, 27);
        contentPane.add(btnNewButton_1);
        ImageIcon image=new ImageIcon(this.getClass().getClassLoader().getResource("Images/timg.jpg")) ;
        image.getImage().getScaledInstance(700, 196, 0);
        JLabel lable=new JLabel(image);
        lable.setBounds(-30, 0, 600, 200);
        contentPane.add(lable);
        JLabel lblid = new JLabel("ID\uFF1A");//请输入id
        lblid.setBounds(93, 242, 86, 18);
        contentPane.add(lblid);

        // 用户名框
        textField = new JTextField("请输入您的用户名...");
        textField.setBounds(185, 239, 206, 24);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel("\u5BC6\u7801\uFF1A");//请输入密码
        label.setBounds(93, 284, 99, 18);
        contentPane.add(label);

        // 密码框
        textField_1 = new JTextField("请输入您的密码...");
        textField_1.setBounds(185, 281, 206, 24);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        //清除号码
        button = new JButton("\u6E05\u9664\u53F7\u7801");
        button.setBounds(409, 238, 113, 27);
        contentPane.add(button);
        button.addActionListener(event->{
            textField.setText("");
        });

        JLabel label_1 = new JLabel("\u5FD8\u8BB0\u5BC6\u7801");//忘记密码
        label_1.setFont(new Font("瀹嬩綋", Font.BOLD, 13));
        label_1.setBounds(415, 284, 72, 18);
        contentPane.add(label_1);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 334, 582, 2);
        contentPane.add(separator_1);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 233, 582, 2);
        contentPane.add(separator);

        // 登录按钮
        btnNewButton_2 = new JButton("\u767B\u9646");
        btnNewButton_2.addActionListener(new LogActLis());
        /*btnNewButton_2.addActionListener(event -> {
            this.setVisible(false);
            // 学生登录
            if (state == 1) {
                StudentFrame frame = null;
                try {
                    frame = new StudentFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                frame.setVisible(true);
            }
            if (state == 2) {
                InstructorFrame frame = new InstructorFrame();
                frame.setVisible(true);
            }
            if (state == 3) {
                DeanFrame frame = new DeanFrame();
                frame.setVisible(true);
            }
        });*/


        btnNewButton_2.setBounds(76, 345, 113, 27);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("\u53D6\u6D88");//取消
        btnNewButton_3.addActionListener(event->{
            System.exit(0);
        });
        btnNewButton_3.setBounds(223, 345, 113, 27);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("\u6CE8\u518C");//注册
        btnNewButton_4.setBounds(385, 345, 113, 27);
        contentPane.add(btnNewButton_4);
    }

    /**
     * @return  ID and password
     */
    private String logInfo() {
        return this.ID + " " + this.password;
    }

    public void setLog() {

    }

    /**
     * listener of log on operation
     */
    final class LogActLis implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ID = textField.getText();
            password = textField_1.getText();
            // 登录失败
            if (!Enter.log(logInfo(), state))
                JOptionPane.showMessageDialog(contentPane, "用户名或密码错误！", "请重新输入！", JOptionPane.ERROR_MESSAGE);
            else {
                JOptionPane.showMessageDialog(contentPane, "登陆成功！");
                LogFrame.this.dispose();
                if (state == 1) new Student(ID);
                else if (state == 2) new Instructor(ID);
                //else new Dean(ID);
            }
        }
    }

    @Override
    public void initFrame() {
        try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);
        }
        catch(Exception e)
        {
            //TODO exception
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogFrame frame = new LogFrame();
                    frame.setTitle("四川大学教务管理系统");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public String toString() {
        return this.ID + " " + this.password;
    }
}
