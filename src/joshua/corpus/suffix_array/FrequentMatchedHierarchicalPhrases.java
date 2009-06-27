/* This file is part of the Joshua Machine Translation System.
 * 
 * Joshua is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 * MA 02111-1307 USA
 */
package joshua.corpus.suffix_array;

import joshua.corpus.Corpus;
import joshua.corpus.MatchedHierarchicalPhrases;
import joshua.prefix_tree.PrefixTree;

/**
 *
 *
 * @author Lane Schwartz
 */
public class FrequentMatchedHierarchicalPhrases extends
		AbstractHierarchicalPhrases {

	private final FrequentMatches frequentMatches;
	private final Corpus corpus;
	
	public FrequentMatchedHierarchicalPhrases(Pattern pattern, FrequentMatches frequentMatches, Corpus corpus) {
		super(pattern, frequentMatches.getMatchCount(pattern));
		
		this.frequentMatches = frequentMatches;
		this.corpus = corpus;
	}

	
	/* @see joshua.corpus.MatchedHierarchicalPhrases#getSentenceNumber(int) */
	public int getSentenceNumber(int phraseIndex) {
		
		//TODO Remove this implementation, and instead have an implementation in AbstractHierarchicalPhrases
		
		int position = frequentMatches.getStartPosition(pattern, phraseIndex, 0);
		return corpus.getSentenceIndex(position);
	}
	
	
	/* @see joshua.corpus.MatchedHierarchicalPhrases#getStartPosition(int, int) */
	public int getStartPosition(int phraseIndex, int positionNumber) {
		
		return frequentMatches.getStartPosition(pattern, phraseIndex, positionNumber);
		
	}
	
	/* @see joshua.corpus.MatchedHierarchicalPhrases#isEmpty() */
	public boolean isEmpty() {
		return ! frequentMatches.contains(pattern);
	}
	
	/* @see joshua.corpus.MatchedHierarchicalPhrases#copyWithFinalX() */
	public MatchedHierarchicalPhrases copyWithFinalX() {
		
		final Pattern patternX = new Pattern(pattern.vocab, pattern.words, PrefixTree.X);
		final FrequentMatchedHierarchicalPhrases parent = this;
		
		return new FrequentMatchedHierarchicalPhrases(patternX, frequentMatches, corpus) {
			public int getStartPosition(int phraseIndex, int positionNumber) {
				return parent.getStartPosition(phraseIndex, positionNumber);
			}
			
			public boolean isEmpty() {
				return parent.isEmpty();
			}
		};
		
	}

	/* @see joshua.corpus.MatchedHierarchicalPhrases#copyWithInitialX() */
	public MatchedHierarchicalPhrases copyWithInitialX() {
		
		int[] xwords = new int[pattern.words.length+1];
		xwords[0] = PrefixTree.X;
		for (int i=0; i<pattern.words.length; i++) {
			xwords[i+1] = pattern.words[i];
		}
		final Pattern xPattern = new Pattern(pattern.vocab, xwords);
		final FrequentMatchedHierarchicalPhrases parent = this;
		
		return new FrequentMatchedHierarchicalPhrases(xPattern, frequentMatches, corpus) {
			public int getStartPosition(int phraseIndex, int positionNumber) {
				return parent.getStartPosition(phraseIndex, positionNumber);
			}
			
			public boolean isEmpty() {
				return parent.isEmpty();
			}
		};
	}

}
