#include <iostream>
#include <string>

int main() {
    int num=0;
    try{std::string str = "a";
    int num = std::stoi(str);
    }catch(std::invalid_argument e){
        std::cout << "Invalid argument" << std::endl;
    }
    catch(std::out_of_range e){
        std::cout << "Out of range" << std::endl;
    }
    catch(...){
        std::cout << "Unknown error" << std::endl;
    }
    std::cout << "The converted integer is: " << num << std::endl;
    
    return 0;
}