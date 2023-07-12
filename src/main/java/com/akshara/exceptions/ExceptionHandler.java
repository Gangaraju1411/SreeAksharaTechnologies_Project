package com.akshara.exceptions;


import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Component
@ControllerAdvice
public class ExceptionHandler {


@org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)

 public String  handleSqlException(SQLIntegrityConstraintViolationException obj, Model model) {
	
		model.addAttribute("errMsg","Username already exists");
		return "register";
}
	
}
