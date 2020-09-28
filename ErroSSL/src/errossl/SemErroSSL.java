package errossl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SemErroSSL {

//Detalhes da Conexão    
    private static final String DATABASE="educaciencia";
    private static final String HOST="jdbc:mysql://localhost:3306/educaciencia";
    private static final String DRIVER="com.mysql.jdbc.Driver";
//Para tirar erro de SSL em alguns casos em que tem varios Bancos e Certificados
    //private static final String URL="jdbc:mysql://localhost:3306/educaciencia?useSSL=false";
    private static final String URL="jdbc:mysql://localhost:3306/educaciencia?useTimezone=true&serverTimezone=UTC&useSSL=false";

    private static final String USR="root";
    private static final String PWD="";

//Metodo conectar    
    public static Connection Conectar(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USR, PWD);
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }
//PARA TESTAR VIA SCRIPT    
//Metodo Main 
    public static void main(String[] args){
        if (Conectar() != null){
            System.out.println("Conexão realizada com sucesso com Banco de Dados Educa!");
        }
    }
}





