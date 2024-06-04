package org.example.numbers.impl;

import org.example.numbers.NumberConverter;

import java.math.BigInteger;

import java.util.HashMap;
import java.util.Map;

public class ConverterServiceImpl implements NumberConverter {
    public static final HashMap<String, BigInteger> numbers;
    public static final HashMap<String, BigInteger> numbers2;
    static BigInteger milyar = new BigInteger("1000000000");
    static BigInteger trilyon = new BigInteger("1000000000000");
    static BigInteger katrilyon = new BigInteger("1000000000000000");
    static BigInteger kentilyon = new BigInteger("1000000000000000000");
    static BigInteger sekstilyon = new BigInteger("1000000000000000000000");
    static BigInteger septilyon = new BigInteger("1000000000000000000000000");
    static BigInteger oktilyon = new BigInteger("1000000000000000000000000000");
    static BigInteger nonilyon = new BigInteger("1000000000000000000000000000000");
    static BigInteger desilyon = new BigInteger("1000000000000000000000000000000000");
    static BigInteger undesilyon = new BigInteger ("1000000000000000000000000000000000000");

    private static final String[] ONES = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
    private static final String[] TENS = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
    private static final String[] GROUPS = {"", "bin", "milyon", "milyar", "trilyon", "katrilyon", "kentilyon", "seksilyon", "septilyon", "oktilyon", "nonilyon", "desilyon"};

    public static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    public static final String[] tens = {
            "",        // 0
            "",        // 1
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    private static final String[] GROUPSENG = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion", "octillion", "nonillion", "decillion"};

    static {
        numbers = new HashMap<>();
        numbers.put("eksi", null);
        numbers.put("sıfır", BigInteger.ZERO);
        numbers.put("bir", BigInteger.ONE);
        numbers.put("iki", BigInteger.TWO);
        numbers.put("üç", BigInteger.valueOf(3));
        numbers.put("dört", BigInteger.valueOf(4));
        numbers.put("beş", BigInteger.valueOf(5));
        numbers.put("altı", BigInteger.valueOf(6));
        numbers.put("yedi", BigInteger.valueOf(7));
        numbers.put("sekiz", BigInteger.valueOf(8));
        numbers.put("dokuz", BigInteger.valueOf(9));
        numbers.put("on", BigInteger.TEN);
        numbers.put("yirmi", BigInteger.valueOf(20));
        numbers.put("otuz", BigInteger.valueOf(30));
        numbers.put("kırk", BigInteger.valueOf(40));
        numbers.put("elli", BigInteger.valueOf(50));
        numbers.put("altmış", BigInteger.valueOf(60));
        numbers.put("yetmiş", BigInteger.valueOf(70));
        numbers.put("seksen", BigInteger.valueOf(80));
        numbers.put("doksan", BigInteger.valueOf(90));
        numbers.put("yüz", BigInteger.valueOf(100));
        numbers.put("bin", BigInteger.valueOf(1000));
        numbers.put("milyon", BigInteger.valueOf(1000000));
        numbers.put("milyar", BigInteger.valueOf(1000000000));
        numbers.put("trilyon", trilyon);
        numbers.put("katrilyon", katrilyon);
        numbers.put("kentilyon", kentilyon);
        numbers.put("sekstilyon", sekstilyon);
        numbers.put("septilyon", septilyon);
        numbers.put("oktilyon", oktilyon);
        numbers.put("nonilyon", nonilyon);
        numbers.put("desilyon", desilyon);

    }

    static {
        numbers2 = new HashMap<>();
        numbers2.put("minus", null);
        numbers2.put("zero", BigInteger.ZERO);
        numbers2.put("one", BigInteger.ONE);
        numbers2.put("two", BigInteger.TWO);
        numbers2.put("three", BigInteger.valueOf(3));
        numbers2.put("four", BigInteger.valueOf(4));
        numbers2.put("five", BigInteger.valueOf(5));
        numbers2.put("six", BigInteger.valueOf(6));
        numbers2.put("seven", BigInteger.valueOf(7));
        numbers2.put("eight", BigInteger.valueOf(8));
        numbers2.put("nine", BigInteger.valueOf(9));
        numbers2.put("ten", BigInteger.TEN);
        numbers2.put("eleven", BigInteger.valueOf(11));
        numbers2.put("twelve", BigInteger.valueOf(12));
        numbers2.put("thirteen", BigInteger.valueOf(13));
        numbers2.put("fourteen", BigInteger.valueOf(14));
        numbers2.put("fifteen", BigInteger.valueOf(15));
        numbers2.put("sixteen", BigInteger.valueOf(16));
        numbers2.put("seventeen", BigInteger.valueOf(17));
        numbers2.put("eighteen", BigInteger.valueOf(18));
        numbers2.put("nineteen", BigInteger.valueOf(19));
        numbers2.put("twenty", BigInteger.valueOf(20));
        numbers2.put("thirty", BigInteger.valueOf(30));
        numbers2.put("forty", BigInteger.valueOf(40));
        numbers2.put("fifty", BigInteger.valueOf(50));
        numbers2.put("sixty", BigInteger.valueOf(60));
        numbers2.put("seventy", BigInteger.valueOf(70));
        numbers2.put("eighty", BigInteger.valueOf(80));
        numbers2.put("ninety", BigInteger.valueOf(90));
        numbers2.put("hundred", BigInteger.valueOf(100));
        numbers2.put("thousand", BigInteger.valueOf(1000));
        numbers2.put("million", BigInteger.valueOf(1000000));
        numbers2.put("billion", BigInteger.valueOf(1000000000));
        numbers2.put("trillion", trilyon );
        numbers2.put("quadrillion", katrilyon);
        numbers2.put("quintillion", kentilyon);
        numbers2.put("sextillion", sekstilyon);
        numbers2.put("septillion", septilyon);
        numbers2.put("octillion", oktilyon);
        numbers2.put("nonillion", nonilyon);
        numbers2.put("decillion", desilyon);
        numbers2.put("undecillion", undesilyon);
    }

    @Override
    public BigInteger convertToNumber(String turkishNumber) {
        String[] tokens = turkishNumber.split("\\s+");
        BigInteger result = BigInteger.ZERO;
        BigInteger temp = BigInteger.ZERO;
        boolean isNegative = false;

        for (String token : tokens) {
            if (token.equals("eksi")) {
                isNegative = true;
            } else {
                BigInteger number = numbers.get(token);
                if (number != null) {
                    if (number.equals(BigInteger.valueOf(100))) {
                        if (temp.equals(BigInteger.ZERO))
                            temp = number;
                        else
                            temp = temp.multiply(number);
                    } else if (number.equals(BigInteger.valueOf(1000))
                            || number.equals(BigInteger.valueOf(1000000))
                            || number.equals(milyar)
                            || number.equals(trilyon)
                            || number.equals(katrilyon)
                            || number.equals(kentilyon)
                            || number.equals(sekstilyon)
                            || number.equals(septilyon)
                            || number.equals(oktilyon)
                            || number.equals(nonilyon)
                            || number.equals(desilyon)) {
                        if (temp.equals(BigInteger.ZERO)) {
                            temp = BigInteger.ONE;
                        }
                        result = result.add(temp.multiply(number));
                        temp = BigInteger.ZERO;
                    } else {
                        temp = temp.add(number);
                    }
                }

            }
        }
        result = result.add(temp);
        return isNegative ? result.negate() : result;
    }
    @Override
    public  BigInteger convertToNumberEnglish(String englishNumber) {
        String[] tokens = englishNumber.split("\\s+");
        BigInteger result = BigInteger.ZERO;
        BigInteger temp = BigInteger.ZERO;
        boolean isNegative = false;


        for (String token : tokens) {
            if (token.equals("minus")) {
                isNegative = true;
            }
            else {
                BigInteger number = numbers2.get(token);
                if (number != null) {
                    if (number.equals(BigInteger.valueOf(100))) {
                        if (temp.equals(BigInteger.ZERO))
                            temp = number;
                        else
                            temp = temp.multiply(number);
                    } else if (number.equals(BigInteger.valueOf(1000))
                            || number.equals(BigInteger.valueOf(1000000))
                            || number.equals(BigInteger.valueOf(1000000000))
                            || number.equals(milyar)
                            || number.equals(trilyon)
                            || number.equals(katrilyon)
                            || number.equals(kentilyon)
                            || number.equals(sekstilyon)
                            || number.equals(septilyon)
                            || number.equals(oktilyon)
                            || number.equals(nonilyon)
                            || number.equals(desilyon)
                            || number.equals(undesilyon)) {
                        if (temp.equals(BigInteger.ZERO)) {
                            temp = BigInteger.ONE;
                        }
                        result = result.add(temp.multiply(number));
                        temp = BigInteger.ZERO;
                    } else {
                        temp = temp.add(number);
                    }
                }
            }}
        result = result.add(temp);
        return isNegative ? result.negate() : result;
    }
    @Override
    public String convertToEnglish(final BigInteger number){
        if (number.compareTo(BigInteger.ZERO)<0){
            return "minus " + convertToEnglish(number.negate());
        }
        if (number.compareTo(BigInteger.valueOf(20))<0){
            return units[number.intValue()];
        }
        if (number.compareTo(BigInteger.valueOf(100))<0){
            return tens[number.intValue()/10]+((number.mod(BigInteger.TEN).intValue()!=0)? " ":"")+ units[number.mod(BigInteger.TEN).intValue()];
        }
        if (number.compareTo(BigInteger.valueOf(1000)) < 0) {
            return units[number.divide(BigInteger.valueOf(100)).intValue()] + " hundred" + ((number.mod(BigInteger.valueOf(100)).intValue()!=0)?" ":"")+convertToEnglish(number.mod(BigInteger.valueOf(100)));
        }
        if (number.compareTo(BigInteger.valueOf(1000000)) < 0) {
            return convertToEnglish(number.divide(BigInteger.valueOf(1000)))+ " thousand" + ((number.mod(BigInteger.valueOf(1000)).intValue() !=0 ) ? " ":"")+ convertToEnglish(number.mod(BigInteger.valueOf(1000)));
        }
        if (number.compareTo(BigInteger.valueOf(1000000000)) < 0) {
            return convertToEnglish(number.divide(BigInteger.valueOf(1000000))) + " million" + ((number.mod(BigInteger.valueOf(1000000)).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(BigInteger.valueOf(1000000)));
        }

        if (number.compareTo(BigInteger.valueOf(1000000000000L)) < 0) {
            return convertToEnglish(number.divide(BigInteger.valueOf(1000000000))) + " billion" + ((number.mod(BigInteger.valueOf(1000000000)).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(BigInteger.valueOf(1000000000)));
        }

        if (number.compareTo(katrilyon) < 0) {
            return convertToEnglish(number.divide(trilyon)) + " trillion" + ((number.mod(trilyon).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(trilyon));
        }

        if (number.compareTo(kentilyon) < 0) {
            return convertToEnglish(number.divide(katrilyon)) + " quadrillion" + ((number.mod(katrilyon).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(katrilyon));
        }

        if (number.compareTo(sekstilyon) < 0) {
            return convertToEnglish(number.divide(kentilyon)) + " quintillion" + ((number.mod(kentilyon).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(kentilyon));
        }

        if (number.compareTo(septilyon) < 0) {
            return convertToEnglish(number.divide(sekstilyon)) + " sextillion" + ((number.mod(sekstilyon).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(sekstilyon));
        }

        if (number.compareTo(oktilyon) < 0) {
            return convertToEnglish(number.divide(septilyon)) + " septillion" + ((number.mod(septilyon).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(septilyon));
        }

        if (number.compareTo(nonilyon) < 0) {
            return convertToEnglish(number.divide(oktilyon)) + " octillion" + ((number.mod(oktilyon).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(oktilyon));
        }

        if (number.compareTo(desilyon) < 0) {
            return convertToEnglish(number.divide(nonilyon)) + " nonillion" + ((number.mod(nonilyon).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(nonilyon));
        }

        if (number.compareTo(undesilyon) < 0) {
            return convertToEnglish(number.divide(desilyon)) + " decillion" + ((number.mod(desilyon).intValue() != 0) ? " " : "") + convertToEnglish(number.mod(desilyon));
        }

        return null;

    }
    @Override
    public String convertToTurkish(final BigInteger number) {

        if (number.compareTo(BigInteger.ZERO) < 0) {
            return "eksi " + convertToTurkish(number.negate());
        }

        if (number.compareTo(BigInteger.valueOf(10)) < 0) {
            return ONES[number.intValue()];
        }

        if (number.compareTo(BigInteger.valueOf(100)) < 0) {
            return TENS[number.intValue() / 10] + ((number.mod(BigInteger.TEN).intValue() != 0) ? " " : "") + ONES[number.mod(BigInteger.TEN).intValue()];
        }

        if (number.compareTo(BigInteger.valueOf(1000)) < 0) {
            return ONES[number.divide(BigInteger.valueOf(100)).intValue()] + " yüz" + ((number.mod(BigInteger.valueOf(100)).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(BigInteger.valueOf(100)));
        }

        if (number.compareTo(BigInteger.valueOf(1000000)) < 0) {
            return convertToTurkish(number.divide(BigInteger.valueOf(1000))) + " bin" + ((number.mod(BigInteger.valueOf(1000)).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(BigInteger.valueOf(1000)));
        }

        if (number.compareTo(BigInteger.valueOf(1000000000)) < 0) {
            return convertToTurkish(number.divide(BigInteger.valueOf(1000000))) + " milyon" + ((number.mod(BigInteger.valueOf(1000000)).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(BigInteger.valueOf(1000000)));
        }

        if (number.compareTo(trilyon) < 0) {
            return convertToTurkish(number.divide(BigInteger.valueOf(1000000000))) + " milyar" + ((number.mod(BigInteger.valueOf(1000000000)).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(BigInteger.valueOf(1000000000)));
        }

        if (number.compareTo(katrilyon) < 0) {
            return convertToTurkish(number.divide(trilyon)) + " trilyon" + ((number.mod(trilyon).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(trilyon));
        }

        if (number.compareTo(kentilyon) < 0) {
            return convertToTurkish(number.divide(katrilyon)) + " katrilyon" + ((number.mod(katrilyon).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(katrilyon));
        }

        if (number.compareTo(sekstilyon) < 0) {
            return convertToTurkish(number.divide(kentilyon)) + " kentilyon" + ((number.mod(kentilyon).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(kentilyon));
        }

        if (number.compareTo(septilyon) < 0) {
            return convertToTurkish(number.divide(sekstilyon)) + " sekstilyon" + ((number.mod(sekstilyon).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(sekstilyon));
        }

        if (number.compareTo(oktilyon) < 0) {
            return convertToTurkish(number.divide(septilyon)) + " septilyon" + ((number.mod(septilyon).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(septilyon));
        }

        if (number.compareTo(nonilyon) < 0) {
            return convertToTurkish(number.divide(oktilyon)) + " oktilyon" + ((number.mod(oktilyon).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(oktilyon));
        }

        if (number.compareTo(desilyon) < 0) {
            return convertToTurkish(number.divide(nonilyon)) + " nonilyon" + ((number.mod(nonilyon).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(nonilyon));
        }

        if (number.compareTo(undesilyon) < 0) {
            return convertToTurkish(number.divide(desilyon)) + " desilyon" + ((number.mod(desilyon).intValue() != 0) ? " " : "") + convertToTurkish(number.mod(desilyon));
        }
        return null;
    }

    @Override
    public BigInteger add(BigInteger num1, BigInteger num2) {
        return num1.add(num2);
    }
    @Override
    public BigInteger subtract(BigInteger num1, BigInteger num2) {
        return num1.subtract(num2);
    }

    @Override
    public BigInteger multiply(BigInteger num1, BigInteger num2) {
        return num1.multiply(num2);
    }

    @Override
    public BigInteger divide(BigInteger num1, BigInteger num2) {
        if (num2.equals(BigInteger.ZERO)) {
        }

        return num1.divide(num2);
    }

    @Override
    public Map<String, BigInteger> turkishNumbers() {
        return numbers;
    }


    @Override
    public Map<String, BigInteger> englishNumbers() {
        return numbers2;
    }
}
