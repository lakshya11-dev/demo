package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class DictionaryService {

    private  Map<String, Integer> dict = new HashMap<>();

    public String addWord(String word) {

        if (dict.containsKey(word)) {
            return "word already found";
        }
        if(word == null || word.trim().isEmpty() || !word.matches("[a-zA-Z]+")){
            return "invalid  word";
        }

        dict.put(word, 1);

        return "added";
    }

    public String search(String word) {

        if (!dict.containsKey(word)) {
            return "not found";
        }

        dict.put(word, dict.get(word) + 1);

        return "found";
    }

    public List<String> suggest(String prefix, int k) {

        List<String> result = new ArrayList<>();

        //getting word that has same preficx

        for (String word : dict.keySet()) {
            if (word.startsWith(prefix)) {
                result.add(word);
            }
        }

        //exchanging words with higher frequency
        for (int i = 0; i < result.size(); i++) {

            for (int j = i+1;j < result.size();j++) {

                String word1=result.get(i);
                String word2=result.get(j);

                int freq1=dict.get(word1);
                int freq2=dict.get(word2);

                if (freq1<freq2) {
                    result.set(i, word2);
                    result.set(j, word1);
                }
                else if (freq1 == freq2 && word1.compareTo(word2) > 0) {
                    result.set(i, word2);
                    result.set(j, word1);
                }
            }
        }
        //returning total number of word asked by user
        if (result.size() > k) {
            return result.subList(0, k);
        }

        return result;
    }
}
