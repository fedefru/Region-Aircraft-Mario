package com.example.handlingformsubmission.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


import com.example.handlingformsubmission.model.Paises;

@Service
public class ContinentesRowMapper implements RowMapper<Paises> {
	
	@Override
	
	public Paises mapRow(ResultSet resultSet, int i) throws SQLException {
        Paises pais = new Paises();
        pais.setCountry(resultSet.getString("COUNTRY"));
        pais.setRegion(resultSet.getString("REGION"));
      
        return  pais;
    }
}
