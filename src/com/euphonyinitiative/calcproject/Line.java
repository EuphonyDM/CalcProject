package com.euphonyinitiative.calcproject;

public class Line {

    private Equation equation;
    private double xStart;
    private double xEnd;
    private double yStart;
    private double yEnd;
    private double step;
    private double[][] values;

    public Line (Equation equation, double xStart, double xEnd, double yStart, double yEnd, double step) {
        this.equation = equation;
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;
        this.step = step;
        genValues();
    }

    private void genValues() {
        int numValues = (int) (((xEnd - xStart) / step) + 1);
        double[][] vals = new double[numValues][2];
        for(int i = 0; i < numValues; i++) {
            double x = xStart + step*i;
            vals[i][0] = x;
            vals[i][1] = equation.getValue(x);
        }
        values = vals;
    }

    public void setEquation(Equation equation) {
        this.equation = equation;
        genValues();
    }

    public Equation getEquation() {
        return equation;
    }

    public void setxStart(double xStart) {
        this.xStart = xStart;
        genValues();
    }

    public double getxStart() {
        return xStart;
    }

    public void setxEnd(double xEnd) {
        this.xEnd = xEnd;
        genValues();
    }

    public double getxEnd() {
        return xEnd;
    }

    public void setyStart(double yStart) {
        this.yStart = yStart;
    }

    public double getyStart() {
        return yStart;
    }

    public void setyEnd(double yEnd) {
        this.yEnd = yEnd;
    }

    public double getyEnd() {
        return yEnd;
    }

    public void setStep(double step) {
        this.step = step;
        genValues();
    }

    public double getStep() {
        return step;
    }

    public double[][] getValues() {
        return values;
    }
}
