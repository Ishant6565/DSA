import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        
        if (n <= 2) return n;
        
        int maxPoints = 0;
        
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int currentMax = 0;
            
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                int gcd = gcd(Math.abs(dx), Math.abs(dy));
                
                
                if ((dx < 0 && dy > 0) || (dx < 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = Math.abs(dy); 
                } else if (dy == 0) {
                    dx = Math.abs(dx);
                }
                
                String slopeKey = (dx / gcd) + "," + (dy / gcd);
                
                slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey, 0) + 1);
                currentMax = Math.max(currentMax, slopeMap.get(slopeKey));
            }
            
            
            maxPoints = Math.max(maxPoints, currentMax + 1);
        }
        
        return maxPoints;
    }
    
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}