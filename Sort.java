package new1;

import java.util.Scanner;

public class Sort {
	/**
	 * 冒泡排序
	 */
	public static void maopao(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)//数组长度-1轮比较
		{
			for(int j=0;j<arr.length-1-i;j++)//每轮比较需要比较的次数
			{
				if(arr[j]>arr[j+1])//按照从小到大排列，如果按照从大到小则将大于符号改为小于符号便可
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
			}
			int t=i+1;
			System.out.print("第"+t+"次冒泡排序后的数组：");          
            printArray(arr);
		}
	}
    /**
     * 选择排序
     * @param arr
     */
    public static void selection(int[] arr)
    {
          //选择排序的优化
        int t;
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){ 
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }    
            t=i+1;
            System.out.print("第"+t+"次选择排序后的数组：");          
            printArray(arr);
        }
        }
    /**
     * 插入排序
     * @param nums
     */
    public static void insertion(int[] nums)
    {
         //默认构造从左→右依次递增的序列
        for(int i=1; i<nums.length; i++){
            int j;
            int temp = nums[i];                      //temp是本趟待插入的数，之前从0~i-1的数全是从左→右有序递增。
            for(j=i-1; j>=0&&nums[j]>temp; j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
            System.out.print("第"+i+"次直接插入排序后的数组：");          
            printArray(nums);
        }
    }
    /**
     * 输入初始数组
     * @return
     */
    public static int[] buildArray(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一组整数值，数字之间用','隔开：");
        int[] a = null;//创建空数组a
        String strs = scan.nextLine();//获取控制台输入信息
       //strs存放的是从键盘输入的string类数值
            String[] s = strs.split(",");//将字符串转换成字符数组
            a = new int[s.length];
            for(int i=0; i<a.length; i++){//将字符数组转换成
                a[i] = Integer.valueOf(s[i]);
            }
        return a;
    }
//打印数组
    public static void printArray(int[] arr){
        System.out.print('[');
        for(int i=0;i<arr.length-1;i++){//循环输出数组
            System.out.print(arr[i]+", ");
        }
        System.out.println(arr[arr.length-1] + "]");
    }
    public static void main(String[] args){
        int[] nums = buildArray();
        System.out.print("您输入的初始数组是 : ");
        printArray(nums);
       /*System.out.println("插入排序:");
        insertion(nums);//插入排序方法
        System.out.println("选择排序:");
        selection(nums);//选择排序方法*/
        System.out.println("冒泡排序:");
        maopao(nums);
    }

}
