package _Grup_17_package;

public class _Grup_17_SJF
{
	static void waitTime(int capacity, int arrivalTime[], int burstTime[], int waitTime[], int completeTime[], int turnAroundTime[])
	{
		int startTime = 1;
		for (int stage = 0; stage < capacity; stage++)
		{
			completeTime[stage] = startTime + burstTime[stage];
			startTime = startTime + burstTime[stage];
			turnAroundTime[stage] = completeTime[stage] - arrivalTime[stage];
			waitTime[stage] = turnAroundTime[stage] - burstTime[stage];
		}
	}
	public static void SJF(String processID[], int capacity, int arrivalTime[], int burstTime[]) throws InterruptedException
	{
		int completeTime[] = new int[capacity];
		int turnAroundTime[] = new int[capacity];
		int waitTime[] = new int[capacity];
		int totalTrunTime = 0;
		float averageWaitingTime = 0;
		float averageturnAroundTime = 0;

		waitTime(capacity, arrivalTime, burstTime, waitTime, completeTime, turnAroundTime);
		System.out.println("SJF(non-preemptive) Simülasyonu");
		for(int step = 0; step < capacity; step++)
		{
			averageWaitingTime = averageWaitingTime + waitTime[step];
			averageturnAroundTime = averageturnAroundTime + turnAroundTime[step];
			totalTrunTime = waitTime[step] + burstTime[step];
			Thread.sleep(1000);
			System.out.println(processID[step]+" prosesi "+arrivalTime[step]+" Saniyede kuyruğa girdi.");
			Thread.sleep(1000);
			System.out.println(processID[step]+" prosesi "+totalTrunTime+" Saniyede çalışmaya başladı.");
			Thread.sleep(1000);
			System.out.println(processID[step]+" prosesi toplamda "+burstTime[step]+" saniye çalıştı.");
		}
		for(int step = 0; step < capacity; step++)
		{
			System.out.print(processID[step]+" "+waitTime[step]+" saniye, ");
		}
		Thread.sleep(1000);
		System.out.println("\nOrtalama Bekleme Süresi: "+ (float)(averageWaitingTime / capacity));
	}
}