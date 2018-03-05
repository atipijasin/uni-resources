#include <fstream>
#include <iostream>
#include <vector>
#include <limits.h>
#include <algorithm>    // std::max

using namespace std;

int knapsack(int C, vector<int> &P, vector<int> &V, int N, vector< vector<int> > &D);

int main(int argc, char **argv){

  ifstream input("input.txt");
  ofstream output("output.txt");

  int C;
  int N;
  input >> C;
  input >> N;

  vector<int> P;
  vector<int> V;

  vector< vector<int> > D;
  D.resize(N+1);
  for (int i = 0; i < N+1; i++) {
    D[i].resize(C+1);
    D[i][0] = 0;
  }
  for (int j = 0; j < C+1; j++) {
    D[0][j] = 0;
  }
  P.resize(N);
  V.resize(N);

  for(int i=0; i<N; i++){
    input >> P[i];
    input >> V[i];
  }

  int sol = knapsack(C, P, V, N-1, D);
  cout << sol << endl;
  output << sol;
  return 0;
}

int knapsack(int C, vector<int> &P, vector<int> &V, int N, vector< vector<int> > &D){
  int currentMax = 0;
  for (int i = 1; i <= N; i++) {
    for (int j = 1; j <= C; j++) {
      int nottaken = D[i-1][j];
      int taken = INT_MIN;
      if(j - P[i-1] >= 0){
        taken = V[i-1] + D[i-1][j - P[i-1]];
      }
      D[i][j] = std::max(taken, nottaken);
      currentMax = std::max(currentMax, D[i][j]);
    }
  }
  return currentMax;
}
