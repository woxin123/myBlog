# C语言之指针
## 目录
[toc]

在谈论指针之前，我们先看看地址。地址是指存储单元的编号。我们可以通过这个地址找到他所对应的存储单元，然后进行操作。（可以将地址理解为学生的学号，房间的房号。）可以说，地址指向某一变量的存储单元，所以，将地址形象话的称为“指针”。那么指针到底是什么呢？
从根本上来看指针是一个值为内存地址的变量（或者数据对象）
## 1. 指针的简单使用
### 1. 地址运算符&
在计算机中每一个变量都存储在内存中，每一个变量都有其对应的地址空间，我们可以通过取地址符来得到它所对应的地址。这就是一元运算符“&”的作用。假如有一个int型的变量a，我们可以通过`&a`得到他的地址。
看如下程序：
```
#include <stdio.h>
int main(void)
{
	int a = 2;
	printf("%d %p\n", a, &a);
}
```
上面的程序对于大家来说是既熟悉又陌生，这里来说明一下。
%p表示的是输出地址的说明符。
假设a的地址是0061FEAC（PC中地址通常使用16进制形式表示），那么上面的程序的输出结果是：
`2 0061FEAC`
总结：地址运算符&是单目运算符，也称为一元运算符，&运算符可以获取变量的地址。
### 2.指针简介
通过最开始的讲解我们已经了解了指针，也知道了指针是一个值为内存地址的变量。也就是说我们可以将通过&运算符取出的地址赋给一个变量。

下面我们来讲解一下如何申请这样的变量。

声明指针变量时必须声明指针所指向的变量类型，因为不同的变量类型占用不同大小的存储空间。int和float可能占用相同大小的存储空间，但是他们所存储的数字去大不相同。所以我们可以使用指针变量所指向的变量类型 + “\*” + 变量名来声明一个变量。
上面说了很多，可以理解起来不太容易，下面是一些指针变量声明的示例：
```
int * a;		// a是指向int类型变量的指针
char * b;		// b是指向char类型变量的指针
float * c;		// c是指向float类型变量的指针
```
a 是指向int型变量的指针指的是a可以存储一个int型变量的地址。
还有个可能不理解的地方是指针变量。
相信大家有个疑惑，我们说，a是指向int型变量的指针，那么a到底是什么类型呢？a的值是一个地址，在大多数的系统中，地址是由一个无符号的整数表示的。但是不要把指针认为是整数类型。

### 2. 指针的简单使用
前面讲了好多，都是一些理论，现在来讲解一些简单的应用。
#### 1. 间接运算符
现在可以声明一个指针变量，并且可以得到一个变量的地址进行赋值，如下：
```
int a = 2;
int * b = &a;
```
指针b存储了a的地址，假设现在不知道b所储存的地址是哪个变量的，而想得到它的值，该怎么办呢？
现在就该间接运算符\*登场了。间接运算符“\*”，有时也称解引用符。作用是找到某个指针变量上的地址上的之值，然后对这个地址进行取值等操作，所以也被称为取值运算符。
1. \*的作用是取值，得到某个地址变量上的值。
看如下程序：
```
#include <stdio.h>
int main(void)
{
	int a = 2;
	int *b = &a;
	int c = *b;
	printf("c = %d\n", c);
	return 0;
}
```
2. 解引用符的作用不止于此，还可以通过解引用符改变指针变量所指的值。
看下面程序：
```
#include <stdio.h>
int main(void)
{
	int a = 2;
	int *b = &a;
	printf("a = %d\n", a);
	*b = 3;
	printf("a = %d\n", a);
	return 0;
}
```
a的值通过*b的赋值操作被改变了。上面的这种用法在函数中的引用比较多。

这儿我们来说明一下指针变量的类型的意义，通过解引用符可以取得指针变量所指向的值。众所周知，变量在内存中是存储的是二进制，那些指针变量的类型就告诉系统如何去获得这个值。指针变量的类型在读取这块所提供的信息是，指针变量所指向的值占空间的大小和“读”的方式。（就像前面提到过的int和float）
#### 2. 空指针和空类型的指针
C语言设置了一个指针常量“NULL”，空指针不指向任何存储单元。空指针可以赋给任何类型的指针变量。
C语言中有一种void类型，它的意思是空，在函数中，可以用来说明一个函数的返回值为空。在指针中可以说明一个指针可以指向任意的类型，当然，在指向具体的类型时，必须进行强制类型转化。
## 2. 多重指针
之前说过，每一个变量都有其对应的地址空间，我们可以通过取地址符来得到它所对应的地址。那么也可以通过取地址符取得指针变量的地址。看如下程序：
```
#include <stdio.h>
int main(void)
{
	int a = 2;
	int * b = &a;
	printf("a的地址是：%p, 指针变量b的地址是：%p", &a, &b);

	return 0;
}
结果：
a的地址是：0061FEAC, 指针变量b的地址是：0061FEA8
```
a和b的关系入下图所示：
![这里写图片描述](http://img.blog.csdn.net/20171114200050166?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc3RhcmV4cGxvZGU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
注：指针变量在32位系统中占4个字节，在64位系统（更准确的说是32位编译器和64位编译器，因为64位机器上可以运行32位的编译器）中占8个字节。指针变量所占内存的大小可以通过sizeof()函数计算。

既然也可以获得指针变量的值，那么该将这个值赋给谁呢？看下面的一行代码。
`int ** a;`
上面的这行代码说明a是指向int型指针变量的指针。它的作用是改变指针变量的值。看如下程序：
```
#include <stdio.h>
int main(void)
{
	int a = 2;
	int b = 12;
	int * c;
	int ** d;
	c = &a;
	printf("*c = %d\n", *c);
	d = &c;	// 将c的地址赋给d
	*d = &b; // 通过*d改变c的值
	printf("*c = %d\n", *c);
	printf("*d = %p, c = %p, &b = %p\n", *d, c, &b);
	printf("**d = %d, *c = %d, b = %d\n", **d, *c, b);

	return 0;
}
结果：
*c = 2
*c = 12
*d = 0061FEA4, c = 0061FEA4, &b = 0061FEA4
**d = 12, *c = 12, b = 12

```
可以得到如下等式：
```
*d == c
**d == b
```
a是一个指向int型指针变量的指针，可以这样理解`int * (* a)`，'\* a'说名a是一个指针，`int *`说明a所指向的是一个int型指针变量的指针。这种方式在函数中很常用。

## 3. 指针与数组
###1.  指针与一维数组
数组在内存中占用的是一段连续的内存空间，并且数组名是数组首元素的地址。也就是说，如果a是一个数组，那么则会有`a == &a[0]`。
a和&a[0]都可以表示数组首元素的地址，我们可以将其赋给指针变量，然后可以通过这个指针进行操作，看如下程序：
```
#include <stdio.h>
int main(void)
{
	int a[5] = {0, 1, 2, 3, 4}, i;
	int * p = a;
	if (a == &a[0]) {
		for (i = 0; i < 5; i++) {
			printf("a[%d] = %d &a[%d] = %p, p = %p *p = %d\n", i, a[i], i, &a[i], p,*p);
			p = p + 1;
		}
	}
	return 0;
}
```
上面的程序验证了数组名和数组首元素的地址相同。
大家可能感到奇怪的地方是p加一之后为什么会指向下一个数组元素。
在大多数系统中int类型的变量占4个字节。**而指针加1指的是增加一个储存单元**，对于上面的程序而言，p每增加1增加4个字节。并且因为数组在内存中占用的是一段连续的存储空间，所以上面的程序的一个结果如下所示：
```
a[0] = 0 &a[0] = 0061FE94, p = 0061FE94 *p = 0
a[1] = 1 &a[1] = 0061FE98, p = 0061FE98 *p = 1
a[2] = 2 &a[2] = 0061FE9C, p = 0061FE9C *p = 2
a[3] = 3 &a[3] = 0061FEA0, p = 0061FEA0 *p = 3
a[4] = 4 &a[4] = 0061FEA4, p = 0061FEA4 *p = 4
```
第一行中p = 0061FE94，在p+1之后的第二行中p = 0061FE98，刚好相差4。
![这里写图片描述](http://img.blog.csdn.net/20171114200206473?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc3RhcmV4cGxvZGU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
### 2. 指针的危险性
指针在C语言中非常重要，但是也同样非常危险。在C语言中如果一个变量没有被赋值，而去使用时，它会是一个随机的值，例如：
```
#include <stdio.h>
int main(void)
{
  int a;
  printf("%d\n", a);
}
```
每次运行的结果都会不一样。指针变量也不例外。那么如果直接使用这个变量时可能会发生一个无法预知的事情。

注：<font color=red>在全局变量中的系统会将一个没有初始化的变量初始化为0，指针变量初始化为NULL</font>

在比如上面的p指针可以直接加5访问到数组之外的内存，如果将未分配的内存改变了，可能会对程序的运行产生一些影响。
下面来说一下下标运算符[]，对，你看的没错，就是数组的中使用的[]。下面的程序中可以看出下标运算符的实质。
看下面这段程序：
```
#include <stdio.h>
int main(void)
{
    int a[4] = {1,2 ,3 ,4}, i;
    for (i = 0; i < 4; i++) {
        printf("%d %d\n", a[i], *(a + i));
    }

    return 0;
}

结果：
1 1
2 2
3 3
4 4
```
a的首地址相当于a数组第一个元素的地址，显然a[1]就相当于给a加上了1，然后取值。也就是：
```
*(a + 1) == a[1];
```
下面和说一下指针与二维数组。
### 3. 指针与二维数组
其实没有真正的二维数组，二维数组在内存中也是存储在一段连续的存储空间中。
看如下程序。
```
#include <stdio.h>
int main(void)
{
  int array[3][3] = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
  };
  int i;
  int * ptr = &array[0][0];
  for (i = 0; i < 9; i++) {
    printf("%d ", *(ptr + i));
  }
  printf("\n");
  return 0;
}
结果：
1 2 3 4 5 6 7 8 9
```
从上面的这段程序中可以看出二维数组正真的存储方式。
![这里写图片描述](http://img.blog.csdn.net/20171114200306622?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc3RhcmV4cGxvZGU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
接下来的程序使用了指针代替下标运算符进行遍历二维数组，看下面的程序：
```
#include <stdio.h>
int main(void)
{
  int array[3][3] = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
  };
  int i, j;
  for (i = 0; i < 3; i++) {
    for (j = 0; j < 3; j++) {
      printf("%d ", *(*(array + i) + j));
    }
    printf("\n");
  }
  return 0;
}
```
从上面的的程序可以可出，指针和下标运算符之间的关系如下：
```
array[1] = *(array + 1)
array[2][1] = *(*(array + 2) + 1)
```
当然还可以将其推广至三维，四维...
### 4. 数组指针与指针数组
数组指针和指针数组是两个比较容易混淆的概念。下面先来简单解释下他们分别是什么意思。

+ 指针数组：数组指针是一个数组，其中所存储的变量是指针变量。也就是说，数组指针是由指针变量构成的数组。
+ 数组指针：指针数组是一个指针，是指向一个数组的指针。

#### 1. 指针数组
数组的元素可以是各种类型，当然也可以是指针类型，如果每个数组元素的类型都为指针，则称该数组为指针数组。换句话说，指针数组是由指针变量构成的数组。一维指针数组的定义形式如下：
```
类型名 * 数组名[数组长度];
例如：int * a[5];
```
为何是上面的这种定义呢？这是因为**[]的优先级比\*高**，所以首先a是一个大小为5的数组，该数组中元素的类型为`int *`。
一个简单的小例子：
```
#include <stdio.h>
int main(void)
{
  int a[5] = {1, 2, 3, 4, 5};
  int * array[5] = {&a[0], &a[1], &a[2], &a[3], &a[4]};
  int ** ptr = array;
  int i;
  for (i = 0; i < 5; i++) {
    printf("%d ", **ptr);  // *p == &a[i];
    ptr++;
  }
}
```
#### 2. 数组指针
指针变量的类型可以是任何类型，当然也可以数组类型，一个指向数组的指针称为数组指针。它的定义形式如下：
```
类型名 (* 变量名)[数组长度];
```
下面的程序是一个小例子：
```
#include <stdio.h>
int main(void)
{
  int array[3][3] = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
  };
  int i, j;
  int (*ptr)[3] = array;
  ptr = array;
  for (i = 0; i < 3; i++) {
    for (j = 0; j < 3; j++) {
      printf("%d ", *(*(ptr + i) + j));
    }
    printf("\n");
  }
  return 0;
}
```
上面的这段程序对于初学的你来说是难以理解的，但是当你掌握这个的时候说明你已经初步的掌握指针了。
对于这句`int (*ptr)[3] = array;`，可以这样理解：
首先`* ptr`表明ptr是一个指针，然后接下来就是类型了。假设现在有一个`int a[3] = {1, 2, 3}`，其中a的类型是数组，那么可以这样认为a的类型是int[3]。那么指针ptr所指向的指针类型为int[3]。

## 思考题
想想输出为什么是那样？
```
#include <stdio.h>
int main(void)
{
	int a[5];
	int * ptr1 = (int *) (&a + 1);
	int * ptr2 = (int *) ((int)a + 1);
	printf("%x %x\n", ptr1[-1], *ptr2);

	return 0;
}
```
## 结语
关于指针这些肯定是不够的，指针是C语言中的难点，重点，需要平时多敲多练。
