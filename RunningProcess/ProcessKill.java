package RunningProcess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public  class ProcessKill{

	static MainFrame Main = new MainFrame();
	static String P = "taskkill /F /IM ";

	//���μ����� �ش��ϴ� ���μ��� ����
	public static void ProcsKill(){
		String K = (String) Main.list.getSelectedValue(); //����Ʈ���� ���õ� ���μ����� �ҷ�����
		String PK = P + Main.name; //���μ��� ���� ��ɾ ������ ���μ��� ����
		System.out.print(K);
		if(Main.name != null && !Main.name.isEmpty())
		{
		try{
			Runtime.getRuntime().exec(PK);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		}
		//System.out.print(K);
	}
	
	//ä�� ���μ��� ����
	public static void MiningProcsKill(){
		String PRCS = "notepad.exe"; //ä�� ���μ����� ���
		String KillPRCS = "taskkill /F /IM "; //���μ��� ���� ���
		String MPROCS = KillPRCS+PRCS;
		try{
			Runtime.getRuntime().exec(MPROCS);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
			//System.out.print(MPROCS);	
		}
	public static void main(String[] args) {
		ProcsKill();
	}
}