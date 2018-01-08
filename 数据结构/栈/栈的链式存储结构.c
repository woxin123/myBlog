#include <stdio.h>
#include <stdlib.h>
typedef int dataType;
typedef struct Node {
    dataType data;
    struct Node * next;
}* LinkStack, *PtrToNode;
LinkStack CreateStack();
dataType GetTop(LinkStack S);
int Push(dataType X, LinkStack S);
void Pop(LinkStack S);
int IsEmpty(LinkStack S);
void MakeEmpty(LinkStack S);
int main(void)
{
    LinkStack S = CreateStack();
    for (int i = 0; i < 5; i++) {
        Push(i, S);
    }
    int e = GetTop(S);
    printf("%d\n", e);
    Pop(S);
    e = GetTop(S);
    printf("%d\n", e);
    MakeEmpty(S);
    for (int i = 0; i < 5; i++) {
        Push(i, S);
    }
    for (int i = 0; i < 5; i++) {
        e = GetTop(S);
        Pop(S);
        printf("%d\n", e);
    }
    if (IsEmpty(S)) {
        printf("ջΪ�գ�\n");
    }
    return 0;    
}
LinkStack CreateStack() {
    LinkStack S;
    S = (LinkStack) malloc(sizeof(struct Node));
    if (S == NULL) {
        printf("�ռ����ʧ�ܣ�\n");
        return NULL;
    }
    S->next = NULL;
    MakeEmpty(S);   // ����һ����ջ�ƿյĲ�������֤������ջ�ǿյ�
    return S;
}
void MakeEmpty(LinkStack S) {
    if (S == NULL) 
        printf("�����ȴ���һ����Ȼ������ƿ�ջ");
    else
        while (!IsEmpty(S))
            Pop(S);
}
int Push(dataType X, LinkStack S) {
    PtrToNode temp;
    temp = (PtrToNode) malloc(sizeof(struct Node));
    if (temp == NULL) {
        printf("�ռ����ʧ�ܣ�\n");
        return 0;
    } else {
        temp->data = X;
        temp->next = S->next;
        S->next = temp;
    }
    return 1;
}

dataType GetTop(LinkStack S) {
    if (!IsEmpty(S)) {
        return S->next->data;
    }
    printf("��ջ��\n");
    return 0;
}

void Pop(LinkStack S) {
    PtrToNode p;
    if (IsEmpty(S)) {
        printf("��ջ����\n");
    } else {
        p = S->next;
        S->next = S->next->next;
        free(p);
    }
}

int IsEmpty(LinkStack S) {
    if (S->next == NULL)
        return 1;
    else
        return 0;
}

