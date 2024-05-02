package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Esta é a classe User, ela lida com a autenticação de usuários e a conexão com o banco de dados.
 */
public class User {

    /**
     * Método para conectar ao banco de dados.
     * @return A conexão estabelecida.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Vamos carregar o driver JDBC do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // URL para a conexão com o banco de dados
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            // Tentando conectar
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Se algo der errado na conexão, vamos lidar com isso aqui
        }
        return conn;
    }

    // Variáveis de instância
    public String nome = ""; // O nome do usuário
    public boolean result = false; // Indica se a autenticação foi bem-sucedida ou não

    /**
     * Método para verificar se as credenciais do usuário estão corretas.
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @return true se as credenciais estiverem corretas, false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();
        
        // Consulta SQL para verificar o usuário e senha no banco de dados
        sql += "SELECT nome FROM usuarios ";
        sql += "WHERE login = '" + login + "'";
        sql += " AND senha = '" + senha + "';";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            // Se a consulta retornar algum resultado, significa que o usuário está autenticado
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Lidando com possíveis exceções durante a consulta SQL
        }
        return result;
    }
}//fim da classe
