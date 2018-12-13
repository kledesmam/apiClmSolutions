package com.clmsolution.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clmsolution.api.model.pojo.AccountStatusDTO;
import com.clmsolution.api.model.pojo.AccountStatusData;
import com.clmsolution.api.model.pojo.AccountStatusResponse;
import com.clmsolution.api.repository.AccountStatusRepository;
import com.clmsolution.api.utility.ConvertObjects;

@RestController
@RequestMapping("/api")
public class AccountStatusController {

	@Autowired
	AccountStatusRepository accountStatusRepository;
	
	@GetMapping("/account/{cedula}")
	public AccountStatusResponse getEstadoCuenta(@PathVariable String cedula){
		AccountStatusResponse estadoCuentaResponse = new AccountStatusResponse();
		List<AccountStatusData> lstEstadoCuentaData = new ArrayList();
		
		try {
			List<Object[]> lstObject = accountStatusRepository.getAccountStatus(cedula);
			for(Object[] ob: lstObject) {
				AccountStatusDTO estadoCuentaDTO = ConvertObjects.ConvertObjectToAccountStatusDTO(ob);
				if(estadoCuentaDTO != null) {
					AccountStatusData estadoCuentaData = new AccountStatusData();
					estadoCuentaData.setCode(estadoCuentaDTO.getLINCRED());
					estadoCuentaData.setName(estadoCuentaDTO.getDETALLE());
					estadoCuentaData.setType(estadoCuentaDTO.getTIPO_CONCEPTO());
					estadoCuentaData.setData(estadoCuentaDTO);
					
					lstEstadoCuentaData.add(estadoCuentaData);
				}
			}
			
			if(lstEstadoCuentaData.size() > 0) {
				estadoCuentaResponse.setStatus(200);
				estadoCuentaResponse.setMessage("OK");
				estadoCuentaResponse.setData(lstEstadoCuentaData);
			}
			else {
				estadoCuentaResponse.setStatus(400);
				estadoCuentaResponse.setMessage("No se encontró información");
			}
		}
		catch(Exception e){
			estadoCuentaResponse.setStatus(400);
			estadoCuentaResponse.setMessage(e.getMessage());
		}
		
		return estadoCuentaResponse;
	}
	
}
