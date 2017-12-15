# tdddemo
# Identify problem with refactoring class
•	 An add() method with a long argument list.
•	 The add() method accepts single-character variables. What is the purpose
of String a ?
•	 Method name add() doesn't tell you the intent of the method. Does it
add numbers?
•	 The add() method is doing many things, single-character variables are
participating in some calculation, nested if conditions.
•	 add() has a a twenty-line-long documentation. Is it a code documentation
or business strategy documentation? Does it describe the add() method?
•	 There is a private class-level variable cd . What is cd ? Compact disk? Seems
like no one is using it.
•	 There is a bill() method. bill() has nested if conditions similar to those
in the add() method.
•	 The class is adding something that we don't understand, generating bills, and
charging for incoming text messages.

# This class has the following issues:
•	 Not readable, therefore, not maintainable.
•	 Duplicate code and nested if conditions in the add() and bill() methods.
•	 The class is doing many things—GOD object. The add() method is also
doing many things.
•	 The add() method is very long.
•	 Unnecessary comments are present.
•	 The class is violating the open-close principle. A new enhancement will touch
almost all methods in this class.
•	 Finally, the class doesn't have JUnits.