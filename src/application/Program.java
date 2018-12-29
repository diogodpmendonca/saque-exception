package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
	
		System.out.println("Entre com os dados da Conta");
		System.out.print("Numero da conta: ");
		int number = sc.nextInt();
		System.out.print("Nome do titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Valor inicial na conta: ");
		Double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.print("Informe o valor que deseja sacar: ");
		Double amount = sc.nextDouble();
		
		try {
		account.withdraw(amount);
		
		System.out.println(account.toString());
		}
		catch (DomainException e) {
			System.out.println("Erro: "+e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro RunTime: "+e.getMessage());
		}
		finally {
			System.out.println("Programa Encerrado");
			sc.close();
		}
	}

}
