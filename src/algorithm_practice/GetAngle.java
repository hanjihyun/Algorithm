package algorithm_practice;

public class GetAngle {
//원시 충돌 반사각 구하기
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 5;
	static final int[][] HOLES = {{0, 0}, {127, 0}, {254, 0}, {0, 127}, {127, 127}, {254, 127}};
	
	// 사용자 추가 코드
	static final double R = 5.72 / 2;
	static class Point{
		double x, y;

		Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
//		int[][] balls = new int[NUMBER_OF_BALLS][2];//5번공의 위치
		Point white = new Point(200, 65);
		Point target = new Point(95, 30);
		getAngle(white,target);
	}

	private static double getAngle(Point ptCenter,Point ptTarget) {
		 double angle;
		 double deltaX = ptTarget.x - ptTarget.x;
		 double deltaY = ptTarget.y - ptTarget.y;
		 
		 double distance = Math.sqrt(deltaX * deltaX + deltaY *deltaY);
		 
		 angle = Math.acos(deltaX/distance);
		 
		 if(deltaY > 0) {
			 angle = 3.14 + (3.14 - angle);
		 }
		 
		 return angle;
	}
}
