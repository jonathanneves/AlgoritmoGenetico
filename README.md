# Desafio com Algoritmo Genético
###### Introdução aos algoritmos genéticos. Representação, população inicial, operadores genéticos e função de avaliação. 

### Objetivos:

* Conhecer e entender a estrutura e funcionamento dos algoritmos genéticos; 
* Entender o conceito de representação e população inicial; 
* Entender o funcionamento dos operadores genéticos; 
* Conhecer a estrutura de uma função de avaliação;
* Implementar um algoritmo genético. 

### Descrição do problema:

Implementar um algoritmo genético para otimizar os parâmetros (configurações) de uma mesa de som hipotética. Cada um dos botões, na figura 1, representam possíveis configurações de volume, equalização, ganho, etc...  

Formalizando: Sabendo que cada botão pode ser colocado em 16 posições distintas, encontre a melhor combinação de posições para os 9 botões disponíveis na superfície da caixa apresentada na figura 1 de modo que o sinal de saída assuma o valor máximo.

Representação binária: existem 16 posições possíveis para  cada um dos 9 botões, de modo que 4 bits são suficientes para representar cada uma das 16 posições, na forma: 1 = 0001, 2 = 0010  ... 15 = 1111

------------------------------------------------------------------------------------------------------

Exemplo de genótipo:  001001001111011011011000000011111001. Essa sequência binária representa as configurações dos 9 botões respectivamente, 2-4-15-6-13-8-0-15-9. 
 
#### Metódos utilizados:

* Operadores Genéticos: mutação simples e crossover uniforme 
* Tipo de seleção para aplicação de crossover: elitismo 
 
**Função de Avaliação (fitness)** = 9+b2b5−b23b14+b24b4−b21b10+b36b15−b11b26+b16b17+b3b33+b28b19+b12b34−b31b 32−b22b25+b35b27−b29b7+b8b13−b6b9+b18b20−b1b30+b23b4+b21b15+b26b16+b31b1 2+b25b19+b7b8+b9b18+b1b33 
Os valores b2b5, por exemplo, representam os valores dos bits nas posições 2 e 5 respectivamente, na sequência binária. Nesse caso, a função de avaliação deve multiplicar os bits das posições 2 e 5.  
 
Os melhores indivíduos (cromossomos) serão aqueles com os maiores valores retornados pela função. O objetivo é obter o maior valor possível. 
