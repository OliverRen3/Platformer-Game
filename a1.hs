-- CISC 360 a1, Fall 2024

-- Read the instructions in a1.pdf.

module A1 where

-- Rename this file to include your student ID: a1-studentid.hs
-- Also, add your student ID number after the "=":
student_id :: Integer
student_id =  

-- THIS FILE WILL NOT COMPILE UNTIL YOU ADD YOUR STUDENT ID ABOVE
check_that_you_added_your_student_ID_above = ()

{- Checklist

   I have read the "Read this first" section,
     including "Reminder", "Try to start early", "Late policy",
     and "Your lowest assignment mark is dropped":

   I have read the "Version control" section:

   I have read the "IMPORTANT: Your file must compile" section:

   I have read the "Document your code" section:

   I have read the "Strive for simplicity" section:

   I have read the "Be careful with library functions" section:

   I have read the "Test cases" section:

   I have added my student ID above: 
-}

{-
Q1:
   cube (m, n)  ==  True
   if and only if
                         3
     n is m cubed  (n = m )

     or
                         3
     m is n cubed  (m = n )

   Hint: Haskell has an exponentiation operator, **,
         but it uses floating-point arithmetic so I wouldn't trust it here.
         The multiplication operator * works on integers (as well as floats).
-}
cube :: (Integer, Integer) -> Bool
cube (m, n) = undefined

{-
  Testing cube:

  CISC 360 CONVENTION:
  Every variable beginning with "test_" should evaluate to True.
  So test_cube1 should be True because  cube 1 (-1)  should equal True,
  test_cube2 should be True because  (cube 5 2)  should equal False,
  and so on.
-}
test_cube1, test_cube2, test_cube3, test_cube4, test_cube5, test_cube6 :: Bool
test_cube1 = (cube (1, -1)) == False
test_cube2 = (cube (125, 5)) == True
test_cube3 = (cube (-3, -27)) == True
test_cube4 = (cube (-3, 27)) == False
test_cube5 = (cube (2, 4)) == False
test_cube6 = (cube (4096, 16)) == True
test_cube7 = (cube (16, 4095)) == False

-- Do all cube tests together
test_cube :: Bool
test_cube = test_cube1 && test_cube2
                       && test_cube3
                       && test_cube4
                       && test_cube5
                       && test_cube6
                       && test_cube7

{-
Q2:
  `spiral': given two integers `dir' and `span',
  returns 1 if `dir' is less than 0,
  and otherwise returns (span - dir) * spiral (span - dir) (1 - span).
-}

spiral :: Integer -> Integer -> Integer
spiral dir span = undefined

-- Testing spiral:
test_spiral1, test_spiral2, test_spiral3, test_spiral4, test_spiral :: Bool
test_spiral1 = ((spiral 0 32)    == -2016)
test_spiral2 = ((spiral (-32) 5) == 1)
test_spiral3 = ((spiral 13 3)    == -10)
test_spiral4 = ((spiral 7 6000)  == -71868056)

test_spiral  = test_spiral1 && test_spiral2 && test_spiral3 && test_spiral4


{-
Q3: 
  spiral_seq n == string containing results of  spiral k 180  for k in 0, ..., n
                  separated by semicolons

  For example,  spiral_seq 2  should return  "-64620;-64082;-63546"
    because spiral 0 180 should return -64620,
            spiral 1 180 should return -64082,
        and spiral 2 180 should return -63546.

  If n < 0, spiral_seq should return the empty string: ""
  
  Hints:
     1. The built-in function  show  converts an integer
        to its (decimal) representation as a string.

     2. You can use the built-in function  ++  to concatenate strings.
          For example, "10" ++ "," == "10,".

     3. You may find it useful to define a helper function for spiral_seq to call.
-}
spiral_seq :: Integer -> String
spiral_seq n = undefined


{-
Q4: Stepping

   Give your answers by filling in the blanks below,
   **including the substitution** in function application steps, as described.

Q4.1: Replace the underlines (_______).

     expression                   justification

     (\q -> 1 + (q * 3)) 2

  => _________________________    _________________________

  => _________________________    _________________________

  => _______                      by arithmetic

  For full marks, state the substitution in the function application step.
  For example:

  "...                          by function application
                                with 500 for q"
                                     ^^^^^^^^^
                          "500 for q" is the substitution

Q4.2: Replace the underlines (_______).
      Assume a function `incr' has been defined:
-}
incr :: Integer -> Integer
incr x = x + 1
{-
     expression                             justification

     (if True then incr else (\z -> 9)) 0

  => _____________________________________  ______________________________

  => _____________________________________  ______________________________

  => _____________________________________  ______________________________

  For full marks, state the substitution in all function application steps.

Q4.3: 
  Step the following expression.  (It can only be stepped once.)
  (You cannot directly check the answer in Haskell,
   because Haskell will not print functions.)

     expression                            justification

     (\x -> (\y -> (y, x))) incr

  => ____________________________________  ________________________________
-}
