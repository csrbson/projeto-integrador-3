package br.com.projetointegrador3.helpers;

import java.util.Scanner;

public class Input { 

	private static final Scanner scanner = new Scanner(System.in);

	public static String inputString(String label) {
		
		return input(label);
	}
	

	public static int inputNumber(String label) {
	
		try {
			return Integer.parseInt(input(label));	
		} catch(NumberFormatException e) {
			throw e;
		}		
	}
	

	private static String input(String label) {
		
		System.out.print(label);

		String entrada = scanner.nextLine();		
		
		return entrada;
		
	}
	
	public static void close() {
		scanner.close();
	}
	
}
