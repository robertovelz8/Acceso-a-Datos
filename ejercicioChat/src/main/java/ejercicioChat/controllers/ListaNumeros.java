package ejercicioChat.controllers;

import java.util.Scanner;

import ejercicioChat.exceptions.MiExcepcion;

public class ListaNumeros {
	public static void main(String[] args) throws MiExcepcion{
		
		Scanner sc = new Scanner (System.in);
		boolean flag = true;
		while (flag) {
			int valor = sc.nextInt();
			if (valor > 0) {
				flag = false;
				throw new MiExcepcion("No se admiten valores positivios.");
			}else if (valor == -999) {
				System.out.println("No se admite el -999");
				flag = false;
			}
		}
	}
}
