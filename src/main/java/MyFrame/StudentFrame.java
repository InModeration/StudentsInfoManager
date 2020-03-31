package MyFrame;

import Func.Student;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class StudentFrame extends JFrame implements StartFrame{

	// create the Student object
	private Student student = null;

	// 左侧目录panel
	private JPanel contentPane;
	// 显示相关信息panel
	private JPanel infoPanel;

	// "作息表"按钮
	JButton btnNewButton_1 = null;
	// 用于打印信息的按钮
	JButton btnNewButton = null;
	// 打印提示语的按钮
	JButton btnNewButton_2 = null;
	// “查看学籍细信息”按钮
	JButton btnNewButton_4 = null;
	// “查询成绩”按钮
	JButton btnNewButton_5 = null;

	private boolean state=false;
	private boolean state1=true;

	private String ID;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public StudentFrame(String ID, Student student) {

		// initialize the Student by the ID
		this.student = student;

		this.ID = ID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		this.setTitle("ID");
		contentPane = new JPanel() ;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,900,750);
		setContentPane(contentPane);
		contentPane.setLayout(null);



		// 用于打印信息的按钮
		btnNewButton = new JButton("scu_educational management system");
		btnNewButton.setFont(new Font("Bookman Old Style", Font.ITALIC, 18));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 0, 372, 49);
		contentPane.add(btnNewButton);

		// “作息表”按钮
		btnNewButton_1 = new JButton("\u4F5C\u606F\u8868");
		btnNewButton_1.setFont(new Font("????", Font.PLAIN, 17));
		btnNewButton_1.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/clock.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Work_Rest frame=new Work_Rest();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(516, 1, 122, 48);
		contentPane.add(btnNewButton_1);

		// 打印提示语的按钮
		btnNewButton_2 = new JButton("\u6B22\u8FCE\u56DE\u6765\uFF0C" + student.getName());
		btnNewButton_2.setFont(new Font("????", Font.PLAIN, 17));
		btnNewButton_2.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/user.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(635, 1, 211, 48);
		contentPane.add(btnNewButton_2);

		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String time=sdf.format(date);
		JButton btnNewButton_3 = new JButton(time);
		btnNewButton_3.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/calendar.png")));
		btnNewButton_3.setBounds(369, 1, 152, 49);
		contentPane.add(btnNewButton_3);

		// “查看学籍信息”按钮
		btnNewButton_4 = new JButton("\u67E5\u770B\u5B66\u7C4D\u4FE1\u606F");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/user.png")));
		btnNewButton_4.setBounds(0, 46, 160, 42);
		contentPane.add(btnNewButton_4);

		// “查询成绩”按钮
		btnNewButton_5 = new JButton("\u67E5\u8BE2\u6210\u7EE9");
		btnNewButton_5.addActionListener(event-> {
			//String id=this.getTitle();
//			//printWriter.println(id);
//			//printWriter.flush();
//			String[][] results=new String[100][100];
//
//			for (int i=0;i<2;i++){
//				if (!in.hasNextLine())break;
//				for (int j=0;j<4;j++){
//					results[i][j]=in.nextLine();
//					}
//				}
//
//			JTable table_2 = new JTable();
//			table_2.setModel(new DefaultTableModel(results,
//					new String[] {
//							"course_id", "course_name", "grade", "GPA"
//					}));
//
//			JScrollPane jsp=new JScrollPane(table_2);
//			jsp.setBounds(268, 200, 468, 190);
//			contentPane.add(jsp);
//

		});
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
	    btnNewButton_5.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/table.png")));
		btnNewButton_5.setBounds(0, 87, 160, 42);
		contentPane.add(btnNewButton_5);

		JList<String> list = new JList<String>();

		list.setListData(new String[] {"\u641C\u7D22\u8BFE\u7A0B", "\u9000\u8BFE", "\u67E5\u770B\u9009\u8BFE\u7ED3\u679C"});
		list.setBounds(0, 166, 160, 85);
		contentPane.add(list);
		list.setVisible(false);

		JButton btnNewButton_6 = new JButton("\u9009\u8BFE\u7BA1\u7406");
		btnNewButton_6.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
		JButton btnNewButton_7 = new JButton("\u67E5\u770B\u8003\u8BD5\u6210\u7EE9");
		btnNewButton_7.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_7.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/picture.png")));
		btnNewButton_7.setBounds(0, 163, 160, 42);
		contentPane.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("\u67E5\u770B\u5B66\u751F\u8BFE\u8868");
		btnNewButton_8.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_8.setBounds(0, 205, 160, 42);
		btnNewButton_8.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/calendar.png")));
		contentPane.add(btnNewButton_8);
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 261, 56, 2);
		contentPane.add(separator);

		JLabel lblNewLabel = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("Images/left.png")));
		lblNewLabel.setBounds(43, 256, 72, 18);
		contentPane.add(lblNewLabel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(106, 261, 56, 2);
		contentPane.add(separator_1);
		btnNewButton_6.addActionListener(event->{
			if(!state) {
				list.setVisible(true);
				btnNewButton_6.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/up.png")));
				btnNewButton_7.setLocation(0, 248);
				btnNewButton_8.setLocation(0, 290);
				separator.setLocation(0,346);
				separator_1.setLocation(106,346);
				lblNewLabel.setLocation(43, 341);
				state=true;
			}
			else {
			list.setVisible(false);
			btnNewButton_6.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
			btnNewButton_7.setLocation(0, 163);
			btnNewButton_8.setLocation(0, 205);
			separator.setLocation(0,261);
			separator_1.setLocation(106,261);
			lblNewLabel.setLocation(43, 256);
			state=false;
			}

		});
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setBounds(0, 126, 160, 42);
		contentPane.add(btnNewButton_6);
		lblNewLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO ??????????????

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO ??????????????

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO ??????????????

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO ??????????????

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO ??????????????
				if(state1){

					btnNewButton_4.setSize(32,42);
					btnNewButton_5.setSize(32,42);
					btnNewButton_6.setSize(32,42);
					btnNewButton_7.setSize(32,42);
					btnNewButton_8.setSize(32,42);
					lblNewLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/right.png")));
					btnNewButton_7.setLocation(0,163);
					btnNewButton_8.setLocation(0,205);
					separator.setSize(10,2);
					separator_1.setBounds(40, 261, 10, 5);
					lblNewLabel.setLocation(-10,256);
					list.setVisible(false);
					state1=false;
				}
				else{

					btnNewButton_4.setSize(160,42);
					btnNewButton_5.setSize(160,42);
					btnNewButton_6.setSize(160,42);
					btnNewButton_7.setSize(160,42);
					btnNewButton_8.setSize(160,42);
					separator.setBounds(0, 261, 56, 2);
					separator_1.setBounds(106, 261, 56, 2);
					lblNewLabel.setBounds(43, 256, 72, 18);
					lblNewLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/left.png")));
					state1=true;

				}
			}
		});
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
					StudentFrame frame = new StudentFrame(ID, student);
					frame.setTitle("四川大学教务管理系统(学生端）");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

