/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.compData;
import Persistence.DataDB;
import java.awt.Color;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.exp;
import static java.lang.StrictMath.sin;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class MainFrame extends javax.swing.JFrame {

    private double[] old_params; // radius, length, angle, default
    private double[] current_params; // radius, length, angle, default
    private double[] new_params; // radius, length, angle, default
    private double[] step;
    private int number_iterations;
    private boolean error = false;
    private compData data;
    private DataDB dataBase;
    private boolean first_run;
    private SystemError failurePopup;
    private int number = 0;
    private XYSeries series;
    

    public void drawChart() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        dataset.addSeries(this.series);

        JFreeChart chart = ChartFactory.createXYLineChart("", "Iteration number", "Lift/Drag", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel CP = new ChartPanel(chart);
        //chart_panel.setSize(400, 400);
        chart_panel.setLayout(new java.awt.BorderLayout());
        chart_panel.add(CP);
        chart_panel.setVisible(true);
        chart_panel.validate();
        chart_panel.repaint();
        chart_panel.revalidate();

    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        try {
            this.dataBase = new DataDB();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        setBackground(Color.white);
        try {
            data = dataBase.findLastData();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        r_input.setText(Double.toString(data.getR()));
        t_input.setText(Double.toString(data.getT()));
        angle_input.setText(Double.toString(data.getTheta()));
        this.setTitle("Lift and Drag Optimizer");
        this.old_params = new double[4];
        this.current_params = new double[4];
        this.new_params = new double[4];
        this.step = new double[3];
        this.first_run = true;
        this.series = new XYSeries("Optimized value");
        this.failurePopup = new SystemError();
        this.failurePopup.setVisible(this.error);
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        r_input = new javax.swing.JTextField();
        t_input = new javax.swing.JTextField();
        angle_input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chart_panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        n_iter = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lift and Drag Optimizer");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(830, 710));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        r_input.setText("1");
        r_input.setName("r_input"); // NOI18N
        jPanel1.add(r_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 80, -1));

        t_input.setText("1");
        t_input.setName("t_input"); // NOI18N
        jPanel1.add(t_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 80, -1));

        angle_input.setText("0.5");
        angle_input.setName("angle_input"); // NOI18N
        jPanel1.add(angle_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 80, -1));

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setText("Radius = ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, -1));

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setText("Length = ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, -1));

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setText("Angle = ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 60, -1));

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setText("meter(s)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setText("meter(s)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        chart_panel.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout chart_panelLayout = new javax.swing.GroupLayout(chart_panel);
        chart_panel.setLayout(chart_panelLayout);
        chart_panelLayout.setHorizontalGroup(
            chart_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        chart_panelLayout.setVerticalGroup(
            chart_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jPanel1.add(chart_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 245, 810, 340));

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/image.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

        jLabel7.setText("radians");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        n_iter.setText("200");
        jPanel1.add(n_iter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 60, -1));

        jLabel8.setText("Iterations =");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This function calculates the lift force of the wing. It uses SI units,
     * and takes example values for the speed, air density and drag coefficient
     * for a BAC lightning.
     *
     * @param r This is the width of the wing.
     * @param t This is the length of the wing.
     * @param theta This is the angle of attack.
     * @return Returns the value of the lift force.
     * @author Joan
     */
    public double lift(double r, double t, double theta) {
        double lift;
        double lift_coeff;

        lift_coeff = 1.01731 * exp(theta) - 1.01731;
        lift = lift_coeff * (5 * cos(theta) + 2 * r * sin(theta)) * 2 * t * 1000 * 278 * 278 * 0.5;//We assume 5 meters wing width, 1000 g/m^3 air density, 1000 km/h = 278 m/s, all units are from the SI

        return lift;
    }

    /**
     * This function calculates the drag force of the wing. It uses SI units,
     * and takes example values for the speed, air density and drag coefficient
     * for a BAC lightning.
     *
     * @param r This is the width of the wing.
     * @param t This is the length of the wing.
     * @param theta This is the angle of attack.
     * @return Returns the value of the drag force.
     * @author Joan
     */
    public double drag(double r, double t, double theta) {
        double drag;
        double drag_coeff = 0.09; //Assuming Streamlined half-body shape for the wing

        drag = drag_coeff * 2 * r * t * 1000 * 278 * 278 * 0.5 / (cos(theta));
        return drag;
    }

    /**
     * This is the optimiser function. It receives the parameters used in the previous iteration, as well as the parameters used in the current iteration.
     * It generates the parameters to be used in the next iteration.
     * 
     * @param lift_drag This is the lift/drag coefficient obtained in the current iteration
     * @param old_lift_drag This is the lift/drag coefficient obtained in the past iteration
     * @param old_param This is a vector containing the parameters used in the last iteration
     * @param current_param This is a vector containing the parameters used in the current iteration
     * @param step This vector contains the step size of every parameter. For example step[0] is teh step size for current_param[0] (r)
     * @param p This indicates which parameter to change in this iteration.
     * @return Returns the parameters to be used in the next iteration
     * @author Joan
     */
    public double[] optimizer(double lift_drag, double old_lift_drag, double[] old_param, double[] current_param, double step[], int p) {
        double[] new_param = new double[5];//param[0]=r, param[1]=t, param[2]=theta, param[3]= turns improving in a row
        double current_lift_drag;
        boolean improve = true;
        new_param = current_param;

        current_lift_drag = lift_drag;

        if (current_lift_drag >= old_lift_drag) {
            improve = true;
            new_param[3] = current_param[3] + 1;//total turns improving non-stop + 1
        }
        if (current_lift_drag < old_lift_drag) {
            improve = false;
            new_param[3] = 0; //total turns improving non-stop is now 0 (this turn we didn't get a better result
        }

        if (improve == false){
            step[p] = (-1)*step[p];
            improve = true;
        }

        if (improve == true){
            new_param[p]=current_param[p] + step[p]; //we need to create an old_param and a current_param when starting the code for the first time, the difference between old_param[i] and current_param[i] is the step size for each parameter.
            
            if (new_param[2] > 0.52){ //if theta > 30 --> theta = 30 (30 degrees in radians = 0.52 aprox
                new_param[2] = 0.52;
            }
            if (new_param[2] < 0){ //if theta < 0 --> theta = 0
                new_param[2] = 0;
            }
            if (new_param[0] < 1){
                new_param[0] = 1;
            }
            if (new_param[1] <=0){
                new_param[1] =0.001;
            }
        }

        return new_param;
    }

    /**
     * This is the function that is executed when the button submit is pressed.
     * It starts the optimisation process.
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double lift, drag, lift_drag, old_lift_drag = 0;
        int p = 0;
        try {
            data = dataBase.findLastData();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        number = data.getIteration() + 1;
        
        this.current_params[0] = Double.parseDouble(r_input.getText());
        this.current_params[1] = Double.parseDouble(t_input.getText());
        this.current_params[2] = Double.parseDouble(angle_input.getText());
        this.current_params[3] = 0;

        // starts increasing
        this.step[0] = 0.001;
        this.step[1] = 0.001;
        this.step[2] = 0.00001;

        this.old_params[0] = this.current_params[0] - step[0];
        this.old_params[1] = this.current_params[1] - step[1];
        this.old_params[2] = this.current_params[2] - step[2];
        this.old_params[3] = 0;
        this.number_iterations = Integer.parseInt(n_iter.getText());
        int i = 1;

        while (i < this.number_iterations + 1) {
            if (i%5 == 0){ //p indicates the parameter to change each iteration. This way the optimizer function only changes ONE parameter per function call (the one that p indicates. We change p every 5 iterations.
                p++;
                if (p>2){
                    p=0;
                }
            }
            
            this.error = false;
            lift = lift(this.current_params[0], this.current_params[1], this.current_params[2]);
            drag = drag(this.current_params[0], this.current_params[1], this.current_params[2]);
            if (lift < 0) {
                this.error = true;
                System.out.println("An error occurred.");
                i = this.number_iterations +1;
            }
            if (drag <= 0) {
                this.error = true;
                System.out.println("An error occurred.");
                i = this.number_iterations +1;
            }
            
            this.failurePopup.setVisible(error); //ERROR POP UP
       
           
            if (this.error == false){
                lift_drag = lift/drag;
                this.new_params = optimizer(lift_drag, old_lift_drag, this.old_params, this.current_params, this.step, p);

                //Saves the data to the database
                data = new compData(number, new_params[0], new_params[1], new_params[2], lift_drag);
                try{
                    dataBase.createNewData(data);
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
            
                System.out.println("Lift: " + lift + "    Drag: " + drag + "   Lift/Drag: " + lift_drag);
                System.out.println("new_r: " + this.new_params[0] + "   new_t: " + this.new_params[1] + "   new_theta: " + this.new_params[2]);
            

                old_lift_drag = lift_drag;
                this.old_params = this.current_params;
                this.current_params = this.new_params;
                
                if(number_iterations <= 100) {
                    this.series.add(number, old_lift_drag);
                    drawChart();
                    repaint();
                    revalidate();
                } else if(number_iterations > 100) {
                    if (add == 0 || add == 10) {
                        // Re-plot
                        /*if (this.series.getItems().size() == 300) {
                            this.series.remove(0);                    
                        }*/

                        this.series.add(number, old_lift_drag);

                        drawChart();
                        repaint();
                        revalidate();
                        add = 0;
                    }
                    add++;
                }
                
                i++;
                number++;
            }
            
            
            if (!this.first_run) {
                this.r_input.setText(Double.toString(this.old_params[0]));
                this.t_input.setText(Double.toString(this.old_params[1]));
                this.angle_input.setText(Double.toString(this.old_params[2]));
            }
            this.first_run = false;
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField angle_input;
    private javax.swing.JPanel chart_panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField n_iter;
    private javax.swing.JTextField r_input;
    private javax.swing.JTextField t_input;
    // End of variables declaration//GEN-END:variables
}
