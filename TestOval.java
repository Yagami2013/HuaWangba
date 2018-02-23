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
		int h=200,a=200,b=250,k=500;
		//int h=250,a=250,b=200,k=200;
		int[][] num=new int[10][3];
		int i=0;
		for(int x=h-a+1;x<h+a;x++){
			double[] y=countOvalPoint(h,k,a,b,x);
			int y0=(int)y[0];
			if(y0<y[0])
			{
				
			}else if(x==h){ 

			}
			else{
				num[i][0]=x;
				num[i][1]=(int)y[0];
				num[i][2]=(int)y[1];
				i++;
			}
		}
		for(int m=0;m<8;m++){
			for(int n=0;n<3;n++){
				System.out.print(num[m][n]+",");				
			}
			System.out.println();
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