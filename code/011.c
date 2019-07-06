int main(int argc, char *argv[]){
    int arr[ARR_SIZE];
    int T;

    //under 10
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 5;
    arr[3] = 10;

    //under 100
    arr[4] = 20;
    arr[5] = 25;
    arr[6] = 50;
    arr[7] = 100;

    //under 1000
    arr[8] = 125;
    arr[9] = 200;
    arr[10] = 250;
    arr[11] = 500;
    arr[12] = 1000;

    //else
    for(int i = 4; i < 10; i++){
        int unit = i-3;
        for(int j = 0; j < 5; j++)
            arr[8 + unit * 5 + j] = arr[8 + (unit - 1) * 5 + j] * 10;
    }

    scanf("%d", &T);
    for(int test_case = 1 ; test_case <= T; test_case++){
        int each_case;
        int index = -1;

        scanf("%d", &each_case);

        for(int i = 0; i < ARR_SIZE; i++){
            if(arr[i] > each_case){
                index = i - 1;
                break;
            }
        }

        if(index == -1)
            index = ARR_SIZE - 1;

        printf("#%d %d\n", test_case, index + 1);
    }
}
