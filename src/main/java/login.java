
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public login() {
        // TODO Auto-generated constructor stub
    }
    
    String db_url = null;
    String db_usr = null;
    String db_psw = null;
    Connection conn = null;
    
	
	public void init(ServletConfig cfg){
    	try{
	    	super.init(cfg);
	    	
	    	db_url = cfg.getInitParameter("db_url");
	    	db_usr = cfg.getInitParameter("db_usr");
	    	db_psw = cfg.getInitParameter("db_psw");
	    	
	    	db_url="jdbc:mysql://"+db_url;
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	conn = DriverManager.getConnection(db_url,db_usr,db_psw);
	    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	public void doGet(HttpServletRequest reqt, HttpServletResponse res)
	{
		
		
		
		String username = reqt.getParameter("username");
		String password = reqt.getParameter("password");
		//password = encryptPassword(password);
		
		String query = "SELECT username FROM studente WHERE username = '"+ username + "' AND password = '"+ password + "'";
		
		try {
			
			ResultSet result = conn.createStatement().executeQuery(query);
			if(result.next()) {
				
				HttpSession sess = reqt.getSession();

				if(sess != null) {
					sess.invalidate();
				}
				sess = reqt.getSession();
				sess.setAttribute("username", username);
				
				
				
				
			}else {
				
				//lancio unecezzione penso	
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void doPost(HttpServletRequest reqt, HttpServletResponse res)
	{
		doGet(reqt,res);
	}
	
	private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}