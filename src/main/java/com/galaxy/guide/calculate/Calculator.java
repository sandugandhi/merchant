package com.galaxy.guide.calculate;

import com.galaxy.guide.store.GalacticTranslationBook;

/**
 * Interface to compute the answer from the query using the 'Galactic Translation Book'
 */
public interface Calculator {

  GalacticTranslationBook BOOK = GalacticTranslationBook.getInstance();

  String calculate(Token input);
}
