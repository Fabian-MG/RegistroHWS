package com.registro.business;

import java.util.List;

import com.materia.dao.MateriaDao;
import com.materia.dto.MateriaDto;

public class RegistroBusiness {
	private MateriaDao materiaDao;

	
	public void setMateriaDao(MateriaDao materiaDao) {
		this.materiaDao = materiaDao;
	}


	public String registrarHorario(String alumno_id, List<MateriaDto> materias) {
		String mensaje = "Horario registrado correctamente";
		try {
			for(MateriaDto materia : materias) {
				materiaDao.registrarMateria(alumno_id, materia);
			}
		}catch (Exception e) {
			mensaje = "Error al registrar el horario, " + e.getMessage();
		}
		
		return mensaje;
	}
	
}
