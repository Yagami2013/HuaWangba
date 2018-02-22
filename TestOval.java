public class TestOval{
	public static void main(String[] args){
	/*	double x=294.99473669630333;
		testDouble2(x);
		double y=294;
		testDouble2(y); */
		testOvalPoint();
	}
	static void testDouble(double m){
		int n=(int)m;
		System.out.println(m+","+n);
		if(n<m){
			System.out.println("OK");
		}
	}
	static void testDouble2(double m){
		int n=(int)m;
		System.out.println(m+","+n);
		if(n<m){
			
		}else{System.out.println("OK");}
	}
	static void testOvalPoint(){
		int h=200,a=100,b=125,k=200;
		//int h=250,a=250,b=200,k=200;
		for(int x=100;x<300;x++){
			double[] y=countOvalPoint(h,k,a,b,x);
			int y0=(int)y[0];
			if(y0<y[0])
			{
				
			}else{
				System.out.println(x+","+y0+","+y[0]+","+y[1]);
			}
		}
	}
	public static double[] countOvalPoint(double h,double k,double a,double b,double x){
		double y1,y2;
		y1=k+b/a*Math.sqrt(a*a-h*h-x*x+2*x*h);
		y2=k-b/a*Math.sqrt(a*a-h*h-x*x+2*x*h);
		double[] y={y1<y2?y1:y2,y1<y2?y2:y1};
		return y;
	}
}