package RunningProcess;

import java.io.IOException;

public  class ProcessKill{

	static MainFrame Main = new MainFrame();

	//프로세스명에 해당하는 프로세스 종료
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

	//채굴 프로세스 종료
	public static void MiningProcsKill(){
	try{
		Runtime.getRuntime().exec("taskkill /F /IM 프로세스명");
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}	
	}
}