package MyFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.awt.AWTUtilities;

import java.awt.*;

public class Work_Rest extends JFrame implements StartFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Work_Rest() {
		 this.setUndecorated(true);
		 AWTUtilities.setWindowOpaque(this, false);
		 this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("Images/workandrest.jpg"));
		lblNewLabel.setBounds(0, 0, 860, 674);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<<\u8FD4\u56DE");
		btnNewButton.addActionListener(event->{
			this.setVisible(false);
		});
		btnNewButton.setBounds(747, 673, 113, 64);
		contentPane.add(btnNewButton);
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
					Work_Rest frame = new Work_Rest();
					frame.setTitle("作息表");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
