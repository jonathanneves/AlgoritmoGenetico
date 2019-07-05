package model;

import java.util.List;

public class Cromossomo {

	private String binario;
	private int fitness;
	
	
	public Cromossomo(String binario) {
		this.binario = binario;
		this.fitness = funcaoDeAvaliacao(binario);
	}

	public void binaryToInt(String cromossomo) {
		String [] bits = new String[9];
			for(int i=0; i<36; i++) {
				bits = cromossomo.split("(?<=\\G.{4})");
			}		
			for(int i=0; i<9; i++) {
				System.out.print(Integer.parseInt(bits[i], 2)+"-");
			}	
			System.out.println();
	}
	
	public int funcaoDeAvaliacao(String binario) {
		
		int valor = 0;
		
		//PEGANDO POSIÇÃO DOS BINARIOS
		int b1 = Character.getNumericValue(binario.charAt(0)); 
		int b2 = Character.getNumericValue(binario.charAt(1)); 
		int b3 = Character.getNumericValue(binario.charAt(2)); 
		int b4 = Character.getNumericValue(binario.charAt(3)); 
		int b5 = Character.getNumericValue(binario.charAt(4)); 
		int b6 = Character.getNumericValue(binario.charAt(5)); 
		int b7 = Character.getNumericValue(binario.charAt(6)); 
		int b8 = Character.getNumericValue(binario.charAt(7)); 
		int b9 = Character.getNumericValue(binario.charAt(8)); 
		int b10 = Character.getNumericValue(binario.charAt(9)); 
		int b11 = Character.getNumericValue(binario.charAt(10)); 
		int b12 = Character.getNumericValue(binario.charAt(11)); 
		int b13 = Character.getNumericValue(binario.charAt(12)); 
		int b14 = Character.getNumericValue(binario.charAt(13)); 
		int b15 = Character.getNumericValue(binario.charAt(14)); 
		int b16 = Character.getNumericValue(binario.charAt(15)); 
		int b17 = Character.getNumericValue(binario.charAt(16)); 
		int b18 = Character.getNumericValue(binario.charAt(17)); 
		int b19 = Character.getNumericValue(binario.charAt(18)); 
		int b20 = Character.getNumericValue(binario.charAt(19)); 
		int b21 = Character.getNumericValue(binario.charAt(20)); 
		int b22 = Character.getNumericValue(binario.charAt(21)); 
		int b23 = Character.getNumericValue(binario.charAt(22)); 
		int b24 = Character.getNumericValue(binario.charAt(23)); 
		int b25 = Character.getNumericValue(binario.charAt(24)); 
		int b26 = Character.getNumericValue(binario.charAt(25)); 
		int b27 = Character.getNumericValue(binario.charAt(26)); 
		int b28 = Character.getNumericValue(binario.charAt(27)); 
		int b29 = Character.getNumericValue(binario.charAt(28)); 
		int b30 = Character.getNumericValue(binario.charAt(29)); 
		int b31 = Character.getNumericValue(binario.charAt(30)); 
		int b32 = Character.getNumericValue(binario.charAt(31)); 
		int b33 = Character.getNumericValue(binario.charAt(32)); 
		int b34 = Character.getNumericValue(binario.charAt(33)); 
		int b35 = Character.getNumericValue(binario.charAt(34)); 
		int b36 = Character.getNumericValue(binario.charAt(35)); 
		
		valor= 9+(b2*b5)-(b23*b14)+(b24*b4)-(b21*b10)+(b36*b15)-(b11*b26)+(b16*b17)+(b3*b33)+(b28*b19)
				+(b12*b34)-(b31*b32)-(b22*b25)+(b35*b27)-(b29*b7)+(b8*b13)-(b6*b9)+(b18*b20)-(b1*b30)+(b23*b4)
				+(b21*b15)+(b26*b16)+(b31*b12)+(b25*b19)+(b7*b8)+(b9*b18)+(b1*b33);
		
		return valor;
	}
		
	@Override
	public String toString() {
		return "Cromossomo= "+ binario + " Fitness= " + fitness;
	}

	public String getBinario() {
		return binario;
	}
	public void setBinario(String binario) {
		this.binario = binario;
	}
	public int getFitness() {
		return fitness;
	}
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	
	
}
