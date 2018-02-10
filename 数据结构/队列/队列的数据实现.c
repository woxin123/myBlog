#include <stdio.h>
#define FALSE 0
#define TRUE 1
#define MAX_SIZE 100
typedef char ElementType; 
typedef struct {
    ElementType array[MAX_SIZE];
    int front;
    int rear;
} Queue;

// 初始化队列，也就是将队列制空
int initQueue(Queue * q) {
    q->front = q->rear = MAX_SIZE - 1;
}
// 入队
int InQueue(Queue * q, ElementType element) {
    if ((q->rear + 1) % MAX_SIZE == q->front) {
        printf("队列已经满了！！");
        return FALSE;
    } else {
        q->rear = (q->rear + 1) % MAX_SIZE;
        q->array[q->rear] = element;
        return TRUE;
    }
}

// 出队
int OutQueue(Queue * q, ElementType * element) {
    if (q->front == q->rear) {
        printf("队列为空！！");
        return FALSE;
    } else {
        q->front = (q->front + 1) % MAX_SIZE;
        *element = q->array[q->front];
        return TRUE;
    }
}
// 判断队空
int EmptyQueue(Queue q) {
    if (q.front == q.rear) 
        return TRUE;
    else
        return FALSE;
}

int main(void) {
    Queue q;
    initQueue(&q);
    char ch;
    InQueue(&q, 'a');
    InQueue(&q, 'b');
    OutQueue(&q, &ch);
    printf("%c", ch);
}

