package com.microservicios.app.futfem.referees.services;

import java.util.Locale;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.microservicios.app.common.services.CommonServiceImpl;
import com.microservicios.app.futfem.referees.models.entity.Referee;
import com.microservicios.app.futfem.referees.models.repository.RefereeRepository;
import com.microservicios.app.futfem.referees.services.dto.RefereePageResponse;
import com.microservicios.app.futfem.referees.services.dto.RefereeSearchRequest;

@Service
public class RefereeServiceImpl  extends CommonServiceImpl<Referee, RefereeRepository>  implements RefereeService {

	private static final int DEFAULT_PAGE = 0;
	private static final int DEFAULT_SIZE = 25;

	@Override
	public RefereePageResponse searchReferees(RefereeSearchRequest request) {
		RefereeSearchRequest safeRequest = request == null ? new RefereeSearchRequest() : request;
		int page = safeRequest.getPage() == null || safeRequest.getPage() < 0 ? DEFAULT_PAGE : safeRequest.getPage();
		int size = safeRequest.getSize() == null || safeRequest.getSize() <= 0 ? DEFAULT_SIZE : safeRequest.getSize();

		Pageable pageable = PageRequest.of(page, size,
				Sort.by("surname").ascending().and(Sort.by("name").ascending()));
		Page<Referee> result = repository.searchReferees(
				normalize(safeRequest.getSearch()),
				normalizeCountry(safeRequest.getCountry()),
				pageable);

		return new RefereePageResponse(result.getContent(), result.getTotalElements(), result.getTotalPages(),
				result.getNumber(), result.getSize());
	}

	private String normalize(String value) {
		if (value == null) {
			return null;
		}
		String normalized = value.trim().replaceAll("\\s+", " ");
		return normalized.isEmpty() ? null : normalized;
	}

	private String normalizeCountry(String value) {
		String normalized = normalize(value);
		return normalized == null ? null : normalized.toUpperCase(Locale.ROOT);
	}
}
