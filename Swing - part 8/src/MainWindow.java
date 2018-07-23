import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private TutorListModel model;
	private JList<String> list;
	private JButton btnRemove;
	
	public MainWindow() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640,480);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.removeElement(list.getSelectedValue());
			}
		});
		btnRemove.setBounds(330, 9, 89, 23);
		getContentPane().add(btnRemove);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 310, 430);
		getContentPane().add(scrollPane);
		
		model = new TutorListModel();
		
		list = new JList<String>(model);
		scrollPane.setViewportView(list);		
		

	}

	public void addElement(String s) {
		model.addElement(s);
	}

	public void removeElement(int index) {
		model.removeElement(index);
	}
}
