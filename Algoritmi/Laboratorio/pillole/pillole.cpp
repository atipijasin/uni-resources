#include <algorithm> // std::max
#include <fstream>
#include <iostream>
#include <limits.h>
#include <vector>

using namespace std;

long long int pillole(long long int, long long int, long long int[31][31]);
int main(int argc, char **argv) {

  ifstream input("input.txt");
  ofstream output("output.txt");
  int N;
  input >> N;

  long long int DP[31][31];
  for (int i = 0; i < 31; i++) {
    for (int j = 0; j < 31; j++) {
      DP[i][j] = 0;
    }
  }
  long long int res = pillole(N, 0, DP);
  cout << res;
  output << res;
  return 0;
}
long long int pillole(long long int intere, long long int mezze,
                      long long int DP[31][31]) {
  if (intere == 0) {
    return 1;
  } else if (mezze < 0) {
    return 0;
  } else {
    if (DP[intere][mezze] == 0) {
      DP[intere][mezze] =
          pillole(intere - 1, mezze + 1, DP) + pillole(intere, mezze - 1, DP);
    }
    return DP[intere][mezze];
  }
}
