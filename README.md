# Assignment 1 - Duck hunt
B-OOP 2022
<p> My version of the game:</p>
  <img src="https://github.com/RiuminIa/duckHuntGame/blob/master/ducks.png" alt="ducks" title="ducks" height="200px">
<p>This repository contains a duck hunting game, which is the solution to the task below.</p>
Your task is to create a simplified version of the card game "Duck hunt" in the form of a console JAVA aplication.

## Game introduction
Ducks are swimming peacefully in a pond. They have no idea that there are hunters nearby, and the hunters won't stop shooting until all the ducks are dead. Each of the hunters must protect some of the ducks and their goald is to shoot all the ducks of the other hunters.

## Goal of the game
Protect your own ducks and try to kill the ducks of the other players. The player who has the only surviving ducks wins (for simplification, each player has 5 lives at the start of the game and they will lose a life whenever one of their ducks dies).

## Cards
* 5 Ducks for each player
* 5 Empty water cards
* 6 Crosshair cards
* 34 Action cards

## Before the game starts
The game is played by 2-6 players. Each player has 5 ducks. The ducks and the empty water cards are shuffled together to create the deck of ducks. The top 6 cards of this deck are drawn and layed out side by side to create the pond (a game board with 6 spaces). The leftmost (or topmost, for simplification when printing the board) duck is in the first position. Above each space in the pond is a space for the crosshairs (a second game board with 6 spaces).
The action cards are shuffled together and each player gets 3 of them.
An example of how to print the game boards (verticaly) can be seen here:
Pond
1. - Not aimed at - Duck of player 1
2. - Aimed at - Duck of player 2
3. - Not aimed at - Duck of player 3
4. - Aimed at - Water
5. - Not aimed at - Water
6. - Not aimed at - Duck of player 1

The game board can be printed horizontaly as well (as in the original game), it might be more difficult however to align all the information in a readable way.

## During the game
The game begins with player 1. Each player must play one action card on their turn. The order of operations during a players turn is as follows:
* The player must play one card from their hand even if it should hurt them.
* The effect of the card takes place.
* A new card is drawn from the deck of action cards, so that the player ends their turn with 3 cards.

WARNING: A player must play a card even if it means killing their own duck. If the player has no legal moves (eg. the player has 3 Shoot cards, but no space is targeted) they must discard one of their cards and draw another one (they don't play a card during this turn).

When a duck is shot, remove it from the pond and remove one life from the player that owns it (5 ducks = 5 lives). When a player runs out of all ducks (lives) they no longer participate in the game.

## End of the game
The last player standing wins.

## Action cards
### Aim and Shoot
#### Aim - 10 cards
When played we target one space of the pond. We can only target a place that is not yet targeted. We do not target a specific duck but only the space of the pond it is sitting in. If the duck moves the targeted space remains in the same place and will target a new duck or water. A space that contains water may be targeted.

#### Shoot - 12 cards
When played we shoot at a targeted space. It does not matter which player targeted the space. Any duck that is currently sitting in a targeted space can be shot by any player. The shot duck is removed from the game. All the cards that are placed in the spaces to the right (down) of the duck move by one space to fill the gap. The last space in the pond is filled by the top card of the duck deck. The crosshair is removed from the space (it is no longer targeted). Shoot can be played on a targeted water space. The water is not removed in this case, only the crosshair is removed (the space is no longer targeted).

#### Wild Bill - 2 cards
Is a combination of the Aim and Shoot cards. Remove any duck from the pond. If the space it was sitting on was targeted, remove the crosshair. The ducks will move to fill the empty space in the pond, just like when the Shoot card is played.

### Duck movement
#### Duck march - 6 cards
All the ducks move one space forward. The duck in the first space is moved to the bottom of the duck deck, the empty space at the end is filled with the duck from the top of the duck deck.

#### Turboduck - 1 card
Move any duck to the first space in the pond. The ducks that were overtaken by it move one space backwards, to fill the gap.

#### Scatter - 2 cards
Randomly rearange the positions of all the cards in the pond. The targeted spaces do not change (perform a shuffle of the cards in the pond).

#### Duck dance - 1 card
Put the cards from the pond back into the duck deck, shuffle the deck and place 6 new cards into the pond.

