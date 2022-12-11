package presentacion;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import javax.swing.*;

public class BarGraph extends JPanel {
    
    public BarGraph(List<Integer> v, List<String> s, String t,String e,String c ,int a) {
    	    DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
            for(int i=0;i<v.size();i++) {
            	barDataset.setValue(v.get(i), e,s.get(i));
        	}   
            
    	    //Create the chart
    	    JFreeChart chart = ChartFactory.createBarChart(
    	        t, e, c, barDataset,
    	        PlotOrientation.HORIZONTAL, false, true, false);
    	    String source; 
    	    
    	    if(a==1) {
    	    	source="src/images/ummmmn.png"; 
    	    }else if(a==2) {
    	    	source="src/images/nooo.png"; 
    	    }else {
    	    	source="src/images/xix.jpeg"; 
    	    }
    	    
    	    chart.setBackgroundImage(new ImageIcon(source).getImage());
    	    ChartPanel CP = new ChartPanel(chart);
    	    //Render the frame
    	    this.add(CP);
    }

}