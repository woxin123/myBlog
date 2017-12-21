#include <stdio.h>
void BubbleSort(int a[], int n) {
    int i, j, temp;
    for (i = 0; i < n - 1; i++) {
        for (j = n - 2; j >= i; j--) {
            if (a[j] > a[j + 1]) {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}
int main(void)
{
    int i;
    int a[5] = {5, 4, 3, 2, 1};
    BubbleSort(a, 5);
    for (i = 0; i < 5; i++) {
        printf("%d ", a[i]);
    }

    return 0;
}