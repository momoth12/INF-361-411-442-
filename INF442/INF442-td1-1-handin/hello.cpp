// Include the library that defines input/output streams and operations on them
#include <iostream>

int main()  {
  char name[256];
  int nbr;
  std::cout <<"How many are you?";
  std::cin >> nbr;
  for(int i=0;i<nbr;i++){
    std::cout<<"What is your name";
    std::cin >> name;
    std::cout << "hello," <<name << std::endl;

  }

  
}