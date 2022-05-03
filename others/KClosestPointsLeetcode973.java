import java.util.*;

class KClosestPointsLeetcode973 {
    PriorityQueue<Point> pQueue = new PriorityQueue<Point>(new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            return p1.getDistance().compareTo(p2.getDistance());
        }
    });

    public int[][] kClosest(int[][] points, int k) {

        for (int i = 0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            pQueue.add(p);
        }

        int[][] results = new int[k][2];

        for (int i = 0; i < k; i++) {
            Point p = pQueue.poll();

            results[i][0] = p.getX();
            results[i][1] = p.getY();
        }

        return results;
    }

    private class Point {
        private int x, y;
        private double distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;

            computeDistance();
        }

        public void computeDistance() {
            this.distance = Math.sqrt(Math.pow((0 - this.x), 2) + Math.pow((0 - this.y), 2));
        }

        public Double getDistance() {
            return distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        KClosestPointsLeetcode973 ob = new KClosestPointsLeetcode973();
        /*
         * int [][] points = {{1,3},{-2,2}};
         * int k = 1;
         */

        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        int[][] results = ob.kClosest(points, k);

        for (int i = 0; i < results.length; i++) {
            System.out.print("[ " + results[i][0] + ", " + results[i][1] + "] ");
        }
    }
}

/*
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that
 * it is in).
 * 
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * 
 */
