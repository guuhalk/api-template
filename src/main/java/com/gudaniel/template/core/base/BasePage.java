package com.gudaniel.template.core.base;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BasePage<T> {

	@Builder.Default
	private int page = 0;

	@Builder.Default
	private int offset = 0;

	@Builder.Default
	private Long totalElements = 0L;

	@Builder.Default
	private boolean hasMore = false;

	@Builder.Default
	private String lastItem = "";

	@Builder.Default
	private Collection<T> list = new ArrayList<>();

	public BasePage(Pageable pageable, Page<T> page) {

		this.offset = pageable.getPageSize();
		this.page = pageable.getPageNumber();

		this.list = page.getContent();
		this.hasMore = page.hasNext();
		this.totalElements = page.getTotalElements();
	}

	public BasePage(Pageable pageable, Page<T> page, String lastItem) {

		this.offset = pageable.getPageSize();
		this.page = pageable.getPageNumber();

		this.list = page.getContent();
		this.hasMore = page.hasNext();
		this.totalElements = page.getTotalElements();

		this.lastItem = lastItem;
		this.hasMore = lastItem != null;
	}

}
