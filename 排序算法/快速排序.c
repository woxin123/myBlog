#include <stdio.h>

int Partition(int a[], int low, int high) {
    int pivotKey;
    int temp;
    pivotKey = a[low];
    while (low < high) {
        while (low < high && a[high] >= pivotKey)
            high--;
        temp = a[low];
        a[low] = a[high];
        a[high] = temp;
        while (low < high && a[low] <= pivotKey)
            low++;
        temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }
    return low;
}

void QSort(int a[], int low, int high) {
    int pivot;
    if (low < high) {
        // 将a数组一分为二，并算出枢轴值pivot
        pivot = Partition(a, low, high);
        // 对低于枢轴值的表排序
        QSort(a, low, pivot - 1);
        // 对高于枢轴值的表排序
        QSort(a, pivot + 1, high);
    }
}

void QuickSort(int a[], int n) {
    QSort(a, 0, n - 1);
}
int main(void)
{
    int a[] = {4,3,2,1};
    QuickSort(a, 4);
    for (int i = 0; i < 4; i++) {
        printf("%d ", a[i]);
    }
}
