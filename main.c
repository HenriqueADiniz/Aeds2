#include <stdio.h>
#include <stdlib.h>
#include<string.h>
#include <locale.h>

#define true 1
#define false 0



char combinador(char A[100],char B[100])
{
    char combinacao[200];
    int tamanhoA= strlen(A);
    int tamanhoB=strlen(B);
    int tamanho= tamanhoA+tamanhoB;

        for(int i=0; i<tamanho; i++){
                int j=0;
                int k=0;
            if(i%2==0)
            {
                combinacao[i]=A[j];
                j++;
            }
            else if(B[i]!=NULL)
            {
                combinacao[i]=B[k];
                k++;
            }
            else
            {
                combinacao[i]=A[j];
                j++;
            }
            if(A[i]!=NULL){
                combinacao[i]=B[k];
                k++;
            }


        }
    printf("%s",combinacao);
    return combinacao;

}
int main(){
	setlocale(LC_ALL,"");
	char str1[100];
    fgets(str1, 100, stdin);
    char str2[100];
    fgets(str2, 100, stdin);
	setbuf(stdin, NULL);
	if(str1[strlen(str1) - 1] == '\n'){
		str1[strlen(str1) - 1] = '\0';
	}
	int x;
	while (scanf("%d",&x)==1){
	    combinador( str1[100], str2[100]);

		fgets(str1, 100, stdin);
        fgets(str2, 100, stdin);
		setbuf(stdin, NULL);
		if(str1[strlen(str1) - 1] == '\n'){
			str1[strlen(str1) - 1] = '\0';
		}

	}
	return 0;
}


