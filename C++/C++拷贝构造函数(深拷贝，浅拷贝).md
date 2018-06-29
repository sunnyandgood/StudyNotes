### 一、普通类型的对象之间的复制
> **For example**
````
int a=88;
int b=a; 
````

### 二、类对象之间的复制

类对象与普通对象不同，类对象内部结构一般较为复杂，存在各种成员变量。如下是一个类对象拷贝的简单例子。 
> **For example**
````
#include <iostream>
using namespace std;

class CExample
{
private:
    int a;
public:
    CExample(int b)
    {
        a = b;
    }
    void Show ()
    {
        cout<<a<<endl;
    }
};

int main()
{
    CExample A(100);
    CExample B = A;
    B.Show ();
    return 0;
}


运行程序，屏幕输出100。从以上代码的运行结果可以看出，系统为对象B分配了内存并完成了与对象A的复制过程。就类对象而言，相同类型
的类对象是通过拷贝构造函数来完成整个复制过程的
````
### 三、拷贝构造函数的工作过程
> **For example**
````
#include <iostream>
using namespace std;

class CExample
{
private:
    int a;
public:
    CExample(int b)
    {
        a = b;
    }
    CExample(const CExample &example)
    {
        a=example.a;
    }
    void Show ()
    {
        cout<<a<<endl;
    }
};

int main()
{
    CExample A(100);
    CExample B = A;
    B.Show ();
    return 0;
}


CExample(const CExample &example)就是我们自定义的拷贝构造函数。可见，拷贝构造函数是一种特殊的构造函数，函数的名称必须和
类名称一致，它的唯一的一个参数是本类型的一个引用变量，该参数是const类型，不可变的。例如：类X的拷贝构造函数的形式为X(X &x)。
````

当用一个已初始化过了的自定义类类型对象去初始化另一个新构造的对象的时候，拷贝构造函数就会被自动调用。也就是说，当类的对象需要拷贝时，
拷贝构造函数将会被调用。以下情况都会调用拷贝构造函数：
* 一个对象需要通过另外一个对象进行初始化。
* 一个对象以值传递的方式传入函数体 
* 一个对象以值传递的方式从函数返回 

如果在类中没有显式地声明一个拷贝构造函数，那么，编译器将会自动生成一个默认的拷贝构造函数，该构造函数完成对象之间的位拷贝。
位拷贝又称浅拷贝，后面将进行说明。

自定义拷贝构造函数是一种良好的编程风格，它可以阻止编译器形成默认的拷贝构造函数，提高源码效率。

### 四、自定义拷贝构造函数
````
类名：：类名（const 类名 &对象名）
{
   拷贝构造函数的函数体
}


利用下述语句调用拷贝构造函数
CTest t2（t1）；
````

>CTest(CTest &c_t)是自定义的拷贝构造函数，拷贝构造函数的名称必须与类名称一致，函数的形式参数是本类型的一个引用变量,且必须是引用。

>当用一个已经初始化过了的自定义类类型对象去初始化另一个新构造的对象的时候，拷贝构造函数就会被自动调用，如果你没有自定义拷贝构造函数的时候，
系统将会提供给一个默认的拷贝构造函数来完成这个过程。

### 五、深拷贝与浅拷贝

>在某些状况下，类内成员变量需要动态开辟堆内存，如果实行位拷贝，也就是把对象里的值完全复制给另一个对象，如A=B。这时，如果B中有一个
成员变量指针已经申请了内存，那A中的那个成员变量也指向同一块内存。这就出现了问题：当B把内存释放了（如：析构），这时A内的指针就是
野指针了，出现运行错误。

>深拷贝和浅拷贝可以简单理解为：如果一个类拥有资源，当这个类的对象发生复制过程的时候，资源重新分配，这个过程就是深拷贝，反之，
没有重新分配资源，就是浅拷贝。下面举个深拷贝的例子。
> **For example**
````
#include<iostream>
#include<string.h>
using namespace std;

class CTest
{
public:
    CTest(int b,char* cstr)
    {
        a=b;
        str=new char[b];
        strcpy(str,cstr);
    }
    CTest(const CTest &test)
    {
        a=test.a;
        str=new char[a]; //深拷贝
        if(str!=0)
        strcpy(str,test.str);
    }
    void Show()
    {
        cout<<str<<endl;
    }
    ~CTest()
    {
        delete str;
    }
private:
    int a;
    char *str;
};

int main()
{
    CTest A(10,"Hello!");
    CTest B = A;
    B.Show();
    return 0;
}

输出结果：Hello!
````
>深拷贝和浅拷贝的定义可以简单理解成：如果一个类拥有资源(堆，或者是其它系统资源)，当这个类的对象发生复制过程的时候，这个过程就可以叫做深拷贝，
反之对象存在资源，但复制过程并未复制资源的情况视为浅拷贝。

>浅拷贝资源后在释放资源的时候会产生资源归属不清的情况导致程序运行出错。
