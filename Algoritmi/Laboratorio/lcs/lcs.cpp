#include <algorithm> // std::max
#include <fstream>
#include <iostream>
#include <limits.h>
#include <vector>

using namespace std;

int main(int argc, char **argv) {

  ifstream input("input.txt");
  ofstream output("output.txt");
  string a;
	string b;
  input >> a;
	input >> b;
	cout << a << b;


  return 0;
}