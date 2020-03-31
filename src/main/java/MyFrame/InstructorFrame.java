package MyFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InstructorFrame extends JFrame implements StartFrame{

	private JPanel contentPane;
	private boolean state=false;

	private String ID;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public InstructorFrame(String ID) {
		this.ID = ID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		this.setTitle(ID);
		contentPane = new JPanel() ;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,900,750);
		setContentPane(contentPane);
		contentPane.setLayout(null);





//娣诲姞涓婃爮鐨刡uttons
		JButton btnNewButton = new JButton("scu_educational management system");
		btnNewButton.setFont(new Font("Bookman Old Style", Font.ITALIC, 18));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 0, 372, 49);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u4F5C\u606F\u8868");
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

		JButton btnNewButton_2 = new JButton("\u6B22\u8FCE\u56DE\u6765\uFF0C\u5B66\u751F\u540D\u5B57");
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









		JButton btnNewButton_4 = new JButton("\u67E5\u770B\u6559\u5E08\u8BFE\u8868");
		btnNewButton_4.setBounds(0, 47, 160, 40);
		btnNewButton_4.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/table.png")));
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u5F55\u5165\u6210\u7EE9");
		btnNewButton_5.setBounds(0, 86, 160, 40);
		contentPane.add(btnNewButton_5);
		
		JList list = new JList();
		list.setVisible(false);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u5F55\u5165\u8BFE\u7A0B\u6210\u7EE9", "\u5F55\u5165\u8003\u8BD5\u6210\u7EE9"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(0, 125, 160, 58);
		contentPane.add(list);

		btnNewButton_5.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
		btnNewButton_5.addActionListener(event->{
			if (state==false){
				btnNewButton_5.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/up.png")));
				state=true;
				list.setVisible(true);
			}
			else {
				btnNewButton_5.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
				state=false;
				list.setVisible(false);
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
					InstructorFrame frame = new InstructorFrame(ID);
					frame.setTitle("四川大学教务管理系统（教师端）");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
