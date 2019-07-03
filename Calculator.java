import java.util.Scanner;

/**Calculator functions as a basic calculator
 * @author Paul Harder
 * @author Emma Pascal
 * @author Jasmine Young */
public class Calculator {
	
	private double total; // total of the  expressions
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
			if(expr.contains(" ")) //to make parsing easier
			{
				printUsage();
			} 
			else
			{
				boolean hasPlus = expr.contains("+"); // for single operator verification
				boolean hasMinus = expr.contains("-"); // for single operator verification
				boolean hasMult = expr.contains("*"); // for single operator verification
				boolean hasDiv = expr.contains("/"); // for single operator verification
				boolean hasExpo = expr.contains("^"); // for single operator verification
				boolean hasFact = expr.contains("!"); // for single operator verification
				int operatorCount = 0; // for single operator verification
				
				// single operator verification
				if(hasPlus)
				{
					operatorCount++;
				}
				if(hasMinus)
				{
					operatorCount++;
				}
				if(hasMult)
				{
					operatorCount++;
				}
				if(hasDiv)
				{
					operatorCount++;
				}
				if(hasExpo)
				{
					operatorCount++;
				}
				if(hasFact)
				{
					operatorCount++;
				}
				
				if(operatorCount == 1)
				{
					double firstNum; // number on left of operator
					double secondNum; // number on right of operator
					double pi = Math.PI; // for ease, since it's referenced a lot
					boolean hasPI = expr.contains("pi"); // expr is scanned in using toLower, so PI, pi, Pi, and pI will all be read in as pi
					if(hasPlus)
					{
						int plusIndex = expr.indexOf('+');
						if(plusIndex == 0)
						{
							firstNum = total;
							secondNum = Double.parseDouble(expr.substring(1));
						}
						else
						{
							if(hasPI)
							{
								if(expr.indexOf("p") == 0)
								{
									firstNum = pi;
									secondNum = Double.parseDouble(expr.substring(plusIndex+1));
								}
								else
								{
									firstNum = Double.parseDouble(expr.substring(0, plusIndex));
									secondNum = pi;
								}
							}
							else
							{
								firstNum = Double.parseDouble(expr.substring(0, plusIndex));
								secondNum = Double.parseDouble(expr.substring(plusIndex+1));
							}
						}
						add(firstNum, secondNum);
					}
					else if (hasMinus)
					{
						int minusIndex = expr.indexOf('-');
						if(minusIndex == 0)
						{
							firstNum = total;
							secondNum = Double.parseDouble(expr.substring(1));
						}
						else
						{
							if(hasPI)
							{
								if(expr.indexOf("p") == 0)
								{
									firstNum = pi;
									secondNum = Double.parseDouble(expr.substring(minusIndex+1));
								}
								else
								{
									firstNum = Double.parseDouble(expr.substring(0, minusIndex));
									secondNum = pi;
								}
							}
							else
							{
								firstNum = Double.parseDouble(expr.substring(0, minusIndex));
								secondNum = Double.parseDouble(expr.substring(minusIndex+1));
							}
						}
						subtract(firstNum, secondNum);
					}
					else if(hasMult)
					{
						int multIndex = expr.indexOf('*');
						if(multIndex == 0)
						{
							firstNum = total;
							secondNum = Double.parseDouble(expr.substring(1));
						}
						else
						{
							if(hasPI)
							{
								if(expr.indexOf("p") == 0)
								{
									firstNum = pi;
									secondNum = Double.parseDouble(expr.substring(multIndex+1));
								}
								else
								{
									firstNum = Double.parseDouble(expr.substring(0, multIndex));
									secondNum = pi;
								}
							}
							else
							{
								firstNum = Double.parseDouble(expr.substring(0, multIndex));
								secondNum = Double.parseDouble(expr.substring(multIndex+1));
							}
						}
						multiply(firstNum, secondNum);
					}
					else if(hasDiv)
					{
						int divIndex = expr.indexOf('/');
						if(divIndex == 0)
						{
							firstNum = total;
							secondNum = Double.parseDouble(expr.substring(1));
						}
						else
						{
							if(hasPI)
							{
								if(expr.indexOf("p") == 0)
								{
									firstNum = pi;
									secondNum = Double.parseDouble(expr.substring(divIndex+1));
								}
								else
								{
									firstNum = Double.parseDouble(expr.substring(0, divIndex));
									secondNum = pi;
								}
							}
							else
							{
								firstNum = Double.parseDouble(expr.substring(0, divIndex));
								secondNum = Double.parseDouble(expr.substring(divIndex+1));
							}
						}
						divide(firstNum, secondNum);
					}
					else if(hasExpo)
					{
						int expoIndex = expr.indexOf('^');
						if(expoIndex == 0)
						{
							firstNum = total;
							secondNum = Double.parseDouble(expr.substring(1));
						}
						else
						{
							if(hasPI)
							{
								if(expr.indexOf("p") == 0)
								{
									firstNum = pi;
									secondNum = Double.parseDouble(expr.substring(expoIndex+1));
								}
								else
								{
									firstNum = Double.parseDouble(expr.substring(0, expoIndex));
									secondNum = pi;
								}
							}
							else
							{
								firstNum = Double.parseDouble(expr.substring(0, expoIndex));
								secondNum = Double.parseDouble(expr.substring(expoIndex+1));
							}
						}
						exponent(firstNum, secondNum);
					}
					else if(hasFact)
					{
						int factIndex = expr.indexOf('!');
						if(factIndex == 0)
						{
							firstNum = total;
						}
						else
						{
							firstNum = Double.parseDouble(expr.substring(0, factIndex));
						}
						factorial(firstNum);
					}
					else
					{
						System.out.println("Something went wrong. Did not find any operators");
					}
					expr = "";
					System.out.println("Enter a command. Enter menu for list of commands:");
				} // operatorCount if 
				else
				{
					System.out.println( "Please enter one and only one operator.");
					printUsage();
				}
			} // contains space else 
		} // try
		catch(NumberFormatException nfe)
		{
			System.out.println( expr + " is not a valid expression. Please enter digits, operators, and supported operations only.");
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
							"addition: [digit]+[digit]  OR +[digit] to use previous answer as first digit \n" +
							"subtraction: [digit]-[digit] OR -[digit] \n" +
							"multiplication: [digit]*[digit] OR *[digit] \n" +
							"division: [digit]/[digit] OR /[digit] \n" +
							"exponential: [digit]^[digit] OR ^[digit] \n" +
							"factorial: [digit]! OR ! \n" +
							"PI: Input PI in place of [digit] in one of the above operations (does not work with factorial)" +
							"Enter a command:"); // update with functionality
	}

	private void add(double first, double second)
	{
		total = (first + second);
		System.out.println(total);
	}

	private void subtract(double first, double second)
	{
		total = (first - second);
		System.out.println(total);
	}

	private void multiply(double first, double second)
	{
		total = (first * second);
		System.out.println(total);
	}
	
	private void divide(double first, double second)
	{
		total = (first / second);
		System.out.println(total); 
	}

	private void factorial(double num)
	{
		double numCount = num-1;
		double tempTotal = num;
		
		while(numCount != 0)
		{
			tempTotal = (tempTotal * numCount);
		
			numCount--;
		}
		total = tempTotal;
		System.out.println(total);
	}
	
	private void exponent(double first, double second)
	{
		total = Math.pow(first, second);
		System.out.println(total);
	}
}
