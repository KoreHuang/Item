//美团链表翻转
#include <stdio.h>
#include <stdlib.h>
#define N 10

typedef struct note {
	int data;
	struct note * next;
}Elem;

Elem *CreatLink(int a[]){
	int i;
	Elem *p,*tail,*head=NULL; 
	for (i=0;i<N;i++){
		p= (Elem *) malloc (sizeof(Elem));
		p->data =a[i];
		p->next =NULL;
		if (!head)
			head=tail=p;
		else 
			tail=tail->next=p;
	}
	return head;
}

void PrintLink(Elem *head){
	Elem *p;
	for (p=head;p;p=p->next)
		printf("%5d",p->data);	
} 

int main(void){
	int a[10]={1,2,3,4,5,6,7,8,9,10};
	int k,loop,LinkNum,i;
	Elem *newhead,*headfix,*p,*q,*tail,*test,*head,*LinkN;
	head=CreatLink(a);
	scanf ("%d",&k);
	for (LinkNum=0,LinkN=head;LinkN;LinkNum++,LinkN=LinkN->next);//数元素个数，确定循环次数 10个就循环10/3次 
	for (loop=LinkNum/k;loop;loop--){//大循环 
		for (i=0,newhead=head;newhead && k-i;i++,newhead=newhead->next){//找到第k+1个元素，作为本次翻转的最后一个元素的后继 
			if (loop==LinkNum/k && i==k-1)//每k个数一翻转，headfix固定在第k个元素上，最后输出时候他就是头 
				headfix=newhead;
		}
		p=NULL;//下面用p等不等于NULL来判断是不是翻转小循环的第一个元素 
		for (i=0;i<k;i++){//每k个元素一翻转  小循环 
			if (!p){//翻转第一个元素这么处理 
				q=head;
				head=head->next;
				q->next=newhead;
				tail=p=q;//tail!!!
			}
			else{//处理剩下k-1个 
				p=q;
				q=head;
				head=head->next;
				q->next=p;
			}
		}
		for (test=newhead,i=1;i<k && test;test=test->next,i++);//test测试剩下的有没有k个，如果有test指向第k+1个挂后继 
		if (test)//上面每k个元素的翻转前第一个（也是翻转后的最后一个）有tail指着，挂后继 
			tail->next=test;
	}
	PrintLink(headfix);
	return 0;
}






