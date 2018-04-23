package com.kenfo.sort;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.sort
 * @Description: 插入排序
 *
 *
 *
 * @date 2018/4/23 下午12:56
 */
public class Insert {

    public void sort(int a[]){
        int i,j;
        int insertnode;//要插入数据的值
        for(i=1; i<a.length; i++){
            insertnode = a[i];
            j = i-1;
            while (j>=0 && insertnode<a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = insertnode;

            //排序打印
            //System.out.println("i:" + i + " j:" + j + " insertnode: " + insertnode );

        }
    }

    public static void main(String[] args) {
        int b[] = {3,7,22,8,5,2,99,76,86,1};
        System.out.println("原始：");
        for(int i=0; i<b.length; i++){
            System.out.print(b[i] + "\t");
        }
        System.out.println("");
        Insert insert = new Insert();
        insert.sort(b);
        System.out.println("排序：");
        for(int i=0; i<b.length; i++){
            System.out.print(b[i] + "\t");
        }
    }
}
