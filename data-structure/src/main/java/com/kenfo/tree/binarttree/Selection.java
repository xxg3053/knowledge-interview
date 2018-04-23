package com.kenfo.tree.binarttree;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.tree.binarttree
 * @Description: 直接选择排序
 * @date 2018/4/23 上午10:25
 */
public class Selection {

    public void selectionSort(int a[]){
        for (int i=0; i<a.length; i++){
            int index = getIndex(a,i);
            int temp = 0;
            if(i != index){//交换
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }

    }

    /**
     * 获取最小值的索引
     * @param a
     * @return
     */
    public int getIndex(int a[], int index){
        //index 起始位置
        int temp = a[index];
        int ind = index;
        for(int i=index+1; i<a.length; i++){
            if(temp>a[i]){
                temp = a[i];
                ind = i;
            }
        }
        return ind;//返回最小值的索引号
    }

    public static void main(String[] args) {
        int b[] = {3,7,22,8,5,2,99,76,86,1};
        Selection selection = new Selection();
        selection.selectionSort(b);

        //排序完成
        for(int i=0; i<b.length;i++){
            System.out.print(b[i] + "\t");
        }
    }
}
