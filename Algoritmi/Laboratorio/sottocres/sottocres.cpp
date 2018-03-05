#include <fstream>
#include <iostream>
#include <vector>
#include <limits.h>
#include <algorithm>    // std::max


using namespace std;

int main(int argc, char **argv){

  ifstream input("input.txt");
  ofstream output("output.txt");
  int N;
  input >> N;
  vector<int> D;
  vector<int> D2;

  D.resize(N);
  D2.resize(N);
  int tmp;

  for (int i = 0; i < N; i++) {
    input >> tmp;
    D[i]=D2[i]=tmp;
  }

  int sol = INT_MIN;
  for(int i=1; i<N; i++){
    for (int j=0; j<i; j++){
      if((D[i] > D[j]) && (D2[j] + D[i] > D2[i])){
        D2[i]=D2[j]+D[i];
        if (sol < D2[i]){
          sol = D2[i];
        }
      }
    }
  }
  output << sol;
  return 0;
}

