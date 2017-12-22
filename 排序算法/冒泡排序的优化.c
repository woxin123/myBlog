#include <stdio.h>
void BubbleSort(int a[], int n) {
    int i, j, temp, flag = 1;
    for (i = 0; i < n - 1 && flag; i++) {
        flag = 0;
        for (j = n - 2; j >= i; j--) {
            if (a[j] > a[j + 1]) {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
            flag = 1; 
        }
    }
}
int main(void)
{
    int a[] = {4,1,2,3};
    BubbleSort(a, 4);
    for (int i = 0; i < 4; i++) {
        printf("%d ", a[i]);
    }
}