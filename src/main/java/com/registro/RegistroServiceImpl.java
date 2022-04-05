/**
 * RegistroServiceSkeleton.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.0 Built on : Aug 01,
 * 2021 (07:27:19 HST)
 */
package com.registro;

import java.util.ArrayList;
import java.util.List;

import com.materia.dto.MateriaDto;
import com.registro.business.RegistroBusiness;

/** RegistroServiceSkeleton java skeleton for the axisService */
public class RegistroServiceImpl extends RegistroServiceSkeleton {


	RegistroBusiness registroBusiness;
	
	
  public void setRegistroBusiness(RegistroBusiness registroBusiness) {
		this.registroBusiness = registroBusiness;
	}


/**
   * Auto generated method signature
   *
   * @param registrarHorarioRequest
   * @return registrarHorarioResponse
   */
	public RegistrarHorarioResponse registrarHorarioOperation(RegistrarHorarioRequest request) {

	  RegistrarHorarioResponse response = new RegistrarHorarioResponse();
	  MateriaDto materiaDto = new MateriaDto();
	  
	  List<MateriaDto> materias = new ArrayList<>();
	  
	  for(MateriaType materia : request.getHorario()) {
		  materiaDto.setNombreMateria(materia.getNombreMateria());
		  materiaDto.setHoraFin(materia.getHoraFin());
		  materiaDto.setHoraInicio(materia.getHoraInicio());
		  materias.add(materiaDto);
	  }
	  
	  String mensaje = registroBusiness.registrarHorario(request.getNumeroControl(), materias);
	  
	  response.setMensaje(mensaje);
	  
	  return response;
  }
}
