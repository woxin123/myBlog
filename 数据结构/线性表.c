#include <stdio.h>
#define MAXSIZE 100 // �洢�ռ�ķ���
#define TRUE 1
#define FALSE 0
#define ERROR 0
typedef int ElemType;  // ���Ը���ʵ����Ҫ����
typedef struct {
    ElemType data[MAXSIZE];
    int length;
}SqList;

// ��ʼ������
void InitList(SqList *L) {
    L->length = 0;
}

// �������
int ListInsert(SqList *L, int i, ElemType x) {
    int k;
    // ���Ѿ����ˣ�����ERROR
    if (L->length == MAXSIZE) {
        return ERROR;
    }
    // ���i��������Ԫ�����ڵķ�Χ������ERROR
    // length+1��ԭ���ǿ��ܲ����λ���Ǳ�β
    if (i < 1 || i > L->length + 1) {
        return ERROR;
    }
    // ������ڱ�β
    if (i < L->length) {
        for (k = L->length; k >= i; i++) {
            L->data[k+1] = L->data[k];
        }
    }
    L->data[i] = x;
    L->length++;
    return TRUE;
}
// ɾ������
int ListDelete(SqList *L, int i, ElemType *e) {
    int k;
    // ��Ϊ�գ�����ERROR
    if (L->length == 0)
        return ERROR;
    if (i < 1 || i > L->length)
        return ERROR;
    *e = L->data[i];
    // ������i�ĺ��Ԫ����ǰ��һ��λ��
    if (i < L->length) {
        for (k = i; k <= L->length - 1; k++)
            L->data[k] = L->data[k+1];
    }
    L->length--;
    return TRUE;
}

int LocationElem(SqList L,ElemType x) {
    int i;
    for (i = 1; i <= L.length; i++) {
        if (L.data[i] == x)
            return TRUE;
    }
    return FALSE;
}

int main(void) {
    int i;
    SqList L;
    ElemType e;
    InitList(&L);
    for (i = 1; i < 5; i++) {
        ListInsert(&L, i, i);
    }
    // ListInsert(&L, 5, 2);

    // for (i = L.length; i >= 1; i--) {
        // ListDelete(&L, i, &e);
        // printf("��ɾ����Ԫ�أ�%d\n", e);
    // }
    if (LocationElem(L, 4))
        printf("�ҵ���");
    for (i = 1; i <= L.length; i++) {
        printf("%d ", L.data[i]);
    }

    return 0;
}

