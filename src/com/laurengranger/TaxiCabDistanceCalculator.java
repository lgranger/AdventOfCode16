package com.laurengranger;

import static java.lang.Character.getNumericValue;
import static java.lang.StrictMath.abs;

public class TaxiCabDistanceCalculator {
    private String input;

    public TaxiCabDistanceCalculator(String easter_Bunny_Recruiting_Doc_Input){
        input = easter_Bunny_Recruiting_Doc_Input;
    }

    public int DistaceToBunnyHQ(){
        int xVal = 0;
        int yVal = 0;
        boolean onXAxis = true;
        boolean moveLeft = true;
        String directionFacing = "N";


        String[] arr = input.split(", ");

        for ( String splitInput : arr) {
            String moveAmountChar = splitInput.substring(1);
            int moveAmount = Integer.parseInt(moveAmountChar);
            if (splitInput.startsWith("R")) {
                moveLeft = false;
            } else {
                moveLeft = true;
            }
            if (onXAxis) {
                if (((directionFacing == "N") && moveLeft) || ((directionFacing == "S") && !moveLeft)) {
                    xVal = xVal - moveAmount;
                } else {
                    xVal = xVal + moveAmount;
                }
            } else {
                if (((directionFacing == "W") && !moveLeft) || ((directionFacing == "E") && moveLeft)) {
                    yVal = yVal - moveAmount;
                } else {
                    yVal = yVal + moveAmount;
                }
            }
            directionFacing = FindAndSetDirection(directionFacing, moveLeft);
            onXAxis = !onXAxis;
        }

        xVal = abs(xVal);
        yVal = abs(yVal);
        int sum = xVal + yVal;
        return(sum);
    }

    private String FindAndSetDirection (String directionFacing, boolean moveLeft) {
        switch (directionFacing) {
            case "N":
                if (moveLeft){
                    return "W";
                } else {
                    return "E";
                }
            case "E":
                if (moveLeft){
                    return "N";
                } else {
                    return "S";
                }
            case "S":
                if (moveLeft){
                    return "E";
                } else {
                    return "W";
                }
            case "W":
                if (moveLeft){
                    return "S";
                } else {
                    return "N";
                }
        }
        return "N";
    }

        }