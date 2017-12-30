#include <stdio.h>

void ShellSort(int a[], int n) {
    int i, j, Increment;
    int temp;
    for (Increment = n / 3; Increment > 0; Increment = Increment / 3) {
        for (i = Increment; i < n; i++) {
            temp = a[i];
            for (j = i; j >= Increment; j -= Increment)
                if (temp < a[j - Increment])
                    a[j] = a[j - Increment];
                else
                    break;
            a[j] = temp;
        }
    }
}

int main(void)
{
    int a[10] = {10, 8, 4, 12, 43, 32, 90, 19, 56, 65};
    ShellSort(a, 10);
    for (int i = 0; i < 10; i++)
        printf("%d ", a[i]);
}