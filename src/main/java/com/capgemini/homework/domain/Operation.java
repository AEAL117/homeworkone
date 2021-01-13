package com.capgemini.homework.domain;

import org.springframework.stereotype.Component;



import java.util.Optional;
@Component
public class Operation {
    public Optional<String> iseven(int num){
        String message;
        if(num%2==0){
             message="el numero: "+num+" es par";
        }else{
            message="el numero: "+num+" es impar";
        }

        Optional<String> optional=Optional.ofNullable(message);
        return optional;
    }
    public Optional<String> isprime(int num){
        String message;

        int count = 2;
        boolean primo=true;
        if (num <= 1){
            message="introduce un numero mayor a 1";
        }else{
            while ((primo) && (count!=num)){
                if (num % count == 0)
                    primo = false;
                count++;
            }
            if (primo){
                message="El numero: "+num+" es primo :D";
            }else{
                message="El numero: "+num+" no es primo :(";
            }
        }



        Optional<String> optional=Optional.ofNullable(message);
        return optional;
    }
    public Optional<String> sum(double a,double b){

        String sum= "La suma de: "+a+" y :"+b+" es: "+(a+b);
        Optional<String> optional=Optional.ofNullable(sum);
        return optional;
    }
}
