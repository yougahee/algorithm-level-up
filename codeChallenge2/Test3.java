package codeChallenge2;

public class Test3 {
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}};
        System.out.println(solution(4, edges));
    }

    public static int solution(int n, int[][] edges) {
        int answer = 0;

        int[][] tree = new int[250001][250001];
        tree[250000][25000] = 2;


        return answer;
    }
}


/* == 풀이 ==
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
#define NM 250005
#define INF 0x7fffffff
#define FOR(i,n,m) for (int i=(n);i<=(m);i++)

int n;
int answer = 0;
int dy[NM], visit[NM];
vector<int> edges[NM];
void dfs1(int x) {
	visit[x] = 1;
	for (int y : edges[x]) {
		if (visit[y]) continue;
		dy[y] = dy[x] + 1;
		dfs1(y);
	}
}
int solution(int _n, vector<vector<int>> _edges) {
	n = _n;
	for (auto& e : _edges) {
		edges[e[0]].push_back(e[1]);
		edges[e[1]].push_back(e[0]);
	}
	dfs1(1);
	FOR(i, 1, n) visit[i] = 0;
	int x = 1;
	FOR(i, 2, n) {
		if (dy[x] < dy[i]) x = i;
	}
	FOR(i, 1, n) dy[i] = 0;
	dfs1(x);
	int y = 1;
	FOR(i, 1, n) {
		if (dy[y] < dy[i]) y = i;
	}
	int cnt = 0;
	FOR(i, 1, n) {
		if (dy[i] == dy[y]) cnt++;
	}
	if (cnt >= 2) return dy[y];

	x = y;
	FOR(i, 1, n) visit[i] = 0;
	FOR(i, 1, n) dy[i] = 0;
    dfs1(x);
	y = 1;
	FOR(i, 1, n) {
		if (dy[y] < dy[i]) y = i;
	}
	cnt = 0;
	FOR(i, 1, n) {
		if (dy[i] == dy[y]) cnt++;
	}
	if (cnt >= 2) return dy[y];

	x = y;
	if (cnt == 1) return dy[y] - 1;
	return dy[y];
}


*/