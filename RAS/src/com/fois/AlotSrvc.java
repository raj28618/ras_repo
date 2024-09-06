package com.fois;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
