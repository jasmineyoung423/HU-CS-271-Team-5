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
			if(expr.contains(" "))
			{
				printUsage();
			}
			else
			{
				int plusIndex = expr.indexOf('+'); // sets up functionality for multiple operator inputs
				int minusIndex = expr.indexOf('-'); // sets up functionality for multiple operator inputs
				int multiplyIndex = expr.indexOf('*');
				int divideIndex = expr.indexOf('/');
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
					subtract(firstNum, secondNum);
				}
				else if (multiplyIndex == 0)
				{
					firstNum = total;
					secondNum = Double.parseDouble(expr.substring(1));
					multiply(firstNum, secondNum);
				}
				else if (divideIndex == 0)
				{
					firstNum = total;
					secondNum = Double.parseDouble(expr.substring(1));
					divide(firstNum, secondNum);
				}
				else if(minusIndex == -1 && multiplyIndex == -1 && divideIndex == -1)
				{
					firstNum = Double.parseDouble(expr.substring(0, plusIndex));
					secondNum = Double.parseDouble(expr.substring(plusIndex+1));
					add(firstNum, secondNum);
				}
				else if (plusIndex == -1 && multiplyIndex == -1 && divideIndex == -1)
				{
					firstNum = Double.parseDouble(expr.substring(0, minusIndex));
					secondNum = Double.parseDouble(expr.substring(minusIndex+1));
					subtract(firstNum, secondNum);
				}
				else if (plusIndex == -1 && minusIndex == -1 && divideIndex == -1)
				{
					firstNum = Double.parseDouble(expr.substring(0, multiplyIndex));
					secondNum = Double.parseDouble(expr.substring(multiplyIndex+1));
					multiply(firstNum, secondNum);
				}
				else if (plusIndex == -1 && minusIndex == -1 && multiplyIndex == -1)
				{
					firstNum = Double.parseDouble(expr.substring(0, divideIndex));
					secondNum = Double.parseDouble(expr.substring(divideIndex+1));
					divide(firstNum, secondNum);
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
	

	/*
	 * Methods for adding, subtracting and multiplying matrices
	 */
	private void matrixAdd(double first[][], double second[][], 
			int firstRow, int firstCol, int secondRow, int secondCol) 
	{
		if (firstRow == secondRow && firstCol == secondCol) //must be true to add matrices
		{
			int row = firstRow;
			int col = secondCol;
			double addResult[][]=new double[row][col];

			for(int i = 0; i < row ;i++){
				for(int j = 0; j <col; j++){
					addResult[i][j] = first[i][j]+second[i][j];
					System.out.print(addResult[i][j]+" ");
				}
			}
		}
		else {
			System.out.println("These matrices cannot be added because they are not the same size.");
		}
	}
	private void matrixSubtract(double first[][], double second[][], 
			int firstRow, int firstCol, int secondRow, int secondCol) 
	{
		if (firstRow == secondRow && firstCol == secondCol) //must be true to subtract matrices
		{
			int row = firstRow;
			int col = secondCol;
			double subtractResult[][]=new double[row][col];

			for(int i = 0; i<row; i++){
				for(int j = 0; j<col; j++){
					subtractResult[i][j] = first[i][j]+second[i][j];
					System.out.print(subtractResult[i][j]+" ");
				}
			}
		}
		else {
			System.out.println("These matrices cannot be subtracted because they are not the same size.");
		}
	}
	private void matrixMultiply(double first[][], double second[][], 
			int firstRow, int firstCol, int secondRow, int secondCol) 
	{
		if (firstCol == secondRow) //must be true to multiply matrices
		{
			double multiplyResult[][]=new double[firstRow][secondCol];
		
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					multiplyResult[i][j] = 0;
					for (int k = 0; k < 3; k++) {
						multiplyResult[i][j] += first[i][k] * second[k][j];
					}
					System.out.print(multiplyResult[i][j] + " ");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("These matrices cannot be multiplied.");
		}
	}

}
