package com.laurengranger;

public class DoorCodeCalculator {
    String[] numberStrings;
    String previousNumber;
    String code;

    public DoorCodeCalculator(String input){
        numberStrings = input.split("\n");
        previousNumber = "5";
        code = "";
    }

    public String code(){
        for (String line: numberStrings) {
            String[] singleDigitDirectionArray = line.split("");
            for (String moveDir : singleDigitDirectionArray) {
                previousNumber = getNextNumber(moveDir, previousNumber);
            }
            code = code + previousNumber;
        }
        return code;
    }

    private String getNextNumber(String DirectionsLine, String previousNumber){
        switch (previousNumber) {
            case "1":
                switch (DirectionsLine){
                    case "U":
                        return "1";
                    case "D":
                        return "3";
                    case "L":
                        return "1";
                    case "R":
                        return "1";
                }
            case "2":
                 switch (DirectionsLine){
                    case "U":
                        return "2";
                    case "D":
                        return "6";
                    case "L":
                        return "2";
                    case "R":
                        return "3";
                }

            case "3":
                switch (DirectionsLine){
                    case "U":
                        return "1";
                    case "D":
                        return "7";
                    case "L":
                        return "2";
                    case "R":
                        return "4";
                }
            case "4":
                 switch (DirectionsLine){
                    case "U":
                        return "4";
                    case "D":
                        return "8";
                    case "L":
                        return "3";
                    case "R":
                        return "4";
                }
            case "5":
                switch (DirectionsLine){
                    case "U":
                        return "5";
                    case "D":
                        return "5";
                    case "L":
                        return "5";
                    case "R":
                        return "6";
                }
            case "6":
                 switch (DirectionsLine) {
                     case "U":
                         return "2";
                     case "D":
                         return "A";
                     case "L":
                         return "5";
                     case "R":
                         return "7";
                 }
            case "7":
                switch (DirectionsLine){
                    case "U":
                        return "3";
                    case "D":
                        return "B";
                    case "L":
                        return "6";
                    case "R":
                        return "8";
                }
            case "8":
                 switch (DirectionsLine){
                    case "U":
                        return "4";
                    case "D":
                        return "C";
                    case "L":
                        return "7";
                    case "R":
                        return "9";
                }
            case "9":
                 switch (DirectionsLine){
                    case "U":
                        return "9";
                    case "D":
                        return "9";
                    case "L":
                        return "8";
                    case "R":
                        return "9";
                }
            case "A":
                 switch (DirectionsLine) {
                     case "U":
                         return "6";
                     case "D":
                         return "A";
                     case "L":
                         return "A";
                     case "R":
                         return "B";
                 }
            case "B":
                switch (DirectionsLine){
                    case "U":
                        return "7";
                    case "D":
                        return "D";
                    case "L":
                        return "A";
                    case "R":
                        return "C";
                }
            case "C":
                 switch (DirectionsLine){
                    case "U":
                        return "8";
                    case "D":
                        return "C";
                    case "L":
                        return "B";
                    case "R":
                        return "C";
                }
            case "D":
                 switch (DirectionsLine){
                    case "U":
                        return "B";
                    case "D":
                        return "D";
                    case "L":
                        return "D";
                    case "R":
                        return "D";
                }
        }
        return "0";
    }
}
