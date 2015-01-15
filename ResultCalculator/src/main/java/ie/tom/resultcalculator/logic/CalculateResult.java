package ie.tom.resultcalculator.logic;

public class CalculateResult {

	public static String runCalculation(String overallIn, String needIn, String worthIn, String gotIn) {
		String output = "";		
		int total = 100;
		int overall, need, worth, got, result;
		
		overall = Integer.parseInt(overallIn);
		need = Integer.parseInt(needIn);
		worth = Integer.parseInt(worthIn);
		got = Integer.parseInt(gotIn);
		
		result = ((got * worth) / total);
		
		output += "Old Overall:\t" + overall + "/" + total + "\n";
		output += "New Overall:\t" + (result+overall) + "/" + total + "\n\n";
		output += "Exam:\t" + got + "/" + total + " = " + result + "/" + worth + "\n\n";
		if((result+overall)-need < 0) {
			output += "Need:\t" + (need-(result+overall)) + "% more\n";
		} else {
			output += "Have:\t" + ((result+overall)-need) + "% over\n";
		}
		output += "#################################################################\n";
		
		return output;		
	}
}