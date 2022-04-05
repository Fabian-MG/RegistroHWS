package com.materia.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.materia.dto.MateriaDto;

public class MateriaDao {

	protected JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public boolean registrarMateria(String alumnoId, MateriaDto MateriaDto) {
    	
    	String sql = "SELECT MATERIA_ID FROM MATERIAS WHERE NOMBRE_MATERIA = ?";

        String materiaId = jdbcTemplate.queryForObject(sql, String.class, new Object[]{alumnoId});
        
        if(materiaId == null) 
        	throw new Error("La materia" + MateriaDto.getNombreMateria() + "no existe");
        
        jdbcTemplate.execute("INSERT INTO MATERIAS_POR_ALUMNOS (materia_id, alumno_id) VALUES('"
                + materiaId + "', '" + alumnoId
                + "')");
        
        return true;
    }
    
}
