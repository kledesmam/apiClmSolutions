package com.clmsolution.api.utility;

import com.clmsolution.api.model.pojo.AccountStatusDTO;

public class ConvertObjects {

	public static AccountStatusDTO ConvertObjectToAccountStatusDTO(Object[] obj) {
		if(obj != null) {
			AccountStatusDTO estadoCuentaDTO = new AccountStatusDTO();
			estadoCuentaDTO.setTIPO_CONCEPTO(obj[0] + "");
			estadoCuentaDTO.setLINCRED(obj[1] + "");
			estadoCuentaDTO.setDETALLE(obj[3] +"");
			
			return estadoCuentaDTO;
		}
		return null;
	}
}
