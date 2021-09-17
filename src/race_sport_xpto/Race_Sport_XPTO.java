package race_sport_xpto;

import CampeonatoPack.Campeonato;
import ClasificacaoEqPack.ClassificacaoEq;
import ClassificacaoPilPack.ClassificacaoPil;
import EquipaPack.Equipa;
import PilotoPack.Piloto;
import PovraPack.Prova;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Race_Sport_XPTO {

    public static void main(String[] args) throws IOException {

        Scanner ler = new Scanner(System.in);
        String c, filename;
        int opcao, opcao2;
        String fileName;

        Campeonato[] camp = null;
        int contCamp = 0;
        do {
            System.out.println("=================================================");
            System.out.println("|\t\t>RACE SPORT XPTO<               |");
            System.out.println("=================================================");
            System.out.println("|  [1]-LEITURA DO FICHEIRO                      |\n|  [2]-ESCREVER DADOS NO FICHEIRO               |\n|  [3]-SAIR DO PROGRAMA  |\n|  [4]-MAIS OPÇÕES                         |");
            System.out.println("=================================================");
            System.out.print("Digite a 0pção: ");
            opcao = ler.nextInt();
            ler.nextLine();
            System.out.println();
            switch (opcao) {

                case 1:
                    System.out.print("Digite o nome do ficheiro que deseja abrir: ");
                    filename = ler.nextLine();
                    camp = leitura(filename);
                    if (camp != null) {
                        System.out.println("\nGerando o ficheiro de saida");
                        ficheiro_Saida(camp);
                    }

                    break;
                case 2:
                    do {
                        System.out.println("<<<<<<<<<<<<<<<<<<Escrevendo no ficheiro>>>>>>>>>>>>>>>>>>>");
                        System.out.print("Digite o número de campeonatos(número inteiro entre 1 à 50): ");
                        c = ler.nextLine();
                        System.out.println();
                        if (!verificar_NumeroInt(c)) {
                            System.out.println("Digite um número inteiro!");
                        } else {
                            camp = new Campeonato[Integer.parseInt(c)];
                            camp = inserirCampeonatos(camp);
                            ficheiro_Saida(camp);
                            ficheiro_Entrada(camp);
                            break;
                        }
                    } while (true);
                    break;

                case 3:
                    System.out.println("Saiu do programa");
                    break;
                    
                case 4:
                    System.out.println("=================================================");
                    System.out.println("1-LISTAR TODAS AS EQUIPAS");
                    System.out.println("2-LISTAR TODAS AS EQUIPAS DE CAMPEONATO ESPECÍFICO");
                    System.out.println("3-LISTAR TODOS OS PILOTOS DE UMA EQUIPA");
                    System.out.println("4-MOSTAR QUAL PILOTO COM MAIS PONTOS NUM CAMPEONATO");
                    System.out.println("5-TRANSFERIR PILOTO DE UMA EQUIPA PARA OUTRA");
                    System.out.println("6-LISTAR PILOTO COM MAIS VICTORIA NUM CAMPEONATO");
                    
                    opcao2 = ler.nextInt();
                    
                    switch(opcao2){
                        case 1:
                            
                            listarTodasEquipas(camp);
                            break;
                            
                        case 2:
                            System.out.println("Digite o nome do campeonato");
                            ler.nextLine();
                            String ca = ler.nextLine();
                            listarEquipasDeUmCampeonato(camp, ca);
                            
                            break;
                        
                        case 3:
                            ler.nextLine();
                            System.out.println("Digite o nome da equipa");
                            String eq = ler.nextLine();
                            
                            listarPilotosDadaEquipa(camp, eq);
                            break;
                            
                        case 4:
                              
                            System.out.println("Digite o  nome do campeonato");
                            ler.nextLine();
                            ca = ler.nextLine();
                             
                             mostrarPilotoComMaisPontos(camp, ca);
                           
                             break;
                            
                        case 5:
                            System.out.println("Digite o nome do campeonato");
                            ler.nextLine();
                            ca = ler.nextLine();
                            
                            System.out.println("Digite o nome do piloto");
                            String nomePiloto = ler.nextLine();
                            
                            System.out.println("Digite a equipa de origem");
                            String equipaOri = ler.nextLine();
                            
                            System.out.println("Digite a equipa de destino");
                            String equipaDest = ler.nextLine();
                            
                            transferirPiloto(camp, ca, nomePiloto, equipaOri, equipaDest);
                            
                            break;
                            
                        case 6:
                             System.out.println("Digite o  nome do campeonato");
                             ler.nextLine();
                             ca = ler.nextLine();
                             mostrarPilotoComMaisPontos(camp, ca);
                            
                            break;    
                            
                                             
                            
                            
                    }
                    
                    
                    
                    break;

                default:
                    System.out.println("Opção inválida!");
                    ;
            }
            System.out.println();
        } while (opcao != 3);

    }

    //VERIFICA SE O VALOR INSERIDA É UM NÚMERO INTEIRO
    static boolean verificar_NumeroInt(String n) {

        int numeroInt = 0;
        n = n.toLowerCase();
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) >= 'a' && n.charAt(i) <= 'z') {
                return false;
            } else {
                //É verificado se cada caractere corresponde a um dígito(número)
                if (Integer.parseInt(String.valueOf(n.charAt(i))) >= 0 && Integer.parseInt(String.valueOf(n.charAt(i))) <= 9) {
                    numeroInt++;
                }
            }
        }

        if (numeroInt == n.length()) {
            return true;
        } else {
            return false;
        }
    }

    //Função que permite inserir a quantidade c de campeonatos 
    static Campeonato[] inserirCampeonatos(Campeonato[] campeonatos) throws IOException {
        Scanner ler = new Scanner(System.in);
        String p;
        int i = 0;
        String nome, ano;
        campeonatos[i] = new Campeonato();
        do {

            System.out.print("Digite o nome  do " + (i + 1) + "º campeonato: ");
            nome = ler.nextLine();
            System.out.print("Digite o ano(número inteiro, formato \"YYYY\") do " + (i + 1) + "º campeonato: ");
            ano = ler.nextLine();
            System.out.println();
            //Verifica se ano digitado  corresponde a uma cadeia de numeros inteiros 
            if (!verificar_NumeroInt(ano)) {
                System.out.println("Digite um número inteiro");
            } // Verifica se ano digitado  possui um tamanho diferenta da do padrão solicitado
            else if (ano.length() != 4) {
                System.out.println("Digite a data no padrão solicitado");
            } //Verifica se o tamanho de nome está entre 1 à 50
            else if (nome.length() < 1 || nome.length() > 50) {
                System.out.println("Digite nomes que possuam de 1 a 50 caracteres");
            } else {
                campeonatos[i].nome = nome;
                campeonatos[i].ano = Integer.parseInt(ano);
                //Solicita ao usuário que digite uma quantidade p de pilotos
                do {

                    System.out.print("Digite  a quantidade de pilotos(número inteiro de 1 a 50): ");
                    p = ler.nextLine();
                    System.out.println();
                    //Verifica se  p corresponde a um número inteiro 
                    if (!verificar_NumeroInt(p)) {
                        System.out.println("Digite um número inteiro");
                    }//Verifica se o tamanho de p está entre 1 à 50 
                    else if (Integer.parseInt(p) < 1 || Integer.parseInt(p) > 50) {
                        System.out.println("Digite número inteiro de 1 à 50");
                    } else {
                        campeonatos[i] = inserirPilotos(campeonatos[i], Integer.parseInt(p));
                        break;
                    }
                } while (true);
                campeonatos[i].classificacaoPiloto = classificaCampeonatoPil(campeonatos[i]);
                campeonatos[i].classificaoEquipa = classificaCampeonatoEq(campeonatos[i]);
                i++;
                // Verifica se o contador i é menor que o número de campeonatos
                if (i < campeonatos.length) {

                    campeonatos[i] = new Campeonato();
                }

            }

        } while (i < campeonatos.length);

        return campeonatos;
    }

    //Função que permite inserir p pilotos
    static Campeonato inserirPilotos(Campeonato camp, int p) {

        Scanner ler = new Scanner(System.in);
        ClassificacaoEq auxEq = new ClassificacaoEq();
        boolean existe = false;
        boolean cofirma = false;
        String nome, equipa;
        int contEq = 1;
        int i = 0;
        int l;

        String s;
        auxEq.equipa = new Equipa();

        camp.piloto = new Piloto[p];
        camp.piloto[i] = new Piloto();
        camp.piloto[i].equipa = new Equipa();
        camp.classificacaoPiloto = new ClassificacaoPil[camp.piloto.length];
        camp.classificacaoPiloto[i] = new ClassificacaoPil();
        camp.classificacaoPiloto[i].piloto = new Piloto();
        camp.classificacaoPiloto[i].piloto.equipa = new Equipa();
        do {

            System.out.print("Digite o nome(50 caracteres) do " + (i + 1) + "º piloto: ");
            nome = ler.nextLine();
            System.out.print("Digite a equipa(50 caracteres) do " + (i + 1) + "º piloto: ");
            equipa = ler.nextLine();
            System.out.println();
            // verifica se o tamanho nome e equipa são esta entre 1 á 50
            if (nome.length() < 1 || equipa.length() < 1
                    || nome.length() > 50 || equipa.length() > 50) {
                System.out.println("Digite nomes que possuam de 1 a 50 caracteres");
            } else {
                //Verifica se o nome digitado já exite
                for (l = 0; l < i; l++) {
                    if (camp.piloto[l].nome.equalsIgnoreCase(nome)) {
                        System.out.println("O piloto inserido já foi inscrito");
                        break;
                    }
                }
                // O  piloto é cadatrado caso não esteja cadastrado
                if (l == i) {
                    camp.piloto[i].nome = nome;
                    camp.piloto[i].equipa.nome = equipa;
                    camp.classificacaoPiloto[i].piloto = camp.piloto[i];

                    i++;
                    if (i < camp.classificacaoPiloto.length) {
                        camp.piloto[i] = new Piloto();
                        camp.piloto[i].equipa = new Equipa();
                        camp.classificacaoPiloto[i] = new ClassificacaoPil();
                        camp.classificacaoPiloto[i].piloto = new Piloto();
                        camp.classificacaoPiloto[i].piloto.equipa = new Equipa();

                    } else {
                        //Verifica quantas equipas diferentes a  corrida possui
                        for (int j = 0; j < (camp.classificacaoPiloto.length - 1); j++) {

                            for (l = (j + 1); l < camp.classificacaoPiloto.length; l++) {
                                if (camp.classificacaoPiloto[j].piloto.equipa.nome.equalsIgnoreCase(camp.classificacaoPiloto[l].piloto.equipa.nome)) {
                                    existe = true;
                                    break;
                                }
                            }
                            if (!existe) {
                                contEq++;

                            } else {
                                existe = false;
                            }
                        }

                        camp.classificaoEquipa = new ClassificacaoEq[contEq];
                        contEq = 0;
                        camp.classificaoEquipa[contEq] = new ClassificacaoEq();
                        camp.classificaoEquipa[contEq].equipa = new Equipa();
                        camp.classificaoEquipa[contEq].equipa.nome = camp.classificacaoPiloto[contEq].piloto.equipa.nome;
                        contEq++;
                        // As equipas se diferente são cadastradas para posterior cassificação
                        for (int j = 0; j < (camp.classificacaoPiloto.length - 1); j++) {

                            for (l = (j + 1); l < camp.classificacaoPiloto.length; l++) {
                                if (camp.classificacaoPiloto[j].piloto.equipa.nome.equalsIgnoreCase(camp.classificacaoPiloto[l].piloto.equipa.nome)) {
                                    existe = true;
                                    break;
                                }
                            }
                            if (!existe) {
                                camp.classificaoEquipa[contEq] = new ClassificacaoEq();
                                camp.classificaoEquipa[contEq].equipa = new Equipa();
                                camp.classificaoEquipa[contEq].equipa.nome = camp.classificacaoPiloto[contEq].piloto.equipa.nome;
                                contEq++;

                            } else {
                                existe = false;
                            }

                        }
                        //Solicita ao usuário que digite uma quantidade s de pontuaçãoes
                        do {

                            System.out.print("Digite  a quantidade de pontuações do sistema(número inteiro): ");
                            s = ler.nextLine();
                            System.out.println();
                            //Verifica se s corresponde a um número inteiro
                            if (!verificar_NumeroInt(s)) {
                                System.out.println("Digite a data no padrão solicitado");
                            } else if (Integer.parseInt(s) > camp.piloto.length) {
                                System.out.println("A quantidade de pontuações não pode ser suprerior a quantidade de pilotos");
                            } else {

                                camp = inserirPontuacoes(camp, Integer.parseInt(s));
                                break;
                            }
                        } while (true);

                    }
                }
            }

        } while (i < camp.classificacaoPiloto.length);

        return camp;
    }
    //Função que permite inserir as s pontuações

    static Campeonato inserirPontuacoes(Campeonato camp, int s) {

        Scanner ler = new Scanner(System.in);
        String k;
        int i = 0;
        String pontuacao;
        camp.pontuacao = new int[s];
        do {

            System.out.print("Digite a " + (i + 1) + "º pontuação: ");
            pontuacao = ler.nextLine();

            //Verifica se  pontuacao corresponde a um número inteiro
            if (!verificar_NumeroInt(pontuacao)) {
                System.out.println("\nDigite um número inteiro");
            }
            if (i > 0 && Integer.parseInt(pontuacao) > camp.pontuacao[i - 1]) {
                System.out.println("Didite um número menor que " + camp.pontuacao[i - 1]);
            } else {

                camp.pontuacao[i] = Integer.parseInt(pontuacao);
                i++;
                //Solicita a quantadade k de provas caso  inserção de pontuações já tenha terminado
                if (!(i < camp.pontuacao.length)) {

                    do {
                        System.out.print("\nDigite  a quantidade de provas(número inteiro de 1 à 50): ");
                        k = ler.nextLine();
                        // Verifica de k corresponde a um número inteiro
                        if (!verificar_NumeroInt(k)) {
                            System.out.println("\nDigite a data no padrão solicitado");
                        }//Verica se k está ente 1 à 50
                        else if (Integer.parseInt(k) < 1 || Integer.parseInt(k) > 50) {
                            System.out.println("\nDigite um número  de 1 a 50 caracteres");
                        } else {

                            camp = inserirProvas(camp, Integer.parseInt(k));
                            break;
                        }
                    } while (true);
                }
            }

        } while (i < camp.pontuacao.length);

        return camp;
    }

    //Função que permite inserir as k provas
    static Campeonato inserirProvas(Campeonato camp, int p) {

        Scanner ler = new Scanner(System.in);
        String nome;
        int i = 0;

        camp.prova = new Prova[p];
        camp.prova[i] = new Prova();
        do {

            System.out.print("\nDigite o nome da " + (i + 1) + "ª prova: ");
            nome = ler.nextLine();
            System.out.println();
            //Verifica se o tamanho de nome está entre 1 à 50
            if (nome.length() < 1 || nome.length() > 50) {
                System.out.println("Digite nomes que possuam de 1 a 50 caracteres");
            } else {
                camp.prova[i].nome = nome;
                camp.prova[i].classificacaoProva = inserirClassificacoesProva(camp.classificacaoPiloto, camp.pontuacao);

                i++;
                if (i < camp.prova.length) {
                    camp.prova[i] = new Prova();
                }
            }

        } while (i < camp.prova.length);

        return camp;
    }

    //Função que permite inserir a posição dos p pilotos em cada prova
    private static ClassificacaoPil[] inserirClassificacoesProva(ClassificacaoPil[] classificacoesPil, int[] pontuacao) {

        Scanner ler = new Scanner(System.in);
        ClassificacaoPil aux;
        boolean confirma = false;
        String nome;
        int j = 0;
        int i = 0;
        int l = 0;
        Prova prova = new Prova();
        prova.classificacaoProva = new ClassificacaoPil[classificacoesPil.length];
        prova.classificacaoProva[i] = new ClassificacaoPil();
        prova.classificacaoProva[i].piloto = new Piloto();
        do {

            System.out.print("Digite o nome do " + (i + 1) + "º classificado: ");
            nome = ler.nextLine();
            //Verifica se o tamanho de nome está entre 1 à 50
            if (nome.length() < 1 || nome.length() > 50) {
                System.out.println("\nDigite um nome que possua de 1 a 50 caracteres");
            } else {
                //Verifica se o nome inserido corresponde a um dos p pilotos 
                for (j = 0; j < classificacoesPil.length; j++) {
                    if (classificacoesPil[j].piloto.nome.equalsIgnoreCase(nome)) {

                        //Verifica se o nome inserido já possui alguma posição na prova 
                        for (l = 0; l < i; l++) {
                            if (prova.classificacaoProva[l].piloto.nome.equalsIgnoreCase(nome)) {
                                System.out.println("Não é possível posicionar o mesmo piloto em posiçõs diferentes");
                                break;
                            }

                        }
                        //Permite o piloto ser cadastrado caso não possua  nenhuma posição
                        if (l == i) {
                            prova.classificacaoProva[i].posicao = (i + 1);
                            prova.classificacaoProva[i].piloto = classificacoesPil[j].piloto;
                            if (i < pontuacao.length) {
                                prova.classificacaoProva[i].pontos = pontuacao[i];
                            }
                            confirma = true;
                            break;
                        } else {
                            break;
                        }

                    }
                }
            }

            //Verifica se todas a posições já foram colocadas
            if (confirma) {

                i++;

                if (i < classificacoesPil.length) {
                    prova.classificacaoProva[i] = new ClassificacaoPil();
                    prova.classificacaoProva[i].piloto = new Piloto();
                }
                confirma = false;
            } else if (j == classificacoesPil.length) {

                System.out.println("O nome digitado não se encontra cadastrado nessa prova!");
            }
        } while (i < classificacoesPil.length);

        return prova.classificacaoProva;
    }

    //Função que atribui os pontos das equipas do campeonato
    private static ClassificacaoEq[] classificaCampeonatoEq(Campeonato camp) {
        //Atribuição dos pontos de cada piloto as sua equipa correspondente 
        
        for (int i = 0; i < camp.classificaoEquipa.length; i++) {
            for (int j = 0; j < camp.classificacaoPiloto.length; j++) {
                
                if (camp.classificaoEquipa[i].equipa.nome.equalsIgnoreCase(camp.classificacaoPiloto[j].piloto.equipa.nome)) {
                    camp.classificaoEquipa[i].pontos += camp.classificacaoPiloto[j].pontos;   
                   
                }
            }
        }
        System.out.println("pd");
        camp = criteriosDesempEq(camp);

        return camp.classificaoEquipa;
    }

    //Função que atribui os pontos dos pilotos do campeonato
    private static ClassificacaoPil[] classificaCampeonatoPil(Campeonato camp) {
        //Atribuição dos pontos da posição de cada prova ao piloto correspondente 
        for (int i = 0; i < camp.prova.length; i++) {
            for (int j = 0; j < camp.classificacaoPiloto.length; j++) {
                for (int k = 0; k < camp.pontuacao.length; k++) {
                    if (camp.classificacaoPiloto[j].piloto.nome.equalsIgnoreCase(camp.prova[i].classificacaoProva[k].piloto.nome)) {
                        camp.classificacaoPiloto[j].pontos += camp.pontuacao[k]; 
                        break;
                    }
                }
            }
        }
        camp = criteriosDesempPil(camp);
        return camp.classificacaoPiloto;
    }

    //Função que organiza e aplica os critérios de desempate da classificação dos pilotos
    private static Campeonato criteriosDesempPil(Campeonato camp) {
        ClassificacaoPil aux = null;

        int maislugi;
        int maislugj;
        int menor = 0;
        int lugar;
        camp.classificacaoPiloto[0].posicao = 1;
        //Verifica se  o piloto da posição j  possui mais pontos que o piloto na posição i
        for (int i = 0; i < (camp.classificacaoPiloto.length - 1); i++) {
            for (int j = (i + 1); j < camp.classificacaoPiloto.length; j++) {

                if (camp.classificacaoPiloto[i].pontos < camp.classificacaoPiloto[j].pontos) {

                    aux = camp.classificacaoPiloto[i];
                    camp.classificacaoPiloto[i] = camp.classificacaoPiloto[j];
                    camp.classificacaoPiloto[i].posicao = (i + 1);
                    camp.classificacaoPiloto[j] = aux;
                    camp.classificacaoPiloto[j].posicao = (j + 1);
                } //Verifica se  o piloto da posição i possui os mesmos pontos que o piloto na posição j
                else if (camp.classificacaoPiloto[i].pontos == camp.classificacaoPiloto[j].pontos) {

                    lugar = 0;
                    //Verifica quantidade de saidas do piloto i e do piloto j numa dada posição
                    do {
                        maislugi = 0;
                        maislugj = 0;
                        //Verificação da saída de um piloto i  numa dada posição
                        for (int k = 0; k < camp.prova.length; k++) {

                            if (camp.classificacaoPiloto[i].piloto.nome.equalsIgnoreCase(camp.prova[k].classificacaoProva[lugar].piloto.nome)) {
                                maislugi++;
                            }

                        }
                        //Verificação da saída de um piloto j  numa dada posição
                        for (int k = 0; k < camp.prova.length; k++) {

                            if (camp.classificacaoPiloto[j].piloto.nome.equalsIgnoreCase(camp.prova[k].classificacaoProva[lugar].piloto.nome)) {
                                maislugj++;
                            }

                        }
                        //Verificação do saída de um piloto j numa dada posição
                        if (maislugi < maislugj) {
                            aux = camp.classificacaoPiloto[i];
                            camp.classificacaoPiloto[i] = camp.classificacaoPiloto[j];
                            camp.classificacaoPiloto[i].posicao = (i + 1);
                            camp.classificacaoPiloto[j] = aux;
                            camp.classificacaoPiloto[j].posicao = (j + 1);

                            break;
                        } else if (!(maislugi == maislugj)) {
                            camp.classificacaoPiloto[i].posicao = (i + 1);
                            camp.classificacaoPiloto[j].posicao = (j + 1);
                            break;
                        }

                        lugar++;
                    } while ((lugar < 3) && (lugar < camp.classificacaoPiloto.length));

                    if (!(lugar < 3) || !(lugar < camp.classificacaoPiloto.length)) {
                        menor = 0;
                        if (camp.classificacaoPiloto[i].piloto.nome.length() > camp.classificacaoPiloto[j].piloto.nome.length()) {

                            menor = camp.classificacaoPiloto[j].piloto.nome.length();
                        } else {

                            menor = camp.classificacaoPiloto[i].piloto.nome.length();
                        }
                        for (int l = 0; l < menor; l++) {

                            if (camp.classificacaoPiloto[i].piloto.nome.toLowerCase().charAt(l) > camp.classificacaoPiloto[j].piloto.nome.toLowerCase().charAt(l)) {
                                aux = camp.classificacaoPiloto[i];
                                camp.classificacaoPiloto[i] = camp.classificacaoPiloto[j];
                                camp.classificacaoPiloto[i].posicao = (i + 1);
                                camp.classificacaoPiloto[j] = aux;
                                camp.classificacaoPiloto[j].posicao = (j + 1);
                                break;
                            } else if (!(camp.classificacaoPiloto[i].piloto.nome.toLowerCase().charAt(l) == camp.classificacaoPiloto[j].piloto.nome.toLowerCase().charAt(l))) {
                                break;
                            } else if (i == (menor - 1)) {
                                camp.classificacaoPiloto[j].posicao = (j + 1);
                                break;
                            }
                        }
                    }

                } else {
                    camp.classificacaoPiloto[i].posicao = (i + 1);
                    camp.classificacaoPiloto[j].posicao = (j + 1);
                }
            }
        }
        return camp;

    }

    static Campeonato criteriosDesempEq(Campeonato camp) {

        ClassificacaoEq aux = null;
        int menor = 0;

        camp.classificaoEquipa[0].posicao = 1;
        for (int i = 0; i < (camp.classificaoEquipa.length - 1); i++) {
            for (int j = (i + 1); j < camp.classificaoEquipa.length; j++) {

                if (camp.classificaoEquipa[i].pontos < camp.classificaoEquipa[j].pontos) {
                    aux = camp.classificaoEquipa[i];
                    camp.classificaoEquipa[i] = camp.classificaoEquipa[j];
                    camp.classificaoEquipa[i].posicao = (i + 1);
                    camp.classificaoEquipa[j] = aux;
                    camp.classificaoEquipa[j].posicao = (j + 1);
                } else if (camp.classificaoEquipa[i].pontos == camp.classificaoEquipa[j].pontos) {

                    menor = 0;
                    if (camp.classificaoEquipa[i].equipa.nome.length() > camp.classificaoEquipa[j].equipa.nome.length()) {

                        menor = camp.classificaoEquipa[j].equipa.nome.length();
                    } else {

                        menor = camp.classificaoEquipa[i].equipa.nome.length();
                    }

                    for (int l = 0; l < menor; l++) {

                        if (camp.classificaoEquipa[i].equipa.nome.toLowerCase().charAt(l) > camp.classificaoEquipa[j].equipa.nome.toLowerCase().charAt(l)) {

                            aux = camp.classificaoEquipa[i];
                            camp.classificaoEquipa[i] = camp.classificaoEquipa[j];
                            camp.classificaoEquipa[i].posicao = (i + 1);
                            camp.classificaoEquipa[j] = aux;
                            camp.classificaoEquipa[j].posicao = (j + 1);
                            break;
                        } else if (!(camp.classificaoEquipa[i].equipa.nome.toLowerCase().charAt(l) == camp.classificaoEquipa[j].equipa.nome.toLowerCase().charAt(l))) {
                            break;
                        } else if (i == (menor - 1)) {
                            camp.classificaoEquipa[j].posicao = (j + 1);
                            break;
                        }
                    }

                } else {
                    camp.classificaoEquipa[i].posicao = (i + 1);
                    camp.classificaoEquipa[j].posicao = (j + 1);
                }
            }
        }
        return camp;

    }

    static void ficheiro_Entrada(Campeonato[] camp) throws IOException {

        PrintWriter f = null;
        DateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
        String file = "entrada" + formato.format(dataActual()) + ".txt";
        int i = 0;
        try {
            f = new PrintWriter(new File(file));
            f.println(camp.length + "\n");

            do {
                f.println(camp[i].nome + ", " + camp[i].ano + "\n");
                f.println(camp[i].piloto.length);
                for (int j = 0; j < camp[i].piloto.length; j++) {
                    f.println(camp[i].piloto[j].nome + ", " + camp[i].piloto[j].equipa.nome);
                }

                f.println();

                f.print(camp[i].pontuacao.length);
                for (int j = 0; j < camp[i].pontuacao.length; j++) {
                    f.print(" " + camp[i].pontuacao[j]);
                }

                f.println("\n");

                f.println(camp[i].prova.length);
                for (int j = 0; j < camp[i].prova.length; j++) {
                    f.println("\n" + camp[i].prova[j].nome);

                    for (int l = 0; l < camp[i].prova[j].classificacaoProva.length; l++) {
                        f.println(camp[i].prova[j].classificacaoProva[l].piloto.nome + ", " + camp[i].prova[j].classificacaoProva[l].piloto.equipa.nome);
                    }

                }

                i++;
            } while (i < camp.length);
            System.out.println("Oconteudo foi escrito com sucesso no ficheiro " + file);
        } catch (Exception e) {
            System.out.println("Não foi possível realizar operação");
        }
        f.close();

    }

    static void ficheiro_Saida(Campeonato[] camp) throws IOException {

        DateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
        String file = formato.format(dataActual()) + ".txt";
        PrintWriter f = null;
        int i = 0;
        try {
            f = new PrintWriter(new File(file));
            f.println(camp.length);
            do {
                f.println("\n"+camp[i].nome + ", " + camp[i].ano + "\n");
                f.println("Classificação após " + camp[i].prova.length + " provas realizadas\n");

                f.println("Pilotos\n");

                for (int j = 0; j < camp[i].piloto.length; j++) {
                    f.println(camp[i].classificacaoPiloto[j].posicao + ". " + camp[i].classificacaoPiloto[j].piloto.nome
                            + ", " + camp[i].classificacaoPiloto[j].piloto.equipa.nome + ", " + camp[i].classificacaoPiloto[j].pontos + " pontos");
                }

                f.println();

                f.println("Equipas\n");
                for (int j = 0; j < camp[i].classificaoEquipa.length; j++) {
                    f.println(camp[i].classificaoEquipa[j].posicao + ". " + camp[i].classificaoEquipa[j].equipa.nome
                            + ", " + camp[i].classificaoEquipa[j].pontos + " pontos");
                }

                i++;
            } while (i < camp.length);
            System.out.println("Oconteudo foi escrito com sucesso no ficheiro " + file);
        } catch (Exception e) {
            System.out.println("Não foi possível realizar operação");
        }
        f.close();

    }

    static Campeonato[] leitura(String file) throws IOException {

        BufferedReader dadosCamp = null;
        Campeonato[] camp = null;
        boolean confirma = true;
        boolean existe = false;
        String[] nomeAno;
        String[] pilotoEq;
        String[] pontuacao;
        int qtdCamp, qtdPil;
        int[] pontos;
        int contEq;
        int contSpace = 0;
        int i, h;
        try {
            dadosCamp = new BufferedReader(new FileReader(file));
            String dados = dadosCamp.readLine();
            if (verificar_NumeroInt(dados)) {
                qtdCamp = Integer.parseInt(dados);
                camp = new Campeonato[qtdCamp];

                for (i = 0; i < camp.length && confirma; i++) {
                    dadosCamp.readLine();
                    dados = dadosCamp.readLine();

                    if (dados.contains(",")) {
                        nomeAno = dados.split(", ");
                        if (nomeAno[0].length() >= 1 && nomeAno[0].length() <= 50 && nomeAno[1].length() == 4
                                && verificar_NumeroInt(nomeAno[1])) {

                            camp[i] = new Campeonato();
                            camp[i].nome = nomeAno[0];
                            camp[i].ano = Integer.parseInt(nomeAno[1]);

                            dadosCamp.readLine();
                            dados = dadosCamp.readLine();

                            if (verificar_NumeroInt(dados)) {

                                qtdPil = Integer.parseInt(dados);
                                camp[i].piloto = new Piloto[qtdPil];
                                camp[i].classificacaoPiloto = new ClassificacaoPil[camp[i].piloto.length];

                                for (int j = 0; j < camp[i].piloto.length && confirma; j++) {
                                    dados = dadosCamp.readLine();
                                    if (dados.contains(",")) {

                                        pilotoEq = dados.split(", ");

                                        if (pilotoEq[0].length() >= 1 && pilotoEq[1].length() >= 1
                                                && pilotoEq[0].length() <= 50 && pilotoEq[1].length() <= 50) {

                                            camp[i].piloto[j] = new Piloto();
                                            camp[i].piloto[j].equipa = new Equipa();
                                            camp[i].classificacaoPiloto[j] = new ClassificacaoPil();
                                            camp[i].classificacaoPiloto[j].piloto = new Piloto();

                                            camp[i].piloto[j].nome = pilotoEq[0];
                                            camp[i].classificacaoPiloto[j].piloto = camp[i].piloto[j];
                                            camp[i].piloto[j].equipa.nome = pilotoEq[1];
                                            
                                        } else {
                                            System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                            confirma = false;
                                            break;
                                        }
                                    } else {
                                        confirma = false;
                                        break;
                                    }
                                }
                                if (confirma) {
                                    contEq = 1;
                                    for (int j = 0; j < (camp[i].piloto.length - 1) && confirma; j++) {

                                        for (int l = (j + 1); l < camp[i].piloto.length; l++) {

                                            if (camp[i].piloto[j].equipa.nome.equalsIgnoreCase(camp[i].piloto[l].equipa.nome)) {
                                                existe = true;
                                                break;
                                            }
                                        }
                                        if (!existe) {
                                            contEq++;
                                        } else {
                                            existe = false;
                                        }
                                    }

                                    camp[i].classificaoEquipa = new ClassificacaoEq[contEq];
                                    camp[i].classificaoEquipa[0] = new ClassificacaoEq();
                                    camp[i].classificaoEquipa[0].equipa = new Equipa();
                                    camp[i].classificaoEquipa[0].equipa = camp[i].classificacaoPiloto[0].piloto.equipa;

                                    
                                    contEq = 1;
                                    for (int j = 0; j < (camp[i].classificacaoPiloto.length) && confirma; j++) {

                                        for (int l = 0; l < contEq; l++) {

                                            if (camp[i].classificacaoPiloto[j].piloto.equipa.nome.equalsIgnoreCase(camp[i].classificaoEquipa[l].equipa.nome)) {
                                                existe = true;
                                                break;
                                            }
                                        }
                                        if (!existe) {

                                            camp[i].classificaoEquipa[contEq] = new ClassificacaoEq();
                                            camp[i].classificaoEquipa[contEq].equipa = new Equipa();
                                            camp[i].classificaoEquipa[contEq].equipa = camp[i].classificacaoPiloto[j].piloto.equipa;
                                            contEq++;

                                        } else {
                                            existe = false;
                                        }
                                    }
                                    dadosCamp.readLine();
                                    dados = dadosCamp.readLine();
                                  
                                    for (h = 0; h < dados.length(); h++) {
                                        if (dados.charAt(h) == ' ' && dados.charAt(h - 1) != ' ' && h > 0) {
                                            contSpace++;
                                        }
                                    }
                                    if (contSpace > 0) {

                                        pontuacao = dados.split(" ");

                                        if (verificar_NumeroInt(pontuacao[0]) && Integer.parseInt(pontuacao[0]) <= camp[i].piloto.length) {

                                            camp[i].pontuacao = new int[Integer.parseInt(pontuacao[0])];

                                            for (int l = 0; l < camp[i].pontuacao.length && confirma; l++) {
                                                if (verificar_NumeroInt(pontuacao[l + 1]) && l == 0) {
                                                    camp[i].pontuacao[l] = Integer.parseInt(pontuacao[l + 1]);

                                                } else if (verificar_NumeroInt(pontuacao[l + 1]) && Integer.parseInt(pontuacao[l + 1]) < Integer.parseInt(pontuacao[l])) {
                                                    camp[i].pontuacao[l] = Integer.parseInt(pontuacao[l + 1]);

                                                } else {
                                                    System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                                    confirma = false;
                                                    break;
                                                }
                                            }
                                            if (confirma) {

                                                dadosCamp.readLine();
                                                dados = dadosCamp.readLine();
                                                
                                                if (verificar_NumeroInt(dados)) {

                                                    camp[i].prova = new Prova[Integer.parseInt(dados)];

                                                    for (int k = 0; k < camp[i].prova.length && confirma; k++) {
                                                        dadosCamp.readLine();
                                                        dados = dadosCamp.readLine();
                                                      if(dados.length() >= 1 && dados.length() <= 50 && confirma){
                                                        camp[i].prova[k] = new Prova();
                                                        camp[i].prova[k].nome = dados;
                                                        camp[i].prova[k].classificacaoProva = new ClassificacaoPil[camp[i].piloto.length];
                                                       
                                                        for (int l = 0; l < camp[i].prova[k].classificacaoProva.length; l++) {
                                                            dados = dadosCamp.readLine();
                                                            if (dados.contains(",")) {
                                                                
                                                                pilotoEq = dados.split(", ");
                                                                if (pilotoEq[0].length() >= 1 && pilotoEq[1].length() >= 1
                                                                        && pilotoEq[0].length() <= 50 && pilotoEq[1].length() <= 50 && confirma) {
                                                                    
                                                                    camp[i].prova[k].classificacaoProva[l] = new ClassificacaoPil();
                                                                    camp[i].prova[k].classificacaoProva[l].piloto = new Piloto();
                                                                    camp[i].prova[k].classificacaoProva[l].piloto.equipa = new Equipa();
                                                                    
                                                                    for (h = 0; h < camp[i].piloto.length; h++) {
                                                                        
                                                                        if (camp[i].piloto[h].nome.equalsIgnoreCase(pilotoEq[0])) {
                                                                            
                                                                            camp[i].prova[k].classificacaoProva[l].piloto.nome = pilotoEq[0];
                                                                            camp[i].prova[k].classificacaoProva[l].piloto.equipa.nome = pilotoEq[1];
                                                                            
                                                                            break;
                                                                        } else if (h == camp[i].piloto.length) {
                                                                           
                                                                            System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                                                            confirma = false;
                                                                            break;
                                                                        }
                                                                    }

                                                                } else {
                                                                    System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                                                    confirma = false;
                                                                    break;
                                                                }
                                                            } else {
                                                                System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                                                confirma = false;
                                                                break;
                                                            }
                                                        }
                                                    }

                                                    }

                                                } else {
                                                    System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                                    confirma = false;
                                                    break;
                                                }
                                            } else {
                                                System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                                confirma = false;
                                                break;
                                            }
                                        } else {
                                            System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                            confirma = false;
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                    confirma = false;
                                    break;
                                }
                            } else {
                                System.out.println("O ficherio não se encontra padronizado na forma correcta");
                                confirma = false;
                                break;
                            }

                        } else {
                            System.out.println("O ficherio não se encontra padronizado na forma correcta");
                            confirma = false;
                            break;
                        }
                    } else {
                        System.out.println("O ficherio não se encontra padronizado na forma correcta");
                        confirma = false;
                        break;
                    }
                   
                    camp[i].classificacaoPiloto = classificaCampeonatoPil(camp[i]);
                    camp[i].classificaoEquipa = classificaCampeonatoEq(camp[i]);
                
                }
                if (i == camp.length) {

                    System.out.println("Ficheiro " + file + " lido com sucesso");
                    dadosCamp.close();
                    return camp;
                } else {
                    System.out.println("O ficherio não se encontra padronizado na forma correcta");
                }
            } else {
                System.out.println("O ficherio não se encontra padronizado na forma correcta");
            }

        } catch (Exception e) {
            System.out.println("Não foi possível realizar operação");
        }

        return null;
    }

    static Date dataActual() {
        Date data = new Date();

        return data;
    }

    private static void listarTodasEquipas(Campeonato[] camp) {
        int i =0, j=0;
        
        do{
            System.out.println(camp[i].nome);
            System.out.println("Equipas\n");
                for (j = 0; j < camp[i].classificaoEquipa.length; j++) {
                    System.out.println(camp[i].classificaoEquipa[j].posicao + ". " + camp[i].classificaoEquipa[j].equipa.nome);
                }
            i++;
        }while(i < camp.length);
        
                
    }

    private static void listarEquipasDeUmCampeonato(Campeonato[] camp, String campeonato) {
        
        int i =0, j=0;
        int index = indiceNomeCampeonato(camp, campeonato);
        
            if(index != -1){
               System.out.println(camp[i].nome);
               System.out.println("Equipas\n");
                for (j = 0; j < camp[i].classificaoEquipa.length; j++) {
                    System.out.println(camp[i].classificaoEquipa[j].posicao + ". " + camp[i].classificaoEquipa[j].equipa.nome);
                }
            }else
                System.out.println("Campeonato não encontrado");
    }
    
   public static int indiceNomeCampeonato(Campeonato[] camp, String campeonato){
       int index = -1;
       
       for (int i = 0; i < camp.length; i++) {
           if(camp[i].nome.equals(campeonato)){
               index = i;
               return index;
           }
               
       } 
       return index;    
   }

    private static void listarPilotosDadaEquipa(Campeonato[] camp, String eq) {
        int i =0, j=0;
        
        do{
            for ( j = 0; j < camp[i].piloto.length; j++) {
                if(camp[i].piloto[j].equipa.nome.equals(eq))
                    System.out.println(camp[i].piloto[j].nome + ", " + camp[i].piloto[j].equipa.nome);
            }
            i++;
        }while(i < camp.length);
    }

    private static void mostrarPilotoComMaisPontos(Campeonato[] camp, String ca) {
        
        int i =0, j=0;
        int index = indiceNomeCampeonato(camp, ca);
        
            if(index != -1){
               System.out.println(camp[i].nome);
                System.out.println(camp[i].classificacaoPiloto[j].posicao + ". " + camp[i].classificacaoPiloto[j].piloto.nome
                            + ", " + camp[i].classificacaoPiloto[j].piloto.equipa.nome + ", " + camp[i].classificacaoPiloto[j].pontos + " pontos");
               
               
            }else
                System.out.println("Campeonato não encontrado");

    }
    
    private static boolean verificaSeExisteEq(Campeonato camp, String eq){
        int j=0;
        
        for (j = 0; j < camp.classificaoEquipa.length; j++) {
            if(camp.classificaoEquipa[j].equipa.nome.equals(eq))
                return true;
        }
        
         return false;
    }
    
    private static int indexPiloto(Campeonato[] camp, String piloto){
        int i=0;
         do {
               
                for (int j = 0; j < camp[i].piloto.length; j++) {
                    if(camp[i].piloto[j].nome.equals(piloto))
                        return j;
                    //f.println(camp[i].piloto[j].nome + ", " + camp[i].piloto[j].equipa.nome);
                }

                i++;
            } while (i < camp.length);
         
         return -1;
        
    }

    private static void transferirPiloto(Campeonato[] camp, String campeonato, String nomePiloto, String equipaOri, String equipaDest) throws IOException {
           
        int i =0, j=0;
        int indexPil;
        
        int indexCamp = indiceNomeCampeonato(camp, campeonato);
        
            if(indexCamp != -1){
                if(verificaSeExisteEq(camp[i], equipaOri) && verificaSeExisteEq(camp[i], equipaDest)){
                    indexPil = indexPiloto(camp, nomePiloto);
                    camp[i].piloto[indexPil].equipa.nome = equipaDest;
                    ficheiro_Entrada(camp);
                    ficheiro_Saida(camp);
                }
                else
                    System.out.println("Equipa não encontrada");
            }else
                System.out.println("Campeonato não encontrado");
            
            
            

    }
    
    
   
}
