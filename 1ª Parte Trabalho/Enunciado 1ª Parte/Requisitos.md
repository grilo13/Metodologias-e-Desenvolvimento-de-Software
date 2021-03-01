# Sistema automático de registo de presenças nas aulas
## Descrição do sistema

Pretende-se desenvolver um sistema automático de registo de presenças nas aulas de MDS. O sistema deve permitir registar as presenças dos alunos e dos professores automaticamente, através da leitura do cartão de aluno ou docente, respectivamente. Os requisitos do sistema estão descritos abaixo.



    - O sistema deve possuir uma configuração persistente, onde estão definidas as aulas (data, hora, duração e tipo);


    - O sistema deve importar a lista de alunos inscritos à disciplina a partir do SIIUE;


    - Na hora da aula, o docente e os alunos passam os seus cartões no leitor de cartões, sendo contabilizada a sua presença nessa aula;


    - Quando o docente não passa o seu cartão, considera-se que não houve aula e, consequentemente, não são contabilizadas as faltas;


    - Sempre que um aluno atinja 25% de faltas, o sistema deve enviar um email ao aluno e outro aos docentes a informar sobre esta situação;


    - Sempre que um aluno atinja 50% de faltas, o sistema deve enviar um email ao aluno, aos docentes e ao director de curso a informar sobre esta situação;


    - Se um aluno passa o seu cartão depois de decorrida 1h sobre a hora de início da aula, apenas será considerada meia presença;


    - A cada hora de aula, o sistema deve avaliar as condições acima, enviando automaticamente os emails necessários;


    - A qualquer momento, o docente deve poder alterar o estado de faltas como justificadas ou injustificadas;


    - No final do semestre é gerado um relatório com a seguinte informação:


        - Listagem de alunos com o número de presenças e respectiva percentagem;


        - Gráfico de presenças por aula, ao longo do tempo;


        - Lista de alunos com entre 25% e 50% de faltas;


        - Lista de alunos com mais de 50% de faltas;

