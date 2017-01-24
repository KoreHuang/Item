//��������ת
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
	for (LinkNum=0,LinkN=head;LinkN;LinkNum++,LinkN=LinkN->next);//��Ԫ�ظ�����ȷ��ѭ������ 10����ѭ��10/3�� 
	for (loop=LinkNum/k;loop;loop--){//��ѭ�� 
		for (i=0,newhead=head;newhead && k-i;i++,newhead=newhead->next){//�ҵ���k+1��Ԫ�أ���Ϊ���η�ת�����һ��Ԫ�صĺ�� 
			if (loop==LinkNum/k && i==k-1)//ÿk����һ��ת��headfix�̶��ڵ�k��Ԫ���ϣ�������ʱ��������ͷ 
				headfix=newhead;
		}
		p=NULL;//������p�Ȳ�����NULL���ж��ǲ��Ƿ�תСѭ���ĵ�һ��Ԫ�� 
		for (i=0;i<k;i++){//ÿk��Ԫ��һ��ת  Сѭ�� 
			if (!p){//��ת��һ��Ԫ����ô���� 
				q=head;
				head=head->next;
				q->next=newhead;
				tail=p=q;//tail!!!
			}
			else{//����ʣ��k-1�� 
				p=q;
				q=head;
				head=head->next;
				q->next=p;
			}
		}
		for (test=newhead,i=1;i<k && test;test=test->next,i++);//test����ʣ�µ���û��k���������testָ���k+1���Һ�� 
		if (test)//����ÿk��Ԫ�صķ�תǰ��һ����Ҳ�Ƿ�ת������һ������tailָ�ţ��Һ�� 
			tail->next=test;
	}
	PrintLink(headfix);
	return 0;
}






