package com.mycompany.entity;

import com.mycompany.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-18T22:54:47")
@StaticMetamodel(Controlfechas.class)
public class Controlfechas_ { 

    public static volatile SingularAttribute<Controlfechas, Date> fechaInicio;
    public static volatile SingularAttribute<Controlfechas, String> nombreRango;
    public static volatile SingularAttribute<Controlfechas, Date> fechaFin;
    public static volatile SingularAttribute<Controlfechas, Usuario> usuarioId;
    public static volatile SingularAttribute<Controlfechas, Integer> idFechaPrimaria;

}