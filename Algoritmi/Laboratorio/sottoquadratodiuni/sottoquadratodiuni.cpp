#include <algorithm> // std::max
#include <fstream>
#include <iostream>
#include <limits.h>
#include <vector>

using namespace std;
int sottoquadrato(vector<vector<int>> &, int, int, int, int);

int main(int argc, char **argv) {

  ifstream input("input.txt");
  int n, m;
  input >> n >> m;
  vector<vector<int>> M(n, vector<int>(m));

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      input >> M[i][j];
    }
  }
  // int sol = sottoquadrato(M, n - 1, m - 1, n, m);
  // cout << sol;
  return 0;
}

// int sottoquadrato(vector<vector<int>> &M, int i, int j, int n, int m) {
//   if (M[i,j]==0){
// 		return 0;
// 	}else{

// 	}

// }