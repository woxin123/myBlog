#include <stdio.h>
int main(void)
{
  int array[3][3] = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
  };
  int i, j;
  printf("%p %p %p\n", array, array[0], &array[0][0]);
  // int * ptr = &array[0][0];
  // for (i = 0; i < 9; i++) {
  //   printf("%d ", *(ptr + i));
  // }
  // printf("\n");
  for (i = 0; i < 3; i++) {
    for (j = 0; j < 3; j++) {
      printf("%d ", *(*(array + i) + j));
    }
    printf("\n");
  }
  return 0;
}
