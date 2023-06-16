package com.sortspectrum17.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SortService {


    public List<List<Integer>> bubbleSort(List<Integer> data) {
        int n = data.size();
        List<List<Integer>> steps = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    int temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                    steps.add(new ArrayList<>(data));
                }
            }
        }
        return steps;
    }
    
    public List<List<Integer>> selectionSort(List<Integer> data) {
        List<List<Integer>> steps = new ArrayList<>();
        int n = data.size();

        for (int i = 0; i < n-1 ; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                steps.add(List.of(i, j, minIndex, 0)); // Add step for comparison
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = data.get(minIndex);
                data.set(minIndex, data.get(i));
                data.set(i, temp);
            steps.add(List.of(i, minIndex, minIndex, 1)); // Add step for swapping
            }
        }

        return steps;
    }
    
        public List<List<Integer>> insertionSort(List<Integer> data) {
            List<List<Integer>> steps = new ArrayList<>();
            for (int i = 1; i < data.size(); i++) {
                int key = data.get(i);
                int j = i - 1;
                boolean hasChanged = false;
                while (j >= 0 && data.get(j) > key) {
                    data.set(j + 1, data.get(j));
                    j = j - 1;
                    hasChanged = true;
                }
                data.set(j + 1, key);
                if (hasChanged) {
                    List<Integer> step = new ArrayList<>(Arrays.asList(i, j + 1, key));
                    step.addAll(data);
                    steps.add(step);
                }
            }
            return steps;
        }
    }



