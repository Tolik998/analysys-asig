# Sorting Algorithms Project

## Overview

This project implements four sorting and selection algorithms:
1. **MergeSort with Insertion Sort for small arrays**
2. **QuickSort**
3. **Deterministic Select (Median-of-Medians)**
4. **Closest Pair of Points**

Each algorithm is implemented in Java and tested on sample data to demonstrate its functionality, performance, and correctness.

---

## Architecture Notes

- **MergeSort**: Uses a reusable buffer for merging. Recursion depth is \(O(\log n)\). For arrays of size 8 or less, **Insertion Sort** is used.
- **QuickSort**: Uses a randomized pivot. Recursion occurs only on the smaller partition, keeping recursion depth at \(O(\log n)\).
- **Deterministic Select**: Recurses only into the partition containing the k-th element. Uses the Median-of-Medians method to find the pivot.
- **Closest Pair of Points**: Recursively divides points by x-coordinate, merges them, and uses brute force for small arrays.

---

## Recurrence Analysis

### 1. **MergeSort**
- **Recurrence**: T(n) = 2T(n/2) + O(n)
- **Method**: Master Theorem (Case 2)
- **Result**: \( \T(n \log n) \)

### 2. **QuickSort**
- **Recurrence**: T(n) = T(n/2) + O(n) (average case)
- **Method**: Master Theorem / Akra-Bazzi intuition
- **Result**: \( \T(n \log n) \) average, \(O(n^2)\) worst-case

### 3. **Deterministic Select**
- **Recurrence**: T(n) = T(n/5) + T(4n/5) + O(n)
- **Method**: Akra-Bazzi intuition
- **Result**: \( \T(n) \)

### 4. **Closest Pair of Points**
- **Recurrence**: T(n) = 2T(n/2) + O(n)
- **Method**: Master Theorem
- **Result**: \( \T(n \log n) \)

---

## Plots and Discussion

### **Time vs n**
- MergeSort and QuickSort both show \(O(n \log n)\) growth. 
- Deterministic Select grows linearly, while Closest Pair grows at \(O(n \log n)\).

### **Depth vs n**
- QuickSort and MergeSort recursion depths are \(O(\log n)\), whereas Deterministic Select and Closest Pair grow linearly with the input size.

### **Constant-factor effects**
- **Cache locality**: Improves MergeSort when using a contiguous buffer.
- **Garbage collection**: Slightly affects Deterministic Select and Closest Pair due to temporary arrays.

---

## Summary

- **Alignment**: The actual results align with theoretical expectations for all algorithms.
- **Mismatch**: Minor differences due to memory allocation, cache, and garbage collection overhead.
- **Conclusion**: Recursion depth and time complexity are as expected, with optimizations (like Insertion Sort for small arrays and randomized pivots) improving practical performance.

---
