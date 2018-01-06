% Author: Amol Kapoor
% Date: 3/26/2013

 :- dynamic guess/2, no/1, yes/1, fact/2.

fact(pizza, food).
fact(pizza, cheesy).
fact(pizza, delicious).

fact(brocoli, food).
fact(brocoli, vegetable).
fact(brocoli, disgusting).
fact(brocoli, like_a_tree).

fact(neeraj, human).
fact(neeraj, short).
fact(neeraj, asks_for_extra_credit).

fact(greg, human).
fact(greg, tall).
fact(greg, has_blonde_hair).



start :-
                 reset,
                 forall(fact(X,_), helper(X)),
                 write('Didnt get it.'),
                 new_fact, start.

reset :- retractall(yes(_)), retractall(no(_)).

helper(Object) :-
                  forall(fact(Object,Z), guess(Object,Z)),
                  no(Object) -> true;
                  write('Is your mystery object...'),
                  write(Object),
                  write('? yes/no '),
                  read(Input),
                  (Input == yes) -> write('GOT IT!'), start;
                  write('Didnt get it.'), new_fact, start.
               
guess(Object, Describer) :-
               no(Object) -> true;
               yes(Describer) -> true;
               write('Does/Is your mystery object... '),
               write(Describer),
               write(' ? yes/no '),
               %read(X) takes in input from the user
               read(Input),
               (Input == yes) -> assert(yes(Describer)), forall(fact(X,_), remove_fact_without(X, Describer)), true;
               assert(no(Object)), forall(fact(X, Describer), assert(no(X))).

remove_fact_without(Object, Describer) :-
                    fact(Object, Describer) -> true;
                    assert(no(Object)).

new_fact :-
         write('What was your object? '),
         read(Object),
         write('Describe your object with five adjectives or verbs. '),
         write('Your object is/does: '),
         read(Adj1),read(Adj2),read(Adj3),read(Adj4),read(Adj5),
         assert(fact(Object, Adj1)),
         assert(fact(Object, Adj2)),
         assert(fact(Object, Adj3)),
         assert(fact(Object, Adj4)),
         assert(fact(Object, Adj5)),
         write('ADDED TO THE DATABASE!').
               