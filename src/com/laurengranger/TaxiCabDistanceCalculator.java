package com.laurengranger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxiCabDistanceCalculator {
    private String input;
    private boolean finished = false;
    private String hqCoordinates;
    private Map<Integer, List> coordinatesMap;

    public TaxiCabDistanceCalculator(String easter_Bunny_Recruiting_Doc_Input){
        input = easter_Bunny_Recruiting_Doc_Input;
        HashMap<Integer, List<Integer>> coordinatesMap = new HashMap<Integer, List<Integer>>();
    }

    public String DistaceToBunnyHQ(){
        int xVal = 0;
        int yVal = 0;
        boolean onXAxis = true;
        boolean moveLeft;
        String directionFacing = "N";

        String[] turnDir = input.split(", ");

        for ( String splitInput : turnDir) {
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
            BunnyHQCoordinates(xVal, yVal);
            if (finished) {
                return hqCoordinates;
            }
            onXAxis = !onXAxis;
        }
        return "no location found";
    }

    public void BunnyHQCoordinates(int xVal, int yVal){
        if (!coordinatesMap.containsKey(xVal)){
            List yValues = coordinatesMap.get(xVal);
            yValues.add(yVal);
            coordinatesMap.put(xVal,yValues);
        } else {
            List yValues = coordinatesMap.get(xVal);
            if (yValues.contains(yVal)) {
                hqCoordinates = "(" + xVal + "," + yVal + ")";
                finished = true;
            } else {
                yValues.add(yVal);
            }
        }
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