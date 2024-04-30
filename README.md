# Qualidade_Caixa_Branca

#### Erros encontrados

1. *Erro na Configuração do Driver JDBC*
   - No método `conectarBD`, a linha `Class.forName("com.mysql.Driver.Manager").newInstance();` está incorreta.

2. *Tratamento Inadequado de Exceções*
   - O código atualmente engole (captura sem tratamento) exceções, o que pode ocultar problemas e dificultar a depuração de erros.
   
3. *Vulnerabilidade à Injeção de SQL*
   - A string SQL é construída de forma insegura, concatenando diretamente os valores dos parâmetros (`login` e `senha`) na consulta. Isso torna o código vulnerável a ataques de injeção de SQL, onde um invasor pode manipular os parâmetros para executar comandos SQL maliciosos.

4. *Fechamento Inadequado de Recursos*
   - Não há fechamento adequado dos recursos (`Connection`, `Statement`, `ResultSet`), o que pode levar a vazamento de recursos e problemas de desempenho.


#### Documentação
- Não há documentação no código. 

#### Nomenclatura de Variáveis e Constantes
- A nomenclatura das variáveis e métodos não está seguindo as convenções Java. Por exemplo, o método `conectarBD` poderia ser renomeado para `conectarBancoDeDados` para seguir um padrão mais claro e descritivo.

#### Legibilidade e Organização
- O código precisa de melhorias em termos de legibilidade e organização. A falta de espaçamento entre as linhas e a ausência de quebras de linha dificultam a leitura do código.

#### Tratamento de NullPointerException
- Não há tratamento explícito para `NullPointerException`.

#### Arquitetura Utilizada
- Não fica claro qual arquitetura está sendo referida aqui.

#### Fechamento de Conexões
- O código não fecha adequadamente a conexão com o banco de dados após o uso. Isso pode causar vazamento de recursos e problemas de desempenho. 
