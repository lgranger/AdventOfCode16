package com.laurengranger;

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
            int moveAmount = splitInput.charAt(1);
            if (splitInput.startsWith("R")) {
                moveLeft = false;
            }
            if (onXAxis) {
                if (moveLeft) {
                    xVal = xVal - moveAmount;
                } else {
                    xVal = xVal + moveAmount;
                }
            } else {
                if (moveLeft) {
                    yVal = yVal - moveAmount;
                } else {
                    yVal = yVal + moveAmount;
                }
            }
            directionFacing = FindAndSetDirection(directionFacing, moveLeft);
            onXAxis = !onXAxis;
        }

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