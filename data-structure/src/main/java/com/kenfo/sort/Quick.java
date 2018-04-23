package com.kenfo.sort;


/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.sort
 * @Description: 快速排序
 * 通过将数据拆分，分别递归查找排序
 * @date 2018/4/22 下午9:19
 */
public class Quick {

    /**
     * 找到分割点
     * @param a
     * @param low
     * @param high
     * @param size
     * @return
     */
    public int partition(int a[],
                         int low, int high, int size){
        int m = a[low];//要进行比较的初始值
        while (low < high){
            //从右往左找一个大于m的值
            while (low < high && m<a[high]){
                high--;
            }
            if(low < high){
                a[low++] = a[high];
            }
            //从左往右找一个大于m的值
            while (low < high && m>a[low]){
                low++;
            }
            if(low < high){
                a[high--] = a[low];
            }
            a[low] = m;
        }
        return low;
    }

    /**
     * 排序
     * @param a
     * @param low
     * @param high
     * @param size
     * @return
     */
    public int[] quickSort(int a[],
                           int low, int high, int size){
        if(low < high){
            int index = partition(a, low, high, size);
            quickSort(a, low, index - 1, size);
            quickSort(a, index+1, high,size);
        }
        return a;
    }



    public static void main(String[] args) {
        int b[] = {3,7,22,8,5,2,99,76,86,1};
        Quick quick = new Quick();
        quick.quickSort(b, 0, b.length-1, b.length);
        //打印结果
        for(int i=0; i<b.length; i++){
            System.out.print(b[i] + "\t");
        }
    }
}
