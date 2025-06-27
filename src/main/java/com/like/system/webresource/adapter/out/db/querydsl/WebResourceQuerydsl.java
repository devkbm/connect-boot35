package com.like.system.webresource.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.webresource.application.port.in.query.WebResourceQueryDTO;
import com.like.system.webresource.application.port.in.query.WebResourceQueryResultDTO;
import com.like.system.webresource.domain.QWebResource;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class WebResourceQuerydsl {

	JPAQueryFactory queryFactory;
	
	private final QWebResource qWebResource = QWebResource.webResource;
	
	public WebResourceQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<WebResourceQueryResultDTO> getList(WebResourceQueryDTO condition) {
		return queryFactory
				.select(
					Projections.fields(WebResourceQueryResultDTO.class,							
							qWebResource.id.as("resourceId"),
							qWebResource.name.as("resourceName"),
							qWebResource.type.as("resourceType"),
							qWebResource.url,
							qWebResource.description
						))
				.from(qWebResource)
				.where(condition.getBooleanBuilder())
				.fetch();
				           
	}
	
	
	public WebResourceQueryResultDTO get(WebResourceQueryDTO condition) {
		return queryFactory
				.select(
					Projections.fields(WebResourceQueryResultDTO.class,							
							qWebResource.id.as("resourceId"),
							qWebResource.name.as("resourceName"),
							qWebResource.type.as("resourceType"),
							qWebResource.url,
							qWebResource.description
						))
				.from(qWebResource)				
				.fetchFirst();
				           
	}
}
