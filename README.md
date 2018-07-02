# CONTROLENOTAS
Projeto de controle pessoal de rendimento acadêmico.

Este projeto tem por finalidade inicial, criar uma aplicação de gerenciamento pessoal de notas e rendimento acadêmico.


## UTILIZAÇÃO PELO USUÁRIO:

1. Cadastrar seus dados acadêmicos: Nome, Matrícula, Turma e etc.

2. Cadastrar o semestre e as disciplinas (informando os dados referentes à disciplina - Nome da disciplina, Professor, Número de avaliações,
notas, etc...)

## RETORNO ESPERADO:

1. Cálculo da média de cada disciplina.

2. Cálculo da conceito de acordo com a média da disciplina.

3. Cálculo do rendimento semestral de acordo com conceitos e cargas horária das disciplinas do semestre.

4. Cálculo do CRG de acordo com os conceitos e cargas horaria de todas as disciplinas.


## OBS:

Deverá ser implementado o CRUD com conexão ao H2 Database para facilitar a manipulação dos dados.

Poderá ser implementada uma interface gráfica para facilitar o uso.


## RECURSOS UTILIZADOS

1. ECLIPSE NEON EE

2. APACHE MAVEN 3.5.0

3. ORACLE JAVA JDK 8_144

4. TestNG

5. ObjectAid UM Explorer


### INSTALAÇÃO DOS RECURSOS UTILIZADOS
#### Java, Eclipse e Maven
* Baixe o arquivo zip (nos LINKS EXTERNOS) contendo os programas nas versões informadas anteriormente (opcional)

* De preferencia crie uma pasta na raiz do sistema para instalação do Eclipse e do Maven, ex: C:\\Desenvolvimento (opcional)

* Instale o Oracle Java SDK no diretório de sua preferência, mas recomendo instalar na padrão do sistema.

* Descompacte e copie o diretório do eclipse para a pasta de sua escolha (recomendo na C:\\Desenvolvimento)

* Instale o Apache Maven (Recomendo instalar em C:\\Desenvolvimento

#### TestNG
1. No Eclipse selecione Help -> Install New Software
2. No campo Work With cole o link <http://beust.com/eclipse> e clique em add
3. Insira o nome TestNG, clique Ok
4. Espere carregar e assim que aparecer o TestNG, marque-o e clique em next
5. Clique em next até aparecer para aceitar licenças, aceite e clique em finish
6. Após iniciada a instalação poderá aparecer uma janela Security Warning, clique em Install Anyway e espere a instalação terminar
7. Quando for terminada o eclipse pedirá para ser reiniciado, reinicie-o
9. Ao ser aberto novamente o TestNG já poderá ser utilizado

#### ObjectAid UML Explorer
1. Siga praticamente os mesmos passos de instalação do TestNG, mas utilize os dados abaixo:
Name: ObjectAid UML Explorer
Location (link): <http://www.objectaid.com/update/current>


+ Após instalar os programas devemos configurar o ambiente


### CONFIGURAÇÃO DO AMBIENTE

* É necessário criar variáveis de sistema e amiente, para ter acesso a essas configuraçães:
 Win(janelinha)+Pause Break -> Configurações Avançadas do Sistema -> Variáveis de Ambiente
 
* Crie ou edite a Variável de Usuário Path adicionando o caminho para \bin do Java JDK (ex: C:\Program Files\Java\jdk1.8.0_144\bin)

* Crie a Variável de Sistema JAVA_HOME adicionando o caminho da pasta do Java JDK (ex: C:\Program Files\Java\jdk1.8.0_144)

* Crie a Variável de Sistema M2_HOME adicionando o caminho da pasta do Maven (ex: C:\Desnvolvimento\build\apache-maven-3.5.0)

* Crie a Variável de Sistema M2 adicionando o valor %M2_HOME%\bin

* Crie a Variável de Sistema MAVEN_OPTS adicionando o valor -Xms256m -Xmx521m

* Edite a Variável de Sistema Path adicionando as linhas: %JAVA_HOME%\bin e %M2%

* Aperte OK nas janelas para validar as configurações

* Agora devemos testar se funcionou

* Pressione Win(janelinha)+R , digite cmd e aperte enter para abrir o Prompt

* No CMD digite mvn -version e aperte enter

* Se o ambiente foi configurado com sucesso, aparecerá: Apache Maven, Maven home, Java version, Java home, Default locale e OS name

### OBS:
Caso ocorra erro com as configurações do Maven no Eclipse ao iniciar , use as seguintes soluções:
1. Clique com o botão direito na pasta do projeto, selecione Maven -> Update Project, marque Force Update... e aperte OK
2. Caso o erro persista(e apareça algo assim: Cold not calculate build plan: Plugin...)
2.1. Selecione Window -> Preferences e pesquise por Maven
2.2. Selecione User Settings e em global settings coloque o caminho correto para o arquivo settings.xml do Maven (ex: C:\desenvolvimento\builds\apache-maven-3.5.0\conf\settings.xml)


## LINKS EXTERNOS

[link do zip](https://mega.nz/#!9cBDGS6b!6jh7UylLNfZuHBnpB1ikw9Awi1vJx8plm_4N0GjMoVE)

[Eclipse Neon](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/neon3)

[Oracle Java 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

[Maven Apache](https://maven.apache.org/download.cgi)

[Maven Repository](https://mvnrepository.com/)

[TutorialsPoint Maven Config](https://www.tutorialspoint.com/maven/maven_environment_setup.htm)
