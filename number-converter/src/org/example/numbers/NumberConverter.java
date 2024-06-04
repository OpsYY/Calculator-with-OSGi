package org.example.numbers;

import java.math.BigInteger;
import java.util.Map;

public interface NumberConverter {

    BigInteger convertToNumber(String turkishNumber);

    BigInteger convertToNumberEnglish(String englishNumber);

    String convertToEnglish(BigInteger number);

    String convertToTurkish(BigInteger number);

    BigInteger add(BigInteger num1, BigInteger num2);

    BigInteger subtract(BigInteger num1, BigInteger num2);

    BigInteger multiply(BigInteger num1, BigInteger num2);

    BigInteger divide(BigInteger num1, BigInteger num2);

    Map<String, BigInteger> turkishNumbers();

    Map<String, BigInteger> englishNumbers();
}
