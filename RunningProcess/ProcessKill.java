package RunningProcess;

import java.io.IOException;

public  class ProcessKill{

	static MainFrame Main = new MainFrame();

	//���μ����� �ش��ϴ� ���μ��� ����
	public static void ProcsKill(){
		//String P=Main.name;
		String K = "taskkill /F /IM notepad.exe";
		//String PK = P + K;
		try{
			Runtime.getRuntime().exec(K);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
		}

	//ä�� ���μ��� ����
	public static void MiningProcsKill(){
	try{
		Runtime.getRuntime().exec("taskkill /F /IM ���μ�����");
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}	
	}
}