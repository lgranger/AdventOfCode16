package com.laurengranger;

public class TriangleCalculator {
    String input;
    String[] arrayOfTriangles;
    Integer count;

    public TriangleCalculator(String trianglesInput){
        input = trianglesInput;
        arrayOfTriangles = trianglesInput.split("\n");
        count = 0;
    }

    public Integer countTriangles() throws Exception{
        for (String triangleString : arrayOfTriangles) {

            triangleString = triangleString.replaceAll("\\s+", ",");
            String[] singleTriangleArray = triangleString.split(",");
            
            Integer triangleA = Integer.parseInt((singleTriangleArray[1]).replaceAll("\\s+", ""));
            Integer triangleB = Integer.parseInt((singleTriangleArray[2]).replaceAll("\\s+", ""));
            Integer triangleC = Integer.parseInt((singleTriangleArray[3]).replaceAll("\\s+", ""));

            Boolean isTriangle = isTriangle(triangleA, triangleB, triangleC);
            if (isTriangle) {
                count = count + 1;
            }
        }
        return count;
    }

    private Boolean isTriangle(Integer triangleA, Integer triangleB, Integer triangleC){
        if (((triangleA + triangleB) > triangleC)
            && ((triangleB + triangleC) > triangleA)
            && ((triangleA + triangleC) > triangleB)){
            return true;
        }
        return false;
    }
}
