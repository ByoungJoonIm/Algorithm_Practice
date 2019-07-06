#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    int tc;
    int tc_each;
    int *mem;

    scanf("%d", &tc);

    for(int i = 0; i < tc; i++){
        int max;
        int min;

        scanf("%d", &tc_each);
        mem = (int*)malloc(sizeof(int) * tc_each);
        for(int j = 0; j < tc_each; j++){           //get each numbers
            scanf("%d", &mem[j]);
        }

        max = mem[0];
        min = mem[0];

        for(int j = 1; j < tc_each; j++){
            if(mem[j] > max)
                max = mem[j];
            if(mem[j] < min)
                min = mem[j];
        }

        printf("#%d %d\n", i+1, max * min);

        free(mem);
    }
}
