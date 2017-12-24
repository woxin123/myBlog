#include <stdio.h>
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
int Partition(int a[], int low, int high) {
    int pivotKey;
    int mid = (low + high) / 2;
    if (a[low] > a[high]) {
        swap(&a[low], &a[high]);
    }
    if (a[mid] > a[high]) {
        swap(&a[mid], &a[high]);
    }
    if (a[mid] > a[low]) {
        swap(&a[mid], &a[low]);
    }
    // 此时的a[low]已经是三个值中的中间值了。
    pivotKey = a[low];
    while (low < high) {
        while (low < high && a[high] >= pivotKey)
            high--;
        a[low] = a[high];
        while (low < high && a[low] <= pivotKey)
            low++;
        a[high] = a[low];
    }
    a[low] = pivotKey;
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
    int a[] = {34, 56, 12, 89, 67, 32, 12, 45, 89};
    QuickSort(a, 4);
    for (int i = 0; i < 9; i++) {
        printf("%d ", a[i]);
    }
}
