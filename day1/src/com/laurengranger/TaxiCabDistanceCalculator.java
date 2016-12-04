package com.laurengranger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.StrictMath.abs;

public class TaxiCabDistanceCalculator {
    private String input;
    private boolean finished = false;
    private String hqCoordinates;
    private Map<Integer, List> coordinatesMap;
    private Integer distance;

    public TaxiCabDistanceCalculator(String easter_Bunny_Recruiting_Doc_Input){
        input = easter_Bunny_Recruiting_Doc_Input;
        coordinatesMap = new HashMap();
    }

    public int DistaceToBunnyHQ(){
        int xVal = 0;
        int yVal = 0;
        boolean onXAxis = true;
        boolean moveLeft;
        String directionFacing = "N";

        String[] turnDir = input.split(", ");

        for ( String splitInput : turnDir) {

            System.out.print(directionFacing);

            String moveAmountChar = splitInput.substring(1);
            if (splitInput.startsWith("R")) {
                moveLeft = false;
            } else {
                moveLeft = true;
            }

            boolean movePositive = MovePositive(directionFacing, moveLeft);

            int moveAmount = Integer.parseInt(moveAmountChar);

            if (onXAxis) {
                if (movePositive) {
                    //plus on x axis
                    int finalX = xVal + moveAmount;
                    MovePositive(xVal, finalX, yVal, onXAxis);
                    xVal = finalX;
                } else {
                    //minus on x axis
                    int finalX = xVal - moveAmount;
                    MoveNegative(xVal, finalX, yVal, onXAxis);
                    xVal = finalX;
                }
            } else {
                if (movePositive) {
                    //plus on yaxis
                    int finalY = yVal + moveAmount;
                    MovePositive(yVal, finalY, xVal, onXAxis);
                    yVal = finalY;
                } else {
                    //minus on yaxis
                    int finalY = yVal - moveAmount;
                    MoveNegative(yVal,finalY, xVal, onXAxis);
                    yVal = finalY;
                }
            }

            if (finished) {return distance;}

            directionFacing = FindAndSetDirection(directionFacing, moveLeft);
            onXAxis = !onXAxis;
        }
        return distance;
    }

    private boolean MovePositive(String directionFacing, Boolean moveLeft){
        switch (directionFacing) {
            case "N":
                if (moveLeft){
                    return false;
                } else {
                    return true;
                }
            case "E":
                if (moveLeft){
                    return true;
                } else {
                    return false;
                }
            case "S":
                if (moveLeft){
                    return true;
                } else {
                    return false;
                }
            case "W":
                if (moveLeft){
                    return false;
                } else {
                    return true;
                }
        }
        return true;
    }

    private void MovePositive(int coordinateValueStart, int coordinateValueFinish, int staticCoordinateValue, boolean onXAxis){
        int x;
        int y;
        for (int i = coordinateValueStart; i < coordinateValueFinish; i++) {
            if (finished) {break;}
            if (onXAxis) {
                x = i;
                y = staticCoordinateValue;
            } else {
                x = staticCoordinateValue;
                y = i;
            }

            RecordCoordinatesCrossed(x, y);
        }
    }

    private void MoveNegative(int coordinateValueStart, int coordinateValueFinish, int staticCoordinateValue, boolean onXAxis){
        int x;
        int y;
        for (int i = coordinateValueStart; i > coordinateValueFinish; i--) {
            if (onXAxis) {
                x = i;
                y = staticCoordinateValue;
            } else {
                x = staticCoordinateValue;
                y = i;
            }
            RecordCoordinatesCrossed(x, y);
        }
    }

    private void RecordCoordinatesCrossed(int xVal, int yVal){
        if (!coordinatesMap.containsKey(xVal)){
            List yValues = new ArrayList();
            yValues.add(yVal);
            coordinatesMap.put(xVal,yValues);
            System.out.print("(" + xVal + "," + yVal + ")");
        } else {
            List yValues = coordinatesMap.get(xVal);
            if (yValues.contains(yVal)) {
                hqCoordinates = "Crossed twice: (" + xVal + "," + yVal + ")";
                System.out.print(hqCoordinates);
                finished = true;
                CalculateDistanceFromStart(xVal, yVal);
            } else {
                yValues.add(yVal);
                coordinatesMap.put(xVal,yValues);
                System.out.print("(" + xVal + "," + yVal + ")");
            }
        }
    }

    private Integer CalculateDistanceFromStart(int xVal, int yVal){
        xVal = abs(xVal);
        yVal = abs(yVal);
        distance = xVal + yVal;
        return distance;
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