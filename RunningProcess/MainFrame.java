package RunningProcess;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
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
	public static String name;
	JTextField selectedList = new JTextField(10);
	JLabel Label = new JLabel();
	JButton ProcsKillbtn = new JButton("프로세스 종료"); //프로세스 종료 버튼 생성자
	JButton Killbtn = new JButton("채굴 프로세스 종료"); //채굴 프로세스 종료 생성자
	FlowLayout flow = new FlowLayout();
	JPanel listPanel=new JPanel();
	JPanel labelPanel = new JPanel();
	JList list=new JList();
	JScrollPane scroll;
	Border border = BorderFactory.createTitledBorder("실행 프로세스 목록");
		
	public MainFrame()
	{
		super("Mining Process Kill");
		super.setLayout(flow);		
		
		List PROCS = PList.listRunningProcesses();
		
		//리스트에 스크롤 부착
		scroll = new JScrollPane(list);
		scroll.setBorder(border);
		scroll.setViewportView(list);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //리스트 인덱스를 한번에 한개만 선택
		list.setListData(PList.processes.toArray()); //리스트에 프로세스 목록 출력
		list.addListSelectionListener(this);
		list.setPreferredSize(new Dimension(300, 2000)); //리스트 크기 지정
		//list = new JList(PList.processes.toArray()); //리스트를 배열로 바꿔줌

		selectedList.setEditable(false); //텍스트 필드 수정 불가상태
		
		//컴포넌트에 기능 추가
		listPanel.add(scroll); //리스트 컴포넌트에 스크롤 기능 추가
		labelPanel.add(Label); //선택한 프로세스를 표시할 라벨 부착
		labelPanel.add(selectedList);
		
		Label.setText("선택한 프로세스 : ");
		selectedList.setEditable(false);
		Label.add(selectedList);
				
		add(Killbtn); //채굴 프로세스 종료 버튼
		add(ProcsKillbtn); //선택된 프로세스 종료 버튼
		add(listPanel); //프로세스 목록 출력
		add(labelPanel, BorderLayout.SOUTH); 

		//버튼 클릭시 선택된 프로세스 종료
		ProcsKillbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Kill.ProcsKill();
			}
		});
		
		//버튼 클릭시 채굴 프로세스 종료
		Killbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Kill.MiningProcsKill();
			}
		});

		//기본 프레임 셋팅
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//리스트에 출력된 프로세스 목록 중 선택된 프로세스명 얻기 
	public void valueChanged(ListSelectionEvent e)
	{
	if(!e.getValueIsAdjusting()) //마우스가 버튼 클릭 후 떼면 리스트에서 프로세스명 선택
	{
		name = (String) list.getSelectedValue();
		selectedList.setText(name);
		//System.out.print(name);

	}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}