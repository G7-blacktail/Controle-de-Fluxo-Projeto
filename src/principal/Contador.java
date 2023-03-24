package principal;

import java.util.InputMismatchException;
import java.util.Scanner;
import excecoes.ParametrosInvalidosException;

public class Contador {

	public static void main(String[] args) throws Exception {

		Scanner entrada = new Scanner(System.in);

		int InputMismatchExceptionTest = -1;
		int primeiroNumero = 0;
		int segundoNumero = 0;

		System.out.println("vamos realizar a operação\n Pressione qualquer tecla para começar:");
		do {
				String retensaoLoopInfinito = entrada.nextLine();
				try {
				System.out.print("Digite o primeiro número: ");
				primeiroNumero = entrada.nextInt();
				System.out.print("Digite o segundo número: ");
				segundoNumero = entrada.nextInt();
				InputMismatchExceptionTest = 1;
				}catch(InputMismatchException i) {
					System.err.println("Só é permitido a entrada de valores numéricos");
				System.out.println("Insira novamente os valores");
				}

			}while(InputMismatchExceptionTest != 1);


			try {
				contagem(primeiroNumero, segundoNumero);
				} catch(ParametrosInvalidosException e) {
					while(segundoNumero < primeiroNumero) {
						System.err.println(e);
						System.out.println("Digite novamente os valores a serem verificados");
						System.out.print("Digite o primeiro número: ");
						primeiroNumero = entrada.nextInt();
						System.out.print("Digite o segundo número: ");
						segundoNumero = entrada.nextInt();
				}
						contagem(primeiroNumero, segundoNumero);
				}

	entrada.close();
	}

	static void contagem(int primeiroNumero, int segundoNumero) throws ParametrosInvalidosException {

		int indice = segundoNumero - primeiroNumero;
		if(indice < 0 ) {
			throw new ParametrosInvalidosException("O valor do segundo número deve ser maior do que o primeiro");
		}else {
			for(int i = 0; i < indice; i++) {
				System.out.println("Imprimindo o número " + (i+1));
			}
		}
	}

}
