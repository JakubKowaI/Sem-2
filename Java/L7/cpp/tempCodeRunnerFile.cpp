Klasa elemenu drzewa
// template<typename Typ>
// class TreeElem{
//     public:
//   Typ elem;
//   TreeElem<Typ>* left;
//   TreeElem<Typ>* right;
//   TreeElem(Typ elem)
//   {
//     this->elem = elem;
//     left = NULL;
//     right = NULL;
//   }
//   string toString() { return elem.toString(); }
// };

// // Klasa do obslugi drzewa. Typ generyczny T musi implementowac Comparable,
// // zeby mozna bylo porownac elementy do wstawienia do drzewa.
// template<typename Typ>
// class Tree{
//     public:
//   TreeElem<Typ>* root;
//   Tree() { root = NULL; }
//   void insert(Typ elem) { root = ins(elem, root); }
//   TreeElem<Typ>* ins(Typ elem, TreeElem<Typ>* w) {
//     if( w==NULL ) return new TreeElem<Typ>(elem);
//     if(elem.type())
//     try{
//     if( elem.compare(w->elem)<0 ) 
//       w->left = ins(elem, w->left);
//     else if( elem.compare(w->elem)>0)
//       w->right = ins(elem, w->right);
//     return w;
//     }catch(string e){
//         cout<<e<<endl;
//     }
//     try{
// if(elem<w->elem)
//     w->left = ins(elem, w->left);
// else if(elem>w->elem)
//     w->right = ins(elem, w->right);
// return w;
//     }catch(string e){
//         cout<<e<<endl;
//     }
//   }
//   bool isElement(Typ elem) { return isElem(elem,root); }
//   bool isElem(Typ elem, TreeElem<Typ>* w) {
//     if( w==NULL ) return false;
//     if( elem.compare(w->elem)==0 ) return true;
//     if( elem.compare(w->elem)<0) 
//       return isElem(elem, w->left);
//     else
//       return isElem(elem, w->right);
//   }
//   string toString() { return toS(root); }
//   string toS(TreeElem<Typ>* w) { 
//     if( w!=NULL )
//       return "("+w->elem+":"+toS(w->left)+":"+toS(w->right)+")";
//     return "()";
//   }
// };
