import java.util.Scanner;

/**Calculator functions as a basic calculator
 * @author Paul Harder
 * @author Emma Pascal
 * @author Jasmine Young */
public class Calculator {
	
	private double firstNum; // number on left of operator
	private double secondNum; // number on right of operator
	private double total; // total of all expressions (sets up functionality for multiple operator inputs)
	public static void main(String[] args)
	{
		new Calculator(); // create this object
	}
	
	
	/**Constructor*/
	private Calculator()
	{
		printUsage();
		Scanner scan = new Scanner(System.in);
		Boolean loopRunner = true;
		while(loopRunner)
		{
			String expr = scan.nextLine().toLowerCase();
			switch(expr)
			{
			case "clear":
				firstNum = 0;
				secondNum = 0;
				total = 0;
				break;
			case "exit":
				System.out.println("Goodbye");
				loopRunner = false;
				break;
			case "menu":
				printUsage();
				break;
			default:
				parseExpression(expr);
				break;
			}
		}
		scan.close();
	}
	
	private void parseExpression(String expr)
	{
		try {
			if(expr.contains(" ") || (!expr.contains("+") && !expr.contains("-")))
			{
				printUsage();
			}
			else
			{
				int plusIndex = expr.indexOf('+'); // sets up functionality for multiple operator inputs
				int minusIndex = expr.indexOf('-'); // sets up functionality for multiple operator inputs
				if(plusIndex == 0)
				{
					firstNum = total;
					secondNum = Double.parseDouble(expr.substring(1));
					add(firstNum, secondNum);
				}
				else if (minusIndex == 0)
				{
					firstNum = total;
					secondNum = Double.parseDouble(expr.substring(1));
					// send to subtract function
				}
				else if(minusIndex == -1)
				{
					firstNum = Double.parseDouble(expr.substring(0, plusIndex));
					secondNum = Double.parseDouble(expr.substring(plusIndex+1));
					add(secondNum, firstNum);
				}
				else if (plusIndex == -1)
				{
					firstNum = Double.parseDouble(expr.substring(0, minusIndex));
					secondNum = Double.parseDouble(expr.substring(minusIndex+1));
					// send to subtract function
				}
				else
				{
					System.out.println("Please input only one operator.");
				}
				expr = "";
				System.out.println("Enter a command. Enter menu for list of commands:");
			}
		}
		catch(NumberFormatException nfe)
		{
			System.out.println("Please enter digits, operators, and supported operations only.");
			printUsage();
		}
	}
	
	
	/**Prints the proper usage of Calculator*/
	private static void printUsage()
	{
		System.out.println("Please enter a full expression with one operator and no spaces. \n" + 
							"Current Operations Supported: \n" +
							"exit: exit program \n" +
							"clear: clear memory \n" +
							"Enter a command. Enter menu for list of commands:"); // update with functionality
	}

	private void add(double first, double second)
	{
		total = (first + second);
		System.out.println(total);
	}
}
