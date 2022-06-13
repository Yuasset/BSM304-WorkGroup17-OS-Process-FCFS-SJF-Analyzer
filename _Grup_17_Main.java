package _Grup_17_package;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _Grup_17_Main
{
	static String 
	author1="Yuşa Çağatay GÜNAYDIN", 
	author2="Mohamed Ali EL MOUBAREK";
	public static void main(String[] args) throws IOException, InterruptedException
	{
		_Grup_17_FCFS FCFS = new _Grup_17_FCFS();
		_Grup_17_SJF SJF = new _Grup_17_SJF();
		String lines;
		String[] processID;
		int burstTime[];
		int arrivalTime[];
		String fileSource = "C:/Users/YusaCagatay/Documents/Eclipse-WorkFiles/BSM304_Grup17_19210207053_19670310004/src/_Grup_17_package/prosesler.txt";
		FileReader targetFile = new FileReader(fileSource);
		BufferedReader readerFile = new BufferedReader(targetFile);

		Path path = Paths.get(fileSource);
		long capacity = Files.lines(path).count();
		processID = new String[(int)capacity];
		burstTime = new int[(int)capacity];
		arrivalTime = new int[(int)capacity];

		int index = 0;
		while ((lines = readerFile.readLine()) != null)
		{
			String[] nextSplit = lines.split(" ", 3);
			if (processID[index] == null)
			{
				processID[index] = nextSplit[0]; 
				arrivalTime[index] = Integer.parseInt(nextSplit[1]);
				burstTime[index] = Integer.parseInt(nextSplit[2]);
			}
			index++;
		}
		targetFile.close();
		
		SJF.SJF(processID, (int)capacity, arrivalTime, burstTime);
		FCFS.FCFS(processID, (int)capacity, burstTime);
		Thread.sleep(1000);
		System.out.println("\nEmeği Geçenler; "+author1+" \t"+author2);
	}
}