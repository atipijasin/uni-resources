#include <fstream>
#include <iostream>
#include <vector>
#include <limits.h>
#include <algorithm>    // std::max


using namespace std;

int knapsack(int C, vector<int> &P, vector<int> &V, int i);

int main(int argc, char **argv){

  ifstream input("input.txt");
  ofstream output("output.txt");

  int C;
  int N;
  input >> C;
  input >> N;

  vector<int> P;
  vector<int> V;

  P.resize(N);
  V.resize(N);

  for(int i=0; i<N; i++){
    input >> P[i];
    input >> V[i];
  }

  int sol = knapsack(C, P, V, N-1);
  cout << sol << endl;
  output << sol;
  return 0;
}

int knapsack(int C, vector<int> &P, vector<int> &V, int i){
  if (i > 0){
    int a = V[i] + knapsack(C-P[i], P, V, i-1);
    int b = knapsack(C, P, V, i-1);
    return max(a,b);
  } else if(C<0){
    return INT_MIN;
  } else {
    return 0;
  }
}
