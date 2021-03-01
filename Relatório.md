 # Relatório de Trabalho

## Introdução

 - Começámos por alterar o nosso diagrama de use cases com base nas alterações que o professor nos indicou e seguidamente começámos a executar o código referente à pesquisa do número do cartão para que 
seja feita a identificação do usuário.

 - Após feita a identificação do usuário (com base no ficheiro Json disponibilizado pelo professor, sendo que foi adicionado um array para ser mais fácil a pesquisa) tentámos perceber como procederiamos 
para distinguir as várias ações de cada um deles (docente e professor).

 - Seguidamente decidimos fazer a leitura da data e horas das aulas. Usando o mesmo método json fizemos então o suposto. Procedemos então depois à conjugação das datas e horas com os utilizadores que podem 
passar o código no leitor, para assim podermos marcar as presenças respetivas.

- O diagrama de classes foi melhorado ao longo do trabalho consoante aquilo que necessitámos.

## Classes

- Foram feitas classes para organização de dados e armazenamento de informações úteis no gerenciamento das presenças dos utilizadores.

- Classe Main onde juntamos todas as outras funções e fazemos com que as aulas sejam inicializadas, as presenças e as faltas contabilizadas e ainda onde podemos aceder ao menú para justificar as faltas de qualquer aluno (apenas permitido aos docentes).

- Classe Aulas com 2 atributos, sendo eles Data e Hora que permite localizar a aula posteriormente

- Classe Faltas com 5 atributos nome, cartão, lista_faltas, valor_falta e lista_data_faltas, que é usada para contabilizar o número de faltas

- Classe Presença com 5 atributos nome, cartão, lista_presenças, valor_presenças e lista_data_presenças sendo esta usada posteriormente na marcação das presenças na main

- Classe Utilizador com 3 atributos nome, cartão e papel que permite disntinguir todos os utilizadores do ficheiro json posteriormente

## Funções

- Usámos uma função Utilizador[] lista_alunos para retornar um array com todos os utilizadores identificados

- Usámos uma função Aula[] Lista_Aulas para retornar um array com todas as datas das aulas

- A função Consultar_Presenças(Presença[] presença, String nome_aluno, int tamanho) retorna o número de presenças do aluno em questão

- A função Faltas[] Lista_Faltas(Utilizador utilizador[], Presença[] presença, String nome_aluno, Faltas[] falta, Aula[] aula retonra um array com as faltas de um aluno

- A função Relatório_Faltas(Aula[] aula, Presença[] presença, Utilizador[] utilizador, int escolha) consoante o número de faltas de cada aluno do array utilizador, gera em forma de prints os relatórios pedidos pelo professor

- A função Justificar_Faltas(Faltas[] array_faltas, String nome_aluno, Presença[] presenças, Aula[] aula) justifica a falta de um aluno escolhido, dando também print da lista inicial de faltas e da final de presenças (para ser ver que passou de uma falta para uma presença pois foi justificada)

- A função E_Utilizador(Utilizador[] utilizador, String nome, String cartão) retorna 1 se for um aluno o utilizador, ou 2 se for um docente

## Testes

- Foram implementados alguns testes JUnit para testar de forma exaustiva as funcionalidades do sistema.

- Foram primeiramente implementados testes unitários para as classes Utilizador e Aula.

- Foram feitas na parte do código 5 classes mais os testes, sendo elas nomeadas de Aula, Faltas, Presença, Utilizador e a função Main.

- Depois de termos efetuado estas funções procedemos para criar testes unitários de forma a testar todas as nossas classes no entanto encontrámos uma dificuldade que não conseguimos resolver e por isso não conseguimos ter os testes de listas de arrays a funcionar, no entanto todas as classes estão a ser testadas.


## Linguagem

- Java
