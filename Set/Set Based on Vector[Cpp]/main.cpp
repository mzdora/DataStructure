#include <iostream>
#include "set.h"
using namespace std;

int main()
{
    set a;
    a.add(5);
    a.add(6);
    a.add(7);
    cout << a.isEmpty() <<endl;
    cout << a.size()<<endl;
    a.add(7);
    cout << a.size()<<endl;
    a.remove(7);
    cout << a.size()<<endl;
    cout << a <<endl;
    a.add(7);
    a.add(6);
    cout << a<<endl;
    return 0;
}
