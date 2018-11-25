package com.edu.disk;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wrh
 * @Date: 2018/11/24 21:29
 */
public class DiskScheduling {
    //磁盘申请序列
    private Integer[] queue;
    //当前磁道号
    private Integer head;
    //磁盘申请序列的长度
    private Integer length;
    //磁盘调度的过程
    private String[][] control;
    //总移动距离
    private Double sumLenth;
    //移动距离
    private Integer sub;
    //control的计数器
    private Integer index;

    public DiskScheduling(){

    }
    public DiskScheduling(Integer[] queue,Integer head){
        this.queue = queue;
        this.head = head;
        length = queue.length;
        control = new String[2][queue.length+1];
        sumLenth = 0.0;
        sub = 0;
        index = 0;
    }
    /**
     * 先来先服务(FCFS，First Come First Served)
     * 根据进程请求访问磁盘的先后次序进行调度
     * @return 平均寻道长度
     */
    public String fcfs(){
        control[0][0] = "被访问的下一磁道号：";
        control[1][0] = "移动距离（磁道数）：";
        for (int i=0;i<length;i++){
            this.count(i);
        }

        for (int i=1;i<length+1;i++){
            sumLenth += Integer.parseInt(control[1][i]);
        }
        System.out.println("先来先服务(FCFS，First Come First Served):");
        this.show(control);
        return String.format("%.1f",sumLenth/length);
    }

    /**
     * 最短寻道时间优先(SSTF，Shortest Seek Time First)
     * 访问的磁道与当前磁头所在的磁道距离最近，以使每 次的寻道时间最短。
     * @return 平均寻道长度
     */
    public String sstf(){
        List<Integer> list = new LinkedList<>();
        for (int i=0;i<queue.length;i++){
            list.add(queue[i]);
        }
        Arrays.sort(queue);
        control[0][0] = "被访问的下一磁道号：";
        control[1][0] = "移动距离（磁道数）：";
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                Boolean flag = false;
                for (int k=1;k<length+1;k++){
                    if(queue[j].toString().equals(control[0][k])){
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    continue;
                }
                Integer min = this.min(list, head);
                if (Math.abs(queue[j]-head) == min){
                    this.count(j);
                    list.remove(queue[j]);
                }
            }
        }
        for (int i=1;i<length+1;i++){
            if (null!=control[1][i]){
                sumLenth += Integer.parseInt(control[1][i]);
            }
        }
        System.out.println("最短寻道时间优先(SSTF，Shortest Seek Time First)：");
        this.show(control);
        return String.format("%.1f",sumLenth/length);
    }

    /**
     * 扫描(SCAN)算法
     * @return
     */
    public String scan(){
        Arrays.sort(queue);
        control[0][0] = "被访问的下一磁道号：";
        control[1][0] = "移动距离（磁道数）：";
        Integer nextNearInddex = this.nextNear(queue, head);
        //磁盘指针朝外
        for (int i=nextNearInddex;i<queue.length;i++){
            this.count(i);
        }
        //磁盘指针朝内
        for (int i=nextNearInddex-1;i>=0;i--){
            this.count(i);
        }

        for (int i=1;i<length+1;i++){
            if (null!=control[1][i]){
                sumLenth += Integer.parseInt(control[1][i]);
            }
        }
        System.out.println("扫描(SCAN)算法 ：");
        this.show(control);
        return String.format("%.1f",sumLenth/length);
    }

    /**
     * 循环扫描(CSCAN)算法
     * 只是自里向外移动，当磁头移到最外的磁道并访问后，
     * 磁头立即返回到最里的欲访问的磁道，
     * 亦即将最小磁道号紧接着最大磁道号构成循环，进行循环扫描。
     * @return
     */
    public String cscan(){
        Arrays.sort(queue);
        control[0][0] = "被访问的下一磁道号：";
        control[1][0] = "移动距离（磁道数）：";
        Integer nextNearInddex = this.nextNear(queue, head);
        //磁盘指针朝外
        for (int i=nextNearInddex;i<queue.length;i++){
            this.count(i);
        }
        //磁盘指针朝内
        for (int i=0;i<nextNearInddex;i++){
            this.count(i);
        }

        for (int i=1;i<length+1;i++){
            if (null!=control[1][i]){
                sumLenth += Integer.parseInt(control[1][i]);
            }
        }
        System.out.println("循环扫描(CSCAN)算法");
        this.show(control);
        return String.format("%.1f",sumLenth/length);
    }

    /**
     * 计算list中数据与head的距离最小值
     * @param list
     * @param first
     * @return
     */
    public Integer min(List<Integer> list,Integer first){
        Integer index = -1;
        Integer[] sub = new Integer[list.size()];
        for (Integer integer : list){
            sub[++index] = Math.abs(integer - first);
        }
        Integer min = sub[0];
        for (int i=1;i<sub.length;i++){
            min = (min<sub[i]) ? min : sub[i];
        }
        return min;
    }

    /**
     * 计算磁头移动距离，并记录磁盘调度的过程
     * @param i
     */
    private void count(Integer i){
        sub = Math.abs(queue[i]-head);
        head = queue[i];
        control[0][++index] = queue[i].toString();
        control[1][index] = sub.toString();
    }

    public Integer nextNear(Integer[] queue,Integer head){
        Integer nextNearIndex = 0;
        for (int i=0;i<queue.length;i++){
            if (queue[i] >= head){
                nextNearIndex = i;
                break;
            }
        }
        return nextNearIndex;
    }

    /**
     * 显示磁盘调度的过程
     * @param control
     */
    public void show(String[][] control){
        for (int i=0;i<control.length;i++){
            for (int j=0;j<control[i].length;j++){
                System.out.print(control[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[] queue = {55,58,39,18,90,160,150,38,184};
        Integer head = 100;
        DiskScheduling fcfs = new DiskScheduling(queue,head);
        String fcfsAvageLength = fcfs.fcfs();
        System.out.println("fcfs的平均寻道长度：" + fcfsAvageLength);
        System.out.println();

        DiskScheduling sstf = new DiskScheduling(queue,head);
        String sstfAvageLength = sstf.sstf();
        System.out.println("sstf的平均寻道长度：" + sstfAvageLength);
        System.out.println();

        DiskScheduling scan = new DiskScheduling(queue,head);
        String scanAvageLength = scan.scan();
        System.out.println("scan的平均寻道长度：" + scanAvageLength);
        System.out.println();

        DiskScheduling cscan = new DiskScheduling(queue,head);
        String cscanAvageLength = cscan.cscan();
        System.out.println("cscan的平均寻道长度：" + cscanAvageLength);
    }
}
