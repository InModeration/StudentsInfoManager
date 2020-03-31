package MyFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DeanFrame extends JFrame implements StartFrame{

	private JPanel contentPane;

	//�ֱ��жϸ���list�Ƿ�չ��
	private boolean state=false;
	private boolean state1=false;
	private boolean state2=false;
	private boolean state3=false;

	private String ID;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public DeanFrame(String ID) {
		this.ID = ID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		this.setTitle(ID);
		contentPane = new JPanel() ;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,900,750);
		setContentPane(contentPane);
		contentPane.setLayout(null);





//添加上栏的buttons
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









		//����
		JButton btnNewButton_4 = new JButton("\u7BA1\u7406\u9009\u8BFE");//����ѡ��
		btnNewButton_4.setBounds(0, 46, 160, 42);
		contentPane.add(btnNewButton_4);
		JList list = new JList();
		list.setVisible(false);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u5BA1\u6838\u6559\u5E08\u8868", "\u5F00\u653E\u9009\u8BFE", "\u5220\u9664\u9009\u8BFE\u6761\u76EE", "\u9009\u8BFE\u516C\u544A"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(0, 89, 160, 80);
		contentPane.add(list);


		JButton btnNewButton_5 = new JButton("\u7BA1\u7406\u4FE1\u606F");
		btnNewButton_5.setBounds(0, 86, 160, 40);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u7BA1\u7406\u8003\u52A1");
		btnNewButton_6.setBounds(0, 126, 160, 40);
		contentPane.add(btnNewButton_6);
		
		JList list_1 = new JList();
		list_1.setVisible(false);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u4FEE\u6539\u5B66\u751F\u4FE1\u606F", "\u4FEE\u6539\u6559\u5E08\u4FE1\u606F", "\u4FEE\u6539\u6559\u52A1\u5458\u4FE1\u606F"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(0, 126, 160, 74);
		contentPane.add(list_1);
		
		JList list_2 = new JList();
		list_2.setVisible(false);
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u67E5\u770B\u8003\u8BD5\u5B89\u6392", "\u5B89\u6392\u8003\u8BD5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setBounds(0, 166, 160, 49);
		contentPane.add(list_2);
		btnNewButton_4.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
		btnNewButton_5.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
		btnNewButton_6.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));

		btnNewButton_4.addActionListener(event->{
			if (state==false){
				list.setVisible(true);
				btnNewButton_4.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/up.png")));
				btnNewButton_5.setLocation(btnNewButton_5.getX(),btnNewButton_5.getY()+80);
				list_1.setLocation(list_1.getX(),list_1.getY()+80);
				btnNewButton_6.setLocation(btnNewButton_6.getX(),btnNewButton_6.getY()+80);
				list_2.setLocation(list_2.getX(),list_2.getY()+80);
				state=true;
			}
			else{
				state=false;
				list.setVisible(false);
				btnNewButton_4.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
				btnNewButton_5.setLocation(btnNewButton_5.getX(),btnNewButton_5.getY()-80);
				list_1.setLocation(list_1.getX(),list_1.getY()-80);
				btnNewButton_6.setLocation(btnNewButton_6.getX(),btnNewButton_6.getY()-80);
				list_2.setLocation(list_2.getX(),list_2.getY()-80);

			}
		});
		btnNewButton_5.addActionListener(event->{
			if (state1==false){

				btnNewButton_5.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/up.png")));
				list_1.setVisible(true);
				btnNewButton_6.setLocation(btnNewButton_6.getX(),btnNewButton_6.getY()+74);
				list_2.setLocation(list_2.getX(),list_2.getY()+74);
				state1=true;
			}
			else {
				btnNewButton_5.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
				list_1.setVisible(false);
				btnNewButton_6.setLocation(btnNewButton_6.getX(),btnNewButton_6.getY()-74);
				list_2.setLocation(list_2.getX(),list_2.getY()-74);
				state1=false;
			}
		});
		btnNewButton_6.addActionListener(event->{
			if (state3==false){
				btnNewButton_6.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/up.png")));
				list_2.setVisible(true);
				state3 = true;
			}
			else {
				btnNewButton_6.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Images/down.png")));
				state3=false;
				list_2.setVisible(false);
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
					DeanFrame frame = new DeanFrame(ID);
					frame.setTitle("四川大学教务管理系统（教务员端）");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
