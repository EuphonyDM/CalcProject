package com.euphonyinitiative.calcproject;

import javax.swing.*;
import java.util.HashMap;

public class CalcProject {

    static final int PARENT = 0;
    static final int DERIVATIVE = 1;
    static final int INTEGRAL = 2;

    public static void main(String[] args) {
        Object[] options = { "Parent Functions", "Derivatives", "Integrals" };
        int equationType = JOptionPane.showOptionDialog(null, "What do you want to review? ", "Start Game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        new ReviewGame(equationType);
    }

    public static HashMap<String, Line> genParentMap() {
        HashMap<String, Line> map = new HashMap<>();
        map.put("4", new Line((x) -> 4, -5, 5, -5, 5, 0.01));
        map.put("2x + 1", new Line((x) -> 2*x + 1, -5, 5, -5, 5, 0.01));
        map.put("x^2", new Line((x) -> Math.pow(x, 2), -2, 2, -0.1, 5, 0.01));
        map.put("x^3", new Line((x) -> Math.pow(x, 3), -2, 2, -5, 5, 0.01));
        map.put("sin(x)", new Line(Math::sin, -5, 5, -2, 2, 0.01));
        map.put("cos(x)", new Line(Math::cos, -5, 5, -2, 2, 0.01));
        map.put("csc(x)", new Line((x) -> 1/Math.sin(x), -5, 5, -5, 5, 0.01));
        map.put("sec(x)", new Line((x) -> 1/Math.cos(x), -2, 2, -5, 5, 0.01));
        map.put("tan(x)", new Line(Math::tan, -5, 5, -5, 5, 0.01));
        map.put("cot(x)", new Line((x) -> 1/Math.tan(x), -5, 5, -5, 5, 0.01));
        map.put("e^x", new Line((x) -> Math.pow(Math.E, x), -2, 2, -0.1, 5, 0.01));
        map.put("1/x", new Line((x) -> 1/x, -5, 5, -5, 5, 0.01));
        map.put("2^x", new Line((x) -> Math.pow(2, x), -5, 5, -0.1, 8, 0.01));
        map.put("ln(x)", new Line(Math::log, -5, 5, -5, 5, 0.01));
        map.put("sqrt(x)", new Line(Math::sqrt, -0.1, 5, -0.1, 5, 0.01));
        map.put("cbrt(x)", new Line(Math::cbrt, -5, 5, -5, 5, 0.01));
        map.put("|x|", new Line(Math::abs, -5, 5, -0.1, 5, 0.01));
        return map;
    }

    public static HashMap<String, Line> genDerivativeMap() {
        HashMap<String, Line> map = new HashMap<>();
        map.put("4", new Line((x) -> 0, -5, 5, -5, 5, 0.01));
        map.put("2x + 3", new Line((x) -> 2, -5, 5, -5, 5, 0.01));
        map.put("x^3", new Line((x) -> 3 * Math.pow(x, 3), -2, 2, -0.1, 5, 0.01));
        map.put("sin(x)", new Line(Math::cos, -5, 5, -2, 2, 0.01));
        map.put("cos(x)", new Line((x) -> -1 * Math.sin(x), -5, 5, -2, 2, 0.01));
        map.put("tan(x)", new Line((x) -> Math.pow((1/(Math.cos(x))), 2), -5, 5, -5, 5, 0.01));
        map.put("sec(x)", new Line((x) -> (1/(Math.cos(x)))*Math.tan(x), -2, 2, -5, 5, 0.01));
        map.put("cot(x)", new Line((x) -> -1 * Math.pow(1/Math.sin(x), 2), -5, 5, -5, 5, 0.01));
        map.put("csc(x)", new Line((x) -> (-1)/(Math.sin(x))*(1)/(Math.tan(x)), -5, 5, -5, 5, 0.01));
        map.put("e^x", new Line((x) -> Math.pow(Math.E,x), -2, 2, -0.1, 5, 0.01));
        map.put("ln(x)", new Line((x) -> 1 / x, -5, 5, -5, 5, 0.01));
        map.put("2^x", new Line((x) -> Math.log(2)*Math.pow(2,x), -5, 5, -0.1, 8, 0.01));
        return map;
    }

    public static HashMap<String, Line> genIntegralMap() {
        HashMap<String, Line> map = new HashMap<>();
        map.put("0", new Line((x) -> 0, -5, 5, -5, 5, 0.01));
        map.put("2", new Line((x) -> 2 * x, -5, 5, -5, 5, 0.01));
        map.put("x^3", new Line((x) -> (1. / 4.) * Math.pow(x, 4), -5, 5, -0.1, 5, 0.01));
        map.put("cos(x)", new Line(Math::sin, -5, 5, -2, 2, 0.01));
        map.put("sin(x)", new Line((x) -> -1 * Math.cos(x), -5, 5, -2, 2, 0.01));
        map.put("sec^2(x)", new Line(Math::tan, -5, 5, -5, 5, 0.01));
        map.put("sec(x)tan(x)", new Line((x) -> 1/Math.cos(x), -5, 5, -5, 5, 0.01));
        map.put("csc^2(x)", new Line((x) -> -1/Math.tan(x), -5, 5, -5, 5, 0.01));
        map.put("csc(x)cot(x)", new Line((x) -> -1/Math.sin(x), -5, 5, -5, 5, 0.01));
        map.put("e^x", new Line((x) -> Math.pow(Math.E, x), -2, 2, -0.1, 5, 0.01));
        map.put("1/x", new Line(Math::log, -0.1, 8, -2, 2, 0.01));
        map.put("2^x", new Line((x) -> (1/Math.log(2))*Math.pow(2,x), -2, 2, -0.1, 5, 0.01));
        return map;
    }
}
