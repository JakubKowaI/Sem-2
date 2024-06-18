#include <iostream>
#include <typeinfo>
#include <string>
#include <type_traits>
#include <sstream>

template <typename T>
std::string to_string(T val)
{
    std::stringstream stream;
    stream << val;
    return stream.str();
}

using namespace std;

template<typename Typ>
class TreeElem{
    public:
  Typ elem;
  TreeElem<Typ>* left;
  TreeElem<Typ>* right;
  TreeElem(Typ elem)
  {
    this->elem = elem;
    left = NULL;
    right = NULL;
  }
};

template<typename Typ>
class Tree{
    public:
  TreeElem<Typ>* root;
  string test;
  Tree() { 
    root = NULL; 
    }
  void insert(Typ elem) {
    root = ins(elem, root); 
    }
  TreeElem<Typ>* ins(Typ elem, TreeElem<Typ>* w) {
    if( w==NULL ) return new TreeElem<Typ>(elem);
    if(is_same<Typ, string>::value){
    try{
    if( elem.compare(w->elem)<0) 
      w->left = ins(elem, w->left);
    else if( elem.compare(w->elem)>0)
      w->right = ins(elem, w->right);
    return w;
    }catch(string e){
        cout<<e<<endl;
    }
    }else{
    try{
if(elem<w->elem)
    w->left = ins(elem, w->left);
else if(elem>w->elem)
    w->right = ins(elem, w->right);
return w;
    }catch(string e){
        cout<<e<<endl;
    }
    }
  }
  bool isElement(Typ elem) { return isElem(elem,root); }
  bool isElem(Typ elem, TreeElem<Typ>* w) {
    if( w==NULL ) return false;
    if(is_same<Typ, string>::value){
    if( elem.compare(w->elem)==0 ) return true;
    if( elem.compare(w->elem)<0) 
      return isElem(elem, w->left);
    else
      return isElem(elem, w->right);
  }else{
      if(elem==w->elem)
          return true;
      if(elem<w->elem)
          return isElem(elem, w->left);
      else
          return isElem(elem, w->right);
    }
  }
  void delete1(Typ elem) { 
    root = treeDelete(elem, root); 
  }
    TreeElem<Typ>* treeDelete(Typ elem, TreeElem<Typ>* temp) {
      if( temp==NULL ) return NULL;
      if( elem.compare(temp->elem)<0 ) 
        temp->left = treeDelete(elem, temp->left);
      else if( elem.compare(temp->elem)>0)
        temp->right = treeDelete(elem, temp->right);
      else {
        if( temp->left==NULL ) return temp->right;
        if( temp->right==NULL ) return temp->left;
        if(findMin(temp)->right==NULL){
            temp->elem = findMin(temp)->elem;
            temp->left = treeDelete(temp->elem, temp->left);
        }
        else{
            temp->elem = findMin(temp->right)->elem;
            temp->right = treeDelete(temp->elem, temp->right);
        }
      }
      return temp;
    }
    TreeElem<Typ>* findMin(TreeElem<Typ>* temp) {
      if( temp->left==NULL ) return temp;
      return findMin(temp->left);
    }
  string toString() { return toS(root); }
  string toS(TreeElem<Typ>* w) { 
    if( w!=NULL ){
        if(is_same<Typ, string>::value){
            //cout<<"string"<<endl;
            return "("+w->elem+":"+toS(w->left)+":"+toS(w->right)+")";
        }else{
            //cout<<"int"<<endl;
            return "("+to_string(w->elem)+":"+toS(w->left)+":"+toS(w->right)+")";
        }
    }
    return "()";
  }
};

int main() {
    Tree<string> a;
    a.insert("ala");
    a.insert("ola");
    a.insert("ula");
    a.insert("ela");
    a.delete1("ola");

    
    //cout<<a.root->elem<<endl;
    //cout<<a.isElement("ala")<<endl;
    cout<<a.toString()<<endl;
    return 0;
}