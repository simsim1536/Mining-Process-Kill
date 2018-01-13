package RunningProcess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
 
public class RunningProcessList {
    public static List listRunningProcesses(){
        List processes = new ArrayList();
        try{
            String line;
            Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line = input.readLine()) != null){
                if (!line.trim().equals("")){
                    // keep only the proecess name
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
          
          //�ߺ��� �̸��� ���μ��� �ϳ��� ǥ��
          HashSet<String> distinctData = new HashSet<String>(processes);
          processes = new ArrayList<String>(distinctData);
          String result = "";
          // display the result
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
    

    public static void main(String[] args){
    	DisplayRunningProcess();
    }
}
