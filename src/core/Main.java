package core;
import javax.swing.JOptionPane;

import core.Application;

public class Main {

	private static Application app = new Application();
	
	public static void main(String[] args) {
		
		//MELHOR FITNESS 27
		//BIN�RIO: 111110111001101111111011111100101111
		//Decimal: 15-11-9-11-15-11-15-2-15
		int geracao = 0;
		int fitness = 0;
		int escolha = Integer.parseInt(JOptionPane.showInputDialog("Qual ser� o par�metro de parada: \n"+"1. Gera��es \n"+"2. Fitness (Aptid�o)"));
		if(escolha == 1 || escolha == 2) {
			switch(escolha) {
				case 1:
					geracao = Integer.parseInt(JOptionPane.showInputDialog("Quantas gera��es voc� deseja? "));
					break;
				case 2:
					fitness = Integer.parseInt(JOptionPane.showInputDialog("Qual seu fitness objetivo? \n"+"OBS: Um valor de fitness imposs�vel far� o algoritmo entrar em loop (M�x: 27)"));
					break;
			}
			app.iniciar(geracao, fitness);
			
		}else
			System.out.println("Digite um valor correto para escolha");
	}

}
