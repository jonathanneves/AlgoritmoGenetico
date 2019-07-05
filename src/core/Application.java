package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import model.Cromossomo;

public class Application {

	public List<Cromossomo> cromossomos = new ArrayList<Cromossomo>();
	public int geracao = 1;

	//INICIANDO TODO O PROCESSO DO ALGORITMO GENETICO POR GERAÇÕES
	public void iniciar(int geracaoMax, int fitness) {		
		gerarPopulacao();
		//INICIANDO MUTAÇÂO e CROSSOVER
		if(geracaoMax > 0) {
			while(geracao <= geracaoMax) {
				System.out.print("-------------------GERAÇÃO: "+geracao+"---------------------");
				manterMaisApto();
				crossover(cromossomos);
				mutacao(cromossomos);
				cromossomos.forEach(System.out::println);
				geracao++;
			}
		}
		else if(fitness > 0) {
			boolean fitnessObjetivo = false;
			while(!fitnessObjetivo) {
				System.out.print("-------------------GERAÇÃO: "+geracao+"---------------------");
				manterMaisApto();
				crossover(cromossomos);
				mutacao(cromossomos);
				cromossomos.forEach(System.out::println);
				for(Cromossomo c : cromossomos) {
					if(c.getFitness() == fitness)
						fitnessObjetivo = true;
				}			
				geracao++;
			}
		}
		melhorIndividuo();
	}
	
	//IMPRIMIR RESULTADO FINAL
	public void melhorIndividuo() {
		System.out.println("Valores decimais: ");
		cromossomos.forEach(c -> c.binaryToInt(c.getBinario()));
		Cromossomo melhor = Collections.max(cromossomos, Comparator.comparing(s -> s.getFitness()));
		System.out.println("O Melhor Cromossomo é: "+ melhor.getBinario() + " com Aptidão de: "+ melhor.getFitness());
	}
	
	//GERA 4 CROMOSSOMOS ALEATÓRIOS APARTIR DE VALORES DECIMAIS
	public void gerarPopulacao() {
		Random gerador = new Random();
		String binario = "";
		int valor;
		
		System.out.println("Primeiras Configurações: ");
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<9; j++) {
				valor = gerador.nextInt(16);
				System.out.print(valor + "-");
				binario += intToBinary(valor);
			}
			System.out.println();
			cromossomos.add(new Cromossomo(binario));
			binario = "";
		}
		cromossomos.forEach(b -> System.out.println(b));
	}
	
	//CONVERTE DECIMAL PARA BINÁRIO
	public String intToBinary(int valor) {	
		String binario = String.format("%4s", Integer.toBinaryString(valor)).replace(' ', '0');
		return binario;	
	}
		
	//REMOVE OS DOIS CROMOSSOMOS COM MENOR APDTIDÃO
	public void manterMaisApto() {

		for(int i=0; i<2; i++) {
			Cromossomo c = Collections.min(cromossomos, Comparator.comparing(s -> s.getFitness()));
			cromossomos.remove(c);
		}
	}
	
	//APLICAR CROSSOVER
	public void crossover(List<Cromossomo> populacao) {	
		//Pegando o mais apto
		Cromossomo etilismo = Collections.max(populacao, Comparator.comparing(s -> s.getFitness()));
		
		//Pegando as letras que serão trocadas
		String cromossomo1 = populacao.get(0).getBinario();
		String cromossomo2 = populacao.get(1).getBinario();
		cromossomos.clear();
		String crossover1="";
		String crossover2="";
		
		Random gerador = new Random();
		for(int i=0; i<2; i++) {
			int pos = gerador.nextInt(34); //nunca pegar as duas ultimas posicao
			int corte = gerador.nextInt(10)+1; //corte máximo de 10
	
			if(pos+corte >= 36) 
				corte -= (pos+corte) - 35;
			
			//System.out.println("Posicao: "+pos +" Corte: " +corte);
			
			if(i==0) {
				crossover1 = cromossomo1.substring(0, pos) + cromossomo2.substring(pos, pos+corte) + cromossomo1.substring(pos+corte, 36);
				crossover2 = cromossomo2.substring(0, pos) + cromossomo1.substring(pos, pos+corte) + cromossomo2.substring(pos+corte, 36);
			}
			if(i==1) {
				crossover1 = cromossomo2.substring(0, pos) + cromossomo1.substring(pos, pos+corte) + cromossomo2.substring(pos+corte, 36);
				crossover2 = cromossomo1.substring(0, pos) + cromossomo2.substring(pos, pos+corte) + cromossomo1.substring(pos+corte, 36);
			}

			cromossomos.add(new Cromossomo(crossover1));
			cromossomos.add(new Cromossomo(crossover2));			
		}
		
		//Realizando o etilismo
		 Cromossomo menosApto = Collections.min(cromossomos, Comparator.comparing(s -> s.getFitness()));
		 if(etilismo.getFitness() > menosApto.getFitness()) {
			 cromossomos.remove(menosApto);
			 cromossomos.add(etilismo);
			 System.out.println("ETILISMO REALIZADO");
		 }else
			 System.out.println("");	 
	}
	
	//APLICAR MUTAÇÃO
	public void mutacao(List<Cromossomo> crossover) {

		Random gerador = new Random();
		
		int index1 = 0;
		int index2 = 0;

		String cromossomo1 = "";
		String cromossomo2 = "";
		
		//Escolhendo 2 cromossomos aleatoriamente
		while(index1 == index2) {
			index1 = gerador.nextInt(4);
			index2 = gerador.nextInt(4);
		}

		//Pegando dois cromossomos aleatórios para realizar mutação
		Cromossomo c1 =  crossover.get(index1);
		Cromossomo c2 =  crossover.get(index2);
		cromossomos.remove(c1);
		cromossomos.remove(c2);
		
		
				
		//Realizando a troca de bits para mutacação
		for(int i=0; i<2; i++) {
			int pos = gerador.nextInt(34);
			int corte = gerador.nextInt(2)+1;
			
			if(pos+corte >= 36) 
				corte -= (pos+corte) - 35;
			
			String mutacao="";
		    //System.out.println("Posicao: "+pos +" Corte: " +corte);
			
			for(int j=0; j<corte; j++) {
				int bit = gerador.nextInt(2);
				mutacao += bit;
			}
			
			if(i==0) 
				cromossomo1 = c1.getBinario().substring(0, pos) + mutacao + c1.getBinario().substring(pos+corte, 36);			
			if(i==1) 
				cromossomo2 = c2.getBinario().substring(0, pos) + mutacao + c2.getBinario().substring(pos+corte, 36);
		}
		cromossomos.add(new Cromossomo(cromossomo1));
		cromossomos.add(new Cromossomo(cromossomo2));

	}
}
