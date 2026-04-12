package com.microservicios.app.futfem.referees.services.dto;

import java.util.List;

import com.microservicios.app.futfem.referees.models.entity.Referee;

public record RefereePageResponse(
		List<Referee> content,
		long totalElements,
		int totalPages,
		int page,
		int size) {
}
