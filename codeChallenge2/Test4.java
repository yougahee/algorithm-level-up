package codeChallenge2;

public class Test4 {
    public static void main(String[] args) {

    }

    public long solution(String s) {
        long answer = -1;
        return answer;
    }
}

/*

#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
#define NM 300005
#define INF 0x7fffffff
#define FOR(i,n,m) for (int i=(n);i<=(m);i++)

long long dy[26], cnt[26], idx[30], alpha[NM], l[NM], r[NM];
long long tree[26][NM * 2][2], B;
void Update(int c, int idx, int v) {
	idx += B;
	tree[c][idx][0]++;
	tree[c][idx][1]+=v;
	idx /= 2;
	while (idx) {
		tree[c][idx][0] = tree[c][idx * 2][0] + tree[c][idx * 2 + 1][0];
		tree[c][idx][1] = tree[c][idx * 2][1] + tree[c][idx * 2 + 1][1];
		idx /= 2;
	}
}
pair<ll,ll> Find(int c, int l, int r) {
	l += B, r += B;
	ll res = 0, res2 = 0;
	while (l <= r) {
		if (l & 1) res += tree[c][l][0], res2 += tree[c][l][1], l++;
		if (!(r & 1)) res += tree[c][r][0], res2 += tree[c][r][1], r--;
		l >>= 1, r >>= 1;
	}
	return { res,res2 };
}
long long solution(string s) {
	long long ans = 0;
	int n = s.length();
	B = n - 1;
	ll same = 0;
	FOR(i, 0, n - 1) {
		ll temp = (ll)i * (i + 1) / 2;
		if (i >= 1 && s[i] == s[i - 1]) {
			same++;
		}
		else if (i>=1){
			FOR(j, 1, same + 1) {
				Update(s[i - 1] - 'a', j, j);
			}
			same = 0;
		}
		temp -= same * (same + 1) / 2;

		auto [leCnt, leSum] = Find(s[i] - 'a', 1, same + 1);
		ll total = tree[s[i] - 'a'][1][0];

		temp -= leSum;

		temp -= (same + 1) * (total - leCnt);

		ans += temp;
	}

	return ans;
}

*/