class Solution {
    public double[] convertTemperature(double celsius) {
        double p[] = new double[2];
        p[0]=celsius+273.15;
        p[1]=celsius*1.80+32.00;
        return p;
    }
}