import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RobotInterface {

	private JFrame frmRobotInterface;
	private DefaultListModel<Robot> listModel;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotInterface window = new RobotInterface();
					window.frmRobotInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRobotInterface = new JFrame();
		frmRobotInterface.setTitle("Robot Interface");
		frmRobotInterface.setBounds(100, 100, 850, 300);
		frmRobotInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRobotInterface.getContentPane().setLayout(null);
		
		listModel = new DefaultListModel<Robot>();
		list = new JList(listModel);
		list.setBounds(186, 11, 621, 239);
		frmRobotInterface.getContentPane().add(list);
		
		JButton btnCreateARobot = new JButton("Create a Robot");
		btnCreateARobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				String name = (String) JOptionPane.showInputDialog(
						frmRobotInterface,
						"What is the Robots's name?",
						"Name", JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"");
				String x = (String) JOptionPane.showInputDialog(
						frmRobotInterface,
						"What is the Robot's x coordinate?",
						"X Position", JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"");
				int positionX = Integer.parseInt(x);
				String y = (String) JOptionPane.showInputDialog(
						frmRobotInterface,
						"What is the Robot's y coordinate?",
						"Y Position", JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"");
				int positionY = Integer.parseInt(y);
				int speed = (int)getPositiveValue("How fast is the Robot moving?", "Speed");
				String[] directions = {
						"West",
						"North",
						"East",
						"South"
				};
				int orientation;
				int direction_index = JOptionPane.showOptionDialog(null, "What direction is the Robot facing?", "Orientation", 0, JOptionPane.QUESTION_MESSAGE, null, directions, 0);
				if(direction_index == 0)
				{
					orientation = 0;
				} else if(direction_index == 1) 
				{
					orientation = 90;
				} else if(direction_index == 2)
				{
					orientation = 180;
				} else
				{
					orientation = 270;
				}
				
				Robot r = new Robot(name, positionX, positionY, speed, orientation);
				listModel.add(listModel.size(), r);
						
			}
		});
		btnCreateARobot.setBounds(10, 11, 149, 23);
		frmRobotInterface.getContentPane().add(btnCreateARobot);
		
		JButton btnNewButton = new JButton("Move a Robot");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selected = list.getSelectedIndex();
				if (selected < 0) 
				{
					JOptionPane.showMessageDialog(frmRobotInterface, "Please select a Robot.");
				} else {
					int movement = (int)getPositiveValue("How far do you want the Robot to move?", "Move A Robot");
					listModel.get(selected).moveRobot(movement);
				}
				
			}
		});
		btnNewButton.setBounds(10, 49, 149, 23);
		frmRobotInterface.getContentPane().add(btnNewButton);
		
		JButton btnRotateARobot = new JButton("Rotate a Robot");
		btnRotateARobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selected = list.getSelectedIndex();
				if (selected < 0) 
				{
					JOptionPane.showMessageDialog(frmRobotInterface, "Please select a Robot.");
				} else {
					String[] rotations = {
							"Left",
							"Right"
					};
					int rotation_index = JOptionPane.showOptionDialog(null, "Do you want to rotate the Robot left or right?", "Rotation", 0, JOptionPane.QUESTION_MESSAGE, null, rotations, 0);
					int rotation;
					if (rotation_index == 0)
					{
						rotation = -90;
					} else {
						rotation = 90;
					}
					listModel.get(selected).rotateRobot(rotation);
				}
			}
		});
		btnRotateARobot.setBounds(10, 90, 149, 23);
		frmRobotInterface.getContentPane().add(btnRotateARobot);
		
		JButton btnCompareDistance = new JButton("Compare distance");
		btnCompareDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				if (selected < 0) 
				{
					JOptionPane.showMessageDialog(frmRobotInterface, "Please select a Robot.");
				} else {
					int otherIndex = (int)getPositiveValue("Please enter the index of the other Robot i.e.(0, 1, 2...)", "Compare distance");
					double ans = listModel.get(selected).distanceFromOther(listModel.get(otherIndex));
					JOptionPane.showMessageDialog(frmRobotInterface, "The distance between the Robots is " + ans);
				}
			}
		});
		btnCompareDistance.setBounds(10, 129, 149, 23);
		frmRobotInterface.getContentPane().add(btnCompareDistance);
	}
	
	private double getPositiveValue(String prompt, String title)
	{
		String s = (String)JOptionPane.showInputDialog(
				frmRobotInterface,
				prompt,
				title, JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"");
		double sint = Double.parseDouble(s);
		while(sint < 0)
		{
			s = (String)JOptionPane.showInputDialog(
					frmRobotInterface,
					prompt + "(Please enter a positive value)",
					title, JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					"");
			sint = Double.parseDouble(s);
		}
		return sint;
	}
}
