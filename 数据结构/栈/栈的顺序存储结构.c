#include <stdio.h>
#define MAXSIZE 100
typedef int dataType;
typedef struct {
    dataType data[MAXSIZE];
    int top;
} SeqStack;

void InitStack(SeqStack * S) {
    S->top = -1;
}

// 返回0表示失败，返回1表示成功
int Push(SeqStack * S, dataType e) {
    if (S->top > MAXSIZE - 1) {
        printf("栈已经满了！\n");
        return 0;
    }
    S->top++;
    S->data[S->top] = e;
    return 1;
}

int Pop(SeqStack * S, dataType * e) {
    if (S->top == -1) {
        printf("栈为空！\n");
        return 0;
    }
    *e = S->data[S->top];
    S->top--;               // "删除"栈顶元素
}

dataType GetTop(SeqStack S) {
    if (S.top == -1) {
        printf("栈为空！\n");
        return -1;
    }
    return S.data[S.top];
}

// 栈为空，返回1，否则返回0
int StackEmpty(SeqStack S) {
    if (S.top == -1) 
        return 1;
    else
        return 0;
}

void ClearStack(SeqStack * S) {
    if (S->top != -1)
        S->top = -1;
}

int main(void)
{
    SeqStack S;
    InitStack(&S);
    for (int i = 0; i < 5; i++)
        Push(&S, i);
    printf("%d\n", GetTop(S));
    int e;
    Pop(&S, &e);
    printf("%d %d %d\n", e, GetTop(S), S.top);
}