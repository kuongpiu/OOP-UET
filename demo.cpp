#include<bits/stdc++.h>
using namespace std;
struct Birth{
    int day,month,year;
    Birth(int day, int month, int year){
        this->day = day;
        this->month = month;
        this->year = year;
    }
};
enum Sex{
    MALE,
    FEMALE,
};
struct Student{
    string iD,name;
    Sex sex;
    Birth birth;
    Sinhvien(const string &iD,const string &name, Sex sex, Birth birth){
        this->iD = iD;
        this->name = name;
        this->sex = sex;
        this->birth = birth;
    }
};

struct Node{
    Student data;
    Node* pre;
    Node* next;

};

int main(){
    Sex s = MALE;
    Birth birth(31,10,2000);
    Student st("18020248", "cuong", s, birth);
    return 0;
}
