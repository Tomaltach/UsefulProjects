package ie.tom.resultcalculator.logic;

import java.text.DecimalFormat;

public class CalculateResult {

	public static String runCalculation(String overallIn, String needIn, String worthIn, String gotIn) {
				
		double total = 100;
		double overall, need, worth, got;
		try {
			overall = Double.parseDouble(overallIn);
			need = Double.parseDouble(needIn);
			worth = Double.parseDouble(worthIn);
			got = Double.parseDouble(gotIn);
		} catch(Exception e) {
			return "Must enter a number";
		}
		
		if(overall < 0 || overall > 100 || need < 0 || need > 100 || worth < 0 || worth > 100 || got < 0 || got > 100) {
			return "Number must be between 0-100\n";
		} else if((overall+worth) > total) {
			return "Overall percent and Overall worth cannot go above 100\n";
		} else {		
			if(got == 0) {			
				return calcWhatisNeededInExam(total, overall, need, worth, got);
			} else {		
				return calcNewOverallGrade(total, overall, need, worth, got);	
			}
		}
	}
	private static String calcWhatisNeededInExam(double total, double overall, double need, double worth, double got) {
		String output = "";
		double resultOverall;
		double resultTest;
				
		resultTest = (((need-overall) * total) / worth);
		if(resultTest > 100) {
			resultTest = 100;
		}
		resultOverall = ((resultTest * worth) / total);
		if(resultOverall > worth) {
			System.out.println(resultOverall);
			resultOverall = worth;
		}
		
		output += "Exam:\t" + new DecimalFormat("#.##").format(resultTest) + 
				"/" + total + " = " + new DecimalFormat("#.##").format(resultOverall) + "/" + worth + "\n";
		
		output += "#################################################################\n";
		return output;
	}
	private static String calcNewOverallGrade(double total, double overall, double need, double worth, double got) {
		String output = "";
		double result;
		
		result = ((got * worth) / total);
		
		output += "Old Overall:\t" + overall + "/" + total + "\n";
		output += "New Overall:\t" + (result+overall) + "/" + total + "\n\n";
		output += "Exam:\t" + got + "/" + total + " = " + result + "/" + worth + "\n\n";
		if((result+overall)-need < 0) {
			output += "Need:\t" + (need-(result+overall)) + "% more\n";
		} else if((result+overall)-need > 0) {
			output += "Have:\t" + ((result+overall)-need) + "% over\n";
		}
		else {
			output += "Just made even\n";
		}
		output += "#################################################################\n";
		return output;
	}
}