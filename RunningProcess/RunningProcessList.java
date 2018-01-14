package RunningProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.ListModel;
 
public class RunningProcessList {
	public static List listRunningProcesses(){
        List processes = new ArrayList();
        //프로세스 리스트 불러오기
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
        return processes;
    }
 
    public static void DisplayRunningProcess() {
    	  List processes = listRunningProcesses();

          //중복된 이름의 프로세스는 하나만 표시
          HashSet<String> distinctData = new HashSet<String>(processes);
          processes = new ArrayList<String>(distinctData);
          String result = "";
          
          // 실행 프로세스 출력
          Iterator it = processes.iterator();
          int i = 0;
          while (it.hasNext()){
              result += it.next() + "\n";
              i++;
              if (i == 10){
                  result += "\n";
                  i = 0;
              }
          }
          System.out.printf(result);
    }
}
