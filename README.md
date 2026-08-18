# Dictionary System

A backend-only Dictionary System built using Java and Spring Boot.

The system stores words along with their search frequency and provides APIs for:

- Adding a new word
- Searching for an exact word
- Prefix-based word suggestions
- Ranking suggestions based on frequency and alphabetical order

---

## 1. Features

The application supports three main operations:

### 1. Add Word

Adds a new word to the dictionary.

- New words are added with frequency `1`.
- If the word already exists, the API returns `already exists`.
- Invalid words containing spaces, numbers, or special characters are rejected.

### 2. Search Word

Checks whether a word exists in the dictionary.

- Returns `FOUND` if the word exists.
- Returns `NOT FOUND` if the word does not exist.
- Every successful search increases the word's frequency by `1`.

### 3. Prefix Suggestions

Returns words starting with a given prefix.

Suggestions are ranked according to:

1. Higher frequency first.
2. If frequencies are equal, alphabetical order is used.
3. At most `k` words are returned.

---

# 2. Data Structures Used

## HashMap

The main data structure used is:

```java
Map<String, Integer> dict = new HashMap<>();
