#include <stdio.h>

void InsertSort(int a[], int n) {
    int i, j, temp;
    for (i = 1; i < n; i++) {
        if (a[i] < a[i - 1]) {
            temp = a[i];
            for (j = i - 1; a[j] > temp && j >= 0; j--) { 
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }
}

int main(void)
{
    int a[5] = {11, 2, 5, 78, 34};
    InsertSort(a, 5);
    for (int i = 0; i < 5; i++)
        printf("%d ", a[i]);

    return 0;
}