package RunningProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.ListModel;
 
public class RunningProcessList {
	

    public static List processes = new ArrayList();

	public static List listRunningProcesses(){
        //���μ��� ����Ʈ �ҷ�����
        try{
            String line;
            Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line = input.readLine()) != null){
                if (!line.trim().equals("")){
                    processes.add(line.substring(0, line.indexOf(" ")));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //�ߺ��� �̸��� ���μ��� �ϳ��� ǥ��
        HashSet<String> distinctData = new HashSet<String>(processes);
        processes = new ArrayList<String>(distinctData);
        return processes;
    }
}
