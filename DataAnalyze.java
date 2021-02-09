package DataAnalyze1;

import java.util.Scanner;

public class DataAnalyze {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Please Enter the Sample Size: ");
		int sampSize = input.nextInt();
		int triSize = 4;
		
		int[] average = new int [triSize];
		int[] total = new int[triSize];
		int[] data = new int[sampSize * triSize];

		int j = 0;
		int i = 0;

		for (i=0;i <triSize;i++)
		{
			System.out.println("Enter numbers for Trial " + i);

			for (j=0;j<sampSize;j++)
			{
				System.out.print("Enter Sample #" + j + ": ");
				data[j* triSize + i] = input.nextInt();
				total[i] += data[j* triSize + i];
			}

		}

		for (i=0; i<triSize; i++)
			average[i] = total[i] / sampSize;

		int Min = average[0];
		int Max = average[0];

		for (i=0; i<triSize; i++)
		{
			if (average[i]< Min)
				Min = average[i];
			if (average[i]> Max)
				Max = average[i];
		}

		System.out.println("\n\tSample #\t Trial 1\t Trial 2\t Trial 3\t Trial 4");

		for (j=0;j<sampSize; j++)
		{
			System.out.print("\t" + j + "\t\t");

			for (i=0; i < triSize; i++)
			{
				System.out.print("\t" + data[j* triSize + i] + "\t");

			}
			System.out.print("\n");
		}
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.print("Averages \t\t\t");

		for (i=0; i<triSize; i++)
			System.out.print((double)average[i] + "\t\t");
		System.out.print("\n\n");
		System.out.println("Min average " + ": " + (double)Min);
		System.out.println("Max average " + ": " + (double)Max);
		System.out.println("\n");

		if (Min == Max)
			System.out.println("The trials match EXACTLY!");
			else if (Max < Min * 2)
			System.out.println("The trials concur with each other!");
			else 
			System.out.println("The trials do NOT concur!");
	}
}