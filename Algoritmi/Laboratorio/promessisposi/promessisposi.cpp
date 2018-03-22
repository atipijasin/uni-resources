#include <algorithm> // std::max
#include <fstream>
#include <iostream>
#include <limits.h>
#include <vector>

using namespace std;
int lcs(string &, string &, int, int);


int main(int argc, char **argv) {
	string a = "did you go";
	string b = "dog";
  
  return 0;
}

int lcs(string &a, string &b, int n, int m) {
  vector<vector<int>> DP(n+1, vector<int>(m+1));
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <=m; j++) {
      if (i == 0 || j == 0) {
        DP[i][j] = 0;
      } else if (a[i-1] == b[j-1]) {
        DP[i][j] = 1 + DP[i - 1][j - 1];
      } else {
        DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]);
      }
    }
  }
  return DP[n][m];