package com.dev.curdProject.exception;

import java.util.List;

public class ApiErrorResponseBuilder {
	
	private static ApiErrorResponseBuilder builder;
	
	private ApiErrorResponseBuilder()
	{
		
	}
	
	private String errorId;
	private Integer status;
	private String message;
	private List<String> errors;
	private String  path;

	public synchronized static ApiErrorResponseBuilder getInstance()
	{
		if(builder == null)
		{
			builder = new ApiErrorResponseBuilder();
		}
		return builder;
	}
	
	public ApiErrorResponseBuilder withErrorId(String errorId)
	{
		builder.errorId = errorId;
		return builder;
	}
	
	public ApiErrorResponseBuilder withStatus(Integer status)
	{
		builder.status = status;
		return builder;
	}
	
	public ApiErrorResponseBuilder withMessage(String message)
	{
		builder.message = message;
		return builder;
	}
	
	public ApiErrorResponseBuilder withErrors(List<String> errors)
	{
		builder.errors = errors;
		return builder;
	}
	
	public ApiErrorResponseBuilder withPath(String  path)
	{
		builder.path = path;
		return builder;
	}
	
	public ApiErrorResponse build()
	{
		ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
		apiErrorResponse.setErrorId(builder.errorId);
		apiErrorResponse.setStatus(builder.status);
		apiErrorResponse.setMessage(builder.message);
		apiErrorResponse.setErrors(builder.errors);
		apiErrorResponse.setPath(builder.path);
		
		return apiErrorResponse;
		
	}

}
