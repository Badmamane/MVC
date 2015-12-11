package DAO;

import java.sql.Connection;

/**
 * Created by Badam on 11/12/2015.
 */
class AbstractDAO {
    protected void closeConnection(Connection connection) throws Exception {
        try {
            if (connection != null && (!connection.isClosed())) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur pendant la fermeture de la connection");
        }
    }
}
