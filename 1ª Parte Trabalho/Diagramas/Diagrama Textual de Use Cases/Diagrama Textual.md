## Use Cases

- #### Aluno passa cartão
  - Nome - Aluno passa cartão
  - Ator principal - Aluno

  - Caso de sucesso: 

    1. Aluno passa o seu cartão no leitor
    2. Sistema reconhece o aluno como estando na disciplina
    3. A sua presença na aula é confirmada no sistema

  - Extensões:

    **1**. Aluno não passa o cartão durante a hora da aula
        
        1a. Sistema marca falta ao aluno

        1b. Sistema verifica número de faltas do aluno

        1c. Sistema envia emails consoante o número de faltas do aluno


    **2**. Leitor assume que passou 1 hora de aula

        2a. Sistema contabiliza apenas meia presença na aula


    **3**. Aluno não está inscrito na disciplina
  
        3a. Sistema não contabiliza a presença

        3b. Sistema envia email ao docente com o sucedido





- #### Docente passa o cartão
  - Nome - Docente passa o cartão
  - Ator principal - Docente

  - Caso de sucesso: 

    1. Docente passa o cartão respetivo
    2. Aula é iniciada podendo os alunos passarem os seus cartões para contabilização das presenças
    3. Se quiser o docente pode justificar as faltas 

  - Extensões:

    **1**. Docente não passa cartão
        
        1a. Aula não é iniciada
  
        1b. Sistema assume que não podem ser marcadas faltas ao alunos



- #### Ações do sistema
  - Nome - Ações do sistema
  - Ator principal - Sistema

  - Caso de sucesso: 

    1. Sistema regista presença dos alunos que passarem o seu cartão na hora da disciplina
    2. Sistema regista falta aos alunos que não passarem o seu cartão na hora da disciplina
    3. Se necessário, sistema envia emails após saber o número de faltas dos alunos
    4. Sistema adiciona ao relatório os dados do momento para que possa este ser entregue no final do semestre
