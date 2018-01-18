package RunningProcess;

import java.io.IOException;

public  class ProcessKill{

	//프로세스명에 해당하는 프로세스 종료
	public static void ProcsKill(){
		try{
			Runtime.getRuntime().exec("taskkill /F /IM 프로세스명");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
		}
}