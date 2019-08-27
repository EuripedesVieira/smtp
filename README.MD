Aplicação implementando protocolo SMTP

Iniciar um novo projeto Java 

Baixar a API JavaMail no link: https://www.oracle.com/technetwork/java/index-138643.html.

Descompactar o arquivo .zip

Adicionar os pacotes e o subpacotes .jar no projeto

 Configurando Gmail
Ativar acesso IMAP.

Configurar Google conta
 Ativar “Verificação em duas etapas”.
Gerar uma senha para terceiros (senha de app).

Adicionar usuário de gmail e senha em PasswordAuthentication. Exemplo:
return new PasswordAuthentication("user@gmail.com","senhaGerada");

Executar a aplicação e preencher os campos, “Enviar para”,”Assunto”, e “Mensagem”.

Repositórios:
https://github.com/EuripedesVieira/smtp/blob/master/src/SMTP/Interface.java
https://github.com/gabrielifg/GabrielIfg

Alunos: Euripedes Vieira, Gabriel Eduardo, Marcos Vinícius.

