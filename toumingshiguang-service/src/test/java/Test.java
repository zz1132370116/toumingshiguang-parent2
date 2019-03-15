import java.util.Arrays;
import java.util.Calendar;

/**
 * @Auther: 舍頭襘游泳
 * @Date: 2019/3/14 10:42
 * @Description:
 */

/**
 * 和络笔试题应用题
 */
public class Test {
    /**
     * 1.九九乘法表
     * @param args
     */
    public static void main(String[] args) {
        for(int i =1; i<=9;i++){
            System.out.print("|");
            for (int j = 1; j<=i;j++){
                System.out.print(i+"*"+j+"="+j*i+"	");
            }
            System.out.print("\n");
        }
    }

    /**
     * 2.编程计算距当前时间10天后的日期和时间，并用“xxxx年xx月xx日”的格式输出新的日期和时间
     */
    @org.junit.Test
    public void date(){

        Calendar cal=Calendar.getInstance();
        //设置一年中的天数+10
        cal.add(Calendar.DAY_OF_YEAR,10);

        //获取年月日
        String strDate=cal.get(Calendar.YEAR)+"年"

        +(cal.get(Calendar.MONTH)+1)+"月"

        +cal.get(Calendar.DATE)+"日";

        System.out.println("10天后的日期为："+strDate);


    }
    /**
     *  3.编写一个程序，用选择法对数组a[]={20,10,55,40,30,70,60,80,90,100}进行从大到小的排序
     */
    @org.junit.Test
    public void num3(){
        int a[] = { 20, 10, 55, 40, 30, 70, 60, 80, 90, 100 };
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
    @org.junit.Test
    public void num31(){
        int[] arr= { 20, 10, 55, 40, 30, 70, 60, 80, 90, 100 };
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {
            // 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){
                // 选最小的记录
                if(arr[j] < arr[k]){
                    k = j;
                    //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){
                //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }

    }
}
