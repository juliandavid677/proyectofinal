package com.mycompany.entity;

import com.mycompany.entity.Categoriaingresos;
import com.mycompany.entity.Controlfechas;
import com.mycompany.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-18T22:54:47")
@StaticMetamodel(Ingresos.class)
public class Ingresos_ { 

    public static volatile SingularAttribute<Ingresos, Integer> idIngreso;
    public static volatile SingularAttribute<Ingresos, Long> valor;
    public static volatile SingularAttribute<Ingresos, Controlfechas> fechas;
    public static volatile SingularAttribute<Ingresos, Categoriaingresos> catIngresos;
    public static volatile SingularAttribute<Ingresos, Usuario> usuarioId;

}