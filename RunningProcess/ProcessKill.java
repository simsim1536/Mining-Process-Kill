package RunningProcess;

import java.io.IOException;

public class ProcessKill {

	public static void main(String[] args) {
		try{
			Runtime.getRuntime().exec("taskkill /F /IM ������ ���μ�����");
		}
		catch(IOException e)
		{
			e.printStackTrace();
	}
}
}