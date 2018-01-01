#include <stdio.h>
#include <math.h>

void ShellInsert(int a[], int dlta, int n) {
    int i, j, temp;
    for (i = dlta; i < n; i++) {
        temp = a[i];
        for (j = i; j >= dlta; j -= dlta)
            if (temp < a[j - dlta])
                a[j] = a[j - dlta];
            else
                break;
        a[j] = temp;
    }
}

int Hibbard(int t, int k) {
    return (int) (pow(2, t - k + 1) - 1);
}
void ShellSort (int a[], int n) {
    int t = log(n + 1) / log(2);    // 排序需要进行log2(n+1)，这里有一个数学计算
    int i;
    for (i = 1; i <= t; i++) 
        ShellInsert(a, Hibbard(t, i), n);
}

int main(void)
{
    int a[] = {55, 43, 23, 56, 32, 67, 90, 11, 2, 34};
    ShellSort(a, 10);
    for (int i = 0; i < 10; i++)
        printf("%d ", a[i]);
    return 0;
}