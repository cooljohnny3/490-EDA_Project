package com.COMP490.EDA;

import javafx.scene.control.Accordion;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Drawable {
    private Pane drawArea;
    private String tool;
    private Accordion sidePanel;
    private double startX;
    private double startY;

    public Drawable(Pane drawArea, String tool, Accordion sidePanel) {
        this.drawArea = drawArea;
        this.tool = tool;
        this.sidePanel = sidePanel;
    }

    public void setStartPoint(double x, double y) {
        System.out.println("STart point set to X: " + x + " Y: " + y);
        startX = x;
        startY = y;
    }

    public void updateTool(String tool){
        this.tool = tool;
    }

    private double distance(double x, double y) {
        double xDistance = Math.pow((x - startX), 2);
        double yDistance = Math.pow((y - startY), 2);
        return Math.sqrt(xDistance + yDistance);
    }

    public void drawShape(double x, double y) {
        switch (tool) {
            case "select":
                break;
            case "line":
                Line line = new Line(startX, startY, x, y);
                drawArea.getChildren().add(line);
                break;
            case "rectangle":
                double width = x - startX;
                double height = y - startY;
                // If end point is less than start swap points and make width/height positive
                if(width < 0) {
                    startX = x;
                    width = Math.abs(width);
                }
                if(height < 0) {
                    startY = y;
                    height = Math.abs(height);
                }
                System.out.println(startX + " " + startY);
                Rectangle rect = new Rectangle(startX, startY, width, height);
                drawArea.getChildren().add(rect);
                break;
            case "circle":
                Circle circle = new Circle();
                circle.setCenterX(startX);
                circle.setCenterY(startY);
                circle.setRadius(distance(x, y));
                drawArea.getChildren().add(circle);
                break;
        }

        System.out.println(tool + " end point set to X: " + x + " Y: " + y);
        TreeItem item = new TreeItem(tool);
//        tree.getRoot().getChildren().addAll(item);
    }
}
