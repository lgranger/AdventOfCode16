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

    public Integer countTriangles() {

        for (int i = 0; i < arrayOfTriangles.length; i = i+3) {

            //set first triangle
            String triangleString = arrayOfTriangles[i];
            triangleString = triangleString.replaceAll("\\s+", ",");
            String[] singleTriangleArray = triangleString.split(",");

            Integer triangleA1 = Integer.parseInt((singleTriangleArray[1]).replaceAll("\\s+", ""));
            Integer triangleB1 = Integer.parseInt((singleTriangleArray[2]).replaceAll("\\s+", ""));
            Integer triangleC1 = Integer.parseInt((singleTriangleArray[3]).replaceAll("\\s+", ""));

            //set second triangle
            triangleString = arrayOfTriangles[i+1];
            triangleString = triangleString.replaceAll("\\s+", ",");
            singleTriangleArray = triangleString.split(",");

            Integer triangleA2 = Integer.parseInt((singleTriangleArray[1]).replaceAll("\\s+", ""));
            Integer triangleB2 = Integer.parseInt((singleTriangleArray[2]).replaceAll("\\s+", ""));
            Integer triangleC2 = Integer.parseInt((singleTriangleArray[3]).replaceAll("\\s+", ""));

            //set third triangle
            triangleString = arrayOfTriangles[i+2];
            triangleString = triangleString.replaceAll("\\s+", ",");
            singleTriangleArray = triangleString.split(",");

            Integer triangleA3 = Integer.parseInt((singleTriangleArray[1]).replaceAll("\\s+", ""));
            Integer triangleB3 = Integer.parseInt((singleTriangleArray[2]).replaceAll("\\s+", ""));
            Integer  triangleC3 = Integer.parseInt((singleTriangleArray[3]).replaceAll("\\s+", ""));

            isTriangle(triangleA1, triangleA2, triangleA3);
            isTriangle(triangleB1, triangleB2, triangleB3);
            isTriangle(triangleC1, triangleC2, triangleC3);

        }
        return count;
    }

    private void isTriangle(Integer triangleA, Integer triangleB, Integer triangleC){
        if (((triangleA + triangleB) > triangleC)
            && ((triangleB + triangleC) > triangleA)
            && ((triangleA + triangleC) > triangleB)){
            count = count + 1;
        }
    }
}
