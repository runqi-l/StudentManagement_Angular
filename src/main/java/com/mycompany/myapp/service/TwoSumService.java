package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.TwoSum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.myapp.repository.TwoSumRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class TwoSumService {
    @Autowired
        private TwoSumRepository twoSumRepository;


    public List<Integer> getNums(String input){
        List<TwoSum> nums1 = twoSumRepository.nums();
        List<Long> nums2 = new ArrayList<>();
        for(int i = 0; i < nums1.size(); i++){
            TwoSum a = nums1.get(i);
            nums2.add(a.getVal());
        }
        int target = Integer.parseInt(input);
        HashMap<Integer, Integer> store = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums2.size(); i++){
            Long m = nums2.get(i);
            int k = (int)(long) m;
            if(store.containsKey(target-k)){
                ans.add(store.get(target-k));
                ans.add(i);
                return ans;
            }
            store.put(k, i);
        }
        return ans;
    }
}
