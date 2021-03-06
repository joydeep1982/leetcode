/**
 * 
 * https://leetcode.com/problems/word-ladder/
 * 
 */
package com.practice.ds.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		WordLadder obj = new WordLadder();

		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
//		wordList.add("hog");

		int min = obj.ladderLength("hit", "cog", wordList);
		System.out.println(min);
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		Map<String, List<String>> mapper = new HashMap<String, List<String>>();
		
		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
				//System.out.println(newWord);
				List<String> children = mapper.getOrDefault(newWord, new ArrayList<String>());
				children.add(word);
				mapper.put(newWord, children);
			}
		}
		
		Set<String> alreadyProcessed = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		int level = 0;
		
		outer:
		while (!q.isEmpty()) {
			int size = q.size();
			
			level++;
			
			for (int i = 0; i < size; i++) {
				
				String word = q.poll();
				
				if (alreadyProcessed.contains(word)) {
					continue;
				}
				alreadyProcessed.add(word);
				
				for (int x = 0; x < level; x++) {
					System.out.print("-");
				}
				System.out.print("Processing " + word);
				System.out.println();
				
				if (word.equals(endWord)) {
					break outer;
				}
				
				for (int j = 0; j < word.length(); j++) {
					String transformedWord = word.substring(0, j) + "*" + word.substring(j + 1, word.length());
					q.addAll(mapper.getOrDefault(transformedWord, new ArrayList<String>()));
				}
			}
		}
		
		return level;
	}

	/*public int ladderLength1(String beginWord, String endWord, List<String> wordList) {

		return 0;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> visited = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();

		q.add(beginWord);
		int depthCounter = 0;

		while (!q.isEmpty()) {
			depthCounter++;
			System.out.println("      depth incremented");
			int size = q.size();
			for (int x = 0; x < size; x++) {

				String word = q.poll();
				System.out.println("processing word: " + word);
				visited.add(word);

				if (word.equals(endWord)) {
					return depthCounter;
				}

				populateQueue(wordList, visited, q, word);
			}
		}

		return 0;
	}

	private void populateQueue(List<String> wordList, Set<String> visited, Queue<String> q, String word) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++) {
			for (int j = 97; j < 123; j++) {
				String nextWord = word.substring(0, i) + Character.toString((char) j)
						+ word.substring(i + 1, word.length());
				if (visited.contains(nextWord))
					continue;
				if (!wordList.contains(nextWord))
					continue;
				list.add(nextWord);
				q.add(nextWord);
			}
		}
		System.out.println("Added to queue: " + list);
	}*/
}
