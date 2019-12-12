/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Coto
 */
public interface SystemSolver {
    public boolean hasSolutions();
    public int getSolutionsNumber();
    public int getRows();
    public int getColumns();
    public double[][] getIncompleteMatrix();
    public double[][] getCompleteMatrix();
    public double[] solveSystem();
    public int getIncompleteRank();
    public int getCompleteRank();
    public double[] solveSystem(double[][] A, double[] b);
}
