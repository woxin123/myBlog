#include <stdio.h>

typedef char ElementType;
typedef struct BiTNode {
    ElementType element;
    struct BiTNode * lChild;    // 左孩子
    struct BiTNode * rChild;    // 有孩子
} BiTNode, *BiTree;

// 二叉树的前序遍历
void PreOrderTraverse(BiTNode T);
// 二叉树的中序遍历
void InOrderTraverse(BiTree T);
// 二叉树的后序遍历
void PostOrderTraverse(BiTree T);