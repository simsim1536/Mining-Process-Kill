package RunningProcess;

import java.io.IOException;

public  class ProcessKill{

	//���μ����� �ش��ϴ� ���μ��� ����
	public static void ProcsKill(){
		try{
			Runtime.getRuntime().exec("taskkill /F /IM ���μ�����");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
		}
}