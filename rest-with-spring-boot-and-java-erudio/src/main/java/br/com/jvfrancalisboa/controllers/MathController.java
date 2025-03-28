package br.com.jvfrancalisboa.controllers;

import br.com.jvfrancalisboa.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/average/3/5
    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    // http://localhost:8080/math/square-root/3
    @RequestMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number){

        if(!isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return Math.sqrt(convertToDouble(number));
    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
