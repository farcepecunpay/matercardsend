package es.pecunpay.mastercardsend.bbdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
public class ManagerBBDD {
    static Connection connection = null;
    static Statement stmt = null;
    @Value("spring.datasource.url")
    private static String bbdd;
    @Value("spring.datasource.username")
    private static String user;
    @Value("spring.datasource.password")
    private static String pass;
    public static void connectDatabase() {
	try {
	    try {
		Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException ex) {
		System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
	    }
	    connection = DriverManager.getConnection(bbdd, user, pass);
	} catch (java.sql.SQLException sqle) {
	    System.out.println("Error: " + sqle);
	}
    }
    public static void insertarInicio(List datos) {
	try {
	    connectDatabase();
	    stmt = connection.createStatement();
	    String sql = "INSERT INTO public.transferencias_mcs (id_tra_mcs, usu_created, ts_created, usu_modified, ts_modified, payment_type, estado, nummp, fechahoraoperacion, id_acuerdo_origen, num_acuerdo, id_medio_pago, id_acuerdo, nombre_emisor, apellido_emisor, importe, comision) VALUES('"
		    + datos.get(0) + "', 'UJ0001', current_timestamp,'UJ0001',current_timestamp, '" + datos.get(1)
		    + "', '" + datos.get(2) + "', '" + datos.get(3) + "', '" + datos.get(4) + "','" + datos.get(5)
		    + "','" + datos.get(6) + "','" + datos.get(7) + "','" + datos.get(8) + "','" + datos.get(9) + "','"
		    + datos.get(10) + "','" + datos.get(11) + "','" + datos.get(12) + "')";
	    stmt.execute(sql);
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (!connection.isClosed()) {
		    connection.close();
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
}
