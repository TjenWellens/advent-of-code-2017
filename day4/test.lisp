(load "~/development/_advent-of-code/2017/day4/unit-test.lisp")

(load "~/development/_advent-of-code/2017/day4/day4.lisp")

(deftest test-sort-letters-in-words ()
  (check
    (equal (list "ab" "cd") (sort-letters-in-words (list "ba" "cd")))))

(deftest test-split-string ()
  (check
    (equal (list "aa" "bb") (split-string "aa bb"))))

(deftest test-check-passphrase ()
  (check
    (check-passphrase "aa bb cc dd ee")
    (not (check-passphrase "aa bb cc dd aa"))
    (check-passphrase "aa bb cc dd aaa")))

(deftest test-check-passphrase-enhanced ()
  (check
    (check-passphrase-enhanced "abcde fghij")
    (not (check-passphrase-enhanced "abcde xyz ecdab"))
    (check-passphrase-enhanced "a ab abc abd abf abj")
    (check-passphrase-enhanced "iiii oiii ooii oooi oooo")
    (not (check-passphrase-enhanced "oiii ioii iioi iiio"))))

(deftest test-suite ()
  (combine-results
    (test-split-string)
    (test-check-passphrase)
    (test-sort-letters-in-words)
    (test-check-passphrase-enhanced)))

; (test-passphrase-suite)
