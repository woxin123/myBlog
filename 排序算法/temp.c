#include <stdio.h>

void swap(int *a, int *b) {
    *a = *a + *b;
    *b = *a - *b;
    *a = *a - *b;
}
int main(void)
{
    int x = 1, y = 1;
    swap(&x, &y);
    printf("%d %d", x, y);
}
