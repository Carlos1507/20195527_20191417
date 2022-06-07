package com.example._20195527_20191417.daos;

import com.example._20195527_20191417.beans.ActoresBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class problem1Dao {
    private String user= "root";
    private String pass= "root";
    private String url = "jdbc:mysql://localhost:3306/sakila";

    public ArrayList<ActoresBean> listar_ActoresVersa(){
        ArrayList<ActoresBean> listaActores= new ArrayList<ActoresBean>();
        String sql= obtener_sql();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection conn= DriverManager.getConnection(url,user,pass);
                Statement statement= conn.createStatement();
                ResultSet rs= statement.executeQuery(sql)){
                while(rs.next()){
                    ActoresBean actor= new ActoresBean();
                    actor.setID(rs.getInt(1));
                    actor.setNombre(rs.getString(2));
                    actor.setCantCategorias(rs.getInt(3));
                    actor.setCantPeliculas(rs.getInt(4));
                    actor.setNombre(convertir_Nombres(actor.getNombre()));
                    listaActores.add(actor);
                }
            }
        }catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
        return listaActores;
    }

    public String obtener_sql(){
        String sql= "select a.actor_id as `ID`, " +
                "       concat(a.first_name,' ', a.last_name) as 'Nombre Completo', m.`Categorias` as 'Cantidad Categorias',count(l.language_id) as `Cantidad Peliculas` " +
                "from actor a " +
                "         inner join film_actor k on (k.actor_id=a.actor_id) " +
                "         inner join film f on (f.film_id=k.film_id) " +
                "         inner join language l on (l.language_id=f.language_id) " +
                "         inner join (select n.actor_id, count(n.category_id) as `Categorias` from (select distinct c.category_id, a.actor_id, a.first_name, " +
                "                                                                                                   c.name " +
                "                                                                                   from actor a " +
                "                                                                                            inner join film_actor k on (k.actor_id=a.actor_id) " +
                "                                                                                            inner join film f on (f.film_id=k.film_id) " +
                "                                                                                            inner join film_category j on (j.film_id=f.film_id) " +
                "                                                                                            inner join category c on (c.category_id=j.category_id) " +
                "                                                                                   order by a.actor_id) n " +
                "                     group by n.actor_id) m on (m.actor_id = a.actor_id) " +
                "where (upper(a.first_name) like '%LO%' or upper(a.last_name) like '%LO%') and l.name='English' " +
                "group by `ID` " +
                "having `Cantidad Peliculas`>20 and `Cantidad Categorias`>12 " +
                "order by `ID`";
        return sql;
    }
    public String convertir_Nombres(String nombre){
        String[] a;
        a= nombre.split(" ");
        String x= a[0], y= a[1];
        String[] x_new= x.split("");
        String[] y_new= y.split("");
        x="";
        y=" ";
        int i=0;
        while(i<x_new.length){
            if(i!=0){
                x_new[i]=x_new[i].toLowerCase(Locale.ROOT);
            }
            x+=x_new[i];
            i++;
        }
        i=0;
        while(i<y_new.length){
            if(i!=0){
                y_new[i]=y_new[i].toLowerCase(Locale.ROOT);
            }
            y+=y_new[i];
            i++;
        }
        return x+y;
    }
}
