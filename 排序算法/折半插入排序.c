#include <stdio.h>

void BiInsertSort(int a[], int n) {
    int i, j, temp;
    int low, high, mid;
    for (i = 1; i < n; i++) {
        if (a[i] < a[i - 1]) {
            temp = a[i];    // a[i]是待插关键字
            low = 0;
            high = i - 1;   // 从0到i是一段有序序列，在这段序列中找一个合适的位置插入a[i]
            while (low < high) {
                mid = (low + high) / 2;
                if (a[mid] > temp)  // a[i]在mid之前
                    high = mid - 1;
                else
                    low = mid + 1;  // a[i]在mid之后
            }
            for (j = i - 1; j >= low; j--) 
                a[j + 1] = a[j];        // 记录后移
            a[low] = temp;
        }  
    }
}
int main(void)
{
    int a[7] = {11, 2, 5, 78, 34, 56, 23};
    BiInsertSort(a, 7);
    for (int i = 0; i < 7; i++)
        printf("%d ", a[i]);

    return 0;
}
