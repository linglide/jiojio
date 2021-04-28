package new1;

import java.util.Arrays;
import java.util.Scanner;

public class Power {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;int max=0;int start=0;int all=0;
        int[] num =new int[n];
        for(int i=0;i<n;i++)
        {
        num[i]=gas[i]-cost[i];
        if(max<num[i]) 
        {
            max=num[i];start=i;
            System.out.println("max"+max+"\t"+"start"+start);
        }
        }
       while(max>=0&&all<n)
       {
           max+=num[(++start)%n];
          all++;
          System.out.println("max"+max+"\t"+"all"+all+"\t"+"start"+start%n);
       }
       if(all!=n) return -1;
       else return start%n;
    }
	  public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		  int c;
		     if(jug1Capacity>jug2Capacity)
				     {
				        c=jug1Capacity;jug1Capacity=jug2Capacity;jug2Capacity=c;
				     }
		     int a=jug1Capacity;int b=jug2Capacity;
		       if(a!=targetCapacity&&b!=targetCapacity&&a+b!=targetCapacity)
		           {
		           a=0;
		           System.out.println("a"+a+"b"+b);
		        while(a!=jug1Capacity||b!=jug2Capacity)
		       {
		           if(a==targetCapacity||b==targetCapacity||a+b==targetCapacity) return true;
		           //else if(a==jug1Capacity&&b==0) b=jug2Capacity;
		            else if(a==jug1Capacity&&b!=0){a=0; System.out.println("a"+a+"b"+b);}
		            else if(b==0){ b=jug2Capacity; System.out.println("a"+a+"b"+b);}
		            else if(a!=jug1Capacity&&b!=0&&jug1Capacity-a>=b){ a+=b;b=0; System.out.println("a"+a+"b"+b);}
		            else if(a!=jug1Capacity&&b!=0&&jug1Capacity-a<b){ c=a;a=jug1Capacity;b-=jug1Capacity-c; System.out.println("a"+a+"b"+b);}
		       }
		       System.out.println("a"+a+"b"+b);return false;
		           }
		           else
		        	   { System.out.println("a"+a+"b"+b);
		        	   return true;
		        	   }
		    }
	  public static boolean canMeasureWater1(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		     int c;
		     if(jug1Capacity>jug2Capacity)
				     {
				        c=jug1Capacity;jug1Capacity=jug2Capacity;jug2Capacity=c;
				     }
		     int a=jug1Capacity;int b=jug2Capacity;
		       if(a!=targetCapacity&&b!=targetCapacity&&a+b!=targetCapacity)
		           {
		           a=0;
		       while(a!=jug1Capacity||b!=jug2Capacity)
		       {
		           if(a==targetCapacity||b==targetCapacity||a+b==targetCapacity) return true;
		            else if(a==jug1Capacity&&b!=0) a=0;
		            else if(b==0) b=jug2Capacity;
		            else if(a!=jug1Capacity&&b!=0&&jug1Capacity-a>=b){ a+=b;b=0;}
		            else if(a!=jug1Capacity&&b!=0&&jug1Capacity-a<b){ c=a;a=jug1Capacity;b-=(jug1Capacity-c);}
		       }
		       return false;
		           }
		           else return true;
		    }
	  public static boolean canMeasureWater3(int x, int y, int z,int d[][]) {
		  int c;int g=0;
		  if(z==0) return true;
		  if(z>(x+y)) return false;
		     if(x>y)
		     {				        
		    	 c=x;x=y;y=c;
			}
		     int a=x;int b=y;
		       if(a!=z&&b!=z&&a+b!=z)
		           {
		           a=0;d[g][0]=a;d[g][1]=b;g++;
		       while(a!=x||b!=y)
		       {		           
		    	   if(b==z||a+b==z) return true;
		            else if(a==x&&b!=0){a=0;d[g][0]=a;d[g][1]=b;g++;}
		            else if(b==0){b=y;d[g][0]=a;d[g][1]=b;g++;}
		            else if(a!=x&&b!=0&&x-a>=b){ a+=b;b=0;d[g][0]=a;d[g][1]=b;g++;}
		            else if(a!=x&&b!=0&&x-a<b){ c=a;a=x;b-=(x-c);d[g][0]=a;d[g][1]=b;g++;}
		       }
		       return false;
		           }
		           else{d[g][0]=a;d[g][1]=b;g++;return true;}
		    }
	  public static boolean canMeasureWater2(int x, int y, int z,int d) {
	        if(z == 0) return true;
	        if(z > (x + y)) return false;
	        int min = Math.min(x, y);
	        int max = Math.max(x, y);
	        int g=0;
	        boolean[] app = new boolean[max];   //记录是否出现一个周期，是则说明永远达不到目标

	        int remain = 0;
	        while(!app[remain]){
	            app[remain] = true;
	            remain = (remain + min) % max;
	            System.out.println("remain"+remain+"remain.max"+remain+max);
	            if(remain == z || remain + max == z) return true;   //两种情况
	        }
	        return false;
	   }
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请分别输入两个水壶的容量和所要容量的大小：");
		int a=in.nextInt();int b=in.nextInt();int c=in.nextInt();
		int[][] d=new int [a*b][2];
		if(canMeasureWater3(a,b,c,d))
		{
			System.out.println("判断的结果为："+true);
			System.out.println("操作步骤如下：");
			for(int i=0;i<d.length;i++)
			System.out.println(Arrays.toString(d[i]));
		}
		else System.out.println("判断的结果为："+false);
	}
}
