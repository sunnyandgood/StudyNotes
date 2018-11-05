#include <string.h>
#include <iostream>
using namespace std;
#define FALSE 0
#define TRUE 1
#define W 10
#define R 20
int M = 4 ; //总进程数
int N = 3 ; //资源种类
int ALL_RESOURCE[3] = {9,3,6};//各种资源的数目总和
int MAX[4][3] = {{3,2,2},{6,1,3},{3,1,4},{4,2,2}}; //M个进程对N类资源最大资源需求量
int AVAILABLE[R]; //系统可用资源数
int ALLOCATION[4][3] = {{1,0,0},{6,1,2},{2,1,1},{0,0,2}}; //M个进程已经得到N类资源的资源量
int NEED[W][R]; //M个进程还需要N类资源的资源量
int Request[R]; //请求资源个数

void showdata() //函数showdata,输出资源分配情况
{
    int i;
    int j;
    cout<<"各种资源的总数量(all):";
    cout<<" [";
    for (j=0;j<N;j++)
    {
        cout<<" "<<ALL_RESOURCE[j];
    }
    cout<<" ]";
    cout<<endl<<endl;
    cout<<"系统目前各种资源可用的数为(available):";
    cout<<" [";
    for (j=0;j<N;j++)
    {
        cout<<" "<<AVAILABLE[j];
    }
    cout<<" ]";
    cout<<endl<<endl;

    cout<<" 各进程已经得到的资源量(allocation): "<<endl<<endl;
    cout<<"       资源0"<<"     资源1"<<"     资源2"<<endl;
    for (i=0;i<M;i++)
    {
        cout<<"进程p"<<i<<":    ";
        for (j=0;j<N;j++)
        {
            cout<<ALLOCATION[i][j]<<"       ";
        }
        cout<<endl;
    }
    cout<<endl;
    cout<<" 各进程还需要的资源量(need):"<<endl<<endl;
    cout<<"       资源0"<<"     资源1"<<"    资源2"<<endl;
    for (i=0;i<M;i++)
    for (i=0;i<M;i++)
    {
        cout<<"进程p"<<i<<":   ";
        for (j=0;j<N;j++)cout<<NEED[i][j]<<"        ";;
        cout<<endl;
    }
    cout<<endl;
}
void changdata(int k) //分配资源
{
    int j;
    for (j=0;j<N;j++)
    {
        AVAILABLE[j] = AVAILABLE[j]-Request[j];
        ALLOCATION[k][j] = ALLOCATION[k][j]+Request[j];
        NEED[k][j] = NEED[k][j]-Request[j];
    }
}

void rstordata(int k) //恢复现场
{
    int j;
    for (j=0;j<N;j++)
    {
        AVAILABLE[j] = AVAILABLE[j]+Request[j];
        ALLOCATION[k][j] = ALLOCATION[k][j]-Request[j];
        NEED[k][j] = NEED[k][j]+Request[j];
    }
}

int chkerr(int s) //函数chkerr,检查是否安全
{
    int WORK,FINISH[W];
    int i;
    int j;
    int k = 0;
    for(i=0;i<M;i++)FINISH[i]=FALSE;
    {
        for(j=0;j<N;j++)
        {
            WORK = AVAILABLE[j];
            i = s;

            do
            {
                if(FINISH[i]==FALSE&&NEED[i][j]<=WORK)
                {
                    WORK = WORK+ALLOCATION[i][j];
                    FINISH[i] = TRUE;
                    i = 0;
                }
                else
                {
                    i++;
                }
            }
            while(i<M);

            for(i=0;i<M;i++)
            {
                if(FINISH[i]==FALSE)
                {
                    cout<<endl;
                    cout<<" 系统不安全!!! 本次资源申请不成功!!!"<<endl;
                    cout<<endl;
                    return 1;
                }
            }
        }
    }
    cout<<endl;
    cout<<" 经安全性检查，系统安全，本次分配成功。"<<endl;
    cout<<endl;
    return 0;
}
void bank()   //银行家算法主体
{
     int i = 0;
     int j = 0;
     char flag = 'Y';

     while(flag=='Y'||flag=='y')
     {
        i=-1;
        while(i<0||i>=M)
        {
            cout<<" 请输入需申请资源的进程号（从P0到P"<<M-1<<"，否则重输入!）:";
            cout<<"P";cin>>i;
            if(i<0||i>=M)
            {
                cout<<" 输入的进程号不存在，重新输入!"<<endl;
            }
        }
        cout<<" 请输入进程P"<<i<<"申请的资源数:"<<endl;
        for (j=0;j<N;j++)
        {
            cout<<" 资源"<<j<<": ";
            cin>>Request[j];
            if(Request[j]>NEED[i][j]) //若请求的资源数大于进程还需要i类资源的资源量j
            {
                cout<<" 进程P"<<i<<"申请的资源数大于进程P"<<i<<"还需要"<<j<<"类资源的资源量!";
                cout<<"申请不合理，出错!请重新选择!"<<endl<<endl;
                flag = 'N';
                break;
            }
            else
            {
                if(Request[j]>AVAILABLE[j]) //若请求的资源数大于可用资源数
                {
                    cout<<" 进程P"<<i<<"申请的资源数大于系统可用"<<j<<"类资源的资源量!";
                    cout<<"申请不合理，出错!请重新选择!"<<endl<<endl;
                    flag = 'N';
                    break;
                }
            }
        }
        if(flag=='Y'||flag=='y')
        {
            changdata(i); //调用changdata(i)函数，改变资源数
            if(chkerr(i)) //若系统安全
            {
                rstordata(i); //调用rstordata(i)函数，恢复资源数
                showdata();   //输出资源分配情况
            }
            else       //若系统不安全
                showdata(); //输出资源分配情况
        }
        else      //若flag=N||flag=n
        {
            showdata();
        }
        cout<<endl;
        cout<<" 是否继续银行家算法演示,按'Y'或'y'键继续,按'N'或'n'键退出演示: ";
        cin>>flag;
     }
}
//主函数
int main()
{
    int i = 0;
    int j = 0;
    int p;
    //初始化资源数量
    for (j=0;j<N;j++)
    {
        p = ALL_RESOURCE[j];
        for (i=0;i<M;i++)
        {
            p = p-ALLOCATION[i][j];//减去已经被占据的资源
            AVAILABLE[j] = p;
            if(AVAILABLE[j]<0)
                AVAILABLE[j] = 0;
        }
    }
    for (i=0;i<M;i++)
    {
        for(j=0;j<N;j++)
        {
            NEED[i][j] = MAX[i][j]-ALLOCATION[i][j];
        }
    }
    showdata();
    bank();
    return 0;
}
