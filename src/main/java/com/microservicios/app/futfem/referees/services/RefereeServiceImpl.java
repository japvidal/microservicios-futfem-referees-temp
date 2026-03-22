package com.microservicios.app.futfem.referees.services;

import org.springframework.stereotype.Service;

import com.microservicios.app.common.services.CommonServiceImpl;
import com.microservicios.app.futfem.referees.models.entity.Referee;
import com.microservicios.app.futfem.referees.models.repository.RefereeRepository;

@Service
public class RefereeServiceImpl  extends CommonServiceImpl<Referee, RefereeRepository>  implements RefereeService {

}
