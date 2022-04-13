package com.etiya.rentACar;

import com.etiya.rentACar.PayService.HalkBankPosManager;
import com.etiya.rentACar.PayService.IsBankPosManager;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return  new ModelMapper();
	}

	@Bean
	public IsBankPosManager getIsbankPostManager(){
		return new IsBankPosManager();
	}

	@Bean
	public HalkBankPosManager getHalkBankPosManager(){
		return new HalkBankPosManager();
	}

	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
		Map<String,String> validationErrors=new HashMap<String,String>();

		for (FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors() ) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errorDataResult=new ErrorDataResult<Object>(validationErrors,"VALİDATİON_ERROR(S)");
		return errorDataResult;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException) {
		ErrorDataResult<Object> errorResults = new ErrorDataResult<>(businessException.getMessage(), "Business.Error");
		return errorResults;
	}
}

