package com.capgemini.homework.web.controller;

import com.capgemini.homework.domain.Operation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/op")
public class OperationController {
    @Autowired
    private Operation operation;

    @GetMapping("/iseven/{num}")
    @ApiOperation("returns a text saying if the number entered is odd or even")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "WRONG INPUT VALUE")
    })
    public ResponseEntity<String> getOperationEven(@ApiParam(value = "A Integer number in order to  analyze if is even",required = true,example = "8") @PathVariable("num") int number){

        return operation.iseven(number)
                .map(op -> new ResponseEntity<>(op, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @GetMapping("/isprime/{num}")
    public ResponseEntity<String> getOperationPrime(@ApiParam(value = "A Integer number in order to analyze if is prime number",required = true,example = "3") @PathVariable("num") int number){

        return operation.isprime(number)
                .map(op -> new ResponseEntity<>(op, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @GetMapping("/sum/{a},{b}")
    public ResponseEntity<String> getOperationSum(@ApiParam(value = "a double number to add ",required = true,example = "1.0") @PathVariable("a") double a,@ApiParam(value = "a double number to add ",required = true,example = "3.0")@PathVariable("b") double b){

        return operation.sum(a,b)
                .map(op -> new ResponseEntity<>(op,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
