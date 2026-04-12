package com.microservicios.app.futfem.referees.services;

import com.microservicios.app.common.services.CommonService;
import com.microservicios.app.futfem.referees.models.entity.Referee;
import com.microservicios.app.futfem.referees.services.dto.RefereePageResponse;
import com.microservicios.app.futfem.referees.services.dto.RefereeSearchRequest;

public interface RefereeService extends CommonService<Referee> {

	RefereePageResponse searchReferees(RefereeSearchRequest request);
}
