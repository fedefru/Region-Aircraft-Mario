package com.example.handlingformsubmission.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.handlingformsubmission.model.Arrives;


@Service
public class ArrivesRowMapper implements RowMapper<Arrives> {
	
	@Override
	
	public Arrives mapRow(ResultSet resultSet, int i) throws SQLException {
        Arrives arrive = new Arrives();
        arrive.setAircraft(resultSet.getString("AIRCRAFT"));
        
        return arrive;
    }
}