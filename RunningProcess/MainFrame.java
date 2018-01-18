package RunningProcess;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame implements ListSelectionListener {

	ProcessKill Kill = new ProcessKill();
	static RunningProcessList PList = new RunningProcessList();
	
	
	static ArrayList<String> procsToClose = new ArrayList<String>();
	static ArrayList<String> openedProcs = new ArrayList<String>();

	JTextField selectedList = new JTextField(10);
	JLabel Label = new JLabel();
	JButton ProcsKillbtn = new JButton("���μ��� ����");
	JButton Killbtn = new JButton("ä�� ���μ��� ����");
	FlowLayout flow = new FlowLayout();
	JPanel listPanel=new JPanel();
	JPanel labelPanel = new JPanel();
	JList list=new JList();
	JScrollPane scroll;
	Border border = BorderFactory.createTitledBorder("���μ��� ���");
	String[] names = {"���μ��� ���"};
	
 static Iterator IM = PList.processes.iterator();
	
	public MainFrame()
	{
		
		super("Mining Process Kill");
		super.setLayout(flow);		
		
		List PROCS = PList.listRunningProcesses();
		
		//��ư Ŭ���� ���õ� ���μ��� ����
		Killbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Kill.ProcsKill();
			}
		});
		
		scroll = new JScrollPane(list);
		scroll.setBorder(border);
		scroll.setViewportView(list);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //����Ʈ �ε����� �ѹ��� �Ѱ��� ����
		list.setListData(PList.processes.toArray()); //����Ʈ�� ���μ��� ��� ���
		list.addListSelectionListener(this);
		list.setPreferredSize(new Dimension(300, 2000)); //����Ʈ ũ�� ����
		list = new JList(PList.processes.toArray()); //����Ʈ�� �迭�� �ٲ���

		
		//������Ʈ�� ��� �߰�
		listPanel.add(scroll); //����Ʈ ������Ʈ�� ��ũ�� ��� �߰�
		labelPanel.add(Label);
		
		Label.setText("������ ���μ��� : ");
		Label.add(selectedList);
		
		add(Killbtn); //ä�� ���μ��� ���� ��ư
		add(ProcsKillbtn); //���õ� ���μ��� ���� ��ư
		add(listPanel); //���μ��� ��� ���
		add(labelPanel); 


		selectedList.setEditable(false);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void valueChanged(ListSelectionEvent e)
	{
		String name = (String) list.getSelectedValue();
		selectedList.setText(name);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}