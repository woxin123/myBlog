#include <stdio.h>
#include <stdlib.h>
#include "bitree.h"

// 前序遍历
void PreOrderTraverse(BiTNode T) {
    if (T == NULL)
        return;
    printf("%c", T->element);
    PreOrderTraverse(T->lChild);
    PreOrderTraverse(T->rChild);
}

// 中序遍历
void InOrderTraverse(BiTree T) {
    if (T == NULL)
        return;
    // 先左子树
    InOrderTraverse(T->lChild);
    // 然后访问
    printf("%c", T->element);
    // 最后右子树
    InOrderTraverse(T->rChild);
}

void PostOrderTraverse(BiTree T) {
    if (T == NULL)
        return;
    // 后序遍历左子树
    PostOrderTraverse(T->lChild);
    // 后序遍历右子树
    PostOrderTraverse(T->rChild);
    // 访问根节点
    printf("%c", T->element);
}