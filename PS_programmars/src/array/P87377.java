package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P87377 {
	
	public static void main(String[] args) {
		
	}
	
	static class Point {
		
		public long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	
	
	public static String[] solution(int[][] line) {
       
        
        List<Point> points = new ArrayList<>();
        
//        두 직선을 골라서 교차점을 배열에 담음
        for (int i =0;i<line.length;i++) {
        	for (int j=i+1;j<line.length;j++) {
        		Point p = intersaction(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
        		if (p!=null) points.add(p);
        	}
        }
        
//	   교차점들을 담은 배열을 구했으니 화면에 나타낼 차례
//     width와 height를 구하기
        
       Point maxPoint = getMaxPoint(points);
       Point minPoint = getMinPoint(points);
       
       int width = (int)(maxPoint.x-minPoint.x)+1;
       int height = (int)(maxPoint.y-minPoint.y)+1;
       
//      화면에 표시할 배열
       char[][] arr = new char[height][width];
       
//      일단 .으로 다 채우기 
       for (char[] row : arr) {
    	   Arrays.fill(row,'.');
       }
        
       for (Point p : points) {
    	   int x = (int)(p.x-minPoint.x);
    	   int y = (int)(maxPoint.y-p.y);
    	   arr[y][x] = '*';
       }
       String[] answer = new String[arr.length];
       for(int i=0;i<arr.length;i++) {
    	   answer[i] = new String(arr[i]);
       }
       
       
        
        return answer;
    }
	 
	static Point getMaxPoint(List<Point> points) {
		
		long maxX = Long.MIN_VALUE;
		long maxY = Long.MIN_VALUE;
		
		for (Point p : points) {
			maxX = Math.max(maxX, p.x);
			maxY = Math.max(maxY, p.y);
		}
		
		return new Point(maxX,maxY);
	}
	
	static Point getMinPoint(List<Point> points) {
		
		long minX = Long.MAX_VALUE;
		long minY = Long.MAX_VALUE;
		
		for (Point p : points) {
			minX = Math.min(minX, p.x);
			minY = Math.min(minY, p.y);
		}
		
		return new Point(minX,minY);
	}
	
	
//	두 직선의 교차점
	static Point intersaction(long a, long b, long e, long c, long d, long f) {
		
		if (a*d-b*c==0) return null;
		
		double x = (double)(b*f-e*d)/(a*d-b*c);
		double y = (double)(e*c-a*f)/(a*d-b*c);
		
//		정수 좌표가 아닌경우 null
		if(x%1!=0||y%1!=0) return null;
		
		
		return new Point((long)x, (long)y);
	}
	
	
	
	

}
