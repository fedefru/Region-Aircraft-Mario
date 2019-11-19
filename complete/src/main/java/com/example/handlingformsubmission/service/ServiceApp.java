package com.example.handlingformsubmission.service;

import com.example.handlingformsubmission.Mappers.AirlinesRowMapper;
import com.example.handlingformsubmission.Mappers.ArrivesRowMapper;
import com.example.handlingformsubmission.Mappers.ContinentesRowMapper;
import com.example.handlingformsubmission.model.Airline;
import com.example.handlingformsubmission.model.Arrives;
import com.example.handlingformsubmission.model.Paises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceApp {

    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     *
     * @return
     */
    public  List<Airline> getAirlines(){
        String sql="select * from AIRLINES";
        List<Airline> query = jdbcTemplate.query(sql, new AirlinesRowMapper());
        query.forEach(item->System.out.println(item.getAirlineNameShort()));
        return query;
    }
    
    public  List<Paises> getContinentes(String region){
        String sql="select * from COUNTRIES where REGION = ?;";
      
        List<Paises> paises= jdbcTemplate.query(sql,new Object[]{region},new ContinentesRowMapper());
        return paises;
    }
    
    public  List<Arrives> getArrives(String valor, String valor1){
        String sql="SELECT DISTINCT AIRCRAFT FROM FLIGHTS where ARRIVE_TIME between ? and ? ;";
      
        List<Arrives> arrive= jdbcTemplate.query(sql,new Object[]{valor,valor1},new ArrivesRowMapper());
        
        return arrive;
    }
    


    /**
     *
     * @param shortName
     * @param longName
     * @return
     */
    public Integer getEconomySeatsFromAirlines(String shortName, String longName){
        String query="select * from AIRLINES where AIRLINE=?  and AIRLINE_FULL=? ;";
        List<Airline> airline= jdbcTemplate.query(query,new Object[]{shortName,longName},new AirlinesRowMapper());
        if(!airline.isEmpty()){
            Airline a= airline.get(0);
            return a.getEconomySeat();
        }
        return 0;
    }
}
