class Solution {
    public double largestTriangleArea(int[][] p) {
        int n=p.length;
        double ans=0.0;
        for(int i=0;i<n-2;i++){
            double x1=p[i][0],y1=p[i][1];
            for(int j=i+1;j<n-1;j++){
                double x2=p[j][0],y2=p[j][1];
                double dx=x2-x1, dy=y2-y1;
                double base=Math.sqrt(dx*dx+dy*dy);
                for(int k=j+1;k<n;k++){
                    double x3=p[k][0],y3=p[k][1];
                    double numerator=dy*x3 - dx*y3 + dx*y1 - dy*x1;
                    if(numerator<0) numerator=-numerator;
                    double height=numerator/base;
                    double area=0.5*base*height;
                    ans=Math.max(ans,area);
                }
            }
        }
        return ans;
    }
}
