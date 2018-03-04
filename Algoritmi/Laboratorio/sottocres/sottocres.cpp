#include <fstream>
#include <iostream>
#include <vector>
#include <limits.h>
#include <algorithm>    // std::max


using namespace std;

int sottocres(int N, vector<int> &D);

int main(int argc, char **argv){

  ifstream input("input.txt");
  ofstream output("output.txt");
  int N;
  input >> N;
  vector<int> D;
  D.resize(N);
  for (int i = 0; i < N; i++) {
    input >> D[i];
  }

  int sol = sottocres(N,D);
  output << sol;
  cout << sol << endl;
  return 0;
}


int sottocres(int N, vector<int> &D){
  if (N=0){
    return D[N];
  } else if (D[N]>=D[N-1]){
    a = D[N] + sottocres(N-1, D);
    b = sottocres(N-1, D);
    return std::max(a,b);
  } else {
    int i = N-1;
    while(i>=0){
      if (D[N] >= D[i]){
        break;
      }
      i--;
    }
    b = D[N] + sottocres
  }
}
