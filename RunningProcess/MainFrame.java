package RunningProcess;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MainFrame extends JFrame {

	RunningProcessList WU = new RunningProcessList();
	
	static ArrayList<String> procsToClose = new ArrayList<String>();
	static ArrayList<String> openedProcs = new ArrayList<String>();
	
	JList list = new JList();
	
	JButton ProcsKill = new JButton("프로세스 종료");
	FlowLayout flow = new FlowLayout();
	
	public void closeProcs() {

		System.out.println("Killing Processes:");
		
		for (int i = 0; i < procsToClose.size() - 1; i++) {
			for (int j = 0; j < openedProcs.size(); j++) {
				if (openedProcs.get(j).contains(procsToClose.get(i))) {

					try {
						Runtime.getRuntime().exec("taskkill /F /IM" + " " + procsToClose.get(i) + ".exe");
					} catch (IOException e) {
						System.out.println("Error!");
					}

					System.out.println(procsToClose.get(i)+".exe " + "- Killed!");

				}
				{
				}
			}
		}
	}
	
	public MainFrame()
	{
		super("Mining Process Kill");
		super.setLayout(flow);		
		
		add(ProcsKill);
		ProcsKill.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				closeProcs();
			}
		});
		
		//list.setListData(WU.DisplayRunningProcess());
		
		add(new JScrollPane(list),"Center");
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//list.setListData(listStr);
		
		setSize(300, 400);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
	}
	public static void main(String[] args) {
		new MainFrame();
	}

}