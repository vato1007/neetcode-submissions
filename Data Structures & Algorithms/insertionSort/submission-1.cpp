class Solution {
public:
    vector<vector<Pair>> insertionSort(vector<Pair>& pairs) {
        vector<vector<Pair>> result;

        if (pairs.empty())
            return result;

        result.push_back(pairs);

        for (int i = 1; i < pairs.size(); i++) {
            int j = i;

            while (j > 0 && pairs[j - 1].key > pairs[j].key) {
                swap(pairs[j - 1], pairs[j]);
                j--;
            }

            result.push_back(pairs);
        }

        return result;
    }
};