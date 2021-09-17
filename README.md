1. APRESENTAÇÃO
Este projecto tem o objectivo de consolidar os conhecimentos adquiridos na disciplina de
Programação II.
2. Descrição
A velocidade e as máquinas sempre fascinaram os humanos, em especial, os do sexo
masculino. Corridas de velocidade sobre máquinas são então considerados desportos
por eles e são muito populares em todo o mundo. Há tantas categorias de corridas de
velocidade e tantos campeonatos regionais e mundiais que é sempre difícil manter-se
informado sobre seus andamentos. A sua tarefa neste trabalho desenvolver o Race
Sports XPTO. um programa que receba o nome de um campeonato, o ano de
realização, o nome dos pilotos e de suas equipas, o sistema de pontuação do
campeonato e os resultados das corridas já realizadas, e determinar a classificação
dos pilotos e das equipas até o momento.
Para efeitos de simplificação do trabalho, podemos assumir que em todas as
categorias e seus sistemas de pontuação, os pilotos são classificados de acordo com
as seguintes regras, nesta ordem:
1. Mais pontos ganhos;
2. Mais primeiros lugares;
3. Mais segundos lugares;
4. Mais terceiros lugares;
5. Ordem lexicográfica dos nomes dos pilotos.
Essas regras gerais estabelecem critérios de classificação que sempre fornecem uma
ordem decrescente dos pilotos da categoria em um campeonato (daquele que tem
mais pontos para aquele que tem menos), estabelecendo também critérios de
desempate. Isso significa que, após um número de corridas, nunca há dois pilotos
empatados, mesmo que tenham o mesmo número de pontos. As equipas são
apresentadas em ordem decrescente de pontuação. Em caso de mesmo número de
pontuação, as equipas são desempatadas na ordem lexicográfica de seus nomes.Projecto Programação II
3. Entrada e Saída
A entrada contém vários casos de teste. A primeira linha contém um número inteiro c > 0
que se refere ao número de campeonatos. Após esse número, uma linha em branco é
apresentada. Depois disso, o número de pilotos p do campeonato, um número inteiro com
1 ≤ p ≤ 50, é dado em uma linha. Em cada uma das p linhas seguintes, um nome de um
piloto e de uma equipa são descritos, separados por uma vírgula e um espaço. Em
seguida, uma linha em branco é dada. Depois, um número inteiro s é fornecido, que
indica a quantidade de pontos no sistema de pontuação do campeonato em questão.
Logo em seguida, s números inteiros são fornecidos, separados por espaços,
representando os s pontos do sistema de classificação do campeonato, do primeiro
colocado ao s-ésimo. Depois disso, uma linha em branco é descrita.
Em seguida um número inteiro k, com 1 ≤ k ≤ 50, é fornecido, indicando o número total de
provas já realizadas. Para cada prova, um nome da prova é fornecido em uma linha.
Em seguida, a classificação dos p pilotos é apresentada linha a linha em ordem
decrescente, do melhor ao pior colocado. O nome das equipas dos pilotos também é
fornecido. Cada par de provas é separado por uma linha em branco. Todos os nomes
deste trabalho têm no máximo 50 caracteres.
Para cada um dos casos de teste, o seu programa deve imprimir o seguinte. Primeiro,
uma linha contendo o nome do campeonato deve ser impressa. Em seguida, imprima uma
linha em branco. Depois, uma linha é impressa contendo uma mensagem que descreve a
classificação após k provas do campeonato. Segue então mais uma linha em branco.
Então, imprima p linhas, onde cada uma contém um número inteiro de 1 a p indicando a
classificação do piloto, seu nome, o nome de sua equipe e total de pontos que possui, em
ordem decrescente, do melhor para o pior colocado. Siga as regras de classificação e
desempate descritas na secção 2.
A seguir, imprima uma linha em branco. E em seguida, imprima e linhas, com 1 ≤ e ≤ p,
onde cada linha contém um número inteiro de 1 a e, indicando a classificação da equipa
no campeonato, o nome da equipa e a sua pontuação, em ordem decrescente de
classificação, da melhor para a pior equipa. Siga também as regras de classificação e
desempate descritas na secção 2. Entre dois campeonatos, sempre há uma linha em
branco impressa.Projecto Programação II
4. Exemplo de Entrada
2
Fórmula 1, 2020
24
Jason Bottom, McLaren (Mercedes)
Jerry Lewis Hamilton, McLaren (Mercedes)
Michael Schumasso, Mercedes (Mercedes)
Nico Rosbife, Mercedes (Mercedes)
Sebastian Pappel, Red Bull (Renault)
Mark Bebber, Red Bull (Renault)
Felipe Pasta, Ferrari (Ferrari)
Fernando Afonso, Ferrari (Ferrari)
Rubens Barriquebra, Williams (Cosworth)
Nico Inkrivelhulk, Williams (Cosworth)
Robert Cubico, Renault (Renault)
Vitaly Petregulhov, Renault (Renault)
Adrian Grosso, Force India (Mercedes)
Vitantonio Tiuzzi, Force India (Mercedes)
Sebastien Boemio, Toro Rosso (Ferrari)
Jaime Alguemsuave, Toro Rosso (Ferrari)
Jarro Bulli, Lotus (Cosworth)
Heikki Kovarrasen, Lotus (Cosworth)
Karun Chanbinhok, Hispania (Cosworth)
Bruno Megasena, Hispania (Cosworth)
Kamui Kambalashi, BMW Sauber (Ferrari)
Pedro de lo Cravo, BMW Sauber (Ferrari)
Timo Colt, Virgin (Cosworth)
Lucas Semgrassi, Virgin (Cosworth)
10 25 18 15 12 10 8 6 4 2 1
3
GP do Bahrein
Fernando Afonso, Ferrari (Ferrari)
Felipe Pasta, Ferrari (Ferrari)
Jerry Lewis Hamilton, McLaren (Mercedes)
Sebastian Pappel, Red Bull (Renault)
Nico Rosbife, Mercedes (Mercedes)
Michael Schumasso, Mercedes (Mercedes)
Jason Bottom, McLaren (Mercedes)
Mark Bebber, Red Bull (Renault)
Vitantonio Tiuzzi, Force India (Mercedes)
Rubens Barriquebra, Williams (Cosworth)
Robert Cubico, Renault (Renault)
Adrian Grosso, Force India (Mercedes)
Jaime Alguemsuave, Toro Rosso (Ferrari)
Nico Inkrivelhulk, Williams (Cosworth)
Heikki Kovarrasen, Lotus (Cosworth)
Sebastien Boemio, Toro Rosso (Ferrari)
Jarro Bulli, Lotus (Cosworth)
Pedro de lo Cravo, BMW Sauber (Ferrari)
Bruno Megasena, Hispania (Cosworth)
Timo Colt, Virgin (Cosworth)
Vitaly Petregulhov, Renault (Renault)
Kamui Kambalashi, BMW Sauber (Ferrari)
Lucas Semgrassi, Virgin (Cosworth)
Karun Chanbinhok, Hispania (Cosworth)
GP da Australia
Jason Bottom, McLaren (Mercedes)Projecto Programação II
Robert Cubico, Renault (Renault)
Felipe Pasta, Ferrari (Ferrari)
Fernando Afonso, Ferrari (Ferrari)
Nico Rosbife, Mercedes (Mercedes)
Jerry Lewis Hamilton, McLaren (Mercedes)
Vitantonio Tiuzzi, Force India (Mercedes)
Rubens Barriquebra, Williams (Cosworth)
Mark Bebber, Red Bull (Renault)
Michael Schumasso, Mercedes (Mercedes)
Jaime Alguemsuave, Toro Rosso (Ferrari)
Pedro de lo Cravo, BMW Sauber (Ferrari)
Heikki Kovarrasen, Lotus (Cosworth)
Karun Chanbinhok, Hispania (Cosworth)
Timo Colt, Virgin (Cosworth)
Lucas Semgrassi, Virgin (Cosworth)
Sebastian Pappel, Red Bull (Renault)
Adrian Grosso, Force India (Mercedes)
Vitaly Petregulhov, Renault (Renault)
Bruno Megasena, Hispania (Cosworth)
Sebastien Boemio, Toro Rosso (Ferrari)
Nico Inkrivelhulk, Williams (Cosworth)
Kamui Kambalashi, BMW Sauber (Ferrari)
Jarro Bulli, Lotus (Cosworth)
GP da Malasia
Sebastian Pappel, Red Bull (Renault)
Mark Bebber, Red Bull (Renault)
Nico Rosbife, Mercedes (Mercedes)
Robert Cubico, Renault (Renault)
Adrian Grosso, Force India (Mercedes)
Jerry Lewis Hamilton, McLaren (Mercedes)
Felipe Pasta, Ferrari (Ferrari)
Jason Bottom, McLaren (Mercedes)
Jaime Alguemsuave, Toro Rosso (Ferrari)
Nico Inkrivelhulk, Williams (Cosworth)
Sebastien Boemio, Toro Rosso (Ferrari)
Rubens Barriquebra, Williams (Cosworth)
Fernando Afonso, Ferrari (Ferrari)
Lucas Semgrassi, Virgin (Cosworth)
Karun Chanbinhok, Hispania (Cosworth)
Bruno Megasena, Hispania (Cosworth)
Jarro Bulli, Lotus (Cosworth)
Heikki Kovarrasen, Lotus (Cosworth)
Vitaly Petregulhov, Renault (Renault)
Vitantonio Tiuzzi, Force India (Mercedes)
Michael Schumasso, Mercedes (Mercedes)
Kamui Kambalashi, BMW Sauber (Ferrari)
Timo Colt, Virgin (Cosworth)
Pedro de lo Cravo, BMW Sauber (Ferrari)
Corrida de Tartarugas de Angola, 2021
5
Leonardo, Flash Turtles
Michaelangelo, United Turtles
Donatello, Turtles Stars
Mestre Splinter, Infinity Turtles
Elio, Space Turtles
10 6 2
2
Corrida do ISPTEC
Elio, Space Turtles
Michaelangelo, United Turtles
Leonardo, Flash TurtlesProjecto Programação II
Mestre Splinter, Infinity Turtles
Donatello, Turtles Stars
Corrida da UTEC
Donatello, Turtles Stars
Mestre Splinter, Infinity Turtles
Michaelangelo, United Turtles
Elio, Space Turtles
Leonardo, Flash Turtles
5. Exemplo de Saída
Fórmula 1, 2020
Classificacao apos 3 provas realizadas
Pilotos
1. Felipe Pasta, Ferrari (Ferrari), 39 pontos
2. Fernando Afonso, Ferrari (Ferrari), 37 pontos
3. Sebastian Pappel, Red Bull (Renault), 37 pontos
4. Jason Bottom, McLaren (Mercedes), 35 pontos
5. Nico Rosbife, Mercedes (Mercedes), 35 pontos
6. Jerry Lewis Hamilton, McLaren (Mercedes), 31 pontos
7. Robert Cubico, Renault (Renault), 30 pontos
8. Mark Bebber, Red Bull (Renault), 24 pontos
9. Adrian Grosso, Force India (Mercedes), 10 pontos
10. Michael Schumasso, Mercedes (Mercedes), 9 pontos
11. Vitantonio Tiuzzi, Force India (Mercedes), 8 pontos
12. Rubens Barriquebra, Williams (Cosworth), 5 pontos
13. Jaime Alguemsuave, Toro Rosso (Ferrari), 2 pontos
14. Nico Inkrivelhulk, Williams (Cosworth), 1 pontos
15. Bruno Megasena, Hispania (Cosworth), 0 pontos
16. Heikki Kovarrasen, Lotus (Cosworth), 0 pontos
17. Jarro Bulli, Lotus (Cosworth), 0 pontos
18. Kamui Kambalashi, BMW Sauber (Ferrari), 0 pontos
19. Karun Chanbinhok, Hispania (Cosworth), 0 pontos
20. Lucas Semgrassi, Virgin (Cosworth), 0 pontos
21. Pedro de lo Cravo, BMW Sauber (Ferrari), 0 pontos
22. Sebastien Boemio, Toro Rosso (Ferrari), 0 pontos
23. Timo Colt, Virgin (Cosworth), 0 pontos
24. Vitaly Petregulhov, Renault (Renault), 0 pontos
Equipas
1. Ferrari (Ferrari), 76 pontos
2. McLaren (Mercedes), 66 pontos
3. Red Bull (Renault), 61 pontos
4. Mercedes (Mercedes), 44 pontoss
5. Renault (Renault), 30 pontos
6. Force India (Mercedes), 18 pontos
7. Williams (Cosworth), 6 pontos
8. Toro Rosso (Ferrari), 2 pontos
9. BMW Sauber (Ferrari), 0 pontos
10. Hispania (Cosworth), 0 pontos
11. Lotus (Cosworth), 0 pontos
12. Virgin (Cosworth), 0 pontos
Corrida de Tartarugas de Angola, 2021
Classificacao apos 2 provas realizadas
Pilotos
1. Donatello, Turtles Stars, 10 pontos
2. Elio, Space Turtles, 10 pontos
3. Michaelangelo, United Turtles, 8 pontosProjecto Programação II
4. Mestre Splinter, Infinity Turtles, 6 pontos
5. Leonardo, Flash Turtles, 2 pontos
Equipas
1.
2.
3.
4.
5.
Space Turtles, 10 pontos
Turtles Stars, 10 pontos
United Turtles, 8 pontos
Infinity Turtles, 6 pontos
Flash Turtles, 2 pontos
A saída deve ser armazenada num ficheiro de texto com a seguinte nomenclatura
“YYYYMMDDhhmmss.txt “em que YYYYMMDDhhmmss é o formato da data e hora actual.
O programa deve de igual modo permitir a leitura do ficheiro.
