package trabalhomdsfinal1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import java.text.DecimalFormat;

import java.util.Timer;
import java.util.TimerTask;

import java.util.ArrayList; 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	
	public static void main(String[] args) throws IOException, ParseException{
		
			Utilizador[] array =  new Utilizador[1000];
			
			array = Lista_Alunos();
			
			
			Aula[] aula = new Aula[1000];
			
			aula = Lista_Aulas();
			
			////Array da ClassePresenças
			
			Presença[] presenças = new Presença[aula.length];
			
			int pointer_presenças = 0;
			
			for(int indice4 = 0; indice4 < aula.length; indice4++) {
				presenças[pointer_presenças] = new Presença();
				pointer_presenças++;
				
			}
			presenças[0] = new Presença();
			
			////Array da ClasseFaltas
			
			Faltas[] faltas = new Faltas[aula.length];
				
			int pointer_faltas = 0;
						
			for(int indice_faltas = 0; indice_faltas < aula.length; indice_faltas++) {
					
				faltas[pointer_faltas] = new Faltas();
				pointer_faltas++;
			}	

			faltas[0] = new Faltas();
			
			////////////////////////////
			
			long t= System.currentTimeMillis();
			long end = t+10000;        
            
            //PARA LER O FICHEIRO AULAS.JSON
            
            JSONParser jsonparser2 = new JSONParser();
            
            FileReader reader2 = new FileReader(".\\ficheirosjson\\aulas.json");
            
            Object obj2 = jsonparser2.parse(reader2); //converte o texto do ficheiro2 (aulas.json) em objetos java
            
            JSONObject aulasJsonobj = (JSONObject) obj2;
            
            JSONArray aulasArray = (JSONArray) aulasJsonobj.get("aulas");
            
            String arr2[] = new String[aulasArray.size()];  //array de todas as aulas no ficheiro json respetivo
            
            ////////////////////////////////////////////////////////////////////////////////////////////////////

			System.out.print("---------------------------------------------\n");
			System.out.print("Sistema de presenças da Universidade de Évora\n");
			System.out.print("---------------------------------------------\n");
			
			int auxiliarpassar2 = 0;
			
			while(auxiliarpassar2 == 0) {
				
				System.out.println("\n                                   ->    MENU    <-      ");
				System.out.println("\nEscolha a funcionalidade que quer:  (1-Leitor de cartões, 2-Gestão do Sistema, 3-Sair) ");
				Scanner inicio = new Scanner(System.in);
				int numero_inicio = inicio.nextInt();
				
					
				if(numero_inicio == 1) {
					
					System.out.println("\n------ Leitor de cartões ------");
					
					int auxiliarpassar = 0;
					
					while(auxiliarpassar == 0) {
						
						int auxiliar = 0;
						int contador_aulas = 1;

			        	for(int indice2 = 0; indice2 < aula.length; indice2++) {        //ciclo for que vai percorrer todas as aulas, 1 de cada vez, num intervalo de 2 minutos
			        		
			        		int confirma_docente = 0;
			        		
			        		System.out.println("\n----> " + contador_aulas + " Aula ");
			        		
			        		arr2[indice2] = "\nData: " + aula[indice2].data + " " + "Hora: " + aula[indice2].hora + " ";
			        		System.out.println(arr2[indice2]);
			        		contador_aulas++;
						
							while(System.currentTimeMillis() < end) {
									
								System.out.print("\nInsira o código do seu cartão: (exemplo = 000) ");
								System.out.println("\n(Para iniciar aula tem quer ser numero do docente) ");
								
								Scanner s = new Scanner(System.in);
								String numero_cartao = s.nextLine();
									
								System.out.println("\nNumero inserido: " + numero_cartao);
								
								for(int indice = 0; indice < array.length; indice++) {
									
									if(numero_cartao.equals(array[indice].cartão)) {               //se o numero introduzido corresponde a utilizador
										
										if(array[indice].papel.equals("docente")) {               //se o numero introduzido corresponde a um docente
											
											confirma_docente = 1;                                 //variavel para saber se é o primeiro a passar o cartão
											System.out.println("É o docente " + array[indice].nome);
											System.out.println("Aula iniciada. ");
											
											
										} else if(array[indice].papel.equals("aluno")) {     //se não for docente, e for aluno
											
											if(confirma_docente == 0) {                        //se o docente ainda não tiver passado, dá print num aviso
												
												System.out.println("\nO docente ainda não começou a aula. Não serão contabilizadas as presenças nem as faltas (até que o docente começe a sua aula). ");
												
											} else {				

													System.out.println("\nIdentificação: Nome -> " + array[indice].nome + "      Código do Cartão  -> " + array[indice].cartão + "      Papel  -> " + array[indice].papel + "\n");
													
													presenças[indice2].lista_presenças.add(array[indice].nome);
													presenças[indice2].lista_data_presenças.add(aula[indice2].data);
													presenças[indice2].valor_presença = 1;   //conta totalidade da presença
											}
										} 
										
										break;
										
									} else {
										
										continue;
									}
								}
							}
							
							t= System.currentTimeMillis() + 0;
							end = t+10000;
						}
			        	
			        	int numero_aulas = 1;
			        	
			        	for(int indice5 = 0; indice5 < aula.length; indice5++) {
			        		
			        		System.out.println("Presenças da Aula " + numero_aulas + ": " + presenças[indice5].lista_presenças);
			        		
			        		numero_aulas++;
			        	}
			        
			        	
			        	System.out.println("\nDeseja voltar ao menu ou à leitura de cartões?  (S: passa, N: volta)");
			        	Scanner s1 = new Scanner(System.in);
			        	String resposta = s1.nextLine();
			        	
			        	if(resposta.equals("S")) {
			        		
			        		auxiliarpassar = 1;
			        		break;
			        		
			        	} else if(resposta.equals("N")) {
			        		
			        		auxiliarpassar = 0;
			        		
			        	} else {
			        		
			        		System.out.println("\nInput não reconhecido. Voltando ao menu principal...");
			        		auxiliarpassar = 1;
			        	}
					}
			
				
				
			} else if(numero_inicio == 2) {
				
				int auxiliarpassar3 = 0;
				
				while(auxiliarpassar3 == 0) {
					
					System.out.println("\n\n----- Gestão do Sistema -----");
		        	
		        	System.out.println("\nQue funcionalidade pretende aceder?\n\n1: Consultar Presenças\n2: Consultar Faltas\n3 Consultar Lista de Dados do Utilizador\n4: Consultar Relatório de Faltas\n5: Justificar Faltas\n6: Sair do Sistema");
		        	
		        	
		        	Scanner scanner3 = new Scanner(System.in);
		        	int numero_scanner2 = scanner3.nextInt();
		        	
		        	if(numero_scanner2 == 1) {
		        		
		        		System.out.println("\n---- Consultar Presenças ---");
		        		
		        		int auxiliar5 = 0;
		        		
		        		while(auxiliar5 == 0) {
		        			
		        			auxiliar5 = 0;
		        			
		            		System.out.print("Insira o seu nome e o seu código do cartão: ");
		            		Scanner scanner4 = new Scanner(System.in);
		            		String login = scanner4.nextLine();
		            		String cartão = scanner4.nextLine();
		            		
		            		if(E_Utilizador(array, login, cartão) == 1) {
		            			
		            			
		            			System.out.println("\nEstá definido como aluno registado do sistema.\n");
		            			
		                		int numero_total_presenças = Consultar_Presenças(presenças, login, aula.length);
		                		
		                		System.out.println("\nTem um total de " + numero_total_presenças + " presenças num total de " + aula.length + " aulas");
		                		
		                		System.out.println("\nPretende continuar a consultar presenças? (1:Sim, 2:Não)");
		            			Scanner scanner10 = new Scanner(System.in);
		            			int escolha5 = scanner10.nextInt();
		            			
		            			if(escolha5 == 1) {
		            				
		            				auxiliar5 = 0;
		            				
		            			} else {
		            				
		            				auxiliar5 = 1;
		            				break;
		            			}
		                		
		            		} else if(E_Utilizador(array, login, cartão) == 2) {
		            			
		            			auxiliar5 = 0;
		            			
		            			System.out.println("\nEstá definido como docente registado do sistema.\n");
		            			
		            			System.out.println("Insira o nome do aluno do qual quer consultar a presença: ");
		            			Scanner scanner5 = new Scanner(System.in);
		            			String nome_escolhido = scanner5.nextLine();
		            			System.out.print("\n");
		            			
		                		int numero_total_presenças = Consultar_Presenças(presenças, nome_escolhido, aula.length);
		                		
		                		System.out.println("\nO aluno escolhido tem um total de " + numero_total_presenças + " presenças num total de " + aula.length + " aulas");
		            			
		                		System.out.println("\nPretende continuar a consultar presenças? (1:Sim, 2:Não)");
		            			Scanner scanner11 = new Scanner(System.in);
		            			int escolha6 = scanner11.nextInt();
		            			
		            			if(escolha6 == 1) {
		            				
		            				auxiliar5= 0;
		            				
		            			} else {
		            				
		            				auxiliar5 = 1;
		            				break;
		            			}
		            			
		            			
		            			
		            		} else {
		            			
		            			System.out.println("Desculpe mas não tem permissão para aceder a esta funcionalidade.\n");
		            		}
		        		}
		        
		        	} else if(numero_scanner2 == 2) { 
		        		
		        		int auxiliar4 = 0;
		        		
		        		System.out.println("\n---- Consultar Faltas ---");
		        		
		        		while(auxiliar4 == 0) {
		        			
		        			System.out.print("Insira o seu nome e o seu código do cartão: ");
		            		Scanner scanner4 = new Scanner(System.in);
		            		String login = scanner4.nextLine();
		            		String cartão = scanner4.nextLine();
		            		
		            		if(E_Utilizador(array, login, cartão) == 1) {
		            			
		            			System.out.println("\nEstá definido como aluno registado do sistema.\n");
		            			
		            				
		                			Faltas[] array_faltas2 = Lista_Faltas(array, presenças, login, faltas, aula);
		                    		
		                    		//System.out.println("\nTem um total de " + numero_total_presenças + " presenças num total de " + aula.length + " aulas");
		                			
		                			System.out.println("\nPretende continuar a consultar faltas? (1:Sim, 2:Não)");
		                			Scanner scanner9 = new Scanner(System.in);
		                			int escolha4 = scanner9.nextInt();
		                			
		                			if(escolha4 == 1) {
		                				
		                				auxiliar4 = 0;
		                				
		                			} else {
		                				
		                				auxiliar4 = 1;
		                				break;
		                			}
		                			
		                		
		            		} else if(E_Utilizador(array, login, cartão) == 2) {
		            			
		            			System.out.println("\nEstá definido como docente registado do sistema.\n");
		            			
		            				auxiliar4 = 0;
		            				int numero_total_presenças = 0;
		            				
		            				System.out.println("Insira o nome do aluno do qual quer consultar a falta: ");
		                			Scanner scanner5 = new Scanner(System.in);
		                			String nome_escolhido = scanner5.nextLine();
		                			System.out.print("\n");
		                			        			
		                			Faltas[] array_faltas2 = Lista_Faltas(array, presenças, nome_escolhido, faltas, aula);
		           
		                    		//System.out.println("\nO aluno escolhido tem um total de " + numero_total_presenças + " presenças num total de " + aula.length + " aulas");
		                			
		                			System.out.println("\nPretende continuar a consultar faltas? (1:Sim, 2:Não)");
		                			Scanner scanner8 = new Scanner(System.in);
		                			int escolha3 = scanner8.nextInt();
		                			
		                			if(escolha3 == 1) {
		                				
		                				auxiliar4 = 0;
		                				
		                			} else {
		                				
		                				auxiliar4 = 1;
		                			}

		            		} else {
		            			
		            			System.out.println("Desculpe mas não tem permissão para aceder a esta funcionalidade.\n");
		            			auxiliar4 = 1;
		            			auxiliarpassar3 = 0;
		            		}
		        		}
		        		

		        	} else if(numero_scanner2 == 3) {
		        		
		        		System.out.println("\n---- Importar Lista de Utilizadores ---");
		        		
		        		int auxiliar6 = 0;
		        		
		        		while(auxiliar6 == 0) {
		        			
		        			auxiliar6 = 0;
		        			
		        			System.out.print("\nInsira o seu nome e o seu código do cartão: ");
		            		Scanner scanner4 = new Scanner(System.in);
		            		String login = scanner4.nextLine();
		            		String cartão = scanner4.nextLine();
		            		
		            		if(E_Utilizador(array, login, cartão) == 2) {
		            			
		            			System.out.println("\nEstá definido como docente registado do sistema.\n");
		            			
		            			Utilizador[] array_users = Lista_Alunos();
		            			
		            			System.out.println("O que pretende fazer com a lista?  (U: para escolher utilizador especifico , T: lista de todos os utilizadores)");
		            			Scanner scanner5 = new Scanner(System.in);
		            			String nome_escolhido = scanner5.nextLine();
		            			        			
		            			if(nome_escolhido.equals("U")) {
		            				
		            				System.out.println("Insira o nome do utilizador em questão: ");
		            				Scanner scanner6 = new Scanner(System.in);
		                			String nome_escolhido2 = scanner6.nextLine();
		                			System.out.print("\n");
		                			
		                			for(int indice = 0; indice < array_users.length; indice++) {
		                				
		                				if(nome_escolhido2.equals(array_users[indice].nome)) {
		                					
		                					System.out.println("Dados do utilizador selecionado: ");
		                					System.out.printf("%-6s%-25s" , "Nome: " , array_users[indice].nome );
		                					System.out.printf("%-10s%-15s" , "Código Cartão: ", array_users[indice].cartão );
		                					System.out.printf("%-6s%-20s" ,"Papel: ",  array_users[indice].papel); 
		                					System.out.print("\n");
		                					
		                				} else {
		                					
		                					continue;
		                				}
		                			}
		                			
		            			} else if(nome_escolhido.equals("T")) {
		            				
		            				for(int indice2 = 0; indice2 < array_users.length; indice2++ ) {
		            					
		            					System.out.printf("%-6s%-25s" , "Nome: " , array_users[indice2].nome );
		            					System.out.printf("%-10s%-15s" , "Código Cartão: ", array_users[indice2].cartão );
		            					System.out.printf("%-6s%-20s" ,"Papel: ",  array_users[indice2].papel); 
		            					System.out.print("\n");
		            				}
		            				
		            			}
		            			
		            			System.out.println("\nPretende continuar a consultar lista de dados? (1:Sim, 2:Não)");
		            			Scanner scanner11 = new Scanner(System.in);
		            			int escolha7 = scanner11.nextInt();
		            			
		            			if(escolha7 == 1) {
		            				
		            				auxiliar6 = 0;
		            				
		            			} else {
		            				
		            				auxiliar6 = 1;
		            			}
		                		
		            			
		            		} else {
		            			
		            			System.out.println("Desculpe mas não tem permissão para aceder a esta funcionalidade.\n");
		            		}
		        		}
		        	
		        	} else if(numero_scanner2 == 4) {
		        		
		        		System.out.println("\n---- Relatório de Faltas ---");
		        		
		        		int auxiliar2 = 0;
		        		
		        		while(auxiliar2 == 0) {
		        			
		        			System.out.println("O que pretende fazer dentro desta funcionalidade?\n \n1: Listagem de alunos com o número de presenças e respectiva percentagem\n2: Lista de alunos com entre 25% e 50% de faltas\n3: Lista de alunos com mais de 50% de faltas ");
		            		System.out.print("R:");
		            		
		            		
		            		Scanner scanner6 = new Scanner(System.in);
		            		int escolha = scanner6.nextInt();
		            		
		            		if(escolha == 1) {
		            			
		            			Relatório_Faltas(aula, presenças, array, escolha);
		            			
		            		} else if(escolha == 2) {
		            			
		            			Relatório_Faltas(aula, presenças, array, escolha);
		            			
		            		} else if(escolha == 3) {
		            			
		            			Relatório_Faltas(aula, presenças, array, escolha);
		            			
		            		} else {
		            			
		            			System.out.print("Funcionalidade Relatório de Faltas não suporta a sua escolha. ");
		            		}
		            		
		            		System.out.print("Pretende continuar a consultar o Relatório de Faltas?  (1:Sim, 2: Não)");
		            		Scanner scanner7 = new Scanner(System.in);
		            		int escolha2 = scanner7.nextInt();
		            		
		            		if(escolha2 == 1) {
		            			
		            			auxiliar2 = 0;
		            			
		            		} else {
		            			
		            			auxiliar2 = 1;
		            		}
		        		}
		        		

		        		
		        	} else if(numero_scanner2 == 5) {
		        		
		        		System.out.println("\n---- Justificar Faltas ---");
		        		
		        		int auxiliar7 = 0;
		        		
		        		while(auxiliar7 == 0) {
		        			
		        			auxiliar7 = 0;
		        			
		        			System.out.print("Insira o seu nome e o seu código do cartão: ");
		            		Scanner scanner4 = new Scanner(System.in);
		            		String login = scanner4.nextLine();
		            		String cartão = scanner4.nextLine();
		            		
		            		if(E_Utilizador(array, login, cartão) == 1) {
		            			
		            			System.out.println("Desculpe mas não tem permissão para aceder a esta funcionalidade.\n");
		            			
		                		
		            		} else if(E_Utilizador(array, login, cartão) == 2) {
		            			
		            			System.out.println("\nEstá definido como docente registado do sistema.\n");
		            			
		            				
		                			System.out.println("Insira o nome do aluno do qual quer justificar a presença: ");
		                			Scanner scanner5 = new Scanner(System.in);
		                			String nome_escolhido = scanner5.nextLine();
		                			System.out.print("\n");
		                			
		                			Faltas[] array_faltas2 = Lista_Faltas(array, presenças, nome_escolhido,faltas, aula);
		                			
		                			Justificar_Faltas(array_faltas2, nome_escolhido, presenças, aula); 

		    	        	} else {
		    	        		System.out.println("Funcionalidade Relatório de Faltas não suporta a sua escolha. ");
		    	        	}
		            	
		            		System.out.print("\nQuer continuar a justificar faltas?  (1: Sim, 2: Não )");
		        			
		        			Scanner scanner9 = new Scanner(System.in);
		        			int numero10 = scanner9.nextInt();
		        			
		        			if(numero10 == 1) {
		        				
		        				auxiliar7 = 0;
		        			} else {
		        				
		        				auxiliar7 = 1;
		        			}
		        		}
		        	}  
		        	 else if(numero_scanner2 == 6)  {
		        		System.out.println("\nDesligando o sistema....");
						System.exit(0);
					}
				}
				
				} else if(numero_inicio == 3) {
					
					System.out.println("\nDesligando o sistema...");
					System.exit(0);
			}
		}
	}
			
			
			
        	
        	/////////////FUNÇÕES USADAS NA MAIN
	
		public static Utilizador[] Lista_Alunos() throws IOException, ParseException{
			
			JSONParser jsonparser = new JSONParser();
			
			FileReader reader = new FileReader(".\\ficheirosjson\\listaalunos.json");
			
            Object obj = jsonparser.parse(reader);  //converte o texto do ficheiro em objetos java
            
            JSONObject userloginJsonobj = (JSONObject) obj;
            
            JSONArray userloginsArray = (JSONArray) userloginJsonobj.get("listalunos");
            
            String arr[] = new String[userloginsArray.size()];   //array de todos os utilizadores no ficheiro json
            
            Utilizador[] array_utilizadores = new Utilizador[userloginsArray.size()];
            
            
            for(int j = 0; j < userloginsArray.size(); j++) {
				
				JSONObject user = (JSONObject) userloginsArray.get(j);
					
				String card = (String) user.get("cartao");
				String name = (String) user.get("nome");
				String role = (String) user.get("papel");	
				
				
				Utilizador utilizador = new Utilizador(name, card, role);
				
				array_utilizadores[j] = utilizador;
				
            }            
           return array_utilizadores;
		}	
		
		
		public static Aula[] Lista_Aulas() throws IOException, ParseException{
			
			JSONParser jsonparser2 = new JSONParser();
	        
	        FileReader reader2 = new FileReader(".\\ficheirosjson\\aulas.json");
	        
	        Object obj2 = jsonparser2.parse(reader2); //converte o texto do ficheiro2 (aulas.json) em objetos java
	        
	        JSONObject aulasJsonobj = (JSONObject) obj2;
	        
	        JSONArray aulasArray = (JSONArray) aulasJsonobj.get("aulas");
	        
	        String arr2[] = new String[aulasArray.size()];  //array de todas as aulas no ficheiro json respetivo
	        
	        Aula[] array_aulas = new Aula[aulasArray.size()];
	        
	        for(int p = 0; p < aulasArray.size(); p++) {
				
	        	JSONObject aulas1 = (JSONObject) aulasArray.get(p);
					
				String date = (String) aulas1.get("data");
	    		String time = (String) aulas1.get("hora");
				
				
				Aula aula = new Aula(date, time);
				
				array_aulas[p] = aula;
	        }            
	       return array_aulas;
		}
		
		public static int Consultar_Presenças(Presença[] presença, String nome_aluno, int tamanho) {
			
			int n_presenças = 0;
			int n_faltas = 0;
			
			for(int indice = 0; indice < tamanho ; indice++ ) {
				
				for(int index = 0; index < presença[indice].lista_presenças.size(); index++) {
					
					if(nome_aluno.equals(presença[indice].lista_presenças.get(index))) {
						
						n_presenças++;
						
						System.out.println("Tem " + presença[indice].valor_presença + " presença na data " + presença[indice].lista_data_presenças.get(index));
						break;
						
					} else {
						n_faltas++;
					}
				}		
			}
			return n_presenças;
		}
		
		public static Faltas[] Lista_Faltas(Utilizador utilizador[], Presença[] presença, String nome_aluno, Faltas[] falta, Aula[] aula/*, String nome_aluno, int tamanho, Faltas[] faltas, Aula[] aula /*, int tamanho2 tamanho das aulas)*/) {
			
				int auxiliar = 0;
				int contador_presenças = 0;
				int indice_auxiliar = 0;
				
				Faltas[] array_faltas = new Faltas[presença.length];
				
				int pointer2_faltas = 0;
				
				for(int indice_faltas = 0; indice_faltas < presença.length; indice_faltas++) {
					
					array_faltas[pointer2_faltas] = new Faltas();
					pointer2_faltas++;
				}
				
				array_faltas[0] = new Faltas();
				
				
				for(int indice = 0; indice <  presença.length; indice++) {
					
					for(int indice2 = 0; indice2 < presença[indice].lista_presenças.size(); indice2++) {
						
						if(nome_aluno.equals(presença[indice].lista_presenças.get(indice2))) {
							
							break;
							
						} else {
							auxiliar++;
							
						}
					}
					
					if(auxiliar == presença[indice].lista_presenças.size()) {
						
						array_faltas[indice].lista_faltas.add(nome_aluno);
						array_faltas[indice].lista_data_faltas.add(aula[indice].data);

						System.out.print("O aluno " + array_faltas[indice].lista_faltas);
						System.out.println(" tem uma falta no dia " + array_faltas[indice].lista_data_faltas);
						
						indice_auxiliar++;
						
					} else {
						
						contador_presenças++;
					}
					
					auxiliar = 0;

				}
				
			if(contador_presenças == presença.length) {
				
				System.out.println("\nO aluno não tem qualquer falta nas " + presença.length + " aulas registadas no sistema. ");
				
			} else  {
				
				System.out.println("\nO aluno tem " + indice_auxiliar + " faltas num total de " + presença.length + " aulas registadas no sistema.");
			}
			
			return array_faltas;    //return num vetor do tipo Faltas com todos alunos que faltaram á aula na data para o efeito
		}
		
		public static void Relatório_Faltas(Aula[] aula, Presença[] presença, Utilizador[] utilizador, int escolha) {
						
			System.out.println("\n\n-------- RELATÓRIO DE FALTAS ---------");
			
			System.out.println("\n Ao que pretende aceder?\n\n1: Listagem de alunos com o número de presenças e respectiva percentagem \n2: Lista de alunos com entre 25% e 50% de faltas \n3: Lista de alunos com mais de 50% de faltas");
			
			System.out.print("R:");
			
			System.out.print("\n");
			
			if(escolha == 1) {
				
				System.out.println("-> Listagem de alunos com o número de presenças e respectiva percentagem\n");
				
				int contador_de_presenças = 0;
				double percentagem = 0.0;
				
				for(int indice = 0; indice < utilizador.length; indice++) {  //array da lista json de utilizadores
					
					contador_de_presenças = 0;
					
					for(int indice2 = 0; indice2 < presença.length; indice2++) {   //array das presenças Presença[0], Presença[1]....
						
						for(int indice3 = 0; indice3 < presença[indice2].lista_presenças.size(); indice3++) {
							
							String nome = utilizador[indice].getNome();
							
							if(nome.equals(presença[indice2].lista_presenças.get(indice3))){
								
								contador_de_presenças++;
								
							} else {
								
								continue;
							}
						}
					}
					
					percentagem = ((double)contador_de_presenças / (double)aula.length) * 100;
					
					System.out.printf("%-11s%-25s", "Utilizador: ", utilizador[indice].getNome());
					System.out.printf("%-17s%-5s", "Número de Presenças: ", contador_de_presenças);
					System.out.printf("%-25s%-7s%-3s", "Percentagem de presenças: ", percentagem, "%");
					System.out.print("\n");
				}
				
			} else if(escolha == 2) {
				
				DecimalFormat df = new DecimalFormat(".0"); 
				
				System.out.println("-> Lista de alunos com entre 25% e 50% de faltas\n");
				
				int contador_de_presenças = 0;
				double percentagem = 0.0;
				int contador_de_faltas = 0;
				
				for(int indice = 0; indice < utilizador.length; indice++) {  //array da lista json de utilizadores
					
					for(int indice2 = 0; indice2 < presença.length; indice2++) {   //array das presenças Presença[0], Presença[1].... 
						
						contador_de_presenças = 0;
						
						for(int indice3 = 0; indice3 < presença[indice2].lista_presenças.size(); indice3++) {
							
							String nome = utilizador[indice].getNome();
							
							
							if(nome.equals(presença[indice2].lista_presenças.get(indice3))){
								
								contador_de_presenças++;
								
							} else {
								
								continue;
							}
						}
					}
					
					percentagem = ((double)contador_de_presenças / (double)aula.length) * 100.0;
					
					if(percentagem >= (double)50.0 && percentagem <= (double)75.0 ) {
						
						contador_de_faltas = aula.length - contador_de_presenças;
						
						if(utilizador[indice].papel.equals("docente")) {
							
							break;
						} 
						
						percentagem = 100.0 - percentagem;
						
						System.out.printf("%-11s%-25s", "Utilizador: ", utilizador[indice].getNome());
						System.out.printf("%-17s%-5s", "Número de faltas: ", contador_de_faltas);
						System.out.printf("%-25s%-7s%-3s", "Percentagem de faltas: ", percentagem, "%");
						System.out.print("\n");
						
					} else {
						
						continue;
					}
				}
				
			} else if(escolha == 3) {
				
				DecimalFormat df = new DecimalFormat("0.0"); 
				
				System.out.println("-> Lista de alunos com mais de 50% de faltas");
				
				int contador_de_presenças = 0;
				double percentagem = 0.0;
				int contador_de_faltas = 0;
				
				for(int indice = 0; indice < utilizador.length; indice++) {  //array da lista json de utilizadores
					
					contador_de_presenças = 0;
					
					for(int indice2 = 0; indice2 < presença.length; indice2++) {   //array das presenças Presença[0], Presença[1].... 
						
						for(int indice3 = 0; indice3 < presença[indice2].lista_presenças.size(); indice3++) {
							
							String nome = utilizador[indice].getNome();
							
							if(nome.equals(presença[indice2].lista_presenças.get(indice3))){
								
								contador_de_presenças++;
								
							} else {
								continue;
							}
						}
					}

					percentagem = ((double)contador_de_presenças / (double)aula.length) * 100.0;
					
					if(percentagem < 50.0) {
						
						contador_de_faltas = aula.length - contador_de_presenças;
						
						percentagem = 100.0 - percentagem;
						
						if(utilizador[indice].papel.equals("docente")) {
							
							break;
							
						} 
						
						System.out.printf("%-11s%-25s", "Utilizador: ", utilizador[indice].getNome());
						System.out.printf("%-17s%-5s", "Número de Faltas: ", contador_de_faltas);
						System.out.printf("%-25s%-7s%-3s", "Percentagem de faltas: ", percentagem, "%");
						System.out.print("\n");
					} 
				}
			}
		}
		
		public static void Justificar_Faltas(Faltas[] array_faltas, String nome_aluno, Presença[] presenças, Aula[] aula) {
			
			int contador_de_faltas = 0;
			
			for(int indice = 0; indice < array_faltas.length; indice++) {
				
				contador_de_faltas = 0;
				
				for(int indice2 = 0; indice2 < array_faltas[indice].lista_faltas.size(); indice2++) {
					
					for(int indice3 = 0; indice3 < presenças[indice].lista_presenças.size(); indice3++) {
						
						if(nome_aluno.equals(array_faltas[indice].lista_faltas.get(indice2))){
							
							contador_de_faltas++;
							
							System.out.println("Lista inicial de faltas: " + array_faltas[indice].lista_faltas);
							
							array_faltas[indice].lista_faltas.remove(indice2);
							array_faltas[indice].lista_data_faltas.remove(indice2);
							
							System.out.println("Lista final de faltas: " + array_faltas[indice].lista_faltas);
							
							System.out.println("Lista inicial de presenças: " + presenças[indice3].lista_presenças);
							
							presenças[indice].lista_presenças.add(nome_aluno);
							presenças[indice].lista_data_presenças.add(aula[indice2].data);
							
							System.out.println("Lista final de presenças: " + presenças[indice].lista_presenças);
							
							break;
						
						} else {
							
							continue;
						}
					}
				}
			}
		}
		
		public static int E_Utilizador(Utilizador[] utilizador, String nome, String cartão) {  //função que retorna 1 se o nome for de alqum aluno e 2 se for docente
			
			int valor_retorna = 0;
			
			for(int indice = 0; indice < utilizador.length; indice++) {
				
				if(nome.equals(utilizador[indice].nome) && cartão.equals(utilizador[indice].cartão)) {
					
					if(utilizador[indice].papel.equals("aluno")) {
						
						valor_retorna = 1;
						
					} else if(utilizador[indice].papel.equals("docente")) {
						
						valor_retorna = 2;
					}
										
				} else  {
					
					continue;
				}
			}
			return valor_retorna;
		}
}
