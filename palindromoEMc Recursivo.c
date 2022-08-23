
#include <stdio.h>
#include <string.h>
#include <locale.h>

#define true 1
#define false 0
int isFim(char s[]);
int palindromo(char s[]);
int isFim(char s[]){
	return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}


int palindromo(char s[], int i, int j){
	int resp = true;
	
	if(i < strlen(s)){
		if(s[i] != s[j])
			resp = false;
		else 
			resp = true && palindromo(s, i+1, j-1);	
	}
	return true;
}

int main(){
	setlocale(LC_ALL,"");
	char string[1000];
    fgets(string, 1000, stdin);
	setbuf(stdin, NULL);
	if(str[strlen(string) - 1] == '\n'){
		str[strlen(string) - 1] = '\0';
	}
	while(!(isFim(string))){

		if(palindromo(string,0,strlen(s)-1 )){
			printf("SIM\n");
		}else{
			printf("NAO\n");
		}

		fgets(string, 1000, stdin);
		setbuf(stdin, NULL);
		if(str[strlen(string) - 1] == '\n'){
			str[strlen(string) - 1] = '\0';
		}

	}
	return 0;
}


