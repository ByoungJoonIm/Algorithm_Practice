#include <iostream>
 
using namespace std;
 
void run(){
    int tmp;
    int max;
     
    cin >> max;
    for(int i = 1; i < 10; i++){
        cin >> tmp;
        if( tmp > max && tmp >= 0 && tmp <= 10000 )
            max = tmp;
    }
     
    cout << max << endl;
}
 
int main(void){
    int cnt;
     
    cin >> cnt;
    for(int i = 1; i <= cnt; i++){
        cout << "#" << i <<" ";   
        run();
    }
}
