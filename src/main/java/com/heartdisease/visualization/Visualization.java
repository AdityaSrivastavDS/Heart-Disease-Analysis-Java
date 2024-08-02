package com.heartdisease.visualization;

import com.heartdisease.data.HeartDiseaseRecord;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.controllers.mouse.camera.AWTCameraMouseController;
import org.jzy3d.chart.factorie;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import java.util.List;

public class Visualization {
    public static void create3DScatterPlot(List<HeartDiseaseRecord> records) {
        Coord3d[] points = new Coord3d[records.size()];
        Color[] colors = new Color[records.size()];

        for (int i = 0; i < records.size(); i++) {
            HeartDiseaseRecord record = records.get(i);
            points[i] = new Coord3d(record.getAge(), record.getSex(), /* third dimension */);
            colors[i] = Color.RED; // Choose color based on condition
        }

        Scatter scatter = new Scatter(points, colors);
        Chart chart = AWTChartComponentFactory.chart(Quality.Advanced, "awt");
        chart.getScene().add(scatter);
        chart.addController(new AWTCameraMouseController(chart));
        chart.open("3D Scatter Plot", 800, 600);
    }
}
