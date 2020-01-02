package domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ClienteTestee {
	public static void main(String[] args) {
		
		Cliente cli = new Cliente();
		
		cli.setNome("Vinicius");
		System.out.println(cli.getNome());		
		
	}
}
