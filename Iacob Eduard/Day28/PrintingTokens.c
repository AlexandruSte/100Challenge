//Given a sentence s, print each word of the sentence in a new line.

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {

    char *s, sentence[70][70];
    int i, j, count;
    s = malloc(1024 * sizeof(char));
    scanf("%[^\n]", s);
    s = realloc(s, strlen(s) + 1);
    j = 0; count = 0;
    for(i = 0; i <= strlen(s); i++){
      if(s[i] == ' ' || s[i] == '\0'){
        sentence[count][j] = '\0';
        count++;
        j = 0;
      }
      else{
        sentence[count][j] = s[i];
        j++;
      }
    }
    for(i=0;i < count ;i++)
        printf("%s\n",sentence[i]);
    return 0;
}
