/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import javax.ws.rs.ApplicationPath;
//import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Eduardo Torrado
 */
@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

     public ApplicationConfig() {
       register( new CorsFilter() );
       packages("API");
   }
    
}
