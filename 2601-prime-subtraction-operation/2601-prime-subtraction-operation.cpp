class Solution {
public:
vector<int> getPrimes() {
    vector<int> ps = {2}, sieve(1001);
    for (int i = 3; i < 32; ++i)
        if (!sieve[i])
            for (int j = i * i; j <= 1000; j += i)
                sieve[j] = true;
    for (int i = 3; i <= 1000; i += 2)
        if (!sieve[i])
            ps.push_back(i);
    return ps;
}
bool primeSubOperation(vector<int>& nums) {
    auto ps = getPrimes();
    for (int i = 0; i < nums.size(); ++i) {
        auto it = lower_bound(begin(ps), end(ps), nums[i] - (i ? nums[i - 1] : 0));
        if (it != begin(ps))
            nums[i] -= *prev(it);
        if (i && nums[i] <= nums[i - 1])
            return false;
    }
    return true;
}
};