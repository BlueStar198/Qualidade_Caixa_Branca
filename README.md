# Qualidade_Caixa_Branca
## TESTADO EM VISUAL STUDIO CODE

# Teste de Caixa Branca

Este repositório contém um exemplo de código Java para demonstrar o teste de caixa branca.

## O que é Teste de Caixa Branca?

O teste de caixa branca, também conhecido como teste estrutural, é uma técnica de teste de software que se concentra na análise do código-fonte interno de um programa. Em vez de examinar apenas as entradas e saídas esperadas do software, o teste de caixa branca examina a estrutura interna do código para garantir que todas as instruções sejam executadas corretamente e que todos os caminhos possíveis sejam testados.

## Sobre o Exemplo de Código

O código Java neste repositório é um exemplo simples de uma classe de usuário que realiza operações de autenticação em um banco de dados. O método `verificarUsuario` é responsável por verificar se um determinado usuário e senha correspondem a uma entrada no banco de dados.

# Erros encontrados

## 1. Erro na Configuração do Driver JDBC
   - No método `conectarBD`, a linha `Class.forName("com.mysql.Driver.Manager").newInstance();` está incorreta.

## 2. Tratamento Inadequado de Exceções
   - O código atualmente engole (captura sem tratamento) exceções, o que pode ocultar problemas e dificultar a depuração de erros.
   
## 3. Vulnerabilidade à Injeção de SQL
   - A string SQL é construída de forma insegura, concatenando diretamente os valores dos parâmetros (`login` e `senha`) na consulta. Isso torna o código vulnerável a ataques de injeção de SQL, onde um invasor pode manipular os parâmetros para executar comandos SQL maliciosos.

## 4. Fechamento Inadequado de Recursos
   - Não há fechamento adequado dos recursos (`Connection`, `Statement`, `ResultSet`), o que pode levar a vazamento de recursos e problemas de desempenho.


# Documentação
- Não há documentação no código. 

## Nomenclatura de Variáveis e Constantes
- A nomenclatura das variáveis e métodos não está seguindo as convenções Java. Por exemplo, o método `conectarBD` poderia ser renomeado para `conectarBancoDeDados` para seguir um padrão mais claro e descritivo.

## Legibilidade e Organização
- O código precisa de melhorias em termos de legibilidade e organização. A falta de espaçamento entre as linhas e a ausência de quebras de linha dificultam a leitura do código.

## Tratamento de NullPointerException
- Não há tratamento explícito para `NullPointerException`.

## Arquitetura Utilizada
- Não fica claro qual arquitetura está sendo referida aqui.

#### Fechamento de Conexões
- O código não fecha adequadamente a conexão com o banco de dados após o uso. Isso pode causar vazamento de recursos e problemas de desempenho.


# Grafo de Fluxo Etapa 3
![image](https://github.com/BlueStar198/Qualidade_Caixa_Branca/assets/41968462/26eea9e7-33e4-4975-9dd1-d98cf6b1b6c3)

## Numeracao dos pontos do codigo

   //Inicio da classe
    public class User {
1:  public Connection conectarBD() {
2:  Connection conn = null;
3:  try{
4:  Class.forName("com.mysql.Driver.Manager").newInstance();
5:  String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
6:  conn = DriverManager.getConnection(url);
7:  } catch (Exception e) {}
8:  return conn;}
9:  public String nome="";
    public boolean result = false;
10: public boolean verificarUsuario (String login, String senha) {
11: String sql = "";
    Connection conn = conectarBD();
    //INSTRUÇÃO SQL
12: sql += "select nome from usuarios ";
    sql += "where login = " + "'" + login + "'";
    sql += "  and senha = " + "'" + senha + "';";
13: try {
14: Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
15: if (rs.next()) {
16: result = true;
    nome = rs.getString("nome");}
17: }catch (Exception e) {}
18: return result; }
    }
    //fim da class

## Caminhos

Caminho 1:[1;2;8;10;11;
           13;16;18]

Caminho 2:[1;2;8;10;13;
           15;18]

Caminho 3:[1;2;8;10;
           13;18]

Caminho 4:[1;8;10;18]

Caminho 5:[1;8;10;13;
           15;16;18]

Caminho 6:[1;8;10;13;
           15;18]

Caminho 7:[1;8;10;13;18]

Caminho 8:[1;8;10;18]

## Cálculo da complexidade ciclomática

V(G) = 5 REGIÕES.
V(G) = 21 ARESTAS.
V(G) = 18 NÓS.
CÁLCULO: V(G) = (ARESTAS – NÓS) + 2 = 5



