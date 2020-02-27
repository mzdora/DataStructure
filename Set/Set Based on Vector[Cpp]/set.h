#ifndef SET_H
#define SET_H

#include <vector>
#include <iostream>
#include <stdio.h>

class set
{
    public:
        set();
        int getindex(int index){
            return _vec[index];
        }
        void add(int e){
            bool canadd = true;
            for(int i=0;i<_vec.size();i++){
                if(_vec[i]==e){
                    canadd = false;
                }
            }
            if(canadd)
                _vec.push_back(e);
        }
        bool isEmpty(){
            return _vec.empty();
        }
        int size(){
            return _vec.size();
        }
        void remove(int e){
            int p = 0;
            for(int i=0;i<_vec.size();i++){
                if(_vec[i]==e){
                    p = i;
                    break;
                }
            }
            for(int i=p;i<_vec.size()-1;i++){
                _vec[i] = _vec[i+1];
            }
            _vec.resize(_vec.size()-1);
        }
        friend std::ostream &operator<<(std::ostream &os,set &_v){
            os<<"Set:[";
            for(int i=0;i<_v.size();i++){
                if(i!=_v.size()-1){
                    os<<_v.getindex(i)<<",";
                }else{
                    os<<_v.getindex(i);
                }
            }
            os<<"]";
            return os;
        }
    private:
        std::vector<int> _vec;
};

#endif // SET_H
