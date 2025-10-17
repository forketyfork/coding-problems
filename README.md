# Coding Problems

[![Build status](https://github.com/forketyfork/coding-problems/actions/workflows/build.yml/badge.svg)](https://github.com/forketyfork/coding-problems/actions/workflows/build.yml)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/language-Java-orange.svg)](https://www.oracle.com/java/)

A comprehensive collection of well-documented solutions to coding problems from [LeetCode](https://leetcode.com/), [HackerRank](https://www.hackerrank.com/), [Daily Coding Problem](https://www.dailycodingproblem.com/), and other sources.

## Features

- **60+ Problem Solutions**: Carefully implemented solutions covering arrays, strings, linked lists, trees, dynamic programming, graphs, and more
- **Comprehensive Testing**: 350+ unit tests with extensive edge case coverage
- **Detailed Documentation**: Every class and method includes Javadoc with time/space complexity analysis
- **Modern Java**: Uses JDK 17 with records, var, and modern language features
- **CI/CD Pipeline**: Automated builds and tests via GitHub Actions

## Prerequisites

- **JDK 17** or higher
- **Maven 3.8+** for building and testing

## Building and Testing

```bash
# Clone the repository
git clone https://github.com/forketyfork/coding-problems.git
cd coding-problems

# Run all tests
mvn test

# Compile and package
mvn clean package

# Run a specific test
mvn test -Dtest=TwoSumTest
```

## Project Structure

```
src/
├── main/java/com/forketyfork/codingproblems/
│   ├── structures/          # Common data structures (ListNode, TreeNode, etc.)
│   └── *.java              # Problem solutions
└── test/java/com/forketyfork/codingproblems/
    └── *Test.java          # Unit tests with extensive coverage
```

## Problem Categories

### Arrays & Strings
- Two Sum, Three Sum
- Trapping Rain Water
- String Compression
- Group Anagrams
- Valid Palindrome
- Diagonal Traverse
- Plus One
- Pascal's Triangle

### Dynamic Programming
- Jump Game, Jump Game II
- Fibonacci (Constant Space)
- Tribonacci
- Largest Sum of Non-Adjacent Numbers
- Egyptian Fractions
- Number of Ways to Reorder Array

### Linked Lists
- Copy List with Random Pointer
- Merge Sorted Array
- Reorder List
- Rotate Linked List
- Remove Duplicates from Sorted List

### Trees & Graphs
- Same Tree
- Maximum Depth of Binary Tree
- Merge Two Binary Trees
- Most Frequent Subtree Sum
- Is Graph Bipartite
- Shortest Path in Binary Matrix
- Shortest Path with Obstacles Elimination

### Data Structures
- Trie (Prefix Tree)
- LRU Cache
- Custom implementations with optimized operations

### Bit Manipulation
- Is Power of Two
- Single Element in Sorted Array
- Divide Two Integers
- Three Equal Parts

### String Algorithms
- Substring with Concatenation of All Words
- Strange Printer
- Word Break
- Count and Say
- URLify
- One Away

### Hard Problems
- String Compression II
- Construct Target Array with Multiple Sums
- Problem 2 (Product of Array Except Self)
- Problem 4 (Finding XOR Linked List)
- Problem 8 (Unival Trees)
- Problem 339 (Nested List Weight Sum)

## Code Quality

- **Comprehensive Javadoc**: Every public class and method includes detailed documentation
- **Complexity Analysis**: Time and space complexity documented for all algorithms
- **Inline Comments**: Complex logic sections include explanatory comments
- **Test Coverage**: Extensive unit tests covering edge cases, boundary conditions, and error paths
- **Modern Practices**: Clean code principles, descriptive naming, and proper error handling

## Testing Approach

Each problem solution includes:
- **Basic functionality tests**: Verify the core algorithm works correctly
- **Edge cases**: Empty inputs, single elements, null values
- **Boundary conditions**: MIN_VALUE, MAX_VALUE, overflow scenarios
- **Complex scenarios**: Large inputs, nested structures, worst-case patterns
- **Parameterized tests**: Using JUnit 5's `@ParameterizedTest` for comprehensive coverage

## Example Problems

### Two Sum (LeetCode #1)
Find two numbers in an array that add up to a target sum.
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Approach**: Hash map for constant-time lookups

### LRU Cache (LeetCode #146)
Implement a Least Recently Used cache with O(1) get and put operations.
- **Time Complexity**: O(1) for all operations
- **Space Complexity**: O(capacity)
- **Approach**: HashMap + Doubly Linked List

### Trapping Rain Water (LeetCode #42)
Calculate how much water can be trapped after raining.
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Approach**: Two-pointer technique

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

Problems sourced from:
- [LeetCode](https://leetcode.com/)
- [HackerRank](https://www.hackerrank.com/)
- [Daily Coding Problem](https://www.dailycodingproblem.com/)
- Cracking the Coding Interview by Gayle Laakmann McDowell

## Author

Maintained by [@forketyfork](https://github.com/forketyfork)