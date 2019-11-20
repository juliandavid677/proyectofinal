/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.interfaces.IUsuarioFacade;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Eduardo Torrado
 */
@Path("/loginFinanciapp")
public class ServiceLogin {
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validar(DTO_Usuario usuario) throws NoSuchAlgorithmException{
        System.out.println(usuario.getNombre() + "  " + usuario.getClave());
        DTO_Usuario us;
        String contrasena = contraseña(usuario.getClave());
        us = usuarioInterface.iniciarSesion(usuario.getCorreo(), contrasena); 
        if(us != null){
            String KEY = "mi_clave";
            Long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, KEY)
                    .setSubject(us.getNombre())
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo + 9000000))
                    .claim("nombre", us.getNombre())
                    .claim("email", us.getCorreo())
                    .compact();
            JsonObject json = Json.createObjectBuilder().add("JWT",jwt).build();
            return Response.status(Response.Status.CREATED).entity(json).build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    
    @GET
    public JsonArray factorial() {
        JsonArrayBuilder array = Json.createArrayBuilder();
        array.add("Amarillo");
        array.add("Verde");
        System.out.println(array);
        return array.build();
        /*Response.ok()
               .header("Access-Control-Allow-Origin", "*")
               .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
               .allow("OPTIONS").entity(saludo).build();*/
    }
    
    
    /**
     * Metodo que cifra la contraseña
     * @param password contraseña del usuario
     * @return contraseña cifrada
     * @throws NoSuchAlgorithmException
     */
    public String contraseña(String password) throws NoSuchAlgorithmException{
    
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashText = number.toString(16);
            while(hashText.length()<32){
                hashText = "0"+hashText;
            }
            String cifPass = hashText;
            return cifPass;
    }
}
