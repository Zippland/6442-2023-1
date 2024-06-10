## Q2 - Data Persistence, Tokenization/Parsing, and Data Structure

In this question, we will read and process **list elements** in markdown files (.md).
For simplicity, we only tackle two specific types of list elements of a strict syntax.
Please pay attention to the syntax as defined in this instruction instead of your own understanding of markdown.

<h2>Introduction - List Elements in Markdown Files</h2>
List elements can be represented as follows.
For unordered lists,
```
- Element A
- Element B
    - Element C
        - Element D
    - Element E
```
For ordered lists,
```
1. Element A
2. Element B
    3. Element C
        4. Element D
    5. Element E
```
Here, the list elements must follow a fixed indentation:
- Elements at the first level (`level`=1) shall have no prefixing spaces, and
- elements at the next level must have exactly 4 spaces.
  (and so on, where elements at `level` l have exactly 4 x (l-1) spaces before them.)

Note: the index for ordered lists must be a number (integer) (e.g., 1. Element A, `1` is the index (attribute `number`) for 'Element A'). <br>
You may disregard the following cases:
- more than one list item in the same line
- items at an invalid indentation level (e.g., with 3 prefix spaces), OR
- items at an invalid indentation level relative to its predecessors/successors, e.g.,
  ```
    1. Element 1
             2. Element Too Far (Will Not Happen)
  ```

However, there could be empty lines or with only whitespaces (not a token), 
and mixed (ordered and unordered), nested list elements, e.g.,
  ```
    - Element 1
    - Element 2
        1. Element 2A
        2. Element 2B
    1. Element 3
   ```

You may also refer to the example markdown files within the `data` directory.


***
<h3> Part 1) Reading Markdown Files </h3>

Complete a function that takes in a file path, reads its content as text, and returns them as a String.

- Complete the `read()` method of the `MDFileReader` class.
- (Note: you may use any `java.io` packages)
  <br>


<h3> Part 2) Tokenizer </h3> 

Complete the `next()` method of the `MDTokenizer` class to perform a tokenization process.
The `next()` method should identify all tokens and their associated values (e.g., for an item without indentation (no prefix spaces), the corresponding value for `level` is `1`).
Each token has a `tokenType`, `content`, `level` and `number` as implemented in the `MDToken` class.
You may also revise the specified line in `hasNext()` if needed.

- The types of tokens (`tokenType`) are `ORDERED_ITEM` and `UNORDERED_ITEM`. You may ignore the `LIST_ROOT` token type as it is only used in Parts 3 and 4 of this question.
- You may find some basic tests in the given `MDTokeniserTest` class.
  <br>


<h3> Part 3) Parser and Data Structure </h3> 

The parser shall take in a tokenizer and process the tokens generated from it.
In particular, you should create a data structure (see `ListElementsTree` class)
that contains all the tokens inserted into it and retains all the parent-children relationships and the order of the list elements.

The skeleton of the `ListElementsTree` class has already been completed.
You must complete the `parse()` method of the `MDParser` class.
- Use the provided methods to create the tree and insert elements into it.
- A root node (token type `LIST_ROOT`) is always given to hold the list of elements.
- The nodes of the trees are not ordered by their values, but each element should be inserted into its parent as indicated by the tokenizer, which should reflect the structure of the md file.
- The tree and also the nodes have been defined in the `ListElementsTree` class.
- No test cases are provided as they would reveal the expected answer. Optionally, you can create your own tests to increase your confidence in your solution.
  <br>

<h3>Illustration - The expected structure of the ListElementsTree to be created</h3>

Taking the following MD files as an example 
(Note: this is a valid list that fulfill the syntax set out in this question),
```
1. I
2. Love
    - Software
    - Construction
3. So
2. Very
    9. Muchhhhhhh
        9. REALLY !!! 
        - ヽ
        - (ˋ▽ˊ)
        - ノ
```

After tokenization, your MDParser should process the tokens and insert them into a ListElementsTree as follows.<br>
<img src="MDTree_Example.png" style="max-width: 500px;" alt="Example illustrating the structure of the tree (find `MDTree_Example.png` in the folder if it is not shown)." >

<br>


<h3> Part 4) Data Structure </h3>

Implement the `preOrderWalk()` method within the `ListElementsTree` class.
Hint: You may add helper methods within the `Node` class if needed. 

Pre-Order traversal at a node entails: visit the current node, then perform pre-order traversal from its leftmost children to the rightmost children.

For instance, the expected order of nodes in the previous example is illustrated as follows:<br>
<img src="MDTree_Example_Walk.png" style="max-width: 500px;" alt="Example illustrating the pre-order traversal of the MDTree (find `MDTree_Example_Walk.png` in the folder if it is not shown)." >

Note that you should exclude the root node of the tree (of `LIST_ROOT` type) from the returned list.
You may find more details in the given `ListElementsTreeTest.java`.

<br><br>
***

#### You are expected to update the following files and push them (and only them) to GitLab:
* `MDFileReader.java`
* `MDTokeniser.java`
* `MDParser.java`
* `ListElementsTree.java`


