package com.bayviewglen.club;

import java.util.Scanner;

public class CrossCountryAssignmentRevised {
	
	// initialize constant
	private static final int SECONDS_IN_MINUTE = 60;
	
	// method to convert formatted time string into seconds (double)
	
	private static double convertFormattedTimeToSeconds(String time) {
		
		String minutesString = time.substring(0,time.indexOf(':'));
		String secondsString = time.substring(time.indexOf(':')+1);
		
		// convert to seconds 
		
		double unformattedTime = Double.parseDouble(minutesString) * SECONDS_IN_MINUTE + Double.parseDouble(secondsString);
		return unformattedTime;
		
		}
	
	private static String convertSecondsintoFormattedTime(double unformattedTime) {
		
		//extract minutes
		int minutes = (int) (unformattedTime / 60);
		double remTime = unformattedTime - minutes * 60;
		//extract seconds
		int seconds = (int) remTime;
		remTime = remTime - seconds;
		//extract milliseconds
		int milliSeconds = (int)(remTime * 1000 + .49999);
		//format time and return it
		return minutes + ":" + seconds + "." + milliSeconds;
		
	}
	
	public static void main(String[] args) {
		
		//initialize for loop iteration variables
		int i = 0;
		int n = 0;
		
		//create unidimensional array for name
		String[] name = new String[5];
		//create two dimensional array for time
		String[][] time = new String[5][3];
		//create two dimensional array for time converted to seconds
		double[][] timeDouble = new double[5][3];
		
		//create unidimensional array which stores the three interval names
		String marker[] = new String[3];
		marker[0] = "mile one";
		marker[1] = "mile two";
		marker[2] = "end of five kilometres";
		
		//initialize scanner to prompt user for information
		Scanner keyboard = new Scanner (System.in);
		
		//create nested for loops to populate the array variables
		for(i = 0; i< 5; i++) {
			
			System.out.println("Please enter runner " + (i + 1) + "'s name");
			name[i] = keyboard.nextLine();
			
			for(n = 0; n< 3; n++) {
				
				System.out.println("Please enter " + name[i] + "'s time to " + (marker[n])); 
				time[i][n] = keyboard.nextLine();
				timeDouble[i][n] = convertFormattedTimeToSeconds(time[i][n]);
				
			}
			
			// print summary to console
			System.out.println("Summary for " + name[i] + " :"); 
			System.out.printf("%-15s %-15s %-15s %15s %n", "Split One Time", "Split Two Time",  "Split Three Time", "Overall Time");
			System.out.printf("%-15s %-15s %-15s %15s %n", time[i][0], convertSecondsintoFormattedTime(timeDouble[i][1] - timeDouble[i][0]),  convertSecondsintoFormattedTime(timeDouble[i][2] - timeDouble[i][1]), time[i][2]);	
			
		}
		                   
		System.out.println("-------------------------------FINAL RESULTS------------------------------------");
		System.out.printf("%-15s %-15s %-15s %-15s %15s %n", "Full Name", "Split One Time", "Split Two Time",  "Split Three Time", "Overall Time");
		
		// print results for all athletes
		for(i = 0; i< 5; i++) {
				System.out.printf("%-15s %-15s %-15s %-15s %15s %n", name[i], time[i][0], convertSecondsintoFormattedTime(timeDouble[i][1] - timeDouble[i][0]),  convertSecondsintoFormattedTime(timeDouble[i][2] - timeDouble[i][1]), time[i][2]);
		}
		keyboard.close();
	}	
}
		


