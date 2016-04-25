# Activity 8 Questions

1. Elevens, Thirteens, and Tens all focus around the same basic idea: removing all cards from a deck via two simple rules, one of which is that you can pick a pair of cards that add up to the number specified in the game's name, and another custom rule (i.e. quartets of high cards in Tens, JQK in Elevens, single kings in Thirteens). They have different deck sizes and different rules, but approximately the same purpose: the player must remove all cards from the board.

2. The `size` variable for each Board is passed in the constructor and used to make an array of cards with that size. In the Board's getter, this board size is then accessed from the length of the cards array. 

3. The `abstract` methods in the Board class are `anotherPlayIsPossible()` and `isLegal()`. Both of these methods cover the differences between Elevens, Thirteens, and Tens, because they are checking whether the moves in these games are legal. Because they have different rules, making a one-size-fits-all method for all three games is impractical and would make them the same game.