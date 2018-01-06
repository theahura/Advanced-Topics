% This program isn't exactly what I had in mind, and over the summer I'm
% going to try to make it be able to add to its database, but for now
% you can play a guessing game with the six items I implemented.
% The program asks you questions, and based on the answers you give,
% it'll take a guess on what you're thinking of. A couple of tips on
% running the game: before running the game you have to "Consult" it in
% the main interface after compiling it. Follow every command you give
% with a period. After the game guesses something and the program ends
% with "true", keep pressing semicolon until you reach a new command
% line. That resets the game and your answers.
% The game isn't exactly what I wanted, but I'll keep working on it!


%start - call this to start the game, guesses its final answer
start :- guess(Answer),
	write('Is this what you were thinking of? A '),
	write(Answer),
	write('?'),
	nl,       %New Line
	reset.

guess(rock) :- rock, !.           %Exclamation points are known as
guess(computer) :- computer, !.	  %cuts, and end a line of code only
guess(tree) :- tree, !.           %allowing prolog to return the
guess(frog) :- frog, !.           %first answer it gets.
guess(cricket) :- cricket, !.
guess(iPod) :- iPod, !.

%Characteristics of guesses

rock :- solid,  %Facts that can stand for multiple objects, these are defined later
	verify('featured in The Flintstones'),         %Simple facts that need to
	verify('the last name of a famous comedian').  %be verified individually
computer :- electronic,
	verify('used to surf the web'),
	verify('allow Trem to play solitaire').
tree :- alive,
	plant,
	verify('green'),
	verify('produce oxygen').
frog :- alive,
	verify('green'),
	verify('say RIBBIT').
cricket :- alive,
	insect,
	verify('small'),
	verify('make an annoying sound').
iPod :- electronic,
	verify('small'),
	verify('used to listen to music').

%Those other facts are defined here.

solid :- verify('hard'),
	verify('difficult to break').
electronic :- verify('consume electricity'),
	verify('need to be charged').
alive :- verify('breathe'),
	verify('reproduce').
plant :- verify('grow from seeds'),
	verify('produce pollen').
insect :- verify('have six legs'),
	verify('have compound eyes').

%Called in verify method below to ask about facts

askQuestion(Q) :-
	write('Does/Is your mystery object... '),
	write(Q),
	write(' ? '),
	%read(X) takes in input from the user
	read(Input),
	%the arrow (->) I used in the next line is like an if/else statement: in this
	%case, if Input == yes, assert(yes(Q)), else assert(no(Q)).
	(   (Input == yes) ->
	assert(yes(Q));
	%the fail command is like a break, so if one answer in a category isn't "yes",
	%it stops asking other questions in the same category
	assert(no(Q)), fail).

%I found this online, it is necessary to accept or reject a fact
:- dynamic yes/1, no/1.

%called every time to ask about a fact, it checks if the fact has already
%been assigned a yes/no value, if not it asks the user about it
verify(Fact) :-
	(yes(Fact) -> true;
	(no(Fact) -> fail;
	askQuestion(Fact))).

%called at the end of the game to reset yes/no values
reset :-  retract(yes(_)).
reset :-  retract(no(_)).
