package _Grup_17_package;

public class _Grup_17_FCFS
{
	static void waitTime(String processID[], int capacity, int burstTime[], int waitTime[])
	{
		waitTime[0] = 1;
		for (int stage = 1; stage < capacity; stage++)
		{
			waitTime[stage] = burstTime[stage - 1] + waitTime[stage - 1];
		}
	}
	static void averageWaitingTime(String processID[], int capacity, int burstTime[], int waitTime[], int averageWaitingTime[])
	{
		for (int stage = 0; stage < capacity; stage++)
		{
			averageWaitingTime[stage] = burstTime[stage] + waitTime[stage];
		}
	}
	static void FCFS(String processID[], int capacity, int burstTime[]) throws InterruptedException
	{
		int waitTime[] = new int[capacity], averageWaitingTime[] = new int[capacity];
		int totalAverageWaitingTime = 0, totalAverageTime = 0;

		waitTime(processID, capacity, burstTime, waitTime);
		averageWaitingTime(processID, capacity, burstTime, waitTime, averageWaitingTime);
		System.out.println("FCFS Simülasyonu");
		for (int stage = 0; stage < capacity; stage++)
		{
			totalAverageWaitingTime = totalAverageWaitingTime + waitTime[stage];
			totalAverageTime = totalAverageTime + averageWaitingTime[stage];
			Thread.sleep(1000);
			System.out.println(processID[stage] + " prosesi " + waitTime[stage] + ". saniyede kuyruğa girdi.");
			Thread.sleep(1000);
			System.out.println(processID[stage] + " prosesi " + waitTime[stage] + ". saniyede çalışmaya başladı.");
			Thread.sleep(1000);
			System.out.println(processID[stage] + " prosesi toplamda " + burstTime[stage] + ". saniyede çalıştı.");
		}
		System.out.printf("\n");
		float averagewaitingTime = (float)totalAverageWaitingTime /(float) capacity;
		int averageTurnTime = totalAverageTime / capacity;
		Thread.sleep(1000);
		System.out.println("Ortalama Bekleme Zamanı: "+ averagewaitingTime);
		Thread.sleep(1000);
		System.out.println("Ortlama Çalışma Zamanı: "+ averageTurnTime);
	}
}