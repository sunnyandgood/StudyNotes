package com.edu.bank;

import java.util.Scanner;

public class BankAlgorithm {
    //系统可用资源数
    private Integer[] available;
    //M个进程对N类资源最大资源需求量
    private Integer[][] max;
    //M个进程已经得到N类资源的资源量
    private Integer[][] allocation;
    //M个进程还需要N类资源的资源量
    private Integer[][] need;

    public void setMax(Integer[][] max) {
        this.max = max;
    }

    public void setAllocation(Integer[][] allocation) {
        this.allocation = allocation;
    }

    //计算需求资源(need)
    public void countNeed(){
        need = new Integer[max.length][max[0].length];
        for (int i=0;i<max.length;i++){
            for (int j=0;j<max[i].length;j++){
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
    }
    //计算系统可用资源数(available)
    public void countAvailable(Integer[] allResources){
        available = new Integer[allResources.length];
        for (int i=0;i<allocation.length;i++){
            for(int j=0;j<allocation[i].length;j++){
                //减去已经被占据的资源
                available[j] = allResources[j] - allocation[i][j];
                if (available[j]<0){
                    available[j] = 0;
                }
                allResources[j] = available[j];
            }
        }
    }

    //分配资源
    private void changdata(Integer[] request,Integer index){
        for (int i=0;i<request.length;i++){
            available[i] = available[i] - request[i];
            allocation[index][i] = allocation[index][i] + request[i];
            need[index][i] = need[index][i] - request[i];
        }
    }
    //恢复现场
    private void rstordata(Integer[] request,Integer index){
        for (int i=0;i<request.length;i++){
            available[i] = available[i] + request[i];
            allocation[index][i] = allocation[index][i] - request[i];
            need[index][i] = need[index][i] + request[i];
        }
    }
    //检查安全性
    public Boolean checkSecurity(){
        Integer[] process = new Integer[need.length];
        Integer[] work = new Integer[available.length];

        Boolean[] finish = new Boolean[need.length];
        Boolean flag = false;
        int index = 0;
        for (int i=0;i<available.length;i++){
            work[i] = available[i];
        }

        for (int i=0;i<need.length;i++){
            for (int j=0;j<need.length;j++){
                Boolean[] security = new Boolean[available.length];
                //判断该进程是否已检验过
                if (null!=finish[j]){
                    continue;
                }
                for (int k=0;k<need[j].length;k++){
                    if (work[k]>=need[j][k]){
                        security[k] = true;
                    }else {
                        continue;
                    }
                }
                Boolean mark = false;
                for(int n=0;n<security.length;n++){
                    if (null!=security[n]&&security[n]){
                        mark = true;
                    }else {
                        mark = false;
                        break;
                    }
                }
                if (mark){
                    for (int q=0;q<work.length;q++){
                        work[q] = work[q] + allocation[j][q];

                        System.out.print(work[q] + " ");
                    }
                    System.out.println();

                    finish[j] = true;
                    process[index++] = j;
                }
            }
        }
        for (int i=0;i<finish.length;i++){
            if (null!=finish[i]){
                flag = true;
            }else {
                flag = false;
            }
        }
        if (flag){
            System.out.print("安全序列为：");
            for (int i=0;i<process.length;i++){
                System.out.print("P" + process[i] + " ");
            }
            System.out.println();
        }else {
            System.out.println("该序列不安全！");
        }

        return flag;
    }

    //银行家算法
    public Boolean bankerAlgorithm(Integer[] request,Integer index){
        Boolean needFlag = false;
        Boolean availableFlag = false;
        for (int i=0;i<request.length;i++){
            if (need[index][i]>=request[i]){
                needFlag = true;
            }else {
                System.out.println("进程P" + index + "申请的资源数大于进程P" + index + "还需要" + i + "类资源的资源量!");
                return false;
            }
        }
        if (needFlag){
            for (int i=0;i<request.length;i++){
                if (available[i]>=request[i]){
                    availableFlag = true;
                }else {
                    System.out.println("进程P" + index + "申请的资源数大于系统可用" + i + "类资源的资源量");
                    return false;
                }
            }
            if (availableFlag){
                    changdata(request,index);
                Boolean security = checkSecurity();
                if (security){
                    //安全
                    return true;
                }else {
                    rstordata(request,index);
                }
            }
        }
        return false;
    }
    //展示数据
    public void showData(){
        System.out.print("系统目前各资源可用数目为(available)：[");
        for (int i=0;i<available.length;i++){
            System.out.print(available[i] + " ");
        }
        System.out.println("]");
        System.out.println("资源请求进程   最大需求量矩阵     已分配资源       需求资源");
        for (int i=0;i<max.length;i++){
            System.out.print("\t P" + i + "\t\t\t");
            for (int j=0;j<max[i].length;j++){
                System.out.print(max[i][j] + "\t");
            }
            System.out.print("\t");
            for (int j=0;j<allocation[i].length;j++){
                System.out.print(allocation[i][j] + "\t");
            }
            System.out.print("\t");
            for (int j=0;j<need[i].length;j++){
                System.out.print(need[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //各种资源的数目总和
        Integer allResources[] = {10,5,7};
        //M个进程对N类资源最大资源需求量
        Integer max[][] = {{7,5,3},
                           {3,2,2},
                           {9,0,2},
                           {2,2,2},
                           {4,3,3}};
        //M个进程已经得到N类资源的资源量
        Integer allocation[][] = {{0,1,0},
                                  {2,0,0},
                                  {3,0,2},
                                  {2,1,1},
                                  {0,0,2}};
        Integer request[] = new Integer[allResources.length];
        Integer index;
        Character flag;

        BankAlgorithm bank = new BankAlgorithm();
        bank.setMax(max);
        bank.setAllocation(allocation);
        bank.countAvailable(allResources);
        bank.countNeed();
        bank.showData();
        bank.checkSecurity();
        Scanner input = new Scanner(System.in);
        do {
            do {
                System.out.print("请输入请输入需申请资源的进程号（从P0到P" + (max.length-1) + "，否则重输入!）P");
                index = input.nextInt();
                System.out.println();
            }while (index<0||index>=max.length);
            System.out.println("请输入进程P" + index + "申请的资源数:");
            for (int i=0;i<request.length;i++){
                System.out.print("资源" + i + ":");
                request[i] = input.nextInt();
                System.out.println();
            }

            bank.bankerAlgorithm(request,index);
            bank.showData();
            System.out.println("是否继续银行家算法演示,按'Y'或'y'键继续,按'N'或'n'键退出演示:");
            flag = input.next().charAt(0);
        }while (flag=='y'||flag=='Y');
    }
}
