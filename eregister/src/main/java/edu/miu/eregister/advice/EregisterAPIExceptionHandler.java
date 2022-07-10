package edu.miu.cs.cs425.fairfieldlibrarywebapi.advice;

import edu.miu.eregister.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EregisterAPIExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String, String> handleWebAPIException(StudentNotFoundException studentNotFoundException) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", studentNotFoundException.getMessage());
        return errorMap;
    }

}
