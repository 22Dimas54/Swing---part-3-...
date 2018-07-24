import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
public class MainWindow extends JFrame {

	private TutorListModel model;
	private JList<String> list;
	private JButton btnRemove;
	private JButton add_btn;
	
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
				//model.removeElement(list.getSelectedValue()); одиночное удаление
				List<String> objects = list.getSelectedValuesList();
				for(String s: objects) {
					model.removeElement(s);
				}
				list.updateUI();
			}
		});
		btnRemove.setBounds(330, 9, 89, 23);
		getContentPane().add(btnRemove);
		
		add_btn = new JButton("Add");
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog("Enter your string here:");
				model.addElement(s);
				list.updateUI();
			}
		});
		add_btn.setBounds(330, 43, 89, 23);
		getContentPane().add(add_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 310, 430);
		getContentPane().add(scrollPane);
		
		model = new TutorListModel();
		
		list = new JList<String>(model);
		scrollPane.setViewportView(list);		
		
		//setVisible(true);
		//list.updateUI();
	}

	public void addElement(String s) {
		model.addElement(s);
	}

	public void removeElement(int index) {
		model.removeElement(index);
	}
	
	public void updateUI() {
		list.updateUI();
	}
}
