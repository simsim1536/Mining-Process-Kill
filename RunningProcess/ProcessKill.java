package RunningProcess;

import java.io.IOException;

public  class ProcessKill{

	//���μ��� ����
	public static void ProcsKill(){
		try{
			Runtime.getRuntime().exec("taskkill /F /IM notepad.exe");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
		}
}