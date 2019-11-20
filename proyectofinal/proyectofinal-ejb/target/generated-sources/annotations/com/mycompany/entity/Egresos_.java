package com.mycompany.entity;

import com.mycompany.entity.Categoriaegresos;
import com.mycompany.entity.Controlfechas;
import com.mycompany.entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-19T08:36:52")
@StaticMetamodel(Egresos.class)
public class Egresos_ { 

    public static volatile SingularAttribute<Egresos, Categoriaegresos> categoriaEgresos;
    public static volatile SingularAttribute<Egresos, Integer> idEgreso;
    public static volatile SingularAttribute<Egresos, Long> valor;
    public static volatile SingularAttribute<Egresos, Controlfechas> fechas;
    public static volatile SingularAttribute<Egresos, Usuario> usuarioId;

}