package com.fois.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

public class OracleDbConn {
    
    private static Connection conn;
    
    
    public OracleDbConn() {
        super();
    }
    
    
    public static Connection getOracleConnection()
    {
        
        if(conn==null)
        {
            try
            {
                    Context ctx = new InitialContext();
                    DataSource ds = (DataSource)ctx.lookup("RAS");
                    conn = ds.getConnection();
                    if(conn!=null)
                        System.out.println("Connection to DB established Successfully!!");
                    else 
                        System.out.println("Unable To Connect To Database...");
                
            }
            catch(Exception ex)
            {
                
                ex.printStackTrace();
            }
            
            
        }
        
        return conn;    
    }
}
