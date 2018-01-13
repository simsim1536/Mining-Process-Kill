package RunningProcess;

import java.io.IOException;

public class ProcessKill {

	public static void main(String[] args) {
		try{
			Runtime.getRuntime().exec("taskkill /F /IM 종료할 프로세스명");
		}
		catch(IOException e)
		{
			e.printStackTrace();
	}
}
}