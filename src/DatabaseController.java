import model.User;

import java.sql.*;

public class DatabaseController {

    private String databaseUrl="jdbc:sqlite:UserDetails.db";
    private String TABLE_CREATOR="CREATE TABLE IF NOT EXISTS ";

    private String userTableNAME ="userDatabase";
    private String userTableCOLUMNS ="(UserName TEXT NOT NULL PRIMARY KEY,Password TEXT,Email TEXT,Phone TEXT,WalletBalance TEXT)";
    private String userInsertParameters =" (UserName,Password,Email,Phone,WalletBalance)";
    private Connection conn=null;
    private Statement statement=null;
    public void initialiseDatabase() {
        try {
            conn= DriverManager.getConnection(databaseUrl);
            statement=conn.createStatement();
            statement.execute(TABLE_CREATOR+userTableNAME+userTableCOLUMNS);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addUser (String userName,String password,String email,String phone,String walletBalance) throws SQLException{
        statement.execute("INSERT INTO "+ userTableNAME + userInsertParameters +" VALUES('"+userName+"','"
                +password+"','"+email+"','"+phone+"','"+walletBalance+"')");
    }
    public String Verify(String username) {

        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT Password FROM " + userTableNAME + " WHERE UserName = '" +username+ "'" );
                if(resultSet.next()) {
                    return resultSet.getString("Password");
                }else {
                    return "null";
                }

            } else {
                return "Connection is Closed";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Exception";
        }
    }
    public  User getUserDetails(String userName)
    {
        User user = null;
        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT Password FROM " + userTableNAME + " WHERE UserName = '" +userName+ "'" );
                if(resultSet.next()) {
                    String password = resultSet.getString("Password");
                    String phnnumber = resultSet.getString("Phone");
                    String walletBalance = resultSet.getString("WalletBalance");
                    String email = resultSet.getString("Email");
                  user = new User(userName,password,walletBalance,phnnumber,email);
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return  user;
    }
    public String checkUser(String username){
        int x =0;
        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT UserName FROM userDataBase" );
                while (resultSet.next())
                {
                    String u = resultSet.getString("UserName");
                    if(u.equals(username))

                    {
                        //  JOptionPane.showMessageDialog(null,"UserName Already Exists");
                        x=1;
                    }
                }
                if (x==1)
                {
                    return "s";
                }
                else return "f";

            } else {
                return "f";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return "f";
    }
    public void closeDatabaseConnection() {
        try {
            if (!conn.isClosed()) {
                statement.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

}
