#include<bits/stdc++.h>
using namespace std;
void chuanHoa(string &str){
    int fi = 0;
    int la = 0;
    int length = str.length();
    while(str[fi] == ' '){
        fi++;
    }
    while(str[length - 1 - la] == ' '){
        la++;
    }
    la = length - la - fi;
    str = str.substr(fi, la);

    str = str + " ";
    int lo = 0;
    int hi = str.find("www ", lo);
    cout << hi << endl;
}
int main(){
    string str;
    getline(cin,str);
    chuanHoa(str);
    cout << "." + str + ".";
    return 0;
}
