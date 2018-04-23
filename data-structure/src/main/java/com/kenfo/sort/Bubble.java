package com.kenfo.sort;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.sort
 * @Description: 冒泡排序
 * 两两比较，将大值下层
 * @date 2018/4/22 下午8:26
 */
public class Bubble {

    /**
     * 冒泡排序
     * 优点：若数据已有部分排好序，则可快速完成排序，稳定的排序方法
     * 缺点：会反复扫描数据，比较相邻两个数据，速度不快没有效率
     * @param a
     */
    public void bubbleSort(int a[]){
        int i,j;
        int temp = 0;
        for (i=0; i<a.length-1; i++){
           // System.out.println("第" +(i+1)+ "趟排序");
            for(j=0; j<a.length-i-1; j++){//每趟保证最大数后移
                //大于号，等于的情况不用交换，因此是稳定排序
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            //显示第一趟排序后的结果
            /**
            for(j=0;j<a.length;j++){
                System.out.print(a[j]+"\t");
            }
            System.out.println("");
             **/
        }
    }
    public static void main(String[] args) {
        int b[] = {3,7,22,8,5,2,99,76,86,1};
        Bubble bubble = new Bubble();
        bubble.bubbleSort(b);
        //打印结果
        for(int i=0; i<b.length; i++){
            System.out.print(b[i] + "\t");
        }
    }
}
