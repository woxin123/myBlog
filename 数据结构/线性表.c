#include <stdio.h>
#define MAXSIZE 100 // 存储空间的分配
#define TRUE 1
#define FALSE 0
#define ERROR 0
typedef int ElemType;  // 可以根据实际需要定义
typedef struct {
    ElemType data[MAXSIZE];
    int length;
}SqList;

// 初始化操作
void InitList(SqList *L) {
    L->length = 0;
}

// 插入操作
int ListInsert(SqList *L, int i, ElemType x) {
    int k;
    // 表已经满了，返回ERROR
    if (L->length == MAXSIZE) {
        return ERROR;
    }
    // 如果i不在数据元素所在的范围，返回ERROR
    // length+1的原因是可能插入的位置是表尾
    if (i < 1 || i > L->length + 1) {
        return ERROR;
    }
    // 如果不在表尾
    if (i < L->length) {
        for (k = L->length; k >= i; i++) {
            L->data[k+1] = L->data[k];
        }
    }
    L->data[i] = x;
    L->length++;
    return TRUE;
}
// 删除操作
int ListDelete(SqList *L, int i, ElemType *e) {
    int k;
    // 表为空，返回ERROR
    if (L->length == 0)
        return ERROR;
    if (i < 1 || i > L->length)
        return ERROR;
    *e = L->data[i];
    // 将表中i的后继元素向前移一个位置
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
        // printf("被删除的元素：%d\n", e);
    // }
    if (LocationElem(L, 4))
        printf("找到了");
    for (i = 1; i <= L.length; i++) {
        printf("%d ", L.data[i]);
    }

    return 0;
}

