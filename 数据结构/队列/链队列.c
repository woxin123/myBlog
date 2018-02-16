#include <stdio.h>
#include <stdlib.h>
typedef int ElementType;
typedef struct node {
    ElementType element;
    struct node * next;
} QNode;
typedef struct {
    QNode * front;
    QNode * rear;
} LinkedQueue;

// 创建一个带头结点空队列
LinkedQueue * initQueue() {
    LinkedQueue *q;
    QNode * p;
    q = (LinkedQueue *) malloc(sizeof(LinkedQueue));    // 申请一个链队列的指针
    p = (QNode *) malloc(sizeof(QNode));    // 申请链队列的头指针
    p->next = NULL;
    q->front = q->rear = p;     // 让头尾都指向头结点
    return q;
}

// 入队
void inLinkedQueue(LinkedQueue * q, ElementType x) {
    QNode * p;      // 申请一个新的节点
    p = (QNode *) malloc(sizeof(QNode));
    p->element = x;
    p->next = NULL;
    q->rear->next = p;
    q->rear = p;
}
// 判断对空
int isEmpty(LinkedQueue * q) {
    if (q->front == q->rear)
        return 1;
    else
        return 0;
}
// 出队
int outLinkedQueue(LinkedQueue * q, ElementType * x) {
    QNode * p;
    if (isEmpty(q)) {
        printf("队列为空");
        return 0;
    } else {
        p = q->front->next;
        q->front->next = p->next;
        *x = p->element;
        free(p);
        // 当队列中只有一个元素时，修改队尾指针
        if (q->front->next == NULL)
            q->rear = q->front;
        return 1;
    }
}

int main(void) {
    LinkedQueue * q = initQueue();
    if (isEmpty(q)) {
        printf("队列为空！！");
    }
    inLinkedQueue(q, 555);
    inLinkedQueue(q, 666);
    int a, b;
    outLinkedQueue(q, &a);
    outLinkedQueue(q, &b);
    printf("%d %d\n", a, b);
    if (isEmpty(q)) {
        printf("队列为空！！");
    }
}