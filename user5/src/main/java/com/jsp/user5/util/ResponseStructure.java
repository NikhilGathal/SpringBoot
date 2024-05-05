package com.jsp.user5.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {
	
	private String message;
	private int httpstatus;
	private Object data; 			// user object
	

}
