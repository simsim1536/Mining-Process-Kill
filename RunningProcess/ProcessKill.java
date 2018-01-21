package RunningProcess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public  class ProcessKill{

	static MainFrame Main = new MainFrame();
	static String P = "taskkill /F /IM ";

	//프로세스명에 해당하는 프로세스 종료
	public static void ProcsKill(){
		String K = (String) Main.list.getSelectedValue(); //리스트에서 선택된 프로세스명 불러오기
		String PK = P + Main.name; //프로세스 종료 명령어에 선택한 프로세스 삽입
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
	
	//채굴 프로세스 종료
	public static void MiningProcsKill(){
		String PRCS = "notepad.exe"; //채굴 프로세스명 등록
		String KillPRCS = "taskkill /F /IM "; //프로세스 종료 명령
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