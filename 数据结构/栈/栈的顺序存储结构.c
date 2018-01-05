#include <stdio.h>
#define MAXSIZE 100
typedef int dataType;
typedef struct {
    datatype data[MAXSIZE];
    int top;
} SeqStack;

void InitStack(SeqStack * S) {
    S->top = -1;
}
