package kata3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Silvio Alberto Scarfò
 */
public class ShowGraphic extends JFrame{
    
    private final Histogram<String> histogram;
    
    public ShowGraphic(String name,Histogram<String> histogram){
        super(name);
        this.histogram = histogram;
        setSize(800,600);
        add(createPanel());
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        
        return chartPanel;
    }
    
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
       JFreeChart chart = org.jfree.chart.ChartFactory.createBarChart("Grafico", "Dominio email", "Numero di mail", createDataset() , PlotOrientation.HORIZONTAL, true, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        return chart;
        
        
    }
    
    
    private DefaultCategoryDataset createDataset(){
        
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key  : histogram.keySet()) {
            dataSet.addValue(histogram.get(key),key, key);
        }
        return dataSet;
    }
    
    
    
    
    
    
    
    
    
}