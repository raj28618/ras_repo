package com.fois;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import com.fois.dao.OracleDbConn;
import java.sql.ResultSet;
import java.sql.Statement;



@Path("rasalotsrvc")
public class AlotSrvc {
    public AlotSrvc() {
        super();
    }


    @GET
    @Produces("text/html")
    @Path("ironore/{alotmentDate}")
    public String gnrtIronOreAllotment(@PathParam("alotmentDate") String alotDate){
        
        if(alotDate!=null)
            return "<html><body bgcolor='#054' text='white'><h2>RAS Iron Ore Allotment for "+alotDate+" has been generated successfully!!</h2></body></html>";
        else 
            return "<html><body bgcolor='#054' text='white'><h2>InSufficient Inputs For Allotment Generation...</h2></body></html>";
    }


    @GET
    @Produces("text/html")
    @Path("coal/{alotmentDvsn}/{alotmentDate}")
    public String gnrtCoalAllotment(@PathParam("alotmentDvsn") String alotDvsn, @PathParam("alotmentDate") String alotDate){
        
        if(alotDvsn!=null && alotDate!=null)
            return "<html><body bgcolor='#042' text='white'><h2>Coal Allotment for "+alotDate+" has been generated successfully!! for "+alotDvsn+"</h2></body></html>";
        else 
            return "<html><body bgcolor='#042' text='white'><h2>InSufficient Inputs For Allotment Generation...</h2></body></html>";
        
    }
    
    @GET
    @Produces("text/html")
    @Path("checkDB")
    public String chckDbConn(){
            String retVal="";
        try{
                    Connection conn = OracleDbConn.getOracleConnection();
                    String qry = "SELECT   TO_CHAR(SYSDATE,'DD-MM-YYYY HH24:MI:SS') FROM DUAL";
                    Statement stmnt = conn.createStatement();
                    ResultSet rs = stmnt.executeQuery(qry);
                    String currentDate="";
                    if(rs.next())
                    {
                            currentDate = rs.getString(1);
                    }
                    if(currentDate!=null || !currentDate.equals(""))
                        retVal= "<html><body bgcolor='#042' text='white'><h2>Connection To Database Established Successfully At:: "+currentDate+"</h2></body></html>";
                    else
                        retVal= "<html><body bgcolor='#042' text='white'><h2>Unable To Connect To Database</h2></body></html>";
                
            }
            catch(Exception ex)
            {
                    ex.printStackTrace();    
            }
            return retVal;
            
            
}

}
