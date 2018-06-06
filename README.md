# controlenotas
Projeto de controle pessoal de rendimento acadêmico.

Este projeto tem por finalidade inicial, criar uma aplicação de gerenciamento pessoal de notas e rendimento acadêmico.


UTILIZAÇÃO PELO USUÁRIO:

1 - Cadastrar seus dados acadêmicos: Nome, Matrícula, Turma e etc.

2 - Cadastrar o semestre e as disciplinas (informando os dados referentes à  disciplina - Nome da disciplina, Professor, Número de avaliações,
notas, etc...)

RETORNO ESPERADO:

1 - Cálculo da conceito de acordo com a média da disciplina.

2 - Cálculo do rendimento semestral de acordo com conceitos e cargas horária das disciplinas do semestre.

2 - Cálculo do CRG de acordo com os conceitos e cargas horaria de todas as disciplinas.


OBS:

Deverá ser implementado o CRUD com conexÃ£o ao H2 Database para facilitar a manipulação dos dados.

Poderá ser implementada uma interface gráfica para facilitar o uso.


RECURSOS UTILIZADOS

1 - ECLIPSE NEON EE

2 - APACHE MAVEN 3.5.0

3 - ORACLE JAVA JDK 8_144


INSTALAÇÃO DOS RECURSOS UTILIZADOS

Baixe o arquivo zip (nos LINKS EXTERNOS) contendo os programas nas versões informadas anteriormente (opcional)

De preferencia crie uma pasta na raiz do sistema para instalação do Eclipse e do Maven, ex: C:\\Desenvolvimento (opcional)

Instale o Oracle Java SDK no diretório de sua preferência, mas recomendo instalar na padrão do sistema.

Copie o diretório do eclipse para a pasta de sua escolha (recomendo na C:\\Desenvolvimento)

Instale o Apache Maven (Recomendo instalar em C:\\Desenvolvimento

Após instalar os programas devemos configurar o ambiente


CONFIGURAÇÃO DO AMBIENTE

É necessário criar variáveis de sistema e amiente, para ter acesso a essas configurações:
 Win(janelinha)+Pause Break -> Configurações Avançadas do Sistema -> Variáveis de Ambiente
 
Crie ou edite a Variável de Usuário Path adicionando o caminho para \bin do Java JDK (ex: C:\Program Files\Java\jdk1.8.0_144\bin)

Crie a Variável de Sistema JAVA_HOME adicionando o caminho da pasta do Java JDK (ex: C:\Program Files\Java\jdk1.8.0_144)

Crie a Variável de Sistema M2_HOME adicionando o caminho da pasta do Maven (ex: C:\Desnvolvimento\build\apache-maven-3.5.0)

Crie a Variável de Sistema M2 adicionando o valor %M2_HOME%\bin

Crie a Variável de Sistema MAVEN_OPTS adicionando o valor -Xms256m -Xmx521m

Edite a Variável de Sistema Path adicionando as linhas: %JAVA_HOME%\bin e %M2%

Aperte OK nas janelas para validar as configurações

Agora devemos testar se funcionou

Pressione Win(janelinha)+R , digite cmd e aperte enter para abrir o Prompt

No CMD digite mvn -version e aperte enter

Se o ambiente foi configurado com sucesso, aparecerá: Apache Maven, Maven home, Java version, Java home, Default locale e OS name


LINKS EXTERNOS

https://mega.nz/#!9cBDGS6b!6jh7UylLNfZuHBnpB1ikw9Awi1vJx8plm_4N0GjMoVE (link do zip)

http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/neon3

http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html

https://maven.apache.org/download.cgi

https://mvnrepository.com/

https://www.tutorialspoint.com/maven/maven_environment_setup.htm