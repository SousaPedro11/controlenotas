package controlenotas;

import java.util.Scanner;

public class Notas {
    private int[] notas;

    Scanner scan = new Scanner(System.in);

    public void lerNotas(final Disciplina disciplina, final int quantidade) {
	for (int i = 0; i < quantidade; i++) {
	    System.out.println("Informe a " + i + "ª nota: ");
	    this.notas[i] = this.scan.nextInt();
	}
    }
}
