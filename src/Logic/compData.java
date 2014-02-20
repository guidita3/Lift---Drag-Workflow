/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

/**
 * Data structure to store the values of r, t and theta and the drag/lift value.
 * @author Miguel Angel Grimaldos
 */
public class compData {
    private int iteration;
    private double r;
    private double t;
    private double theta;
    private double coeficient;
    
    public compData(){
        iteration = -1;
        r = -1;
        t = -1;
        theta = -1;
        coeficient = -1;
    }
    
    public compData(int iteration, double r, double t, double theta, double coeficient){
        this.iteration = iteration;
        this.r = r;
        this.t = t;
        this.theta = theta;
        this.coeficient = coeficient;
    }
    
    public int getIteration(){
        return iteration;
    }
    
    public void setIteration(int iteration){
        if(iteration >= 0)
            this.iteration = iteration;
    }
    
    public double getR(){
        return r;
    }
    
    public void setR(double r){
            this.r = r;
    }
    
    public double getT(){
        return t;
    }
    
    public void setT(double t){
            this.t = t;
    }
    
    public double getTheta(){
        return theta;
    }
    
    public void setTheta(double theta){
            this.theta = theta;
    }
    
    public double getCoeficient(){
        return coeficient;
    }
    
    public void setCoeficient(double coeficient){
            this.coeficient = coeficient;
    }
}
